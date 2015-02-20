package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSDate;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class Score extends MetaResponse
{
	@Property(selector = "userName")
	public native String getUserName();

	@Property(selector = "setUserName:", strongRef = true)
	public native void setUserName(String userName);

	@Property(selector = "rank")
	public native String getRank();

	@Property(selector = "setRank:", strongRef = true)
	public native void setRank(String rank);

	@Property(selector = "createdOn")
	public native NSDate getCreatedOn();

	@Property(selector = "setCreatedOn:", strongRef = true)
	public native void setCreatedOn(NSDate createdOn);

	@Property(selector = "scoreId")
	public native String getScoreId();

	@Property(selector = "setScoreId:", strongRef = true)
	public native void setScoreId(String scoreId);
	
	@Property(selector = "value")
	public native double getValue();

	@Property(selector = "setValue:", strongRef = true)
	public native void setValue(double value);

	@Property(selector = "gameObject")
	public native Game getGame();

	@Property(selector = "setGameObject:", strongRef = true)
	public native void setGame(Game game);

	@Property(selector = "facebookProfile")
	public native FacebookProfile getFacebookProfile();

	@Property(selector = "setFacebookProfile:", strongRef = true)
	public native void setFacebookProfile(FacebookProfile facebookProfile);

	public Score(Game game) {
		super((SkipInit) null);
	    initObject(init(game));
	}
	
	@Method(selector = "initWithGame:")
	private native @Pointer long init(Game game);
}
