
package org.robovm.cocoatouch.temp;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

@Library("Foundation")
@NativeClass
public class NSDate extends NSObject {
	static {
		ObjCRuntime.bind(NSDate.class);
	}

	private static final ObjCClass objCClass = ObjCClass.getByType(NSDate.class);

	protected NSDate (SkipInit skipInit) {
		super(skipInit);
	}

	public NSDate () {
	}

	// + (id)date;
	private static final Selector date = Selector.register("date");

	@Bridge
	private native static NSDate objc_date (ObjCClass __self__, Selector __cmd__);

	public static NSDate now () {
		return objc_date(objCClass, date);
	}

	// - (id)dateByAddingTimeInterval:(NSTimeInterval)ti NS_AVAILABLE(10_6, 2_0);
	private static final Selector dateByAddingTimeInterval$ = Selector.register("dateByAddingTimeInterval:");

	@Bridge
	private native static NSDate objc_dateByAddingTimeInterval (NSDate __self__, Selector __cmd__, double seconds);

	public NSDate addSeconds (double seconds) {
		return objc_dateByAddingTimeInterval(this, dateByAddingTimeInterval$, seconds);
	}
}
