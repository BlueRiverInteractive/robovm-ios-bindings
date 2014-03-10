
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
public class GPGPlayerModel extends NSObject {
	private static final ObjCClass objCClass = ObjCClass.getByType(GPGPlayerModel.class);

	static {
		ObjCRuntime.bind(GPGPlayerModel.class);
	}

	// - (GPGPlayer *)localPlayer;
	private static final Selector localPlayer$ = Selector.register("localPlayer");

	@Bridge
	private native static GPGPlayer objc_localPlayer (GPGPlayerModel __self__, Selector __cmd__);

	public GPGPlayer localPlayer () {
		return objc_localPlayer(this, localPlayer$);
	}
}
