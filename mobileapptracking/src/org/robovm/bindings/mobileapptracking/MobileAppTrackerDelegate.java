
package org.robovm.bindings.mobileapptracking;

import org.robovm.apple.foundation.NSData;
import org.robovm.apple.foundation.NSError;
import org.robovm.apple.foundation.NSObjectProtocol;
import org.robovm.objc.annotation.Method;

/** Interface that allows for callbacks from the MobileAppTracker methods. To use, set your class as the delegate for MAT and
 * implement these methods. Delegate methods are called on an arbitrary thread. */
public interface MobileAppTrackerDelegate extends NSObjectProtocol {

    /** Delegate method called when an action is enqueued.
     * @param referenceId The reference ID of the enqueue action. */
    @Method(selector = "mobileAppTrackerEnqueuedActionWithReferenceId:")
    void enqueuedAction (String referenceId);

    /** Delegate method called when an action succeeds.
     * @param data The success data returned by the MobileAppTracker. */
    @Method(selector = "mobileAppTrackerDidSucceedWithData:")
    void didSucceed (NSData data);

    /** Delegate method called when an action fails.
     * @param error Error object returned by the MobileAppTracker. */
    @Method(selector = "mobileAppTrackerDidFailWithError:")
    void didFail (NSError error);

    /** Delegate method called when an iAd is displayed and its parent view is faded in. */
    @Method(selector = "mobileAppTrackerDidDisplayiAd")
    void didDisplayiAd ();

    /** Delegate method called when an iAd failed to display and its parent view is faded out. */
    @Method(selector = "mobileAppTrackerDidRemoveiAd")
    void didRemoveiAd ();

    /** Delegate method called to pass through an iAd display error.
     * @param error Error object returned by the iAd framework. */
    @Method(selector = "mobileAppTrackerFailedToReceiveiAdWithError:")
    void failedToReceiveiAd (NSError error);
}
