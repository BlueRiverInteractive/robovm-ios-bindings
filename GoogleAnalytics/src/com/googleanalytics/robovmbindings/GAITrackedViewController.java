package com.googleanalytics.robovmbindings;

import org.robovm.cocoatouch.foundation.NSString;
import org.robovm.cocoatouch.uikit.UIViewController;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

/**
 *Extends UIViewController to generate Google Analytics appview calls
 *whenever the view appears; this is done by overriding the `viewDidAppear:`
 *method. The screen name must be set for any tracking calls to be made.
 *
 *By default, this will use [GAI defaultTracker] for tracking calls, but one can
 *override this by setting the tracker property.
 */
@Library(Library.INTERNAL)
@NativeClass()
public class GAITrackedViewController extends UIViewController{
	private static final ObjCClass objCClass = ObjCClass.getByType(GAITrackedViewController.class);

	static {
		ObjCRuntime.bind(GAITrackedViewController.class);
	}


	//@property(nonatomic, assign) id<GAITracker> tracker;
	private static final Selector tracker$ = Selector.register("tracker");
	@Bridge private native static GAITrackerImpl objc_tracker(GAITrackedViewController __self__, Selector __cmd__);
	/** The tracker on which view tracking calls are be made, or `nil`, in which case [GAI defaultTracker] will be used.*/
	public GAITrackerImpl tracker(){
		return objc_tracker(this, tracker$);
	}
	private static final Selector setTracker$ = Selector.register("setTracker:");
	@Bridge private native static void objc_setTracker(GAITrackedViewController __self__, Selector __cmd__, GAITrackerImpl tracker);
	public void setTracker(GAITrackerImpl tracker){
		objc_setTracker(this, setTracker$, tracker);
	}

	//@property(nonatomic, copy)   NSString *screenName;
	private static final Selector screenName$ = Selector.register("screenName");
	@Bridge private native static NSString objc_screenName(GAITrackedViewController __self__, Selector __cmd__);
	/** The screen name, for purposes of Google Analytics tracking. If this is `nil`, no tracking calls will be made. */
	public NSString screenName(){
		return objc_screenName(this, screenName$);
	}
	private static final Selector setScreenName$ = Selector.register("setScreenName:");
	@Bridge private native static NSString objc_setScreenName(GAITrackedViewController __self__, Selector __cmd__, NSString screenName);
	public void setScreenName(String screenName){
		objc_setScreenName(this, setScreenName$, new NSString(screenName));
	}	
}
