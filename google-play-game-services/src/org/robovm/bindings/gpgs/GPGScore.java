
package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.foundation.NSString;
import org.robovm.apple.foundation.NSURL;
import org.robovm.objc.ObjCBlock;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass()
public class GPGScore extends NSObject {

	@Method(selector = "initWithLeaderboardId:")
	private native @Pointer long init(String leaderboardId);
	
	public GPGScore(String leaderboardId) {
	    super((SkipInit)null);
	    initObject(init(leaderboardId));
	}
	
	@Method(selector = "scoreWithLeaderboardId:")
	private static native GPGScore sgetScoreWithLeaderboardId(String leaderboardId);
	
	@Property(selector = "leaderboardId")
	public native String getLeaderboardId();

	@Property(selector = "value")
	public native long getValue();
	
	@Property(selector = "setValue:", strongRef = true)
	public native void setValue(long value);
	
	@Property(selector = "scoreTag")
	public native String getScoreTag();
	
	@Property(selector = "setScoreTag:", strongRef = true)
	public native void setScoreTag(String scoreTag);

	@Method(selector = "submitScoreWithCompletionHandler:")
	public native boolean submitScoreWithCompletionHandler(@Block GPGScoreReportScoreBlock completionHandler);
	
	@Method(selector = "batchSubmitScores:completionHandler:")
	public native void batchSubmitScores(NSArray scores, @Block GPGScoreReportScoreBlock completionHandler);

	@Deprecated
	@Property(selector = "avatarUrl")
	public native NSURL getAvatarUrl();
	
	@Deprecated
	@Property(selector = "displayName")
	public native String getDisplayName();
	
	@Property(selector = "formattedRank")
	public native String getFormattedRank();
	
	@Property(selector = "formattedScore")
	public native String getFormattedScore();
	
	@Deprecated
	@Property(selector = "playerId")
	public native String getPlayerId();
	
	@Property(selector = "player")
	public native GPGPlayer getPlayer();
	
	@Property(selector = "rank")
	public native long getRank();
	
	@Property(selector = "timeSpan")
	public native String getTimeSpan();

	@Property(selector = "writeTimestamp")
	public native long getWriteTimestamp();
}
