
package org.robovm.bindings.vungle;

import org.robovm.cocoatouch.foundation.NSDictionary;
import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

/** Data for one movie play event. */
@Library(Library.INTERNAL)
@NativeClass()
public class VGPlayData extends NSObject {
	private static final ObjCClass objCClass = ObjCClass.getByType(VGPlayData.class);

	static {
		ObjCRuntime.bind(VGPlayData.class);
	}

	public double getStart () {
		return objc_start(this, start);
	}

	private static final Selector start = Selector.register("start");

	@Bridge
	private native static double objc_start (VGPlayData __self__, Selector __cmd__);

	public double getMovieDuration () {
		return objc_movieTotal(this, movieTotal);
	}

	private static final Selector movieTotal = Selector.register("movieTotal");

	@Bridge
	private native static double objc_movieTotal (VGPlayData __self__, Selector __cmd__);

	public double getMovieViewedTime () {
		return objc_movieViewed(this, movieViewed);
	}

	private static final Selector movieViewed = Selector.register("movieViewed");

	@Bridge
	private native static double objc_movieViewed (VGPlayData __self__, Selector __cmd__);

	public NSDictionary<NSObject, NSObject> getJSONData () {
		return objc_JSONData(this, JSONData);
	}

	private static final Selector JSONData = Selector.register("JSONData");

	@Bridge
	private native static NSDictionary<NSObject, NSObject> objc_JSONData (VGPlayData __self__, Selector __cmd__);

	public boolean isValid () {
		return objc_valid(this, valid);
	}

	private static final Selector valid = Selector.register("valid");

	@Bridge
	private native static boolean objc_valid (VGPlayData __self__, Selector __cmd__);

	public boolean isPlayedFully () {
		return objc_playedFull(this, playedFull);
	}

	private static final Selector playedFull = Selector.register("playedFull");

	@Bridge
	private native static boolean objc_playedFull (VGPlayData __self__, Selector __cmd__);
}
