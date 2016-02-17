
package org.robovm.bindings.unityads.sample;

import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.uikit.UIApplication;
import org.robovm.apple.uikit.UIApplicationDelegateAdapter;
import org.robovm.apple.uikit.UIScreen;
import org.robovm.apple.uikit.UIViewController;
import org.robovm.apple.uikit.UIWindow;
import org.robovm.bindings.unityads.UnityAds;
import org.robovm.bindings.unityads.UnityAdsDelegateAdapter;

/** Sample usage of the UnityAds SDK. */
public class Sample extends UIApplicationDelegateAdapter {
	private static final String UNITY_ADS_GAME_ID = "YOUR GAME ID GOES HERE";
	private UIViewController viewController;
	private UIWindow window;

	@Override
	public void didFinishLaunching (UIApplication application) {
		viewController = new UIViewController();
		
		// Startup UnityAds
		UnityAds.sharedInstance().startWithGameId(UNITY_ADS_GAME_ID, viewController);
		UnityAds.sharedInstance().setDebugMode(true);
		UnityAds.sharedInstance().setTestMode(true);
		UnityAds.sharedInstance().setDelegate(new UnityAdsDelegateAdapter() {

			@Override
			public void unityAdsVideoCompleted(String rewardItemKey, boolean skipped) {
				
			}
			
			@Override
			public void unityAdsWillShow() {
				
			}
			
			@Override
			public void unityAdsWillLeaveApplication() {
				
			}
			
			@Override
			public void unityAdsWillHide() {
				
			}
			
			@Override
			public void unityAdsVideoStarted() {
				
			}
			
			@Override
			public void unityAdsFetchFailed() {
				
			}
			
			@Override
			public void unityAdsFetchCompleted() {
				
			}
			
			@Override
			public void unityAdsDidShow() {
				
			}
			
			@Override
			public void unityAdsDidHide() {
				
			}
		});

		window = new UIWindow(UIScreen.getMainScreen().getBounds());
		window.setRootViewController(viewController);
		window.makeKeyAndVisible();
		
		// Show Unity Ad
		UnityAds.sharedInstance().setZone("rewardedVideoZone"); // optional, otherwise it takes the default zone set in unityads game panel
		if (UnityAds.sharedInstance().canShow()) {
			UnityAds.sharedInstance().show();
		}
	}

	public static void main (String[] argv) {
		try (NSAutoreleasePool pool = new NSAutoreleasePool()) {
			UIApplication.main(argv, null, Sample.class);
		}
	}
}
