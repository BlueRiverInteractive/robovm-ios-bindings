
package org.robovm.bindings.facebook;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSString;
import org.robovm.cocoatouch.foundation.NSURL;
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

	private static final Selector handleOpenURL$sourceApplication$ = Selector.register("handleOpenURL:sourceApplication:");

	@Bridge
	private native static boolean objc_handleOpenURL (ObjCClass __self__, Selector __cmd__, NSURL url, NSString sourceApplication);

	public static boolean handleOpenURL (NSURL url, String sourceApplication) {
		return objc_handleOpenURL(objCClass, handleOpenURL$sourceApplication$, url, new NSString(sourceApplication));
	}

	private static final Selector handleOpenURL$sourceApplication$withSession$ = Selector
		.register("handleOpenURL:sourceApplication:withSession:");

	@Bridge
	private native static boolean objc_handleOpenURL (ObjCClass __self__, Selector __cmd__, NSURL url, NSString sourceApplication,
		FBSession session);

	public static boolean handleOpenURL (NSURL url, String sourceApplication, FBSession session) {
		return objc_handleOpenURL(objCClass, handleOpenURL$sourceApplication$withSession$, url, new NSString(sourceApplication),
			session);
	}
}
