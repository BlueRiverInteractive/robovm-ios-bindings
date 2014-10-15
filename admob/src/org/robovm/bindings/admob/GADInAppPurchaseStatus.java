
package org.robovm.bindings.admob;

import org.robovm.rt.bro.ValuedEnum;

public enum GADInAppPurchaseStatus implements ValuedEnum {
    /** Error occured while processing the purchase. */
    Error,
    /** Purchase was completed successfully. */
    Successful,
    /** Purchase was cancelled by the user. */
    Cancel,
    /** Error occurred while looking up the product. */
    InvalidProduct;

    @Override
    public long value () {
        return ordinal();
    }
}
