package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSMutableArray;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class Recommender extends App42Response
{
	@Property(selector = "fileName")
	public native String getFileName();

	@Property(selector = "setFileName:", strongRef = true)
	public native void setFileName(String fileName);

	@Property(selector = "recommendedItemList")
	public native NSMutableArray<?> getRecommendedItemList();

	@Property(selector = "setRecommendedItemList:", strongRef = true)
	public native void setRecommendedItemList(NSMutableArray<?> recommendedItemList);
}
