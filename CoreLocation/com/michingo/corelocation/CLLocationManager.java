package com.michingo.corelocation;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

@Library("CoreLocation")
@NativeClass
public class CLLocationManager extends NSObject{
	private static final ObjCClass objCClass = ObjCClass.getByType(CLLocationManager.class);
	
	static {
        ObjCRuntime.bind(CLLocationManager.class);
    }

    //+ (BOOL)locationServicesEnabled
	private static final Selector locationServicesEnabled$ = Selector.register("locationServicesEnabled");
    @Bridge private native static boolean objc_locationServicesEnabled(ObjCClass __self__, Selector __cmd__);
    public static boolean locationServicesEnabled() {
        return objc_locationServicesEnabled(objCClass, locationServicesEnabled$);
    }
    
    //+ (CLAuthorizationStatus)authorizationStatus
    private static final Selector authorizationStatus$ = Selector.register("authorizationStatus");
    @Bridge private native static CLAuthorizationStatus objc_authorizationStatus(ObjCClass __self__, Selector __cmd__);
    public static CLAuthorizationStatus authorizationStatus() {
        return objc_authorizationStatus(objCClass, authorizationStatus$);
    }
    
    //@property(readonly, nonatomic) CLLocation *location
    private static final Selector location$ = Selector.register("location");
    @Bridge private native static CLLocation objc_location(CLLocationManager __self__, Selector __cmd__);
    public CLLocation getLocation() {
        return objc_location(this, location$);
    }
    
    //@property(assign, nonatomic) CLLocationDistance *distanceFilter
    private static final Selector setDistanceFilter$ = Selector.register("setDistanceFilter:");
    @Bridge private native static void objc_setDistanceFilter(CLLocationManager __self__, Selector __cmd__, double distanceFilter);
    public void setDistanceFilter(double distanceFilter) {
        objc_setDistanceFilter(this, setDistanceFilter$, distanceFilter);
    }
    
    //@property(assign, nonatomic) CLLocationAccuracy *desiredAccuracy
    private static final Selector setDesiredAccuracy$ = Selector.register("setDesiredAccuracy:");
    @Bridge private native static void objc_setDesiredAccuracy(CLLocationManager __self__, Selector __cmd__, double desiredAccuracy);
    public void setDesiredAccuracy(double desiredAccuracy) {
        objc_setDesiredAccuracy(this, setDesiredAccuracy$, desiredAccuracy);
    }
    
    //@property(assign, nonatomic) CLLocationManagerDelegate delegate
    private static final Selector setDelegate$ = Selector.register("setDelegate:");
    @Bridge private native static void objc_setDelegate(CLLocationManager __self__, Selector __cmd__, CLLocationManagerDelegate del);
    public void setDelegate(CLLocationManagerDelegate del) {
        objc_setDelegate(this, setDelegate$, del);
    }
    
    //- (void)startUpdatingLocation
    private static final Selector startUpdatingLocation$ = Selector.register("startUpdatingLocation");
    @Bridge private native static void objc_startUpdatingLocation(CLLocationManager __self__, Selector __cmd__);
    public void startUpdatingLocation() {
        objc_startUpdatingLocation(this, startUpdatingLocation$);
    }
    
    //- (void)stopUpdatingLocation
    private static final Selector stopUpdatingLocation$ = Selector.register("stopUpdatingLocation");
    @Bridge private native static void objc_stopUpdatingLocation(CLLocationManager __self__, Selector __cmd__);
    public void stopUpdatingLocation() {
        objc_stopUpdatingLocation(this, stopUpdatingLocation$);
    }
}
