
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
public class GPGPlayer extends NSObject {
	private static final ObjCClass objCClass = ObjCClass.getByType(GPGPlayer.class);

	static {
		ObjCRuntime.bind(GPGPlayer.class);
	}

	// @property(nonatomic, readonly, copy) NSURL *avatarUrl;
	private static final Selector avatarUrl$ = Selector.register("avatarUrl");

	@Bridge
	private native static NSURL objc_avatarUrl (GPGPlayer __self__, Selector __cmd__);

	public NSURL avatarUrl () {
		return objc_avatarUrl(this, avatarUrl$);
	}

	// @property(nonatomic, readonly, copy) NSString *name;
	private static final Selector name$ = Selector.register("name");

	@Bridge
	private native static String objc_name (GPGPlayer __self__, Selector __cmd__);

	public String name () {
		return objc_name(this, name$);
	}

	// @property(nonatomic, readonly, copy) NSString *playerId;
	private static final Selector playerId$ = Selector.register("playerId");

	@Bridge
	private native static String objc_playerId (GPGPlayer __self__, Selector __cmd__);

	public String playerId () {
		return objc_playerId(this, playerId$);
	}
}
