
package org.robovm.bindings.facebook.manager;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.robovm.apple.foundation.NSError;
import org.robovm.apple.foundation.NSMutableDictionary;
import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.foundation.NSOperationQueue;
import org.robovm.apple.foundation.NSPropertyList;
import org.robovm.apple.foundation.NSString;
import org.robovm.apple.foundation.NSURL;
import org.robovm.apple.uikit.UIApplication;
import org.robovm.apple.uikit.UIApplicationDelegate;
import org.robovm.bindings.facebook.FBAppCall;
import org.robovm.bindings.facebook.FBAppCallHandler;
import org.robovm.bindings.facebook.FBAppEvents;
import org.robovm.bindings.facebook.FBAppLinkData;
import org.robovm.bindings.facebook.FBRequest;
import org.robovm.bindings.facebook.FBRequestConnection;
import org.robovm.bindings.facebook.FBRequestHandler;
import org.robovm.bindings.facebook.dialogs.FBWebDialogHandler;
import org.robovm.bindings.facebook.dialogs.FBWebDialogResult;
import org.robovm.bindings.facebook.dialogs.FBWebDialogs;
import org.robovm.bindings.facebook.error.FBErrorCategory;
import org.robovm.bindings.facebook.error.FBErrorUtility;
import org.robovm.bindings.facebook.manager.request.CommonFacebookRequests;
import org.robovm.bindings.facebook.manager.request.CommonFacebookRequests.FacebookGrantedPermissionsRequestListener;
import org.robovm.bindings.facebook.manager.request.FacebookRequest;
import org.robovm.bindings.facebook.manager.request.FacebookRequestListener;
import org.robovm.bindings.facebook.manager.request.GraphObject;
import org.robovm.bindings.facebook.manager.request.GraphUser;
import org.robovm.bindings.facebook.session.FBSession;
import org.robovm.bindings.facebook.session.FBSessionDefaultAudience;
import org.robovm.bindings.facebook.session.FBSessionRequestPermissionResultHandler;
import org.robovm.bindings.facebook.session.FBSessionState;
import org.robovm.bindings.facebook.session.FBSessionStateHandler;

public final class FacebookManager implements FacebookActions {
    private static FacebookManager instance = null;

    private FacebookManager () {
    }

    public static FacebookManager getInstance () {
        if (instance == null) {
            instance = new FacebookManager();
        }
        return instance;
    }

    @Override
    public void login (final FacebookPermission[] permissions, final boolean allowLoginUI, final FacebookLoginListener listener) {
        NSOperationQueue.getMainQueue().addOperation(new Runnable() {
            @Override
            public void run () {
                final FBSession session = FBSession.getActiveSession();
                final FBSessionStateHandler handler = new FBSessionStateHandler() {
                    @Override
                    public void invoke (final FBSession session, final FBSessionState status, final NSError error) {
                        if (listener != null) {
                            if (error == null && status == FBSessionState.Open) {
                                logUser(listener);
                            } else if (status == FBSessionState.Closed || status == FBSessionState.ClosedLoginFailed) {
                                FBSession.getActiveSession().close(true);
                                listener.onCancel();
                            } else if (error != null) {
                                if (FBErrorUtility.shouldNotifyUser(error)) {
                                    listener.onError(new FacebookError(FBErrorUtility.getUserMessage(error), true));
                                } else if (FBErrorUtility.getErrorCategory(error) == FBErrorCategory.UserCancelled) {
                                    listener.onCancel();
                                } else {
                                    listener.onError(new FacebookError(error.getLocalizedDescription()));
                                }
                            } else {
                                listener.onCancel();
                            }
                        }
                    }
                };

                if (session != null && session.getState() == FBSessionState.CreatedTokenLoaded) {
                    FBSession.getActiveSession().open(handler);
                } else if (permissions != null
                    && (session == null || !session.isOpen() || !containsRequiredPermissions(permissions))) {
                    FBSession.openForRead(FacebookPermission.getNamesOfPermissions(permissions), allowLoginUI, handler);
                } else if (listener != null) {
                    logUser(listener);
                }
            }
        });
    }

    private void logUser (final FacebookLoginListener listener) {
        FBRequest.requestForMe().start(new FBRequestHandler() {
            @Override
            public void invoke (FBRequestConnection connection, NSObject result, final NSError error) {
                if (result != null && error == null) {
                    listener.onSuccess(new GraphUser(result));
                } else {
                    if (FBErrorUtility.getErrorCategory(error) == FBErrorCategory.UserCancelled) {
                        listener.onCancel();
                    } else if (FBErrorUtility.shouldNotifyUser(error)) {
                        listener.onError(new FacebookError(FBErrorUtility.getUserMessage(error), true));
                    } else {
                        listener.onError(new FacebookError(error.getLocalizedDescription()));
                    }
                }
            }
        });
    }

    @Override
    public void logout () {
        FBSession session = FBSession.getActiveSession();
        if (session != null && session.getState() != FBSessionState.Closed) {
            session.close(true);
        }
    }

    @Override
    public boolean isLoggedIn () {
        FBSession session = FBSession.getActiveSession();
        return session != null && session.isOpen();
    }

    @Override
    public void requestPublishPermissions (final FacebookPermission[] permissions, final FacebookRequestListener listener) {
        NSOperationQueue.getMainQueue().addOperation(new Runnable() {
            @Override
            public void run () {
                FBSession.getActiveSession().requestNewPublishPermissions(FacebookPermission.getNamesOfPermissions(permissions),
                    FBSessionDefaultAudience.Everyone, new FBSessionRequestPermissionResultHandler() {
                        @Override
                        public void invoke (final FBSession session, final NSError error) {
                            if (error != null) {
                                if (FBErrorUtility.getErrorCategory(error) == FBErrorCategory.UserCancelled) {
                                    listener.onCancel();
                                } else if (FBErrorUtility.shouldNotifyUser(error)) {
                                    listener.onError(new FacebookError(FBErrorUtility.getUserMessage(error), true));
                                } else {
                                    listener.onError(new FacebookError(error.getLocalizedDescription()));
                                }
                            } else if (session.getState() == FBSessionState.ClosedLoginFailed) {
                                FBSession.getActiveSession().close(true);
                                listener.onCancel();
                            } else if (session.getState() == FBSessionState.OpenTokenExtended
                                || session.getState() == FBSessionState.Open) {
                                if (!containsRequiredPermissions(permissions)) {
                                    listener.onError(new FacebookError("Facebook publish permissions couldn't be retrieved!"));
                                } else {
                                    listener.onSuccess(null);
                                }
                            } else {
                                listener.onError(new FacebookError(
                                    "Facebook publish permissions request failed for unknown reason! Session state: "
                                        + session.getState()));
                            }
                        }
                    });
            }
        });
    }

    @Override
    public void request (final FacebookRequest... requests) {
        NSOperationQueue.getMainQueue().addOperation(new Runnable() {
            @Override
            public void run () {
                FBSession session = FBSession.getActiveSession();

                if (session != null && session.isOpen() && requests.length > 0) {
                    if (requests[0].isUseDialog()) {
                        for (final FacebookRequest request : requests) {
                            if (request.getApi().contains("feed")) {
                                FBWebDialogs.presentFeedDialog(session, request.getParameters(), new FBWebDialogHandler() {
                                    @Override
                                    public void invoke (final FBWebDialogResult result, final NSURL url, final NSError error) {
                                        if (error != null) {
                                            if (FBErrorUtility.shouldNotifyUser(error)) {
                                                request.getListener().onError(
                                                    new FacebookError(FBErrorUtility.getUserMessage(error), true));
                                            } else if (FBErrorUtility.getErrorCategory(error) == FBErrorCategory.UserCancelled) {
                                                request.getListener().onCancel();
                                            } else {
                                                request.getListener().onError(new FacebookError(error.getLocalizedDescription()));
                                            }
                                        } else {
                                            if (result == FBWebDialogResult.NotCompleted) {
                                                request.getListener().onCancel();
                                            } else {
                                                GraphObject r = parseURLParams(url.toString());
                                                String postId = r.getString("post_id");
                                                if (postId != null) {
                                                    request.getListener().onSuccess(r);
                                                } else {
                                                    request.getListener().onCancel();
                                                }
                                            }
                                        }
                                    }
                                });
                            } else {
                                FBWebDialogs.presentRequestDialog(session, request.getParameters().get("message"), request
                                    .getParameters().get("title"), request.getParameters(), new FBWebDialogHandler() {
                                    @Override
                                    public void invoke (final FBWebDialogResult result, final NSURL url, final NSError error) {
                                        if (error != null) {
                                            if (FBErrorUtility.getErrorCategory(error) == FBErrorCategory.UserCancelled) {
                                                request.getListener().onCancel();
                                            } else if (FBErrorUtility.shouldNotifyUser(error)) {
                                                request.getListener().onError(
                                                    new FacebookError(FBErrorUtility.getUserMessage(error), true));
                                            } else {
                                                request.getListener().onError(new FacebookError(error.getLocalizedDescription()));
                                            }
                                        } else {
                                            if (result == FBWebDialogResult.NotCompleted) {
                                                request.getListener().onCancel();
                                            } else {
                                                GraphObject r = parseURLParams(url.toString());
                                                final String requestId = r.getString("request");
                                                if (requestId != null) {
                                                    request.getListener().onSuccess(r);
                                                } else {
                                                    request.getListener().onCancel();
                                                }
                                            }
                                        }
                                    }
                                });
                            }
                        }
                    } else {
                        FBRequestConnection batch = new FBRequestConnection();

                        for (final FacebookRequest requestOrder : requests) {
                            final FBRequest request = new FBRequest(session, requestOrder.getApi(), requestOrder.getParameters(),
                                requestOrder.getHttpMethod());
                            batch.addRequest(request, new FBRequestHandler() {
                                private int retryCount = 0;

                                @SuppressWarnings("unchecked")
                                @Override
                                public void invoke (FBRequestConnection connection, NSObject result, final NSError error) {
                                    if (requestOrder.getListener() != null) {
                                        if (error != null || result == null) {
                                            final FBRequestHandler handler = this;
                                            FBErrorCategory category = FBErrorUtility.getErrorCategory(error);

                                            retryCount++;
                                            if (retryCount <= 2
                                                && (category == FBErrorCategory.Retry || category == FBErrorCategory.Throttling)) {
                                                request.start(handler);
                                            } else if (category == FBErrorCategory.UserCancelled) {
                                                requestOrder.getListener().onCancel();
                                            } else if (FBErrorUtility.shouldNotifyUser(error)) {
                                                requestOrder.getListener().onError(
                                                    new FacebookError(FBErrorUtility.getUserMessage(error), true));
                                            } else {
                                                requestOrder.getListener().onError(
                                                    new FacebookError(error.getLocalizedDescription()));
                                            }
                                        } else {
                                            NSMutableDictionary<NSObject, NSObject> dict = ((NSMutableDictionary<NSObject, NSObject>)result);
                                            NSObject data;
                                            if (dict.containsKey(new NSString("data"))) {
                                                data = dict.get(new NSString("data"));
                                            } else {
                                                data = dict;
                                            }
                                            final GraphObject graph = new GraphObject(data);
                                            requestOrder.getListener().onSuccess(graph);
                                        }
                                    }
                                }
                            });
                        }
                        batch.start();
                    }
                } else if (requests.length > 0) {
                    requests[0].getListener().onError(new FacebookError("Facebook session is not open!"));
                }
            }
        });
    }

    /** Use this method to get a list of all permissions that the user has granted access.
     * <p>
     * NOTE: You need to check if the user granted permissions for a specific action, before you make a request to that action.
     * @param listener */
    public void requestGrantedPermissions (FacebookGrantedPermissionsRequestListener listener) {
        request(CommonFacebookRequests.requestGrantedPermissions(listener));
    }

    private GraphObject parseURLParams (String url) {
        GraphObject graph = new GraphObject();

        int qx = url.indexOf("?");
        if (qx == -1) return graph;

        Map<String, GraphObject> graphParameters = new HashMap<String, GraphObject>();

        String[] pairs = url.substring(qx + 1).split("&");
        try {
            for (String pair : pairs) {
                String[] kv = pair.split("=");
                String val = URLDecoder.decode(kv[1], "UTF-8");
                int arrayIx = kv[0].indexOf("%5B");
                if (arrayIx == -1) arrayIx = kv[0].indexOf('[');
                if (arrayIx >= 0) {
                    kv[0] = kv[0].substring(0, arrayIx);

                    GraphObject p;
                    if (graphParameters.containsKey(kv[0])) {
                        p = graphParameters.get(kv[0]);
                    } else {
                        p = new GraphObject();
                        graphParameters.put(kv[0], p);
                    }
                    p.addParameter(kv[0], val);
                } else {
                    graph.addParameter(kv[0], val);
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        graph.addGraphParameters(graphParameters);
        return graph;
    }

    private boolean containsRequiredPermissions (FacebookPermission[] requiredPermissions) {
        FBSession session = FBSession.getActiveSession();
        List<String> permissions = session.getPermissionList();

        for (FacebookPermission perm : requiredPermissions) {
            if (!permissions.contains(perm.getName())) {
                return false;
            }
        }

        return true;
    }

    private void handleAppLinkData (FBAppLinkData appLinkData) {
        NSString targetURLString = appLinkData.getOriginalQueryParameters().get("target_url");
        if (targetURLString != null) {
            GraphObject graph = parseURLParams(targetURLString.toString());
            String ref = graph.getString("ref");
            if (ref.equals("notif")) {
                String requestIDParam = graph.getString("request_ids");
                String[] requestIDs = requestIDParam.split(",");

                // TODO
// game.facebook.addUnhandledRequest(new FacebookRequest(requestIDs[0], null, HttpMethods.GET, false, null));
            }
        }
    }

    /** Add this to {@link UIApplicationDelegate#didBecomeActive(UIApplication)} in your application delegate.
     * <p>
     * NOTE: It is required that you invoke this method in your application delegate, otherwise Facebook will not work as
     * expected!
     * @param application */
    public void handleDidBecomeActive (UIApplication application) {
        FBAppEvents.activateApp();
        FBAppCall.handleDidBecomeActive();
        FBSession.getActiveSession().handleDidBecomeActive();
    }

    /** Add this to {@link UIApplicationDelegate#openURL(UIApplication, NSURL, String, NSPropertyList)} in your application
     * delegate.
     * <p>
     * NOTE: It is required that you invoke this method in your application delegate, otherwise Facebook will not work as
     * expected!
     * @param application
     * @param url
     * @param sourceApplication
     * @param annotation
     * @return */
    public boolean handleOpenURL (UIApplication application, NSURL url, String sourceApplication, NSPropertyList annotation) {
        FBAppCall.handleOpenURL(url, sourceApplication, new FBAppCallHandler() {
            @Override
            public void invoke (FBAppCall call) {
                // Launch app from Facebook request.
                handleAppLinkData(call.getAppLinkData());
            }
        });
        return FBSession.getActiveSession().handleOpenURL(url);
    }

    /** Add this to {@link UIApplicationDelegate#willTerminate(UIApplication)} in your application delegate.
     * <p>
     * NOTE: It is required that you invoke this method in your application delegate, otherwise Facebook will not work as
     * expected!
     * @param application */
    public void handleWillTerminate (UIApplication application) {
        FBSession.getActiveSession().closeSession();
    }
}
