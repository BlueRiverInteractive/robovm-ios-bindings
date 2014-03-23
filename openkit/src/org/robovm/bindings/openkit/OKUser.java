
package org.robovm.bindings.openkit;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class OKUser extends NSObject {

	@Method(selector = "currentUser")
	public static native OKUser getCurrentUser ();

	@Method(selector = "logoutCurrentUserFromOpenKit")
	public static native void logoutCurrentUser ();

// @property (nonatomic, strong) NSNumber *OKUserID;
// @property (nonatomic, strong) NSString *customID;
	@Property(selector = "fbUserID")
	public native String getFBUserID ();

	@Property
	public native String getUserNick ();
}
