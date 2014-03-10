
package org.robovm.bindings.gpgs;

import org.robovm.cocoatouch.foundation.NSNumber;
import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
@NativeClass()
public class GPGAppStateListInfo extends NSObject {
	private static final ObjCClass objCClass = ObjCClass.getByType(GPGAppStateListInfo.class);

	static {
		ObjCRuntime.bind(GPGAppStateListInfo.class);
	}

	// @property(nonatomic, readwrite, assign) BOOL dataIsStale;
	private static final Selector dataIsStale$ = Selector.register("dataIsStale");

	@Bridge
	private native static boolean objc_dataIsStale (GPGAppStateListInfo __self__, Selector __cmd__);

	public boolean dataIsStale () {
		return objc_dataIsStale(this, dataIsStale$);
	}

	private static final Selector setDataIsStale$ = Selector.register("setDataIsStale:");

	@Bridge
	private native static boolean objc_setDataIsStale (GPGAppStateListInfo __self__, Selector __cmd__, boolean dataIsStale);

	public void setDataIsStale (boolean dataIsStale) {
		objc_setDataIsStale(this, setDataIsStale$, dataIsStale);
	}

	// @property(nonatomic, readwrite, copy) NSNumber *key;
	private static final Selector key$ = Selector.register("key");

	@Bridge
	private native static int objc_key (GPGAppStateListInfo __self__, Selector __cmd__);

	public int key () {
		return objc_key(this, key$);
	}

	private static final Selector setKey$ = Selector.register("setKey:");

	@Bridge
	private native static boolean objc_setKey (GPGAppStateListInfo __self__, Selector __cmd__, NSNumber key);

	public void setKey (int key) {
		objc_setKey(this, setKey$, NSNumber.valueOf(key));
	}
}
