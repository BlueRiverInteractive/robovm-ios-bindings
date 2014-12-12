package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;

@NativeClass()
public class GPGRealTimeRoomCreationHandle extends NSObject {

	@Method(selector = "cancel")
	public native boolean cancel();
	
}
