package org.robovm.bindings.adcolony;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSObjectProtocol;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.BindSelector;
import org.robovm.rt.bro.annotation.Callback;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
public interface AdColonyDelegate extends NSObjectProtocol{
	
	//- ( void ) onAdColonyAdAvailabilityChange:(BOOL)available inZone:(String*) zoneID;
	/**
	 * Provides your app with real-time updates about ad availability changes.
	 * This method is called when a zone's ad availability state changes (when ads become available, or become unavailable).
	 * Listening to these callbacks allows your app to update its user interface immediately. 
	 * For example, when ads become available in a zone you could immediately show an ad for that zone.
	 * @param available Whether ads became available or unavailable  
	 * @param zoneID The affected zone  
	 */
	void onAdColonyAdAvailabilityChange(boolean available, String zoneID);
	
	//- ( void ) onAdColonyV4VCReward:(BOOL)success currencyName:(String*)currencyName currencyAmount:(int)amount inZone:(String*)zoneID;
	/** 
	 * Notifies your app after an ad is displayed when a virtual currency transaction has completed.
	 * In your implementation, check for success and implement any app-specific code that should be run when 
	 * AdColony has successfully rewarded. Client-side V4VC implementations should increment the user's currency 
	 * balance in this method. Server-side V4VC implementations should contact the game server to determine 
	 * the current total balance for the virtual currency.
	 * @param success Whether the transaction succeeded or failed
	 * @param currencyName The name of currency to reward  
	 * @param amount The amount of currency to reward  
	 * @param zoneID The affected zone  
	 */
	void onAdColonyV4VCReward(boolean success, String currencyName, int amount, String zoneID);
	
	public static class Adapter extends NSObject implements AdColonyDelegate{
		@Override
		public void onAdColonyAdAvailabilityChange(boolean available, String zoneID){
		}

		@Override
		public void onAdColonyV4VCReward(boolean success, String currencyName, int amount, String zoneID){
		}
	}
	
	static class Callbacks{
		@Callback
		@BindSelector("onAdColonyAdAvailabilityChange:inZone:")
		public static void onAdColonyAdAvailabilityChange(AdColonyDelegate __self__, Selector __cmd__, boolean available, String zoneID){
			__self__.onAdColonyAdAvailabilityChange(available, zoneID);
		}
		
		@Callback
		@BindSelector("onAdColonyV4VCReward:currencyName:currencyAmount:inZone:")
		public static void onAdColonyV4VCReward(AdColonyDelegate __self__, Selector __cmd__, boolean success, String currencyName, int amount, String zoneID){
			__self__.onAdColonyV4VCReward(success, currencyName, amount, zoneID);
		}
	}
	
}
