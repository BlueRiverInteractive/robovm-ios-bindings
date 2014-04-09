
package org.robovm.bindings.facebook.session;

import java.util.ArrayList;
import java.util.List;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.foundation.NSString;
import org.robovm.apple.foundation.NSURL;
import org.robovm.apple.uikit.UIApplicationDelegate;
import org.robovm.bindings.facebook.FBAccessTokenData;
import org.robovm.bindings.facebook.FBFriendPickerViewController;
import org.robovm.bindings.facebook.FBLoginView;
import org.robovm.bindings.facebook.FBRequest;
import org.robovm.bindings.facebook.FBSettings;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;
import org.robovm.rt.bro.annotation.Pointer;

/** The FBSession object is used to authenticate a user and manage the user's session. After initializing a FBSession object the
 * Facebook App ID and desired permissions are stored. Opening the session will initiate the authentication flow after which a
 * valid user session should be available and subsequently cached. Closing the session can optionally clear the cache.
 * 
 * If an {@link FBRequest} request requires user authorization then an FBSession object should be used.
 * 
 * 
 * Instances of the FBSession class provide notification of state changes in the following ways:
 * 
 * 1. Callers of certain FBSession methods may provide a block that will be called back in the course of state transitions for the
 * session (e.g. login or session closed).
 * 
 * 2. The object supports Key-Value Observing (KVO) for property changes. */
@NativeClass
public class FBSession extends NSObject {
	/** Returns a newly initialized Facebook session with default values for the parameters to
	 * {@link #FBSession(String, NSArray, FBSessionDefaultAudience, String, FBSessionTokenCachingStrategy)} */
	public FBSession () {
		super((SkipInit)null);
		initObject(init());
	}

	@Method(selector = "init")
	private native @Pointer
	long init ();

	/** Returns a newly initialized Facebook session with the specified permissions and other default values for parameters to
	 * {@link #FBSession(String, NSArray, FBSessionDefaultAudience, String, FBSessionTokenCachingStrategy)}.
	 * 
	 * It is required that any single permission request request (including initial log in) represent read-only permissions or
	 * publish permissions only; not both. The permissions passed here should reflect this requirement.
	 * @param permissions An array of strings representing the permissions to request during the authentication flow. The
	 *           basic_info permission must be explicitly requested at first login, and is no longer inferred, (subject to an
	 *           active migration.) The default is {@code null}. */
	public FBSession (NSArray<?> permissions) {
		super((SkipInit)null);
		initObject(init(permissions));
	}

	@Method(selector = "initWithPermissions:")
	private native @Pointer
	long init (NSArray<?> permissions);

	/** Following are the descriptions of the arguments along with their defaults when ommitted.
	 * 
	 * It is required that any single permission request request (including initial log in) represent read-only permissions or
	 * publish permissions only; not both. The permissions passed here should reflect this requirement.
	 * 
	 * @param permissions An array of strings representing the permissions to request during the authentication flow. The
	 *           basic_info permission must be explicitly requested at first login, and is no longer inferred, (subject to an
	 *           active migration.) The default is {@code null}.
	 * 
	 * @param appID The Facebook App ID for the session. If {@code null} is passed in the default App ID will be obtained. The
	 *           default is {@code null}.
	 * 
	 * @param urlSchemeSuffix The URL Scheme Suffix to be used in scenarious where multiple iOS apps use one Facebook App ID. A
	 *           value of {@code null} indicates that this information should be pulled from
	 *           {@link FBSettings#getDefaultUrlSchemeSuffix()}. The default is {@code null}.
	 * 
	 * @param tokenCachingStrategy Specifies a key name to use for cached token information in NSUserDefaults, {@code null}
	 *           indicates a default value of "FBAccessTokenInformationKey". */
	public FBSession (String appID, NSArray<?> permissions, String urlSchemeSuffix,
		FBSessionTokenCachingStrategy tokenCachingStrategy) {
		super((SkipInit)null);
		initObject(init(appID, permissions, urlSchemeSuffix, tokenCachingStrategy));
	}

	@Method(selector = "initWithAppID:permissions:urlSchemeSuffix:tokenCacheStrategy:")
	private native @Pointer
	long init (String appID, NSArray<?> permissions, String urlSchemeSuffix, FBSessionTokenCachingStrategy tokenCachingStrategy);

	/** Following are the descriptions of the arguments along with their defaults when ommitted.
	 * 
	 * It is required that any single permission request (including initial log in) represent read-only permissions or publish
	 * permissions only; not both. The permissions passed here should reflect this requirement. If publish permissions are used,
	 * then the audience must also be specified.
	 * 
	 * @param permissions An array of strings representing the permissions to request during the authentication flow. The
	 *           basic_info permission must be explicitly requested at first login, and is no longer inferred, (subject to an
	 *           active migration.) The default is {@code null}.
	 * 
	 * @param defaultAudience Most applications use FBSessionDefaultAudienceNone here, only specifying an audience when using
	 *           reauthorize to request publish permissions.
	 * 
	 * @param appID The Facebook App ID for the session. If {@code null} is passed in the default App ID will be obtained. The
	 *           default is {@code null}.
	 * 
	 * @param urlSchemeSuffix The URL Scheme Suffix to be used in scenarious where multiple iOS apps use one Facebook App ID. A
	 *           value of {@code null} indicates that this information should be pulled from
	 *           {@link FBSettings#getDefaultUrlSchemeSuffix()}. The default is {@code null}.
	 * 
	 * @param tokenCachingStrategy Specifies a key name to use for cached token information in NSUserDefaults, {@code null}
	 *           indicates a default value of "FBAccessTokenInformationKey". */
	public FBSession (String appID, NSArray<?> permissions, FBSessionDefaultAudience defaultAudience, String urlSchemeSuffix,
		FBSessionTokenCachingStrategy tokenCacheStrategy) {
		initObject(init(appID, permissions, defaultAudience, urlSchemeSuffix, tokenCacheStrategy));
	}

	@Method(selector = "initWithAppID:permissions:defaultAudience:urlSchemeSuffix:tokenCacheStrategy:")
	private native @Pointer
	long init (String appID, NSArray<?> permissions, FBSessionDefaultAudience defaultAudience, String urlSchemeSuffix,
		FBSessionTokenCachingStrategy tokenCacheStrategy);

	/** @return Indicates whether the session is open and ready for use. */
	@Property(selector = "isOpen")
	public native boolean isOpen ();

	/** @return Detailed session state. */
	@Property
	public native FBSessionState getState ();

	/** @return Identifies the Facebook app which the session object represents. */
	@Property
	public native String getAppID ();

	/** @return Identifies the URL Scheme Suffix used by the session. This is used when multiple iOS apps share a single Facebook app
	 *         ID. */
	@Property(selector = "urlSchemeSuffix")
	public native String getURLSchemeSuffix ();

	/** @return The permissions granted to the access token during the authentication flow. */
	public List<String> getPermissionList () {
		NSArray<?> p = getPermissions();
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < p.size(); i++) {
			list.add(p.get(i).toString());
		}
		return list;
	}

	/** @return The permissions granted to the access token during the authentication flow. */
	@Property
	public native NSArray<?> getPermissions ();

	/** @return the FBAccessTokenData for the session. */
	@Property
	public native FBAccessTokenData getAccessTokenData ();

	/** Opens a session for the Facebook.
	 * 
	 * A session may not be used with {@link FBRequest} and other classes in the SDK until it is open. If, prior to calling open,
	 * the session is in the {@link FBSessionState#CreatedTokenLoaded} state, then no UX occurs, and the session becomes available
	 * for use. If the session is in the {@link FBSessionState#Created} state, prior to calling open, then a call to open causes
	 * login UX to occur, either via the Facebook application or via mobile Safari.
	 * 
	 * Open may be called at most once and must be called after the FBSession is initialized. Open must be called before the
	 * session is closed. Calling an open method at an invalid time will result in an exception. The open session methods may be
	 * passed a block that will be called back when the session state changes. The block will be released when the session is
	 * closed.
	 * 
	 * @param handler A block to call with the state changes. The default is {@code null}. */
	@Method(selector = "openWithCompletionHandler:")
	public native void open (@Block FBSessionStateHandler stateHandler);

	/** Logs a user on to Facebook.
	 * 
	 * A session may not be used with {@link FBRequest} and other classes in the SDK until it is open. If, prior to calling open,
	 * the session is in the {@link FBSessionState#CreatedTokenLoaded} state, then no UX occurs, and the session becomes available
	 * for use. If the session is in the {@link FBSessionState#Created} state, prior to calling open, then a call to open causes
	 * login UX to occur, either via the Facebook application or via mobile Safari.
	 * 
	 * The method may be called at most once and must be called after the FBSession is initialized. It must be called before the
	 * session is closed. Calling the method at an invalid time will result in an exception. The open session methods may be passed
	 * a block that will be called back when the session state changes. The block will be released when the session is closed.
	 * 
	 * @param behavior Controls whether to allow, force, or prohibit Facebook Login or Inline Facebook Login. The default is to
	 *           allow Facebook Login, with fallback to Inline Facebook Login.
	 * 
	 * @param handler A block to call with session state changes. The default is {@code null}. */
	@Method(selector = "openWithBehavior:completionHandler:")
	public native void open (FBSessionLoginBehavior behavior, @Block FBSessionStateHandler stateHandler);

	/** Imports an existing access token and opens the session with it.
	 * 
	 * The method attempts to open the session using an existing access token. No UX will occur. If successful, the session with be
	 * in an Open state and the method will return {@code true}; otherwise, {@code false}.
	 * 
	 * The method may be called at most once and must be called after the FBSession is initialized (see below). It must be called
	 * before the session is closed. Calling the method at an invalid time will result in an exception. The open session methods
	 * may be passed a block that will be called back when the session state changes. The block will be released when the session
	 * is closed.
	 * 
	 * The initialized session must not have already been initialized from a cache (for example, you could use the
	 * {@link FBSessionTokenCachingStrategy#createNullCacheInstance()} instance).
	 * 
	 * @param accessTokenData The token data. See {@link FBAccessTokenData} for construction methods.
	 * 
	 * @param handler A block to call with session state changes. The default is {@code null}. */
	@Method(selector = "openFromAccessTokenData:completionHandler:")
	public native boolean open (FBAccessTokenData accessTokenData, @Block FBSessionStateHandler handler);

	/** Closes the local in-memory session object, but does not clear the persisted token cache. */
	@Method(selector = "close")
	public native void closeSession ();

	/** Closes the in-memory session, and clears any persisted cache related to the session, when specified.
	 * @param clearTokenInformation */
	public void close (boolean clearTokenInformation) {
		if (clearTokenInformation) {
			closeAndClearTokenInformation();
		} else {
			closeSession();
		}
	}

	/** Closes the in-memory session, and clears any persisted cache related to the session. */
	@Method(selector = "closeAndClearTokenInformation")
	private native void closeAndClearTokenInformation ();

	/** @see #requestNewReadPermissions(NSArray, FBSessionRequestPermissionResultHandler)
	 * @param readPermissions
	 * @param handler */
	public void requestNewReadPermissions (List<String> readPermissions, FBSessionRequestPermissionResultHandler handler) {
		List<NSString> permissions = new ArrayList<NSString>();
		for (int i = 0; i < readPermissions.size(); i++) {
			permissions.add(new NSString(readPermissions.get(i)));
		}
		requestNewReadPermissions(new NSArray<NSString>(permissions), handler);
	}

	/** Requests new or additional read permissions for the session.
	 * 
	 * The handler, if not {@code null}, is called once the operation has completed or failed. This is in contrast to the state
	 * completion handler used in {@link FBSession#open(FBSessionStateHandler)} (and other open methods) which is called for each
	 * state-change for the session.
	 * 
	 * @param readPermissions An array of strings representing the permissions to request during the authentication flow. A value
	 *           of {@code null} indicates basic permissions.
	 * 
	 * @param handler A block to call with session state changes. The default is {@code null}. */

	@Method(selector = "requestNewReadPermissions:completionHandler:")
	public native void requestNewReadPermissions (NSArray<?> readPermissions,
		@Block FBSessionRequestPermissionResultHandler handler);

	/** @see #requestNewPublishPermissions(NSArray, FBSessionDefaultAudience, FBSessionRequestPermissionResultHandler)
	 * @param publishPermissions
	 * @param defaultAudience
	 * @param handler */
	public void requestNewPublishPermissions (List<String> publishPermissions, FBSessionDefaultAudience defaultAudience,
		FBSessionRequestPermissionResultHandler handler) {
		List<NSString> permissions = new ArrayList<NSString>();
		for (int i = 0; i < publishPermissions.size(); i++) {
			permissions.add(new NSString(publishPermissions.get(i)));
		}
		requestNewPublishPermissions(new NSArray<NSString>(permissions), defaultAudience, handler);
	}

	/** Requests new or additional write permissions for the session.
	 * 
	 * The handler, if not {@code null}, is called once the operation has completed or failed. This is in contrast to the state
	 * completion handler used in {@link #open(FBSessionStateHandler)} (and other open* methods) which is called for each
	 * state-change for the session.
	 * 
	 * 
	 * @param publishPermissions An array of strings representing the permissions to request during the authentication flow.
	 * @param defaultAudience Specifies the audience for posts.
	 * @param handler A block to call with session state changes. The default is {@code null}. */
	@Method(selector = "requestNewPublishPermissions:defaultAudience:completionHandler:")
	public native void requestNewPublishPermissions (NSArray<?> publishPermissions, FBSessionDefaultAudience defaultAudience,
		@Block FBSessionRequestPermissionResultHandler handler);

	/** A helper method that is used to provide an implementation for {@link UIApplicationDelegate#openURL(NSURL, String, NSObject)}
	 * . It should be invoked during the Facebook Login flow and will update the session information based on the incoming URL.
	 * 
	 * @param url The URL as passed to {@link UIApplicationDelegate#openURL(NSURL, String, NSObject)}. */
	@Method(selector = "handleOpenURL:")
	public native boolean handleOpenURL (NSURL url);

	/** A helper method that is used to provide an implementation for {@link UIApplicationDelegate#didBecomeActive(UIApplication)}
	 * to properly resolve session state for the Facebook Login flow, specifically to support app-switch login. */
	@Method(selector = "handleDidBecomeActive")
	public native void handleDidBecomeActive ();

	/** Assign the block to be invoked for session state changes.
	 * 
	 * This will overwrite any state change handler that was already assigned. Typically, you should only use this setter if you
	 * were unable to assign a state change handler explicitly. One example of this is if you are not opening the session (e.g.,
	 * using the open* methods) but still want to assign a {@link FBSessionStateHandler} block. This can happen when the SDK opens
	 * a session from an app link. */
	@Method(selector = "setStateChangeHandler:")
	public native void setStateChangeHandler (@Block FBSessionStateHandler stateChangeHandler);

	/*
	 * !
	 * 
	 * @abstract This is the simplest method for opening a session with Facebook. Using sessionOpen logs on a user, and sets the
	 * static activeSession which becomes the default session object for any Facebook UI widgets used by the application. This
	 * session becomes the active session, whether open succeeds or fails.
	 * 
	 * Note, if there is not a cached token available, this method will present UI to the user in order to open the session via
	 * explicit login by the user.
	 * 
	 * @param allowLoginUI Sometimes it is useful to attempt to open a session, but only if no login UI will be required to
	 * accomplish the operation. For example, at application startup it may not be disirable to transition to login UI for the
	 * user, and yet an open session is desired so long as a cached token can be used to open the session. Passing {@code false} to
	 * this argument, assures the method will not present UI to the user in order to open the session.
	 * 
	 * @discussion Returns {@code true} if the session was opened synchronously without presenting UI to the user. This occurs when
	 * there is a cached token available from a previous run of the application. If {@code false} is returned, this indicates that
	 * the session was not immediately opened, via cache. However, if {@code true} was passed as allowLoginUI, then it is possible
	 * that the user will login, and the session will become open asynchronously. The primary use for this return value is to
	 * switch-on facebook capabilities in your UX upon startup, in the case where the session is opened via cache.
	 */
	// + (BOOL)openActiveSessionWithAllowLoginUI:(BOOL)allowLoginUI;

	/** @see #openForRead(NSArray, boolean, FBSessionStateHandler)
	 * @param readPermissions
	 * @param allowLoginUI
	 * @param stateChangeHandler
	 * @return */
	public static boolean openForRead (List<String> readPermissions, boolean allowLoginUI, FBSessionStateHandler stateChangeHandler) {
		List<NSString> permissions = new ArrayList<NSString>();
		for (int i = 0; i < readPermissions.size(); i++) {
			permissions.add(new NSString(readPermissions.get(i)));
		}

		return openForRead(new NSArray<NSString>(permissions), allowLoginUI, stateChangeHandler);
	}

	/** This is a simple method for opening a session with Facebook. Using sessionOpen logs on a user, and sets the static
	 * activeSession which becomes the default session object for any Facebook UI widgets used by the application. This session
	 * becomes the active session, whether open succeeds or fails.
	 * 
	 * @param readPermissions An array of strings representing the read permissions to request during the authentication flow. The
	 *           basic_info permission must be explicitly requested at first login, and is no longer inferred, (subject to an
	 *           active migration.) It is not allowed to pass publish permissions to this method.
	 * 
	 * @param allowLoginUI Sometimes it is useful to attempt to open a session, but only if no login UI will be required to
	 *           accomplish the operation. For example, at application startup it may not be desirable to transition to login UI
	 *           for the user, and yet an open session is desired so long as a cached token can be used to open the session.
	 *           Passing {@code false} to this argument, assures the method will not present UI to the user in order to open the
	 *           session.
	 * 
	 * @param handler Many applications will benefit from notification when a session becomes invalid or undergoes other state
	 *           transitions. If a block is provided, the FBSession object will call the block each time the session changes state.
	 * 
	 * @return {@code true} if the session was opened synchronously without presenting UI to the user. This occurs when there is a
	 *         cached token available from a previous run of the application. If {@code false} is returned, this indicates that the
	 *         session was not immediately opened, via cache. However, if {@code true} was passed as allowLoginUI, then it is
	 *         possible that the user will login, and the session will become open asynchronously. The primary use for this return
	 *         value is to switch-on facebook capabilities in your UX upon startup, in the case where the session is opened via
	 *         cache. */
	@Method(selector = "openActiveSessionWithReadPermissions:allowLoginUI:completionHandler:")
	public static native boolean openForRead (NSArray<NSString> readPermissions, boolean allowLoginUI,
		@Block FBSessionStateHandler stateChangeHandler);

	/** @see #openForPublish(NSArray, FBSessionDefaultAudience, boolean, FBSessionStateHandler)
	 * @param publishPermissions
	 * @param defaultAudience
	 * @param allowLoginUI
	 * @param stateChangeHandler
	 * @return */
	public static boolean openForPublish (List<String> publishPermissions, FBSessionDefaultAudience defaultAudience,
		boolean allowLoginUI, FBSessionStateHandler stateChangeHandler) {
		List<NSString> permissions = new ArrayList<NSString>();
		for (int i = 0; i < publishPermissions.size(); i++) {
			permissions.add(new NSString(publishPermissions.get(i)));
		}

		return openForPublish(new NSArray<NSString>(permissions), defaultAudience, allowLoginUI, stateChangeHandler);
	}

	/** This is a simple method for opening a session with Facebook. Using sessionOpen logs on a user, and sets the static
	 * activeSession which becomes the default session object for any Facebook UI widgets used by the application. This session
	 * becomes the active session, whether open succeeds or fails.
	 * 
	 * @param publishPermissions An array of strings representing the publish permissions to request during the authentication
	 *           flow.
	 * 
	 * @param defaultAudience Anytime an app publishes on behalf of a user, the post must have an audience (e.g. me, my friends,
	 *           etc.) The default audience is used to notify the user of the cieling that the user agrees to grant to the app for
	 *           the provided permissions.
	 * 
	 * @param allowLoginUI Sometimes it is useful to attempt to open a session, but only if no login UI will be required to
	 *           accomplish the operation. For example, at application startup it may not be desirable to transition to login UI
	 *           for the user, and yet an open session is desired so long as a cached token can be used to open the session.
	 *           Passing {@code false} to this argument, assures the method will not present UI to the user in order to open the
	 *           session.
	 * 
	 * @param handler Many applications will benefit from notification when a session becomes invalid or undergoes other state
	 *           transitions. If a block is provided, the FBSession object will call the block each time the session changes state.
	 * 
	 * @return {@code true} if the session was opened synchronously without presenting UI to the user. This occurs when there is a
	 *         cached token available from a previous run of the application. If {@code false} is returned, this indicates that the
	 *         session was not immediately opened, via cache. However, if {@code true} was passed as allowLoginUI, then it is
	 *         possible that the user will login, and the session will become open asynchronously. The primary use for this return
	 *         value is to switch-on facebook capabilities in your UX upon startup, in the case where the session is opened via
	 *         cache. */
	@Method(selector = "openActiveSessionWithPublishPermissions:defaultAudience:allowLoginUI:completionHandler:")
	public static native boolean openForPublish (NSArray<?> publishPermissions, FBSessionDefaultAudience defaultAudience,
		boolean allowLoginUI, @Block FBSessionStateHandler stateChangeHandler);

	/** An application may get or set the current active session. Certain high-level components in the SDK will use the
	 * activeSession to set default session (e.g. {@link FBLoginView}, {@link FBFriendPickerViewController})
	 * 
	 * If sessionOpen* is called, the resulting FBSession object also becomes the activeSession. If another session was active at
	 * the time, it is closed automatically. If activeSession is called when no session is active, a session object is instatiated
	 * and returned; in this case open must be called on the session in order for it to be useable for communication with Facebook. */
	@Property
	public static native FBSession getActiveSession ();

	/** An application may get or set the current active session. Certain high-level components in the SDK will use the
	 * activeSession to set default session (e.g. {@link FBLoginView}, {@link FBFriendPickerViewController})
	 * 
	 * If an application prefers the flexibility of directly instantiating a session object, an active session can be set directly.
	 * @param session The FBSession object to become the active session */
	@Property
	public static native void setActiveSession (FBSession session);

	/** Issues an asychronous renewCredentialsForAccount call to the device Facebook account store.
	 * 
	 * This can be used to explicitly renew account credentials on iOS 6 devices and is provided as a convenience wrapper around
	 * `[ACAccountStore renewCredentialsForAccount:completion]`. Note the method will not issue the renewal call if the the
	 * Facebook account has not been set on the device, or if access had not been granted to the account (though the handler wil
	 * receive an error).
	 * 
	 * This is safe to call (and will surface an error to the handler) on versions of iOS before 6 or if the user logged in via
	 * Safari or Facebook SSO.
	 * @param handler The completion handler to call when the renewal is completed. The handler will be invoked on the main thread. */
// @Method(selector = "renewSystemCredentials:") TODO
// public static native void renewSystemCredentials (@Block FBSessionRenewSystemCredentialsHandler handler);

	/** Builder class used to create a Session. */
	public static final class Builder {
		private String applicationId;
		private NSArray<NSString> permissions;
		private FBSessionDefaultAudience defaultAudience = FBSessionDefaultAudience.Friends;
		private String urlSchemePrefix = "";
		private FBSessionTokenCachingStrategy tokenCachingStrategy;

		public Builder () {
		}

		public Builder setApplicationId (String applicationId) {
			this.applicationId = applicationId;
			return this;
		}

		public Builder setPermissions (String... permissions) {
			this.permissions = new NSArray<NSString>();
			for (String permission : permissions) {
				this.permissions.add(new NSString(permission));
			}
			return this;
		}

		public Builder setDefaultAudience (FBSessionDefaultAudience defaultAudience) {
			this.defaultAudience = defaultAudience;
			return this;
		}

		public Builder setURLSchemePrefix (String urlSchemePrefix) {
			this.urlSchemePrefix = urlSchemePrefix;
			return this;
		}

		public Builder setTokenCachingStrategy (FBSessionTokenCachingStrategy tokenCachingStrategy) {
			this.tokenCachingStrategy = tokenCachingStrategy;
			return this;
		}

		public FBSession build () {
			return new FBSession(applicationId, permissions, defaultAudience, urlSchemePrefix, tokenCachingStrategy);
		}
	}
}
