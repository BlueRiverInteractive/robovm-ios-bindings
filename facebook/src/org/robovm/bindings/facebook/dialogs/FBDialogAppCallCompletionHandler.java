
package org.robovm.bindings.facebook.dialogs;

import org.robovm.bindings.facebook.FBAppCall;
import org.robovm.cocoatouch.foundation.NSDictionary;
import org.robovm.cocoatouch.foundation.NSError;
import org.robovm.objc.ObjCBlock;
import org.robovm.objc.ObjCBlock.Wrapper;
import org.robovm.rt.bro.annotation.Callback;

/** A block that when passed to a method in FBDialogs is called back with the results of the AppCall for that dialog.
 * 
 * This will be called on the UI thread, once the AppCall completes.
 * @param call The {@link FBAppCall} that was completed.
 * @param results The results of the AppCall for the dialog. This parameters is present purely for convenience, and is the exact
 *           same value as call.dialogData.results.
 * @param error The {@link NSError} representing any error that occurred. This parameters is present purely for convenience, and
 *           is the exact same value as call.error. */
public interface FBDialogAppCallCompletionHandler {

	void invoke (FBAppCall call, NSDictionary<?, ?> results, NSError error);

	static class Callbacks {
		@Callback
		static void run (ObjCBlock block, FBAppCall call, NSDictionary<?, ?> results, NSError error) {
			((FBDialogAppCallCompletionHandler)block.object()).invoke(call, results, error);
		}
	}

	static class Marshaler {
		private static final Wrapper WRAPPER = new Wrapper(Callbacks.class);

		public static ObjCBlock toObjCBlock (FBDialogAppCallCompletionHandler o) {
			return WRAPPER.toObjCBlock(o);
		}
	}
}
