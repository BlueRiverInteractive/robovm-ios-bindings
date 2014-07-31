
package org.robovm.bindings.bugsense;

import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSException;
import org.robovm.apple.uikit.UIAlertViewDelegateAdapter;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;

@NativeClass
public class BugSenseController extends UIAlertViewDelegateAdapter {

    /** Creates and returns a singleton crash controller instance with the given API key. If a singleton has already been created,
     * this method has no effect.
     * @param APIKey The BugSense API key
     * @return A new singleton crash controller with the given API key, or an existing controller with no changes to it (has the
     *         API key of its original call). */
    @Method(selector = "sharedControllerWithBugSenseAPIKey:")
    public static native BugSenseController createSharedController (String apiKey);

    /** Creates and returns a singleton crash controller instance with the given API key and user dictionary. If a singleton has
     * already been created, this method has no effect.
     * @param APIKey The BugSense API key
     * @param userDictionary A dictionary containing custom, user-defined data.
     * @return A new singleton crash controller with the given values, or an existing controller with no changes to it (has the
     *         values of its original call). */
    @Method(selector = "sharedControllerWithBugSenseAPIKey:userDictionary:")
    public static native BugSenseController createSharedController (String apiKey, NSDictionary<?, ?> userDictionary);

    /** Creates and returns a singleton crash controller instance with the given API key, user dictionary and option whether to
     * send crash reports immediately or not. If a singleton has already been created, this method has no effect.
     * @warning This is the designated initializer.
     * @param APIKey The BugSense API key
     * @param userDictionary A dictionary containing custom, user-defined data.
     * @param immediately A value indicating whether the reports should be sent immediately to the service (if YES) or on relaunch
     *            (if NO).
     * @return A new singleton crash controller with the given values, or an existing controller with no changes to it (has the
     *         values of its original call). */
    @Method(selector = "sharedControllerWithBugSenseAPIKey:userDictionary:sendImmediately:")
    public static native BugSenseController createSharedController (String apiKey, NSDictionary<?, ?> userDictionary,
        boolean sendImmediately);

    /** Returns the singleton crash controller instance.
     * @warning This method cannot be used to create a new instance. It can only be used to refer to an existing singleton crash
     *          controller instance, in conjunction with any of the instance methods specified for this class.
     * @return The existing singleton crash controller instance or nil, if none was found. */
    @Method(selector = "sharedController")
    public static native BugSenseController sharedController ();

    /** Configures the plugin to use an alternate url endpoint, mainly for users in China and other countries where the IPs that
     * BugSense normally uses are blocked.
     * @param flag A boolean specifying if the alternate url endpoint should be enabled or not. */
    @Method(selector = "setUsesProxy:")
    public static native void setUsesProxy (boolean flag);

    /** Configures the log messages line count to be sent along with crashes.
     * @param count An unsigned long specifying the maximum lines that should be saved. */
    @Method(selector = "setLogMessagesCount:")
    public static native void setLogMessagesCount (long count);

    /** Configures the log messages logging level to be sent along with crashes.
     * @param level An unsigned long specifying the level of the log messages that are saved. */
    @Method(selector = "setLogMessagesLevel:")
    public static native void setLogMessagesLevel (long level);

    /** Forces the plugin to show a predefined fix notification to the user.
     * @param title The title of the fix notification to be shown.
     * @param message The message of the fix notification to be shown. */
    @Method(selector = "setFixNotificationsTitle:message:")
    public static native void setFixNotification (String title, String message);

    /** Sets a string for identifying the user.
     * @param identifier the string identifying the user. */
    @Method(selector = "setUserIdentifier:")
    public static native void setUserIdentifier (String identifier);

    /** Logs a given exception to the service asynchronously, reports its stacktrace and adds extra data as defined by the
     * developer.
     * @param exception The exception to log.
     * @param extraData A dictionary containing extra data to be sent along with the exception.
     * @return A boolean indicating whether the method completed successfully. This doesn't necessarily mean that the exception
     *         was logged successfully on the server, only that exception data was generated appropriately and that an attempt to
     *         send them was made. */
    @Method(selector = "logException:withExtraData:")
    public static native boolean logException (NSException exception, NSDictionary<?, ?> extraData);

    /** Appends a new breadcrumb to the current breadcrumb trail, allowing you to keep track of the user's path in the application.
     * These are transmitted along with crash reports.
     * @param breadcrumb A string describing the user's location.
     * @return A boolean indicating whether the breadcrumb was successfully saved on the device. */
    @Method(selector = "leaveBreadcrumb:")
    public static native boolean leaveBreadcrumb (String breadcrumb);

    /** Sends an event, usually after the user has done an action in the application.
     * @param tag A tag describing the event. Maximum length is 256 characters.
     * @return A boolean indicating whether the event was generated successfully. It doesn't necessarily mean that it was sent and
     *         received successfully by the server. */
    @Method(selector = "sendCustomEventWithTag:")
    public static native boolean sendCustomEvent (String tag);

    @Method(selector = "apiKey")
    public static native String getApiKey ();

    @Method(selector = "endpointURL")
    public static native String getEndpointURL ();

    @Method(selector = "userIdentifier")
    public static native String getUserIdentifier ();

    @Method(selector = "usesProxy")
    public static native boolean isUsingProxy ();

    /** Returns the id of the last crash that was sent to the BugSense servers.
     * @return A long integer identifying the crash. */
    @Method(selector = "lastCrashId")
    public static native long getLastCrashId ();

    /** Returns the number of crashes that the user has experienced since the last reset.
     * @return The number of crashes. */
    @Method(selector = "crashCount")
    public static native int getCrashCount ();

    /** Resets the number of crashes that the user has experienced to zero.
     * @return A boolean indicating whether the number of crashes was successfully reset to zero. */
    @Method(selector = "resetCrashCount")
    public static native boolean resetCrashCount ();

    @Method(selector = "setErrorNetworkOperationsCompletionBlock:")
    public static native void setErrorNetworkOperationsCompletionBlock (@Block Runnable block);
}
