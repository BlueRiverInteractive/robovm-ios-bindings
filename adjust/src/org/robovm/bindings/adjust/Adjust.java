
package org.robovm.bindings.adjust;

import org.robovm.apple.foundation.NSData;
import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.foundation.NSURL;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;

/** The main interface to Adjust.
 *
 * Use the methods of this class to tell Adjust about the usage of your app. See the README for details. */
@NativeClass
public class Adjust extends NSObject {
    /** Constants for our supported tracking environments. */

    public static final String EnvironmentSandbox = "sandbox";
    public static final String EnvironmentProduction = "production";

    /** Tell Adjust that the application did launch.
     *
     * This is required to initialize Adjust. Call this in the didFinishLaunching method of your AppDelegate.
     *
     * @see ADJConfig for more configuration options
     *
     * @param adjustConfig The configuration object that includes the environment and the App Token of your app. This unique
     *            identifier can be found it in your dashboard at http://adjust.com and should always be 12 characters long. */
    @Method(selector = "appDidLaunch:")
    public static native void appDidLaunch (ADJConfig adjustConfig);

    /** Tell Adjust that a particular event has happened.
     *
     * @see ADJEvent for more event options
     *
     * @param event The Event object for this kind of event. It needs a event token that is created in the dashboard at
     *            http://adjust.com and should be six characters long. */
    @Method(selector = "trackEvent:")
    public static native void trackEvent (ADJEvent event);

    /** Tell adjust that the application resumed.
     *
     * Only necessary if the native notifications can't be used */
    @Method
    public static native void trackSubsessionStart ();

    /** Tell adjust that the application paused.
     *
     * Only necessary if the native notifications can't be used */
    @Method
    public static native void trackSubsessionEnd ();

    /** Enable or disable the adjust SDK
     *
     * @param enabled The flag to enable or disable the adjust SDK */
    @Method(selector = "setEnabled:")
    public static native void setEnabled (boolean enabled);

    /** Check if the SDK is enabled or disabled */
    @Method(selector = "isEnabled")
    public static native boolean isEnabled ();

    /** Read the URL that opened the application to search for an adjust deep link */
    @Method(selector = "appWillOpenUrl:")
    public static native void appWillOpenUrl (NSURL url);

    /** Set the device token used by push notifications */
    @Method(selector = "setDeviceToken:")
    public static native void setDeviceToken (NSData deviceToken);

    /** Enable or disable offline mode. Activities won't be sent but they are saved when offline mode is disabled. This feature is
     * not saved for future sessions */
    @Method(selector = "setOfflineMode:")
    public static native void setOfflineMode (boolean enabled);

    /** Obtain singleton Adjust object */
    @Method
    public static native Adjust getInstance ();

}
