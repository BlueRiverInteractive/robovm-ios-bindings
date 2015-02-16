
package org.robovm.bindings.flurry.ads;

import org.robovm.apple.coregraphics.CGRect;
import org.robovm.apple.foundation.NSError;
import org.robovm.apple.foundation.NSObjectProtocol;
import org.robovm.apple.uikit.UIView;
import org.robovm.objc.annotation.Method;

/** Provides all available delegates for receiving callbacks related to Ad Serving.
 * 
 * Set of methods that allow developers to manage and take actions within different phases of App ad display.
 * 
 * This class serves as a delegate for FlurryAds. For additional information on how to use Flurry's Ads SDK to attract
 * high-quality users and monetize your user base see <a href="http://wiki.flurry.com/index.php?title=Publisher">Support Center -
 * Publisher</a>.
 * @version SDK 4.4.0 */
public interface FlurryAdDelegate extends NSObjectProtocol {

    /** Invoked when an ad is received for the specified adSpace.
     * 
     * This method informs the app that an ad has been received and is available for display.
     * 
     * @since 4.1
     * @see FlurryAds#fetchAd(String, CGRect, FlurryAdSize)
     * @param adSpace The placement of an ad in your app, where placement may be splash screen for SPLASH_AD. */
    @Method(selector = "spaceDidReceiveAd:")
    void didReceiveAd (String adSpace);

    /** Invoked when an ad can not be retrieved for the specified adSpace.
     * 
     * This method informs the app that an ad has failed to be received for the given adSpace.
     * 
     * @since 4.1
     * @see FlurryAds#fetchAd(String, CGRect, FlurryAdSize)
     * @param adSpace The placement of an ad in your app, where placement may
     * @param error The error, if known, that caused ads not to be received. be splash screen for SPLASH_AD. */
    @Method(selector = "spaceDidFailToReceiveAd:error:")
    void didFailToReceiveAd (String adSpace, NSError error);

    /** Invoked when an ad is about to display on the specified adSpace.
     * 
     * This method informs the app that an ad is about to be displayed. You can decide at this point not to show this ad by simply
     * returning {@code false}.
     * 
     * @since 4.1.0
     * @see FlurryAds#fetchAd(String, CGRect, FlurryAdSize)
     * @see FlurryAds#fetchAndDisplayAd(String, UIView, FlurryAdSize)
     * 
     * @param adSpace The placement of an ad in your app, where placement may be splash screen for SPLASH_AD.
     * @param interstitial {@code true}/{@code false} if the space to display will be an interstitial. */
    @Method(selector = "spaceShouldDisplay:interstitial:")
    boolean shouldDisplay (String adSpace, boolean interstitial);

    /** Invoked when an ad fails to render.
     * 
     * This method informs the user an ad was retrieved, however, was unsuccessful in displaying to the user (could be lost
     * network connectivity for example).
     * 
     * @since 4.0.0
     * @see FlurryAds#fetchAd(String, CGRect, FlurryAdSize)
     * @see FlurryAds#fetchAndDisplayAd(String, UIView, FlurryAdSize)
     * @param adSpace The placement of an ad in your app, where placement may
     * @param error The error, if known, that caused ads not to be rendered. be splash screen for SPLASH_AD. */
    @Method(selector = "spaceDidFailToRender:error:")
    void didFailToRender (String adSpace, NSError error);

    /** Invoked when the ad will be removed.
     * 
     * This method informs the app that an ad will be removed.
     * 
     * @since 4.1
     * @param adSpace The placement of an ad in your app, where placement may be splash screen for SPLASH_AD.
     * @param interstitial {@code true}/{@code false} indicates if space being removed is an interstitial */
    @Method(selector = "spaceWillDismiss:interstitial:")
    void willDismiss (String adSpace, boolean interstitial);

    /** Invoked when the ad has been removed.
     * 
     * This method informs the app that an ad has closed. You can use this to resume app states.
     * 
     * @since 4.0.0
     * @param adSpace The placement of an ad in your app, where placement may be splash screen for SPLASH_AD.
     * @param interstitial {@code true}/{@code false} indicates if space being removed is an interstitial */
    @Method(selector = "spaceDidDismiss:interstitial:")
    void didDismiss (String adSpace, boolean interstitial);

    /** Invoked when the ad has been selected that will take the user out of the app.
     * 
     * This method informs the app that an ad has been clicked and the user is about to be taken outside the app.
     * 
     * @since 4.0.0
     * @param adSpace The placement of an ad in your app, where placement may be splash screen for SPLASH_AD. */
    @Method(selector = "spaceWillLeaveApplication:")
    void willLeaveApplication (String adSpace);

    /** Invoked when a space will be expanded.
     * 
     * This method informs the app an ad space (typcially a banner) will be expanded. Apps should pause their state when they
     * receive this notification
     * 
     * @since 4.1
     * @param adSpace The placement of an ad in your app, where placement may be splash screen for SPLASH_AD. */
    @Method(selector = "spaceWillExpand:")
    void willExpand (String adSpace);

    /** Invoked when a space will be collapsed.
     * 
     * This method informs the app an ad space (typcially a banner) will be collapsed.
     * 
     * @since 4.1
     * @param adSpace The placement of an ad in your app, where placement may be splash screen for SPLASH_AD. */
    @Method(selector = "spaceWillCollapse:")
    void willCollapse (String adSpace);

    /** Invoked when a space has been collapsed.
     * 
     * This method informs the app an ad space (typcially a banner) has been collapsed. Apps should resume their state when they
     * receive this notification
     * 
     * @since 4.1
     * @param adSpace The placement of an ad in your app, where placement may be splash screen for SPLASH_AD. */
    @Method(selector = "spaceDidCollapse:")
    void didCollapse (String adSpace);

    /** Informational callback invoked when an ad is clicked for the specified adSpace.
     * 
     * This method informs the app that an ad has been clicked. This should not be used to adjust state of an app. It is only
     * intended for informational purposes.
     * 
     * @since 4.1
     * @param adSpace The placement of an ad in your app, where placement may be splash screen for SPLASH_AD. */
    @Method(selector = "spaceDidReceiveClick:")
    void didReceiveClick (String adSpace);

    /** Invoked when a video finishes playing
     * 
     * This method informs the app that a video associated with an ad has finished playing
     * 
     * @since 4.2.0
     * @param adSpace The placement of an ad in your app, where placement may be splash screen for SPLASH_AD. */
    @Method(selector = "videoDidFinish:")
    void videoDidFinish (String adSpace);

    /** The Millennial APID.
     * 
     * This is the id for your app as set in Millennial, found here:
     * https://developer.millennialmedia.com/Application/index.php#manageApps.
     * 
     * @since 4.0.0
     * @return */
    @Method(selector = "appSpotMillennialAppKey")
    String getMillennialAppKey ();

    /** The Millennial APID for interstitials.
     * 
     * This is the id for your app as set in Millennial, found here:
     * https://developer.millennialmedia.com/Application/index.php#manageApps.
     * 
     * @since 4.0.0
     * @return */
    @Method(selector = "appSpotMillennialInterstitalAppKey")
    String getMillennialInterstitialAppKey ();

    /** The InMobi APID.
     * 
     * This is the id for your app as set in InMobi, found here: https://www.inmobi.com/pub/mysite.html?platFormType=all
     * 
     * @since 4.0.0
     * @return */
    @Method(selector = "appSpotInMobiAppKey")
    String getInMobiAppKey ();

    /** The FAcebook Audience network APID.
     *
     * This is the id for your app as set in FB Audience Network developer portal :https://developers.facebook.com
     * @since 5.1.0
     * @return */
    @Method(selector = "appSpotFANAppPlacementID")
    String getFANAppPlacementID ();

    /** The AdMob Publisher Id.
     * 
     * This is the id for your app as set in AdMob, found here: http://www.admob.com/my_sites/ (click manage settings)
     * 
     * @since 4.0.0
     * @return */
    @Method(selector = "appSpotAdMobPublisherID")
    String getAdMobPublisherID ();

    /** The Mobclix Application Id.
     * 
     * This is the id for your app as set in Mobclix.
     * 
     * @since 4.0.0
     * @return */
    @Method(selector = "appSpotMobclixApplicationID")
    String getMobclixApplicationID ();

    /** The Jumptap Publisher Id.
     * 
     * This is the pub id for your app as set in Jumptap.
     * 
     * @since 4.1.2
     * @return */
    @Method(selector = "appSpotJumptapPublisherID")
    String getJumptapPublisherID ();

    /** The Jumptap Site Id.
     * 
     * This is the site id for your app as set in Jumptap. It is an optional parameter.
     * 
     * @since 4.1.2
     * @return */
    @Method(selector = "appSpotJumptapSiteID")
    String getJumptapSiteID ();

    /** Jumptap Banner Ad Spot ID
     * 
     * This is the ad spot id for a Banner (320x50) ad spot set in JumpTap.
     * 
     * @since 4.1.2
     * @return */
    @Method(selector = "appSpotJumptapBannerAdSpotID")
    String getJumptapBannerAdSpotID ();

    /** Jumptap Leaderboard Ad Spot ID
     * 
     * This is the ad spot id for a Leaderboard (720x90) ad spot set in JumpTap.
     * 
     * @since 4.1.2
     * @return */
    @Method(selector = "appSpotJumptapLeaderboardAdSpotID")
    String getJumptapLeaderboardAdSpotID ();

    /** Jumptap Medium Rectange Ad Spot ID
     * 
     * This is the ad spot id for a Medium Rectangle (320x50) ad spot set in JumpTap. The Medium Rectangle Ad Spot ID will be used
     * whenever the ad frame can fit it (e.g. interstitial ads).
     * 
     * @since 4.1.2
     * @return */
    @Method(selector = "appSpotJumptapMediumRectangleAdSpotID")
    String getJumptapMediumRectangleAdSpotID ();

    /** The Greystripe Application Id.
     * 
     * This is the id for your app as set in Greystripe.
     * 
     * @since 4.0.0
     * @return */
    @Method(selector = "appSpotGreystripeApplicationID")
    String getGreystripeApplicationID ();

    /** For networks that support accelerometer-enabled ads.
     * 
     * This method allows you to enable accelerometer based ads for networks that support this setting via the client sdk. Set to
     * {@code false} if your app uses the accelerometer to avoid conflict. Set to {@code true} if you want the special ads. Default
     * is {@code false}.
     * 
     * @since 4.0.0
     * @return */
    @Method(selector = "appSpotAccelerometerEnabled")
    boolean isAccelerometerEnabled ();
}
