package org.robovm.bindings.chartboost;

import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.foundation.NSString;
import org.robovm.apple.uikit.UIViewController;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.GlobalValue;

@NativeClass
public class Chartboost extends NSObject {
    
    private Chartboost() {
    }
    
    @GlobalValue(symbol = "CBLocationStartup")
    public static native NSString locationStartup();
    
    @GlobalValue(symbol = "CBLocationHomeScreen")
    public static native NSString locationHomeScreen();
    
    @GlobalValue(symbol = "CBLocationMainMenu")
    public static native NSString locationMainMenu();
    
    @GlobalValue(symbol = "CBLocationGameScreen")
    public static native NSString locationGameScreen();
    
    @GlobalValue(symbol = "CBLocationAchievements")
    public static native NSString locationAchievements();
    
    @GlobalValue(symbol = "CBLocationQuests")
    public static native NSString locationQuests();
    
    @GlobalValue(symbol = "CBLocationPause")
    public static native NSString locationPause();
    
    @GlobalValue(symbol = "CBLocationLevelStart")
    public static native NSString locationLevelStart();
    
    @GlobalValue(symbol = "CBLocationLevelComplete")
    public static native NSString locationLevelComplete();
    
    @GlobalValue(symbol = "CBLocationTurnComplete")
    public static native NSString locationTurnComplete();
    
    @GlobalValue(symbol = "CBLocationIAPStore")
    public static native NSString locationIAPStore();
    
    @GlobalValue(symbol = "CBLocationItemStore")
    public static native NSString locationItemStore();
    
    @GlobalValue(symbol = "CBLocationGameOver")
    public static native NSString locationGameOver();
    
    @GlobalValue(symbol = "CBLocationLeaderBoard")
    public static native NSString locationLeaderBoard();
    
    @GlobalValue(symbol = "CBLocationSettings")
    public static native NSString locationSettings();
    
    @GlobalValue(symbol = "CBLocationQuit")
    public static native NSString locationQuit();
    
    @GlobalValue(symbol = "CBLocationDefault")
    public static native NSString locationDefault();
    
    /*
     * @abstract Start Chartboost with required appId, appSignature and
     * delegate.
     *
     * @param appId The Chartboost application ID for this application.
     *
     * @param appSignature The Chartboost application signature for this
     * application.
     *
     * @param delegate The delegate instance to receive Chartboost SDK
     * callbacks.
     *
     * @discussion This method must be executed before any other Chartboost SDK
     * methods can be used. Once executed this call will also controll session
     * tracking and background tasks used by Chartboost.
     */
    @Method(selector = "startWithAppId:appSignature:delegate:")
    public static native void startWithAppId(String appId, String appSignature,
                                             ChartboostDelegate delegate);
    
    /*
     * !
     *
     * @abstract Determine if a locally cached interstitial exists for the given
     * CBLocation.
     *
     * @param location The location for the Chartboost impression type.
     *
     * @return YES if there a locally cached interstitial, and NO if not.
     *
     * @discussion A return value of YES here indicates that the corresponding
     * showInterstitial:(CBLocation)location method will present without making
     * additional Chartboost API server requests to fetch data to present.
     */
    @Method(selector = "hasInterstitial:")
    public static native boolean hasInterstitial(String location);
    
    /*
     * !
     *
     * @abstract Present an interstitial for the given CBLocation.
     *
     * @param location The location for the Chartboost impression type.
     *
     * @discussion This method will first check if there is a locally cached
     * interstitial for the given CBLocation and, if found, will present using
     * the locally cached data. If no locally cached data exists the method will
     * attempt to fetch data from the Chartboost API server and present it. If
     * the Chartboost API server is unavailable or there is no eligible
     * interstitial to present in the given CBLocation this method is a no-op.
     */
    @Method(selector = "showInterstitial:")
    public static native void showInterstitial(String location);
    
    /*
     * !
     *
     * @abstract Determine if a locally cached "more applications" exists for
     * the given CBLocation.
     *
     * @param location The location for the Chartboost impression type.
     *
     * @return YES if there a locally cached "more applications", and NO if not.
     *
     * @discussion A return value of YES here indicates that the corresponding
     * showMoreApps:(CBLocation)location method will present without making
     * additional server requests to fetch data to present.
     */
    @Method(selector = "hasMoreApps:")
    public static native boolean hasMoreApps(String location);
    
    /*
     * !
     *
     * @abstract Present an "more applications" for the given CBLocation.
     *
     * @param location The location for the Chartboost impression type.
     *
     * @discussion This method will first check if there is a locally cached
     * "more applications" for the given CBLocation and, if found, will present
     * using the locally cached data. If no locally cached data exists the
     * method will attempt to fetch data from the Chartboost API server and
     * present it. If the Chartboost API server is unavailable or there is no
     * eligible "more applications" to present in the given CBLocation this
     * method is a no-op.
     */
    @Method(selector = "showMoreApps:")
    public static native void showMoreApps(String location);
    
    /*
     * !
     *
     * @abstract Present an "more applications" for the given CBLocation and
     * inside the given UIViewController.
     *
     * @param viewController The UIViewController to display the
     * "more applications" UI within.
     *
     * @param location The location for the Chartboost impression type.
     *
     * @discussion This method uses the same implementation logic as
     * showMoreApps:(CBLocation)location for loading the "more applications"
     * data, but adds an optional viewController parameter. The viewController
     * object allows the "more applications" page to be presented modally in a
     * specified view hierarchy. If the Chartboost API server is unavailable or
     * there is no eligible "more applications" to present in the given
     * CBLocation this method is a no-op.
     */
    @Method(selector = "showMoreApps:location:")
    public static native void showMoreApps(UIViewController viewController,
                                           String location);
    
    /*
     * !
     *
     * @abstract Cache an interstitial at the given CBLocation.
     *
     * @param location The location for the Chartboost impression type.
     *
     * @discussion This method will first check if there is a locally cached
     * interstitial for the given CBLocation and, if found, will do nothing. If
     * no locally cached data exists the method will attempt to fetch data from
     * the Chartboost API server.
     */
    @Method(selector = "cacheInterstitial:")
    public static native void cacheInterstitial(String location);
    
    /*
     * !
     *
     * @abstract Cache an "more applications" at the given CBLocation.
     *
     * @param location The location for the Chartboost impression type.
     *
     * @discussion This method will first check if there is a locally cached
     * "more applications" for the given CBLocation and, if found, will do
     * nothing. If no locally cached data exists the method will attempt to
     * fetch data from the Chartboost API server.
     */
    @Method(selector = "cacheMoreApps:")
    public static native void cacheMoreApps(String location);
    
    /*
     * !
     * 
     * @abstract Set to enable and disable the auto cache feature (Enabled by
     * default).
     * 
     * @param shouldCache The param to enable or disable auto caching.
     * 
     * @discussion If set to YES the Chartboost SDK will automatically attempt
     * to cache an impression once one has been consumed via a "show" call. If
     * set to NO, it is the responsibility of the developer to manage the
     * caching behavior of Chartboost impressions.
     */
    @Method(selector = "setAutoCacheAds:")
    public static native void setAutoCacheAds(boolean shouldCache);
    
}
