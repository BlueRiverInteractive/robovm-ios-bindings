
package org.robovm.bindings.gpgs;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
@NativeClass()
public class GPGLocalPlayerScore extends NSObject {
	private static final ObjCClass objCClass = ObjCClass.getByType(GPGLocalPlayerScore.class);

	static {
		ObjCRuntime.bind(GPGLocalPlayerScore.class);
	}

	// @property (nonatomic, readonly, retain) GPGLocalPlayerRank *publicRank;
	private static final Selector publicRank$ = Selector.register("publicRank");

	@Bridge
	private native static GPGLocalPlayerRank objc_publicRank (GPGLocalPlayerScore __self__, Selector __cmd__);

	public GPGLocalPlayerRank publicRank () {
		return objc_publicRank(this, publicRank$);
	}

	// @property (nonatomic, readonly, copy) NSString *leaderboardId;
	private static final Selector leaderboardId$ = Selector.register("leaderboardId");

	@Bridge
	private native static String objc_leaderboardId (GPGLocalPlayerScore __self__, Selector __cmd__);

	public String leaderboardId () {
		return objc_leaderboardId(this, leaderboardId$);
	}

	// @property (nonatomic, readonly, copy) NSString *scoreString;
	private static final Selector scoreString$ = Selector.register("scoreString");

	@Bridge
	private native static String objc_scoreString (GPGLocalPlayerScore __self__, Selector __cmd__);

	public String scoreString () {
		return objc_scoreString(this, scoreString$);
	}

	// @property (nonatomic, readonly, assign) unsigned long long scoreValue;
	private static final Selector scoreValue$ = Selector.register("scoreValue");

	@Bridge
	private native static long objc_scoreValue (GPGLocalPlayerScore __self__, Selector __cmd__);

	public long scoreValue () {
		return objc_scoreValue(this, scoreValue$);
	}

	// @property (nonatomic, readonly, retain) GPGLocalPlayerRank *socialRank;
	private static final Selector socialRank$ = Selector.register("socialRank");

	@Bridge
	private native static GPGLocalPlayerRank objc_socialRank (GPGLocalPlayerScore __self__, Selector __cmd__);

	public GPGLocalPlayerRank socialRank () {
		return objc_socialRank(this, socialRank$);
	}

	// @property (nonatomic, readonly, assign) long long writeTimestamp;
	private static final Selector writeTimestamp$ = Selector.register("writeTimestamp");

	@Bridge
	private native static long objc_writeTimestamp (GPGLocalPlayerScore __self__, Selector __cmd__);

	public long writeTimestamp () {
		return objc_writeTimestamp(this, writeTimestamp$);
	}
}
