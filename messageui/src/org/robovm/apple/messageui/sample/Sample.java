
package org.robovm.apple.messageui.sample;

import org.robovm.apple.coregraphics.CGRect;
import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.foundation.NSError;
import org.robovm.apple.foundation.NSString;
import org.robovm.apple.messageui.MFMailComposeResult;
import org.robovm.apple.messageui.MFMailComposeViewController;
import org.robovm.apple.messageui.MFMailComposeViewControllerDelegate;
import org.robovm.apple.uikit.UIApplication;
import org.robovm.apple.uikit.UIApplicationDelegateAdapter;
import org.robovm.apple.uikit.UIButton;
import org.robovm.apple.uikit.UIColor;
import org.robovm.apple.uikit.UIControl;
import org.robovm.apple.uikit.UIControl.OnTouchUpInsideListener;
import org.robovm.apple.uikit.UIControlState;
import org.robovm.apple.uikit.UIEvent;
import org.robovm.apple.uikit.UIScreen;
import org.robovm.apple.uikit.UIViewController;
import org.robovm.apple.uikit.UIWindow;

/** Sample usage of the MessageUI framework */
public class Sample extends UIApplicationDelegateAdapter {
	UIWindow window;

	@Override
	public void didFinishLaunching (UIApplication application) {
		window = new UIWindow(UIScreen.getMainScreen().getBounds());
		window.makeKeyAndVisible();

		UIViewController viewController = new UIViewController();

		UIButton boton = new UIButton(new CGRect(10, 10, 200, 30));
		boton.setBackgroundColor(new UIColor(1, 0, 0, 0.5f));
		boton.setTitle("Send Mail", UIControlState.Normal);
		boton.addOnTouchUpInsideListener(new OnTouchUpInsideListener() {
			@Override
			public void onTouchUpInside (UIControl control, UIEvent event) {
				sendMail();
			}
		});
		viewController.setView(boton);

		window.setRootViewController(viewController);
	}

	public static void main (String[] argv) {
		try (NSAutoreleasePool pool = new NSAutoreleasePool()) {
			UIApplication.main(argv, null, Sample.class);
		}
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	private void sendMail () {
		MFMailComposeViewController picker = new MFMailComposeViewController();
		picker.setMailComposeDelegate(new MFMailComposeViewControllerDelegate.Adapter() {
			@Override
			public void mailComposeControllerDidFinish (MFMailComposeViewController controller, MFMailComposeResult result,
				NSError error) {
				controller.dismissViewController(true, null);
			}
		});
		NSArray usersTo = new NSArray(new NSString("test@test.com"));
		picker.setToRecipients(usersTo);
		picker.setSubject("Test Mail");
		window.getRootViewController().presentViewController(picker, true, null);
	}
}
