package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class FacebookProfile extends NSObject
{
	@Property(selector = "name")
	public native String getName();

	@Property(selector = "setName:", strongRef = true)
	public native void setName(String name);
	
	@Property(selector = "fbId")
	public native String getFbId();

	@Property(selector = "setFbId:", strongRef = true)
	public native void setFbId(String fbId);
	
	@Property(selector = "picture")
	public native String getPicture();

	@Property(selector = "setPicture:", strongRef = true)
	public native void setPicture(String picture);

	@Property(selector = "scoreObj")
	public native Score getScoreObj();

	@Property(selector = "setScoreObj:", strongRef = true)
	public native void setScore(Score score);

	public FacebookProfile(Score score) {
		super((SkipInit) null);
	    initObject(init(score));
	}
	
	@Method(selector = "initWithScore:")
	private native @Pointer long init(Score score);
}
