
package org.robovm.bindings.openkit;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;
import org.robovm.rt.bro.annotation.Bridge;

@NativeClass
public class OKScore extends NSObject {
	@Method(selector = "submitScoreWithCompletionHandler:")
	public native void submitScore (/* @Block */OKScoreRequestResponseHandler completionHandler);

	@Property(selector = "scoreValue")
	public native long getScoreValue ();

	@Property(selector = "setScoreValue:")
	public native void setScoreValue (long score);

	@Property(selector = "user")
	public native OKUser getOKUser ();

	@Property(selector = "setUser:")
	public native void setOKUser (OKUser user);

	@Property(selector = "scoreRank")
	public native int getRank ();

	@Property(selector = "setOKLeaderboardID:")
	public native void setOKLeaderboardID (int leaderboardID);

	@Bridge
	private native static void objc_setOKLeaderboardID (OKScore __self__, Selector __cmd__, int leaderboardID);

	@Method(selector = "setChallengeEnabled:")
	public native void setChallengeEnabled (boolean enabled);
}
