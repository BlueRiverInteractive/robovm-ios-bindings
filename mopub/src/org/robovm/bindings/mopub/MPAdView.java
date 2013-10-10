package org.robovm.bindings.mopub;

import org.robovm.cocoatouch.coregraphics.CGSize;
import org.robovm.cocoatouch.foundation.NSString;
import org.robovm.cocoatouch.uikit.UIView;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

/**
 * The MPAdView class provides a view that can display banner advertisements.
 */
@Library(Library.INTERNAL)
@NativeClass()
public class MPAdView extends UIView {
	private static final ObjCClass objCClass = ObjCClass.getByType(MPAdView.class);

	static {
		ObjCRuntime.bind(MPAdView.class);
	}

	/**
	 * Initializes an MPAdView with the given ad unit ID and banner size.
	 * 
	 * @param adUnitId
	 *            A string representing a MoPub ad unit ID.
	 * @param size
	 *            The desired ad size. A list of standard ad sizes is available in MPConstants.h.
	 * @return A newly initialized ad view corresponding to the given ad unit ID and size.
	 */
	public MPAdView(String adUnitId, CGSize size) {
		objc_init(this, init, new NSString(adUnitId), size);
	}

	private static final Selector init = Selector.register("initWithAdUnitId:size:");

	@Bridge
	private native static MPAdView objc_init(UIView __self__, Selector __cmd__, NSString adUnitId, CGSize size);

	/**
	 * Requests a new ad from the MoPub ad server.
	 * 
	 * If the ad view is already loading an ad, this call will be ignored. You may use `forceRefreshAd` if you would like cancel any existing ad
	 * requests and force a new ad to load.
	 */
	public void loadAd() {
		objc_loadAd(this, loadAd);
	}

	private static final Selector loadAd = Selector.register("loadAd");

	@Bridge
	private native static void objc_loadAd(MPAdView __self__, Selector __cmd__);

	/**
	 * Requests a new ad from the MoPub ad server.
	 * 
	 * If the ad view is already loading an ad, this call will be ignored. You may use `forceRefreshAd` if you would like cancel any existing ad
	 * requests and force a new ad to load.
	 * 
	 * **Warning**: This method has been deprecated. Use `loadAd` instead.
	 */
	public void refreshAd() {
		objc_refreshAd(this, refreshAd);
	}

	private static final Selector refreshAd = Selector.register("refreshAd");

	@Bridge
	private native static void objc_refreshAd(MPAdView __self__, Selector __cmd__);

	/**
	 * Cancels any existing ad requests and requests a new ad from the MoPub ad server.
	 */
	public void forceRefreshAd() {
		objc_forceRefreshAd(this, forceRefreshAd);
	}

	private static final Selector forceRefreshAd = Selector.register("forceRefreshAd");

	@Bridge
	private native static void objc_forceRefreshAd(MPAdView __self__, Selector __cmd__);

	/**
	 * Informs the ad view that the device orientation has changed.
	 * 
	 * Banners from some third-party ad networks have orientation-specific behavior. You should call this method when your application's orientation
	 * changes if you want mediated ads to acknowledge their new orientation.
	 * 
	 * If your application layout needs to change based on the size of the mediated ad, you may want to check the value of `adContentViewSize` after
	 * calling this method, in case the orientation change causes the mediated ad to resize.
	 * 
	 * @param newOrientation
	 *            The new interface orientation (after orientation changes have occurred).
	 */
	public void rotateToOrientation(MPNativeAdOrientation orientation) {
		objc_rotateToOrientation(this, rotateToOrientation, orientation);
	}

	private static final Selector rotateToOrientation = Selector.register("rotateToOrientation:");

	@Bridge
	private native static void objc_rotateToOrientation(MPAdView __self__, Selector __cmd__, MPNativeAdOrientation orientation);

	/**
	 * Forces third-party native ad networks to only use ads sized for the specified orientation.
	 * 
	 * Banners from some third-party ad networks have orientation-specific behaviors and/or sizes. You may use this method to lock ads to a certain
	 * orientation. For instance, if you call this with MPInterfaceOrientationPortrait, native networks (e.g. iAd) will never return ads sized for the
	 * landscape orientation.
	 * 
	 * @param orientation
	 *            An MPNativeAdOrientation enum value.
	 * 
	 *            <pre>
	 * <code>public enum MPNativeAdOrientation {
	 *    Any,
	 *    Portrait,
	 *    Landscape
	 * }</code>
	 * </pre>
	 * 
	 * @see #unlockAdsOrientation
	 * @see #getAllowedAdsOrientation
	 */
	public void lockAdsToOrientation(MPNativeAdOrientation orientation) {
		objc_lockAdsToOrientation(this, lockAdsToOrientation, orientation);
	}

	private static final Selector lockAdsToOrientation = Selector.register("lockNativeAdsToOrientation:");

	@Bridge
	private native static void objc_lockAdsToOrientation(MPAdView __self__, Selector __cmd__, MPNativeAdOrientation orientation);

	/**
	 * Allows third-party native ad networks to use ads sized for any orientation.
	 * 
	 * You do not need to call this method unless you have previously called `lockNativeAdsToOrientation:`.
	 * 
	 * @see lockAdsToOrientation
	 * @see getAllowedAdsOrientation
	 */
	public void unlockAdsOrientation() {
		objc_unlockAdsOrientation(this, unlockAdsOrientation);
	}

	private static final Selector unlockAdsOrientation = Selector.register("unlockNativeAdsOrientation");

	@Bridge
	private native static void objc_unlockAdsOrientation(MPAdView __self__, Selector __cmd__);

	/**
	 * Causes the ad view to periodically load new advertisements in accordance with user-defined refresh settings on the MoPub website.
	 * 
	 * Calling this method is only necessary if you have previously stopped the ad view's refresh behavior using
	 * `stopAutomaticallyRefreshingContents`. By default, an ad view is allowed to automatically load new advertisements if a refresh interval has
	 * been configured on the MoPub website. This method has no effect if a refresh interval has not been set.
	 * 
	 * @see #stopAutomaticallyRefreshingContents
	 */
	public void startAutomaticallyRefreshingContents() {
		objc_startAutomaticallyRefreshingContents(this, startAutomaticallyRefreshingContents);
	}

	private static final Selector startAutomaticallyRefreshingContents = Selector.register("startAutomaticallyRefreshingContents");

	@Bridge
	private native static void objc_startAutomaticallyRefreshingContents(MPAdView __self__, Selector __cmd__);

	/**
	 * Stops the ad view from periodically loading new advertisements.
	 * 
	 * By default, an ad view is allowed to automatically load new advertisements if a refresh interval has been configured on the MoPub website. This
	 * method prevents new ads from automatically loading, even if a refresh interval has been specified.
	 * 
	 * As a best practice, you should call this method whenever the ad view will be hidden from the user for any period of time, in order to avoid
	 * unnecessary ad requests. You can then call `startAutomaticallyRefreshingContents` to re-enable the refresh behavior when the ad view becomes
	 * visible.
	 * 
	 * @see #startAutomaticallyRefreshingContents
	 */
	public void stopAutomaticallyRefreshingContents() {
		objc_stopAutomaticallyRefreshingContents(this, stopAutomaticallyRefreshingContents);
	}

	private static final Selector stopAutomaticallyRefreshingContents = Selector.register("stopAutomaticallyRefreshingContents");

	@Bridge
	private native static void objc_stopAutomaticallyRefreshingContents(MPAdView __self__, Selector __cmd__);

	/**
	 * Returns the banner orientations that third-party ad networks are allowed to use.
	 * 
	 * @return An enum value representing an allowed set of orientations.
	 * 
	 * @see #lockAdsToOrientation
	 * @see #unlockAdsOrientation
	 */
	public MPNativeAdOrientation getAllowedAdsOrientation() {
		return objc_getAllowedAdsOrientation(this, getAllowedOrientation);
	}

	private static final Selector getAllowedOrientation = Selector.register("allowedNativeAdsOrientation");

	@Bridge
	private native static MPNativeAdOrientation objc_getAllowedAdsOrientation(MPAdView __self__, Selector __cmd__);

	/**
	 * Returns the size of the current ad being displayed in the ad view.
	 * 
	 * Ad sizes may vary between different ad networks. This method returns the actual size of the underlying mediated ad. This size may be different
	 * from the original, initialized size of the ad view. You may use this size to determine to adjust the size or positioning of the ad view to
	 * avoid clipping or border issues.
	 * 
	 * @returns The size of the underlying mediated ad.
	 */
	public CGSize getAdContentViewSize() {
		return objc_getAdContentViewSize(this, getAdContentViewSize);
	}

	private static final Selector getAdContentViewSize = Selector.register("adContentViewSize");

	@Bridge
	private native static CGSize objc_getAdContentViewSize(MPAdView __self__, Selector __cmd__);

	/**
	 * Get the delegate
	 * 
	 * @return the delegate of this ad view.
	 */
	public MPAdViewDelegate getDelegate() {
		return objc_getDelegate(this, getDelegate);
	}

	private static final Selector getDelegate = Selector.register("delegate");

	@Bridge
	private native static MPAdViewDelegate objc_getDelegate(MPAdView __self__, Selector __cmd__);

	/**
	 * Sets the {@link MPAdViewDelegate} of the ad view.
	 * 
	 * @warning **Important**: Before releasing an instance of MPAdView, you must set its delegate property to {@code null}.
	 */
	public void setDelegate(MPAdViewDelegate delegate) {
		objc_setDelegate(this, setDelegate, delegate);
	}

	private static final Selector setDelegate = Selector.register("setDelegate:");

	@Bridge
	private native static void objc_setDelegate(MPAdView __self__, Selector __cmd__, MPAdViewDelegate delegate);

	/**
	 * Get the ad unit ID for this ad view.
	 * 
	 * @return the ad unit ID for this view.
	 */
	public String getAdUnitId() {
		return objc_getAdUnitId(this, getAdUnitId).toString();
	}

	private static final Selector getAdUnitId = Selector.register("adUnitId");

	@Bridge
	private native static NSString objc_getAdUnitId(MPAdView __self__, Selector __cmd__);

	/**
	 * Sets the MoPub ad unit ID for this ad view.
	 * 
	 * Ad unit IDs are created on the MoPub website. An ad unit is a defined placement in your application set aside for advertising. If no ad unit ID
	 * is set, the ad view will use a default ID that only receives test ads.
	 * 
	 * @param id
	 */
	public void setAdUnitId(String id) {
		objc_setAdUnitId(this, setAdUnitId, new NSString(id));
	}

	private static final Selector setAdUnitId = Selector.register("setAdUnitId:");

	@Bridge
	private native static void objc_setAdUnitId(MPAdView __self__, Selector __cmd__, NSString adUnitId);

	/**
	 * Get the keywords.
	 * 
	 * @return keywords
	 */
	public String getKeywords() {
		return objc_getKeywords(this, getKeywords).toString();
	}

	private static final Selector getKeywords = Selector.register("keywords");

	@Bridge
	private native static NSString objc_getKeywords(MPAdView __self__, Selector __cmd__);

	/**
	 * Set the keywords that should be passed to the MoPub ad server to receive more relevant advertising.
	 * 
	 * Keywords are typically used to target ad campaigns at specific user segments. They should be formatted as comma-separated key-value pairs (e.g.
	 * "marital:single,age:24").
	 * 
	 * On the MoPub website, keyword targeting options can be found under the "Advanced Targeting" section when managing campaigns.
	 * 
	 * @param keywords
	 */
	public void setKeywords(String keywords) {
		objc_setKeywords(this, setKeywords, new NSString(keywords));
	}

	@Bridge
	private native static void objc_setKeywords(MPAdView __self__, Selector __cmd__, NSString keywords);

	private static final Selector setKeywords = Selector.register("setKeywords:");

	private static final Selector getLocation = Selector.register("location");
	private static final Selector setLocation = Selector.register("setLocation:");

	// @Bridge
	// private native static CLLocation objc_getLocation(MPAdView __self__, Selector __cmd__);
	// TODO when RoboVM understands the CoreLocation framework
	// @Bridge
	// private native static void objc_setLocation(MPAdView __self__, Selector __cmd__, CLLocation location);

	/**
	 * Get the testing state.
	 * 
	 * @return {@code true} if the ad view is receiving test ads, else {@code false}.
	 */
	public boolean isTesting() {
		return objc_isTesting(this, isTesting);
	}

	private static final Selector isTesting = Selector.register("testing");

	@Bridge
	private native static boolean objc_isTesting(MPAdView __self__, Selector __cmd__);

	/**
	 * Set whether the ad view should request ads in test mode or not.
	 * 
	 * The default value is {@code false}.
	 * 
	 * @warning **Important**: If you set testing to {@code true}, make sure to reset it to {@code false} before submitting your application to the
	 *          App Store.
	 */
	public void setTesting(boolean testing) {
		objc_setTesting(this, setTesting, testing);
	}

	private static final Selector setTesting = Selector.register("setTesting:");

	@Bridge
	private native static void objc_setTesting(MPAdView __self__, Selector __cmd__, boolean testing);
}