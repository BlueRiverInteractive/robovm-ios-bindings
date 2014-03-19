
package org.robovm.bindings.vungle;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

/** Internal statistics. */
@NativeClass
public class VGStatusData extends NSObject {
	private VGStatusData () {
	}

	@Property(selector = "videoAdsCached")
	public native int getCachedVideoAds ();

	@Property(selector = "videoAdsUnviewed")
	public native int getUnviewedVideoAds ();

	@Property
	public native String getDescription ();

	@Property
	public native VGStatus getStatus ();
}
