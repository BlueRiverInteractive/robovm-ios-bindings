
package org.robovm.bindings.thinkgaming;

import java.util.Map;
import java.util.Map.Entry;

import org.robovm.apple.foundation.NSDecimalNumber;
import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSMutableDictionary;
import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.foundation.NSString;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;

@NativeClass
public class ThinkGamingLogger extends NSObject {
	@Method(selector = "currentApiKey")
	public static native String getCurrentApiKey ();

	@Method(selector = "deviceId")
	public static native String getDeviceId ();

	/** Force flushing the current logging data to the server. */
	@Method(selector = "forceFlush")
	public static native void forceFlush ();

	/** Start session with given API key (get your API key from your dashboard).
	 * @param apiKey
	 * @return */
	@Method(selector = "startSession:")
	public static native ThinkGamingLogger startSession (String apiKey);

	@Method(selector = "startSession:andMediaSourceId:")
	public static native ThinkGamingLogger startSession (String apiKey, String mediaSourceId);

	/** Log events after session has started.
	 * @param eventName */
	@Method(selector = "logEvent:")
	public static native void logEvent (String eventName);

	/** Log events after session has started. If passing parameters, simply make a dictionary with the key-value pairs as you wish
	 * for them to appear in your event dashboard.
	 * 
	 * @param eventName
	 * @param parameters */
	@Method(selector = "logEvent:withParameters:")
	public static native void logEvent (String eventName, NSDictionary<?, ?> parameters);

	public static void logEvent (String eventName, Map<String, String> parameters) {
		if (parameters != null) {
			NSMutableDictionary<NSString, NSString> nsParams = new NSMutableDictionary<NSString, NSString>();
			for (Entry<String, String> entry : parameters.entrySet()) {
				nsParams.put(new NSString(entry.getKey()), new NSString(entry.getValue()));
			}
			logEvent(eventName, nsParams);
		} else {
			logEvent(eventName);
		}
	}

	/** Start a timed event with the given name. End the timed event by calling endTimedEvent on the logger, or the returned
	 * {@link ThinkGamingEvent} object.
	 * @param eventName
	 * @return */
	@Method(selector = "startTimedEvent:")
	public static native ThinkGamingEvent startTimedEvent (String eventName);

	/** Start a timed event with the given name. End the timed event by calling endTimedEvent on the logger, or the returned
	 * {@link ThinkGamingEvent} object.
	 * @param eventName
	 * @param parameters
	 * @return */
	@Method(selector = "startTimedEvent:withParameters:")
	public static native ThinkGamingEvent startTimedEvent (String eventName, NSDictionary<?, ?> parameters);

	/** End a timed event.
	 * @param eventName
	 * @return */
	@Method(selector = "endTimedEvent:")
	public static native ThinkGamingEvent endTimedEvent (String eventName);

	/** End a timed event.
	 * @param eventName
	 * @param parameters
	 * @return */
	@Method(selector = "endTimedEvent:withParameters:")
	public static native ThinkGamingEvent endTimedEvent (String eventName, NSDictionary<?, ?> parameters);

	@Method(selector = "startLoggingViewedStore:")
	public static native ThinkGamingEvent startLoggingViewedStore (String storeIdentifier);

	@Method(selector = "startLoggingBuyingProduct:withPriceId:andMessageId:")
	public static native ThinkGamingEvent startLoggingBuyingProduct (String productIdentifier, int priceId, int messageId);

	@Method(selector = "endLoggingBuyingProduct:")
	public static native ThinkGamingEvent endLoggingBuyingProduct (String productIdentifier, int priceId, int messageId,
		String result);

	@Method(selector = "logProductPurchased:withPrice:andPriceLocale:andTitle:")
	public static native void logProductPurchased (String productIdentifier, NSDecimalNumber price, String priceLocale,
		String title);

	/* DEFAULT IS ENABLED */
	@Method(selector = "setImplicitStoreLoggingEnabled")
	public static native void setImplicitStoreLoggingEnabled ();

	@Method(selector = "setImplicitStoreLoggingDisabled")
	public static native void setImplicitStoreLoggingDisabled ();
}
