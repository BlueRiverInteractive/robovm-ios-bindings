package org.robovm.bindings.gpgs;

import org.robovm.rt.bro.ValuedEnum;

public enum GPGQuestState implements ValuedEnum {
	GPGQuestStateUpcoming(0),
	GPGQuestStateOpen(1),
	GPGQuestStateAccepted(2),
	GPGQuestStateCompleted(3),
	GPGQuestStateExpired(4),
	GPGQuestStateFailed(5);

	private final long n;

	private GPGQuestState (long n) {
	  this.n = n;
	}

	@Override
	public long value () {
	  return n;
	}
}
