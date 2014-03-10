package org.robovm.bindings.tapjoy;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.uikit.UIView;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
@NativeClass()
public class Tapjoy extends NSObject {
	
	private static final ObjCClass objCClass = ObjCClass.getByType(Tapjoy.class);

	static {
		ObjCRuntime.bind(Tapjoy.class);
	}
	
	//+ (void)requestTapjoyConnect:(NSString*)appID secretKey:(NSString*)secretKey;
	private static final Selector requestTapjoyConnect$secretKey = Selector.register("requestTapjoyConnect:secretKey:");
	
	@Bridge
	private native static void objc_requestConnect(ObjCClass __self__, Selector __cmd__, String appID, String secretKey);
	
	/** 
	 * This method is called to initialize the Tapjoy system and notify the server that this device is running your application.
	 *
	 * This method should be called upon app delegate initialization in the applicationDidFinishLaunching method.
	 *
	 * @param appID The application ID. Retrieved from the app dashboard in your Tapjoy account.
	 * @param secretKey The application secret key. Retrieved from the app dashboard in your Tapjoy account.
	 * @return n/a
	 */
	public static void requestConnect(String appID, String secretKey){
		objc_requestConnect(objCClass, requestTapjoyConnect$secretKey, appID, secretKey);
	}
	
	//+ (UIView*)showOffers;
	private static final Selector showOffers = Selector.register("showOffers");
	
	@Bridge
	private native static UIView objc_showOffers(ObjCClass __self__, Selector __cmd__);
	
	/**
	 * Allocates and initializes a TJCOffersWebView.
	 *
	 * @return The TJCOffersWebView UIView object.
	 */
	public static UIView showOffers(){
		return objc_showOffers(objCClass, showOffers);
	}
	
	//+ (void)getTapPoints;
	private static final Selector getTapPoints = Selector.register("getTapPoints");
	
	@Bridge
	private native static void objc_getTapPoints(ObjCClass __self__, Selector __cmd__);
	
	/**
	 * Requests for Tap Points (Virtual Currency) notify via TJC_TAP_POINTS_RESPONSE_NOTIFICATION notification.
	 *
	 * @return n/a
	 */
	public static void getTapPoints(){
		objc_getTapPoints(objCClass, getTapPoints);
	}
	
	//+ (void)spendTapPoints:(int)points;
	private static final Selector spendTapPoints = Selector.register("spendTapPoints:");
	
	@Bridge
	private native static void objc_spendTapPoints(ObjCClass __self__, Selector __cmd__, int points);
	
	/**
	 * Updates the virtual currency for the user with the given spent amount of currency.
	 *
	 * If the spent amount exceeds the current amount of currency the user has, nothing will happen.
	 * @param points The amount of currency to subtract from the current total amount of currency the user has.
	 * @return n/a
	 */
	public static void spendTapPoints(int points){
		objc_spendTapPoints(objCClass, spendTapPoints, points);
	}


}
