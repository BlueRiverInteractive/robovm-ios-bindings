
package org.robovm.bindings.appirater;

import org.robovm.apple.foundation.NSObject;

public class AppiraterDelegateAdapter extends NSObject implements AppiraterDelegate {
	@Override
	public void didDisplayAlert (Appirater appirater) {
	}

	@Override
	public void didDeclineToRate (Appirater appirater) {
	}

	@Override
	public void didOptToRate (Appirater appirater) {
	}

	@Override
	public void didOptToRemindLater (Appirater appirater) {
	}

	@Override
	public void willPresentModalView (Appirater appirater, boolean animated) {
	}

	@Override
	public void didDismissModalView (Appirater appirater, boolean animated) {
	}
}
