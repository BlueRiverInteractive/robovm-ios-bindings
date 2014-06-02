
package org.robovm.bindings.tapstream;

import java.util.Map;

import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.foundation.NSString;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;

@NativeClass
public class TSEvent extends NSObject {
// @property(nonatomic, STRONG_OR_RETAIN, readonly) NSString *uid;
// @property(nonatomic, STRONG_OR_RETAIN, readonly) NSString *name;
// @property(nonatomic, STRONG_OR_RETAIN, readonly) NSString *encodedName;
// @property(nonatomic, STRONG_OR_RETAIN, readonly) NSString *productId;
// @property(nonatomic, STRONG_OR_RETAIN, readonly) NSMutableDictionary *customFields;
// @property(nonatomic, STRONG_OR_RETAIN, readonly) NSString *postData;
// @property (nonatomic, assign, readonly) BOOL isOneTimeOnly;
// @property (nonatomic, assign, readonly) BOOL isTransaction;

	@Method(selector = "eventWithName:oneTimeOnly:")
	public static native TSEvent create (String name, boolean oneTimeOnly);

	// + (id)eventWithTransactionId:(NSString *)transactionId
// productId:(NSString *)productId
// quantity:(int)quantity;
//
// + (id)eventWithTransactionId:(NSString *)transactionId
// productId:(NSString *)productId
// quantity:(int)quantity
// priceInCents:(int)priceInCents
// currency:(NSString *)currencyCode;
//
// + (id)eventWithTransactionId:(NSString *)transactionId
// productId:(NSString *)productId
// quantity:(int)quantity
// priceInCents:(int)priceInCents
// currency:(NSString *)currencyCode
// base64Receipt:(NSString *)base64Receipt;

	public void addValues (Map<String, String> values) {
		if (values != null) {
			for (java.util.Map.Entry<String, String> entry : values.entrySet()) {
				addValue(entry.getKey(), entry.getValue());
			}
		}
	}

	public void addValue (String key, String value) {
		addValue(new NSString(value), key);
	}

	public void addValue (String key, NSObject value) {
		addValue(value, key);
	}

	@Method(selector = "addValue:forKey:")
	private native void addValue (NSObject obj, String key);
}
