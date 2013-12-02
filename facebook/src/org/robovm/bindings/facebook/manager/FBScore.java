
package org.robovm.bindings.facebook.manager;

public class FBScore {
	private final int score;
	private final FBProfile profile;

	public FBScore (FBProfile profile, int score) {
		this.profile = profile;
		this.score = score;
	}

	public int getScore () {
		return score;
	}

	public FBProfile getProfile () {
		return profile;
	}
}
