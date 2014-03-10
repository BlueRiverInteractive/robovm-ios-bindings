package org.robovm.bindings.playhaven;

import org.robovm.rt.bro.ValuedEnum;

public enum PHPublisherContentRequestState implements ValuedEnum {

	PHPublisherContentRequestInitialized(0), 
	PHPublisherContentRequestPreloading(1), 
	PHPublisherContentRequestPreloaded(2), 
	PHPublisherContentRequestDisplayingContent(3), 
	PHPublisherContentRequestDone(4);

	private final long n;

	private PHPublisherContentRequestState (long n) {
		this.n = n;
	}

	@Override
	public long value () {
		return n;
	}

}
