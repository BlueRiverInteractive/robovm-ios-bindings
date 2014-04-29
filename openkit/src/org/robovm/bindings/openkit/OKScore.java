
package org.robovm.bindings.openkit;

import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;
import org.robovm.rt.bro.annotation.MachineSizedSInt;

@NativeClass
public class OKScore extends NSObject {
	@Method(selector = "submitScoreWithCompletionHandler:")
	public native void submitScore (@Block OKScoreRequestResponseHandler completionHandler);

	@Method(selector = "forceSubmitScoreWithCompletionHandler:")
	public native void forceSubmitScore (@Block OKScoreRequestResponseHandler completionHandler);

	@Property(selector = "scoreValue")
	public native long getScoreValue ();

	@Property(selector = "setScoreValue:")
	public native void setScoreValue (long score);

	@Property(selector = "user")
	public native OKUser getOKUser ();

	@Property(selector = "setUser:")
	public native void setOKUser (OKUser user);

	@Property(selector = "scoreRank")
	public native @MachineSizedSInt
	long getRank ();

	@Property(selector = "setOKLeaderboardID:")
	public native void setOKLeaderboardID (@MachineSizedSInt long leaderboardID);

	@Method(selector = "setChallengeEnabled:")
	public native void setChallengeEnabled (boolean enabled);
}
