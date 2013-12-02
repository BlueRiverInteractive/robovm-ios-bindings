
package org.robovm.bindings.gpgs;

import org.robovm.cocoatouch.foundation.NSArray;
import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSString;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
@NativeClass()
public class GPGLeaderboardModel extends NSObject {
	private static final ObjCClass objCClass = ObjCClass.getByType(GPGLeaderboardModel.class);

	static {
		ObjCRuntime.bind(GPGLeaderboardModel.class);
	}

	// - (NSArray *)allMetadata; // GPGLeaderboardMetadata objects
	private static final Selector allMetadata$ = Selector.register("allMetadata");

	@Bridge
	private native static NSArray<GPGLeaderboardMetadata> objc_allMetadata (GPGLeaderboardModel __self__, Selector __cmd__);

	public NSArray<GPGLeaderboardMetadata> allMetadata () {
		return objc_allMetadata(this, allMetadata$);
	}

	// - (GPGLeaderboardMetadata *)metadataForLeaderboardId:(NSString *)leaderboardId;
	private static final Selector metadataForLeaderboardId$ = Selector.register("metadataForLeaderboardId:");

	@Bridge
	private native static GPGLeaderboardMetadata objc_metadataForLeaderboardId (GPGLeaderboardModel __self__, Selector __cmd__,
		NSString leaderboardId);

	public GPGLeaderboardMetadata metadataForLeaderboardId (String leaderboardId) {
		return objc_metadataForLeaderboardId(this, metadataForLeaderboardId$, new NSString(leaderboardId));
	}
}
