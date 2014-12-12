package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSNumber;
import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
@NativeClass()
public class GPGAppStateListInfo extends NSObject {

	@Property(selector = "dataIsStale")
	public native boolean getDataIsStale();
	@Property(selector = "setDataIsStale:", strongRef = true)
	public native void setDataIsStale(boolean dataIsStale);

	@Property(selector = "key")
	public native NSNumber getKey();
	@Property(selector = "setKey:")
	public native void setKey(NSNumber dataIsStale);
}
