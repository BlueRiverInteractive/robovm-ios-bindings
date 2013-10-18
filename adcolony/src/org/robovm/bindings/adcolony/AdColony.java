package org.robovm.bindings.adcolony;

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
public class AdColony extends NSObject{
	private static final ObjCClass objCClass = ObjCClass.getByType(AdColony.class);

	static {
		ObjCRuntime.bind(AdColony.class);
	}
    
    //+ ( void ) configureWithAppID:( String * )appID zoneIDs:( NSArray * )zoneIDs delegate:( id<AdColonyDelegate> )del logging:( BOOL )log;
    private static final Selector configureWithAppID$zoneIDs$delegate$logging = Selector.register("configureWithAppID:zoneIDs:delegate:logging:");
    @SuppressWarnings("rawtypes")
	@Bridge private native static void objc_configure(ObjCClass __self__, Selector __cmd__, String appID, NSArray zoneIDs, AdColonyDelegate del, boolean log);
    /**
     * Configures AdColony specifically for your app; required for usage of the rest of the API.
     * This method returns immediately; any long-running work such as network connections are performed in the background.
     * AdColony does not begin preparing ads for display or performing reporting until after it is configured by your app.
     * @param appID The AdColony app ID for your app. This can be created and retrieved at the [Control Panel](http://clients.adcolony.com)
     * @param zoneIDs An array of at least one AdColony zone ID string. AdColony zone IDs can be created and retrieved at the [Control Panel](http://clients.adcolony.com). If `nil`, app will be unable to play ads and AdColony will only provide limited reporting and install tracking functionality.
     * @param del The delegate to receive V4VC and ad availability events. Can be `nil` for apps that do not need these events.
     * @param log A boolean controlling AdColony verbose logging.
     */
    @SuppressWarnings("rawtypes")
    public static void configure(String appID, NSArray zoneIDs, AdColonyDelegate del, boolean log){
    	objc_configure(objCClass, configureWithAppID$zoneIDs$delegate$logging, appID, zoneIDs, del, log);
    }
    
    //+ ( void ) playVideoAdForZone:( String * )zoneID withDelegate:( id<AdColonyAdDelegate> )del;
    private static final Selector playVideoAdForZone$withDelegate = Selector.register("playVideoAdForZone:withDelegate:");
    @Bridge private native static void objc_playVideoAd(ObjCClass __self__, Selector __cmd__, String zoneID, AdColonyAdDelegate del);
    /**
     * Plays an AdColony ad.
     * This method returns immediately, before the ad completes. If ads are not 
     * available, an ad may not play as a result of this method call. If you need 
     * more detailed information about when the ad completes or whether an ad 
     * played, pass in a delegate.
     * @param zoneID The zone from which the ad should play.
     * @param del The delegate to receive ad events. Can be `nil` for apps that do not need these events.
     */
    public static void playVideoAd(String zoneID, AdColonyAdDelegate del){
    	objc_playVideoAd(objCClass, playVideoAdForZone$withDelegate, zoneID, del);
    }
    
    //+ ( void ) playVideoAdForZone:( String * )zoneID withDelegate:( id<AdColonyAdDelegate> )del
    //withV4VCPrePopup:( BOOL )showPrePopup andV4VCPostPopup:( BOOL )showPostPopup;
    private static final Selector playVideoAdForZone$withDelegate$withV4VCPrePopup$andV4VCPostPopup = Selector.register("playVideoAdForZone:withDelegate:withV4VCPrePopup:andV4VCPostPopup:");
    @Bridge private native static void objc_playVideoAd(ObjCClass __self__, Selector __cmd__, String zoneID, AdColonyAdDelegate del, boolean showPrePopup, boolean showPostPopup);
    /**
     * Plays an AdColony ad and allows specifying display of the default V4VC instructional popups.
     * This method returns immediately, before the ad completes. If ads are not 
     * available, an ad may not play as a result of this method call. If you need
     * more detailed information about when the ad completes or whether an ad
     * played, pass in a delegate.
     * @param zoneID The zone from which the ad should play.  
     * @param del The delegate to receive ad events. Can be `nil` for apps that do not need these events. 
     * @param showPrePopup Whether AdColony should display an instructional popup before the ad.
     * @param showPostPopup Whether AdColony should display an instructional popup after the ad.
     */
    public static void playVideoAd(String zoneID, AdColonyAdDelegate del, boolean showPrePopup, boolean showPostPopup){
    	objc_playVideoAd(objCClass, playVideoAdForZone$withDelegate$withV4VCPrePopup$andV4VCPostPopup, zoneID, del, showPrePopup, showPostPopup);
    }
    
    //+ ( ADCOLONY_ZONE_STATUS ) zoneStatusForZone:( String * )zoneID;
    private static final Selector zoneStatusForZone = Selector.register("zoneStatusForZone:");
    @Bridge private native static AdColonyStatus objc_getZoneStatus(ObjCClass __self__, Selector __cmd__, String zoneID);
    /** 
     * Returns the zone status for the specified zone.
     * @param zoneID The zone in question
     * @return An ADCOLONY_ZONE_STATUS enum value indicating the zone status
     */
    public static AdColonyStatus getZoneStatus(String zoneID){
    	return objc_getZoneStatus(objCClass, zoneStatusForZone, zoneID);
    }
    
}
