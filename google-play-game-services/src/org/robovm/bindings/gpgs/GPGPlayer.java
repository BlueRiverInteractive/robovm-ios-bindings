
package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.foundation.NSURL;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;
import org.robovm.rt.bro.annotation.MachineSizedUInt;

@Library(Library.INTERNAL)
@NativeClass()
public class GPGPlayer extends NSObject {
	
	@Property(selector = "imageUrl")
	public native NSURL getImageUrl();
	
	@Property(selector = "displayName")
	public native String getDisplayName();
	
	@Property(selector = "playerId")
	public native String getPlayerId();
	
	@Property(selector = "title")
	public native String getTitle();
	
	@Property(selector = "currentExperiencePoints")
	public native long getCurrentExperiencePoints();
	
	@Property(selector = "lastLevelUpTimestamp")
	public native long getLastLevelUpTimestamp();
	
	@Property(selector = "currentLevel")
	public native GPGPlayerLevel getCurrentLevel();
	
	@Property(selector = "nextLevel")
	public native GPGPlayerLevel getNextLevel();

	@Method(selector = "localPlayerWithCompletionHandler:")
	public static native void localPlayerWithCompletionHandler(@Block GPGPlayerGetBlock completionHandler);
	
	@Method(selector = "localPlayerFromDataSource:completionHandler:")
	public static native void localPlayerFromDataSource(GPGDataSource dataSource, @Block GPGPlayerGetBlock completionHandler);
	
	@Method(selector = "recentlyPlayedPlayersWithCompletionHandler:")
	public static native void recentlyPlayedPlayersWithCompletionHandler(@Block GPGPlayersGetBlock completionHandler);
	
	@Method(selector = "recentlyPlayedPlayersFromDataSource:completionHandler:")
	public static native void recentlyPlayedPlayersFromDataSource(GPGDataSource dataSource, @Block GPGPlayersGetBlock completionHandler);
	
	@Method(selector = "connectedPlayersWithCompletionHandler:")
	public static native void connectedPlayersWithCompletionHandler(@Block GPGPlayersGetBlock completionHandler);
	
	@Method(selector = "connectedPlayersFromDataSource:")
	public static native void connectedPlayersFromDataSource(GPGDataSource dataSource, @Block GPGPlayersGetBlock completionHandler);
}
