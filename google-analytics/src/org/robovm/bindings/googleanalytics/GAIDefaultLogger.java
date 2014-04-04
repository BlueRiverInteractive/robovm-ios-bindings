
package org.robovm.bindings.googleanalytics;

import org.robovm.objc.annotation.NativeClass;

@NativeClass
public class GAIDefaultLogger implements GAILogger {
	private GAILogLevel logLevel;

	@Override
	public void setLogLevel (GAILogLevel level) {
		logLevel = level;
	}

	@Override
	public GAILogLevel getLogLevel () {
		return logLevel;
	}

	@Override
	public void verbose (String message) {
		if (logLevel.ordinal() >= GAILogLevel.Verbose.ordinal()) {
			System.out.println(message);
		}
	}

	@Override
	public void info (String message) {
		if (logLevel.ordinal() >= GAILogLevel.Info.ordinal()) {
			System.out.println(message);
		}
	}

	@Override
	public void warning (String message) {
		if (logLevel.ordinal() >= GAILogLevel.Warning.ordinal()) {
			System.out.println(message);
		}
	}

	@Override
	public void error (String message) {
		if (logLevel.ordinal() >= GAILogLevel.Error.ordinal()) {
			System.err.println(message);
		}
	}
}
