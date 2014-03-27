
package org.robovm.bindings.facebook;

import org.robovm.apple.foundation.NSError;
import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.foundation.NSURL;
import org.robovm.apple.uikit.UIApplication;
import org.robovm.apple.uikit.UIApplicationDelegate;
import org.robovm.bindings.facebook.dialogs.FBDialogsData;
import org.robovm.bindings.facebook.session.FBSession;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

/** The FBAppCall object is used to encapsulate state when the app performs an action that requires switching over to the native
 * Facebook app, or when the app receives an App Link.
 * 
 * <ul>
 * <li>Each FBAppCall instance will have a unique ID</li>
 * <li>This object is passed into an FBAppCallHandler for context</li>
 * <li>dialogData will be present if this AppCall is for a Native Dialog</li>
 * <li>appLinkData will be present if this AppCall is for an App Link</li>
 * <li>accessTokenData will be present if this AppCall contains an access token.</li>
 * </ul> */
@NativeClass
public class FBAppCall extends NSObject {
	/** @return the ID of this FBAppCall instance. */
	@Property
	public native String getID ();

	/** @return error that occurred in processing this AppCall. */
	@Property
	public native NSError getError ();

	/** @return data related to a Dialog AppCall. */
	@Property
	public native FBDialogsData getDialogData ();

	/** @return data for native app link. */
	@Property
	public native FBAppLinkData getAppLinkData ();

	/** @return access Token that was returned in this AppCall. */
	@Property
	public native FBAccessTokenData getAccessTokenData ();

	/** Returns an FBAppCall instance from a url, if applicable. Otherwise, returns {@code null}.
	 * @param url The url.
	 * @return an FBAppCall instance if the url is valid; nil otherwise. This is typically used for App Link URLs. */
	@Method(selector = "appCallFromURL:")
	public static native FBAppCall createAppCall (NSURL url);

	/** Compares the receiving FBAppCall to the passed in FBAppCall.
	 * @param appCall the other FBAppCall to compare to.
	 * @return {@code true} if the AppCalls can be considered to be the same; {@code false} if otherwise. */
	@Method(selector = "isEqualToAppCall:")
	public native boolean equals (FBAppCall appCall);

	/** Call this method from the {@link UIApplicationDelegate#openURL(UIApplication, NSURL, String, NSObject)} method of the
	 * AppDelegate for your app. It should be invoked for the proper processing of responses during interaction with the native
	 * Facebook app or as part of SSO authorization flow.
	 * 
	 * @param url The URL as passed to {@link UIApplicationDelegate#openURL(UIApplication, NSURL, String, NSObject)}.
	 * @param sourceApplication The sourceApplication as passed to
	 *           {@link UIApplicationDelegate#openURL(UIApplication, NSURL, String, NSObject)}.
	 * @return {@code true} if the url was intended for the Facebook SDK, {@code false} if not. */
	@Method(selector = "handleOpenURL:sourceApplication:")
	public static native boolean handleOpenURL (NSURL url, String sourceApplication);

	/** Call this method from the {@link UIApplicationDelegate#openURL(UIApplication, NSURL, String, NSObject)} method of the
	 * AppDelegate for your app. It should be invoked for the proper processing of responses during interaction with the native
	 * Facebook app or as part of SSO authorization flow.
	 * 
	 * @param url The URL as passed to {@link UIApplicationDelegate#openURL(UIApplication, NSURL, String, NSObject)}.
	 * @param sourceApplication The sourceApplication as passed to
	 *           {@link UIApplicationDelegate#openURL(UIApplication, NSURL, String, NSObject)}.
	 * @param handler Optional handler that gives the app the opportunity to do some further processing on urls that the SDK could
	 *           not completely process. A fallback handler is not a requirement for such a url to be considered handled. The
	 *           fallback handler, if specified, is only ever called synchronously, before the method returns.
	 * 
	 * @return {@code true} if the url was intended for the Facebook SDK, {@code false} if not. */
	@Method(selector = "handleOpenURL:sourceApplication:fallbackHandler:")
	public static native boolean handleOpenURL (NSURL url, String sourceApplication, @Block FBAppCallHandler handler);

	/** Call this method from the {@link UIApplicationDelegate#openURL(UIApplication, NSURL, String, NSObject)} method of the
	 * AppDelegate for your app. It should be invoked for the proper processing of responses during interaction with the native
	 * Facebook app or as part of SSO authorization flow.
	 * 
	 * @param url The URL as passed to {@link UIApplicationDelegate#openURL(UIApplication, NSURL, String, NSObject)}.
	 * 
	 * @param sourceApplication The sourceApplication as passed to
	 *           {@link UIApplicationDelegate#openURL(UIApplication, NSURL, String, NSObject)}.
	 * @param session If this url is being sent back to this app as part of SSO authorization flow, then pass in the session that
	 *           was being opened. A nil value defaults to FBSession.activeSession
	 * 
	 * @return {@code true} if the url was intended for the Facebook SDK, {@code false} if not. */
	@Method(selector = "handleOpenURL:sourceApplication:withSession:")
	public static native boolean handleOpenURL (NSURL url, String sourceApplication, FBSession session);

	/** Call this method from the {@link UIApplicationDelegate#openURL(UIApplication, NSURL, String, NSObject)} method of the
	 * AppDelegate for your app. It should be invoked for the proper processing of responses during interaction with the native
	 * Facebook app or as part of SSO authorization flow.
	 * @param url The URL as passed to {@link UIApplicationDelegate#openURL(UIApplication, NSURL, String, NSObject)}.
	 * @param sourceApplication The sourceApplication as passed to
	 *           {@link UIApplicationDelegate#openURL(UIApplication, NSURL, String, NSObject)}.
	 * @param session If this url is being sent back to this app as part of SSO authorization flow, then pass in the session that
	 *           was being opened. A nil value defaults to FBSession.activeSession
	 * @param handler Optional handler that gives the app the opportunity to do some further processing on urls that the SDK could
	 *           not completely process. A fallback handler is not a requirement for such a url to be considered handled. The
	 *           fallback handler, if specified, is only ever called sychronously, before the method returns.
	 * @return {@code true} if the url was intended for the Facebook SDK, {@code false} if not. */
	@Method(selector = "handleOpenURL:sourceApplication:withSession:fallbackHandler:")
	public static native boolean handleOpenURL (NSURL url, String sourceApplication, FBSession session,
		@Block FBAppCallHandler handler);

	/** Call this method when the application's {@link UIApplicationDelegate#didBecomeActive(UIApplication)} is invoked. This
	 * ensures proper state management of any pending FBAppCalls or pending login flow for the FBSession.activeSession. If any
	 * pending FBAppCalls are found, their registered callbacks will be invoked with appropriate state */
	@Method(selector = "handleDidBecomeActive")
	public static native void handleDidBecomeActive ();

	/** Call this method when the application's {@link UIApplicationDelegate#didBecomeActive(UIApplication)} is invoked. This
	 * ensures proper state management of any pending FBAppCalls or a pending open for the passed in FBSession. If any pending
	 * FBAppCalls are found, their registered callbacks will be invoked with appropriate state
	 * @param session Session that is currently being used. Any pending calls to open will be cancelled. If no session is provided,
	 *           then the activeSession (if present) is used. */
	@Method(selector = "handleDidBecomeActiveWithSession:")
	public static native void handleDidBecomeActive (FBSession session);

	/** Call this method from the main thread to fetch deferred applink data. This may require a network round trip. If successful,
	 * {@link UIApplication#openURL(NSURL)} is invoked with the link data. Otherwise, the fallbackHandler will be dispatched to the
	 * main thread.
	 * @param fallbackHandler the handler to be invoked if applink data could not be opened.
	 * 
	 *           the fallbackHandler may contain an NSError instance to capture any errors. In the common case where there simply
	 *           was no app link data, the NSError instance will be {@code null}.
	 * 
	 *           This method should only be called from a location that occurs after any launching URL has been processed (e.g.,
	 *           you should call this method from your application delegate's applicationDidBecomeActive:) to avoid duplicate
	 *           invocations of openURL:.
	 * 
	 *           If you must call this from the delegate's didFinishLaunchingWithOptions: you should only do so if the application
	 *           is not being launched by a URL. For example,
	 * 
	 *           if (launchOptions[UIApplicationLaunchOptionsURLKey] == nil) { [FBAppCall openDeferredAppLink:^(NSError *error) {
	 *           // .... } } */
	@Method(selector = "openDeferredAppLink:")
	public static native void openDeferredAppLink (@Block FBAppLinkFallbackHandler fallbackHandler);
}
