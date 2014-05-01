
package org.robovm.bindings.facebook.manager;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSError;
import org.robovm.apple.foundation.NSMutableDictionary;
import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.foundation.NSOperationQueue;
import org.robovm.apple.foundation.NSString;
import org.robovm.apple.foundation.NSURL;
import org.robovm.apple.uikit.UIApplication;
import org.robovm.bindings.facebook.FBAppCall;
import org.robovm.bindings.facebook.FBAppCallHandler;
import org.robovm.bindings.facebook.FBAppLinkData;
import org.robovm.bindings.facebook.FBRequest;
import org.robovm.bindings.facebook.FBRequestConnection;
import org.robovm.bindings.facebook.FBRequestHandler;
import org.robovm.bindings.facebook.dialogs.FBWebDialogHandler;
import org.robovm.bindings.facebook.dialogs.FBWebDialogResult;
import org.robovm.bindings.facebook.dialogs.FBWebDialogs;
import org.robovm.bindings.facebook.error.FBErrorCategory;
import org.robovm.bindings.facebook.error.FBErrorUtility;
import org.robovm.bindings.facebook.session.FBSession;
import org.robovm.bindings.facebook.session.FBSessionRequestPermissionResultHandler;
import org.robovm.bindings.facebook.session.FBSessionState;
import org.robovm.bindings.facebook.session.FBSessionStateHandler;

public class FacebookManager {
	static final String TAG = "[FacebookManager] ";

	private static FacebookManager instance = null;
	private FacebookConfiguration configuration = new FacebookConfiguration.Builder().build();

	private FacebookManager () {
	}

	public static FacebookManager getInstance () {
		if (instance == null) {
			instance = new FacebookManager();
		}

		return instance;
	}

	/** Set the configuration for the FacebookManager.
	 * 
	 * @param configuration */
	public void setConfiguration (FacebookConfiguration configuration) {
		this.configuration = configuration;
	}

	public FacebookConfiguration getConfiguration () {
		return configuration;
	}

	public void login (final FacebookLoginListener listener) {
		// TODO change to use method session.open(FBSessionLoginBehaviour) and if successful then request for additional read and
// then publish permissions.
		NSOperationQueue.getMainQueue().addOperation(new Runnable() {
			@Override
			public void run () {
				FBSession session = FBSession.getActiveSession();
				if (session == null || !session.isOpen() || !containsRequiredPermissions(configuration.getReadPermissions())
					|| !containsRequiredPermissions(configuration.getPublishPermissions())) {
					FBSession.openForRead(configuration.getReadPermissions(), true, new FBSessionStateHandler() {
						@Override
						public void invoke (final FBSession session, final FBSessionState status, final NSError error) {
							if (error != null) {
								NSOperationQueue.getCurrentQueue().addOperation(new Runnable() {
									@Override
									public void run () {
										if (FBErrorUtility.getErrorCategory(error) == FBErrorCategory.UserCancelled) {
											listener.onCancel();
										} else {
											listener.onError(error.description());
										}
									}
								});
							} else if (status == FBSessionState.ClosedLoginFailed) {
								FBSession.getActiveSession().close(true);
								NSOperationQueue.getCurrentQueue().addOperation(new Runnable() {
									@Override
									public void run () {
										listener.onCancel();
									}
								});
							} else if (status == FBSessionState.Open) {
								if (!containsRequiredPermissions(configuration.getReadPermissions())) {
									NSOperationQueue.getCurrentQueue().addOperation(new Runnable() {
										@Override
										public void run () {
											listener.onError("Facebook read permissions couldn't be retrieved!");
										}
									});
								} else if (!containsRequiredPermissions(configuration.getPublishPermissions())) {
									NSOperationQueue.getMainQueue().addOperation(new Runnable() {
										@Override
										public void run () {
											session.requestNewPublishPermissions(configuration.getPublishPermissions(),
												configuration.getSessionDefaultAudience(), new FBSessionRequestPermissionResultHandler() {
													@Override
													public void invoke (final FBSession session, final NSError error) {
														NSOperationQueue.getCurrentQueue().addOperation(new Runnable() {
															@Override
															public void run () {
																if (error != null) {
																	if (FBErrorUtility.getErrorCategory(error) == FBErrorCategory.UserCancelled) {
																		listener.onCancel();
																	} else {
																		listener.onError(error.description());
																	}
																} else if (session.getState() == FBSessionState.ClosedLoginFailed) {
																	FBSession.getActiveSession().close(true);
																	listener.onCancel();
																} else if (session.getState() == FBSessionState.OpenTokenExtended) {
																	if (!containsRequiredPermissions(configuration.getPublishPermissions())) {
																		listener.onError("Facebook publish permissions couldn't be retrieved!");
																	} else {
																		FBRequest.requestForMe().start(new FBRequestHandler() {
																			@Override
																			public void invoke (FBRequestConnection connection, NSObject result,
																				NSError error) {
																				if (error == null) {
																					listener.onSuccess(createGraphObject(result));
																				} else {
																					if (FBErrorUtility.getErrorCategory(error) == FBErrorCategory.UserCancelled) {
																						listener.onCancel();
																					} else {
																						listener.onError(error.description());
																					}
																				}
																			}
																		});
																	}
																}
															}
														});
													}
												});
										}
									});
								}
							}
						}
					});
				} else {
					NSOperationQueue.getCurrentQueue().addOperation(new Runnable() {
						@Override
						public void run () {
							FBRequest.requestForMe().start(new FBRequestHandler() {
								@Override
								public void invoke (FBRequestConnection connection, NSObject result, NSError error) {
									if (error == null) {
										listener.onSuccess(createGraphObject(result));
									} else {
										if (FBErrorUtility.getErrorCategory(error) == FBErrorCategory.UserCancelled) {
											listener.onCancel();
										} else {
											listener.onError(error.description());
										}
									}
								}
							});
						}
					});
				}
			}
		});
	}

	public void logout () {
		FBSession session = FBSession.getActiveSession();
		if (session != null && session.getState() != FBSessionState.Closed) {
			session.close(true);
		}
	}

	public boolean isLoggedIn () {
		FBSession session = FBSession.getActiveSession();
		return session != null && session.isOpen();
	}

	/** Makes the specified request(s) on the Facebook api. If multiple requests are specified, a batch request will be made (only
	 * works for requests without dialog ui).
	 * @param requests */
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
										NSOperationQueue.getCurrentQueue().addOperation(new Runnable() {
											@Override
											public void run () {
												if (error != null) {
													if (FBErrorUtility.getErrorCategory(error) == FBErrorCategory.UserCancelled) {
														request.getListener().onCancel();
													} else {
														request.getListener().onError(error.description());
													}
												} else {
													if (result == FBWebDialogResult.NotCompleted) {
														request.getListener().onCancel();
													} else {
														GraphObject result = parseURLParams(url.toString());
														String postId = result.getString("post_id");
														if (postId != null) {
															request.getListener().onSuccess(result);
														} else {
															request.getListener().onCancel();
														}
													}
												}
											}
										});
									}
								});
							} else {
								FBWebDialogs.presentRequestDialog(session, request.getParameters().get("message"), request
									.getParameters().get("title"), request.getParameters(), new FBWebDialogHandler() {
									@Override
									public void invoke (final FBWebDialogResult result, final NSURL url, final NSError error) {
										NSOperationQueue.getCurrentQueue().addOperation(new Runnable() {
											@Override
											public void run () {
												if (error != null) {
													if (FBErrorUtility.getErrorCategory(error) == FBErrorCategory.UserCancelled) {
														request.getListener().onCancel();
													} else {
														request.getListener().onError(error.description());
													}
												} else {
													if (result == FBWebDialogResult.NotCompleted) {
														request.getListener().onCancel();
													} else {
														GraphObject result = parseURLParams(url.toString());
														final String requestId = result.getString("request");
														if (requestId != null) {
															request.getListener().onSuccess(result);
														} else {
															request.getListener().onCancel();
														}
													}
												}
											}
										});
									}
								});
							}
						}
					} else {
						FBRequestConnection batch = new FBRequestConnection();

						for (final FacebookRequest requestOrder : requests) {
							FBRequest request = new FBRequest(session, requestOrder.getApi(), requestOrder.getParameters(), requestOrder
								.getHttpMethod());
							batch.addRequest(request, new FBRequestHandler() {
								@SuppressWarnings("unchecked")
								@Override
								public void invoke (FBRequestConnection connection, NSObject result, final NSError error) {
									if (requestOrder.getListener() != null) {
										if (error != null) {
											NSOperationQueue.getCurrentQueue().addOperation(new Runnable() {
												@Override
												public void run () {
													if (FBErrorUtility.getErrorCategory(error) == FBErrorCategory.UserCancelled) {
														requestOrder.getListener().onCancel();
													} else {
														requestOrder.getListener().onError(error.description());
													}
												}
											});
										} else {
											NSMutableDictionary<NSObject, NSObject> dict = ((NSMutableDictionary<NSObject, NSObject>)result);
											NSObject data;
											if (dict.containsKey(new NSString("data"))) {
												data = dict.get(new NSString("data"));
											} else {
												data = dict;
											}
											final GraphObject graph = createGraphObject(data);
											NSOperationQueue.getCurrentQueue().addOperation(new Runnable() {
												@Override
												public void run () {
													requestOrder.getListener().onSuccess(graph);
												}
											});
										}
									}
								}
							});
						}
						batch.start();
					}
				} else if (requests.length > 0) {
					NSOperationQueue.getCurrentQueue().addOperation(new Runnable() {
						@Override
						public void run () {
							requests[0].getListener().onError("Facebook session is not open!");
						}
					});
				}
			}
		});
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

	@SuppressWarnings("unchecked")
	private GraphObject createGraphObject (NSObject data) {
		GraphObject graph = new GraphObject();
		if (data instanceof NSArray) {
			NSArray<NSObject> arrayData = (NSArray<NSObject>)data;
			List<GraphObject> children = new ArrayList<GraphObject>();
			for (NSObject entryData : arrayData) {
				children.add(createGraphObject(entryData));
			}
			graph.addChildren(children);
		} else {
			Map<String, String> convertedParams = new HashMap<String, String>();
			NSDictionary<NSObject, NSObject> parameters = (NSDictionary<NSObject, NSObject>)data;
			for (Entry<NSObject, NSObject> entry : parameters.entrySet()) {
				String key = String.valueOf(entry.getKey());
				if (entry.getValue() instanceof NSArray || entry.getValue() instanceof NSDictionary
					|| entry.getValue() instanceof NSMutableDictionary) {
					graph.addGraphParameter(key, createGraphObject(entry.getValue()));
				} else if (entry.getValue() instanceof NSString && entry.getValue().toString().contains("{")) {
					String v = entry.getValue().toString();
					v = v.substring(1, v.length() - 1);
					String[] values = v.split(",");

					Map<String, String> p = new HashMap<String, String>();
					for (String value : values) {
						value = value.trim();
						String[] kv = value.split(":");
						kv[0] = kv[0].replace("\"", "");
						kv[1] = kv[1].replace("\"", "");
						p.put(kv[0], kv[1]);
					}
					graph.addGraphParameter(key, new GraphObject(p));
				} else {
					convertedParams.put(key, String.valueOf(entry.getValue()));
				}
			}
			graph.addParameters(convertedParams);
		}
		return graph;
	}

	private boolean containsRequiredPermissions (List<String> requiredPermissions) {
		FBSession session = FBSession.getActiveSession();
		List<String> permissions = session.getPermissionList();

		for (String perm : requiredPermissions) {
			if (!permissions.contains(perm)) {
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

				// TODO fetch request data and invoke a listener.
			}
		}
	}

	public void didBecomeActive (UIApplication application) {
		FBAppCall.handleDidBecomeActive();
		FBSession.getActiveSession().handleDidBecomeActive();
	}

	public boolean openURL (UIApplication application, NSURL url, String sourceApplication, NSObject annotation) {
		FBAppCall.handleOpenURL(url, sourceApplication, new FBAppCallHandler() {
			@Override
			public void invoke (FBAppCall call) {
				// Launch app from facebook request.
				handleAppLinkData(call.getAppLinkData());
			}
		});
		return FBSession.getActiveSession().handleOpenURL(url);
	}

	public void willTerminate (UIApplication application) {
		FBSession.getActiveSession().closeSession();
	}
}
