
package org.robovm.cocoatouch.messageui.sample;

import org.robovm.cocoatouch.coregraphics.CGRect;
import org.robovm.cocoatouch.foundation.NSArray;
import org.robovm.cocoatouch.foundation.NSAutoreleasePool;
import org.robovm.cocoatouch.foundation.NSError;
import org.robovm.cocoatouch.foundation.NSString;
import org.robovm.cocoatouch.messageui.MFMailComposeResult;
import org.robovm.cocoatouch.messageui.MFMailComposeViewController;
import org.robovm.cocoatouch.messageui.MFMailComposeViewControllerDelegate;
import org.robovm.cocoatouch.uikit.UIApplication;
import org.robovm.cocoatouch.uikit.UIApplicationDelegate;
import org.robovm.cocoatouch.uikit.UIButton;
import org.robovm.cocoatouch.uikit.UIColor;
import org.robovm.cocoatouch.uikit.UIControl;
import org.robovm.cocoatouch.uikit.UIControl.OnTouchUpInsideListener;
import org.robovm.cocoatouch.uikit.UIControlState;
import org.robovm.cocoatouch.uikit.UIEvent;
import org.robovm.cocoatouch.uikit.UIScreen;
import org.robovm.cocoatouch.uikit.UIViewController;
import org.robovm.cocoatouch.uikit.UIWindow;

/** Sample usage of the MessageUI framework */
public class Sample extends UIApplicationDelegate.Adapter {
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
		NSAutoreleasePool pool = new NSAutoreleasePool();
		UIApplication.main(argv, null, Sample.class);
		pool.drain();
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
