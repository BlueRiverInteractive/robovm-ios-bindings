
package org.robovm.bindings.appirater.sample;

import org.robovm.apple.coregraphics.CGRect;
import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSString;
import org.robovm.apple.uikit.UIApplication;
import org.robovm.apple.uikit.UIApplicationDelegateAdapter;
import org.robovm.apple.uikit.UIButton;
import org.robovm.apple.uikit.UIColor;
import org.robovm.apple.uikit.UIControl;
import org.robovm.apple.uikit.UIControl.OnTouchUpInsideListener;
import org.robovm.apple.uikit.UIControlState;
import org.robovm.apple.uikit.UIEvent;
import org.robovm.apple.uikit.UIScreen;
import org.robovm.apple.uikit.UIWindow;
import org.robovm.bindings.appirater.Appirater;
import org.robovm.bindings.appirater.AppiraterDelegateAdapter;

/** Sample usage of the Appirater SDK. http://github.com/arashpayan/appirater */
public class Sample extends UIApplicationDelegateAdapter {
	private UIWindow window;

	@Override
	public boolean didFinishLaunching (UIApplication application, NSDictionary<NSString, ?> launchOptions) {
		window = new UIWindow(UIScreen.getMainScreen().getBounds());
		window.makeKeyAndVisible();

		UIButton button = new UIButton(new CGRect(10, 50, 200, 30));
		button.setBackgroundColor(new UIColor(1, 0, 0, 0.5f));
		button.setTitle("Show Interstitial", UIControlState.Normal);
		button.addOnTouchUpInsideListener(new OnTouchUpInsideListener() {
			@Override
			public void onTouchUpInside (UIControl control, UIEvent event) {
				showRateDialog();
			}
		});

		window.addSubview(button);

		Appirater.setAppId("YOUR_APP_ID");
		Appirater.setDaysUntilPrompt(-1);
		Appirater.setUsesUntilPrompt(-1);
		Appirater.setDelegate(new AppiraterDelegateAdapter() {
			@Override
			public void didOptToRate (Appirater appirater) {
				System.out.println("Hurray!!!");
			}
		});

		return true;
	}

	private void showRateDialog () {
		Appirater.showPrompt();
	}

	public static void main (String[] argv) {
		try (NSAutoreleasePool pool = new NSAutoreleasePool()) {
			UIApplication.main(argv, null, Sample.class);
		}
	}
}
