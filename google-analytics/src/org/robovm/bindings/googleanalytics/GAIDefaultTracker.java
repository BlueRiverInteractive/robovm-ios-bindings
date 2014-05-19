
package org.robovm.bindings.googleanalytics;

import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.foundation.NSString;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;

@NativeClass
public class GAIDefaultTracker extends NSObject implements GAITracker {
	static {
		ObjCRuntime.bind();
	}

	@Override
	public String getName () {
		return this.getName();
	}

	@Override
	public void set (String parameterName, String value) {
		objc_set(parameterName, value);
	}

	@Method(selector = "set:value:")
	private native void objc_set (String parameterName, String value);

	@Override
	public String get (String parameterName) {
		return objc_get(parameterName);
	}

	@Method(selector = "get:")
	private native String objc_get (String parameterName);

	@Override
	public void send (NSDictionary<NSString, NSString> parameters) {
		objc_send(parameters);
	}

	@Method(selector = "send:")
	private native void objc_send (NSDictionary<NSString, NSString> parameters);
}
