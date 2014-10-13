
package org.robovm.bindings.chartboost;

import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.uikit.UIViewController;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;

@NativeClass
public class Chartboost extends NSObject {

    private Chartboost () {
    }

    /** Start Chartboost with required appId, appSignature and delegate.
     *
     * This method must be executed before any other Chartboost SDK methods can be used. Once executed this call will also
     * controll session tracking and background tasks used by Chartboost.
     * @param appId The Chartboost application ID for this application.
     *
     * @param appSignature The Chartboost application signature for this application.
     *
     * @param delegate The delegate instance to receive Chartboost SDK callbacks. */
    @Method(selector = "startWithAppId:appSignature:delegate:")
    public static native void start (String appId, String appSignature, ChartboostDelegate delegate);

    /** Determine if a locally cached interstitial exists for the given CBLocation. A return value of YES here indicates that the
     * corresponding {@link #showInterstitial(String)} method will present without making additional Chartboost API server
     * requests to fetch data to present.
     * 
     * @param location The location for the Chartboost impression type.
     * 
     * @return true if there a locally cached interstitial, and NO if not. */
    @Method(selector = "hasInterstitial:")
    public static native boolean hasInterstitial (String location);

    public static boolean hasInterstitial (CBLocation location) {
        return hasInterstitial(location.value());
    }

    /** Present an interstitial for the given CBLocation.
     * 
     * This method will first check if there is a locally cached interstitial for the given CBLocation and, if found, will present
     * using the locally cached data. If no locally cached data exists the method will attempt to fetch data from the Chartboost
     * API server and present it. If the Chartboost API server is unavailable or there is no eligible interstitial to present in
     * the given CBLocation this method is a no-op.
     * 
     * @param location The location for the Chartboost impression type. */
    @Method(selector = "showInterstitial:")
    public static native void showInterstitial (String location);

    public static void showInterstitial (CBLocation location) {
        showInterstitial(location.value());
    }

    /** Determine if a locally cached "more applications" exists for the given CBLocation.
     * 
     * A return value of YES here indicates that the corresponding showMoreApps:(CBLocation)location method will present without
     * making additional server requests to fetch data to present.
     * 
     * @param location The location for the Chartboost impression type.
     * 
     * @return true if there a locally cached "more applications", and false if not. */
    @Method(selector = "hasMoreApps:")
    public static native boolean hasMoreApps (String location);

    public static boolean hasMoreApps (CBLocation location) {
        return hasMoreApps(location.value());
    }

    /** Present an "more applications" for the given CBLocation.
     * 
     * This method will first check if there is a locally cached "more applications" for the given CBLocation and, if found, will
     * present using the locally cached data. If no locally cached data exists the method will attempt to fetch data from the
     * Chartboost API server and present it. If the Chartboost API server is unavailable or there is no eligible
     * "more applications" to present in the given CBLocation this method is a no-op.
     * 
     * @param location The location for the Chartboost impression type. */
    @Method(selector = "showMoreApps:")
    public static native void showMoreApps (String location);

    public static void showMoreApps (CBLocation location) {
        showMoreApps(location.value());
    }

    /** Present an "more applications" for the given CBLocation and inside the given UIViewController.
     * 
     * This method uses the same implementation logic as showMoreApps:(CBLocation)location for loading the "more applications"
     * data, but adds an optional viewController parameter. The viewController object allows the "more applications" page to be
     * presented modally in a specified view hierarchy. If the Chartboost API server is unavailable or there is no eligible
     * "more applications" to present in the given CBLocation this method is a no-op.
     * 
     * @param viewController The UIViewController to display the "more applications" UI within.
     * 
     * @param location The location for the Chartboost impression type. */
    @Method(selector = "showMoreApps:location:")
    public static native void showMoreApps (UIViewController viewController, String location);

    public static void showMoreApps (UIViewController viewController, CBLocation location) {
        showMoreApps(viewController, location.value());
    }

    /** Cache an interstitial at the given CBLocation.
     *
     * This method will first check if there is a locally cached interstitial for the given CBLocation and, if found, will do
     * nothing. If no locally cached data exists the method will attempt to fetch data from the Chartboost API server.
     * 
     * @param location The location for the Chartboost impression type. */
    @Method(selector = "cacheInterstitial:")
    public static native void cacheInterstitial (String location);

    public static void cacheInterstitial (CBLocation location) {
        cacheInterstitial(location.value());
    }

    /** Cache an "more applications" at the given CBLocation.
     * 
     * This method will first check if there is a locally cached "more applications" for the given CBLocation and, if found, will
     * do nothing. If no locally cached data exists the method will attempt to fetch data from the Chartboost API server.
     * 
     * @param location The location for the Chartboost impression type. */
    @Method(selector = "cacheMoreApps:")
    public static native void cacheMoreApps (String location);

    public static void cacheMoreApps (CBLocation location) {
        cacheMoreApps(location.value());
    }

    /** Set to enable and disable the auto cache feature (Enabled by default).
     * 
     * If set to true the Chartboost SDK will automatically attempt to cache an impression once one has been consumed via a "show"
     * call. If set to false, it is the responsibility of the developer to manage the caching behavior of Chartboost impressions.
     * 
     * @param shouldCache The param to enable or disable auto caching. */
    @Method(selector = "setAutoCacheAds:")
    public static native void setAutoCacheAds (boolean shouldCache);
}
