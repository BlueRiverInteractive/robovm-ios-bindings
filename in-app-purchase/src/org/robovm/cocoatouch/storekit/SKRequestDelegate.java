
package org.robovm.cocoatouch.storekit;

import org.robovm.cocoatouch.foundation.NSError;
import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSObjectProtocol;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.BindSelector;
import org.robovm.objc.annotation.NotImplemented;
import org.robovm.rt.bro.annotation.Callback;

public interface SKRequestDelegate extends NSObjectProtocol {

	// - (void)accelerometer:(UIAccelerometer *)accelerometer didAccelerate:(UIAcceleration *)acceleration NS_DEPRECATED_IOS(2_0,
// 5_0);
	// void didAccelerate(UIAccelerometer accelerometer, UIAcceleration acceleration);

	// - (void)request:(SKRequest *)request didFailWithError:(NSError *)error __OSX_AVAILABLE_STARTING(__MAC_NA,__IPHONE_3_0);
	void requestFailed (SKRequest request, NSError error);

	// - (void)requestDidFinish:(SKRequest *)request __OSX_AVAILABLE_STARTING(__MAC_NA,__IPHONE_3_0);
	void requestFinished (SKRequest request);

	public static class Adapter extends NSObject implements SKRequestDelegate {
		// @NotImplemented("accelerometer:didAccelerate:") public void didAccelerate(UIAccelerometer accelerometer, UIAcceleration
// acceleration) {
		// throw new UnsupportedOperationException(); }
		@Override
		@NotImplemented("request:didFailWithError:")
		public void requestFailed (SKRequest request, NSError error) {
			throw new UnsupportedOperationException();
		}

		@Override
		@NotImplemented("requestDidFinish:")
		public void requestFinished (SKRequest request) {
			throw new UnsupportedOperationException();
		}
	}

	static class Callbacks {
		// @Callback @BindSelector("accelerometer:didAccelerate:") public static void didAccelerate(UIAccelerometerDelegate
// __self__, Selector
		// __cmd__, UIAccelerometer accelerometer, UIAcceleration acceleration) { __self__.didAccelerate(accelerometer,
// acceleration); }
		@Callback
		@BindSelector("request:didFailWithError:")
		public static void requestFailed (SKRequestDelegate __self__, Selector __cmd__, SKRequest request, NSError error) {
			__self__.requestFailed(request, error);
		}

		@Callback
		@BindSelector("requestDidFinish:")
		public static void requestFinished (SKRequestDelegate __self__, Selector __cmd__, SKRequest request) {
			__self__.requestFinished(request);
		}
	}
}
