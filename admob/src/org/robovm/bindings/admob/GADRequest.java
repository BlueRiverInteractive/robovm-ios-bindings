package org.robovm.bindings.admob;

import org.robovm.cocoatouch.foundation.NSArray;
import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
@NativeClass()
public class GADRequest extends NSObject{
	private static final ObjCClass objCClass = ObjCClass.getByType(GADRequest.class);

	static{
		ObjCRuntime.bind(GADRequest.class);
	}
	
	//+ (GADRequest *)request;
	private static final Selector request = Selector.register("request");
    @Bridge
    private native static GADRequest objc_request(ObjCClass __self__, Selector __cmd__);
    /**
	 * Creates an autoreleased GADRequest.
	 */
    public static GADRequest request(){
    	return objc_request(objCClass, request);
    }
    
 	// @property (nonatomic, retain) NSArray *testDevices;
 	private static final Selector setTestDevices = Selector.register("setTestDevices:");

 	@Bridge
 	private native static void objc_setTestDevices(GADRequest __self__, Selector __cmd__, NSArray testDevices);
 	/**
 	 * Add the device's identifier into this array for testing purposes.
 	 */
 	public void setTestDevices(NSArray testDevices){
 		objc_setTestDevices(this, setTestDevices, testDevices);
 	}

}
