package org.robovm.bindings.greystripe;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSString;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
@NativeClass

public class GSAd extends NSObject {
	
	static {
		ObjCRuntime.bind(GSAd.class);
	}
	
	/**
	 * A BOOL indicating whether an ad has been fetched and is ready to be displayed.
	 *
	 * @return a BOOL indicating whether or not the ad is ready to be displayed
	 */
	public boolean isAdReady() {
		return objc_isAdReady(this, isAdReady);
	}
	
	//- (BOOL)isAdReady;
	private static final Selector isAdReady = Selector.register("isAdReady");
	
	@Bridge
	private native static final boolean objc_isAdReady(GSAd __self__, Selector __cmd__);

	/**
	 * Attempts to fetch a new ad. This should only be called if there is not already a 
	 * valid ad ready to be displayed.
	 */
	public void fetch() {
		objc_fetch(this, fetch);
	}
	//- (void)fetch;
	private static final Selector fetch = Selector.register("fetch");
	
	@Bridge
	private native static final void objc_fetch(GSAd __self__, Selector __cmd__);

	//- (NSString *)adID;
	public String getAdID() {
		NSString val = objc_adID(this, adID);
		
		return val == null ? null : val.toString();
	}
	private static final Selector adID = Selector.register("adID");
	
	@Bridge
	private native static final NSString objc_adID(GSAd __self__, Selector __cmd__);
	
}
