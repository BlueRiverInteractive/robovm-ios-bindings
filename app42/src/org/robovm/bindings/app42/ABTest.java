package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSMutableArray;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class ABTest extends App42Response
{
	@Property(selector = "isActive")
	public native boolean isActive();

	@Property(selector = "setActive:", strongRef = true)
	public native void setActive(boolean isActive);

	@Property(selector = "name")
	public native String getName();

	@Property(selector = "setName:", strongRef = true)
	public native void setName(String name);
	
	@Property(selector = "type")
	public native String getType();

	@Property(selector = "setType:", strongRef = true)
	public native void setType(String type);
	
	@Property(selector = "variantList")
	public native NSMutableArray<?> getVariantList();

	@Property(selector = "setVariantList:", strongRef = true)
	public native void setVariantList(NSMutableArray<?> variantList);
}
