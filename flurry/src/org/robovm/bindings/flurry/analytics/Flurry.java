
package org.robovm.bindings.flurry.analytics;

import java.util.Map;

import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSError;
import org.robovm.apple.foundation.NSException;
import org.robovm.apple.foundation.NSMutableDictionary;
import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.foundation.NSString;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;

/** <p>
 * Provides all available methods for defining and reporting Analytics from use of your app.
 * </p>
 * <p>
 * Set of methods that allow developers to capture detailed, aggregate information regarding the use of their app by end users.
 * </p>
 * <p>
 * This class provides methods necessary for correct function of FlurryAds.h. For information on how to use Flurry's Ads SDK to
 * attract high-quality users and monetize your user base see <a
 * href="http://support.flurry.com/index.php?title=Publishers">Support Center - Publishers</a>.
 * </p>
 * 
 * @version SDK 4.4.0 */
@NativeClass
public class Flurry extends NSObject {
	/** <p>
	 * Start a Flurry session for the project denoted by {@code apiKey}.
	 * </p>
	 * 
	 * <p>
	 * This method serves as the entry point to Flurry Analytics collection. It must be called in the scope of the Application's
	 * {@code didFinishLaunching} delegate method. The session will continue for the period the app is in the foreground until your
	 * app is backgrounded for the time specified in {@link #setSessionContinueSeconds(int)}. If the app is resumed in that period
	 * the session will continue, otherwise a new session will begin.
	 * </p>
	 * 
	 * <p>
	 * Crash reporting will not be enabled. See {@link #setCrashReportingEnabled(boolean)} for more information.
	 * </p>
	 * 
	 * <p>
	 * If testing on a simulator, please be sure to send App to background via home button. Flurry depends on the iOS lifecycle to
	 * be complete for full reporting.
	 * </p>
	 * 
	 * @see #setSessionContinueSeconds(int)
	 * @since 2.6
	 * @param apiKey The API key for this project. */
	public static void startSession (String apiKey) {
		startSession(apiKey, null);
	}

	/** <p>
	 * Start a Flurry session for the project denoted by {@code apiKey}.
	 * </p>
	 * 
	 * <p>
	 * This method serves as the entry point to Flurry Analytics collection. It must be called in the scope of the Application's
	 * {@code didFinishLaunching} delegate method. passing in the launchOptions param. The session will continue for the period the
	 * app is in the foreground until your app is backgrounded for the time specified in {@link #setSessionContinueSeconds(int)}.
	 * If the app is resumed in that period the session will continue, otherwise a new session will begin.
	 * </p>
	 * 
	 * <p>
	 * If testing on a simulator, please be sure to send App to background via home button. Flurry depends on the iOS lifecycle to
	 * be complete for full reporting.
	 * </p>
	 * 
	 * @see #setSessionContinueSeconds(int)
	 * @since 4.0.8
	 * 
	 * @param apiKey The API key for this project.
	 * @param launchOptions passed launchOptions from the application's didFinishLaunching delegate method. */
	@Method(selector = "startSession:withOptions:")
	public static native void startSession (String apiKey, NSDictionary<?, ?> launchOptions);

	/** <p>
	 * Pauses a Flurry session.
	 * </p>
	 * 
	 * <p>
	 * This method is useful in case of {@link #setBackgroundSessionEnabled(boolean)} set to {@code true}. It can be called when
	 * application finished all background tasks (such as playing music) to pause session. If the app is resumed before time
	 * specified in {@link #setSessionContinueSeconds(int)}, the session will continue, otherwise a new session will begin.
	 * </p>
	 * 
	 * @see #setSessionContinueSeconds(int)
	 * @see #setBackgroundSessionEnabled(boolean)
	 * @since 4.2.2 */
	@Method(selector = "pauseBackgroundSession")
	public static native void pauseBackgroundSession ();

	/** <p>
	 * Records an app exception. Commonly used to catch unhandled exceptions.
	 * </p>
	 * 
	 * <p>
	 * This method captures an exception for reporting to Flurry. We recommend adding an uncaught exception listener to capture any
	 * exceptions that occur during usage that is not anticipated by your app.
	 * </p>
	 * 
	 * @see #logError(String, String, NSError)
	 * @since 2.7
	 * 
	 * @param id Name of the error.
	 * @param message The message to associate with the error.
	 * @param exception The exception object to report. */
	@Method(selector = "logError:message:exception:")
	public static native void logError (String id, String message, NSException exception);

	/** <p>
	 * Records an app error.
	 * </p>
	 * 
	 * <p>
	 * This method captures an error for reporting to Flurry.
	 * </p>
	 * 
	 * @see #logError(String, String, NSException)
	 * @since 2.7
	 * 
	 * @param id Name of the error.
	 * @param message The message to associate with the error.
	 * @param error The error object to report. */
	@Method(selector = "logError:message:error:")
	public static native void logError (String id, String message, NSError error);

	/** <p>
	 * Records a custom event specified by {@code eventName}.
	 * </p>
	 * 
	 * <p>
	 * This method allows you to specify custom events within your app. As a general rule you should capture events related to user
	 * navigation within your app, any action around monetization, and other events as they are applicable to tracking progress
	 * towards your business goals.
	 * </p>
	 * 
	 * <p>
	 * You should not pass private or confidential information about your users in a custom event. <br/>
	 * Where applicable, you should make a concerted effort to use timed events with parameters (
	 * {@link #logEvent(String, NSDictionary, boolean)}) or events with parameters ({@link #logEvent(String, NSDictionary)}). This
	 * provides valuable information around the time the user spends within an action (e.g. - time spent on a level or viewing a
	 * page) or characteristics of an action (e.g. - Buy Event that has a Parameter of Widget with Value Golden Sword).
	 * </p>
	 * 
	 * @see #logEvent(String, NSDictionary)
	 * @see #logEvent(String, NSDictionary, boolean)
	 * @see #endTimedEvent(String, NSDictionary)
	 * 
	 * @since 2.8.4
	 * @param eventName Name of the event. For maximum effectiveness, we recommend using a naming scheme that can be easily
	 *           understood by non-technical people in your business domain. */
	public static void logEvent (String eventName) {
		logEvent(eventName, null, false);
	}

	/** <p>
	 * Records a custom parameterized event specified by {@code eventName} with {@code parameters}.
	 * </p>
	 * 
	 * <p>
	 * This method overrides {@link #logEvent(String)} to allow you to associate parameters with an event. Parameters are extremely
	 * valuable as they allow you to store characteristics of an action. For example, if a user purchased an item it may be helpful
	 * to know what level that user was on. By setting this parameter you will be able to view a distribution of levels for the
	 * purchased event on the <a href="http://dev.flurry.com">Flurrly Dev Portal</a>.
	 * </p>
	 * 
	 * <p>
	 * You should not pass private or confidential information about your users in a custom event. <br/>
	 * A maximum of 10 parameter names may be associated with any event. Sending over 10 parameter names with a single event will
	 * result in no parameters being logged for that event. You may specify an infinite number of Parameter values. For example, a
	 * Search Box would have 1 parameter name (e.g. - Search Box) and many values, which would allow you to see what values users
	 * look for the most in your app. <br/>
	 * Where applicable, you should make a concerted effort to use timed events with parameters (
	 * {@link #logEvent(String, NSDictionary, boolean)}). This provides valuable information around the time the user spends within
	 * an action (e.g. - time spent on a level or viewing a page).
	 * </p>
	 * 
	 * @see #logEvent(String, NSDictionary, boolean)
	 * @since 2.8.4
	 * 
	 * @param eventName Name of the event. For maximum effectiveness, we recommend using a naming scheme that can be easily
	 *           understood by non-technical people in your business domain.
	 * @param parameters A map containing Name-Value pairs of parameters. */
	public static void logEvent (String eventName, NSDictionary<NSString, NSString> parameters) {
		logEvent(eventName, parameters, false);
	}

	public static void logEvent (String eventName, Map<String, String> parameters) {
		if (parameters != null) {
			NSMutableDictionary<NSString, NSString> nsParams = new NSMutableDictionary<NSString, NSString>();
			for (java.util.Map.Entry<String, String> entry : parameters.entrySet()) {
				nsParams.put(new NSString(null != entry.getKey() ? entry.getKey() : ""),
					     new NSString(null != entry.getValue() ? entry.getValue() : ""));
			}
			logEvent(eventName, nsParams, false);
		} else {
			logEvent(eventName, false);
		}
	}

	/** <p>
	 * Records a timed event specified by {@code eventName}.
	 * </p>
	 * 
	 * <p>
	 * This method overrides {@link #logEvent(String)} to allow you to capture the length of an event. This can be extremely
	 * valuable to understand the level of engagement with a particular action. For example, you can capture how long a user spends
	 * on a level or reading an article.
	 * </p>
	 * 
	 * <p>
	 * You should not pass private or confidential information about your users in a custom event. <br/>
	 * Where applicable, you should make a concerted effort to use parameters with your timed events (
	 * {@link #logEvent(String, NSDictionary, boolean)} ). This provides valuable information around the characteristics of an
	 * action (e.g. - Buy Event that has a Parameter of Widget with Value Golden Sword).
	 * </p>
	 * 
	 * @see #logEvent(String, NSDictionary, boolean)
	 * @since 2.8.4
	 * 
	 * @param eventName Name of the event. For maximum effectiveness, we recommend using a naming scheme that can be easily
	 *           understood by non-technical people in your business domain.
	 * @param timed Specifies the event will be timed. */
	public static void logEvent (String eventName, boolean timed) {
		logEvent(eventName, null, timed);
	}

	/** <p>
	 * Records a custom parameterized timed event specified by {@code eventName} with {@code parameters}.
	 * </p>
	 * 
	 * <p>
	 * This method overrides {@link #logEvent(String)} to allow you to capture the length of an event with parameters. This can be
	 * extremely valuable to understand the level of engagement with a particular action and the characteristics associated with
	 * that action. For example, you can capture how long a user spends on a level or reading an article. Parameters can be used to
	 * capture, for example, the author of an article or if something was purchased while on the level.
	 * </p>
	 * 
	 * <p>
	 * You should not pass private or confidential information about your users in a custom event.
	 * </p>
	 * 
	 * @see #endTimedEvent(String, NSDictionary)
	 * @since 2.8.4
	 * 
	 * @param eventName Name of the event. For maximum effectiveness, we recommend using a naming scheme that can be easily
	 *           understood by non-technical people in your business domain.
	 * @param parameters A map containing Name-Value pairs of parameters.
	 * @param timed Specifies the event will be timed. */
	@Method(selector = "logEvent:withParameters:timed:")
	public static native void logEvent (String eventName, NSDictionary<NSString, NSString> parameters, boolean timed);

	/** <p>
	 * Ends a timed event specified by {@code eventName} and optionally updates parameters with {@code parameters}.
	 * </p>
	 * 
	 * <p>
	 * This method ends an existing timed event. If parameters are provided, this will overwrite existing parameters with the same
	 * name or create new parameters if the name does not exist in the parameter map set by
	 * {@link #logEvent(String, NSDictionary, boolean)}.
	 * </p>
	 * 
	 * <p>
	 * You should not pass private or confidential information about your users in a custom event. <br/>
	 * If the app is backgrounded prior to ending a timed event, the Flurry SDK will automatically end the timer on the event. <br/>
	 * {@link #endTimedEvent(String, NSDictionary)} is ignored if called on a previously terminated event.
	 * </p>
	 * 
	 * @see #logEvent(String, NSDictionary, boolean)
	 * @since 2.8.4
	 * 
	 * @param eventName Name of the event. For maximum effectiveness, we recommend using a naming scheme that can be easily
	 *           understood by non-technical people in your business domain.
	 * 
	 * @param parameters A map containing Name-Value pairs of parameters. */
	@Method(selector = "endTimedEvent:withParameters:")
	public static native void endTimedEvent (String eventName, NSDictionary<NSString, NSString> parameters);

	/** <p>
	 * Explicitly specifies the App Version that Flurry will use to group Analytics data.
	 * </p>
	 * 
	 * <p>
	 * This is an optional method that overrides the App Version Flurry uses for reporting. Flurry will use the CFBundleVersion in
	 * your info.plist file when this method is not invoked.
	 * </p>
	 * 
	 * <p>
	 * There is a maximum of 605 versions allowed for a single app.<br/>
	 * This method must be called prior to invoking {@link #startSession(String)}.
	 * </p>
	 * 
	 * @since 2.7
	 * @param version The custom version name. */
	@Method(selector = "setAppVersion:")
	public static native void setAppVersion (String version);

	/** <p>
	 * Retrieves the Flurry Agent Build Version.
	 * </p>
	 * 
	 * <p>
	 * This is an optional method that retrieves the Flurry Agent Version the app is running under. It is most often used if
	 * reporting an unexpected behavior of the SDK to <a href="mailto:iphonesupport@flurry.com"> Flurry Support</a>
	 * </p>
	 * 
	 * <p>
	 * This method must be called prior to invoking {@link #startSession(String)}. <br/>
	 * FAQ for the iPhone SDK is located at <a href="http://wiki.flurry.com/index.php?title=IPhone_FAQ"> Support Center - iPhone
	 * FAQ</a>.
	 * </p>
	 * 
	 * @see #setLogLevel
	 * @since 2.7
	 * @return The agent version of the Flurry SDK. */
	@Method(selector = "getFlurryAgentVersion")
	public static native String getFlurryAgentVersion ();

	/** <p>
	 * Displays an exception in the debug log if thrown during a Session.
	 * </p>
	 * 
	 * <p>
	 * This is an optional method that augments the debug logs with exceptions that occur during the session. You must both capture
	 * exceptions to Flurry and set debug logging to enabled for this method to display information to the console. The default
	 * setting for this method is {@code false}.
	 * </p>
	 * 
	 * <p>
	 * This method must be called prior to invoking {@link #startSession(String)}.
	 * </p>
	 * 
	 * @see #setLogLevel(FlurryLogLevel)
	 * 
	 * @since 2.7
	 * @param enabled {@code true} to show errors in debug logs, {@code false} to omit errors in debug logs. */
	@Method(selector = "setShowErrorInLogEnabled:")
	public static native void setShowErrorInLog (boolean enabled);

	/** <p>
	 * Generates debug logs to console.
	 * </p>
	 * 
	 * <p>
	 * This is an optional method that displays debug information related to the Flurry SDK. display information to the console.
	 * The default setting for this method is {@code false} which sets the log level to {@code CriticalOnly}. When set to
	 * {@code true} the debug log level is set to {@code Debug}
	 * </p>
	 * 
	 * <p>
	 * This method must be called prior to invoking {@link #startSession(String)}. If the method,
	 * {@link #setLogLevel(FlurryLogLevel)} is called later in the code, debug logging will be automatically enabled.
	 * </p>
	 * 
	 * @since 2.7
	 * 
	 * @param enabled {@code true} to show debug logs, {@code false} to omit debug logs. */
	@Method(selector = "setDebugLogEnabled:")
	public static native void setDebugLogEnabled (boolean enabled);

	/** <p>
	 * Generates debug logs to console.
	 * </p>
	 * 
	 * <p>
	 * This is an optional method that displays debug information related to the Flurry SDK. display information to the console.
	 * The default setting for this method is {@code CriticalOnly}.
	 * </p>
	 * 
	 * <p>
	 * Its good practice to call this method prior to invoking {@link #startSession(String)}. If debug logging is disabled earlier,
	 * this method will enable it.
	 * </p>
	 * 
	 * @since 4.2.2
	 * 
	 * @param level Log level */
	@Method(selector = "setLogLevel:")
	public static native void setLogLevel (FlurryLogLevel level);

	/** <p>
	 * Set the timeout for expiring a Flurry session.
	 * </p>
	 * 
	 * <p>
	 * This is an optional method that sets the time the app may be in the background before starting a new session upon resume.
	 * The default value for the session timeout is 10 seconds in the background.
	 * </p>
	 * 
	 * <p>
	 * This method must be called prior to invoking {@link #startSession(String)}.
	 * </p>
	 * 
	 * @since 2.7
	 * 
	 * @param seconds The time in seconds to set the session timeout to. */
	@Method(selector = "setSessionContinueSeconds:")
	public static native void setSessionContinueSeconds (int seconds);

	/** <p>
	 * Send data over a secure transport.
	 * </p>
	 * 
	 * <p>
	 * This is an optional method that sends data over an SSL connection when enabled. The default value is {@code false}.
	 * </p>
	 * 
	 * <p>
	 * This method must be called prior to invoking {@link #startSession(String)}.
	 * </p>
	 * 
	 * @since 3.0
	 * 
	 * @param enabled {@code true} to send data over secure connection. */
	@Method(selector = "setSecureTransportEnabled:")
	public static native void setSecureTransportEnabled (boolean enabled);

	/** <p>
	 * Enable automatic collection of crash reports.
	 * </p>
	 * 
	 * <p>
	 * This is an optional method that collects crash reports when enabled. The default value is {@code false}.
	 * </p>
	 * 
	 * <p>
	 * This method must be called prior to invoking {@link #startSession(String)}.
	 * </p>
	 * 
	 * @since 4.1
	 * 
	 * @param enabled {@code true} to enable collection of crash reports. */
	@Method(selector = "setCrashReportingEnabled:")
	public static native void setCrashReportingEnabled (boolean enabled);

	/** <p>
	 * Automatically track page views on a {@code UINavigationController} or {@code UITabBarController}.
	 * </p>
	 * 
	 * <p>
	 * This method increments the page view count for a session based on traversing a UINavigationController or UITabBarController.
	 * The page view count is only a counter for the number of transitions in your app. It does not associate a name with the page
	 * count. To associate a name with a count of occurences see {@link #logEvent(String)}.
	 * </p>
	 * 
	 * <p>
	 * Please make sure you assign the Tab and Navigation controllers to the view controllers before passing them to this method.
	 * </p>
	 * 
	 * @see #logPageView()
	 * @since 2.7
	 * 
	 * @param target The navigation or tab bar controller. */
	@Method(selector = "logAllPageViews:")
	public static native void logAllPageViews (NSObject target);

	/** <p>
	 * Explicitly track a page view during a session.
	 * </p>
	 * 
	 * <p>
	 * This method increments the page view count for a session when invoked. It does not associate a name with the page count. To
	 * associate a name with a count of occurrences see {@link #logEvent(String)}.
	 * </p>
	 * 
	 * @see #logAllPageViews(NSObject) for details on automatically incrementing page view count based on user traversing
	 *      navigation or tab bar controller.
	 * @since 2.7 */
	@Method(selector = "logPageView")
	public static native void logPageView ();

	/** <p>
	 * Assign a unique id for a user in your app.
	 * </p>
	 * 
	 * <p>
	 * Please be sure not to use this method to pass any private or confidential information about the user.
	 * </p>
	 * 
	 * @since 2.7
	 * 
	 * @param userID The app id for a user. */
	@Method(selector = "setUserID:")
	public static native void setUserId (String userId);

	/** <p>
	 * Set your user's age in years.
	 * </p>
	 * 
	 * <p>
	 * Use this method to capture the age of your user. Only use this method if you collect this information explicitly from your
	 * user (i.e. - there is no need to set a default value).
	 * </p>
	 * 
	 * <p>
	 * The age is aggregated across all users of your app and not available on a per user basis.
	 * </p>
	 * 
	 * @since 2.7
	 * 
	 * @param age Reported age of user. */
	@Method(selector = "setAge:")
	public static native void setAge (int age);

	/** <p>
	 * Set your user's gender.
	 * </p>
	 * 
	 * <p>
	 * Use this method to capture the gender of your user. Only use this method if you collect this information explicitly from
	 * your user (i.e. - there is no need to set a default value). Allowable values are {@code "m"} or {@code "f"}.
	 * </p>
	 * 
	 * <p>
	 * The gender is aggregated across all users of your app and not available on a per user basis.
	 * </p>
	 * 
	 * @since 2.7
	 * 
	 * @param gender Reported gender of user. */
	@Method(selector = "setGender:")
	public static native void setGender (String gender);

	/** <p>
	 * Set the location of the session.
	 * </p>
	 * 
	 * <p>
	 * Use information from the CLLocationManager to specify the location of the session. Flurry does not automatically track this
	 * information or include the {@code CLLocation} framework.
	 * </p>
	 * 
	 * <p>
	 * Only the last location entered is captured per session. <br/>
	 * Regardless of accuracy specified, the Flurry SDK will only report location at city level or higher. <br/>
	 * Location is aggregated across all users of your app and not available on a per user basis. <br/>
	 * This information should only be captured if it is germaine to the use of your app.
	 * </p>
	 * 
	 * <p>
	 * After starting the location manager, you can set the location with Flurry. You can implement
	 * {@code CLLocationManagerDelegate} to be aware of when the location is updated. Below is an example of how to use this method,
	 * after you have received a location update from the locationManager.
	 * </p>
	 * 
	 * @since 2.7
	 * 
	 * @param latitude The latitude.
	 * @param longitude The longitude.
	 * @param horizontalAccuracy The radius of uncertainty for the location in meters.
	 * @param verticalAccuracy The accuracy of the altitude value in meters. */
	@Method(selector = "setLatitude:longitude:horizontalAccuracy:verticalAccuracy:")
	public static native void setLocation (double latitude, double longitude, float horizontalAccuracy, float verticalAccuracy);

	/** <p>
	 * Set session to report when app closes.
	 * </p>
	 * 
	 * <p>
	 * Use this method report session data when the app is closed. The default value is {@code true}.
	 * </p>
	 * 
	 * <p>
	 * This method is rarely invoked in iOS >= 3.2 due to the updated iOS lifecycle.
	 * </p>
	 * 
	 * @since 2.7
	 * @see #setSessionReportsOnPauseEnabled(boolean)
	 * 
	 * @param enabled {@code true} to send on close, {@code false} to omit reporting on close. */
	@Method(selector = "setSessionReportsOnCloseEnabled:")
	public static native void setSessionReportsOnCloseEnabled (boolean enabled);

	/** <p>
	 * Set session to report when app is sent to the background.
	 * </p>
	 * 
	 * <p>
	 * Use this method report session data when the app is paused. The default value is{@code true}.
	 * </p>
	 * 
	 * @since 2.7
	 * @see #setSessionReportsOnCloseEnabled(boolean)
	 * 
	 * @param enabled {@code true} to send on pause, {@code false} to omit reporting on pause. */
	@Method(selector = "setSessionReportsOnPauseEnabled:")
	public static native void setSessionReportsOnPauseEnabled (boolean enabled);

	/** <p>
	 * Set session to support background execution.
	 * </p>
	 * 
	 * <p>
	 * Use this method finish session data when the app is paused. The default value is taken looking at the UIBackgroundModes of
	 * application's Info.plist. If UIBackgroundModes array is empty, equals {@code false}, otherwise {@code true}.
	 * </p>
	 * 
	 * @since 4.2.2
	 * 
	 * @param enabled {@code false} to finish on resigning active, {@code true} to omit finishing.</p> */
	@Method(selector = "setBackgroundSessionEnabled:")
	public static native void setBackgroundSessionEnabled (boolean enabled);

	/** <p>
	 * Enable custom event logging.
	 * </p>
	 * 
	 * <p>
	 * Use this method to allow the capture of custom events. The default value is {@code true}.
	 * </p>
	 * 
	 * @since 2.7
	 * 
	 * @param enabled {@code true} to enable event logging, {@code false} to stop custom logging. */
	@Method(selector = "setEventLoggingEnabled:")
	public static native void setEventLoggingEnabled (boolean enabled);

	/** <p>
	 * Set device push token.
	 * </p>
	 * 
	 * <p>
	 * After the device has successfully registered with APNS, call this method to set the push token received from APNS.
	 * </p>
	 * 
	 * @since 2.7
	 * 
	 * @param pushToken */
	@Method(selector = "setPushToken:")
	public static native void setPushToken (String pushToken);
}
