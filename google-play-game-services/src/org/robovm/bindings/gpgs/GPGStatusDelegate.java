package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSError;
import org.robovm.apple.foundation.NSObjectProtocol;
import org.robovm.objc.annotation.Method;

public interface GPGStatusDelegate extends NSObjectProtocol {

	@Method(selector = "didFinishGamesSignInWithError:")
	void didFinishGamesSignInWithError(NSError error);
	
	@Method(selector = "didFinishGamesSignOutWithError:")
	void didFinishGamesSignOutWithError(NSError error);
	
	@Method(selector = "didFinishGoogleAuthWithError:")
	void didFinishGoogleAuthWithError(NSError error);
	
	@Method(selector = "shouldReauthenticateWithError:")
	boolean shouldReauthenticateWithError(NSError error);

	@Method(selector = "willReauthenticate:")
	void willReauthenticate(NSError error);

	@Method(selector = "didDisconnectWithError:")
	void didDisconnectWithError(NSError error);
}
