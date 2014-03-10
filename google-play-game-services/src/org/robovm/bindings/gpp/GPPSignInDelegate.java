
package org.robovm.bindings.gpp;

import org.robovm.bindings.gt.GTMOAuth2Authentication;
import org.robovm.cocoatouch.foundation.NSError;
import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSObjectProtocol;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.BindSelector;
import org.robovm.rt.bro.annotation.Callback;

public interface GPPSignInDelegate extends NSObjectProtocol {

	// The authorization has finished and is successful if |error| is |nil|.
	// - (void)finishedWithAuth:(GTMOAuth2Authentication *)auth error:(NSError *)error;
	void finishedWithAuth (GTMOAuth2Authentication auth, NSError error);

	public static class Adapter extends NSObject implements GPPSignInDelegate {
		@Override
		public void finishedWithAuth (GTMOAuth2Authentication auth, NSError error) {
		}
	}

	static class Callbacks {
		@Callback
		@BindSelector("finishedWithAuth:error:")
		public static void finishedWithAuth (GPPSignInDelegate __self__, Selector __cmd__, GTMOAuth2Authentication auth,
			NSError error) {
			__self__.finishedWithAuth(auth, error);
		}
	}
}
