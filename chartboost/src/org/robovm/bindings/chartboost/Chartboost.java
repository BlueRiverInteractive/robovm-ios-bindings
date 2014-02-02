package org.robovm.bindings.chartboost;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.ObjCSuper;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
@NativeClass()
public class Chartboost extends NSObject {
	private static final ObjCClass objCClass = ObjCClass.getByType(Chartboost.class);

	static {
		ObjCRuntime.bind(Chartboost.class);
	}
	
	//@property (retain) NSString *appId;
	private static final Selector setAppId = Selector.register("setAppId:");

	@Bridge
	private native static void objc_setAppId(Chartboost __self__, Selector __cmd__, String appId);

	@Bridge
	private native static void objc_setAppIdSuper(ObjCSuper __super__, Selector __cmd__, String appId);

	public void setAppId(String appId) {
		if (customClass) {
			objc_setAppIdSuper(getSuper(), setAppId, appId);
		} else {
			objc_setAppId(this, setAppId, appId);
		}
	}
	
	//@property (retain) NSString *appSignature;
	private static final Selector setAppSignature = Selector.register("setAppSignature:");

	@Bridge
	private native static void objc_setAppSignature(Chartboost __self__, Selector __cmd__, String appSignature);

	@Bridge
	private native static void objc_setAppSignatureSuper(ObjCSuper __super__, Selector __cmd__, String appSignature);

	public void setAppSignature(String appSignature) {
		if (customClass) {
			objc_setAppSignatureSuper(getSuper(), setAppSignature, appSignature);
		} else {
			objc_setAppSignature(this, setAppSignature, appSignature);
		}
	}
	
	//+ (Chartboost *)sharedChartboost;
	private static final Selector sharedChartboost = Selector.register("sharedChartboost");
	
	@Bridge
	private native static Chartboost objc_sharedChartboost(ObjCClass __self__, Selector __cmd__);
	
	/**
	 * Get the singleton
	 * @return
	 */
	public static Chartboost sharedChartboost(){
		return objc_sharedChartboost(objCClass, sharedChartboost);
	}
	
	//- (void)startSession;
	private static final Selector startSession = Selector.register("startSession");
	
	@Bridge
	private native static void objc_startSession(Chartboost __self__, Selector __cmd__);
	
	@Bridge
	private native static void objc_startSessionSuper(ObjCSuper __super__, Selector __cmd__);
	
	/**
	 * Start the Chartboost session
	 */
	public void startSession(){
		if(customClass){
			objc_startSessionSuper(getSuper(), startSession);
		}else{
			objc_startSession(this, startSession);
		}
	}
	
	//- (void)showInterstitial;
	private static final Selector showInterstitial = Selector.register("showInterstitial");
	
	@Bridge
	private native static void objc_showInterstitial(Chartboost __self__, Selector __cmd__);
	
	@Bridge
	private native static void objc_showInterstitialSuper(ObjCSuper __super__, Selector __cmd__);
	
	/**
	 * Show an interstitial
	 */
	public void showInterstitial(){
		if(customClass){
			objc_showInterstitialSuper(getSuper(), showInterstitial);
		}else{
			objc_showInterstitial(this, showInterstitial);
		}
	}
	
	//- (void)showInterstitial:(NSString *)location;
	private static final Selector showInterstitialLocation = Selector.register("showInterstitial:");
	
	@Bridge
	private native static void objc_showInterstitial(Chartboost __self__, Selector __cmd__, String location);
	
	@Bridge
	private native static void objc_showInterstitialSuper(ObjCSuper __super__, Selector __cmd__,  String location);
	
	// Show an interstitial, optionally takes a location and/or a view argument
	public void showInterstitial(String location){
		if(customClass){
			objc_showInterstitialSuper(getSuper(), showInterstitialLocation, location);
		}else{
			objc_showInterstitial(this, showInterstitialLocation, location);
		}
	}
	
	//- (void)cacheInterstitial;
	private static final Selector cacheInterstitial = Selector.register("cacheInterstitial");
	
	@Bridge
	private native static void objc_cacheInterstitial(Chartboost __self__, Selector __cmd__);
	
	@Bridge
	private native static void objc_cacheInterstitialSuper(ObjCSuper __super__, Selector __cmd__);
	
	/**
	 * Cache an interstitial
	 */
	public void cacheInterstitial(){
		if(customClass){
			objc_cacheInterstitialSuper(getSuper(), cacheInterstitial);
		}else{
			objc_cacheInterstitial(this, cacheInterstitial);
		}
	}
	
	//- (void)cacheInterstitial;
	private static final Selector cacheInterstitialLocation = Selector.register("cacheInterstitial:");
	
	@Bridge
	private native static void objc_cacheInterstitial(Chartboost __self__, Selector __cmd__, String location);
	
	@Bridge
	private native static void objc_cacheInterstitialSuper(ObjCSuper __super__, Selector __cmd__, String location);
	
	// Cache an interstitial, optionally takes a location argument
	public void cacheInterstitial(String location){
		if(customClass){
			objc_cacheInterstitialSuper(getSuper(), cacheInterstitialLocation, location);
		}else{
			objc_cacheInterstitial(this, cacheInterstitialLocation, location);
		}
	}
	
	//- (void)showMoreApps;
	private static final Selector showMoreApps = Selector.register("showMoreApps");
	
	@Bridge
	private native static void objc_showMoreApps(Chartboost __self__, Selector __cmd__);
	
	@Bridge
	private native static void objc_showMoreAppsSuper(ObjCSuper __super__, Selector __cmd__);
	
	// Show the More Apps page
	public void showMoreApps(){
		if(customClass){
			objc_showMoreAppsSuper(getSuper(), showMoreApps);
		}else{
			objc_showMoreApps(this, showMoreApps);
		}
	}
	
	//@property (assign) id <ChartboostDelegate> delegate;
	private static final Selector setDelegate = Selector.register("setDelegate:");
	
	@Bridge
	private native static void objc_setDelegate(Chartboost __self__, Selector __cmd__, ChartboostDelegate delegate);
	
	@Bridge
	private native static void objc_setDelegateSuper(ObjCSuper __super__, Selector __cmd__, ChartboostDelegate delegate);
	
	public void setDelegate(ChartboostDelegate delegate){
		if(customClass){
			objc_setDelegateSuper(getSuper(), setDelegate, delegate);
		}else{
			objc_setDelegate(this, setDelegate, delegate);
		}
	}

}
