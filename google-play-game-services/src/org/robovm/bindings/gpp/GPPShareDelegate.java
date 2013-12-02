
package org.robovm.bindings.gpp;

import org.robovm.cocoatouch.foundation.NSError;
import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSObjectProtocol;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.BindSelector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Callback;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
@NativeClass()
public interface GPPShareDelegate extends NSObjectProtocol {

	public void finishedSharingWithError (NSError error);

	public void finishedSharing (boolean shared);

	/** Extend this adapter to listen for events triggered by a GPPShare. */
	public static class Adapter extends NSObject implements GPPShareDelegate {
		@Override
		public void finishedSharingWithError (NSError error) {

		}

		@Override
		public void finishedSharing (boolean shared) {

		}
	}

	static class Callbacks {
		@Callback
		@BindSelector("finishedSharingWithError:")
		public static void objc_finishedSharingWithError (GPPShareDelegate __self__, Selector __cmd__, NSError error) {
			__self__.finishedSharingWithError(error);
		}

		@Callback
		@BindSelector("finishedSharing:")
		public static void objc_finishedSharing (GPPShareDelegate __self__, Selector __cmd__, boolean shared) {
			__self__.finishedSharing(shared);
		}
	}
}
