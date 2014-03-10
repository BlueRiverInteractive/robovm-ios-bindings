package org.robovm.bindings.admob;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
@NativeClass()
public class GADCustomEventRequest extends NSObject{
	private static final ObjCClass objCClass = ObjCClass.getByType(GADCustomEventRequest.class);

	static{
		ObjCRuntime.bind(GADCustomEventRequest.class);
	}
	
	//TODO: Hacer el resto de bindings

}
