package org.robovm.bindings.app42;

import org.robovm.rt.bro.ValuedEnum;

public enum App42CachePolicy implements ValuedEnum 
{
	APP42_NO_CACHE(0),
	APP42_NETWORK_FIRST(1),
	APP42_CACHE_FIRST(2);

	private final long n;

	private App42CachePolicy (long n) {
		this.n = n;
	}

	@Override
	public long value () {
		return n;
	}
}
