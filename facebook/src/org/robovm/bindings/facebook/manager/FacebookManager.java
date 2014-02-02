
package org.robovm.bindings.facebook.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;
import org.robovm.bindings.facebook.FBAppCall;
import org.robovm.bindings.facebook.FBRequest;
import org.robovm.bindings.facebook.FBRequestConnection;
import org.robovm.bindings.facebook.FBRequestHandler;
import org.robovm.bindings.facebook.FBSession;
import org.robovm.bindings.facebook.FBSessionRequestPermissionResultHandler;
import org.robovm.bindings.facebook.FBSessionState;
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

	private final LoginListener defaultLoginListener = new LoginListener() {
		@Override
		public void onFail (String reason) {
		}

		@Override
		public void onException (NSError throwable) {
		}

		@Override
		public void onRequest () {
		}

		@Override
		public void onNotAcceptingPermissions () {
		}

		@Override
		public void onLogin () {
		}
	};
	private final LogoutListener defaultLogoutListener = new LogoutListener() {
		@Override
		public void onFail (String reason) {
		}

		@Override
		public void onException (NSError throwable) {
		}

		@Override
		public void onRequest () {
		}

		@Override
		public void onLogout () {
		}
	};

	private FacebookManager () {
		sessionStatusCallback = new FBSessionStatusCallback();
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

	/** Login to Facebook.
	 * 
	 * @param loginListener */
	public void login (LoginListener loginListener) {
		login(loginListener, true);
	}

	public void login (LoginListener loginListener, boolean read) {
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
			sessionStatusCallback = new FBSessionStatusCallback();
			if (loginListener != null)
				sessionStatusCallback.loginListener = loginListener;
			else
				sessionStatusCallback.loginListener = defaultLoginListener;
			session.setStateChangeHandler(sessionStatusCallback);

			// If session is not opened, open it.
			if (!session.isOpen()) {
				openSession(read);
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
				if (logoutListener != null)
					sessionStatusCallback.logoutListener = logoutListener;
				else
					sessionStatusCallback.logoutListener = defaultLogoutListener;

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
			session = new FBSession.Builder().setApplicationId(configuration.getAppId()).build();
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

			// Check if session to Facebook has necessary permissions. If not, we will ask user for missing permissions.
			if (!FBSession.getActiveSession().getPermissions().contains(FBPermission.BASIC_INFO.getValue())) {
				System.out.println(TAG + "Need to request permissions!");
				sessionStatusCallback.extendPermissionsListener = new ExtendPermissionsListener() {
					@Override
					public void onFail (String reason) {
					}

					@Override
					public void onException (NSError throwable) {
					}

					@Override
					public void onRequest () {
					}

					@Override
					public void onSuccess () {
						getProfile(profileRequestListener);
					}
				};
				extendReadPermissions();
			} else {
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
			}
		} else {
			System.out.println(TAG + "User not logged in! Auto-login now...");

			login(new LoginListener() {
				@Override
				public void onFail (String reason) {
					if (profileRequestListener != null) {
						profileRequestListener.onFail(reason);
					}
				}

				@Override
				public void onException (NSError throwable) {
					if (profileRequestListener != null) {
						profileRequestListener.onException(throwable);
					}
				}

				@Override
				public void onRequest () {
				}

				@Override
				public void onNotAcceptingPermissions () {
				}

				@Override
				public void onLogin () {
					getProfile(profileRequestListener);
				}
			});
		}
	}

	/** Get users friends from Facebook.
	 * 
	 * @param friendsRequestListener */
	public void getFriends (final FriendsRequestListener friendsRequestListener) {
		if (isLogged()) {
			System.out.println(TAG + "Requesting friends...");

			// Check if session to Facebook has necessary permissions. If not, we will ask user for missing permissions.
			if (!FBSession.getActiveSession().getPermissions().contains(FBPermission.BASIC_INFO.getValue())) {
				System.out.println(TAG + "Need to request permissions!");
				sessionStatusCallback.extendPermissionsListener = new ExtendPermissionsListener() {
					@Override
					public void onFail (String reason) {
					}

					@Override
					public void onException (NSError throwable) {
					}

					@Override
					public void onRequest () {
					}

					@Override
					public void onSuccess () {
						getFriends(friendsRequestListener);
					}
				};
				extendReadPermissions();
			} else {
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
			}
		} else {
			System.out.println(TAG + "User not logged in! Auto-login now...");

			login(new LoginListener() {
				@Override
				public void onFail (String reason) {
					if (friendsRequestListener != null) {
						friendsRequestListener.onFail(reason);
					}
				}

				@Override
				public void onException (NSError throwable) {
					if (friendsRequestListener != null) {
						friendsRequestListener.onException(throwable);
					}
				}

				@Override
				public void onRequest () {
				}

				@Override
				public void onNotAcceptingPermissions () {
				}

				@Override
				public void onLogin () {
					getFriends(friendsRequestListener);
				}
			});
		}
	}

	/** Get scores of this application from Facebook.
	 * 
	 * @param scoresRequestListener */
	public void getScores (final ScoresRequestListener scoresRequestListener) {
		if (isLogged()) {
			System.out.println(TAG + "Requesting scores...");

			// Check if session to Facebook has necessary permissions. If not, we will ask user for missing permissions.
			if (!FBSession.getActiveSession().getPermissions().contains(FBPermission.USER_GAMES_ACTIVITY.getValue())) {
				System.out.println(TAG + "Need to request permissions!");
				sessionStatusCallback.extendPermissionsListener = new ExtendPermissionsListener() {
					@Override
					public void onFail (String reason) {
					}

					@Override
					public void onException (NSError throwable) {
					}

					@Override
					public void onRequest () {
					}

					@Override
					public void onSuccess () {
						getScores(scoresRequestListener);
					}
				};
				extendReadPermissions();
			} else {
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
			}
		} else {
			System.out.println(TAG + "User not logged in! Auto-login now...");

			login(new LoginListener() {
				@Override
				public void onFail (String reason) {
					if (scoresRequestListener != null) {
						scoresRequestListener.onFail(reason);
					}
				}

				@Override
				public void onException (NSError throwable) {
					if (scoresRequestListener != null) {
						scoresRequestListener.onException(throwable);
					}
				}

				@Override
				public void onRequest () {
				}

				@Override
				public void onNotAcceptingPermissions () {
				}

				@Override
				public void onLogin () {
					getScores(scoresRequestListener);
				}
			});
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

				// Check if session to Facebook has necessary permissions. If not, we will ask user for missing permissions.
				if (!FBSession.getActiveSession().getPermissions().contains(FBPermission.PUBLISH_ACTION.getValue())) {
					System.out.println(TAG + "Need to request permissions!");
					sessionStatusCallback.extendPermissionsListener = new ExtendPermissionsListener() {
						@Override
						public void onFail (String reason) {
						}

						@Override
						public void onException (NSError throwable) {
						}

						@Override
						public void onRequest () {
						}

						@Override
						public void onSuccess () {
							publish(feed, publishListener);
						}
					};
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
			System.out.println(TAG + "User not logged in! Auto-login now...");

			login(new LoginListener() {
				@Override
				public void onFail (String reason) {
					if (publishListener != null) {
						publishListener.onFail(reason);
					}
				}

				@Override
				public void onException (NSError throwable) {
					if (publishListener != null) {
						publishListener.onException(throwable);
					}
				}

				@Override
				public void onRequest () {
				}

				@Override
				public void onNotAcceptingPermissions () {
				}

				@Override
				public void onLogin () {
					publish(feed, publishListener);
				}
			}, false);
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

				// Check if session to Facebook has necessary permissions. If not, we will ask user for missing permissions.
				if (!FBSession.getActiveSession().getPermissions().contains(FBPermission.PUBLISH_ACTION.getValue())) {
					System.out.println(TAG + "Need to request permissions!");
					sessionStatusCallback.extendPermissionsListener = new ExtendPermissionsListener() {
						@Override
						public void onFail (String reason) {
						}

						@Override
						public void onException (NSError throwable) {
						}

						@Override
						public void onRequest () {
						}

						@Override
						public void onSuccess () {
							publishWithDialog(feed, publishListener);
						}
					};
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
			System.out.println(TAG + "User not logged in! Auto-login now...");

			login(new LoginListener() {
				@Override
				public void onFail (String reason) {
					if (publishListener != null) {
						publishListener.onFail(reason);
					}
				}

				@Override
				public void onException (NSError throwable) {
					if (publishListener != null) {
						publishListener.onException(throwable);
					}
				}

				@Override
				public void onRequest () {
				}

				@Override
				public void onNotAcceptingPermissions () {
				}

				@Override
				public void onLogin () {
					publishWithDialog(feed, publishListener);
				}
			}, false);
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
	 * @param message The message inside the dialog.
	 * @param onInviteListener The listener. It could be <code>null</code>. */
	public void invite (final String message, final InviteListener onInviteListener) {
		if (isLogged()) {
			System.out.println(TAG + "Inviting friends...");
			openInviteDialog(message, null, onInviteListener);
		} else {
			System.out.println(TAG + "User not logged in! Auto-login now...");

			login(new LoginListener() {
				@Override
				public void onFail (String reason) {
					if (onInviteListener != null) {
						onInviteListener.onFail(reason);
					}
				}

				@Override
				public void onException (NSError throwable) {
					if (onInviteListener != null) {
						onInviteListener.onException(throwable);
					}
				}

				@Override
				public void onRequest () {
				}

				@Override
				public void onNotAcceptingPermissions () {
				}

				@Override
				public void onLogin () {
					invite(message, onInviteListener);
				}
			}, false);
		}
	}

	/** Open invite dialog and invite only specific friend
	 * 
	 * @param to The id of the friend profile
	 * @param message The message inside the dialog.
	 * @param onInviteListener The listener. It could be <code>null</code> */
	public void invite (final String to, final String message, final InviteListener onInviteListener) {
		if (isLogged()) {
			System.out.println(TAG + "Inviting friends...");
			Map<String, String> params = new HashMap<String, String>();
			params.put("to", to);
			openInviteDialog(message, params, onInviteListener);
		} else {
			System.out.println(TAG + "User not logged in! Auto-login now...");

			login(new LoginListener() {
				@Override
				public void onFail (String reason) {
					if (onInviteListener != null) {
						onInviteListener.onFail(reason);
					}
				}

				@Override
				public void onException (NSError throwable) {
					if (onInviteListener != null) {
						onInviteListener.onException(throwable);
					}
				}

				@Override
				public void onRequest () {
				}

				@Override
				public void onNotAcceptingPermissions () {
				}

				@Override
				public void onLogin () {
					invite(to, message, onInviteListener);
				}
			}, false);
		}
	}

	/** Open invite dialog and invite several specific friends
	 * 
	 * @param suggestedFriends The ids of friends' profiles.
	 * @param message The message inside the dialog.
	 * @param onInviteListener The error listener. It could be <code>null</code> */
	public void invite (final String[] suggestedFriends, final String message, final InviteListener onInviteListener) {
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
			System.out.println(TAG + "User not logged in! Auto-login now...");

			login(new LoginListener() {
				@Override
				public void onFail (String reason) {
					if (onInviteListener != null) {
						onInviteListener.onFail(reason);
					}
				}

				@Override
				public void onException (NSError throwable) {
					if (onInviteListener != null) {
						onInviteListener.onException(throwable);
					}
				}

				@Override
				public void onRequest () {
				}

				@Override
				public void onNotAcceptingPermissions () {
				}

				@Override
				public void onLogin () {
					invite(suggestedFriends, message, onInviteListener);
				}
			}, false);
		}
	}

	/** Make a request to the Facebook API.
	 * 
	 * @param request
	 * @param method
	 * @param onRequestListener */
	public void request (String request, String method, RequestListener requestListener) {
		request(request, method, null, requestListener);
	}

	/** Make a request to the Facebook API with parameters.
	 * 
	 * @param request
	 * @param method
	 * @param params
	 * @param requestListener */
	public void request (final String request, final String method, final Map<String, String> params,
		final RequestListener requestListener) {
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
						System.out.println(TAG + "The GraphObject in response of publish action has null value. Response="
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
			System.out.println(TAG + "User not logged in! Auto-login now...");

			boolean read = false;
			if (method.equals(HttpMethod.GET)) read = true;

			login(new LoginListener() {
				@Override
				public void onFail (String reason) {
					if (requestListener != null) {
						requestListener.onFail(reason);
					}
				}

				@Override
				public void onException (NSError throwable) {
					if (requestListener != null) {
						requestListener.onException(throwable);
					}
				}

				@Override
				public void onRequest () {
				}

				@Override
				public void onNotAcceptingPermissions () {
				}

				@Override
				public void onLogin () {
					request(request, method, params, requestListener);
				}
			}, read);
		}
	}

	private static void publishImpl (FBFeed feed, final PublishListener onPublishListener) {
		FBSession session = FBSession.getActiveSession();
		FBRequest request = new FBRequest(session, "me/feed", feed.getData(), HttpMethod.POST);

		request.start(new FBRequestHandler() {
			@Override
			public void invoke (FBRequestConnection connection, NSObject result, NSError error) {
				NSDictionary<NSString, NSString> graphObject = (NSDictionary<NSString, NSString>)result;
				if (graphObject != null) {
					// convert NSString in the graph object to String
					Map<String, String> graphObjectJava = new HashMap<String, String>();
					Set<Entry<NSString, NSString>> set = graphObject.entrySet();
					for (Entry<NSString, NSString> entry : set) {
						graphObjectJava.put(entry.getKey().toString(), entry.getValue().toString());
					}

					JSONObject graphResponse = new JSONObject(graphObjectJava);
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
// FBShareDialogParams params = new FBShareDialogParams();
// if (feed.getCaption() != null) params.setCaption(feed.getCaption());
// if (feed.getDescription() != null) params.setDescription(feed.getDescription());
// if (feed.getLink() != null) params.setLink(new NSURL(feed.getLink()));
// if (feed.getName() != null) params.setName(feed.getName());
// if (feed.getPicture() != null) params.setPicture(new NSURL(feed.getPicture()));

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
					System.out.println(TAG + "Failed to publish! Error: " + error);

					if (error.description().contains("canceled")) {
						publishListener.onCancel();
					} else {
						publishListener.onException(error);
					}
				} else {
					if (result == FBWebDialogResult.NotCompleted) {
						System.out.println(TAG + "Publish action canceled by user!");
						publishListener.onCancel();
					} else {
						System.out.println(TAG + "Publish action completed successfully!");
						publishListener.onComplete(url.toString().substring(url.toString().indexOf("post_id=") + 8));
					}
				}
			}
		});
		// }
	}

	private void openInviteDialog (final String message, final Map<String, String> params, final InviteListener inviteListener) {
		// Check if session to Facebook has 'publish_action' permission. If not, we will ask user for this permission.
		if (!FBSession.getActiveSession().getPermissions().contains(FBPermission.PUBLISH_ACTION.getValue())) {
			System.out.println(TAG + "Need to request publish permissions!");
			sessionStatusCallback.extendPermissionsListener = new ExtendPermissionsListener() {
				@Override
				public void onFail (String reason) {
					if (inviteListener != null) inviteListener.onFail(reason);
				}

				@Override
				public void onException (NSError throwable) {
					if (inviteListener != null) inviteListener.onException(throwable);
				}

				@Override
				public void onRequest () {
				}

				@Override
				public void onSuccess () {
					openInviteDialog(message, params, inviteListener);
				}
			};
			extendPublishPermissions();
		} else {
			FBWebDialogs.presentRequestDialog(FBSession.getActiveSession(), message, "", params, new FBWebDialogHandler() {
				@Override
				public void invoke (FBWebDialogResult result, NSURL url, NSError error) {
					if (error != null) {
						System.out.println("Failed to invite" + error);

						if (error.description().contains("Code=2")) { // TODO get error code and compare with fberror codes canceled
							inviteListener.onCancel();
						} else {
							if (inviteListener != null) {
								inviteListener.onException(error);
							}
						}
					} else {
						if (result == FBWebDialogResult.NotCompleted) {
							inviteListener.onCancel();
						} else {
							inviteListener.onComplete();
						}
					}
				}
			});
		}
	}

	private void openSession (boolean read) {
		System.out.println(TAG + "Opening session...");

		// Ensure that the status callback will not cause null pointer exceptions.
		if (sessionStatusCallback == null) {
			sessionStatusCallback = new FBSessionStatusCallback();
			sessionStatusCallback.loginListener = defaultLoginListener;
			sessionStatusCallback.logoutListener = defaultLogoutListener;
		} else {
			if (sessionStatusCallback.loginListener == null) {
				sessionStatusCallback.loginListener = defaultLoginListener;
			}
			if (sessionStatusCallback.logoutListener == null) {
				sessionStatusCallback.logoutListener = defaultLogoutListener;
			}
		}

		if (read) {
			FBSession.openForRead(configuration.getReadPermissions(), configuration.getSessionLoginBehavior().value() != 2,
				sessionStatusCallback);
		} else {
			FBSession.openForPublish(configuration.getPublishPermissions(), configuration.getSessionDefaultAudience(), configuration
				.getSessionLoginBehavior().value() != 2, sessionStatusCallback);
		}
	}

	private void reopenSession () {
		System.out.println(TAG + "Reopening session...");

		FBSession session = FBSession.getActiveSession();
		if (session != null && session.getState().equals(FBSessionState.CreatedTokenLoaded)) {
			List<String> permissions = session.getPermissions();
			if (permissions.containsAll(configuration.getPublishPermissions()) && configuration.getPublishPermissions().size() > 0) {
				openSession(false);
			} else if (permissions.containsAll(configuration.getReadPermissions()) && configuration.getReadPermissions().size() > 0) {
				openSession(true);
			}
		}
	}

	/** Extend and ask user for READ permissions. */
	public void extendReadPermissions () {
		System.out.println(TAG + "Asking for extended read permissions...");

		FBSession.getActiveSession().requestNewReadPermissions(configuration.getReadPermissions(),
			new FBSessionRequestPermissionResultHandler() {
				@Override
				public void invoke (FBSession session, NSError error) {
					System.out.println(TAG + "Extended read permissions request finished!");
				}
			});
	}

	/** Extend and ask user for PUBLISH permissions. */
	public void extendPublishPermissions () {
		extendPublishPermissions(new FBSessionRequestPermissionResultHandler() {
			@Override
			public void invoke (final FBSession session, final NSError error) {
				System.out.println(TAG + "Extended publish permissions request finished!");
			}
		});
	}

	/** Extend and ask user for PUBLISH permissions. */
	public void extendPublishPermissions (FBSessionRequestPermissionResultHandler handler) {
		System.out.println(TAG + "Asking for extended publish permission...");

		FBSession.getActiveSession().requestNewPublishPermissions(configuration.getPublishPermissions(),
			configuration.getSessionDefaultAudience(), handler);
	}

	public void handleDidBecomeActive () {
		FBSession.getActiveSession().handleDidBecomeActive();
	}

	public boolean handleOpenUrl (NSURL url, String sourceApplication) {
		FBAppCall.handleOpenURL(url, sourceApplication);
// FBSession.getActiveSession().handleOpenURL(url); TODO
		return true;
	}

	public interface ExtendPermissionsListener extends ActionListener {
		void onSuccess ();
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
