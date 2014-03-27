
package org.robovm.bindings.facebook;


/** A block that is passed to performAppCall to register for a callback with the results of that AppCall.
 * 
 * Pass a block of this type when calling performAppCall. This will be called on the UI thread, once the AppCall completes.
 * @param call The {@link FBAppCall} that was completed. */
public interface FBAppCallHandler {
	void invoke (FBAppCall call);
}
