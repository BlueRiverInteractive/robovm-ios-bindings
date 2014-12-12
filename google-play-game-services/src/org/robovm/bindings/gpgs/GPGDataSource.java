package org.robovm.bindings.gpgs;

import org.robovm.rt.bro.ValuedEnum;

public enum GPGDataSource implements ValuedEnum {
	GPGDataSourceCacheOrNetwork(0), 
	GPGDataSourceNetwork(1);

	private final long n;

	private GPGDataSource (long n) {
		this.n = n;
	}

	@Override
	public long value () {
		return n;
	}
}
