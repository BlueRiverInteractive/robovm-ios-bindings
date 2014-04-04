
package org.robovm.bindings.vungle;

import org.robovm.apple.foundation.NSObjectProtocol;
import org.robovm.apple.uikit.UIViewController;
import org.robovm.objc.annotation.Method;

public interface VGVunglePubDelegate extends NSObjectProtocol {
	@Method(selector = "vungleMoviePlayed:")
	void moviePlayed (VGPlayData playData);

	@Method(selector = "vungleStatusUpdate:")
	void statusUpdate (VGStatusData statusData);

	@Method(selector = "vungleViewDidDisappear:")
	void viewDidDisappear (UIViewController viewController);

	@Method(selector = "vungleViewWillAppear:")
	void viewWillAppear (UIViewController viewController);

	@Method(selector = "vungleAppStoreViewDidDisappear")
	void appStoreViewDidDisappear ();
}
