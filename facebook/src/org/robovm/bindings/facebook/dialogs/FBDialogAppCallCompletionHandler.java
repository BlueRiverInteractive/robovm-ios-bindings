
package org.robovm.bindings.facebook.dialogs;

import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSError;
import org.robovm.bindings.facebook.FBAppCall;

/** A block that when passed to a method in {@link FBDialogs} is called back with the results of the AppCall for that dialog.
 * 
 * This will be called on the UI thread, once the AppCall completes.
 * @param call The {@link FBAppCall} that was completed.
 * @param results The results of the AppCall for the dialog. This parameters is present purely for convenience, and is the exact
 *           same value as call.dialogData.results.
 * @param error The {@link NSError} representing any error that occurred. This parameters is present purely for convenience, and
 *           is the exact same value as call.error. */
public interface FBDialogAppCallCompletionHandler {
	void invoke (FBAppCall call, NSDictionary<?, ?> results, NSError error);
}
