
package org.robovm.bindings.splunkmint;

import org.robovm.apple.foundation.NSMutableDictionary;
import org.robovm.apple.foundation.NSNumber;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;
import org.robovm.rt.bro.annotation.MachineSizedSInt;

@NativeClass
public class MintAppEnvironment extends SPLJSONModel {

    @Method(selector = "isEqualToSplunkAppEnvironment:")
    public native boolean isEqualToSplunkAppEnvironment (MintAppEnvironment aSplunkAppEnvironment);

    @Property(selector = "uid")
    public native String getUID ();

    @Property
    public native String getPhoneModel ();

    @Property
    public native String getManufacturer ();

    @Property
    public native String getInternalVersion ();

    @Property
    public native String getAppVersion ();

    @Property
    public native String getBrand ();

    @Property
    public native String getAppName ();

    @Property(selector = "osVersion")
    public native String getOSVersion ();

    @Property
    public native @MachineSizedSInt long getWifiOn ();

    @Property(selector = "gpsOn")
    public native NSNumber getGPSOn ();

    @Property
    public native String getCellularData ();

    @Property
    public native String getCarrier ();

    @Property
    public native NSNumber getScreenWidth ();

    @Property
    public native NSNumber getScreenHeight ();

    @Property
    public native String getScreenOrientation ();

    @Property
    public native String getScreenDpi ();

    @Property
    public native boolean isRooted ();

    @Property
    public native String getLocale ();

    @Property
    public native String getGeoRegion ();

    @Property(selector = "cpuModel")
    public native String getCPUModel ();

    @Property(selector = "cpuBitness")
    public native String getCPUBitness ();

    @Property(selector = "build_uuid")
    public native String getBuildUUID ();

    @Property(selector = "image_base_address")
    public native String getImageBaseAddress ();

    @Property
    public native String getArchitecture ();

    @Property
    public native NSMutableDictionary<?, ?> getRegisters ();

    @Property
    public native String getExecName ();

    @Property
    public native String getImageSize ();

    @Property(selector = "log_data")
    public native NSMutableDictionary<?, ?> getLogData ();
}
