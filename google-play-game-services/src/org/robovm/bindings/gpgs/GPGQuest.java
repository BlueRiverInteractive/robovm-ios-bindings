package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.foundation.NSURL;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class GPGQuest extends NSObject {

	@Property(selector = "questId")
	public native String getQuestId();
	
	@Property(selector = "name")
	public native String getName();
	
	@Property(selector = "questDescription")
	public native String getQuestDescription();
	
	@Property(selector = "iconUrl")
	public native NSURL getIconUrl();
	
	@Property(selector = "bannerUrl")
	public native NSURL getBannerUrl();
	
	@Property(selector = "currentMilestone")
	public native GPGQuestMilestone getCurrentMilestone();
	
	@Property(selector = "state")
	public native GPGQuestState getState();
	
	@Property(selector = "startTimestamp")
	public native long getStartTimestamp();
	
	@Property(selector = "expirationTimestamp")
	public native long getExpirationTimestamp();
	
	@Property(selector = "acceptedTimestamp")
	public native long getAcceptedTimestamp();
	
	@Method(selector = "fetchQuestWithId:completionHandler:")
	public static native void fetchQuestWithId(String questId, @Block GPGQuestFetchBlock completionHandler);
	
	@Method(selector = "allQuestsWithCompletionHandler:")
	public static native void allQuestsWithCompletionHandler(@Block GPGQuestListBlock completionHandler);
	
	@Method(selector = "allQuestsFromDataSource:completionHandler")
	public static native void allQuestsFromDataSource(GPGDataSource dataSource, @Block GPGQuestListBlock completionHandler);
	
	@Method(selector = "questsForState:completionHandler")
	public static native void questsForState(GPGQuestState state, @Block GPGQuestListBlock completionHandler);
	
	@Method(selector = "acceptWithCompletionHandler:")
	public native void acceptWithCompletionHandler(@Block GPGQuestCompletionBlock completionHandler);
}
