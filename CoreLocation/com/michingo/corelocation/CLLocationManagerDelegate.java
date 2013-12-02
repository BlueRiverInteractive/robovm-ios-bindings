package com.michingo.corelocation;

import org.robovm.cocoatouch.foundation.NSArray;
import org.robovm.cocoatouch.foundation.NSError;
import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSObjectProtocol;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.BindSelector;
import org.robovm.rt.bro.annotation.Callback;

public interface CLLocationManagerDelegate extends NSObjectProtocol {
	/** Extend this adapter to listen for events triggered by a GPPShare. */
	public static class Adapter extends NSObject implements CLLocationManagerDelegate {

		@Override
		public CLLocationManagerDelegate didUpdateLocations(
				CLLocationManager manager, NSArray<CLLocation> locations) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public CLLocationManagerDelegate didFailWithError(
				CLLocationManager manager, NSError error) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public CLLocationManagerDelegate didUpdateToLocation(
				CLLocationManager manager, CLLocation newLocation,
				CLLocation oldLocation) {
			// TODO Auto-generated method stub
			return null;
		}
	}

	public CLLocationManagerDelegate didUpdateLocations(CLLocationManager manager, NSArray<CLLocation> locations);
	public CLLocationManagerDelegate didFailWithError(CLLocationManager manager, NSError error);
	public CLLocationManagerDelegate didUpdateToLocation(CLLocationManager manager, CLLocation newLocation, CLLocation oldLocation);
	
	static class Callbacks {
		@Callback
		@BindSelector("locationManager:didUpdateLocations:")
		public static CLLocationManagerDelegate objc_didUpdateLocations(CLLocationManagerDelegate __self__, Selector __cmd__, CLLocationManager manager, NSArray<CLLocation> locations){
			return __self__.didUpdateLocations(manager, locations);
		}

		@Callback
		@BindSelector("locationManager:didFailWithError:")
		public static CLLocationManagerDelegate objc_didFailWithError(CLLocationManagerDelegate __self__, Selector __cmd__, CLLocationManager manager, NSError error){
			return __self__.didFailWithError(manager, error);
		}

		@Callback
		@BindSelector("locationManager:didUpdateToLocation:fromLocation:")
		public static CLLocationManagerDelegate objc_didUpdateToLocation(CLLocationManagerDelegate __self__, Selector __cmd__, CLLocationManager manager, CLLocation newLocation, CLLocation oldLocation){
			return __self__.didUpdateToLocation(manager, newLocation, oldLocation);
		}
	}
}