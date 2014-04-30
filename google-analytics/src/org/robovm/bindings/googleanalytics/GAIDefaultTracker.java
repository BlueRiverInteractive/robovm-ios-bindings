
package org.robovm.bindings.googleanalytics;

import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.foundation.NSString;

public class GAIDefaultTracker extends NSObject implements GAITracker {
	@Override
	public String getName () {
		return null;
	}

	@Override
	public void set (String parameterName, String value) {
	}

	@Override
	public String get (String parameterName) {
		return null;
	}

	@Override
	public void send (NSDictionary<NSString, NSString> parameters) {
	}
}
