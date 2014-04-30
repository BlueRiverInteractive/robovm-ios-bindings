
package org.robovm.bindings.tapjoy;

public class TapjoyConstants {
	public static final String TJC_CONNECT_SUCCESS = "TJC_Connect_Success";
	public static final String TJC_CONNECT_FAILED = "TJC_Connect_Failed";

	/** This notification is fired after getTapPoints has been called, and indicates that user currency amount has been received
	 * from the server. */
	public static final String TJC_TAP_POINTS_RESPONSE_NOTIFICATION = "TJC_TAP_POINTS_RESPONSE_NOTIFICATION";
	/** This notification is fired after spendTapPoints has been called, and indicates that the user has successfully spent
	 * currency. */
	public static final String TJC_SPEND_TAP_POINTS_RESPONSE_NOTIFICATION = "TJC_SPEND_TAP_POINTS_RESPONSE_NOTIFICATION";
	/** This notification is fired after awardTapPoints has been called, and indicates that the user has successfully been awarded
	 * currency. */
	public static final String TJC_AWARD_TAP_POINTS_RESPONSE_NOTIFICATION = "TJC_AWARD_TAP_POINTS_RESPONSE_NOTIFICATION";

	/** Error notification for getTapPoints. */
	public static final String TJC_TAP_POINTS_RESPONSE_NOTIFICATION_ERROR = "TJC_TAP_POINTS_RESPONSE_NOTIFICATION_ERROR";
	/** Error notification for spendTapPoints. */
	public static final String TJC_SPEND_TAP_POINTS_RESPONSE_NOTIFICATION_ERROR = "TJC_SPEND_TAP_POINTS_RESPONSE_NOTIFICATION_ERROR";
	/** Error notification for awardTapPoints. */
	public static final String TJC_AWARD_TAP_POINTS_RESPONSE_NOTIFICATION_ERROR = "TJC_AWARD_TAP_POINTS_RESPONSE_NOTIFICATION_ERROR";

	/** Notification that is fired after an event has been logged. */
	public static final String TJC_EVENT_TRACKING_RESPONSE_NOTIFICATION = "TJC_EVENT_TRACKING_RESPONSE_NOTIFICATION";
	/** Error notification for Event Tracking. */
	public static final String TJC_EVENT_TRACKING_RESPONSE_NOTIFICATION_ERROR = "TJC_EVENT_TRACKING_RESPONSE_NOTIFICATION_ERROR";

	/** Full Screen Ad notification is fired after full screen ad data is received from the server. */
	public static final String TJC_FULL_SCREEN_AD_RESPONSE_NOTIFICATION = "TJC_FULL_SCREEN_AD_RESPONSE_NOTIFICATION";
	/** Error notification for Full Screen Ad. */
	public static final String TJC_FULL_SCREEN_AD_RESPONSE_NOTIFICATION_ERROR = "TJC_FULL_SCREEN_AD_RESPONSE_NOTIFICATION_ERROR";

	/** Offers notification is fired after the ad data is loaded. */
	public static final String TJC_OFFERS_RESPONSE_NOTIFICATION = "TJC_OFFERS_RESPONSE_NOTIFICATION";
	/** Error notification for offers. */
	public static final String TJC_OFFERS_RESPONSE_NOTIFICATION_ERROR = "TJC_OFFERS_RESPONSE_NOTIFICATION_ERROR";

	/** Notification that a user has just successfully completed an offer and earned currency. This only fires on init/resume. */
	public static final String TJC_TAPPOINTS_EARNED_NOTIFICATION = "TJC_TAPPOINTS_EARNED_NOTIFICATION";

	/** Fired when any Tapjoy view is closed. */
	public static final String TJC_VIEW_CLOSED_NOTIFICATION = "TJC_VIEW_CLOSED_NOTIFICATION";

	/** Fired when a webview fails to load */
	public static final String TJC_VIEW_LOADING_ERROR_NOTIFICATION = "TJC_VIEW_LOADING_ERROR_NOTIFICATION";

	/** The keys for the options dictionary when calling requestTapjoyConnect. */
	public static final String TJC_OPTION_DISABLE_VIDEOS = "TJC_OPTION_DISABLE_VIDEOS";
	public static final String TJC_OPTION_VIDEO_CACHE_COUNT = "TJC_OPTION_VIDEO_CACHE_COUNT";
	public static final String TJC_OPTION_FULL_SCREEN_AD_DELAY_COUNT = "TJC_OPTION_FULL_SCREEN_AD_DELAY_COUNT";
	public static final String TJC_OPTION_ENABLE_LOGGING = "TJC_OPTION_ENABLE_LOGGING";
	public static final String TJC_OPTION_USER_ID = "TJC_OPTION_USER_ID";
	public static final String TJC_OPTION_TRANSITION_EFFECT = "TJC_OPTION_TRANSITION_EFFECT";
	public static final String TJC_OPTION_CLEAR_SHARED_URL_CACHE = "TJC_OPTION_CLEAR_SHARED_URL_CACHE";
	public static final String TJC_OPTION_COLLECT_MAC_ADDRESS = "TJC_OPTION_COLLECT_MAC_ADDRESS";
	public static final String TJC_OPTION_DISABLE_GENERIC_ERROR_ALERT = "TJC_OPTION_DISABLE_GENERIC_ERROR_ALERT";
	public static final String TJC_OPTION_SEGMENTATION_PARAMS = "TJC_OPTION_SEGMENTATION_PARAMS";

	public static final String TJC_DISPLAY_AD_SIZE_320X50 = "320x50";
	public static final String TJC_DISPLAY_AD_SIZE_640X100 = "640x100";
	public static final String TJC_DISPLAY_AD_SIZE_768X90 = "768x90";
}
