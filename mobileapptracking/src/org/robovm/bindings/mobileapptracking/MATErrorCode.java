
package org.robovm.bindings.mobileapptracking;

import org.robovm.rt.bro.ValuedEnum;

public enum MATErrorCode implements ValuedEnum {
    NoAdvertiserIDProvided(1101), NoConversionKeyProvided(1102), InvalidConversionKey(1103), ServerErrorResponse(1111), InvalidEventClose(
        1131), TrackingWithoutInitializing(1132);

    private long value;

    MATErrorCode (long value) {
        this.value = value;
    }

    @Override
    public long value () {
        return value;
    }

}
