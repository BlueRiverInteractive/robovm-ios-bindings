
package org.robovm.cocoatouch.temp;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSString;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

@Library("Foundation")
@NativeClass
public class NSLocale extends NSObject {
	static {
		ObjCRuntime.bind(NSLocale.class);
	}

	private static final ObjCClass objCClass = ObjCClass.getByType(NSLocale.class);

	protected NSLocale (SkipInit skipInit) {
		super(skipInit);
	}

	public NSLocale () {
	}

	public static final NSString Identifier = new NSString("kCFLocaleIdentifierKey");
	public static final NSString LanguageCode = new NSString("kCFLocaleLanguageCodeKey");
	public static final NSString CountryCode = new NSString("kCFLocaleCountryCodeKey");
	public static final NSString ScriptCode = new NSString("kCFLocaleScriptCodeKey");
	public static final NSString VariantCode = new NSString("kCFLocaleVariantCodeKey");
	public static final NSString ExemplarCharacterSet = new NSString("kCFLocaleExemplarCharacterSetKey");
	public static final NSString Calendar = new NSString("kCFLocaleCalendarKey");
	public static final NSString CollationIdentifier = new NSString("collation");
	public static final NSString NUsesMetricSystem = new NSString("kCFLocaleUsesMetricSystemKey");
	public static final NSString MeasurementSystem = new NSString("kCFLocaleMeasurementSystemKey");
	public static final NSString DecimalSeparator = new NSString("kCFLocaleDecimalSeparatorKey");
	public static final NSString GroupingSeparator = new NSString("kCFLocaleGroupingSeparatorKey");
	public static final NSString CurrencySymbol = new NSString("kCFLocaleCurrencySymbolKey");
	public static final NSString CurrencyCode = new NSString("currency");

	private static final Selector objectForKey$ = Selector.register("objectForKey:");

	@Bridge
	private native static NSObject objc_objectForKey (NSLocale __self__, Selector __cmd__, NSObject aKey);

	public NSObject get (NSObject aKey) {
		return objc_objectForKey(this, objectForKey$, aKey);
	}
}
