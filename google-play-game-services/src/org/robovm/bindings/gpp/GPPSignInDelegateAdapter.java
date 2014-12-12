package org.robovm.bindings.gpp;

import org.robovm.apple.foundation.NSError;
import org.robovm.apple.foundation.NSObject;
import org.robovm.bindings.gt.GTMOAuth2Authentication;
import org.robovm.objc.annotation.NotImplemented;

public class GPPSignInDelegateAdapter extends NSObject implements GPPSignInDelegate {

	@NotImplemented("finishedWithAuth:error:")
	public void finishedWithAuth(GTMOAuth2Authentication auth, NSError error) { throw new UnsupportedOperationException(); }

	@NotImplemented("didDisconnectWithError:")
	public void didDisconnectWithError(NSError error) { throw new UnsupportedOperationException(); }

}
