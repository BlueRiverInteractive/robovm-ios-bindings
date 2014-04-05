
package org.robovm.bindings.vungle;

import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.uikit.UIViewController;

public class VGVunglePubDelegateAdapter extends NSObject implements VGVunglePubDelegate {
	@Override
	public void moviePlayed (VGPlayData playData) {
	}

	@Override
	public void statusUpdate (VGStatusData statusData) {
	}

	@Override
	public void viewDidDisappear (UIViewController viewController) {
	}

	@Override
	public void viewWillAppear (UIViewController viewController) {
	}

	@Override
	public void appStoreViewDidDisappear () {
	}
}
