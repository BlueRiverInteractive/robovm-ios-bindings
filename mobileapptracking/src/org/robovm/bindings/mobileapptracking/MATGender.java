
package org.robovm.bindings.mobileapptracking;

import org.robovm.rt.bro.ValuedEnum;

public enum MATGender implements ValuedEnum {
    Male, Female;

    @Override
    public long value () {
        return ordinal();
    }
}
