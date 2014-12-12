package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSData;
import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;
import org.robovm.rt.bro.annotation.MachineSizedSInt;

@NativeClass
public class GPGQuestMilestone extends NSObject {

	@Property(selector = "questMilestoneId")
	public native String getQuestMilestoneId();
	
	@Property(selector = "questId")
	public native String getQuestId();
	
	@Property(selector = "eventId")
	public native String getEventId();
	
	@Property(selector = "state")
	public native GPGQuestMilestoneState getStated();
	
	@Property(selector = "currentCount")
	public native @MachineSizedSInt long getCurrentCount();

	@Property(selector = "targetCount")
	public native @MachineSizedSInt long getTargetCount();
	
	@Property(selector = "rewardData")
	public native NSData getRewardData();

	@Method(selector = "claimWithCompletionHandler:")
	public native void claimWithCompletionHandler(@Block GPGQuestCompletionBlock completionHandler);
}
