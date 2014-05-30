
package org.robovm.bindings.googleanalytics;

import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.foundation.NSString;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;

@NativeClass
public class GAIDefaultTracker extends NSObject implements GAITracker {
	static {
		ObjCRuntime.bind();
	}

	@Override
	public String getName () {
		return this.getName();
	}

	// - (void)set:(NSString *)parameterName
	// value:(NSString *)value;
	private static final Selector set$ = Selector.register("set:value:");

	@Bridge
	private native static void objc_set (GAIDefaultTracker __self__, Selector __cmd__, NSString parameterName, NSString value);

	@Override
	/**
	 * Set a tracking parameter.
	 *
	 *	 @param parameterName The parameter name.
	 *
	 *	 @param value The value to set for the parameter. If this is nil, the
	 *	 value for the parameter will be cleared.
	 */
	public void set (String parameterName, String value) {
		objc_set(this, set$, new NSString(parameterName), new NSString(value));
	}

	// - (NSString *)get:(NSString *)parameterName;
	private static final Selector get$ = Selector.register("get:");

	@Bridge
	private native static String objc_get (GAIDefaultTracker __self__, Selector __cmd__, NSString parameterName);

	@Override
	/**
	 *Get a tracking parameter.
	 *
	 *	 @param parameterName The parameter name.
	 *
	 *	 @returns The parameter value, or nil if no value for the given parameter is
	 *	 set.
	 */
	public String get (String parameterName) {
		return objc_get(this, get$, new NSString(parameterName));
	}

	// - (void)send:(NSDictionary *)parameters;
	private static final Selector send$ = Selector.register("send:");

	@Bridge
	private native static void objc_send (GAIDefaultTracker __self__, Selector __cmd__, NSDictionary parameters);

	@Override
	/**
	 *Queue tracking information with the given parameter values.
	 *
	 *	 @param parameters A map from parameter names to parameter values which will be
	 *	 set just for this piece of tracking information, or nil for none.
	 */
	public void send (NSDictionary parameters) {
		objc_send(this, send$, parameters);
	}

}
