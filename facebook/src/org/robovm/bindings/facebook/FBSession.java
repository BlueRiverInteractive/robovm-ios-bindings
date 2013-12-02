
package org.robovm.bindings.facebook;

import java.util.ArrayList;
import java.util.List;

import org.robovm.cocoatouch.foundation.NSArray;
import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSString;
import org.robovm.cocoatouch.foundation.NSURL;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;
import org.robovm.rt.bro.annotation.Pointer;

@Library(Library.INTERNAL)
@NativeClass()
public class FBSession extends NSObject {
	private static final ObjCClass objCClass = ObjCClass.getByType(FBSession.class);

	static {
		ObjCRuntime.bind(FBSession.class);
	}

	protected FBSession (SkipInit skipInit) {
		super(skipInit);
	}

	/*
	 * !
	 * 
	 * @method
	 * 
	 * @abstract Returns a newly initialized Facebook session with default values for the parameters to
	 * <initWithAppID:permissions:urlSchemeSuffix:tokenCacheStrategy:>.
	 */
	private static final Selector init = Selector.register("init");

	@Bridge
	private native static @Pointer
	long objc_init (FBSession __self__, Selector __cmd__);

	public FBSession () {
		initObject(objc_init(this, init));
	}

	/*
	 * !
	 * 
	 * @method
	 * 
	 * @abstract Returns a newly initialized Facebook session with the specified permissions and other default values for
	 * parameters to <initWithAppID:permissions:urlSchemeSuffix:tokenCacheStrategy:>.
	 * 
	 * @param permissions An array of strings representing the permissions to request during the authentication flow. The
	 * basic_info permission must be explicitly requested at first login, and is no longer inferred, (subject to an active
	 * migration.) The default is nil.
	 * 
	 * @discussion It is required that any single permission request request (including initial log in) represent read-only
	 * permissions or publish permissions only; not both. The permissions passed here should reflect this requirement.
	 */
	// - (id)initWithPermissions:(NSArray*)permissions;

	/*
	 * !
	 * 
	 * @method
	 * 
	 * @abstract Following are the descriptions of the arguments along with their defaults when ommitted.
	 * 
	 * @param permissions An array of strings representing the permissions to request during the authentication flow. The
	 * basic_info permission must be explicitly requested at first login, and is no longer inferred, (subject to an active
	 * migration.) The default is nil.
	 * 
	 * @param appID The Facebook App ID for the session. If nil is passed in the default App ID will be obtained from a call to
	 * <[FBSession defaultAppID]>. The default is nil.
	 * 
	 * @param urlSchemeSuffix The URL Scheme Suffix to be used in scenarious where multiple iOS apps use one Facebook App ID. A
	 * value of nil indicates that this information should be pulled from [FBSettings defaultUrlSchemeSuffix]. The default is nil.
	 * 
	 * @param tokenCachingStrategy Specifies a key name to use for cached token information in NSUserDefaults, nil indicates a
	 * default value of
	 * 
	 * @"FBAccessTokenInformationKey".
	 * 
	 * @discussion It is required that any single permission request request (including initial log in) represent read-only
	 * permissions or publish permissions only; not both. The permissions passed here should reflect this requirement.
	 */
	// - (id)initWithAppID:(NSString*)appID
	// permissions:(NSArray*)permissions
	// urlSchemeSuffix:(NSString*)urlSchemeSuffix
	// tokenCacheStrategy:(FBSessionTokenCachingStrategy*)tokenCachingStrategy;

	/*
	 * !
	 * 
	 * @method
	 * 
	 * @abstract Following are the descriptions of the arguments along with their defaults when ommitted.
	 * 
	 * @param permissions An array of strings representing the permissions to request during the authentication flow. The
	 * basic_info permission must be explicitly requested at first login, and is no longer inferred, (subject to an active
	 * migration.) The default is nil.
	 * 
	 * @param defaultAudience Most applications use FBSessionDefaultAudienceNone here, only specifying an audience when using
	 * reauthorize to request publish permissions.
	 * 
	 * @param appID The Facebook App ID for the session. If nil is passed in the default App ID will be obtained from a call to
	 * <[FBSession defaultAppID]>. The default is nil.
	 * 
	 * @param urlSchemeSuffix The URL Scheme Suffix to be used in scenarious where multiple iOS apps use one Facebook App ID. A
	 * value of nil indicates that this information should be pulled from [FBSettings defaultUrlSchemeSuffix]. The default is nil.
	 * 
	 * @param tokenCachingStrategy Specifies a key name to use for cached token information in NSUserDefaults, nil indicates a
	 * default value of
	 * 
	 * @"FBAccessTokenInformationKey".
	 * 
	 * @discussion It is required that any single permission request request (including initial log in) represent read-only
	 * permissions or publish permissions only; not both. The permissions passed here should reflect this requirement. If publish
	 * permissions are used, then the audience must also be specified.
	 */
	private static final Selector initWithAppID$permissions$defaultAudience$urlSchemeSuffix$tokenCacheStrategy$ = Selector
		.register("initWithAppID:permissions:defaultAudience:urlSchemeSuffix:tokenCacheStrategy:");

	@Bridge
	private native static @Pointer
	long objc_initWithAppID$permissions$defaultAudience$urlSchemeSuffix$tokenCacheStrategy$ (FBSession __self__, Selector __cmd__,
		String appID, NSArray<NSString> permissions, FBSessionDefaultAudience defaultAudience, String urlSchemeSuffix,
		FBSessionTokenCachingStrategy tokenCacheStrategy);

	public FBSession (String appID, NSArray<NSString> permissions, FBSessionDefaultAudience defaultAudience,
		String urlSchemeSuffix, FBSessionTokenCachingStrategy tokenCacheStrategy) {
		initObject(objc_initWithAppID$permissions$defaultAudience$urlSchemeSuffix$tokenCacheStrategy$(this,
			initWithAppID$permissions$defaultAudience$urlSchemeSuffix$tokenCacheStrategy$, appID, permissions, defaultAudience,
			urlSchemeSuffix, tokenCacheStrategy));
	}

	/* ! @abstract Indicates whether the session is open and ready for use. */
	private static final Selector isOpen = Selector.register("isOpen");

	@Bridge
	private native static boolean objc_isOpen (FBSession __self__, Selector __cmd__);

	public boolean isOpen () {
		return objc_isOpen(this, isOpen);
	}

	/* ! @abstract Detailed session state */
	private static final Selector state = Selector.register("state");

	@Bridge
	private native static FBSessionState objc_state (FBSession __self__, Selector __cmd__);

	public FBSessionState getState () {
		return objc_state(this, state);
	}

	/* ! @abstract Identifies the Facebook app which the session object represents. */
	// @property (readonly, copy) NSString *appID;
	private static final Selector appID = Selector.register("appID");

	@Bridge
	private native static String objc_appID (FBSession __self__, Selector __cmd__);

	public String getAppID () {
		return objc_appID(this, appID);
	}

	/*
	 * ! @abstract Identifies the URL Scheme Suffix used by the session. This is used when multiple iOS apps share a single
	 * Facebook app ID.
	 */
	private static final Selector urlSchemeSuffix = Selector.register("urlSchemeSuffix");

	@Bridge
	private native static String objc_urlSchemeSuffix (FBSession __self__, Selector __cmd__);

	public String getURLSchemeSuffix () {
		return objc_urlSchemeSuffix(this, urlSchemeSuffix);
	}

	/* ! @abstract The permissions granted to the access token during the authentication flow. */
	private static final Selector permissions = Selector.register("permissions");

	@Bridge
	private native static NSArray<NSString> objc_permissions (FBSession __self__, Selector __cmd__);

	public List<String> getPermissions () {
		NSArray<NSString> p = objc_permissions(this, permissions);
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < p.size(); i++) {
			list.add(p.get(i).toString());
		}
		return list;
	}

	/* ! @abstract Gets the FBAccessTokenData for the session */
	// @property (readonly, copy) FBAccessTokenData *accessTokenData;
	private static final Selector accessTokenData = Selector.register("accessTokenData");

	@Bridge
	private native static FBAccessTokenData objc_accessTokenData (FBSession __self__, Selector __cmd__);

	public FBAccessTokenData getAccessTokenData () {
		return objc_accessTokenData(this, accessTokenData);
	}

	/*
	 * !
	 * 
	 * @method
	 * 
	 * @abstract Opens a session for the Facebook.
	 * 
	 * @discussion A session may not be used with <FBRequest> and other classes in the SDK until it is open. If, prior to calling
	 * open, the session is in the <FBSessionStateCreatedTokenLoaded> state, then no UX occurs, and the session becomes available
	 * for use. If the session is in the <FBSessionStateCreated> state, prior to calling open, then a call to open causes login UX
	 * to occur, either via the Facebook application or via mobile Safari.
	 * 
	 * Open may be called at most once and must be called after the `FBSession` is initialized. Open must be called before the
	 * session is closed. Calling an open method at an invalid time will result in an exception. The open session methods may be
	 * passed a block that will be called back when the session state changes. The block will be released when the session is
	 * closed.
	 * 
	 * @param handler A block to call with the state changes. The default is nil.
	 */
	// - (void)openWithCompletionHandler:(FBSessionStateHandler)handler;
	private static final Selector openWithCompletionHandler$ = Selector.register("openWithCompletionHandler:");

	@Bridge
	private native static void objc_openWithCompletionHandler$ (FBSession __self__, Selector __cmd__, FBSessionStateHandler handler);

	public void open (FBSessionStateHandler stateHandler) {
		objc_openWithCompletionHandler$(this, openWithCompletionHandler$, stateHandler);
	}

	/*
	 * !
	 * 
	 * @method
	 * 
	 * @abstract Logs a user on to Facebook.
	 * 
	 * @discussion A session may not be used with <FBRequest> and other classes in the SDK until it is open. If, prior to calling
	 * open, the session is in the <FBSessionStateCreatedTokenLoaded> state, then no UX occurs, and the session becomes available
	 * for use. If the session is in the <FBSessionStateCreated> state, prior to calling open, then a call to open causes login UX
	 * to occur, either via the Facebook application or via mobile Safari.
	 * 
	 * The method may be called at most once and must be called after the `FBSession` is initialized. It must be called before the
	 * session is closed. Calling the method at an invalid time will result in an exception. The open session methods may be passed
	 * a block that will be called back when the session state changes. The block will be released when the session is closed.
	 * 
	 * @param behavior Controls whether to allow, force, or prohibit Facebook Login or Inline Facebook Login. The default is to
	 * allow Facebook Login, with fallback to Inline Facebook Login.
	 * 
	 * @param handler A block to call with session state changes. The default is nil.
	 */
	// - (void)openWithBehavior:(FBSessionLoginBehavior)behavior
	// completionHandler:(FBSessionStateHandler)handler;
	private static final Selector openWithBehavior$completionHandler$ = Selector.register("openWithBehavior:completionHandler:");

	@Bridge
	private native static void objc_openWithBehavior$completionHandler$ (FBSession __self__, Selector __cmd__,
		FBSessionLoginBehavior behavior, FBSessionStateHandler handler);

	public void open (FBSessionLoginBehavior behavior, FBSessionStateHandler stateHandler) {
		objc_openWithBehavior$completionHandler$(this, openWithBehavior$completionHandler$, behavior, stateHandler);
	}

	/*
	 * !
	 * 
	 * @method
	 * 
	 * @abstract Imports an existing access token and opens the session with it.
	 * 
	 * @discussion The method attempts to open the session using an existing access token. No UX will occur. If successful, the
	 * session with be in an Open state and the method will return YES; otherwise, NO.
	 * 
	 * The method may be called at most once and must be called after the `FBSession` is initialized (see below). It must be called
	 * before the session is closed. Calling the method at an invalid time will result in an exception. The open session methods
	 * may be passed a block that will be called back when the session state changes. The block will be released when the session
	 * is closed.
	 * 
	 * The initialized session must not have already been initialized from a cache (for example, you could use the
	 * `[FBSessionTokenCachingStrategy nullCacheInstance]` instance).
	 * 
	 * @param accessTokenData The token data. See `FBAccessTokenData` for construction methods.
	 * 
	 * @param handler A block to call with session state changes. The default is nil.
	 */
	// - (BOOL)openFromAccessTokenData:(FBAccessTokenData *)accessTokenData completionHandler:(FBSessionStateHandler) handler;

	/*
	 * !
	 * 
	 * @abstract Closes the local in-memory session object, but does not clear the persisted token cache.
	 */
	// - (void)close;
	private static final Selector close = Selector.register("close");

	@Bridge
	private native static void objc_close (FBSession __self__, Selector __cmd__);

	public void close () {
		objc_close(this, close);
	}

	/*
	 * !
	 * 
	 * @abstract Closes the in-memory session, and clears any persisted cache related to the session.
	 */
	// - (void)closeAndClearTokenInformation;
	private static final Selector closeAndClearTokenInformation = Selector.register("closeAndClearTokenInformation");

	@Bridge
	private native static void objc_closeAndClearTokenInformation (FBSession __self__, Selector __cmd__);

	public void close (boolean clearTokenInformation) {
		if (clearTokenInformation) {
			objc_closeAndClearTokenInformation(this, closeAndClearTokenInformation);
		} else {
			objc_close(this, close);
		}
	}

	/*
	 * !
	 * 
	 * @abstract Requests new or additional read permissions for the session.
	 * 
	 * @param readPermissions An array of strings representing the permissions to request during the authentication flow. A value
	 * of nil indicates basic permissions.
	 * 
	 * @param handler A block to call with session state changes. The default is nil.
	 * 
	 * @discussion The handler, if non-nil, is called once the operation has completed or failed. This is in contrast to the state
	 * completion handler used in <[FBSession openWithCompletionHandler:]> (and other `open*` methods) which is called for each
	 * state-change for the session.
	 */
	private static final Selector requestNewReadPermissions$completionHandler$ = Selector
		.register("requestNewReadPermissions:completionHandler:");

	@Bridge
	private native static void objc_requestNewReadPermissions$completionHandler$ (FBSession __self__, Selector __cmd__,
		NSArray<NSString> readPermissions, FBSessionRequestPermissionResultHandler handler);

	public void requestNewReadPermissions (List<String> readPermissions, FBSessionRequestPermissionResultHandler handler) {
		List<NSString> permissions = new ArrayList<NSString>();
		for (int i = 0; i < readPermissions.size(); i++) {
			permissions.add(new NSString(readPermissions.get(i)));
		}
		objc_requestNewReadPermissions$completionHandler$(this, requestNewReadPermissions$completionHandler$,
			new NSArray<NSString>(permissions), handler);
	}

	/*
	 * !
	 * 
	 * @abstract Requests new or additional write permissions for the session.
	 * 
	 * @param writePermissions An array of strings representing the permissions to request during the authentication flow.
	 * 
	 * @param defaultAudience Specifies the audience for posts.
	 * 
	 * @param handler A block to call with session state changes. The default is nil.
	 * 
	 * @discussion The handler, if non-nil, is called once the operation has completed or failed. This is in contrast to the state
	 * completion handler used in <[FBSession openWithCompletionHandler:]> (and other `open*` methods) which is called for each
	 * state-change for the session.
	 */
	private static final Selector requestNewPublishPermissions$defaultAudience$completionHandler$ = Selector
		.register("requestNewPublishPermissions:defaultAudience:completionHandler:");

	@Bridge
	private native static void objc_requestNewPublishPermissions$defaultAudience$completionHandler$ (FBSession __self__,
		Selector __cmd__, NSArray<NSString> publishPermissions, FBSessionDefaultAudience defaultAudience,
		FBSessionRequestPermissionResultHandler handler);

	public void requestNewPublishPermissions (List<String> publishPermissions, FBSessionDefaultAudience defaultAudience,
		FBSessionRequestPermissionResultHandler handler) {
		List<NSString> permissions = new ArrayList<NSString>();
		for (int i = 0; i < publishPermissions.size(); i++) {
			permissions.add(new NSString(publishPermissions.get(i)));
		}
		NSArray<NSString> p = new NSArray<NSString>(permissions);

		objc_requestNewPublishPermissions$defaultAudience$completionHandler$(this,
			requestNewPublishPermissions$defaultAudience$completionHandler$, p, defaultAudience, handler);
	}

	/*
	 * !
	 * 
	 * @abstract A helper method that is used to provide an implementation for [UIApplicationDelegate
	 * application:openURL:sourceApplication:annotation:]. It should be invoked during the Facebook Login flow and will update the
	 * session information based on the incoming URL.
	 * 
	 * @param url The URL as passed to [UIApplicationDelegate application:openURL:sourceApplication:annotation:].
	 */
	private static final Selector handleOpenURL$ = Selector.register("handleOpenURL:");

	@Bridge
	private native static boolean objc_handleOpenURL$ (FBSession __self__, Selector __cmd__, NSURL url);

	public boolean handleOpenURL (NSURL url) {
		return objc_handleOpenURL$(this, handleOpenURL$, url);
	}

	/*
	 * !
	 * 
	 * @abstract A helper method that is used to provide an implementation for [UIApplicationDelegate applicationDidBecomeActive:]
	 * to properly resolve session state for the Facebook Login flow, specifically to support app-switch login.
	 */
	private static final Selector handleDidBecomeActive = Selector.register("handleDidBecomeActive");

	@Bridge
	private native static void objc_handleDidBecomeActive (FBSession __self__, Selector __cmd__);

	public void handleDidBecomeActive () {
		objc_handleDidBecomeActive(this, handleDidBecomeActive);
	}

	/*
	 * !
	 * 
	 * @abstract Assign the block to be invoked for session state changes.
	 * 
	 * @discussion This will overwrite any state change handler that was already assigned. Typically, you should only use this
	 * setter if you were unable to assign a state change handler explicitly. One example of this is if you are not opening the
	 * session (e.g., using the `open*`) but still want to assign a `FBSessionStateHandler` block. This can happen when the SDK
	 * opens a session from an app link.
	 */
	// - (void)setStateChangeHandler:(FBSessionStateHandler)stateChangeHandler;
	private static final Selector setStateChangeHandler$ = Selector.register("setStateChangeHandler:");

	@Bridge
	private native static void objc_setStateChangeHandler$ (FBSession __self__, Selector __cmd__,
		FBSessionStateHandler stateChangeHandler);

	public void setStateChangeHandler (FBSessionStateHandler stateChangeHandler) {
		objc_setStateChangeHandler$(this, setStateChangeHandler$, stateChangeHandler);
	}

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
	 * user, and yet an open session is desired so long as a cached token can be used to open the session. Passing NO to this
	 * argument, assures the method will not present UI to the user in order to open the session.
	 * 
	 * @discussion Returns YES if the session was opened synchronously without presenting UI to the user. This occurs when there is
	 * a cached token available from a previous run of the application. If NO is returned, this indicates that the session was not
	 * immediately opened, via cache. However, if YES was passed as allowLoginUI, then it is possible that the user will login, and
	 * the session will become open asynchronously. The primary use for this return value is to switch-on facebook capabilities in
	 * your UX upon startup, in the case where the session is opened via cache.
	 */
	// + (BOOL)openActiveSessionWithAllowLoginUI:(BOOL)allowLoginUI;

	/*
	 * !
	 * 
	 * @abstract This is a simple method for opening a session with Facebook. Using sessionOpen logs on a user, and sets the static
	 * activeSession which becomes the default session object for any Facebook UI widgets used by the application. This session
	 * becomes the active session, whether open succeeds or fails.
	 * 
	 * @param readPermissions An array of strings representing the read permissions to request during the authentication flow. The
	 * basic_info permission must be explicitly requested at first login, and is no longer inferred, (subject to an active
	 * migration.) It is not allowed to pass publish permissions to this method.
	 * 
	 * @param allowLoginUI Sometimes it is useful to attempt to open a session, but only if no login UI will be required to
	 * accomplish the operation. For example, at application startup it may not be desirable to transition to login UI for the
	 * user, and yet an open session is desired so long as a cached token can be used to open the session. Passing NO to this
	 * argument, assures the method will not present UI to the user in order to open the session.
	 * 
	 * @param handler Many applications will benefit from notification when a session becomes invalid or undergoes other state
	 * transitions. If a block is provided, the FBSession object will call the block each time the session changes state.
	 * 
	 * @discussion Returns true if the session was opened synchronously without presenting UI to the user. This occurs when there
	 * is a cached token available from a previous run of the application. If NO is returned, this indicates that the session was
	 * not immediately opened, via cache. However, if YES was passed as allowLoginUI, then it is possible that the user will login,
	 * and the session will become open asynchronously. The primary use for this return value is to switch-on facebook capabilities
	 * in your UX upon startup, in the case where the session is opened via cache.
	 */
	// + (BOOL)openActiveSessionWithReadPermissions:(NSArray*)readPermissions
	// allowLoginUI:(BOOL)allowLoginUI
	// completionHandler:(FBSessionStateHandler)handler;
	private static final Selector openActiveSessionWithReadPermissions$allowLoginUI$completionHandler$ = Selector
		.register("openActiveSessionWithReadPermissions:allowLoginUI:completionHandler:");

	@Bridge
	private native static boolean objc_openActiveSessionWithReadPermissions$allowLoginUI$completionHandler$ (ObjCClass __self__,
		Selector __cmd__, NSArray<NSString> readPermissions, boolean allowLoginUI, FBSessionStateHandler stateChangeHandler);

	public static boolean openForRead (List<String> readPermissions, boolean allowLoginUI, FBSessionStateHandler stateChangeHandler) {
		List<NSString> permissions = new ArrayList<NSString>();
		for (int i = 0; i < readPermissions.size(); i++) {
			permissions.add(new NSString(readPermissions.get(i)));
		}

		return objc_openActiveSessionWithReadPermissions$allowLoginUI$completionHandler$(objCClass,
			openActiveSessionWithReadPermissions$allowLoginUI$completionHandler$, new NSArray<NSString>(permissions), allowLoginUI,
			stateChangeHandler);
	}

	/*
	 * !
	 * 
	 * @abstract This is a simple method for opening a session with Facebook. Using sessionOpen logs on a user, and sets the static
	 * activeSession which becomes the default session object for any Facebook UI widgets used by the application. This session
	 * becomes the active session, whether open succeeds or fails.
	 * 
	 * @param publishPermissions An array of strings representing the publish permissions to request during the authentication
	 * flow.
	 * 
	 * @param defaultAudience Anytime an app publishes on behalf of a user, the post must have an audience (e.g. me, my friends,
	 * etc.) The default audience is used to notify the user of the cieling that the user agrees to grant to the app for the
	 * provided permissions.
	 * 
	 * @param allowLoginUI Sometimes it is useful to attempt to open a session, but only if no login UI will be required to
	 * accomplish the operation. For example, at application startup it may not be desirable to transition to login UI for the
	 * user, and yet an open session is desired so long as a cached token can be used to open the session. Passing NO to this
	 * argument, assures the method will not present UI to the user in order to open the session.
	 * 
	 * @param handler Many applications will benefit from notification when a session becomes invalid or undergoes other state
	 * transitions. If a block is provided, the FBSession object will call the block each time the session changes state.
	 * 
	 * @discussion Returns true if the session was opened synchronously without presenting UI to the user. This occurs when there
	 * is a cached token available from a previous run of the application. If NO is returned, this indicates that the session was
	 * not immediately opened, via cache. However, if YES was passed as allowLoginUI, then it is possible that the user will login,
	 * and the session will become open asynchronously. The primary use for this return value is to switch-on facebook capabilities
	 * in your UX upon startup, in the case where the session is opened via cache.
	 */
	// + (BOOL)openActiveSessionWithPublishPermissions:(NSArray*)publishPermissions
	// defaultAudience:(FBSessionDefaultAudience)defaultAudience
	// allowLoginUI:(BOOL)allowLoginUI
	// completionHandler:(FBSessionStateHandler)handler;
	private static final Selector openActiveSessionWithPublishPermissions$defaultAudience$allowLoginUI$completionHandler$ = Selector
		.register("openActiveSessionWithPublishPermissions:defaultAudience:allowLoginUI:completionHandler:");

	@Bridge
	private native static boolean objc_openActiveSessionWithPublishPermissions$defaultAudience$allowLoginUI$completionHandler$ (
		ObjCClass __self__, Selector __cmd__, NSArray<NSString> publishPermissions, FBSessionDefaultAudience defaultAudience,
		boolean allowLoginUI, FBSessionStateHandler stateChangeHandler);

	public static boolean openForPublish (List<String> publishPermissions, FBSessionDefaultAudience defaultAudience,
		boolean allowLoginUI, FBSessionStateHandler stateChangeHandler) {
		List<NSString> permissions = new ArrayList<NSString>();
		for (int i = 0; i < publishPermissions.size(); i++) {
			permissions.add(new NSString(publishPermissions.get(i)));
		}

		return objc_openActiveSessionWithPublishPermissions$defaultAudience$allowLoginUI$completionHandler$(objCClass,
			openActiveSessionWithPublishPermissions$defaultAudience$allowLoginUI$completionHandler$, new NSArray<NSString>(
				permissions), defaultAudience, allowLoginUI, stateChangeHandler);
	}

	/*
	 * !
	 * 
	 * @abstract An application may get or set the current active session. Certain high-level components in the SDK will use the
	 * activeSession to set default session (e.g. `FBLoginView`, `FBFriendPickerViewController`)
	 * 
	 * @discussion If sessionOpen* is called, the resulting `FBSession` object also becomes the activeSession. If another session
	 * was active at the time, it is closed automatically. If activeSession is called when no session is active, a session object
	 * is instatiated and returned; in this case open must be called on the session in order for it to be useable for communication
	 * with Facebook.
	 */
	private static final Selector activeSession = Selector.register("activeSession");

	@Bridge
	private native static FBSession objc_activeSession (ObjCClass __self__, Selector __cmd__);

	public static FBSession getActiveSession () {
		return objc_activeSession(objCClass, activeSession);
	}

	/*
	 * !
	 * 
	 * @abstract An application may get or set the current active session. Certain high-level components in the SDK will use the
	 * activeSession to set default session (e.g. `FBLoginView`, `FBFriendPickerViewController`)
	 * 
	 * @param session The FBSession object to become the active session
	 * 
	 * @discussion If an application prefers the flexibilility of directly instantiating a session object, an active session can be
	 * set directly.
	 */
	private static final Selector setActiveSession$ = Selector.register("setActiveSession:");

	@Bridge
	private native static FBSession objc_setActiveSession$ (ObjCClass __self__, Selector __cmd__, FBSession session);

	public static FBSession setActiveSession (FBSession session) {
		return objc_setActiveSession$(objCClass, setActiveSession$, session);
	}

	/*
	 * !
	 * 
	 * @method
	 * 
	 * @abstract Issues an asychronous renewCredentialsForAccount call to the device Facebook account store.
	 * 
	 * @param handler The completion handler to call when the renewal is completed. The handler will be invoked on the main thread.
	 * 
	 * @discussion This can be used to explicitly renew account credentials on iOS 6 devices and is provided as a convenience
	 * wrapper around `[ACAccountStore renewCredentialsForAccount:completion]`. Note the method will not issue the renewal call if
	 * the the Facebook account has not been set on the device, or if access had not been granted to the account (though the
	 * handler wil receive an error).
	 * 
	 * This is safe to call (and will surface an error to the handler) on versions of iOS before 6 or if the user logged in via
	 * Safari or Facebook SSO.
	 */
	// + (void)renewSystemCredentials:(FBSessionRenewSystemCredentialsHandler)handler;

	/** Builder class used to create a Session. */
	public static final class Builder {
		private String applicationId;
		private FBSessionTokenCachingStrategy tokenCachingStrategy;
		private FBSessionDefaultAudience defaultAudience = FBSessionDefaultAudience.Friends;

		public Builder () {
		}

		/** Sets the application id for the Session.
		 * 
		 * @param applicationId the application id
		 * @return the Builder instance */
		public Builder setApplicationId (final String applicationId) {
			this.applicationId = applicationId;
			return this;
		}

		/** Sets the TokenCachingStrategy for the Session.
		 * 
		 * @param tokenCachingStrategy the token cache to use
		 * @return the Builder instance */
		public Builder setTokenCachingStrategy (final FBSessionTokenCachingStrategy tokenCachingStrategy) {
			this.tokenCachingStrategy = tokenCachingStrategy;
			return this;
		}

		public Builder setDefaultAudience (final FBSessionDefaultAudience defaultAudience) {
			this.defaultAudience = defaultAudience;
			return this;
		}

		// TODO permissions, urlschemeprefix

		/** Build the Session.
		 * 
		 * @return a new Session */
		public FBSession build () {
			return new FBSession(applicationId, null, defaultAudience, "", tokenCachingStrategy);
		}
	}
}
