package org.robovm.bindings.mopub;

import org.robovm.cocoatouch.foundation.NSString;
import org.robovm.cocoatouch.uikit.UIViewController;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCObject;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

/**
 * The MPInterstitialAdController class provides a full-screen advertisement that can be displayed during natural transition points in your
 * application.
 */
@Library(Library.INTERNAL)
@NativeClass()
public class MPInterstitialAdController extends UIViewController {
	private static final ObjCClass objCClass = ObjCClass.getByType(MPInterstitialAdController.class);

	static {
		ObjCRuntime.bind(MPInterstitialAdController.class);
	}

	private MPInterstitialAdController() {

	}

	/**
	 * Returns an interstitial ad object matching the given ad unit ID.
	 * 
	 * The first time this method is called for a given ad unit ID, a new interstitial ad object is created, stored in a shared pool, and returned.
	 * Subsequent calls for the same ad unit ID will return that object, unless you have disposed of the object using {@link #removeAdController()}.
	 * 
	 * There can only be one interstitial object for an ad unit ID at a given time.
	 * 
	 * @param adUnitId
	 *            A string representing a MoPub ad unit ID.
	 */
	public static MPInterstitialAdController getAdController(String adUnitId) {
		return objc_getAdController(objCClass, getAdController, new NSString(adUnitId));
	}

	/**
	 * Removes the given interstitial object from the shared pool of interstitials available to your application.
	 * 
	 * This method removes the mapping from the interstitial's ad unit ID to the interstitial ad object. In other words, you will receive a different
	 * ad object if you subsequently call {@link #getAdController(String)} for the same ad unit ID.
	 * 
	 * @warning **Important**: This method is intended to be used for deallocating the interstitial ad object when it is no longer needed. You should
	 *          {@code null} out any references you have to the object after calling this method.
	 * 
	 * @param controller
	 *            The interstitial ad object that should be disposed.
	 */
	public static void removeAdController(MPInterstitialAdController controller) {
		objc_removeAdController(objCClass, removeAdController, controller);
	}

	// /*
	// * Returns the shared pool of interstitial objects for your application.
	// */
	// public static Array getAdControllers() {
	// TODO when NSMutableArray is implemented
	// }

	/**
	 * Begins loading ad content for the interstitial.
	 * 
	 * You can implement the {@link MPInterstitialAdControllerDelegate#didLoadAd} and {@link MPInterstitialAdControllerDelegate#didFailToLoadAd}
	 * methods of {@link MPInterstitialAdControllerDelegate} if you would like to be notified as loading succeeds or fails.
	 */
	public void loadAd() {
		objc_loadAd(this, loadAd);
	}

	/**
	 * A Boolean value that represents whether the interstitial ad has loaded an advertisement and is ready to be presented.
	 * 
	 * After obtaining an interstitial ad object, you can use {@link loadAd} to tell the object to begin loading ad content. Once the content has been
	 * loaded, the value of this property will be {@code true}.
	 * 
	 * The value of this property can be {@code false} if the ad content has not finished loading, has already been presented, or has expired. The
	 * expiration condition only applies for ads from certain third-party ad networks. See {@link MPInterstitialAdControllerDelegate} for more
	 * details.
	 */
	public boolean isReady() {
		return objc_isReady(this, isReady);
	}

	/**
	 * Presents the interstitial ad modally from the specified view controller.
	 * 
	 * This method will do nothing if the interstitial ad has not been loaded (i.e. the value of its `ready` property is NO).
	 * 
	 * `MPInterstitialAdControllerDelegate` provides optional methods that you may implement to stay informed about when an interstitial takes over or
	 * relinquishes the screen.
	 * 
	 * @param controller
	 *            The view controller that should be used to present the interstitial ad.
	 */
	public void show(UIViewController controller) {
		objc_show(this, show, controller);
	}

	/**
	 * Get the delegate
	 * 
	 * @return the delegate of this ad view.
	 */
	public MPInterstitialAdControllerDelegate getDelegate() {
		return objc_getDelegate(this, delegate$);
	}

	/**
	 * Sets he delegate {@link MPInterstitialAdControllerDelegate} of the interstitial ad object.
	 */
	public void setDelegate(MPInterstitialAdControllerDelegate delegate) {
		this.addStrongRef((ObjCObject) delegate);
		objc_setDelegate(this, delegate$, delegate);
	}

	/**
	 * Get the ad unit ID for this ad view.
	 * 
	 * @return the ad unit ID for this view.
	 */
	public String getAdUnitId() {
		return objc_getAdUnitId(this, adUnitId$).toString();
	}

	/**
	 * Sets he MoPub ad unit ID for this interstitial ad.
	 * 
	 * Ad unit IDs are created on the MoPub website. An ad unit is a defined placement in your application set aside for advertising. If no ad unit ID
	 * is set, the ad object will use a default ID that only receives test ads.
	 * 
	 * @param id
	 */
	public void setAdUnitId(String id) {
		objc_setAdUnitId(this, adUnitId$, new NSString(id));
	}

	/**
	 * Get the keywords.
	 * 
	 * @return keywords
	 */
	public String getKeywords() {
		return objc_getKeywords(this, keywords$).toString();
	}

	/**
	 * Sets the keywords that should be passed to the MoPub ad server to receive more relevant advertising.
	 * 
	 * Keywords are typically used to target ad campaigns at specific user segments. They should be formatted as comma-separated key-value pairs (e.g.
	 * "marital:single,age:24").
	 * 
	 * On the MoPub website, keyword targeting options can be found under the "Advanced Targeting" section when managing campaigns.
	 * 
	 * @param keywords
	 */
	public void setKeywords(String keywords) {
		objc_setKeywords(this, keywords$, new NSString(keywords));
	}

	/**
	 * Get the testing state.
	 * 
	 * @return {@code true} if the ad view is receiving test ads, else {@code false}.
	 */
	public boolean isTesting() {
		return objc_isTesting(this, testing$);
	}

	/**
	 * Set whether the interstitial ad object should request ads in test mode or not.
	 * 
	 * The default value is {@code false}.
	 * 
	 * @warning **Important**: If you set testing to {@code true}, make sure to reset it to {@code false} before submitting your application to the
	 *          App Store.
	 */
	public void setTesting(boolean testing) {
		objc_setTesting(this, testing$, testing);
	}

	// ================
	// SELECTORS
	// ================
	private static final Selector getAdController = Selector.register("interstitialAdControllerForAdUnitId:");
	private static final Selector removeAdController = Selector.register("removeSharedInterstitialAdController:");
	private static final Selector getAdControllers = Selector.register("sharedInterstitialAdControllers");

	private static final Selector loadAd = Selector.register("loadAd");
	private static final Selector isReady = Selector.register("ready");
	private static final Selector show = Selector.register("showFromViewController:");

	private static final Selector delegate$ = Selector.register("delegate");
	private static final Selector adUnitId$ = Selector.register("adUnitId");
	private static final Selector keywords$ = Selector.register("keywords");
	private static final Selector location$ = Selector.register("location");
	private static final Selector testing$ = Selector.register("testing");

	// ================
	// BRIDGES
	// ================
	@Bridge
	private native static MPInterstitialAdController objc_getAdController(ObjCClass __self__, Selector __cmd__, NSString adUnitId);

	@Bridge
	private native static void objc_removeAdController(ObjCClass __self__, Selector __cmd__, MPInterstitialAdController controller);

	// @Bridge
	// private native static NSMutableArray objc_getAdControllers(ObjCClass __self__, Selector __cmd__); TODO

	@Bridge
	private native static void objc_loadAd(MPInterstitialAdController __self__, Selector __cmd__);

	@Bridge
	private native static boolean objc_isReady(MPInterstitialAdController __self__, Selector __cmd__);

	@Bridge
	private native static void objc_show(MPInterstitialAdController __self__, Selector __cmd__, UIViewController controller);

	@Bridge
	private native static MPInterstitialAdControllerDelegate objc_getDelegate(MPInterstitialAdController __self__, Selector __cmd__);

	@Bridge
	private native static void objc_setDelegate(MPInterstitialAdController __self__, Selector __cmd__, MPInterstitialAdControllerDelegate delegate);

	@Bridge
	private native static NSString objc_getAdUnitId(MPInterstitialAdController __self__, Selector __cmd__);

	@Bridge
	private native static void objc_setAdUnitId(MPInterstitialAdController __self__, Selector __cmd__, NSString adUnitId);

	@Bridge
	private native static NSString objc_getKeywords(MPInterstitialAdController __self__, Selector __cmd__);

	@Bridge
	private native static void objc_setKeywords(MPInterstitialAdController __self__, Selector __cmd__, NSString keywords);

	// @Bridge
	// private native static CLLocation objc_getLocation(MPInterstitialAdController __self__, Selector __cmd__);
	// TODO
	// @Bridge
	// private native static void objc_setLocation(MPInterstitialAdController __self__, Selector __cmd__, CLLocation location);

	@Bridge
	private native static boolean objc_isTesting(MPInterstitialAdController __self__, Selector __cmd__);

	@Bridge
	private native static void objc_setTesting(MPInterstitialAdController __self__, Selector __cmd__, boolean testing);
}