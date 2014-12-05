
package org.robovm.bindings.mobileapptracking;

import org.robovm.apple.corelocation.CLRegion;
import org.robovm.apple.foundation.NSObjectProtocol;
import org.robovm.objc.annotation.Method;

/** Interface that allows for callbacks from the MobileAppTracker region-based methods. Delegate methods are called on an arbitrary
 * thread. */
public interface MobileAppTrackerRegionDelegate extends NSObjectProtocol {
    /** Delegate method called when a geofenced region is entered.
     * @param region The region that was entered. */
    @Method(selector = "mobileAppTrackerDidEnterRegion:")
    void didEnterRegion (CLRegion region);

    /** Delegate method called when a geofenced region is exited.
     * @param region The region that was exited. */
    @Method(selector = "mobileAppTrackerDidExitRegion:")
    void didExitRegion (CLRegion region);
}
