
package org.robovm.bindings.facebook;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
@NativeClass()
public class FBAppCall extends NSObject {
	private static final ObjCClass objCClass = ObjCClass.getByType(FBAppCall.class);

	static {
		ObjCRuntime.bind(FBAppCall.class);
	}
}
