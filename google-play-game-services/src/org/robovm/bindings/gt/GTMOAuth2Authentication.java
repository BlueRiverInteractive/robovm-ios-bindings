
package org.robovm.bindings.gt;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
@NativeClass()
public class GTMOAuth2Authentication extends NSObject {
	private static final ObjCClass objCClass = ObjCClass.getByType(GTMOAuth2Authentication.class);

	static {
		ObjCRuntime.bind(GTMOAuth2Authentication.class);
	}
}
