
package org.robovm.bindings.facebook;

import org.robovm.cocoatouch.foundation.NSError;
import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.objc.ObjCBlock;
import org.robovm.objc.ObjCBlock.Wrapper;
import org.robovm.rt.bro.annotation.Callback;
import org.robovm.rt.bro.annotation.Marshaler;
import org.robovm.rt.bro.annotation.Pointer;

/*!
 @typedef FBRequestHandler

 @abstract
 A block that is passed to addRequest to register for a callback with the results of that
 request once the connection completes.

 @discussion
 Pass a block of this type when calling addRequest.  This will be called once
 the request completes.  The call occurs on the UI thread.

 @param connection      The `FBRequestConnection` that sent the request.

 @param result          The result of the request.  This is a translation of
 JSON data to `NSDictionary` and `NSArray` objects.  This
 is nil if there was an error.

 @param error           The `NSError` representing any error that occurred.
 */
@Marshaler(FBRequestHandler.Marshaler.class)
public interface FBRequestHandler {
	/** Runs this block. */
	void invoke (FBRequestConnection connection, NSObject result, NSError error);

	static class Callbacks {
		@Callback
		static void run (ObjCBlock block, FBRequestConnection connection, NSObject result, NSError error) {
			((FBRequestHandler)block.object()).invoke(connection, result, error);
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
