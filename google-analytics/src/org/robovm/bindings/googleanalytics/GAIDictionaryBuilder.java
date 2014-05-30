
package org.robovm.bindings.googleanalytics;

import org.robovm.apple.foundation.NSMutableDictionary;
import org.robovm.apple.foundation.NSNumber;
import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.foundation.NSString;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;

/** Helper class to build a dictionary of hit parameters and values. <br>
 * Examples: <code>
 * id<GAITracker> t = // get a tracker.
 * [t send:[[[GAIDictionaryBuilder createEventWithCategory:@"EventCategory"
 *                                                  action:@"EventAction"
 *                                                   label:{@code null}
 *                                                   value:{@code null}]
 *     set:@"dimension1" forKey:[GAIFields customDimensionForIndex:1]] build]];
 * </code> This will send an event hit type with the specified parameters and a custom dimension parameter. <br>
 * If you want to send a parameter with all hits, set it on GAITracker directly. <code>
 * [t set:kGAIScreenName value:@"Home"];
 * [t send:[[GAIDictionaryBuilder createSocialWithNetwork:@"Google+"
 *                                                 action:@"PlusOne"
 *                                                 target:@"SOME_URL"] build]];
 * [t send:[[GAIDictionaryBuilder createSocialWithNetwork:@"Google+"
 *                                                 action:@"Share"
 *                                                 target:@"SOME_POST"] build]];
 * [t send:[[GAIDictionaryBuilder createSocialWithNetwork:@"Google+"
 *                                                 action:@"HangOut"
 *                                                 target:@"SOME_CIRCLE"]
 *     build]];
 * </code> You can override a value set on the tracker by adding it to the dictionary. <code>
 * [t set:kGAIScreenName value:@"Home"];
 * [t send:...];
 * [t send[[[GAIDictionaryBuilder createEventWithCategory:@"click"
 *                                                 action:@"popup"
 *                                                  label:{@code null}
 *                                                  value:{@code null}]
 *     set:@"popup title" forKey:kGAIScreenName] build]];
 * </code> The values set via [GAIDictionaryBuilder set] or [GAIDictionaryBuilder setAll] will override any existing values in the
 * GAIDictionaryBuilder object (i.e. initialized by [GAIDictionaryBuilder createXYZ]). e.g. <code>
 * GAIDictionaryBuilder *m =
 *     GAIDictionaryBuilder createTimingWithCategory:@"category"
 *                                          interval:@0
 *                                              name:@"name"
 *                                             label:{@code null}];
 * [t send:[m.set:@"10" forKey:kGAITimingVar] build];
 * [t send:[m.set:@"20" forKey:kGAITimingVar] build];
 * </code> */
@NativeClass
public class GAIDictionaryBuilder extends NSObject {

	@Method(selector = "set:forKey:")
	public native GAIDictionaryBuilder set (String value, String key);

	/** Copies all the name-value pairs from params into this object, ignoring any keys that are not NSString and any values that
	 * are neither NSString or NSNull. */
	@Method(selector = "setAll:")
	public native GAIDictionaryBuilder setAll (GAIDictionaryBuilder hitParams);

	/** Returns the value for the input parameter paramName, or {@code null} if paramName is not present. */
	@Method(selector = "get:")
	public native String get (String paramName);

	/** Return an NSMutableDictionary object with all the parameters set in this */
	@Method(selector = "build")
	public native NSMutableDictionary<NSString, NSString> build ();

	/** Parses and translates utm campaign parameters to analytics campaign param and returns them as a map.
	 * 
	 * Valid campaign parameters are:
	 * <ul>
	 * <li>utm_id</li>
	 * <li>utm_campaign</li>
	 * <li>utm_content</li>
	 * <li>utm_medium</li>
	 * <li>utm_source</li>
	 * <li>utm_term</li>
	 * <li>dclid</li>
	 * <li>gclid</li>
	 * <li>gmob_t</li>
	 * </ul>
	 * <p>
	 * Example: http://my.site.com/index.html?utm_campaign=wow&utm_source=source utm_campaign=wow&utm_source=source.
	 * <p>
	 * For more information on auto-tagging, see http://support.google.com/googleanalytics/bin/answer.py?hl=en&answer=55590
	 * <p>
	 * For more information on manual tagging, see http://support.google.com/googleanalytics/bin/answer.py?hl=en&answer=55518
	 * 
	 * @param params url containing utm campaign parameters. */
	@Method(selector = "setCampaignParametersFromUrl:")
	public native GAIDictionaryBuilder setCampaignParameters (String urlString);

	/** Returns a GAIDictionaryBuilder object with parameters specific to an appview hit.
	 * 
	 * Note that using this method will not set the screen name for followon hits. To do that you need to call set:kGAIDescription
	 * value:<screenName> on the GAITracker instance. */
	@Method(selector = "createAppView")
	public static native GAIDictionaryBuilder createAppView ();

	/** Returns a GAIDictionaryBuilder object with parameters specific to an event hit. */
	@Method(selector = "createEventWithCategory:action:label:value:")
	public static native GAIDictionaryBuilder createEvent (String category, String action, String label, NSNumber value);

	/** Returns a GAIDictionaryBuilder object with parameters specific to an exception hit. */
	@Method(selector = "createExceptionWithDescription:withFatal:")
	public static native GAIDictionaryBuilder createException (String description, boolean fatal);

	/** Returns a GAIDictionaryBuilder object with parameters specific to an item hit. */
	@Method(selector = "createItemWithTransactionId:name:sku:category:price:quantity:currencyCode:")
	public static native GAIDictionaryBuilder createItem (String transactionId, String name, String sku, String category,
		NSNumber price, NSNumber quantity, String currencyCode);

	/** Returns a GAIDictionaryBuilder object with parameters specific to a social hit. */
	@Method(selector = "createSocialWithNetwork:action:target:")
	public static native GAIDictionaryBuilder createSocial (String network, String action, String target);

	/** Returns a GAIDictionaryBuilder object with parameters specific to a timing hit. */
	@Method(selector = "createTimingWithCategory:interval:name:label:")
	public static native GAIDictionaryBuilder createTiming (String category, NSNumber intervalMillis, String name, String label);

	/** Returns a GAIDictionaryBuilder object with parameters specific to a transaction hit. */
	@Method(selector = "createTransactionWithId:affiliation:revenue:tax:shipping:currencyCode:")
	public static native GAIDictionaryBuilder createTransaction (String transactionId, String affiliation, NSNumber revenue,
		NSNumber tax, NSNumber shipping, String currencyCode);
}
