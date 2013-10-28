
package org.robovm.bindings.facebook.manager;

import org.robovm.bindings.facebook.FBSession;
import org.robovm.bindings.facebook.FBSessionState;
import org.robovm.bindings.facebook.FBSessionStateHandler;
import org.robovm.bindings.facebook.manager.FacebookManager.LoginListener;
import org.robovm.bindings.facebook.manager.FacebookManager.LogoutListener;
import org.robovm.bindings.facebook.manager.FacebookManager.ReopenSessionListener;
import org.robovm.cocoatouch.foundation.NSError;

/** This class is used to handle common Facebook events. */
public class FBSessionStatusCallback implements FBSessionStateHandler {
	private static final String TAG = "[FBSessionStatusCallback] ";
	private final FacebookManager manager;
	private boolean askPublishPermissions = false;
	boolean doOnLogin = false;
	LoginListener loginListener = null;
	LogoutListener logoutListener = null;
	ReopenSessionListener reopenSessionListener = null;

	public FBSessionStatusCallback (FacebookManager manager) {
		this.manager = manager;
	}

	@Override
	public void invoke (FBSession session, FBSessionState state, NSError error) {
		System.out.println(TAG + "Invoked...");
		if (error != null) {
			System.out.println(TAG + "Exception: " + error.description());

			if (error.toString().contains("Code=2")) {
				System.out.println(TAG + "User canceled login dialog.");
				if (session.getPermissions().size() == 0) {
					if (loginListener != null) loginListener.onNotAcceptingPermissions();
				}
			} else if (loginListener != null) {
				loginListener.onException(error);
			}
		}

		System.out.println(TAG + "FBSession: state=" + state.name() + ", session=" + session.toString());
		switch (state) {
		case Closed:
			logoutListener.onLogout();
			break;
		case ClosedLoginFailed:
			break;
		case Created:
			break;
		case CreatedTokenLoaded:
			break;
		case Opening:
			if (loginListener != null) loginListener.onRequest();
			break;
		case Open:
			if (reopenSessionListener != null) {
				reopenSessionListener.onNotAcceptingPermissions();
				reopenSessionListener = null;
			}
			// Check if WRITE permissions were also defined in the configuration. If so, then ask in another dialog for WRITE
// permissions.
			else if (askPublishPermissions && session.getState().equals(FBSessionState.Open)) {
				if (doOnLogin) {
					System.out.println(FacebookManager.TAG + "Successfully logged in!");
					doOnLogin = false;
					if (loginListener != null) loginListener.onLogin();
				} else {
					System.out.println(TAG + "Asking for publish permissions...");
					doOnLogin = true;
					manager.extendPublishPermissions();
					askPublishPermissions = false;
				}
			} else {
				System.out.println(FacebookManager.TAG + "Successfully logged in!");
				if (loginListener != null) loginListener.onLogin();
			}
			break;
		case OpenTokenExtended:
			if (reopenSessionListener != null) {
				reopenSessionListener.onSuccess();
				reopenSessionListener = null;
			} else if (doOnLogin) {
				System.out.println(FacebookManager.TAG + "Successfully logged in!");
				doOnLogin = false;
				if (loginListener != null) loginListener.onLogin();
			}
			break;
		default:
			break;
		}
	}
}
