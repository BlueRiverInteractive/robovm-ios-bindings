
package org.robovm.bindings.thinkgaming;

import org.robovm.cocoatouch.foundation.NSDictionary;
import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
@NativeClass()
public class ThinkGamingLogger extends NSObject {
	private static final ObjCClass objCClass = ObjCClass.getByType(ThinkGamingLogger.class);

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
	@Method(selector = "logEvent:withParameters")
	public static native void logEvent (String eventName, NSDictionary<?, ?> parameters);

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
	public static native void logProductPurchased (String productIdentifier, double price, String priceLocale, String title);

	/*
	 * Receipt Validation Server Selectors. THE DEFAULT IS PRODUCTION.
	 */
	@Method(selector = "setReceiptValidationModeToSandbox")
	public static native void setReceiptValidationModeToSandbox ();

	@Method(selector = "setReceiptValidationModeToProduction")
	public static native void setReceiptValidationModeToProduction ();

	/* DEFAULT IS DISABLED */
	@Method(selector = "setReceiptValidationModeEnabled")
	public static native void setReceiptValidationModeEnabled ();

	@Method(selector = "setReceiptValidationModeDisabled")
	public static native void setReceiptValidationModeDisabled ();
}
