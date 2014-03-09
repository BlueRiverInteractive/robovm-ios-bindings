
package org.robovm.bindings.vungle;

import org.robovm.cocoatouch.foundation.NSDictionary;
import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

/** Data for one movie play event. */
@NativeClass()
public class VGPlayData extends NSObject {
	private VGPlayData () {
	}

	@Property()
	public native double getStart ();

	@Property(selector = "movieTotal")
	public native double getMovieDuration ();

	@Property(selector = "movieViewed")
	public native double getMovieViewedTime ();

	@Property()
	public native NSDictionary<?, ?> getJSONData ();

	@Property()
	public native boolean isValid ();

	@Property(selector = "playedFull")
	public native boolean isPlayedFully ();
}
