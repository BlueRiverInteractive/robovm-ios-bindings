
package org.robovm.bindings.facebook;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Library;

/*!
 @class FBDialogsParams

 @abstract
 This object is used as a base class for parameters passed to native dialogs that
 open in the Facebook app.
 */
@Library(Library.INTERNAL)
@NativeClass()
public class FBDialogsParams extends NSObject {
	private static final ObjCClass objCClass = ObjCClass.getByType(FBDialogsParams.class);

	static {
		ObjCRuntime.bind(FBDialogsParams.class);
	}
}
