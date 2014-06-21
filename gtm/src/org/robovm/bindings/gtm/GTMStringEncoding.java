
package org.robovm.bindings.gtm;

import org.robovm.apple.foundation.NSData;
import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;

@NativeClass
public class GTMStringEncoding extends NSObject {
// Create a new, autoreleased GTMStringEncoding object with a standard encoding.
// + (id)binaryStringEncoding;
// + (id)hexStringEncoding;
// + (id)rfc4648Base32StringEncoding;
// + (id)rfc4648Base32HexStringEncoding;
// + (id)crockfordBase32StringEncoding;

	@Method(selector = "rfc4648Base64StringEncoding")
	public static native GTMStringEncoding createRFC4648Base64StringEncoding ();

	@Method(selector = "rfc4648Base64WebsafeStringEncoding")
	public static native GTMStringEncoding createRFC4648Base64WebsafeStringEncoding ();

	// // Create a new, autoreleased GTMStringEncoding object with the given string,
// // as described below.
// + (id)stringEncodingWithString:(NSString *)string;
//
// // Initialize a new GTMStringEncoding object with the string.
// //
// // The length of the string must be a power of 2, at least 2 and at most 128.
// // Only 7-bit ASCII characters are permitted in the string.
// //
// // These characters are the canonical set emitted during encoding.
// // If the characters have alternatives (e.g. case, easily transposed) then use
// // addDecodeSynonyms: to configure them.
// - (id)initWithString:(NSString *)string;
//
// // Add decoding synonyms as specified in the synonyms argument.
// //
// // It should be a sequence of one previously reverse mapped character,
// // followed by one or more non-reverse mapped character synonyms.
// // Only 7-bit ASCII characters are permitted in the string.
// //
// // e.g. If a GTMStringEncoder object has already been initialised with a set
// // of characters excluding I, L and O (to avoid confusion with digits) and you
// // want to accept them as digits you can call addDecodeSynonyms:@"0oO1iIlL".
// - (void)addDecodeSynonyms:(NSString *)synonyms;
//
// // A sequence of characters to ignore if they occur during encoding.
// // Only 7-bit ASCII characters are permitted in the string.
// - (void)ignoreCharacters:(NSString *)chars;
//
// // Indicates whether padding is performed during encoding.
// - (BOOL)doPad;
// - (void)setDoPad:(BOOL)doPad;
//
// // Sets the padding character to use during encoding.
// - (void)setPaddingChar:(char)c;
//
	/** Encode a raw binary buffer to a 7-bit ASCII string.
	 * @param data
	 * @return */
	@Method(selector = "encode:")
	public native String encode (NSData data);

// - (NSString *)encodeString:(NSString *)string;
//
// // Decode a 7-bit ASCII string to a raw binary buffer.
// - (NSData *)decode:(NSString *)string;
// - (NSString *)stringByDecoding:(NSString *)string;

}
