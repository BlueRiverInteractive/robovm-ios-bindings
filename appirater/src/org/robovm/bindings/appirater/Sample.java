package org.robovm.bindings.appirater;

import org.robovm.cocoatouch.coregraphics.CGRect;
import org.robovm.cocoatouch.foundation.NSAutoreleasePool;
import org.robovm.cocoatouch.foundation.NSDictionary;
import org.robovm.cocoatouch.uikit.UIApplication;
import org.robovm.cocoatouch.uikit.UIApplicationDelegate;
import org.robovm.cocoatouch.uikit.UIButton;
import org.robovm.cocoatouch.uikit.UIColor;
import org.robovm.cocoatouch.uikit.UIControl;
import org.robovm.cocoatouch.uikit.UIControlState;
import org.robovm.cocoatouch.uikit.UIEvent;
import org.robovm.cocoatouch.uikit.UIScreen;
import org.robovm.cocoatouch.uikit.UIViewController;
import org.robovm.cocoatouch.uikit.UIWindow;
import org.robovm.cocoatouch.uikit.UIControl.OnTouchUpInsideListener;

/** Sample usage of the appirater SDK. http://github.com/arashpayan/appirater */
public class Sample extends UIApplicationDelegate.Adapter{
	private UIWindow window;
	
	@Override
	public boolean didFinishLaunching (UIApplication application, NSDictionary launchOptions) {
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
		Appirater.setDelegate(new AppiraterDelegate.Adapter() {
			
			@Override
			public void appiraterWillPresentModalView(Appirater appirater,
					boolean animated) {
			}
			
			@Override
			public void appiraterDidOptToRemindLater(Appirater appirater) {
			}
			
			@Override
			public void appiraterDidOptToRate(Appirater appirater) {
				/*
				 * Attention!!!
				 * You can access ONLY to static variables from here, or you get NullPointerException
				*/
				System.out.println("Hurray!!!");
			}
			
			@Override
			public void appiraterDidDisplayAlert(Appirater appirater) {
			}
			
			@Override
			public void appiraterDidDismissModalView(Appirater appirater,
					boolean animated) {
			}
			
			@Override
			public void appiraterDidDeclineToRate(Appirater appirater) {
			}
		});
		
		return true;
	}
	
	public static void main (String[] argv) {
		NSAutoreleasePool pool = new NSAutoreleasePool();
		UIApplication.main(argv, null, Sample.class);
		pool.drain();
	}
	
	private void showRateDialog(){
		Appirater.showPrompt();
	}
}
