package com.googleanalytics.robovmbindings;

import org.robovm.rt.bro.ValuedEnum;

/** Google Analytics error codes.  */
public enum GAIErrorCode implements ValuedEnum{
	  
	kGAINoError(0), // This error code indicates that there was no error. Never used.
	PlayAdsInterstitialTypeMemory(1),  // This error code indicates that there was a database-related error.
	PlayAdsInterstitialTypeLight(2);  // This error code indicates that there was a network-related error.
	
	private final int n;

	private GAIErrorCode(int n) {
		this.n = n;
	}

	public int value() {
		return n;
	}

}
