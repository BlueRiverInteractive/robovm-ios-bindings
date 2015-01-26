package org.robovm.bindings.app42;

import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class Reward extends App42Response
{
	@Property(selector = "gameName")
	public native String getGameName();

	@Property(selector = "setGameName:", strongRef = true)
	public native void setGameName(String gameName);
	
	@Property(selector = "userName")
	public native String getUserName();

	@Property(selector = "setUserName:", strongRef = true)
	public native void setUserName(String userName);
	
	@Property(selector = "name")
	public native String getName();

	@Property(selector = "setName:", strongRef = true)
	public native void setName(String name);
	
	@Property(selector = "description")
	public native String getDescription();

	@Property(selector = "setDescription:", strongRef = true)
	public native void setDescription(String description);
	
	@Property(selector = "points")
	public native double getPoints();

	@Property(selector = "setPoints:", strongRef = true)
	public native void setPoints(double points);

	@Property(selector = "rank")
	public native double getRank();

	@Property(selector = "setRank:", strongRef = true)
	public native void setRank(double rank);
}
