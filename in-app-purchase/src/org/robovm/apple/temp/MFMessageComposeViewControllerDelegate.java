
package org.robovm.apple.temp;

import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.foundation.NSObjectProtocol;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.BindSelector;
import org.robovm.objc.annotation.NotImplemented;
import org.robovm.rt.bro.annotation.Callback;

public interface MFMessageComposeViewControllerDelegate extends NSObjectProtocol {
	// - (void)messageComposeViewController:(MFMessageComposeViewController *)controller
// didFinishWithResult:(MessageComposeResult)result;
	void finished (MFMessageComposeViewController controller, MFMessageComposeResult result);

	public static class Adapter extends NSObject implements MFMessageComposeViewControllerDelegate {
		@Override
		@NotImplemented("messageComposeViewController:didFinishWithResult:")
		public void finished (MFMessageComposeViewController controller, MFMessageComposeResult result) {
			throw new UnsupportedOperationException();
		}
	}

	static class Callbacks {
		@Callback
		@BindSelector("messageComposeViewController:didFinishWithResult:")
		public static void onFinish (MFMessageComposeViewControllerDelegate __self__, Selector __cmd__,
			MFMessageComposeViewController controller, MFMessageComposeResult result) {
			__self__.finished(controller, result);
		}
	}
}
