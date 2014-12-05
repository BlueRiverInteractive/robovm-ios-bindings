
package org.robovm.bindings.mobileapptracking;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSData;
import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.foundation.NSUUID;
import org.robovm.apple.storekit.SKPaymentTransactionState;
import org.robovm.apple.uikit.UIApplication;
import org.robovm.apple.uikit.UIApplicationDelegate;
import org.robovm.apple.uikit.UIView;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.MachineSizedFloat;
import org.robovm.rt.bro.annotation.MachineSizedSInt;
import org.robovm.rt.bro.annotation.MachineSizedUInt;

/** MobileAppTracker provides the methods to send events and actions to the HasOffers servers. */
@NativeClass
public class MobileAppTracker extends NSObject {

    /** Starts Mobile App Tracker with MAT Advertiser ID and MAT Conversion Key. Both values are required.
     * @param aid the MAT Advertiser ID provided in Mobile App Tracking.
     * @param key the MAT Conversion Key provided in Mobile App Tracking. */
    @Method(selector = "initializeWithMATAdvertiserId:MATConversionKey:")
    public static native void start (String aid, String key);

    /** Set the delegate used by the MobileAppTracker to post success and failure callbacks from the MAT servers.
     * @param delegate */
    @Method(selector = "setDelegate:")
    public static native void setDelegate (MobileAppTrackerDelegate delegate);

    /** Set the delegate used by the MobileAppTracker to post geofencing boundary notifications. */
    @Method(selector = "setRegionDelegate:")
    public static native void setRegionDelegate (MobileAppTrackerRegionDelegate delegate);

    /** Specifies that the server responses should include debug information.
     * @warning This is only for testing. You must turn this off for release builds.
     * @param debug defaults to {@code false}. */
    @Method(selector = "setDebugMode:")
    public static native void setDebugMode (boolean debug);

    /** Set to {@code true} to allow duplicate requests to be registered with the MAT server.
     * @warning This is only for testing. You must turn this off for release builds.
     * @param allowDuplicateRequests defaults to {@code false}. */
    @Method(selector = "setAllowDuplicateRequests:")
    public static native void setAllowDuplicateRequests (boolean allowDuplicateRequests);

    /** Set whether this is an existing user or a new one. This is generally used to distinguish users who were using previous
     * versions of the app, prior to integration of the MAT SDK. The default is to assume a new user.
     * @see <a href="http://support.mobileapptracking.com/entries/22621001-Handling-Installs-prior-to-SDK-implementation">Handling
     *      Installs prior to SDK implementation</a>
     * @param existingUser Is this a pre-existing user of the app? Default: {@code false} */
    @Method(selector = "setExistingUser:")
    public static native void setExistingUser (boolean existingUser);

    /** Set the Apple Advertising Identifier available in iOS 6.
     * @param appleAdvertisingIdentifier Apple Advertising Identifier
     * @param adTrackingEnabled */
    @Method(selector = "setAppleAdvertisingIdentifier:advertisingTrackingEnabled:")
    public static native void setAppleAdvertisingIdentifier (NSUUID appleAdvertisingIdentifier, boolean adTrackingEnabled);

    /** Set the Apple Vendor Identifier available in iOS 6.
     * @param appleVendorIdentifier Apple Vendor Identifier */
    @Method(selector = "setAppleVendorIdentifier:")
    public static native void setAppleVendorIdentifier (NSUUID appleVendorIdentifier);

    /** Sets the currency code. Default: USD
     * @param currencyCode The string name for the currency code. */
    @Method(selector = "setCurrencyCode:")
    public static native void setCurrencyCode (String currencyCode);

    /** Sets the jailbroken device flag.
     * @param jailbroken The jailbroken device flag. */
    @Method(selector = "setJailbroken:")
    public static native void setJailbroken (boolean yailbroken);

    /** Sets the package name (bundle identifier). Defaults to the Bundle Identifier of the app that is running the sdk.
     * @param packageName The string name for the package. */
    @Method(selector = "setPackageName:")
    public static native void setPackageName (String packageName);

    /** Specifies if the sdk should auto detect if the iOS device is jailbroken.
     * @param autoDetect {@code true} will detect if the device is jailbroken, defaults to {@code true}. */
    @Method(selector = "setShouldAutoDetectJailbroken:")
    public static native void setShouldAutoDetectJailbroken (boolean autoDetect);

    /** Specifies if the sdk should pull the Apple Vendor Identifier from the device.
     * 
     * Note that setting to {@code false} will clear any previously set value for the property.
     * @param autoGenerate {@code true} will set the Apple Vendor Identifier, defaults to {@code true}. */
    @Method(selector = "setShouldAutoGenerateAppleVendorIdentifier:")
    public static native void setShouldAutoGenerateAppleVendorIdentifier (boolean autoGenerate);

    /** Sets the site ID.
     * @param siteId The MAT app/site ID of this mobile app. */
    @Method(selector = "setSiteId:")
    public static native void setSiteId (String siteId);

    /** Set the TRUSTe Trusted Preference Identifier (TPID).
     * @param tpid Trusted Preference Identifier */
    @Method(selector = "setTRUSTeId:")
    public static native void setTRUSTeId (String tpid);

    /** Sets the user's email address.
     * @param userEmail The user's email address. */
    @Method(selector = "setUserEmail:")
    public static native void setUserEmail (String userEmail);

    /** Sets the user ID.
     * @param userId The string name for the user ID. */
    @Method(selector = "setUserId:")
    public static native void setUserId (String userId);

    /** Sets the user's name.
     * @param userName The user's name. */
    @Method(selector = "setUserName:")
    public static native void setUserName (String userName);

    /** Set user's Facebook ID.
     * @param facebookUserId string containing the user's Facebook user ID. */
    @Method(selector = "setFacebookUserId:")
    public static native void setFacebookUserId (String facebookUserId);

    /** Set user's Twitter ID.
     * @param twitterUserId string containing the user's Twitter user ID. */
    @Method(selector = "setTwitterUserId:")
    public static native void setTwitterUserId (String twitterUserId);

    /** Set user's Google ID.
     * @param googleUserId string containing the user's Google user ID. */
    @Method(selector = "setGoogleUserId:")
    public static native void setGoogleUserId (String googleUserId);

    /** Sets the user's age.
     * @param userAge user's age */
    @Method(selector = "setAge:")
    public static native void setAge (@MachineSizedSInt long userAge);

    /** Sets the user's gender.
     * @param userGender user's gender */
    @Method(selector = "setGender:")
    public static native void setGender (MATGender userGender);

    /** Sets the user's location.
     * @param latitude user's latitude
     * @param longitude user's longitude */
    @Method(selector = "setLatitude:longitude:")
    public static native void setLocation (double latitude, double longitude);

    /** Sets the user's location including altitude.
     * @param latitude user's latitude
     * @param longitude user's longitude
     * @param altitude user's altitude */
    @Method(selector = "setLatitude:longitude:altitude:")
    public static native void setLocation (double latitude, double longitude, double altitude);

    /** Set app-level ad-tracking.
     * @param enable {@code true} means opt-in, {@code false} means opt-out. */
    @Method(selector = "setAppAdTracking:")
    public static native void setAppAdTracking (boolean enable);

    /** Set the name of plugin used, if any. Not for general use.
     * @param pluginName */
    @Method(selector = "setPluginName:")
    public static native void setPluginName (String pluinName);

    /** Set whether the user is generating revenue for the app or not. If measureAction is called with a non-zero revenue, this is
     * automatically set to {@code true}.
     * @param isPayingUser {@code true} if the user is revenue-generating, {@code false} if not */
    @Method(selector = "setPayingUser:")
    public static native void setPayingUser (boolean isPayingUser);

    /** Set the content type associated with the next action (e.g., "shoes"). Will be cleared after the next measurement call.
     * @param contentType */
    @Method(selector = "setEventContentType:")
    public static native void setEventContentType (String contentType);

    /** Set the content ID associated with the next action (International Article Number (EAN) when applicable, or other product or
     * content identifier). Will be cleared after the next measurement call.
     * @param contentId */
    @Method(selector = "setEventContentId:")
    public static native void setEventContentId (String contentId);

    /** Set the level associated with the next action (e.g., for a game). Will be cleared after the next measurement call.
     * @param level */
    @Method(selector = "setEventLevel:")
    public static native void setEventLevel (@MachineSizedSInt long level);

    /** Set the quantity associated with the next action (e.g., number of items). Will be cleared after the next measurement call.
     * @param quantity */
    @Method(selector = "setEventQuantity:")
    public static native void setEventQuantity (@MachineSizedSInt long quantity);

    /** Set the search string associated with the next action. Will be cleared after the next measurement call.
     * @param search string */
    @Method(selector = "setEventSearchString:")
    public static native void setEventSearchString (String searchString);

    /** Set the rating associated with the next action (e.g., a user rating an item). Will be cleared after the next measurement
     * call.
     * @param rating */
    @Method(selector = "setEventRating:")
    public static native void setEventRating (@MachineSizedFloat double rating);

    /** Set the first date associated with the next action (e.g., user's check-in time). Will be cleared after the next measurement
     * call.
     * @param date */
    @Method(selector = "setEventDate1:")
    public static native void setEventDate1 (NSData date);

    /** Set the second date associated with the next action (e.g., user's check-out time). Will be cleared after the next
     * measurement call.
     * @param date */
    @Method(selector = "setEventDate2:")
    public static native void setEventDate2 (NSData date);

    /** Set the first attribute to be included in the next action. Will be cleared after the next measurement call.
     * @param value */
    @Method(selector = "setEventAttribute1:")
    public static native void setEventAttribute1 (String value);

    /** Set the second attribute to be included in the next action. Will be cleared after the next measurement call.
     * @param value */
    @Method(selector = "setEventAttribute2:")
    public static native void setEventAttribute2 (String value);

    /** Set the third attribute to be included in the next action. Will be cleared after the next measurement call.
     * @param value */
    @Method(selector = "setEventAttribute3:")
    public static native void setEventAttribute3 (String value);

    /** Set the fourth attribute to be included in the next action. Will be cleared after the next measurement call.
     * @param value */
    @Method(selector = "setEventAttribute4:")
    public static native void setEventAttribute4 (String value);

    /** Set the fifth attribute to be included in the next action. Will be cleared after the next measurement call.
     * @param value */
    @Method(selector = "setEventAttribute5:")
    public static native void setEventAttribute5 (String value);

    /** Get the MAT ID for this installation (mat_id).
     * @return MAT ID */
    @Method(selector = "matId")
    public static native String getMatId ();

    /** Get the MAT log ID for the first app open (open_log_id).
     * @return open log ID */
    @Method(selector = "openLogId")
    public static native String getOpenLogId ();

    /** Get whether the user is revenue-generating.
     * @return {@code true} if the user has produced revenue, {@code false} if not */
    @Method(selector = "isPayingUser")
    public static native boolean isPayingUser ();

    /** Display an iAd banner in a parent view. The parent view will be faded in and out when an iAd is received or failed to
     * display. The MobileAppTracker's delegate object will receive notifications when this happens. */
    @Method(selector = "displayiAdInView:")
    public static native void displayiAd (UIView view);

    /** Removes the currently displayed iAd, if any. */
    @Method
    public static native void removeiAd ();

    /** To be called when an app opens; typically in the {@link UIApplicationDelegate#didBecomeActive(UIApplication)} event. */
    @Method
    public static native void measureSession ();

    /** Record an Action for an Event Name.
     * @param eventName The event name. */
    @Method(selector = "measureAction:")
    public static native void measureAction (String eventName);

    /** Record an Action for an Event Name and reference ID.
     * @param eventName The event name.
     * @param refId The reference ID for an event, corresponds to advertiser_ref_id on the website. */
    @Method(selector = "measureAction:referenceId:")
    public static native void measureAction (String eventName, String refId);

    /** Record an Action for an Event Name, revenue and currency.
     * @param eventName The event name.
     * @param revenueAmount The revenue amount for the event.
     * @param currencyCode The currency code override for the event. Blank defaults to sdk setting. */
    @Method(selector = "measureAction:revenueAmount:currencyCode:")
    public static native void measureAction (String eventName, float revenueAmount, String currencyCode);

    /** Record an Action for an Event Name and reference ID, revenue and currency.
     * @param eventName The event name.
     * @param refId The reference ID for an event, corresponds to advertiser_ref_id on the website.
     * @param revenueAmount The revenue amount for the event.
     * @param currencyCode The currency code override for the event. Blank defaults to sdk setting. */
    @Method(selector = "measureAction:referenceId:revenueAmount:currencyCode:")
    public static native void measureAction (String eventName, String refId, float revenueAmount, String currencyCode);

    /** Record an Action for an Event ID.
     * @param eventId The event ID. */
    @Method(selector = "measureActionWithEventId:")
    public static native void measureAction (@MachineSizedSInt long eventId);

    /** Record an Action for an Event ID and reference id.
     * @param eventId The event ID.
     * @param refId The reference ID for an event, corresponds to advertiser_ref_id on the website. */
    @Method(selector = "measureActionWithEventId:referenceId:")
    public static native void measureAction (@MachineSizedSInt long eventId, String refId);

    /** Record an Action for an Event ID, revenue and currency.
     * @param eventId The event ID.
     * @param revenueAmount The revenue amount for the event.
     * @param currencyCode The currency code override for the event. Blank defaults to sdk setting. */
    @Method(selector = "measureActionWithEventId:revenueAmount:currencyCode:")
    public static native void measureAction (@MachineSizedSInt long eventId, float revenueAmount, String currencyCode);

    /** Record an Action for an Event ID and reference id, revenue and currency.
     * @param eventId The event ID.
     * @param refId The reference ID for an event, corresponds to advertiser_ref_id on the website.
     * @param revenueAmount The revenue amount for the event.
     * @param currencyCode The currency code override for the event. Blank defaults to sdk setting. */
    @Method(selector = "measureActionWithEventId:referenceId:revenueAmount:currencyCode:")
    public static native void measureAction (@MachineSizedSInt long eventId, String refId, float revenueAmount,
        String currencyCode);

    /** Record an Action for an Event Name and a list of event items.
     * @param eventName The event name.
     * @param eventItems An array of MATEventItem objects */
    @Method(selector = "measureAction:eventItems:")
    public static native void measureAction (String eventName, NSArray<MATEventItem> eventItems);

    /** Record an Action for an Event Name.
     * @param eventName The event name.
     * @param eventItems An array of MATEventItem objects
     * @param refId The reference ID for an event, corresponds to advertiser_ref_id on the website. */
    @Method(selector = "measureAction:eventItems:referenceId:")
    public static native void measureAction (String eventName, NSArray<MATEventItem> eventItems, String refId);

    /** Record an Action for an Event Name.
     * @param eventName The event name.
     * @param eventItems An array of MATEventItem objects
     * @param revenueAmount The revenue amount for the event.
     * @param currencyCode The currency code override for the event. Blank defaults to sdk setting. */
    @Method(selector = "measureAction:eventItems:revenueAmount:currencyCode:")
    public static native void measureAction (String eventName, NSArray<MATEventItem> eventItems, float revenueAmount,
        String currencyCode);

    /** Record an Action for an Event Name.
     * @param eventName The event name.
     * @param eventItems An array of MATEventItem objects
     * @param refId The reference ID for an event, corresponds to advertiser_ref_id on the website.
     * @param revenueAmount The revenue amount for the event.
     * @param currencyCode The currency code override for the event. Blank defaults to sdk setting. */
    @Method(selector = "measureAction:eventItems:referenceId:revenueAmount:currencyCode:")
    public static native void measureAction (String eventName, NSArray<MATEventItem> eventItems, String refId,
        float revenueAmount, String currencyCode);

    /** Record an Action for an Event Name.
     * @param eventName The event name.
     * @param eventItems An array of MATEventItem objects
     * @param refId The reference ID for an event, corresponds to advertiser_ref_id on the website.
     * @param revenueAmount The revenue amount for the event.
     * @param currencyCode The currency code override for the event. Blank defaults to sdk setting.
     * @param transactionState The in-app purchase transaction SKPaymentTransactionState as received from the iTunes store. */
    @Method(selector = "measureAction:eventItems:referenceId:revenueAmount:currencyCode:transactionState:")
    public static native void measureAction (String eventName, NSArray<MATEventItem> eventItems, String refId,
        float revenueAmount, String currencyCode, SKPaymentTransactionState transactionState);

    /** Record an Action for an Event Name.
     * @param eventName The event name.
     * @param eventItems An array of MATEventItem objects
     * @param refId The reference ID for an event, corresponds to advertiser_ref_id on the website.
     * @param revenueAmount The revenue amount for the event.
     * @param currencyCode The currency code override for the event. Blank defaults to sdk setting.
     * @param transactionState The in-app purchase transaction SKPaymentTransactionState as received from the iTunes store.
     * @param receipt The in-app purchase transaction receipt as received from the iTunes store. */
    @Method(selector = "measureAction:eventItems:referenceId:revenueAmount:currencyCode:transactionState:receipt:")
    public static native void measureAction (String eventName, NSArray<MATEventItem> eventItems, String refId,
        float revenueAmount, String currencyCode, SKPaymentTransactionState transactionState, NSData receipt);

    /** Record an Action for an Event ID and a list of event items.
     * @param eventId The event ID.
     * @param eventItems An array of MATEventItem objects */
    @Method(selector = "measureActionWithEventId:eventItems:")
    public static native void measureAction (@MachineSizedSInt long eventId, NSArray<MATEventItem> eventItems);

    /** Record an Action for an Event ID.
     * @param eventId The event ID.
     * @param eventItems An array of MATEventItem objects
     * @param refId The reference ID for an event, corresponds to advertiser_ref_id on the website. */
    @Method(selector = "measureActionWithEventId:eventItems:referenceId:")
    public static native void measureAction (@MachineSizedSInt long eventId, NSArray<MATEventItem> eventItems, String refId);

    /** Record an Action for an Event ID.
     * @param eventId The event ID.
     * @param eventItems An array of MATEventItem objects
     * @param revenueAmount The revenue amount for the event.
     * @param currencyCode The currency code override for the event. Blank defaults to sdk setting. */
    @Method(selector = "measureActionWithEventId:eventItems:revenueAmount:currencyCode:")
    public static native void measureAction (@MachineSizedSInt long eventId, NSArray<MATEventItem> eventItems,
        float revenueAmount, String currencyCode);

    /** Record an Action for an Event ID.
     * @param eventId The event ID.
     * @param eventItems An array of MATEventItem objects
     * @param refId The reference ID for an event, corresponds to advertiser_ref_id on the website.
     * @param revenueAmount The revenue amount for the event.
     * @param currencyCode The currency code override for the event. Blank defaults to sdk setting. */
    @Method(selector = "measureActionWithEventId:eventItems:referenceId:revenueAmount:currencyCode:")
    public static native void measureAction (@MachineSizedSInt long eventId, NSArray<MATEventItem> eventItems, String refId,
        float revenueAmount, String currencyCode);

    /** Record an Action for an Event ID.
     * @param eventId The event ID.
     * @param eventItems An array of MATEventItem objects
     * @param refId The reference ID for an event, corresponds to advertiser_ref_id on the website.
     * @param revenueAmount The revenue amount for the event.
     * @param currencyCode The currency code override for the event. Blank defaults to sdk setting.
     * @param transactionState The in-app purchase transaction SKPaymentTransactionState as received from the iTunes store. */
    @Method(selector = "measureActionWithEventId:eventItems:referenceId:revenueAmount:currencyCode:transactionState:")
    public static native void measureAction (@MachineSizedSInt long eventId, NSArray<MATEventItem> eventItems, String refId,
        float revenueAmount, String currencyCode, SKPaymentTransactionState transactionState);

    /** Record an Action for an Event ID.
     * @param eventId The event ID.
     * @param eventItems An array of MATEventItem objects
     * @param refId The reference ID for an event, corresponds to advertiser_ref_id on the website.
     * @param revenueAmount The revenue amount for the event.
     * @param currencyCode The currency code override for the event. Blank defaults to sdk setting.
     * @param transactionState The in-app purchase transaction SKPaymentTransactionState as received from the iTunes store.
     * @param receipt The in-app purchase transaction receipt as received from the iTunes store. */
    @Method(selector = "measureActionWithEventId:eventItems:referenceId:revenueAmount:currencyCode:transactionState:receipt:")
    public static native void measureAction (@MachineSizedSInt long eventId, NSArray<MATEventItem> eventItems, String refId,
        float revenueAmount, String currencyCode, SKPaymentTransactionState transactionState, NSData receipt);

    /** Sets whether or not to user cookie based tracking. Default: {@code false}
     * @param cookieTracking {@code true/false} for cookie based tracking. */
    @Method(selector = "setUseCookieTracking:")
    public static native void setUseCookieTracking (boolean cookieTracking);

    /** Sets a url to be used with app-to-app tracking so that the sdk can open the download (redirect) url. This is used in
     * conjunction with the {@link #startAppToAppTracking(String, String, String, String, boolean)} method.
     * @param redirectURL The string name for the url. */
    @Method(selector = "setRedirectUrl:")
    public static native void setRedirectUrl (String redirectURL);

    /** Start an app-to-app tracking session on the MAT server.
     * @param targetAppPackageName The bundle identifier of the target app.
     * @param targetAppAdvertiserId The MAT advertiser ID of the target app.
     * @param offerId The MAT offer ID of the target app.
     * @param publisherId The MAT publisher ID of the target app.
     * @param shouldRedirect Should redirect to the download url if the tracking session was successfully created. See
     *            setRedirectUrl:. */
    @Method(selector = "startAppToAppTracking:advertiserId:offerId:publisherId:redirect:")
    public static native void startAppToAppTracking (String targetAppPackageName, String targetAppAdvertiserId,
        String targetAdvertiserOfferId, String targetAdvertiserPublisherId, boolean shouldRedirect);

    /** Record the URL and Source when an application is opened via a URL scheme. This typically occurs during OAUTH or when an app
     * exits and is returned to via a URL. The data will be sent to the HasOffers server so that a Re-Engagement can be recorded.
     * @param urlString the url string used to open your app.
     * @param sourceApplication the source used to open your app. For example, mobile safari. */
    @Method(selector = "applicationDidOpenURL:sourceApplication:")
    public static native void didOpenURL (String urlString, String sourceApplication);

    /** Begin monitoring for an iBeacon region. Boundary-crossing events will be recorded by the MAT servers for event attribution.
     * 
     * When the first region is added, the user will immediately be prompted for use of their location, unless they have already
     * granted it to the app.
     * @param UUID The region's universal unique identifier (required).
     * @param nameId The region's name, as programmed into the beacon (required).
     * @param majorId A subregion's major identifier (optional, send 0)
     * @param minorId A sub-subregion's minor identifier (optional, send 0) */
    @Method(selector = "startMonitoringForBeaconRegion:nameId:majorId:minorId:")
    public static native void startMonitoringForBeaconRegion (NSUUID uuid, String nameId, @MachineSizedUInt long majorId,
        @MachineSizedUInt long minorId);

}
