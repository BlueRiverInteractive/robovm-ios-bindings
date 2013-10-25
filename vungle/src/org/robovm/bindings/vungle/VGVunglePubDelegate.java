
package org.robovm.bindings.vungle;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSObjectProtocol;
import org.robovm.cocoatouch.uikit.UIViewController;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.BindSelector;
import org.robovm.rt.bro.annotation.Callback;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
public interface VGVunglePubDelegate extends NSObjectProtocol {
	void moviePlayed (VGPlayData playData);

	void statusUpdate (VGStatusData statusData);

	void viewDidDisappear (UIViewController viewController);

	void viewWillAppear (UIViewController viewController);

	void appStoreViewDidDisappear ();

	/** Extend this adapter to listen for events triggered by a Vungle video. */
	public static class Adapter extends NSObject implements VGVunglePubDelegate {
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

	static class Callbacks {
		@Callback
		@BindSelector("vungleMoviePlayed:")
		public static void moviePlayed (VGVunglePubDelegate __self__, Selector __cmd__, VGPlayData playData) {
			__self__.moviePlayed(playData);
		}

		@Callback
		@BindSelector("vungleStatusUpdate:")
		public static void statusUpdate (VGVunglePubDelegate __self__, Selector __cmd__, VGStatusData statusData) {
			__self__.statusUpdate(statusData);
		}

		@Callback
		@BindSelector("vungleViewDidDisappear:")
		public static void viewDidDisappear (VGVunglePubDelegate __self__, Selector __cmd__, UIViewController viewController) {
			__self__.viewDidDisappear(viewController);
		}

		@Callback
		@BindSelector("vungleViewWillAppear:")
		public static void viewWillAppear (VGVunglePubDelegate __self__, Selector __cmd__, UIViewController viewController) {
			__self__.viewWillAppear(viewController);
		}

		@Callback
		@BindSelector("vungleAppStoreViewDidDisappear")
		public static void appStoreViewDidDisappear (VGVunglePubDelegate __self__, Selector __cmd__) {
			__self__.appStoreViewDidDisappear();
		}
	}
}
