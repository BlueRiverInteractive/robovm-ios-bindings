
package org.robovm.bindings.gpp;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSString;
import org.robovm.cocoatouch.foundation.NSURL;
import org.robovm.cocoatouch.uikit.UIApplication;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
@NativeClass()
public class GPPURLHandler extends NSObject {
	private static final ObjCClass objCClass = ObjCClass.getByType(GPPURLHandler.class);

	static {
		ObjCRuntime.bind(GPPURLHandler.class);
	}

	// Calls |handleURL:sourceApplication:annotation:| for
	// |[GPPSignIn sharedInstance]|, |[GPPShare sharedInstance]|, and
	// |GPPDeepLink|, and returns |YES| if any of them handles the URL.
	// This method can be called from your |UIApplicationDelegate|'s
	// |application:openURL:sourceApplication:annotation| instead of calling
	// those methods individually.
	// + (BOOL)handleURL:(NSURL *)url sourceApplication:(NSString *)sourceApplication annotation:(id)annotation;
	private static final Selector handleURL$ = Selector.register("handleURL:sourceApplication:annotation:");

	@Bridge
	private native static boolean objc_handleURL (ObjCClass __self__, Selector __cmd__, NSURL url, String sourceApplication,
		NSObject annotation);

	public static boolean handleURL (NSURL url, String sourceApplication, NSObject annotation) {
		return objc_handleURL(objCClass, handleURL$, url, sourceApplication, annotation);
	}

	/*
	 * // + ( void ) configureWithAppID:( String * )appID zoneIDs:( NSArray * )zoneIDs delegate:( id<AdColonyDelegate> )del
	 * logging:( // BOOL )log; private static final Selector configureWithAppID$zoneIDs$delegate$logging = Selector
	 * .register("configureWithAppID:zoneIDs:delegate:logging:");
	 */
}
