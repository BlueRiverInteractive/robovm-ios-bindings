package com.googleanalytics.robovmbindings;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSString;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

/**
 *Google Analytics iOS top-level class. Provides facilities to create trackers
 *and set behaviorial flags.
 */
@Library(Library.INTERNAL)
@NativeClass()
public class GAI extends NSObject{
	private static final ObjCClass objCClass = ObjCClass.getByType(GAI.class);

	static {
		ObjCRuntime.bind(GAI.class);
	}
	

	//@property(nonatomic, assign) id<GAITracker> defaultTracker;
	private static final Selector defaultTracker$ = Selector.register("defaultTracker");
	@Bridge private native static GAITrackerImpl objc_defaultTracker(GAI __self__, Selector __cmd__);
	/**
	 *For convenience, this class exposes a default tracker instance.
	 *This is initialized to `nil` and will be set to the first tracker that is
	 *instantiated in trackerWithTrackingId:. It may be overridden as desired.
	 *
	 *	 The GAITrackedViewController class will, by default, use this tracker instance.
	 */
	public GAITrackerImpl getdefaultTracker(){
    	return objc_defaultTracker(this, defaultTracker$);
    }
	private static final Selector setDefaultTracker$ = Selector.register("setDefaultTracker:");
	@Bridge private native static GAITrackerImpl objc_setDefaultTracker(GAI __self__, Selector __cmd__, GAITrackerImpl tracker);
	public GAITrackerImpl setDefaultTracker(GAITrackerImpl tracker){
    	return objc_setDefaultTracker(this, setDefaultTracker$, tracker);
    }
	
	//@property(nonatomic, retain) id<GAILogger> logger;
	private static final Selector logger$ = Selector.register("logger");
	@Bridge private native static GAIDefaultLogger objc_logger(GAI __self__, Selector __cmd__);
	/** The GAIDefaultLogger to use. */
	public GAIDefaultLogger getlogger(){
    	return objc_logger(this, logger$);
    }
	private static final Selector setLogger$ = Selector.register("setLogger:");
	@Bridge private native static GAIDefaultLogger objc_setLogger(GAI __self__, Selector __cmd__, GAIDefaultLogger logger);
	public GAIDefaultLogger setLogger(GAIDefaultLogger logger){
    	return objc_setLogger(this, logger$, logger);
    }
	
	//@property(nonatomic, assign) NSTimeInterval dispatchInterval;
	/*private static final Selector setDispatchInterval$ = Selector.register("setDispatchInterval:");
	@Bridge private native static void objc_setDispatchInterval(GAI __self__, Selector __cmd__, NSTimeInterval dispatchInterval);
	public void setDispatchInterval(NSTimeInterval dispatchInterval){
    	objc_setDispatchInterval(this, setDispatchInterval$, dispatchInterval);
    }*/
	
	//@property(nonatomic, assign) BOOL optOut;
	private static final Selector optOut$ = Selector.register("optOut");
	@Bridge private native static boolean objc_optOut(GAI __self__, Selector __cmd__);
	/**
	 *When this is true, no tracking information will be gathered; tracking calls
	 *will effectively become no-ops. When set to true, all tracking information that
	 *has not yet been submitted. The value of this flag will be persisted
	 *automatically by the SDK.  Developers can optionally use this flag to implement
	 *an opt-out setting in the app to allows users to opt out of Google Analytics
	 *tracking.
	 *
	 *	 This is set to `NO` the first time the Google Analytics SDK is used on a
	 *	 device, and is persisted thereafter.
	 */
	public boolean optOut(){
		return objc_optOut(this, optOut$);
	}
	private static final Selector setOptOut$ = Selector.register("setOptOut:");
	@Bridge private native static boolean objc_setOptOut(GAI __self__, Selector __cmd__, boolean optOut);
	public boolean setOptOut(boolean optOut){
		return objc_setOptOut(this, setOptOut$, optOut);
	}
	
	/**TODO find out about NSTimeInterval
	//@property(nonatomic, assign) NSTimeInterval dispatchInterval;
	private static final Selector dispatchInterval$ = Selector.register("dispatchInterval");
	@Bridge private native static NSTimeInterval objc_dispatchInterval(GAI __self__, Selector __cmd__);
	
	 *If this value is positive, tracking information will be automatically
	 *dispatched every dispatchInterval seconds. Otherwise, tracking information must
	 *be sent manually by calling dispatch.
	 *
	 *	 By default, this is set to `120`, which indicates tracking information should
	 *	 be dispatched automatically every 120 seconds.
	public NSTimeInterval dispatchInterval(){
    	return objc_dispatchInterval(this, dispatchInterval$);
    } 
	*/
	
	//@property(nonatomic, assign) BOOL trackUncaughtExceptions;
	private static final Selector trackUncaughtExceptions$ = Selector.register("trackUncaughtExceptions");
	@Bridge private native static boolean objc_trackUncaughtExceptions(GAI __self__, Selector __cmd__);
	/**
	 *When set to true, the SDK will record the currently registered uncaught
	 *exception handler, and then register an uncaught exception handler which tracks
	 *the exceptions that occurred using defaultTracker. If defaultTracker is not
	 *`nil`, this function will track the exception on the tracker and attempt to
	 *dispatch any outstanding tracking information for 5 seconds. It will then call
	 *the previously registered exception handler, if any. When set back to false,
	 *the previously registered uncaught exception handler will be restored.
	 */
	public boolean trackUncaughtExceptions(){
    	return objc_trackUncaughtExceptions(this, trackUncaughtExceptions$);
    }
	private static final Selector setTrackUncaughtExceptions$ = Selector.register("setTrackUncaughtExceptions:");
	@Bridge private native static boolean objc_setTrackUncaughtExceptions(GAI __self__, Selector __cmd__, boolean track);
	public boolean setTrackUncaughtExceptions(boolean track){
    	return objc_setTrackUncaughtExceptions(this, setTrackUncaughtExceptions$, track);
    }
	
	
	//@property(nonatomic, assign) BOOL dryRun;
	private static final Selector dryRun$ = Selector.register("dryRun");
	@Bridge private native static boolean objc_dryRun(GAI __self__, Selector __cmd__);
	/**
	 *When this is 'YES', no tracking information will be sent. Defaults to 'NO'.
	 */
	public boolean dryRun(){
    	return objc_dryRun(this, dryRun$);
    }
	private static final Selector setDryRun$ = Selector.register("setDryRun:");
	@Bridge private native static void objc_setDryRun(GAI __self__, Selector __cmd__, boolean dryRun);
	public void setDryRun(boolean dryRun){
    	objc_setDryRun(this, setDryRun$, dryRun);
    }
	
	//+ (GAI *)sharedInstance;
	private static final Selector sharedInstance$ = Selector.register("sharedInstance");
	@Bridge private native static GAI objc_sharedInstance(ObjCClass __self__, Selector __cmd__);
	/** Get the shared instance of the Google Analytics for iOS class. */
	public static GAI sharedInstance() {
		return objc_sharedInstance(objCClass, sharedInstance$);
	}
	
	//	- (id<GAITracker>)trackerWithName:(NSString *)name
	//	                       trackingId:(NSString *)trackingId;
	private static final Selector trackerWithName$ = Selector.register("trackerWithName:trackingId:");
	@Bridge private native static GAITrackerImpl objc_trackerWithName(GAI __self__, Selector __cmd__, NSString name, NSString trackingId);
	/**
	 *Creates or retrieves a GAITracker implementation with the specified name and
	 * tracking ID. If the tracker for the specified name does not already exist, then
	 * it will be created and returned; otherwise, the existing tracker will be
	 *returned. If the existing tracker for the respective name has a different
	 *tracking ID, that tracking ID is not changed by this method. If defaultTracker
	 *is not set, it will be set to the tracker instance returned here.
	 *
	 *	 @param name The name of this tracker. Must not be `nil` or empty.
	 *
	 *	 @param trackingID The tracking ID to use for this tracker.  It should be of
	 *	 the form `UA-xxxxx-y`.
	 *
	 *	 @return A GAITracker associated with the specified name. The tracker
	 *	 can be used to send tracking data to Google Analytics. The first time this
	 *	 method is called with a particular name, the tracker for that name will be
	 *	 returned, and subsequent calls with the same name will return the same
	 *	 instance. It is not necessary to retain the tracker because the tracker will be
	 *	 retained internally by the library.
	 *
	 *	 If an error occurs or the name is not valid, this method will return
	 *	 `nil`.
	 */
	public GAITrackerImpl trackerWithName(String name, String trackingId) {
		return objc_trackerWithName(this, trackerWithName$,new NSString(name), new NSString(trackingId));
	}
	
	//- (id<GAITracker>)trackerWithTrackingId:(NSString *)trackingId;
	private static final Selector trackerWithTrackingId$ = Selector.register("trackerWithTrackingId:");
	@Bridge private native static GAITrackerImpl objc_trackerWithTrackingId(GAI __self__, Selector __cmd__, NSString trackingId);
	/**
	 *Creates or retrieves a GAITracker implementation with name equal to
	 *the specified tracking ID. If the tracker for the respective name does not
	 *already exist, it is created, has it's tracking ID set to |trackingId|,
	 *and is returned; otherwise, the existing tracker is returned. If the existing
	 *tracker for the respective name has a different tracking ID, that tracking ID
	 *is not changed by this method. If defaultTracker is not set, it is set to the
	 *tracker instance returned here.
	 *
	 *	 @param trackingID The tracking ID to use for this tracker.  It should be of
	 *	 the form `UA-xxxxx-y`. The name of the tracker will be the same as trackingID.
	 *
	 *	 @return A GAITracker associated with the specified trackingID. The tracker
	 *	 can be used to send tracking data to Google Analytics. The first time this
	 *	 method is called with a particular trackingID, the tracker for the respective
	 *	 name will be returned, and subsequent calls with the same trackingID
	 *	 will return the same instance. It is not necessary to retain the tracker
	 *	 because the tracker will be retained internally by the library.
	 *
	 *	 If an error occurs or the trackingId is not valid, this method will return
	 *	 `nil`.
	 */
	public GAITrackerImpl trackerWithTrackingId(String trackingId) {
		return objc_trackerWithTrackingId(this, trackerWithTrackingId$,new NSString(trackingId));
	}
	
	//- (void)removeTrackerByName:(NSString *)name;
	private static final Selector removeTrackerByName$ = Selector.register("removeTrackerByName:");
	@Bridge private native static void objc_removeTrackerByName(GAI __self__, Selector __cmd__, NSString name);
	/**
	 *Remove a tracker from the trackers dictionary. If it is the default tracker,
	 *clears the default tracker as well.
	 *
	 *	 @param name The name of the tracker.
	 */
	public void removeTrackerByName(String name) {
		objc_removeTrackerByName(this, removeTrackerByName$,new NSString(name));
	}
	
	//- (void)dispatch;
	private static final Selector dispatch$ = Selector.register("dispatch");
	@Bridge private native static void objc_dispatch(GAI __self__, Selector __cmd__);
	/**
	 * Dispatches any pending tracking information.
	 *
	 *	 It would be wise to call this when application is exiting to initiate the
	 *	 submission of any unsubmitted tracking information. Note that this does not
	 *	 have any effect on dispatchInterval, and can be used in conjuntion with
	 *	 periodic dispatch. */
	public void dispatch() {
		objc_dispatch(this, dispatch$);
	}
}
