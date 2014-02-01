package org.robovm.bindings.chartboost;

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

/** Sample usage of the Chartboost SDK. */
public class Sample extends UIApplicationDelegate.Adapter{
	private UIWindow window;
	private Chartboost chartboost;
	
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
				showInterstitial();
			}
		});
		
		UIButton buttonMore = new UIButton(new CGRect(10, 100, 200, 30));
		buttonMore.setBackgroundColor(new UIColor(1, 0, 0, 0.5f));
		buttonMore.setTitle("Show More Apps", UIControlState.Normal);
		buttonMore.addOnTouchUpInsideListener(new OnTouchUpInsideListener() {
			@Override
			public void onTouchUpInside (UIControl control, UIEvent event) {
				showMoreApps();
			}
		});

		window.addSubview(button);
		window.addSubview(buttonMore);
		
		return true;
	}
	
	@Override
	public void didBecomeActive(UIApplication application){
		
		chartboost = Chartboost.sharedChartboost();
		chartboost.setAppId("YOUR_APP_ID");
		chartboost.setAppSignature("YOUR_APP_SIGNATURE");
		chartboost.startSession();

		chartboost.cacheInterstitial("Test Screen");
	}

	public static void main (String[] argv) {
		NSAutoreleasePool pool = new NSAutoreleasePool();
		UIApplication.main(argv, null, Sample.class);
		pool.drain();
	}
	
	private void showInterstitial(){
		if(chartboost != null){
			chartboost.showInterstitial("Test Screen");
		}
	}
	
	private void showMoreApps(){
		if(chartboost != null){
			chartboost.showMoreApps();
		}
	}
}
