package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSMutableArray;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class Game extends App42Response
{
	@Property(selector = "name")
	public native String getName();

	@Property(selector = "setName:", strongRef = true)
	public native void setName(String name);
	
	@Property(selector = "description")
	public native String getDescription();

	@Property(selector = "setDescription:", strongRef = true)
	public native void setDescription(String description);
	
	@Property(selector = "scoreList")
	public native NSMutableArray<?> getScoreList();

	@Property(selector = "setScoreList:", strongRef = true)
	public native void setScoreList(NSMutableArray<?> scoreList);
}
