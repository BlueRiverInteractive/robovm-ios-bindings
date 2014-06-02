
package org.robovm.bindings.tapstream;

import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class TSConfig extends NSObject {
// @property(nonatomic, STRONG_OR_RETAIN) NSString *hardware;
// @property(nonatomic, STRONG_OR_RETAIN) NSString *odin1;
// #if TEST_IOS || TARGET_OS_IPHONE || TARGET_IPHONE_SIMULATOR
// @property(nonatomic, STRONG_OR_RETAIN) NSString *udid;

	@Property
	public native void setIdfa (String idfa);

	@Property
	public native String getIdfa ();

// @property(nonatomic, STRONG_OR_RETAIN) NSString *secureUdid;
// @property(nonatomic, STRONG_OR_RETAIN) NSString *openUdid;
// #else
// @property(nonatomic, STRONG_OR_RETAIN) NSString *serialNumber;
// #endif
//
// @property(nonatomic, assign) BOOL collectWifiMac;
//
// @property(nonatomic, STRONG_OR_RETAIN) NSString *installEventName;
// @property(nonatomic, STRONG_OR_RETAIN) NSString *openEventName;
//
// @property(nonatomic, assign) BOOL fireAutomaticInstallEvent;
// @property(nonatomic, assign) BOOL fireAutomaticOpenEvent;
// @property(nonatomic, assign) BOOL fireAutomaticIAPEvents;
//
// @property(nonatomic, assign) BOOL collectTasteData;
//
// @property(nonatomic, STRONG_OR_RETAIN) NSMutableDictionary *globalEventParams;

	// + (id)configWithDefaults;

	@Property
	public native void setHardcodedBundleId (String hardcodedBundleId);

	@Property
	public native String getHardcodedBundleId ();

	@Property
	public native void setHardcodedBundleShortVersionString (String hardcodedBundleShortVersionString);

	@Property
	public native String getHardcodedBundleShortVersionString ();
}
