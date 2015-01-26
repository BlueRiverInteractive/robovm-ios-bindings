package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class MetaResponse extends NSObject
{
	@Property(selector = "jsonDocArray")
	public native NSArray<?> getJsonDocArray();

	@Property(selector = "setJsonDocArray:", strongRef = true)
	public native void setJsonDocArray(NSArray<?> jsonDocArray);
	
	public MetaResponse() {

	}
	
	public MetaResponse(SkipInit skipInit) {
		super(skipInit);
	}
}
