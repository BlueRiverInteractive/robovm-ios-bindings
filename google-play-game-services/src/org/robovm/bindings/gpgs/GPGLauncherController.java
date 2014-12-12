package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class GPGLauncherController extends NSObject {

	@Method(selector = "sharedInstance")
	public static native GPGLauncherController sharedInstance();
	
	@Property(selector = "launcherDelegate")
	public native GPGLauncherDelegate getLauncherDelegate();
	
	@Property(selector = "setLauncherDelegate:", strongRef = true)
	public native void setLauncherDelegate(GPGLauncherDelegate launcherDelegate);
	
	@Property(selector = "playerPickerLauncherDelegate")
	public native GPGPlayerPickerLauncherDelegate getPlayerPickerLauncherDelegate();
	
	@Property(selector = "setPlayerPickerLauncherDelegate:", strongRef = true)
	public native void setPlayerPickerLauncherDelegate(GPGPlayerPickerLauncherDelegate playerPickerLauncherDelegate);
	
	@Property(selector = "turnBasedMatchListLauncherDelegate")
	public native GPGTurnBasedMatchListLauncherDelegate getTurnBasedMatchListLauncherDelegate();
	
	@Property(selector = "setTurnBasedMatchListLauncherDelegate:", strongRef = true)
	public native void setTurnBasedMatchListLauncherDelegate(GPGTurnBasedMatchListLauncherDelegate turnBasedMatchListLauncherDelegate);
	
	@Property(selector = "questListLauncherDelegate")
	public native GPGQuestListLauncherDelegate getQuestListLauncherDelegate();
	
	@Property(selector = "setQuestListLauncherDelegate:", strongRef = true)
	public native void setQuestListLauncherDelegate(GPGQuestListLauncherDelegate questListLauncherDelegate);
	
	@Property(selector = "snapshotListLauncherDelegate")
	public native GPGSnapshotListLauncherDelegate getSnapshotListLauncherDelegate();
	
	@Property(selector = "setSnapshotListLauncherDelegate:", strongRef = true)
	public native void setSnapshotListLauncherDelegate(GPGSnapshotListLauncherDelegate snapshotListLauncherDelegate);
	
	@Property(selector = "presentingLauncherType")
	public native GPGLauncherType getPresentingLauncherType();
	
	@Method(selector = "presentPlayerPicker")
	public native void presentPlayerPicker();
	
	@Method(selector = "presentTurnBasedMatchList")
	public native void presentTurnBasedMatchList();

	@Method(selector = "presentTurnBasedMatchListWithMatches:")
	public native void presentTurnBasedMatchListWithMatches(NSArray matches);
	
	@Method(selector = "presentQuestList")
	public native void presentQuestList();
	
	@Method(selector = "presentQuestListWithQuestId:")
	public native void presentQuestListWithQuestId(String questId);
	
	@Method(selector = "presentSnapshotList")
	public native void presentSnapshotList();
	
	@Method(selector = "presentLeaderboardWithLeaderboardId:")
	public native void presentLeaderboardWithLeaderboardId(String leaderboardId);
	
	@Method(selector = "presentLeaderboardList")
	public native void presentLeaderboardList();
	
	@Method(selector = "presentAchievementList")
	public native void presentAchievementList();
	
	@Method(selector = "presentRealTimeInvitesWithRoomDataList:")
	public native void presentRealTimeInvitesWithRoomDataList(NSArray roomDataList);
	
	@Method(selector = "presentRealTimeInviteWithMinPlayers:maxPlayers:exclusiveBitMask:variant:")
	public native void presentRealTimeInviteWithMinPlayers(int minPlayers, int maxPlayers, long exclusiveBitMask, int variant);                         
	                           
	@Method(selector = "presentRealTimeInviteWithMinPlayers:maxPlayers:")
	public native void presentRealTimeInviteWithMinPlayers(int minPlayers, int maxPlayers);  
	
	@Method(selector = "presentRealTimeWaitingRoomWithConfig:")
	public native void presentRealTimeWaitingRoomWithConfig(GPGMultiplayerConfig config);  
	
	@Method(selector = "presentRealTimeWaitingRoomWithRoomData:")
	public native void presentRealTimeWaitingRoomWithRoomData(GPGRealTimeRoomData roomData); 
	
	@Method(selector = "presentSettings")
	public native void presentSettings();
	
	@Method(selector = "dismissAnimated:completionHandler:")
	public native void dismissAnimated(boolean animated, GPGLauncherDelegate completionHandler); 
}
