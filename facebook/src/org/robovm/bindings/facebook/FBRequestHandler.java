
package org.robovm.bindings.facebook;

import org.robovm.cocoatouch.foundation.NSArray;
import org.robovm.cocoatouch.foundation.NSDictionary;
import org.robovm.cocoatouch.foundation.NSError;
import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.objc.ObjCBlock;
import org.robovm.objc.ObjCBlock.Wrapper;
import org.robovm.rt.bro.annotation.Callback;

/** A block that is passed to addRequest to register for a callback with the results of that request once the connection completes.
 * 
 * Pass a block of this type when calling addRequest. This will be called once the request completes. The call occurs on the UI
 * thread.
 * @param connection The {@link FBRequestConnection} that sent the request.
 * @param result The result of the request. This is a translation of JSON data to {@link NSDictionary} and {@link NSArray}
 *           objects. This is {@code null} if there was an error.
 * @param error The {@link NSError} representing any error that occurred. */
public interface FBRequestHandler {
	void invoke (FBRequestConnection connection, NSObject result, NSError error);

	static class Callbacks {
		@Callback
		static void run (ObjCBlock block, FBRequestConnection connection, NSObject result, NSError error) {
			((FBRequestHandler)block.object()).invoke(connection, result, error);
		}
	}

	static class Marshaler {
		private static final Wrapper WRAPPER = new Wrapper(Callbacks.class);

		public static ObjCBlock toObjCBlock (FBRequestHandler o) {
			return WRAPPER.toObjCBlock(o);
		}
	}
}
