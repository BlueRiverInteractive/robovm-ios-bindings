package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSData;
import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class ItemData extends NSObject
{
	@Property(selector = "price")
	public native double getPrice();

	@Property(selector = "setPrice:", strongRef = true)
	public native void setPrice(double price);

	@Property(selector = "itemId")
	public native String getItemId();

	@Property(selector = "setItemId:", strongRef = true)
	public native void setItemId(String itemId);
	
	@Property(selector = "name")
	public native String getName();

	@Property(selector = "setName:", strongRef = true)
	public native void setName(String name);
	
	@Property(selector = "image")
	public native String getImage();

	@Property(selector = "setImage:", strongRef = true)
	public native void setImage(String image);
	
	@Property(selector = "description")
	public native String getDescription();

	@Property(selector = "setDescription:", strongRef = true)
	public native void setDescription(String description);
	
	@Property(selector = "imageInputStream")
	public native NSData getImageInputStream();

	@Property(selector = "setImageInputStream:", strongRef = true)
	public native void setImageInputStream(NSData imageInputStream);
	
	@Property(selector = "imageName")
	public native String getImageName();

	@Property(selector = "setImageName:", strongRef = true)
	public native void setImageName(String imageName);
}
