
package org.robovm.bindings.facebook;

import org.robovm.cocoatouch.foundation.NSDictionary;
import org.robovm.cocoatouch.foundation.NSError;
import org.robovm.objc.ObjCBlock;
import org.robovm.objc.ObjCBlock.Wrapper;
import org.robovm.rt.bro.annotation.Callback;
import org.robovm.rt.bro.annotation.Marshaler;
import org.robovm.rt.bro.annotation.Pointer;

/*!
 @typedef FBDialogAppCallCompletionHandler

 @abstract
 A block that when passed to a method in FBDialogs is called back
 with the results of the AppCall for that dialog.

 @discussion
 This will be called on the UI thread, once the AppCall completes.

 @param call      The `FBAppCall` that was completed.

 @param results     The results of the AppCall for the dialog. This parameters is present
 purely for convenience, and is the exact same value as call.dialogData.results.

 @param error       The `NSError` representing any error that occurred. This parameters is
 present purely for convenience, and is the exact same value as call.error.

 */
@Marshaler(FBDialogAppCallCompletionHandler.Marshaler.class)
public interface FBDialogAppCallCompletionHandler {

	/** Runs this block. */
	void invoke (FBAppCall call, NSDictionary results, NSError error);

	static class Callbacks {
		@Callback
		static void run (ObjCBlock block, FBAppCall call, NSDictionary results, NSError error) {
			((FBDialogAppCallCompletionHandler)block.object()).invoke(call, results, error);
		}
	}

	static class Marshaler {
		private static final Wrapper WRAPPER = new Wrapper(Callbacks.class);

		public static @Pointer
		long toNative (Object o) {
			return WRAPPER.toNative(o);
		}

		public static void updateObject (Object o, long handle) {
		}
	}
}
