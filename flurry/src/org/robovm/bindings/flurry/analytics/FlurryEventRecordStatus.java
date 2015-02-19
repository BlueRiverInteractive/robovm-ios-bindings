
package org.robovm.bindings.flurry.analytics;

import org.robovm.rt.bro.ValuedEnum;

/** Enum for setting up log output level.
 * 
 * @since 4.2.2 */
public enum FlurryEventRecordStatus implements ValuedEnum {
    Failed, Recorded, UniqueCountExceeded, ParamsCountExceeded, LogCountExceeded, LoggingDelayed;

    @Override
    public long value () {
        return ordinal();
    }
}
