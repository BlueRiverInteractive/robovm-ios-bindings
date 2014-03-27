
package org.robovm.bindings.facebook;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSError;
import org.robovm.apple.foundation.NSObject;

/** A block that is passed to {@link FBRequestConnection#addRequest(FBRequest, FBRequestHandler)} to register for a callback with
 * the results of that request once the connection completes.
 * 
 * Pass a block of this type when calling addRequest. This will be called once the request completes. The call occurs on the UI
 * thread.
 * @param connection The {@link FBRequestConnection} that sent the request.
 * @param result The result of the request. This is a translation of JSON data to {@link NSDictionary} and {@link NSArray}
 *           objects. This is {@code null} if there was an error.
 * @param error The {@link NSError} representing any error that occurred. */
public interface FBRequestHandler {
	void invoke (FBRequestConnection connection, NSObject result, NSError error);
}
