
package org.robovm.bindings.gpgs;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSURL;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
@NativeClass()
public class GPGLeaderboardMetadata extends NSObject {
	private static final ObjCClass objCClass = ObjCClass.getByType(GPGLeaderboardMetadata.class);

	static {
		ObjCRuntime.bind(GPGLeaderboardMetadata.class);
	}

	// @property(nonatomic, readonly, copy) NSURL *iconUrl;
	private static final Selector iconUrl$ = Selector.register("iconUrl");

	@Bridge
	private native static NSURL objc_iconUrl (GPGLeaderboardMetadata __self__, Selector __cmd__);

	public NSURL iconUrl () {
		return objc_iconUrl(this, iconUrl$);
	}

	// @property(nonatomic, readonly, copy) NSString *leaderboardId;
	private static final Selector leaderboardId$ = Selector.register("leaderboardId");

	@Bridge
	private native static String objc_leaderboardId (GPGLeaderboardMetadata __self__, Selector __cmd__);

	public String leaderboardId () {
		return objc_leaderboardId(this, leaderboardId$);
	}

	// @property(nonatomic, readonly, assign) GPGLeaderboardOrder order;
	private static final Selector order$ = Selector.register("order");

	@Bridge
	private native static GPGLeaderboardOrder objc_order (GPGLeaderboardMetadata __self__, Selector __cmd__);

	public GPGLeaderboardOrder order () {
		return objc_order(this, order$);
	}

	// @property(nonatomic, readonly, copy) NSString *title;
	private static final Selector title$ = Selector.register("title");

	@Bridge
	private native static String objc_title (GPGLeaderboardMetadata __self__, Selector __cmd__);

	public String title () {
		return objc_title(this, title$);
	}
}
