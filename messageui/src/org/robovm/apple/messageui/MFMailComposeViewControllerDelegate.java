
package org.robovm.apple.messageui;

import org.robovm.apple.foundation.NSError;
import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.foundation.NSObjectProtocol;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.BindSelector;
import org.robovm.rt.bro.annotation.Callback;

public interface MFMailComposeViewControllerDelegate extends NSObjectProtocol {

	// - (void)mailComposeController:(MFMailComposeViewController *)controller didFinishWithResult:(MFMailComposeResult)result
// error:(NSError *)error __OSX_AVAILABLE_STARTING(__MAC_NA,__IPHONE_3_0);
	/** @method mailComposeController:didFinishWithResult:error:
	 * @abstract Delegate callback which is called upon user's completion of email composition.
	 * @discussion This delegate callback will be called when the user completes the email composition. How the user chose to
	 *             complete this task will be given as one of the parameters to the callback. Upon this call, the client should
	 *             remove the view associated with the controller, typically by dismissing modally.
	 * @param controller The MFMailComposeViewController instance which is returning the result.
	 * @param result MFMailComposeResult indicating how the user chose to complete the composition process.
	 * @param error NSError indicating the failure reason if failure did occur. This will be <tt>nil</tt> if result did not
	 *           indicate failure. */
	void mailComposeControllerDidFinish (MFMailComposeViewController controller, MFMailComposeResult result, NSError error);

	public static class Adapter extends NSObject implements MFMailComposeViewControllerDelegate {
		@Override
		public void mailComposeControllerDidFinish (MFMailComposeViewController controller, MFMailComposeResult result,
			NSError error) {
		}
	}

	static class Callbacks {
		@Callback
		@BindSelector("mailComposeController:didFinishWithResult:error:")
		public static void mailComposeControllerDidFinish (MFMailComposeViewControllerDelegate __self__, Selector __cmd__,
			MFMailComposeViewController controller, MFMailComposeResult result, NSError error) {
			__self__.mailComposeControllerDidFinish(controller, result, error);
		}
	}

}
