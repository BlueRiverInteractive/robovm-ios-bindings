package org.robovm.bindings.admob;

import org.robovm.rt.bro.ValuedEnum;

/**
 * NSError codes for GAD error domain.
 */
public enum GADRequestError implements ValuedEnum{
	kGADErrorInvalidRequest(0), // The ad request is invalid.  The localizedFailureReason error description will have more details.  Typically this is because the ad did not have the ad unit ID or root view controller set.
	kGADErrorNoFill(1),   // The ad request was successful, but no ad was returned.
	kGADErrorNetworkError(2),   // There was an error loading data from the network.
	kGADErrorServerError(3),   // The ad server experienced a failure processing the request.
	kGADErrorOSVersionTooLow(4),   // The current device's OS is below the minimum required version.
	kGADErrorTimeout(5),   // The request was unable to be loaded before being timed out.
	kGADErrorInterstitialAlreadyUsed(6),   // Will not send request because the interstitial object has already been used.
	kGADErrorMediationDataError(7),   // The mediation response was invalid.
	kGADErrorMediationAdapterError(8),   // Error finding or creating a mediation ad network adapter.
	kGADErrorMediationNoFill(9),   // The mediation request was successful, but no ad was returned from any ad networks.
	kGADErrorMediationInvalidAdSize(10)   // Attempting to pass an invalid ad size to an adapter.
	;

	private final long n;
	
	private GADRequestError(long n){
		this.n = n;
	}
	
	@Override
	public long value(){
		return n;
	}
}
