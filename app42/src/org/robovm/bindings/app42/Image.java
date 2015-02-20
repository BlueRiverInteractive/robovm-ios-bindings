package org.robovm.bindings.app42;

import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class Image extends App42Response
{
	@Property(selector = "name")
	public native String getName();

	@Property(selector = "setName:", strongRef = true)
	public native void setName(String name);

	@Property(selector = "action")
	public native String getAction();

	@Property(selector = "setAction:", strongRef = true)
	public native void setAction(String action);

	@Property(selector = "originalImage")
	public native String getOriginalImage();

	@Property(selector = "setOriginalImage:", strongRef = true)
	public native void setOriginalImage(String originalImage);

	@Property(selector = "convertedImage")
	public native String getConvertedImage();

	@Property(selector = "setConvertedImage:", strongRef = true)
	public native void setConvertedImage(String convertedImage);

	@Property(selector = "originalImageTinyUrl")
	public native String getOriginalImageTinyUrl();

	@Property(selector = "setOriginalImageTinyUrl:", strongRef = true)
	public native void setOriginalImageTinyUrl(String originalImageTinyUrl);
	
	@Property(selector = "convertedImageTinyUrl")
	public native String getConvertedImageTinyUrl();

	@Property(selector = "setConvertedImageTinyUrl:", strongRef = true)
	public native void setConvertedImageTinyUrl(String convertedImageTinyUrl);

	@Property(selector = "percentage")
	public native double getPercentage();

	@Property(selector = "setPercentage:", strongRef = true)
	public native void setPercentage(double percentage);

	@Property(selector = "width")
	public native int getWidth();

	@Property(selector = "setWidth:", strongRef = true)
	public native void setWidth(int width);
	
	@Property(selector = "height")
	public native int getHeight();

	@Property(selector = "setHeight:", strongRef = true)
	public native void setHeight(int height);
	
	@Property(selector = "x")
	public native int getX();

	@Property(selector = "setX:", strongRef = true)
	public native void setX(int x);

	@Property(selector = "y")
	public native int getY();

	@Property(selector = "setY:", strongRef = true)
	public native void setY(int y);
}
