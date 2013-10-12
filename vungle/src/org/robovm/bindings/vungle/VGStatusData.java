package org.robovm.bindings.vungle;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSString;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

/**
 * Internal statistics.
 */
@Library(Library.INTERNAL)
@NativeClass()
public class VGStatusData extends NSObject {
	private static final ObjCClass objCClass = ObjCClass.getByType(VGStatusData.class);

	static {
		ObjCRuntime.bind(VGStatusData.class);
	}

	private VGStatusData() {

	}

	public int getCachedVideoAds() {
		return objc_videoAdsCached(this, videoAdsCached);
	}

	private static final Selector videoAdsCached = Selector.register("videoAdsCached");

	@Bridge
	private native static int objc_videoAdsCached(VGStatusData __self__, Selector __cmd__);

	public int getUnviewedVideoAds() {
		return objc_videoAdsUnviewed(this, videoAdsUnviewed);
	}

	private static final Selector videoAdsUnviewed = Selector.register("videoAdsUnviewed");

	@Bridge
	private native static int objc_videoAdsUnviewed(VGStatusData __self__, Selector __cmd__);

	public String getDescription() {
		return objc_description(this, description).toString();
	}

	private static final Selector description = Selector.register("description");

	@Bridge
	private native static NSString objc_description(VGStatusData __self__, Selector __cmd__);

	public VGStatus getStatus() {
		return objc_status(this, status);
	}

	private static final Selector status = Selector.register("status");

	@Bridge
	private native static VGStatus objc_status(VGStatusData __self__, Selector __cmd__);
}