
package org.robovm.bindings.mopub;

import org.robovm.apple.coregraphics.CGSize;
import org.robovm.apple.uikit.UIView;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;
import org.robovm.rt.bro.annotation.Pointer;

/** The MPAdView class provides a view that can display banner advertisements. */
@NativeClass
public class MPAdView extends UIView {

	/** Initializes an MPAdView with the given ad unit ID and banner size.
	 * 
	 * @param adUnitId A string representing a MoPub ad unit ID.
	 * @param size The desired ad size. A list of standard ad sizes is available in MPConstants.h.
	 * @return A newly initialized ad view corresponding to the given ad unit ID and size. */
	public MPAdView (String adUnitId, CGSize size) {
		super((SkipInit)null);
		initObject(init(adUnitId, size));
	}

	@Method(selector = "initWithAdUnitId:size:")
	private native @Pointer
	long init (String adUnitId, CGSize size);

	/** Requests a new ad from the MoPub ad server.
	 * 
	 * If the ad view is already loading an ad, this call will be ignored. You may use {@link #forceRefreshAd()} if you would like
	 * cancel any existing ad requests and force a new ad to load. */
	@Method(selector = "loadAd")
	public native void loadAd ();

	/** Cancels any existing ad requests and requests a new ad from the MoPub ad server. */
	@Method(selector = "forceRefreshAd")
	public native void forceRefreshAd ();

	/** Informs the ad view that the device orientation has changed.
	 * 
	 * Banners from some third-party ad networks have orientation-specific behavior. You should call this method when your
	 * application's orientation changes if you want mediated ads to acknowledge their new orientation.
	 * 
	 * If your application layout needs to change based on the size of the mediated ad, you may want to check the value of
	 * {@link #getAdContentViewSize()} after calling this method, in case the orientation change causes the mediated ad to resize.
	 * 
	 * @param newOrientation The new interface orientation (after orientation changes have occurred). */
	@Method(selector = "rotateToOrientation:")
	public native void rotateToOrientation (MPNativeAdOrientation orientation);

	/** Forces third-party native ad networks to only use ads sized for the specified orientation.
	 * 
	 * Banners from some third-party ad networks have orientation-specific behaviors and/or sizes. You may use this method to lock
	 * ads to a certain orientation. For instance, if you call this with MPInterfaceOrientationPortrait, native networks (e.g. iAd)
	 * will never return ads sized for the landscape orientation.
	 * 
	 * @param orientation An MPNativeAdOrientation enum value.
	 * 
	 *           <pre>
	 * <code>public enum MPNativeAdOrientation {
	 *    Any,
	 *    Portrait,
	 *    Landscape
	 * }</code>
	 * </pre>
	 * 
	 * @see #unlockAdsOrientation
	 * @see #getAllowedAdsOrientation */
	@Method(selector = "lockNativeAdsToOrientation:")
	public native void lockAdsToOrientation (MPNativeAdOrientation orientation);

	/** Allows third-party native ad networks to use ads sized for any orientation.
	 * 
	 * You do not need to call this method unless you have previously called `lockNativeAdsToOrientation:`.
	 * 
	 * @see lockAdsToOrientation
	 * @see getAllowedAdsOrientation */
	@Method(selector = "unlockNativeAdsOrientation")
	public native void unlockAdsOrientation ();

	/** Causes the ad view to periodically load new advertisements in accordance with user-defined refresh settings on the MoPub
	 * website.
	 * 
	 * Calling this method is only necessary if you have previously stopped the ad view's refresh behavior using
	 * {@link #stopAutomaticallyRefreshingContents()}. By default, an ad view is allowed to automatically load new advertisements
	 * if a refresh interval has been configured on the MoPub website. This method has no effect if a refresh interval has not been
	 * set.
	 * 
	 * @see #stopAutomaticallyRefreshingContents */
	@Method(selector = "startAutomaticallyRefreshingContents")
	public native void startAutomaticallyRefreshingContents ();

	/** Stops the ad view from periodically loading new advertisements.
	 * 
	 * By default, an ad view is allowed to automatically load new advertisements if a refresh interval has been configured on the
	 * MoPub website. This method prevents new ads from automatically loading, even if a refresh interval has been specified.
	 * 
	 * As a best practice, you should call this method whenever the ad view will be hidden from the user for any period of time, in
	 * order to avoid unnecessary ad requests. You can then call `startAutomaticallyRefreshingContents` to re-enable the refresh
	 * behavior when the ad view becomes visible.
	 * 
	 * @see #startAutomaticallyRefreshingContents */
	@Method(selector = "stopAutomaticallyRefreshingContents")
	public native void stopAutomaticallyRefreshingContents ();

	/** Returns the banner orientations that third-party ad networks are allowed to use.
	 * 
	 * @return An enum value representing an allowed set of orientations.
	 * 
	 * @see #lockAdsToOrientation
	 * @see #unlockAdsOrientation */
	@Method(selector = "allowedNativeAdsOrientation")
	public native MPNativeAdOrientation getAllowedAdsOrientation ();

	/** Returns the size of the current ad being displayed in the ad view.
	 * 
	 * Ad sizes may vary between different ad networks. This method returns the actual size of the underlying mediated ad. This
	 * size may be different from the original, initialized size of the ad view. You may use this size to determine to adjust the
	 * size or positioning of the ad view to avoid clipping or border issues.
	 * 
	 * @returns The size of the underlying mediated ad. */
	@Method(selector = "adContentViewSize")
	public native CGSize getAdContentViewSize ();

	/** Get the delegate
	 * 
	 * @return the delegate of this ad view. */
	@Property
	public native MPAdViewDelegate getDelegate ();

	/** Sets the {@link MPAdViewDelegate} of the ad view.
	 * 
	 * @warning **Important**: Before releasing an instance of MPAdView, you must set its delegate property to {@code null}. */
	@Property(strongRef = true)
	public native void setDelegate (MPAdViewDelegate delegate);

	/** Get the ad unit ID for this ad view.
	 * 
	 * @return the ad unit ID for this view. */
	@Property
	public native String getAdUnitId ();

	/** Sets the MoPub ad unit ID for this ad view.
	 * 
	 * Ad unit IDs are created on the MoPub website. An ad unit is a defined placement in your application set aside for
	 * advertising. If no ad unit ID is set, the ad view will use a default ID that only receives test ads.
	 * 
	 * @param id */
	@Property
	public native void setAdUnitId (String id);

	/** Get the keywords.
	 * 
	 * @return keywords */
	@Property
	public native String getKeywords ();

	/** Set the keywords that should be passed to the MoPub ad server to receive more relevant advertising.
	 * 
	 * Keywords are typically used to target ad campaigns at specific user segments. They should be formatted as comma-separated
	 * key-value pairs (e.g. "marital:single,age:24").
	 * 
	 * On the MoPub website, keyword targeting options can be found under the "Advanced Targeting" section when managing campaigns.
	 * 
	 * @param keywords */
	@Property
	public native void setKeywords (String keywords);

// @Property
// public native CLLocation getLocation();
// TODO when RoboVM has the CLLocation framework bound
// @Property
// public native void setLocation(CLLocation location);

	/** Get the testing state.
	 * 
	 * @return {@code true} if the ad view is receiving test ads, else {@code false}. */
	@Property
	public native boolean isTesting ();

	/** Set whether the ad view should request ads in test mode or not.
	 * 
	 * The default value is {@code false}.
	 * 
	 * @warning **Important**: If you set testing to {@code true}, make sure to reset it to {@code false} before submitting your
	 *          application to the App Store. */
	@Property
	public native void setTesting (boolean testing);
}
