
package org.robovm.bindings.adjust;

import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class ADJConfig extends NSObject {

    @Property
    public native String getAppToken ();

    @Property
    public native ADJLogLevel getLogLevel ();

    @Property
    public native void setLogLevel (ADJLogLevel logLevel);

    @Property
    public native String getEnvironment ();

    @Property(selector = "sdkPrefix")
    public native String getSDKPrefix ();

    @Property(selector = "setSdkPrefix:")
    public native void setSDKPrefix (String sdkPrefix);

    /** Configuration object for the initialization of the Adjust SDK.
     *
     * @param appToken The App Token of your app. This unique identifier can be found it in your dashboard at http://adjust.com
     *            and should always be 12 characters long.
     * @param environment The current environment your app. We use this environment to distinguish between real traffic and
     *            artificial traffic from test devices. It is very important that you keep this value meaningful at all times!
     *            Especially if you are tracking revenue. */
    @Method(selector = "configWithAppToken:environment:")
    public static native ADJConfig create (String appToken, String environment);

    @Property
    public native boolean isEventBufferingEnabled ();

    /** Enable event buffering if your app triggers a lot of events. When enabled, events get buffered and only get tracked each
     * minute. Buffered events are still persisted, of course.
     *
     * @param eventBufferingEnabled Enable or disable event buffering */
    @Property
    public native void setEventBufferingEnabled (boolean eventBufferingEnabled);

    @Property
    public native boolean isMacMd5TrackingEnabled ();

    /** Disable macMd5 tracking if your privacy constraints require it.
     *
     * @param macMd5TrackingEnabled Enable or disable tracking of the MD5 hash of the MAC address */
    @Property
    public native void setMacMd5TrackingEnabled (boolean macMd5TrackingEnabled);

// /**
// * Set the optional delegate that will inform you about attribution
// *
// * See the AdjustDelegate declaration above for details
// *
// * @param delegate The delegate that might implement the optional delegate
// * methods like adjustAttributionChanged:
// */
// @property (nonatomic, retain) NSObject<AdjustDelegate> *delegate;

    @Property(selector = "hasDelegate")
    public native boolean hasDelegate ();

    @Property(selector = "isValid")
    public native boolean isValid ();
}
