
package org.robovm.bindings.googleanalytics;

import org.robovm.apple.foundation.NSObjectProtocol;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

/** Protocol to be used for logging debug and informational messages from the SDK. Implementations of this protocol can be provided
 * to the GAI class, to be used as the logger by the SDK. */
@NativeClass
public interface GAILogger extends NSObjectProtocol {
	/** Only messages of |logLevel| and below are logged. */
	@Property
	public void setLogLevel (GAILogLevel level);

	@Property
	public GAILogLevel getLogLevel ();

	/** Logs message with log level "Verbose". */
	@Method
	public void verbose (String message);

	/** Logs message with log level "Info". */
	@Method
	public void info (String message);

	/** Logs message with log level "Warning". */
	@Method
	public void warning (String message);

	/** Logs message with log level "Error". */
	@Method
	public void error (String message);
}
