
package org.robovm.bindings.splunkmint;

import org.robovm.apple.foundation.NSMutableDictionary;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

/** The base class model of all requests */
@NativeClass
public class DataFixture extends SPLJSONModel {

    /** The SplunkMint API key */
    @Property
    public native String getApiKey ();

    /** The SplunkMint SDK version */
    @Property
    public native String getSdkVersion ();

    /** The SplunkMint SDK platform. Always iOS */
    @Property
    public native String getSdkPlatform ();

    /** The type of the request */
    @Property
    public native String getType ();

    /** The name of the device */
    @Property
    public native String getDevice ();

    /** The iOS version */
    @Property(selector = "osVersion")
    public native String getOSVersion ();

    /** The device locale */
    @Property
    public native String getLocale ();

    /** The application SplunkMint UUID */
    @Property(selector = "uuid")
    public native String getUUID ();

    /** The user identifier */
    @Property
    public native String getUserIdentifier ();

    /** The UNIX timestamp of the request */
    @Property
    public native String getTimestamp ();

    /** The name of the carrier */
    @Property
    public native String getCarrier ();

    /** A helper property always having a specific value for the server */
    @Property
    public native String getRemoteIP ();

    /** The type of the connection when the request logged */
    @Property
    public native String getConnection ();

    /** The state of the connection when the request logged */
    @Property
    public native String getState ();

    /** The application package name */
    @Property
    public native String getPackageName ();

    /** The application full version */
    @Property
    public native String getAppVersionName ();

    /** The application short version */
    @Property
    public native String getAppVersionCode ();

    /** The binary name */
    @Property
    public native String getBinaryName ();

    /** The global extra data */
    @Property
    public native NSMutableDictionary<?, ?> getExtraData ();

    /** The screen orientation */
    @Property
    public native String getScreenOrientation ();
}
