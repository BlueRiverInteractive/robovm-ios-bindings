
package org.robovm.bindings.appfireworks;

import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.uikit.UIView;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;

@NativeClass
public class AppTracker extends NSObject {
	@Method(selector = "startSession:")
	public static native void startSession (String apiKey);

	@Method(selector = "startSession:view:")
	public static native void startSession (String apiKey, UIView view);

	@Method(selector = "closeSession")
	public static native void closeSession ();

	@Method(selector = "setSyncDataPeriodInSecond:")
	public static native void setSyncDataPeriod (int periodInSecond);

	@Method(selector = "sync")
	public static native void sync ();

	@Method(selector = "event:")
	public static native void logEvent (String name);

	@Method(selector = "event:instant:")
	public static native void logEvent (String name, boolean instant);

	@Method(selector = "event:value:")
	public static native void logEvent (String name, float value);

	@Method(selector = "event:value:instant:")
	public static native void logEvent (String name, float value, boolean instant);

	@Method(selector = "event:value:ref:")
	public static native void logEvent (String name, float value, String ref);

	@Method(selector = "event:value:ref:instant:")
	public static native void logEvent (String name, float value, String ref, boolean instant);

	@Method(selector = "event:stringValue:")
	public static native void logEvent (String name, String value);

	@Method(selector = "event:stringValue:instant:")
	public static native void logEvent (String name, String value, boolean instant);

	@Method(selector = "event:stringValue:ref:")
	public static native void logEvent (String name, String value, String ref);

	@Method(selector = "event:stringValue:ref:instant:")
	public static native void logEvent (String name, String value, String ref, boolean instant);

	@Method(selector = "event:intValue:")
	public static native void logEvent (String name, int value);

	@Method(selector = "event:intValue:instant:")
	public static native void logEvent (String name, int value, boolean instant);

	@Method(selector = "event:intValue:ref:")
	public static native void logEvent (String name, int value, String ref);

	@Method(selector = "event:intValue:ref:instant:")
	public static native void logEvent (String name, int value, String ref, boolean instant);

	@Method(selector = "transaction:value:currencyCode:")
	public static native void logTransaction (String name, float value, String currencyCode);

	@Method(selector = "transaction:value:currencyCode:instant:")
	public static native void logTransaction (String name, float value, String currencyCode, boolean instant);

	@Method(selector = "transaction:value:currencyCode:ref:")
	public static native void logTransaction (String name, float value, String currencyCode, String ref);

	@Method(selector = "transaction:value:currencyCode:ref:instant:")
	public static native void logTransaction (String name, float value, String currencyCode, String ref, boolean instant);

	@Method(selector = "loadModule:view:")
	public static native boolean loadModule (String placement, UIView view);

	@Method(selector = "crashWithName:description:")
	public static native void crash (String crashName, String description);

	@Method(selector = "setLandscapeMode:")
	public static native void setLandscapeMode (boolean landscape);
}
