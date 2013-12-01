package com.googleanalytics.robovmbindings;

import org.robovm.cocoatouch.foundation.NSMutableDictionary;
import org.robovm.cocoatouch.foundation.NSNumber;
import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSString;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

/**
 * Helper class to build a dictionary of hit parameters and values.
 * <br>
 * Examples:
 * <code>
 * id<GAITracker> t = // get a tracker.
 * [t send:[[[GAIDictionaryBuilder createEventWithCategory:@"EventCategory"
 *                                                  action:@"EventAction"
 *                                                   label:nil
 *                                                   value:nil]
 *     set:@"dimension1" forKey:[GAIFields customDimensionForIndex:1]] build]];
 * </code>
 * This will send an event hit type with the specified parameters
 * and a custom dimension parameter.
 * <br>
 * If you want to send a parameter with all hits, set it on GAITracker directly.
 * <code>
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
 * </code>
 * You can override a value set on the tracker by adding it to the dictionary.
 * <code>
 * [t set:kGAIScreenName value:@"Home"];
 * [t send:...];
 * [t send[[[GAIDictionaryBuilder createEventWithCategory:@"click"
 *                                                 action:@"popup"
 *                                                  label:nil
 *                                                  value:nil]
 *     set:@"popup title" forKey:kGAIScreenName] build]];
 * </code>
 * The values set via [GAIDictionaryBuilder set] or
 * [GAIDictionaryBuilder setAll] will override any existing values in the
 * GAIDictionaryBuilder object (i.e. initialized by
 * [GAIDictionaryBuilder createXYZ]). e.g.
 * <code>
 * GAIDictionaryBuilder *m =
 *     GAIDictionaryBuilder createTimingWithCategory:@"category"
 *                                          interval:@0
 *                                              name:@"name"
 *                                             label:nil];
 * [t send:[m.set:@"10" forKey:kGAITimingVar] build];
 * [t send:[m.set:@"20" forKey:kGAITimingVar] build];
 * </code>
 */
@Library(Library.INTERNAL)
@NativeClass()
public class GAIDictionaryBuilder extends NSObject{
	private static final ObjCClass objCClass = ObjCClass.getByType(GAIDictionaryBuilder.class);

	static {
		ObjCRuntime.bind(GAIDictionaryBuilder.class);
	}
	
	//	- (GAIDictionaryBuilder *)set:(NSString *)value
	//    forKey:(NSString *)key;
	private static final Selector set$ = Selector.register("set:forKey:");
	@Bridge private native static GAIDictionaryBuilder objc_set(GAIDictionaryBuilder __self__, Selector __cmd__,NSString value,NSString key);
	public GAIDictionaryBuilder set(String value, String key){
		return objc_set(this, set$,new NSString(value), new NSString(key));
	}
	
	//- (GAIDictionaryBuilder *)setAll:(NSDictionary *)params;
	private static final Selector setAll$ = Selector.register("setAll:");
	@Bridge private native static GAIDictionaryBuilder objc_setAll(GAIDictionaryBuilder __self__, Selector __cmd__,GAIDictionaryBuilder params);
	/**
	 * Copies all the name-value pairs from params into this object, ignoring any
	 * keys that are not NSString and any values that are neither NSString or
	 * NSNull.
	 */
	public GAIDictionaryBuilder setAll(GAIDictionaryBuilder hitParams){
    	return objc_setAll(this, setAll$, hitParams);
    }
	
	//- (NSString *)get:(NSString *)paramName;
	private static final Selector get$ = Selector.register("get:");
	@Bridge private native static NSString objc_get(GAIDictionaryBuilder __self__, Selector __cmd__,NSString paramName);
	/** Returns the value for the input parameter paramName, or nil if paramName is not present.*/
	public NSString get(String paramName){
    	return objc_get(this, get$, new NSString(paramName));
    }
	
	//- (NSMutableDictionary *)build;
	private static final Selector build$ = Selector.register("build");
	@Bridge private native static NSMutableDictionary objc_build(GAIDictionaryBuilder __self__, Selector __cmd__);
	/** Return an NSMutableDictionary object with all the parameters set in this */
	public NSMutableDictionary build(){
    	return objc_build(this, build$);
    }
	
	//- (GAIDictionaryBuilder *)setCampaignParametersFromUrl:(NSString *)urlString;
	private static final Selector setCampaignParametersFromUrl$ = Selector.register("setCampaignParametersFromUrl:");
	@Bridge private native static GAIDictionaryBuilder objc_setCampaignParametersFromUrl(GAIDictionaryBuilder __self__, Selector __cmd__,
			NSString urlString);
	/**
	 * Parses and translates utm campaign parameters to analytics campaign param
	 * and returns them as a map.
	 *
	 * @param params url containing utm campaign parameters.
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
	 * Example:
	 * http://my.site.com/index.html?utm_campaign=wow&utm_source=source
	 * utm_campaign=wow&utm_source=source.
	 * <p>
	 * For more information on auto-tagging, see
	 * http://support.google.com/googleanalytics/bin/answer.py?hl=en&answer=55590
	 * <p>
	 * For more information on manual tagging, see
	 * http://support.google.com/googleanalytics/bin/answer.py?hl=en&answer=55518
	 */
	public GAIDictionaryBuilder setCampaignParametersFromUrl(String urlString){
		return objc_setCampaignParametersFromUrl(this, setCampaignParametersFromUrl$, new NSString(urlString));
	}
	
	//+ (GAIDictionaryBuilder *)createAppView;
	private static final Selector createAppView$ = Selector.register("createAppView");
	@Bridge private native static GAIDictionaryBuilder objc_createAppView(ObjCClass __self__, Selector __cmd__);
	/**
	 *Returns a GAIDictionaryBuilder object with parameters specific to an appview
	 *hit.
	 *
	 *	 Note that using this method will not set the screen name for followon hits.  To
	 *	 do that you need to call set:kGAIDescription value:<screenName> on the
	 *	 GAITracker instance.
	 */
	public static GAIDictionaryBuilder createAppView(){
		return objc_createAppView(objCClass, createAppView$);
	}


	//	+ (GAIDictionaryBuilder *)createEventWithCategory:(NSString *)category
	//	                                           action:(NSString *)action
	//	                                            label:(NSString *)label
	//	                                            value:(NSNumber *)value;
	private static final Selector createEventWithCategory$ = Selector.register("createEventWithCategory:action:label:value:");
	@Bridge private native static GAIDictionaryBuilder objc_createEventWithCategory(ObjCClass __self__, Selector __cmd__,
			NSString category, NSString action, NSString label, NSNumber value);
	/** Returns a GAIDictionaryBuilder object with parameters specific to an event hit. */
	public static GAIDictionaryBuilder createEventWithCategory(String category, String action, String label, NSNumber value){
		return objc_createEventWithCategory(objCClass, createEventWithCategory$, 
				new NSString(category), new NSString(action), label!=null?new NSString(label):null, value);
	}
	

	//	+ (GAIDictionaryBuilder *)createExceptionWithDescription:(NSString *)description
	//	                                               withFatal:(NSNumber *)fatal;
	private static final Selector createExceptionWithDescription$ = Selector.register("createExceptionWithDescription:withFatal:");
	@Bridge private native static GAIDictionaryBuilder objc_createExceptionWithDescription(ObjCClass __self__, Selector __cmd__,
			NSString description, NSNumber fatal);
	/** Returns a GAIDictionaryBuilder object with parameters specific to an exception hit. */
	public static GAIDictionaryBuilder createExceptionWithDescription(String description, boolean fatal){
		return objc_createExceptionWithDescription(objCClass, createExceptionWithDescription$, new NSString(description), NSNumber.valueOf(fatal));
	}
	

	//	+ (GAIDictionaryBuilder *)createItemWithTransactionId:(NSString *)transactionId
	//	                                                 name:(NSString *)name
	//	                                                  sku:(NSString *)sku
	//	                                             category:(NSString *)category
	//	                                                price:(NSNumber *)price
	//	                                             quantity:(NSNumber *)quantity
	//	                                         currencyCode:(NSString *)currencyCode;
	private static final Selector createItemWithTransactionId$ = Selector.register("createItemWithTransactionId:name:sku:category:price:quantity:currencyCode:");
	@Bridge private native static GAIDictionaryBuilder objc_createItemWithTransactionId(ObjCClass __self__, Selector __cmd__,
			NSString transactionId, NSString name, NSString sku, NSString category, NSNumber price, NSNumber quantity, NSString currencyCode);
	/** Returns a GAIDictionaryBuilder object with parameters specific to an item hit. */
	public static GAIDictionaryBuilder createItemWithTransactionId(
			NSString transactionId, NSString name, NSString sku, NSString category, NSNumber price, NSNumber quantity, NSString currencyCode){
		return objc_createItemWithTransactionId(objCClass, createItemWithTransactionId$, 
				transactionId, name, sku, category, price, quantity, currencyCode);
	}
	

	//	+ (GAIDictionaryBuilder *)createSocialWithNetwork:(NSString *)network
	//	                                           action:(NSString *)action
	//	                                           target:(NSString *)target;	
	private static final Selector createSocialWithNetwork$ = Selector.register("createSocialWithNetwork:action:target:");
	@Bridge private native static GAIDictionaryBuilder objc_createSocialWithNetwork(ObjCClass __self__, Selector __cmd__,
			NSString network, NSString action, NSString target);
	/** Returns a GAIDictionaryBuilder object with parameters specific to a social hit. */
	public static GAIDictionaryBuilder createSocialWithNetwork(NSString network, NSString action, NSString target){
		return objc_createSocialWithNetwork(objCClass, createSocialWithNetwork$, network, network, target);
	} 
	

	//	+ (GAIDictionaryBuilder *)createTimingWithCategory:(NSString *)category
	//	                                          interval:(NSNumber *)intervalMillis
	//	                                              name:(NSString *)name
	//	                                             label:(NSString *)label;
	private static final Selector createTimingWithCategory$ = Selector.register("createTimingWithCategory:interval:name:label:");
	@Bridge private native static GAIDictionaryBuilder objc_createTimingWithCategory(ObjCClass __self__, Selector __cmd__,
			NSString category, NSNumber intervalMillis, NSString name, NSString label);
	/** Returns a GAIDictionaryBuilder object with parameters specific to a timing hit. */
	public static GAIDictionaryBuilder createTimingWithCategory(NSString category, NSNumber intervalMillis, NSString name, NSString label){
		return objc_createTimingWithCategory(objCClass, createTimingWithCategory$, category, intervalMillis, name, label);
	} 
	
	
	 
	//	+ (GAIDictionaryBuilder *)createTransactionWithId:(NSString *)transactionId
	//	                                      affiliation:(NSString *)affiliation
	//	                                          revenue:(NSNumber *)revenue
	//	                                              tax:(NSNumber *)tax
	//	                                         shipping:(NSNumber *)shipping
	//	                                     currencyCode:(NSString *)currencyCode;
	private static final Selector createTransactionWithId$ = Selector.register("createTransactionWithId:affiliation:revenue:tax:shipping:currencyCode:");
	@Bridge private native static GAIDictionaryBuilder objc_createTransactionWithId(ObjCClass __self__, Selector __cmd__,
			NSString transactionId, NSString affiliation, NSNumber revenue, NSNumber tax, NSNumber shipping, NSString currencyCode);
	/** Returns a GAIDictionaryBuilder object with parameters specific to a transaction hit.*/
	public static GAIDictionaryBuilder createTransactionWithId(
			NSString transactionId, NSString affiliation, NSNumber revenue, NSNumber tax, NSNumber shipping, NSString currencyCode){
		return objc_createTransactionWithId(objCClass, createTransactionWithId$, transactionId, affiliation, revenue, tax, shipping, currencyCode);
	} 
}
