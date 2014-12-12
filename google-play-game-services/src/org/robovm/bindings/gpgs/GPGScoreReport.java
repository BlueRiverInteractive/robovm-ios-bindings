
package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass()
public class GPGScoreReport extends NSObject {

	@Property(selector = "isHighScoreForLocalPlayerToday")
	public native boolean isHighScoreForLocalPlayerToday();
	
	@Property(selector = "isHighScoreForLocalPlayerThisWeek")
	public native boolean isHighScoreForLocalPlayerThisWeek();
	
	@Property(selector = "isHighScoreForLocalPlayerAllTime")
	public native boolean isHighScoreForLocalPlayerAllTime();
	
	@Property(selector = "leaderboardId")
	public native String getLeaderboardId();
	
	@Property(selector = "reportedScoreValue")
	public native long getReportedScoreValue();
	
	@Property(selector = "highScoreForLocalPlayerToday")
	public native GPGScore getHighScoreForLocalPlayerToday();
	
	@Property(selector = "highScoreForLocalPlayerThisWeek")
	public native GPGScore getHighScoreForLocalPlayerThisWeek();
	
	@Property(selector = "highScoreForLocalPlayerAllTime")
	public native GPGScore getHighScoreForLocalPlayerAllTime();
}
