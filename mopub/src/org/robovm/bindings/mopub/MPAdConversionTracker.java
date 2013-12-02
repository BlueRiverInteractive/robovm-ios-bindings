
package org.robovm.bindings.mopub;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSString;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

/** The MPAdConversionTracker class provides a mechanism for reporting application download (conversion) events to MoPub. This type
 * of tracking is important for measuring the effectiveness of cross-promotional and direct-sold advertising.
 * 
 * To track application downloads, get a reference to the shared instance of this class using the {@link #getSharedInstance()}
 * method. Then, in your application delegate's didFinishLaunching method, call the {@link #reportApplicationOpen(String)} method
 * on the shared instance. With this call in place, the conversion tracker will report an event to MoPub whenever the application
 * is launched on a given device for the first time. Any subsequent launches will not be recorded as conversion events. */
@Library(Library.INTERNAL)
@NativeClass()
public class MPAdConversionTracker extends NSObject {
	private static final ObjCClass objCClass = ObjCClass.getByType(MPAdConversionTracker.class);

	static {
		ObjCRuntime.bind(MPAdConversionTracker.class);
	}

	private MPAdConversionTracker () {

	}

	/** Returns the shared instance of the MPAdConversionTracker class.
	 * 
	 * @return A singleton MPAdConversionTracker object. */
	public static MPAdConversionTracker getSharedInstance () {
		return objc_getInstance(objCClass, getInstance);
	}

	private static final Selector getInstance = Selector.register("sharedConversionTracker");

	@Bridge
	private native static MPAdConversionTracker objc_getInstance (ObjCClass __self__, Selector __cmd__);

	/** Notifies MoPub that a conversion event should be recorded for the application corresponding to the specified `appID`.
	 * 
	 * A conversion event will only be reported once per application download, even if this method is called multiple times.
	 * 
	 * @param appID An iTunes application ID.
	 * 
	 *           The easiest way to find the correct ID for your application is to generate an iTunes URL using the [iTunes Link
	 *           Maker](https://itunes.apple.com/linkmaker), and then extract the number immediately following the "id" string.
	 * 
	 *           For example, the iTunes URL for the "Find My Friends" application is
	 *           https://itunes.apple.com/us/app/find-my-friends/id466122094, so its application ID is 466122094. */
	public void reportApplicationOpen (String appID) {
		objc_reportApplicationOpen(this, reportApplicationOpen, new NSString(appID));
	}

	private static final Selector reportApplicationOpen = Selector.register("reportApplicationOpenForApplicationID:");

	@Bridge
	private native static void objc_reportApplicationOpen (NSObject __self__, Selector __cmd__, NSString appID);
}
