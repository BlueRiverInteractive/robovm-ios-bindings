package org.robovm.bindings.admob;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSString;
import org.robovm.cocoatouch.uikit.UIImage;
import org.robovm.cocoatouch.uikit.UIViewController;
import org.robovm.cocoatouch.uikit.UIWindow;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
@NativeClass()
public class GADInterstitial extends NSObject {
	private static final ObjCClass objCClass = ObjCClass.getByType(GADInterstitial.class);

	static{
		ObjCRuntime.bind(GADInterstitial.class);
	}

	//@property (nonatomic, readonly) BOOL isReady;
	private static final Selector isReady = Selector.register("isReady");

	@Bridge
	private native static boolean objc_isReady(GADInterstitial __self__, Selector __cmd__);
	/**
	 * Returns YES if the interstitial is ready to be displayed. 
	 * The delegate's interstitialAdDidReceiveAd: will be called when this switches from NO to YES.
	 */
	public boolean isReady(){
		return objc_isReady(this, isReady);
	}
	
	//@property (nonatomic, readonly) BOOL hasBeenUsed;
	private static final Selector hasBeenUsed = Selector.register("hasBeenUsed");
	
	@Bridge
	private native static boolean objc_hasBeenUsed(GADInterstitial __self__, Selector __cmd__);
	/**
	 * Returns YES if the interstitial object has already shown an interstitial.
	 * Note that an interstitial object can only be used once even with different requests.
	 * @return
	 */
	public boolean hasBeenUsed(){
		return objc_hasBeenUsed(this, hasBeenUsed);
	}

	// @property (nonatomic, copy) NSString *adUnitID;
	private static final Selector adUnitID = Selector.register("adUnitID");

	@Bridge
	private native static String objc_adUnitID(GADInterstitial __self__, Selector __cmd__);
	/**
	 * Getter for AdUnitID
	 * Required value created in the AdSense website. Create a new ad unit for
	 * every unique placement of an ad in your application. Set this to the ID
	 * assigned for this placement. Ad units are important for targeting and stats.
	 * Example values for different request types:
	 * AdMob: a0123456789ABCD
	 * DFP: /0123/ca-pub-0123456789012345/my-ad-identifier
	 * AdSense: ca-mb-app-pub-0123456789012345/my-ad-identifier
	 */
	public String getAdUnitID(){
		return objc_adUnitID(this, adUnitID);
	}

	private static final Selector setAdUnitID = Selector.register("setAdUnitID:");

	@Bridge
	private native static void objc_setAdUnitID(GADInterstitial __self__, Selector __cmd__, NSString adUnitID);
	/**
	 * Setter for AdUnitID
	 * Required value created in the AdSense website. Create a new ad unit for
	 * every unique placement of an ad in your application. Set this to the ID
	 * assigned for this placement. Ad units are important for targeting and stats.
	 * Example values for different request types:
	 * AdMob: a0123456789ABCD
	 * DFP: /0123/ca-pub-0123456789012345/my-ad-identifier
	 * AdSense: ca-mb-app-pub-0123456789012345/my-ad-identifier
	 */
	public void setAdUnitID(NSString adUnitID){
		objc_setAdUnitID(this, setAdUnitID, adUnitID);
	}

	// @property (nonatomic, assign) NSObject<GADInterstitialDelegate> *delegate;
	private static final Selector delegate = Selector.register("delegate");

	@Bridge
	private native static GADInterstitialDelegate objc_getDelegate(GADInterstitial __self__, Selector __cmd__);
	/**
	 * Getter for Delegate
	 * Optional delegate object that receives state change notifications from this GADInterstitalAd. 
	 * Remember to nil the delegate before deallocating this object.
	 * @return
	 */
	public GADInterstitialDelegate getDelegate(){
		return objc_getDelegate(this, delegate);
	}

	private static final Selector setDelegate = Selector.register("setDelegate:");

	@Bridge
	private native static void objc_setDelegate(GADInterstitial __self__, Selector __cmd__, GADInterstitialDelegate delegate);
	/**
	 * Setter for Delegate
	 * Optional delegate object that receives state change notifications from this GADInterstitalAd. 
	 * Remember to nil the delegate before deallocating this object.
	 * @return
	 */
	public void setDelegate(GADInterstitialDelegate delegate){
		objc_setDelegate(this, setDelegate, delegate);
	}

	// - (void)loadRequest:(GADRequest *)request;
	private static final Selector loadRequest = Selector.register("loadRequest:");

	@Bridge
	private native static void objc_loadRequest(GADInterstitial __self__, Selector __cmd__, GADRequest request);
	/**
	 * Makes an interstitial ad request. Additional targeting options can be
	 * supplied with a request object. Only one interstitial request is allowed at
	 * a time.
	 *
	 * This is best to do several seconds before the interstitial is needed to
	 * preload its content. Then when transitioning between view controllers show
	 * the interstital with presentFromViewController.
	 * @param request
	 */
	public void loadRequest(GADRequest request){
		objc_loadRequest(this, loadRequest, request);
	}
	
	//- (void)loadAndDisplayRequest:(GADRequest *)request usingWindow:(UIWindow *)window initialImage:(UIImage *)image;
	private static final Selector loadAndDisplayRequest$usingWindow$initialImage = Selector.register("loadAndDisplayRequest:usingWindow:initialImage:");
	
	@Bridge
	private native static void objc_loadAndDisplayRequest(GADInterstitial __self__, Selector __cmd__, GADRequest request, UIWindow window, UIImage image);
	/**
	 * The |window| will be shown with the |image| displayed until either the
	 * |request| interstitial is shown or a timeout occurs.  The delegate will
	 * receive an interstitialDidDismissScreen: callback to indicate that your app
	 * should continue when the interstitial has finished.
	 * @param request
	 * @param window
	 * @param image
	 */
	public void loadAndDisplayRequest(GADRequest request, UIWindow window, UIImage image){
		objc_loadAndDisplayRequest(this, loadAndDisplayRequest$usingWindow$initialImage, request, window, image);
	}

	// - (void)presentFromRootViewController:(UIViewController *)rootViewController;
	private static final Selector presentFromRootViewController = Selector.register("presentFromRootViewController:");

	@Bridge
	private native static void objc_presentFromRootViewController(GADInterstitial __self__, Selector __cmd__, UIViewController controller);
	/**
	 * Presents the interstitial ad which takes over the entire screen until the
	 * user dismisses it. This has no effect unless isReady returns YES and/or the
	 * delegate's interstitialDidReceiveAd: has been received.
	 *
	 * Set rootViewController to the current view controller at the time this method
	 * is called. If your application does not use view controllers pass in nil and
	 * your views will be removed from the window to show the interstitial and
	 * restored when done. After the interstitial has been removed, the delegate's
	 * interstitialDidDismissScreen: will be called.
	 * @param controller
	 */
	public void presentFromRootViewController(UIViewController controller){
		objc_presentFromRootViewController(this, presentFromRootViewController, controller);
	}

}
