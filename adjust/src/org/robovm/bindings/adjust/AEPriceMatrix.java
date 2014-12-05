
package org.robovm.bindings.adjust;

import org.robovm.apple.foundation.NSNumber;
import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;

@NativeClass
public class AEPriceMatrix extends NSObject {

    @Method(selector = "convert:from:to:")
    public static native NSNumber convert (NSNumber value, String currencyIn, String currencyOut);

}
