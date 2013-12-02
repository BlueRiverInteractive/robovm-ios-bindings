
package org.robovm.bindings.gpgs;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
@NativeClass()
public class GPGGameMetadataModel extends NSObject {
	private static final ObjCClass objCClass = ObjCClass.getByType(GPGGameMetadataModel.class);

	static {
		ObjCRuntime.bind(GPGGameMetadataModel.class);
	}
}
