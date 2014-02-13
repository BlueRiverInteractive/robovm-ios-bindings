package org.robovm.bindings.appirater;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSString;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
@NativeClass()
public class Appirater extends NSObject{
	private static final ObjCClass objCClass = ObjCClass.getByType(Appirater.class);
	
	static{
		ObjCRuntime.bind(Appirater.class);
	}

	
	//+ (Appirater*)sharedInstance;
	private static final Selector sharedInstance = Selector.register("sharedInstance");
	
	@Bridge
	private native static Appirater objc_sharedInstance(ObjCClass __self__, Selector __cmd__);
	
	/**
	 * Get the singleton
	 * @return
	 */
	public static Appirater sharedInstance(){
		return objc_sharedInstance(objCClass, sharedInstance);
	}
	
	
	//+ (void)appLaunched:(BOOL)canPromptForRating;
	private static final Selector appLaunched = Selector.register("appLaunched:");
	
	@Bridge
	private native static void objc_appLaunched(ObjCClass __self__, Selector __cmd__, boolean canPromptForRating);
	
	/*
	 Tells Appirater that the app has launched, and on devices that do NOT
	 support multitasking, the 'uses' count will be incremented. You should
	 call this method at the end of your application delegate's
	 application:didFinishLaunchingWithOptions: method.
	 
	 If the app has been used enough to be rated (and enough significant events),
	 you can suppress the rating alert
	 by passing NO for canPromptForRating. The rating alert will simply be postponed
	 until it is called again with YES for canPromptForRating. The rating alert
	 can also be triggered by appEnteredForeground: and userDidSignificantEvent:
	 (as long as you pass YES for canPromptForRating in those methods).
	 */
	public static void appLaunched(boolean canPromptForRating){
		objc_appLaunched(objCClass, appLaunched, canPromptForRating);
	}
	
	
	//+ (void)showPrompt;
	private static final Selector showPrompt = Selector.register("showPrompt");

	@Bridge
	private native static void objc_showPrompt(ObjCClass __self__, Selector __cmd__);

	/*
	 Tells Appirater to show the prompt (a rating alert). The prompt will be showed
	 if there is connection available, the user hasn't declined to rate
	 or hasn't rated current version.
	 
	 You could call to show the prompt regardless Appirater settings,
	 e.g., in case of some special event in your app.
	 */
	public static void showPrompt() {
		objc_showPrompt(objCClass, showPrompt);
	}
		
	
	//+ (void) setAppId:(NSString*)appId;
	private static final Selector setAppId = Selector.register("setAppId:");

	@Bridge
	private native static void objc_setAppId(ObjCClass __self__, Selector __cmd__, NSString appId);

	/*
	 Set your Apple generated software id here.
	 */
	public static void setAppId(String appId) {
		objc_setAppId(objCClass, setAppId, new NSString(appId));
	}
	
	
	//+ (void) setDaysUntilPrompt:(double)value;
	private static final Selector setDaysUntilPrompt = Selector.register("setDaysUntilPrompt:");

	@Bridge
	private native static void objc_setDaysUntilPrompt(ObjCClass __self__, Selector __cmd__, double days);

	/*
	 Users will need to have the same version of your app installed for this many
	 days before they will be prompted to rate it.
	 */
	public static void setDaysUntilPrompt(double days) {
		objc_setDaysUntilPrompt(objCClass, setDaysUntilPrompt, days);
	}
	
	
	//+ (void) setUsesUntilPrompt:(NSInteger)value;
	private static final Selector setUsesUntilPrompt = Selector.register("setUsesUntilPrompt:");

	@Bridge
	private native static void objc_setUsesUntilPrompt(ObjCClass __self__, Selector __cmd__, int uses);

	/*
	 An example of a 'use' would be if the user launched the app. Bringing the app
	 into the foreground (on devices that support it) would also be considered
	 a 'use'. You tell Appirater about these events using the two methods:
	 [Appirater appLaunched:]
	 [Appirater appEnteredForeground:]
	 
	 Users need to 'use' the same version of the app this many times before
	 before they will be prompted to rate it.
	 */
	public static void setUsesUntilPrompt(int uses) {
		objc_setUsesUntilPrompt(objCClass, setUsesUntilPrompt, uses);
	}
	
	
	//+ (void) setDebug:(BOOL)debug;
	private static final Selector setDebug = Selector.register("setDebug:");
	
	@Bridge
	private native static void objc_setDebug(ObjCClass __self__, Selector __cmd__, boolean debug);
	
	/*
	 'YES' will show the Appirater alert everytime. Useful for testing how your message
	 looks and making sure the link to your app's review page works.
	 */
	public static void setDebug(boolean debug){
		objc_setDebug(objCClass, setDebug, debug);
	}
	
	
	//+ (void)setDelegate:(id<AppiraterDelegate>)delegate;
	private static final Selector setDelegate = Selector.register("setDelegate:");
	
	@Bridge
	private native static void objc_setDelegate(ObjCClass __self__, Selector __cmd__, AppiraterDelegate delegate);
	
	/*
	 Set the delegate if you want to know when Appirater does something
	 */
	public static void setDelegate(AppiraterDelegate delegate){
		objc_setDelegate(objCClass, setDelegate, delegate);
	}
}
