
package org.robovm.bindings.facebook;

import org.robovm.bindings.facebook.session.FBSession;
import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSString;
import org.robovm.cocoatouch.foundation.NSURL;
import org.robovm.objc.ObjCBlock;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;

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
	private static final ObjCClass objCClass = ObjCClass.getByType(FBAppCall.class);

// /*! @abstract The ID of this FBAppCall instance */
// @property (nonatomic, readonly) NSString *ID;
//
// /*! @abstract Error that occurred in processing this AppCall */
// @property (nonatomic, readonly) NSError *error;
//
// /*! @abstract Data related to a Dialog AppCall */
// @property (nonatomic, readonly) FBDialogsData *dialogData;
//
// /*! @abstract Data for native app link */
// @property (nonatomic, readonly) FBAppLinkData *appLinkData;
//
// /*! @abstract Access Token that was returned in this AppCall */
// @property (nonatomic, readonly) FBAccessTokenData *accessTokenData;
//
// /*!
// @abstract
// Returns an FBAppCall instance from a url, if applicable. Otherwise, returns nil.
//
// @param url The url.
//
// @return an FBAppCall instance if the url is valid; nil otherwise.
//
// @discussion This is typically used for App Link URLs.
// */
// + (FBAppCall *) appCallFromURL:(NSURL *)url;
//
// /*!
// @abstract
// Compares the receiving FBAppCall to the passed in FBAppCall
//
// @param appCall the other FBAppCall to compare to.
//
// @return YES if the AppCalls can be considered to be the same; NO if otherwise.
// */
// - (BOOL)isEqualToAppCall:(FBAppCall *)appCall;
//
// /*!
// @abstract
// Call this method from the [UIApplicationDelegate application:openURL:sourceApplication:annotation:] method
// of the AppDelegate for your app. It should be invoked for the proper processing of responses during interaction
// with the native Facebook app or as part of SSO authorization flow.
//
// @param url The URL as passed to [UIApplicationDelegate application:openURL:sourceApplication:annotation:].
//
// @param sourceApplication The sourceApplication as passed to [UIApplicationDelegate
// application:openURL:sourceApplication:annotation:].
//
// @return YES if the url was intended for the Facebook SDK, NO if not.
// */
// + (BOOL)handleOpenURL:(NSURL *)url
// sourceApplication:(NSString *)sourceApplication;
//
// /*!
// @abstract
// Call this method from the [UIApplicationDelegate application:openURL:sourceApplication:annotation:] method
// of the AppDelegate for your app. It should be invoked for the proper processing of responses during interaction
// with the native Facebook app or as part of SSO authorization flow.
//
// @param url The URL as passed to [UIApplicationDelegate application:openURL:sourceApplication:annotation:].
//
// @param sourceApplication The sourceApplication as passed to [UIApplicationDelegate
// application:openURL:sourceApplication:annotation:].
//
// @param handler Optional handler that gives the app the opportunity to do some further processing on urls
// that the SDK could not completely process. A fallback handler is not a requirement for such a url to be considered
// handled. The fallback handler, if specified, is only ever called sychronously, before the method returns.
//
// @return YES if the url was intended for the Facebook SDK, NO if not.
// */
// + (BOOL)handleOpenURL:(NSURL *)url
// sourceApplication:(NSString *)sourceApplication
// fallbackHandler:(FBAppCallHandler)handler;
//
// /*!
// @abstract
// Call this method from the [UIApplicationDelegate application:openURL:sourceApplication:annotation:] method
// of the AppDelegate for your app. It should be invoked for the proper processing of responses during interaction
// with the native Facebook app or as part of SSO authorization flow.
//
// @param url The URL as passed to [UIApplicationDelegate application:openURL:sourceApplication:annotation:].
//
// @param sourceApplication The sourceApplication as passed to [UIApplicationDelegate
// application:openURL:sourceApplication:annotation:].
//
// @param session If this url is being sent back to this app as part of SSO authorization flow, then pass in the
// session that was being opened. A nil value defaults to FBSession.activeSession
//
// @return YES if the url was intended for the Facebook SDK, NO if not.
// */
// + (BOOL)handleOpenURL:(NSURL *)url
// sourceApplication:(NSString *)sourceApplication
// withSession:(FBSession *)session;
//
// /*!
// @abstract
// Call this method from the [UIApplicationDelegate application:openURL:sourceApplication:annotation:] method
// of the AppDelegate for your app. It should be invoked for the proper processing of responses during interaction
// with the native Facebook app or as part of SSO authorization flow.
//
// @param url The URL as passed to [UIApplicationDelegate application:openURL:sourceApplication:annotation:].
//
// @param sourceApplication The sourceApplication as passed to [UIApplicationDelegate
// application:openURL:sourceApplication:annotation:].
//
// @param session If this url is being sent back to this app as part of SSO authorization flow, then pass in the
// session that was being opened. A nil value defaults to FBSession.activeSession
//
// @param handler Optional handler that gives the app the opportunity to do some further processing on urls
// that the SDK could not completely process. A fallback handler is not a requirement for such a url to be considered
// handled. The fallback handler, if specified, is only ever called sychronously, before the method returns.
//
// @return YES if the url was intended for the Facebook SDK, NO if not.
// */
// + (BOOL)handleOpenURL:(NSURL *)url
// sourceApplication:(NSString *)sourceApplication
// withSession:(FBSession *)session
// fallbackHandler:(FBAppCallHandler)handler;
//
// /*!
// @abstract
// Call this method when the application's applicationDidBecomeActive: is invoked.
// This ensures proper state management of any pending FBAppCalls or pending login flow for the
// FBSession.activeSession. If any pending FBAppCalls are found, their registered callbacks
// will be invoked with appropriate state
// */
// + (void)handleDidBecomeActive;
//
// /*!
// @abstract
// Call this method when the application's applicationDidBecomeActive: is invoked.
// This ensures proper state management of any pending FBAppCalls or a pending open for the
// passed in FBSession. If any pending FBAppCalls are found, their registered callbacks will
// be invoked with appropriate state
//
// @param session Session that is currently being used. Any pending calls to open will be cancelled.
// If no session is provided, then the activeSession (if present) is used.
// */
// + (void)handleDidBecomeActiveWithSession:(FBSession *)session;
//
// /*!
// @abstract
// Call this method from the main thread to fetch deferred applink data. This may require
// a network round trip. If successful, [+UIApplication openURL:] is invoked with the link
// data. Otherwise, the fallbackHandler will be dispatched to the main thread.
//
// @param fallbackHandler the handler to be invoked if applink data could not be opened.
//
// @discussion the fallbackHandler may contain an NSError instance to capture any errors. In the
// common case where there simply was no app link data, the NSError instance will be nil.
//
// This method should only be called from a location that occurs after any launching URL has
// been processed (e.g., you should call this method from your application delegate's applicationDidBecomeActive:)
// to avoid duplicate invocations of openURL:.
//
// If you must call this from the delegate's didFinishLaunchingWithOptions: you should
// only do so if the application is not being launched by a URL. For example,
//
// if (launchOptions[UIApplicationLaunchOptionsURLKey] == nil) {
// [FBAppCall openDeferredAppLink:^(NSError *error) {
// // ....
// }
// }
// */
// + (void)openDeferredAppLink:(FBAppLinkFallbackHandler)fallbackHandler;

	public static boolean handleOpenURL (NSURL url, String sourceApplication) {
		return objc_handleOpenURL(objCClass, handleOpenURL$sourceApplication$, url, new NSString(sourceApplication));
	}

	private static final Selector handleOpenURL$sourceApplication$ = Selector.register("handleOpenURL:sourceApplication:");

	@Bridge
	private native static boolean objc_handleOpenURL (ObjCClass __self__, Selector __cmd__, NSURL url, NSString sourceApplication);

	public static boolean handleOpenURL (NSURL url, String sourceApplication, FBSession session) {
		return objc_handleOpenURL(objCClass, handleOpenURL$sourceApplication$withSession$, url, new NSString(sourceApplication),
			session);
	}

	private static final Selector handleOpenURL$sourceApplication$withSession$ = Selector
		.register("handleOpenURL:sourceApplication:withSession:");

	@Bridge
	private native static boolean objc_handleOpenURL (ObjCClass __self__, Selector __cmd__, NSURL url, NSString sourceApplication,
		FBSession session);

	/*
	 * !
	 * 
	 * @abstract Call this method from the [UIApplicationDelegate application:openURL:sourceApplication:annotation:] method of the
	 * AppDelegate for your app. It should be invoked for the proper processing of responses during interaction with the native
	 * Facebook app or as part of SSO authorization flow.
	 * 
	 * @param url The URL as passed to [UIApplicationDelegate application:openURL:sourceApplication:annotation:].
	 * 
	 * @param sourceApplication The sourceApplication as passed to [UIApplicationDelegate
	 * application:openURL:sourceApplication:annotation:].
	 * 
	 * @param handler Optional handler that gives the app the opportunity to do some further processing on urls that the SDK could
	 * not completely process. A fallback handler is not a requirement for such a url to be considered handled. The fallback
	 * handler, if specified, is only ever called sychronously, before the method returns.
	 * 
	 * @return YES if the url was intended for the Facebook SDK, NO if not.
	 */
	public static boolean handleOpenURL (NSURL url, String sourceApplication, FBAppCallHandler handler) {
		return objc_handleOpenURL$sourceApplication$fallbackHandler$(objCClass, handleOpenURL$sourceApplication$fallbackHandler$,
			url, sourceApplication, FBAppCallHandler.Marshaler.toObjCBlock(handler));
	}

	private static final Selector handleOpenURL$sourceApplication$fallbackHandler$ = Selector
		.register("handleOpenURL:sourceApplication:fallbackHandler:");

	@Bridge
	private native static boolean objc_handleOpenURL$sourceApplication$fallbackHandler$ (ObjCClass __self__, Selector __cmd__,
		NSURL url, String sourceApplication, ObjCBlock handler);

	/** Data for native app link. */
	public FBAppLinkData getAppLinkData () {
		return objc_appLinkData(this, appLinkData);
	}

	private static final Selector appLinkData = Selector.register("appLinkData");

	@Bridge
	private native static FBAppLinkData objc_appLinkData (FBAppCall __self__, Selector __cmd__);

	/** Access Token that was returned in this AppCall. */
	public FBAccessTokenData getAccessTokenData () {
		return objc_accessTokenData(this, accessTokenData);
	}

	private static final Selector accessTokenData = Selector.register("accessTokenData");

	@Bridge
	private native static FBAccessTokenData objc_accessTokenData (FBAppCall __self__, Selector __cmd__);
}
