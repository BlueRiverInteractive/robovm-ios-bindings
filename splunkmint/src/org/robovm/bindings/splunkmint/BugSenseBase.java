
package org.robovm.bindings.splunkmint;

import org.robovm.apple.foundation.NSException;
import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;
import org.robovm.objc.block.VoidBlock1;

/** The BugSenseBase base class. */
@NativeClass
public class BugSenseBase extends NSObject implements RequestWorkerDelegate {

    /** Indicates whether the plugin is initialized and operating properly. */
    @Property(selector = "isInitialized")
    public native boolean isInitialized ();

    /** Indicates whether there is an active session. You can close the current session and start a new one as needed. */
    @Property(selector = "isSessionActive")
    public native boolean isSessionActive ();

    @Property
    public native String getUserIdentifier ();

    /** Sets a user identifier such as a random ID, an email address, or a username for the current user. */
    @Property
    public native void setUserIdentifier (String userIdentifier);

    @Property(selector = "handleWhileDebugging")
    public native boolean handlesWhileDebugging ();

    /** A value that is set interally and used only by the SDK plugin. Set this value to NO when you don't want requests to be
     * logged and sent to the server. The default value is YES. */
    @Property(selector = "setHandleWhileDebugging:")
    public native void setHandleWhileDebugging (boolean handleWhileDebugging);

    /** A LimitedExtraDataList instance where you can set global extra data (ExtraData instances) and attach them to the handled
     * exception requests. */
    @Property
    public native LimitedExtraDataList getExtraDataList ();

    @Property
    public native void setExtraDataList (LimitedExtraDataList extraDataList);

    /** Sends messages to the delegate and notifies you when any actions are taken by the plugin. This value is not set by the
     * developer. */
    @Property
    public native MintNotificationDelegate getNotificationDelegate ();

    @Property(strongRef = true)
    public native void setNotificationDelegate (MintNotificationDelegate notificationDelegate);

    @Method
    public native void disableCrashReporter ();

    /** Sends all cached requests to the server.
     *
     * @param resultBlock A block that you get from a MintResponseResult instance to examine related information. */
    @Method(selector = "flushAsyncWithBlock:")
    public native void flushAsync (@Block VoidBlock1<MintResponseResult> resultBlock);

    /** Initializes the plugin and starts a session.
     *
     * @param apiKey Your Splunk MINT API key. */
    @Method(selector = "initAndStartSession:")
    public native void initAndStartSession (String apiKey);

    /** Adds an ExtraData instance to the global extra data list.
     *
     * @param extraData The ExtraData instance. */
    @Method(selector = "addExtraData:")
    public native void addExtraData (ExtraData extraData);

    /** Appends a LimitedExtraData instance list to the global extra data list.
     *
     * @param limitedExtraDataList The LimitedExtraDataList instance. */
    @Method(selector = "addExtraDataList:")
    public native void addExtraDataList (LimitedExtraDataList limitedExtraDataList);

    /** Removes an ExtraData instance from the global extra data list.
     *
     * @param key The key of the ExtraData instance.
     *
     * @return A Boolean that indicates whether the instance was removed successfully. If NO, an ExtraData instance with the
     *         specified key does not exist. */
    @Method(selector = "removeExtraDataWithKey:")
    public native boolean removeExtraData (String key);

    /** Clears the LimitedExtraDataList instances from the global extra data list. */
    @Method
    public native void clearExtraData ();

    /** Adds a breadcrumb description to the global breadcrumb list.
     *
     * @param crumb The breadcrumb description. */
    @Method(selector = "leaveBreadcrumb:")
    public native void leaveBreadcrumb (String crumb);

    /** Clears the global breadcrumb list. */
    @Method
    public native void clearBreadcrumbs ();

    /** Logs an event request with a tag description.
     *
     * @param tag The tag description.
     * @param completed A block that is invoked upon completion with additional information. */
    @Method(selector = "logEventAsyncWithTag:completionBlock:")
    public native void logEventAsync (String tag, @Block VoidBlock1<MintLogResult> completed);

    /** Starts a new session. If a previous session was initialized less than one minute earlier, this call is ignored.
     *
     * @param completed A block that is invoked upon completion with additional information. */
    @Method(selector = "startSessionAsyncWithCompletionBlock:")
    public native void startSessionAsync (@Block VoidBlock1<MintResponseResult> completed);

    /** Closes a session. All requests and crash reporting will continue to work properly, but the session is no longer logically
     * active.
     *
     * @param completed A block that is invoked upon completion with additional information. */
    @Method(selector = "closeSessionAsyncWithCompletionBlock:")
    public native void closeSessionAsync (@Block VoidBlock1<MintLogResult> completed);

    /** Logs a handled exception in your try/catch block.
     *
     * @param exception The NSException instance.
     * @param key The key for the additional extra data to attach to the request.
     * @param value The value of the additional extra data to attach to the request.
     * @param completed A block that is invoked upon completion with additional information. */
    @Method(selector = "logExceptionAsync:extraDataKey:extraDataValue:completionBlock:")
    public native void logExceptionAsync (NSException exception, String key, String value,
        @Block VoidBlock1<MintLogResult> completed);

    /** Logs a handled exception in your try/catch block.
     *
     * @param exception The NSException instance.
     * @param limitedExtraDataList A LimitedExtraDataList instance to attach to the request.
     * @param completed A block that is invoked upon completion with additional information. */
    @Method(selector = "logExceptionAsync:limitedExtraDataList:completionBlock:")
    public native void logExceptionAsync (NSException exception, LimitedExtraDataList extraDataList,
        @Block VoidBlock1<MintLogResult> completed);

    @Override
    public void loggedRequestHandled (LoggedRequestEventArgs args) {
    }

    @Override
    public void pingEventCompleted (MintResponseResult splunkResponseResult) {
    }

    @Override
    public void networkDataLogged (NetworkDataFixture networkData) {
    }
}
