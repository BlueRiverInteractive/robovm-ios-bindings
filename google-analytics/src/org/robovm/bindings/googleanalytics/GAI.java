
package org.robovm.bindings.googleanalytics;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

/** Google Analytics iOS top-level class. Provides facilities to create trackers and set behaviorial flags. */
@NativeClass()
public class GAI extends NSObject {

	/** For convenience, this class exposes a default tracker instance. This is initialized to {@code null} and will be set to the
	 * first tracker that is instantiated in {@link #getTracker(String)}. It may be overridden as desired.
	 * 
	 * The GAITrackedViewController class will, by default, use this tracker instance. */
	@Property()
	public native GAITrackerImpl getDefaultTracker ();

	@Property()
	public native void setDefaultTracker (GAITrackerImpl tracker);

	/** The GAIDefaultLogger to use. */
	@Property()
	public native GAIDefaultLogger getLogger ();

	@Property()
	public native void setLogger (GAIDefaultLogger logger);

	@Property()
	public native double getDispatchInterval ();

	/** If this value is positive, tracking information will be automatically dispatched every dispatchInterval seconds. Otherwise,
	 * tracking information must be sent manually by calling dispatch.
	 * 
	 * By default, this is set to {@code 120}, which indicates tracking information should be dispatched automatically every 120
	 * seconds. */
	@Property()
	public native void setDispatchInterval (double interval);

	@Property()
	public native boolean isOptOut ();

	/** When this is true, no tracking information will be gathered; tracking calls will effectively become no-ops. When set to
	 * true, all tracking information that has not yet been submitted. The value of this flag will be persisted automatically by
	 * the SDK. Developers can optionally use this flag to implement an opt-out setting in the app to allows users to opt out of
	 * Google Analytics tracking.
	 * 
	 * This is set to {@code false} the first time the Google Analytics SDK is used on a device, and is persisted thereafter. */

	@Property()
	public native void setOptOut (boolean optOut);

	/** When set to true, the SDK will record the currently registered uncaught exception handler, and then register an uncaught
	 * exception handler which tracks the exceptions that occurred using defaultTracker. If the default tracker is not {@code null},
	 * this function will track the exception on the tracker and attempt to dispatch any outstanding tracking information for 5
	 * seconds. It will then call the previously registered exception handler, if any. When set back to false, the previously
	 * registered uncaught exception handler will be restored. */
	@Property(selector = "trackUncaughtExceptions")
	public native boolean isTrackingUncaughtExceptions ();

	@Property()
	public native void setTrackUncaughtExceptions (boolean track);

	/** When this is {@code true}, no tracking information will be sent. Defaults to '{@code false}. */
	@Property()
	public native boolean isDryRun ();

	@Property()
	public native void setDryRun (boolean dryRun);

	/** Get the shared instance of the Google Analytics for iOS class. */
	@Method(selector = "sharedInstance")
	public native static GAI getSharedInstance ();

	/** Creates or retrieves a GAITracker implementation with the specified name and tracking ID. If the tracker for the specified
	 * name does not already exist, then it will be created and returned; otherwise, the existing tracker will be returned. If the
	 * existing tracker for the respective name has a different tracking ID, that tracking ID is not changed by this method. If
	 * defaultTracker is not set, it will be set to the tracker instance returned here.
	 * 
	 * @param name The name of this tracker. Must not be {@code null} or empty.
	 * 
	 * @param trackingID The tracking ID to use for this tracker. It should be of the form {@code UA-xxxxx-y}.
	 * 
	 * @return A GAITracker associated with the specified name. The tracker can be used to send tracking data to Google Analytics.
	 *         The first time this method is called with a particular name, the tracker for that name will be returned, and
	 *         subsequent calls with the same name will return the same instance. It is not necessary to retain the tracker because
	 *         the tracker will be retained internally by the library.
	 * 
	 *         If an error occurs or the name is not valid, this method will return {@code null}. */
	@Method(selector = "trackerWithName:trackingId:")
	public native GAITrackerImpl getTracker (String name, String trackingId);

	/** Creates or retrieves a GAITracker implementation with name equal to the specified tracking ID. If the tracker for the
	 * respective name does not already exist, it is created, has it's tracking ID set to |trackingId|, and is returned; otherwise,
	 * the existing tracker is returned. If the existing tracker for the respective name has a different tracking ID, that tracking
	 * ID is not changed by this method. If defaultTracker is not set, it is set to the tracker instance returned here.
	 * 
	 * @param trackingID The tracking ID to use for this tracker. It should be of the form {@code UA-xxxxx-y}. The name of the
	 *           tracker will be the same as trackingID.
	 * 
	 * @return A GAITracker associated with the specified trackingID. The tracker can be used to send tracking data to Google
	 *         Analytics. The first time this method is called with a particular trackingID, the tracker for the respective name
	 *         will be returned, and subsequent calls with the same trackingID will return the same instance. It is not necessary
	 *         to retain the tracker because the tracker will be retained internally by the library.
	 * 
	 *         If an error occurs or the trackingId is not valid, this method will return {@code null}. */
	@Method(selector = "trackerWithTrackingId:")
	public native GAITrackerImpl getTracker (String trackingId);

	/** Remove a tracker from the trackers dictionary. If it is the default tracker, clears the default tracker as well.
	 * 
	 * @param name The name of the tracker. */
	@Method(selector = "removeTrackerByName:")
	public native void removeTracker (String name);

	/** Dispatches any pending tracking information.
	 * 
	 * It would be wise to call this when application is exiting to initiate the submission of any unsubmitted tracking
	 * information. Note that this does not have any effect on dispatchInterval, and can be used in conjuntion with periodic
	 * dispatch. */
	@Method(selector = "dispatch")
	public native void dispatch ();
}
