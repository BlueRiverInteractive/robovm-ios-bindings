package org.robovm.bindings.playhaven;

import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
@NativeClass()
public class PHPublisherOpenRequest extends PHAPIRequest{
	private static final ObjCClass objCClass = ObjCClass.getByType(PHPublisherOpenRequest.class);

	static {
		ObjCRuntime.bind(PHPublisherOpenRequest.class);
	}

}
