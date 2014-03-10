
package org.robovm.bindings.facebook;

import org.robovm.objc.ObjCBlock;
import org.robovm.objc.ObjCBlock.Wrapper;
import org.robovm.rt.bro.annotation.Callback;

/*!
 @typedef FBAppCallHandler

 @abstract
 A block that is passed to performAppCall to register for a callback with the results
 of that AppCall

 @discussion
 Pass a block of this type when calling performAppCall.  This will be called on the UI
 thread, once the AppCall completes.

 @param call      The `FBAppCall` that was completed.

 */
public interface FBAppCallHandler {
	void invoke (FBAppCall call);

	static class Callbacks {
		@Callback
		static void run (ObjCBlock block, FBAppCall call) {
			((FBAppCallHandler)block.object()).invoke(call);
		}
	}

	static class Marshaler {
		private static final Wrapper WRAPPER = new Wrapper(Callbacks.class);

		public static ObjCBlock toObjCBlock (FBAppCallHandler o) {
			return WRAPPER.toObjCBlock(o);
		}
	}
}
