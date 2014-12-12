
package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass()
public class GPGLeaderboard extends NSObject {

	@Method(selector = "initWithLeaderboardId:")
	private native @Pointer long init(String leaderboardId);
	
	public GPGLeaderboard(String leaderboardId) {
	    super((SkipInit)null);
	    initObject(init(leaderboardId));
	}
	
	@Method(selector = "leaderboardWithId:")
	public native static GPGLeaderboard getLeaderboardWithId(String leaderboardId);
	
	@Property(selector = "leaderboardId")
	public native String getLeaderboardId();
	
	@Property(selector = "personalWindow")
	public native boolean isPersonalWindow();
	
	@Property(selector = "setPersonalWindow:")
	public native void setPersonalWindow(boolean isPersonalWindow);
	
	@Property(selector = "timeScope")
	public native GPGLeaderboardTimeScope getTimeScope();
	
	@Property(selector = "setTimeScope:")
	public native void setTimeScope(GPGLeaderboardTimeScope timeScope);
	
	@Property(selector = "social")
	public native boolean isSocial();
	
	@Property(selector = "setSocial:")
	public native void setSocial(boolean isSocial);
	
	@Method(selector = "loadScoresWithCompletionHandler:")
	public native void loadScoresWithCompletionHandler(@Block GPGLeaderboardLoadScoresBlock completionHandler);
	
	@Method(selector = "loadScoresFromDataSource:completionHandler:")
	public native void loadScoresFromDataSource(GPGDataSource dataSource, @Block GPGLeaderboardLoadScoresBlock completionHandler);

	@Method(selector = "loadNextPageOfScoresWithCompletionHandler:")
	public native void loadNextPageOfScoresWithCompletionHandler(@Block GPGLeaderboardLoadScoresBlock completionHandler);
	
	@Method(selector = "loadPreviousPageOfScoresWithCompletionHandler:")
	public native void loadPreviousPageOfScoresWithCompletionHandler(@Block GPGLeaderboardLoadScoresBlock completionHandler);
	
	@Method(selector = "resetScoreWithCompletionHandler:")
	public native void resetScoreWithCompletionHandler(@Block GPGScoreResetBlock completionHandler);

	@Property(selector = "loading")
	public native boolean isLoading();
	
	@Property(selector = "loadingPreviousPage")
	public native boolean getLoadingPreviousPage();
	
	@Property(selector = "loadingNextPage")
	public native boolean getLoadingNextPage();

	@Property(selector = "scores")
	public native NSArray getScores();
	
	@Property(selector = "localPlayerScore")
	public native GPGLocalPlayerScore getLocalPlayerScore();
	
	@Property(selector = "name")
	public native String getName();
	
	@Property(selector = "hasPreviousPage")
	public native boolean hasPreviousPage();

	@Property(selector = "hasNextPage")
	public native boolean hasNextPage();
}
