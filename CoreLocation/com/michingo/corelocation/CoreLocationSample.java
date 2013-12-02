package com.michingo.corelocation;

import java.util.ArrayList;

import org.robovm.cocoatouch.foundation.NSArray;
import org.robovm.cocoatouch.foundation.NSError;
import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.uikit.UIDevice;

public class CoreLocationSample {
	
	private CLLocationManager locationManager;
	private ArrayList<Integer> iosVersion;
	
	public ArrayList<Integer> getIOSVersion(){
		if (iosVersion == null){
			ArrayList<Integer> arr = new ArrayList<Integer>();
			String[] sysComponents = UIDevice.getCurrentDevice().getSystemVersion().split("\\.");
			try{
			for(int i=0;i<sysComponents.length;i++){
				arr.add(Integer.parseInt(sysComponents[i]));
			}
			}catch(NumberFormatException e){
				arr.clear();
			}
			if (arr.size() == 0){
				arr.add(-1);
			}
			iosVersion = arr;
		}
		return iosVersion;
	}
	
	private void getUserLocation(){
		
		//only available in ios 4.2 or higher
		ArrayList<Integer> v = getIOSVersion();
		if (v.get(0) > 4 || (v.get(0) == 4 && v.get(1) >= 2)){
			boolean locationAllowed = CLLocationManager.locationServicesEnabled() && (CLLocationManager.authorizationStatus() != CLAuthorizationStatus.kCLAuthorizationStatusDenied);
		
			if (locationAllowed){
				locationManager = new CLLocationManager();
				locationManager.setDistanceFilter(0d);
				locationManager.setDesiredAccuracy(100d);
				locationDelegate = new LocationDelegate();
				locationManager.setDelegate(locationDelegate);
				locationManager.startUpdatingLocation();
			}
		}
	}
	
	private LocationDelegate locationDelegate;
	private class LocationDelegate extends NSObject implements CLLocationManagerDelegate{

		@Override
		public CLLocationManagerDelegate didUpdateLocations(CLLocationManager manager, NSArray<CLLocation> locations) {
			if (locations != null && locations.size() > 0){
				CLLocation loc = (CLLocation)locations.get(locations.size()-1);
				
				String str = loc.toString();
				str = str.split(">")[0];
				str = str.substring(1);
				String[] val = str.split(",");
				double latitude = Double.parseDouble(val[0]);
				double longitude = Double.parseDouble(val[1]);
				double accuracy = loc.horizontalAccuracy();

				System.out.println("location fetched successfully! "+latitude+", "+longitude+", "+accuracy);
				
				manager.stopUpdatingLocation();
				locationManager = null;
				locationDelegate = null;
			}
			return null;
		}

		@Override
		public CLLocationManagerDelegate didFailWithError(CLLocationManager manager, NSError error) {
			if (error != null){
				System.out.println("Error while fetching user location. "+error.description());
			}
			return null;
		}
		@Override
		public CLLocationManagerDelegate didUpdateToLocation(CLLocationManager manager, CLLocation newLocation, CLLocation oldLocation) {
			if (newLocation != null){
				String str = newLocation.toString();
				str = str.split(">")[0];
				str = str.substring(1);
				String[] val = str.split(",");
				double latitude = Double.parseDouble(val[0]);
				double longitude = Double.parseDouble(val[1]);
				double accuracy = newLocation.horizontalAccuracy();
				
				System.out.println("location fetched successfully! "+latitude+", "+longitude+", "+accuracy);
				
				manager.stopUpdatingLocation();
				locationManager = null;
				locationDelegate = null;
			}
			return null;
		}
	};
}
