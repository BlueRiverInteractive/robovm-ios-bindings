
package org.robovm.bindings.openkit;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.objc.ObjCBlock;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
@NativeClass()
public class OKScore extends NSObject {
	private static final ObjCClass objCClass = ObjCClass.getByType(OKScore.class);

	static {
		ObjCRuntime.bind(OKScore.class);
	}

	public void submitScore (OKScoreRequestResponseHandler completionHandler) {
		objc_submitScoreWithCompletionHandler$(this, submitScoreWithCompletionHandler$,
			OKScoreRequestResponseHandler.Marshaler.toObjCBlock(completionHandler));
	}

	private static final Selector submitScoreWithCompletionHandler$ = Selector.register("submitScoreWithCompletionHandler:");

	@Bridge
	private native static void objc_submitScoreWithCompletionHandler$ (OKScore __self__, Selector __cmd__,
		ObjCBlock completionHandler);

	public long getScoreValue () {
		return objc_scoreValue(this, scoreValue);
	}

	private static final Selector scoreValue = Selector.register("scoreValue");

	@Bridge
	private native static long objc_scoreValue (OKScore __self__, Selector __cmd__);

	public void setScoreValue (long score) {
		objc_setScoreValue$(this, setScoreValue$, score);
	}

	private static final Selector setScoreValue$ = Selector.register("setScoreValue:");

	@Bridge
	private native static void objc_setScoreValue$ (OKScore __self__, Selector __cmd__, long score);

	public OKUser getOKUser () {
		return objc_user(this, user);
	}

	private static final Selector user = Selector.register("user");

	@Bridge
	private native static OKUser objc_user (OKScore __self__, Selector __cmd__);

	public void setOKUser (OKUser user) {
		objc_setUser$(this, setUser$, user);
	}

	private static final Selector setUser$ = Selector.register("setUser:");

	@Bridge
	private native static void objc_setUser$ (OKScore __self__, Selector __cmd__, OKUser user);

	public int getRank () {
		return objc_scoreRank(this, scoreRank);
	}

	private static final Selector scoreRank = Selector.register("scoreRank");

	@Bridge
	private native static int objc_scoreRank (OKScore __self__, Selector __cmd__);

	public void setOKLeaderboardID (int leaderboardID) {
		objc_setOKLeaderboardID(this, setOKLeaderboardID$, leaderboardID);
	}

	private static final Selector setOKLeaderboardID$ = Selector.register("setOKLeaderboardID:");

	@Bridge
	private native static void objc_setOKLeaderboardID (OKScore __self__, Selector __cmd__, int leaderboardID);

	public void setChallengeEnabled (boolean enabled) {
		objc_setChallengeEnabled$(this, setChallengeEnabled$, enabled);
	}

	private static final Selector setChallengeEnabled$ = Selector.register("setChallengeEnabled:");

	@Bridge
	private native static void objc_setChallengeEnabled$ (OKScore __self__, Selector __cmd__, boolean enabled);
}
