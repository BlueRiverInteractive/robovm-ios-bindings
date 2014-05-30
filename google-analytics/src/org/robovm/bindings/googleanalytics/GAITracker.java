
package org.robovm.bindings.googleanalytics;

import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSObjectProtocol;
import org.robovm.apple.foundation.NSString;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.Property;

/** Google Analytics tracking interface. Obtain instances of this interface from {@link GAI#getTracker(String)} to track screens,
 * events, transactions, timing, and exceptions. The implementation of this interface is thread-safe, and no calls are expected to
 * block or take a long time. All network and disk activity will take place in the background. */
public interface GAITracker extends NSObjectProtocol {
	/** Name of this tracker. */
	@Property
	public String getName ();

	/** Set a tracking parameter.
	 * 
	 * @param parameterName The parameter name.
	 * 
	 * @param value The value to set for the parameter. If this is {@code null}, the value for the parameter will be cleared. */
	@Method(selector = "set:value:")
	public void set (String parameterName, String value);

	/** Get a tracking parameter.
	 * 
	 * @param parameterName The parameter name.
	 * 
	 * @returns The parameter value, or {@code null} if no value for the given parameter is set. */
	@Method(selector = "get:")
	public String get (String parameterName);

	/** Queue tracking information with the given parameter values.
	 * 
	 * @param parameters A map from parameter names to parameter values which will be set just for this piece of tracking
	 *           information, or {@code null} for none. */
	@Method(selector = "send:")
	public void send (NSDictionary<NSString, NSString> parameters);
}
