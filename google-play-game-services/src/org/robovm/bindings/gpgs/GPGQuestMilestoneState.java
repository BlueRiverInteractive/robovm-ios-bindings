package org.robovm.bindings.gpgs;

import org.robovm.rt.bro.ValuedEnum;

public enum GPGQuestMilestoneState implements ValuedEnum {
	GPGQuestMilestoneStateNotStarted(0),
	GPGQuestMilestoneStateNotCompleted(1),
	GPGQuestMilestoneStateCompletedNotClaimed(2),
	GPGQuestMilestoneStateClaimed(3);

	private final long n;

	private GPGQuestMilestoneState (long n) {
	  this.n = n;
	}

	@Override
	public long value () {
	  return n;
	}
}
