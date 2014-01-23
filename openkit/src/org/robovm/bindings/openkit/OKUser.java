
package org.robovm.bindings.openkit;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
@NativeClass()
public class OKUser extends NSObject {
	private static final ObjCClass objCClass = ObjCClass.getByType(OKUser.class);

	static {
		ObjCRuntime.bind(OKUser.class);
	}

	public static OKUser getCurrentUser () {
		return objc_currentUser(objCClass, currentUser);
	}

	private static final Selector currentUser = Selector.register("currentUser");

	@Bridge
	private native static OKUser objc_currentUser (ObjCClass __self__, Selector __cmd__);

	public static void logoutCurrentUser () {
		objc_logoutCurrentUserFromOpenKit(objCClass, logoutCurrentUserFromOpenKit);
	}

	private static final Selector logoutCurrentUserFromOpenKit = Selector.register("logoutCurrentUserFromOpenKit");

	@Bridge
	private native static void objc_logoutCurrentUserFromOpenKit (ObjCClass __self__, Selector __cmd__);

// @property (nonatomic, strong) NSNumber *OKUserID;
// @property (nonatomic, strong) NSString *customID;
	public String getFBUserID () {
		return objc_fbUserID(this, fbUserID);
	}

	private static final Selector fbUserID = Selector.register("fbUserID");

	@Bridge
	private native static String objc_fbUserID (OKUser __self__, Selector __cmd__);

	public String getUserNick () {
		return objc_userNick(this, userNick);
	}

	private static final Selector userNick = Selector.register("userNick");

	@Bridge
	private native static String objc_userNick (OKUser __self__, Selector __cmd__);
}
