package com.michingo.corelocation;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.Struct;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.ByVal;
import org.robovm.rt.bro.annotation.Library;
import org.robovm.rt.bro.annotation.StructMember;

@Library("CoreLocation")
@NativeClass
public class CLLocation extends NSObject{
	private static final ObjCClass objCClass = ObjCClass.getByType(CLLocation.class);
	
	static {
        ObjCRuntime.bind(CLLocation.class);
    }
	
	public static final class CLLocationCoordinate2D extends Struct<CLLocationCoordinate2D>{
		@StructMember(0)
		public native @ByVal double latitude();
		@StructMember(0)
		public native CLLocationCoordinate2D latitude(@ByVal double l);
		@StructMember(1)
		public native @ByVal double longitude();
		@StructMember(1)
		public native CLLocationCoordinate2D longitude(@ByVal double l);
	}

    //@property(readonly, NS_NONATOMIC_IPHONEONLY) CLLocationCoordinate2D coordinate
	private static final Selector coordinate$ = Selector.register("coordinate");
    @Bridge private native static CLLocationCoordinate2D objc_coordinate(CLLocation __self__, Selector __cmd__);
    public CLLocationCoordinate2D coordinate() {
        return objc_coordinate(this, coordinate$);
    }
    
    //@property(readonly, NS_NONATOMIC_IPHONEONLY) CLLocationAccuracy horizontalAccuracy
  	private static final Selector horizontalAccuracy$ = Selector.register("horizontalAccuracy");
	@Bridge private native static double objc_horizontalAccuracy(CLLocation __self__, Selector __cmd__);
	public double horizontalAccuracy() {
	    return objc_horizontalAccuracy(this, horizontalAccuracy$);
	}
}
