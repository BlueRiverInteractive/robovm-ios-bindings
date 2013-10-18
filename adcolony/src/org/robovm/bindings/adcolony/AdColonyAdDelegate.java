package org.robovm.bindings.adcolony;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSObjectProtocol;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.BindSelector;
import org.robovm.rt.bro.annotation.Callback;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
public interface AdColonyAdDelegate extends NSObjectProtocol{
	
	//- ( void ) onAdColonyAdStartedInZone:( String * )zoneID;
	/** 
	 * Notifies your app that an ad will actually play in response to the app's request to play an ad.
	 * This method is called when AdColony has taken control of the device screen and is about to begin 
	 * showing an ad. Apps should implement app-specific code such as pausing a game and turning off app music.
	 * @param zoneID The affected zone
	 */
	void onAdColonyAdStartedInZone(String zoneID);
	
	//- ( void ) onAdColonyAdAttemptFinished:(BOOL)shown inZone:( String * )zoneID;
	/** 
	 * Notifies your app that an ad completed playing (or never played) and control has been returned to the app.
	 * This method is called when AdColony has finished trying to show an ad, either successfully or unsuccessfully. 
	 * If an ad was shown, apps should implement app-specific code such as unpausing a game and restarting app music.
	 * @param shown Whether an ad was actually shown  
	 * @param zoneID The affected zone  
	 */
	void onAdColonyAdAttemptFinished(boolean shown, String zoneID);
	
	public static class Adapter extends NSObject implements AdColonyAdDelegate{
		@Override
		public void onAdColonyAdStartedInZone(String zoneID){
		}

		@Override
		public void onAdColonyAdAttemptFinished(boolean shown, String zoneID){
		}
	}
	
	static class Callbacks{
		@Callback
		@BindSelector("onAdColonyAdStartedInZone:")
		public static void onAdColonyAdStartedInZone(AdColonyAdDelegate __self__, Selector __cmd__, String zoneID){
			__self__.onAdColonyAdStartedInZone(zoneID);
		}
		
		@Callback
		@BindSelector("onAdColonyAdAttemptFinished:inZone:")
		public static void onAdColonyAdAttemptFinished(AdColonyAdDelegate __self__, Selector __cmd__, boolean shown, String zoneID){
			__self__.onAdColonyAdAttemptFinished(shown, zoneID);
		}
	}
	
}
