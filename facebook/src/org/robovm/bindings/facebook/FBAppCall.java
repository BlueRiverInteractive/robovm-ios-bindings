
package org.robovm.bindings.facebook;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSString;
import org.robovm.cocoatouch.foundation.NSURL;
import org.robovm.objc.ObjCBlock;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
@NativeClass()
public class FBAppCall extends NSObject {
	private static final ObjCClass objCClass = ObjCClass.getByType(FBAppCall.class);

	static {
		ObjCRuntime.bind(FBAppCall.class);
	}

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
