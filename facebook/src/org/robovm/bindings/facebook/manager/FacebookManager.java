
package org.robovm.bindings.facebook.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.robovm.bindings.facebook.FBRequest;
import org.robovm.bindings.facebook.FBRequestConnection;
import org.robovm.bindings.facebook.FBRequestHandler;
import org.robovm.bindings.facebook.FBSession;
import org.robovm.bindings.facebook.FBSessionRequestPermissionResultHandler;
import org.robovm.bindings.facebook.FBSessionState;
import org.robovm.bindings.facebook.FBShareDialogParams;
import org.robovm.bindings.facebook.FBWebDialogHandler;
import org.robovm.bindings.facebook.FBWebDialogResult;
import org.robovm.bindings.facebook.FBWebDialogs;
import org.robovm.bindings.facebook.HttpMethod;
import org.robovm.cocoatouch.foundation.NSArray;
import org.robovm.cocoatouch.foundation.NSDictionary;
import org.robovm.cocoatouch.foundation.NSError;
import org.robovm.cocoatouch.foundation.NSMutableDictionary;
import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSString;
import org.robovm.cocoatouch.foundation.NSURL;

/** This singleton class provides the most common Facebook use cases. */
@SuppressWarnings({"unchecked", "rawtypes"})
public class FacebookManager {
	// TODO FBError instead of NSError?
	// TODO Make log messages and error messages more unique (i.e. store commons strings in a separate Error class or something
// like this)
	// TODO Make LoginBehavior.FallbackToWebView and LoginBehavior.ForcingWebView work. ATM nothing happens when the WebView login
// is used, I think.
	// TODO Implement the missing Facebook classes and methods.
	// TODO make proper JavaDocs for all classes including the binding classes.

	static final String TAG = "[FacebookManager] ";
	private static FacebookManager instance = null;

	private FacebookConfiguration configuration = new FacebookConfiguration.Builder().build();
	private FBSessionStatusCallback sessionStatusCallback;

	private FacebookManager () {
		sessionStatusCallback = new FBSessionStatusCallback(this);
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

	/** Login to Facebook.
	 * 
	 * @param loginListener */
	public void login (LoginListener loginListener) {
		if (isLogged()) {
			System.out.println(TAG + "User is already logged in.");

			if (loginListener != null) {
				loginListener.onLogin();
			}
		} else {
			System.out.println(TAG + "Logging in...");

			FBSession session = FBSession.getActiveSession();
			if (session == null || session.getState() == FBSessionState.Closed) {
				session = new FBSession.Builder().setApplicationId(configuration.getAppId()).build();
				FBSession.setActiveSession(session);
			}

			System.out.println(TAG + "Registering session status callback...");
			sessionStatusCallback = new FBSessionStatusCallback(this);
			sessionStatusCallback.loginListener = loginListener;
			session.setStateChangeHandler(sessionStatusCallback);

			// If session is not opened, open it.
			if (!session.isOpen()) {
				openSession(true);
			} else {
				System.out.println(TAG + "Session already opened!");
				if (loginListener != null) {
					loginListener.onLogin();
				}
			}
		}
	}

	/** Logout from Facebook.
	 * @param logoutListener */
	public void logout (LogoutListener logoutListener) {
		if (isLogged()) {
			FBSession session = FBSession.getActiveSession();
			if (session != null && session.getState() != FBSessionState.Closed) {
				sessionStatusCallback.logoutListener = logoutListener;
				session.close(true);
				session.setStateChangeHandler(null);

				if (logoutListener != null) {
					logoutListener.onLogout();
				}
			}
		} else {
			System.out.println("You were already logged out before calling 'logout()' method");

			if (logoutListener != null) {
				logoutListener.onLogout();
			}
		}
	}

	/** Indicates if you are logged in or not.
	 * 
	 * @return <code>true</code> if you is logged in, otherwise <code>false</code> */
	public boolean isLogged () {
		FBSession session = FBSession.getActiveSession();
		if (session == null) {
			if (session == null) {
				session = new FBSession.Builder().setApplicationId(configuration.getAppId()).build();
			}
			FBSession.setActiveSession(session);
		}
		if (session.isOpen()) {
			return true;
		}

		// Check if we can reload the session when it will be nessecary.
		if (session.getState().equals(FBSessionState.CreatedTokenLoaded)) {
			List<String> permissions = session.getPermissions();
			if (permissions.containsAll(configuration.getReadPermissions())) {
				reopenSession();
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/** Get user profile from Facebook.
	 * 
	 * @param profileRequestListener */
	public void getProfile (final ProfileRequestListener profileRequestListener) {
		if (isLogged()) {
			System.out.println(TAG + "Requesting user profile...");
			FBRequest request = new FBRequest(FBSession.getActiveSession(), "me", null, HttpMethod.GET);
			request.start(new FBRequestHandler() {
				@Override
				public void invoke (FBRequestConnection connection, NSObject result, NSError error) {
					System.out.println(TAG + "Got profile request answer...");
					NSDictionary<NSObject, NSObject> graphUser = (NSDictionary<NSObject, NSObject>)((NSMutableDictionary<NSObject, NSObject>)result)
						.get(new NSString("data"));

					if (error != null) {
						System.out.println(TAG + "Failed to receive user profile! Error: " + error.description());

						if (profileRequestListener != null) {
							profileRequestListener.onException(error);
						}
					} else {
						System.out.println(TAG + "Profile received!");

						if (profileRequestListener != null) {
							FBProfile profile = FBProfile.create(graphUser);
							profileRequestListener.onComplete(profile);
						}
					}
				}
			});
			if (profileRequestListener != null) {
				profileRequestListener.onRequest();
			}
		} else {
			String reason = TAG + "Error: User is not logged in!";
			System.out.println(reason);

			if (profileRequestListener != null) {
				profileRequestListener.onFail(reason);
			}
		}
	}

	/** Get users friends from Facebook.
	 * 
	 * @param friendsRequestListener */
	public void getFriends (final FriendsRequestListener friendsRequestListener) {
		if (isLogged()) {
			System.out.println(TAG + "Requesting friends...");
			FBSession session = FBSession.getActiveSession();
			FBRequest request = new FBRequest(session, "me/friends", null, HttpMethod.GET);
			request.start(new FBRequestHandler() {
				@Override
				public void invoke (FBRequestConnection connection, NSObject result, NSError error) {
					System.out.println(TAG + "Got friends request answer...");
					List<NSDictionary<NSObject, NSObject>> graphUsers = new ArrayList<NSDictionary<NSObject, NSObject>>();
					NSArray<NSObject> friendsData = (NSArray<NSObject>)((NSMutableDictionary<NSObject, NSObject>)result)
						.get(new NSString("data"));

					for (int i = 0; i < friendsData.size(); ++i) {
						NSDictionary<NSObject, NSObject> friend = (NSDictionary<NSObject, NSObject>)friendsData.get(i);
						graphUsers.add(friend);
					}

					if (error != null) {
						System.out.println(TAG + "Failed to receive friends. Error: " + error.description());

						if (friendsRequestListener != null) {
							friendsRequestListener.onException(error);
						}
					} else {
						System.out.println(TAG + "Friends received!");
						if (friendsRequestListener != null) {
							List<FBProfile> friends = new ArrayList<FBProfile>(graphUsers.size());
							for (NSDictionary graphUser : graphUsers) {
								friends.add(FBProfile.create(graphUser));
							}
							friendsRequestListener.onComplete(friends);
						}
					}
				}
			});

			if (friendsRequestListener != null) {
				friendsRequestListener.onRequest();
			}
		} else {
			String reason = TAG + "Error: You are not logged in!";
			System.out.println(reason);
			if (friendsRequestListener != null) {
				friendsRequestListener.onFail(reason);
			}
		}
	}

	/** Get scores of this application from Facebook.
	 * 
	 * @param scoresRequestListener */
	public void getScores (final ScoresRequestListener scoresRequestListener) {
		if (isLogged()) {
			System.out.println(TAG + "Requesting scores...");
			FBSession session = FBSession.getActiveSession();
			FBRequest request = new FBRequest(session, configuration.getAppId() + "/scores", null, HttpMethod.GET);

			request.start(new FBRequestHandler() {
				@Override
				public void invoke (FBRequestConnection connection, NSObject result, NSError error) {
					System.out.println(TAG + "Got scores request answer...");

					List<NSDictionary> graphUsers = new ArrayList<NSDictionary>();
					NSArray<NSObject> friendsData = (NSArray<NSObject>)((NSMutableDictionary)result).get(new NSString("data"));

					for (int i = 0; i < friendsData.size(); ++i) {
						NSDictionary friend = (NSDictionary)friendsData.get(i);
						graphUsers.add(friend);
					}

					if (error != null) {
						System.out.println(TAG + "Failed to get scores! " + error.description());

						if (scoresRequestListener != null) {
							scoresRequestListener.onException(error);
						}
					} else {
						System.out.println(TAG + "Scores received!");

						if (scoresRequestListener != null) {
							List<FBScore> scores = new ArrayList<FBScore>(graphUsers.size());
							for (NSDictionary graphUser : graphUsers) {
								scores.add(new FBScore(FBProfile.create((NSDictionary)graphUser.get(new NSString("user"))), Integer
									.valueOf(graphUser.get(new NSString("score")).toString())));
							}
							scoresRequestListener.onComplete(scores);
						}
					}

				}
			});

			if (scoresRequestListener != null) {
				scoresRequestListener.onRequest();
			}
		} else {
			System.out.println("Error: You are not logged in!");
			if (scoresRequestListener != null) {
				scoresRequestListener.onFail("Error: You are not logged in!");
			}
		}
	}

	/** Publish {@link FBFeed} on the wall.
	 * 
	 * @param feed The feed to publish. Use {@link FBFeed.Builder} to create a new <code>Feed</code>.
	 * @param publishListener The listener for publishing action. */
	public void publish (final FBFeed feed, final PublishListener publishListener) {
		if (isLogged()) {
			System.out.println(TAG + "Publishing...");
			if (configuration.getPublishPermissions().contains(FBPermission.PUBLISH_ACTION.getValue())) {
				if (publishListener != null) {
					publishListener.onRequest();
				}

				// Check if session to facebook has 'publish_action' permission. If not, we will ask user for this permission.

				if (!FBSession.getActiveSession().getPermissions().contains(FBPermission.PUBLISH_ACTION.getValue())) {
					System.out.println(TAG + "Need to request publish permissions!");
					sessionStatusCallback.reopenSessionListener = new ReopenSessionListener() {
						@Override
						public void onSuccess () {
							publishImpl(feed, publishListener);
						}

						@Override
						public void onNotAcceptingPermissions () {
							String reason = "Publish permissions weren't accepted by user";

							publishListener.onFail(reason);
						}
					};

					// Extend publish permissions automatically.
					extendPublishPermissions();
				} else {
					publishImpl(feed, publishListener);
				}
			} else {
				String reason = "Publish permission 'publish_action' wasn't set by the FacebookManagerConfiguration!";
				System.out.println(TAG + reason);

				if (publishListener != null) {
					publishListener.onFail(reason);
				}
			}
		} else {
			if (publishListener != null) {
				String reason = "You are not logged in";

				publishListener.onFail(reason);
			}
		}
	}

	/** Publish {@link FBFeed} on the wall with the feed dialog.
	 * 
	 * @param feed
	 * @param publishListener */
	public void publishWithDialog (final FBFeed feed, final PublishDialogListener publishListener) {
		if (isLogged()) {
			System.out.println(TAG + "Publishing with dialog...");
			if (configuration.getPublishPermissions().contains(FBPermission.PUBLISH_ACTION.getValue())) {
				if (publishListener != null) {
					publishListener.onRequest();
				}

				// Check if session to Facebook has 'publish_action' permission. If not, we will ask user for this permission.
				if (!FBSession.getActiveSession().getPermissions().contains(FBPermission.PUBLISH_ACTION.getValue())) {
					System.out.println(TAG + "Need to request publish permissions!");

					sessionStatusCallback.reopenSessionListener = new ReopenSessionListener() {
						@Override
						public void onSuccess () {
							publishDialogImpl(feed, publishListener);
						}

						@Override
						public void onNotAcceptingPermissions () {
							publishListener.onFail("Publish permissions weren't accepted by the user!");
						}
					};

					// Extend publish permissions automatically.
					extendPublishPermissions();
				} else {
					publishDialogImpl(feed, publishListener);
				}
			} else {
				String reason = "Publish permission: publish_action wasn't set by FacebookManagerConfiguration";
				System.out.println(TAG + reason);
				if (publishListener != null) {
					publishListener.onFail(reason);
				}
			}
		} else {
			if (publishListener != null) {
				String reason = "You are not logged in";
				publishListener.onFail(reason);
			}
		}
	}

	/** Publish open graph story
	 * 
	 * @param openGraph
	 * @param onPublishListener */
	// public void publish(final FBStory story, final OnPublishListener onPublishListener) { TODO
	// if (isLogin()) {
	//
	// // if we defined the publish permission
	// if (configuration.getPublishPermissions().contains(Permissions.PUBLISH_ACTION.getValue())) {
	// if (onPublishListener != null) {
	// onPublishListener.onThinking();
	// }
	//
	// /*
	// * Check if session to facebook has 'publish_action' permission. If not, we will ask user for this permission.
	// */
	// if (!getOpenSessionPermissions().contains(Permissions.PUBLISH_ACTION.getValue())) {
	// sessionStatusCallback.mOnReopenSessionListener = new OnReopenSessionListener() {
	// @Override
	// public void onSuccess() {
	// publishImpl(story, onPublishListener);
	// }
	//
	// @Override
	// public void onNotAcceptingPermissions() {
	// // this fail can happen when user doesn't accept the publish permissions
	// String reason = Errors.getError(ErrorMsg.CANCEL_PERMISSIONS_PUBLISH,
	// String.valueOf(configuration.getPublishPermissions()));
	//
	// // log
	// logError(reason, null);
	//
	// onPublishListener.onFail(reason);
	// }
	// };
	//
	// // extend publish permissions automatically
	// extendPublishPermissions();
	// } else {
	// publishImpl(story, onPublishListener);
	// }
	// } else {
	// // callback with 'fail' due to insufficient permissions
	// if (onPublishListener != null) {
	// String reason = Errors.getError(ErrorMsg.PERMISSIONS_PUBLISH, "publish_action");
	//
	// // log
	// logError(reason, null);
	//
	// onPublishListener.onFail(reason);
	// }
	// }
	// } else {
	// // callback with 'fail' due to not being loged
	// if (onPublishListener != null) {
	// String reason = Errors.getError(ErrorMsg.LOGIN);
	//
	// // log
	// logError(reason, null);
	//
	// onPublishListener.onFail(reason);
	// }
	// }
	// }

	/** Open invite dialog and can add multiple friends
	 * 
	 * @param message The message inside the dialog. It could be <code>null</code>
	 * @param onInviteListener The listener. It could be <code>null</code> */
	public void invite (String message, final InviteListener onInviteListener) {
		if (isLogged()) {
			System.out.println(TAG + "Inviting friends...");
			openInviteDialog(message, null, onInviteListener);
		} else {
			String reason = "User not logged in";

			onInviteListener.onFail(reason);
		}
	}

	/** Open invite dialog and invite only specific friend
	 * 
	 * @param to The id of the friend profile
	 * @param message The message inside the dialog. It could be <code>null</code>
	 * @param onInviteListener The listener. It could be <code>null</code> */
	public void invite (String to, String message, final InviteListener onInviteListener) {
		if (isLogged()) {
			System.out.println(TAG + "Inviting friends...");
			Map<String, String> params = new HashMap<String, String>();
			params.put("to", to);
			openInviteDialog(message, params, onInviteListener);
		} else {
			String reason = "User not logged in";

			onInviteListener.onFail(reason);
		}
	}

	/** Open invite dialog and invite several specific friends
	 * 
	 * @param suggestedFriends The ids of friends' profiles
	 * @param message The message inside the dialog. It could be <code>null</code>
	 * @param onInviteListener The error listener. It could be <code>null</code> */
	public void invite (String[] suggestedFriends, String message, final InviteListener onInviteListener) {
		if (isLogged()) {
			System.out.println(TAG + "Inviting friends...");

			StringBuilder sb = new StringBuilder();
			boolean firstTime = true;
			for (String token : suggestedFriends) {
				if (firstTime) {
					firstTime = false;
				} else {
					sb.append(",");
				}
				sb.append(token);
			}

			Map<String, String> params = new HashMap<String, String>();
			params.put("suggestions", sb.toString());
			openInviteDialog(message, params, onInviteListener);
		} else {
			String reason = "User not logged in";

			onInviteListener.onFail(reason);
		}
	}

	/** Make a request to the Facebook API.
	 * 
	 * @param request
	 * @param method
	 * @param onRequestListener */
	public void request (String request, String method, RequestListener onRequestListener) {
		request(request, method, null, onRequestListener);
	}

	/** Make a request to the Facebook API with parameters.
	 * 
	 * @param request
	 * @param method
	 * @param params
	 * @param requestListener */
	public void request (String request, String method, Map<String, String> params, final RequestListener requestListener) {
		if (isLogged()) {
			System.out.println(TAG + "Starting request '" + request + "' (" + method + ")");
			FBSession session = FBSession.getActiveSession();
			FBRequest requestObj = new FBRequest(session, request, params, method);

			requestObj.start(new FBRequestHandler() {
				@Override
				public void invoke (FBRequestConnection connection, NSObject result, NSError error) {
					System.out.println(TAG + "Request finished!");
					NSDictionary graphResult = (NSDictionary)result;
					if (graphResult != null) {
						if (error != null) {
							System.out.println(TAG + "Error: " + error.description());

							if (requestListener != null) {
								requestListener.onException(error);
							}
						} else {
							if (requestListener != null) {
								requestListener.onComplete(graphResult);
							}
						}
					} else {
						System.out.println("The GraphObject in response of publish action has null value. Response="
							+ result.toString());

						if (requestListener != null) {
							requestListener.onComplete(null);
						}
					}
				}
			});

			if (requestListener != null) {
				requestListener.onRequest();
			}
		} else {
			String reason = "User not logged in";
			System.out.println(reason);
		}
	}

	private static void publishImpl (FBFeed feed, final PublishListener onPublishListener) {
		FBSession session = FBSession.getActiveSession();
		FBRequest request = new FBRequest(session, "me/feed", feed.getData(), HttpMethod.POST);

		request.start(new FBRequestHandler() {
			@Override
			public void invoke (FBRequestConnection connection, NSObject result, NSError error) {
				NSDictionary graphObject = (NSDictionary)result;
				if (graphObject != null) {
					JSONObject graphResponse = new JSONObject(graphObject);
					String postId = null;
					try {
						postId = graphResponse.getString("id");
					} catch (JSONException e) {
						System.out.println("JSON error" + e);
					}

					if (error != null) {
						System.out.println("Failed to publish" + error.description());

						if (onPublishListener != null) {
							onPublishListener.onException(error);
						}
					} else {
						if (onPublishListener != null) {
							onPublishListener.onComplete(postId);
						}
					}
				} else {
					System.out.println("The GraphObject in Response of publish action has null value. Response=" + result.toString());

					if (onPublishListener != null) {
						onPublishListener.onComplete("0");
					}
				}
			}
		});
	}

	// private static void publishImpl(FBStory story, final OnPublishListener onPublishListener) { TODO
	// Session session = getOpenSession();
	// String appNamespace = configuration.getNamespace();
	//
	// Request request = new Request(session, story.getGraphPath(appNamespace), story.getActionBundle(), HttpMethod.POST, new
// Request.Callback() {
	// @Override
	// public void onCompleted(Response response) {
	// GraphObject graphObject = response.getGraphObject();
	// if (graphObject != null) {
	// JSONObject graphResponse = graphObject.getInnerJSONObject();
	// String postId = null;
	// try {
	// postId = graphResponse.getString("id");
	// } catch (JSONException e) {
	// // log
	// logError("JSON error", e);
	// }
	//
	// FacebookRequestError error = response.getError();
	// if (error != null) {
	// // log
	// logError("Failed to publish", error.getException());
	//
	// // callback with 'exception'
	// if (onPublishListener != null) {
	// onPublishListener.onException(error.getException());
	// }
	// } else {
	// // callback with 'complete'
	// if (onPublishListener != null) {
	// onPublishListener.onComplete(postId);
	// }
	// }
	// } else {
	// // log
	// logError("The GraphObject in Response of publish action has null value. Response=" + response.toString(), null);
	//
	// if (onPublishListener != null) {
	// onPublishListener.onComplete("0");
	// }
	// }
	// }
	// });
	//
	// RequestAsyncTask task = new RequestAsyncTask(request);
	// task.execute();
	// }

	private void publishDialogImpl (FBFeed feed, final PublishDialogListener publishListener) {
		FBShareDialogParams params = new FBShareDialogParams();
		params.setCaption(feed.getCaption());
		params.setDescription(feed.getDescription());
		params.setLink(new NSURL(feed.getLink()));
		params.setName(feed.getName());
		params.setPicture(new NSURL(feed.getPicture()));

		System.out.println(TAG + "Wants to present share dialog...");
		// if (FBDialogs.canPresentShareDialog(params)) { // TODO Facebook app crashes after some time on iOS 6
		// System.out.println(TAG + "Presenting share dialog...");
		// FBDialogs.presentShareDialog(params, null, new FBDialogAppCallCompletionHandler() {
		// @Override
		// public void invoke(FBAppCall call, NSDictionary results, NSError error) {
		// System.out.println(TAG + "Share dialog completed...");
		// if (results != null && error == null) {
		// int didComplete = 0;
		// NSObject didCompleteObj = results.get(new NSString("didComplete"));
		// if (didCompleteObj != null)
		// didComplete = Integer.valueOf(didCompleteObj.toString());
		// if (didComplete == 1) {
		// NSObject completionGestureObj = results.get(new NSString("completionGesture"));
		// if (completionGestureObj != null && completionGestureObj.toString().equals("post")) {
		// NSObject postIdObj = results.get(new NSString("postId"));
		// String postId = "";
		// if (postIdObj != null)
		// postId = postIdObj.toString();
		// publishListener.onComplete(postId);
		// } else {
		// publishListener.onCancel();
		// }
		// } else {
		// publishListener.onFail("Dialog Failed");
		// }
		// } else {
		// publishListener.onException(error);
		// }
		// }
		// });
		// } else {
		System.out.println(TAG + "Presenting web share dialog...");
		FBWebDialogs.presentShareDialog(FBSession.getActiveSession(), "feed", feed.getData(), new FBWebDialogHandler() {
			@Override
			public void invoke (FBWebDialogResult result, NSURL url, NSError error) {
				if (error != null) {
					System.out.println("Failed to publish" + error);

					if (error.description().contains("canceled")) {
						publishListener.onCancel();
					} else {
						publishListener.onException(error);
					}
				} else {
					if (result == FBWebDialogResult.NotCompleted) {
						publishListener.onCancel();
					} else {
						publishListener.onComplete(""); // TODO post id extract from url
					}
				}
			}
		});
		// }
	}

	private void openInviteDialog (String message, Map<String, String> params, final InviteListener onInviteListener) {
		FBWebDialogs.presentRequestDialog(FBSession.getActiveSession(), message, "", params, new FBWebDialogHandler() {
			@Override
			public void invoke (FBWebDialogResult result, NSURL url, NSError error) {
				if (error != null) {
					System.out.println("Failed to invite" + error);

					if (error.description().contains("Code=2")) { // TODO get error code and compare with fberror codes canceled
						onInviteListener.onCancel();
					} else {
						if (onInviteListener != null) {
							onInviteListener.onException(error);
						}
					}
				} else {
					if (result == FBWebDialogResult.NotCompleted) {
						onInviteListener.onCancel();
					} else {
						onInviteListener.onComplete();
					}
				}
			}
		});
	}

	private void openSession (boolean read) {
		System.out.println(TAG + "Opening session...");

		if (read) {
			FBSession.openForRead(configuration.getReadPermissions(), configuration.getSessionLoginBehavior().value() != 2,
				sessionStatusCallback);
		} else {
			FBSession.openForPublish(configuration.getReadPermissions(), configuration.getSessionDefaultAudience(), configuration
				.getSessionLoginBehavior().value() != 2, sessionStatusCallback);
		}
	}

	private void reopenSession () {
		System.out.println(TAG + "Reopening session...");

		FBSession session = FBSession.getActiveSession();
		if (session != null && session.getState().equals(FBSessionState.CreatedTokenLoaded)) {
			List<String> permissions = session.getPermissions();
			if (permissions.containsAll(configuration.getPublishPermissions())) {
				openSession(false);
			} else if (permissions.containsAll(configuration.getReadPermissions())) {
				openSession(true);
			}
		}
	}

	/** Extend and ask user for PUBLISH permissions */
	public void extendPublishPermissions () {
		System.out.println(TAG + "Asking for extended publish permission...");

		FBSession session = FBSession.getActiveSession();
		session.requestNewPublishPermissions(configuration.getPublishPermissions(), configuration.getSessionDefaultAudience(),
			new FBSessionRequestPermissionResultHandler() {
				@Override
				public void invoke (final FBSession session, final NSError error) {
					System.out.println(TAG + "Extended publish permissions request finished!");
					sessionStatusCallback.invoke(session, session.getState(), error);
				}
			});
	}

	public void handleDidBecomeActive () {
		FBSession.getActiveSession().handleDidBecomeActive();
	}

	public boolean handleOpenUrl (NSURL url) {
		return FBSession.getActiveSession().handleOpenURL(url);
	}

	// LISTENERS
	public interface ReopenSessionListener {
		void onSuccess ();

		void onNotAcceptingPermissions ();
	}

	public interface ProfileRequestListener extends ActionListener {
		void onComplete (FBProfile profile);
	}

	public interface ScoresRequestListener extends ActionListener {
		void onComplete (List<FBScore> scores);
	}

	public interface FriendsRequestListener extends ActionListener {
		void onComplete (List<FBProfile> friends);
	}

	public interface PublishDialogListener extends PublishListener {
		void onCancel ();
	}

	public interface PublishListener extends ActionListener {
		void onComplete (String postId);
	}

	public interface LoginListener extends ActionListener {
		void onLogin ();

		void onNotAcceptingPermissions ();
	}

	public interface LogoutListener extends ActionListener {
		void onLogout ();
	}

	public interface InviteListener extends ErrorListener {
		void onComplete ();

		void onCancel ();
	}

	public interface RequestListener extends ActionListener {
		void onComplete (NSDictionary result); // TODO maybe make FBGraphObject from it, if this is supported by RoboVM
	}

	public interface ActionListener extends ErrorListener {
		void onRequest ();
	}

	public interface ErrorListener {
		void onException (NSError throwable);

		void onFail (String reason);
	}
}
