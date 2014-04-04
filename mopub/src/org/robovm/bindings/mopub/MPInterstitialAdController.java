
package org.robovm.bindings.mopub;

import org.robovm.apple.foundation.NSMutableArray;
import org.robovm.apple.uikit.UIViewController;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

/** The MPInterstitialAdController class provides a full-screen advertisement that can be displayed during natural transition
 * points in your application. */
@NativeClass
public class MPInterstitialAdController extends UIViewController {
	private MPInterstitialAdController () {
	}

	/** Returns an interstitial ad object matching the given ad unit ID.
	 * 
	 * The first time this method is called for a given ad unit ID, a new interstitial ad object is created, stored in a shared
	 * pool, and returned. Subsequent calls for the same ad unit ID will return that object, unless you have disposed of the object
	 * using {@link #removeAdController()}.
	 * 
	 * There can only be one interstitial object for an ad unit ID at a given time.
	 * 
	 * @param adUnitId A string representing a MoPub ad unit ID. */
	@Method(selector = "interstitialAdControllerForAdUnitId:")
	public static native MPInterstitialAdController getAdController (String adUnitId);

	/** Removes the given interstitial object from the shared pool of interstitials available to your application.
	 * 
	 * This method removes the mapping from the interstitial's ad unit ID to the interstitial ad object. In other words, you will
	 * receive a different ad object if you subsequently call {@link #getAdController(String)} for the same ad unit ID.
	 * 
	 * @warning **Important**: This method is intended to be used for deallocating the interstitial ad object when it is no longer
	 *          needed. You should {@code null} out any references you have to the object after calling this method.
	 * 
	 * @param controller The interstitial ad object that should be disposed. */
	@Method(selector = "removeSharedInterstitialAdController:")
	public static native void removeAdController (MPInterstitialAdController controller);

	/** Returns the shared pool of interstitial objects for your application. */
	@Method(selector = "sharedInterstitialAdControllers")
	public static native NSMutableArray<?> getAdControllers ();

	/** Begins loading ad content for the interstitial.
	 * 
	 * You can implement the {@link MPInterstitialAdControllerDelegate#didLoadAd} and
	 * {@link MPInterstitialAdControllerDelegate#didFailToLoadAd} methods of {@link MPInterstitialAdControllerDelegate} if you
	 * would like to be notified as loading succeeds or fails. */
	@Method(selector = "loadAd")
	public native void loadAd ();

	/** A Boolean value that represents whether the interstitial ad has loaded an advertisement and is ready to be presented.
	 * 
	 * After obtaining an interstitial ad object, you can use {@link loadAd} to tell the object to begin loading ad content. Once
	 * the content has been loaded, the value of this property will be {@code true}.
	 * 
	 * The value of this property can be {@code false} if the ad content has not finished loading, has already been presented, or
	 * has expired. The expiration condition only applies for ads from certain third-party ad networks. See
	 * {@link MPInterstitialAdControllerDelegate} for more details. */
	@Property
	public native boolean isReady ();

	/** Presents the interstitial ad modally from the specified view controller.
	 * 
	 * This method will do nothing if the interstitial ad has not been loaded (i.e. {@link #isReady()} returns {@code false}).
	 * 
	 * The {@link MPInterstitialAdControllerDelegate} provides optional methods that you may implement to stay informed about when
	 * an interstitial takes over or relinquishes the screen.
	 * 
	 * @param controller The view controller that should be used to present the interstitial ad. */
	@Method(selector = "showFromViewController:")
	public native void show (UIViewController controller);

	/** Get the delegate.
	 * 
	 * @return the delegate of this ad view. */
	@Property
	public native MPInterstitialAdControllerDelegate getDelegate ();

	/** Sets the delegate {@link MPInterstitialAdControllerDelegate} of the interstitial ad object. */
	@Property(strongRef = true)
	public native void setDelegate (MPInterstitialAdControllerDelegate delegate);

	/** Get the ad unit ID for this ad view.
	 * 
	 * @return the ad unit ID for this view. */
	@Property
	public native String getAdUnitId ();

	/** Sets he MoPub ad unit ID for this interstitial ad.
	 * 
	 * Ad unit IDs are created on the MoPub website. An ad unit is a defined placement in your application set aside for
	 * advertising. If no ad unit ID is set, the ad object will use a default ID that only receives test ads.
	 * 
	 * @param id */
	@Property
	public native void setAdUnitId (String id);

	/** Get the keywords.
	 * 
	 * @return keywords */
	@Property
	public native String getKeywords ();

	/** Sets the keywords that should be passed to the MoPub ad server to receive more relevant advertising.
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
// TODO when RoboVM has the CoreLocation framework bound
// @Property
// public native void setLocation(CLLocation location);

	/** Get the testing state.
	 * 
	 * @return {@code true} if the ad view is receiving test ads, else {@code false}. */
	@Property
	public native boolean isTesting ();

	/** Set whether the interstitial ad object should request ads in test mode or not.
	 * 
	 * The default value is {@code false}.
	 * 
	 * @warning **Important**: If you set testing to {@code true}, make sure to reset it to {@code false} before submitting your
	 *          application to the App Store. */
	@Property
	public native void setTesting (boolean testing);
}
