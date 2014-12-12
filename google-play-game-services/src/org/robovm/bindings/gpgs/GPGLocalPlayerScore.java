
package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass()
public class GPGLocalPlayerScore extends NSObject {

	@Property(selector = "publicRank")
	public native GPGLocalPlayerRank getPublicRank();
	
	@Property(selector = "leaderboardId")
	public native String getLeaderboardId();
	
	@Property(selector = "scoreString")
	public native String getScoreString();
	
	@Property(selector = "scoreValue")
	public native long getScoreValue();
	
	@Property(selector = "scoreTag")
	public native String getScoreTag();
	
	@Property(selector = "socialRank")
	public native GPGLocalPlayerRank getSocialRank();

	@Property(selector = "writeTimestamp")
	public native long getWriteTimestamp();
}
