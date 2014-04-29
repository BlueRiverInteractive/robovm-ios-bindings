
package org.robovm.bindings.openkit;

import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;

@NativeClass
public class OKFacebookUtilities extends NSObject {
	@Method(selector = "AuthorizeUserWithFacebookWithCompletionHandler:")
	public static native void authorizeUserWithFacebook (@Block OKLoginCompletionHandler completionHandler);

	@Method(selector = "GetCurrentFacebookUsersIDAndCreateOKUserWithCompletionhandler:")
	public static native void createOKUser (@Block OKCreateFacebookUserCompletionHandler completionHandler);
}
