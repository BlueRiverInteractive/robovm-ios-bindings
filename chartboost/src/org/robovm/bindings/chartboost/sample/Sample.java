package org.robovm.bindings.chartboost.sample;

import org.robovm.apple.coregraphics.CGRect;
import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.uikit.UIApplication;
import org.robovm.apple.uikit.UIApplicationDelegateAdapter;
import org.robovm.apple.uikit.UIApplicationLaunchOptions;
import org.robovm.apple.uikit.UIButton;
import org.robovm.apple.uikit.UIColor;
import org.robovm.apple.uikit.UIControl;
import org.robovm.apple.uikit.UIControl.OnTouchUpInsideListener;
import org.robovm.apple.uikit.UIControlState;
import org.robovm.apple.uikit.UIEvent;
import org.robovm.apple.uikit.UIScreen;
import org.robovm.apple.uikit.UIWindow;
import org.robovm.bindings.chartboost.Chartboost;
import org.robovm.bindings.chartboost.ChartboostDelegate;
import org.robovm.bindings.chartboost.ChartboostDelegateAdapter;

/** Sample usage of the Chartboost SDK. */
public class Sample extends UIApplicationDelegateAdapter {
    private UIWindow window;
    
    @Override
    public boolean didFinishLaunching(UIApplication application,
                                      UIApplicationLaunchOptions launchOptions) {
        window = new UIWindow(UIScreen.getMainScreen().getBounds());
        window.makeKeyAndVisible();
        
        UIButton button = new UIButton(new CGRect(10, 50, 200, 30));
        button.setBackgroundColor(new UIColor(1, 0, 0, 0.5f));
        button.setTitle("Show Interstitial", UIControlState.Normal);
        button.addOnTouchUpInsideListener(new OnTouchUpInsideListener() {
            @Override
            public void onTouchUpInside(UIControl control, UIEvent event) {
                showInterstitial();
            }
        });
        
        UIButton buttonMore = new UIButton(new CGRect(10, 100, 200, 30));
        buttonMore.setBackgroundColor(new UIColor(1, 0, 0, 0.5f));
        buttonMore.setTitle("Show More Apps", UIControlState.Normal);
        buttonMore.addOnTouchUpInsideListener(new OnTouchUpInsideListener() {
            @Override
            public void onTouchUpInside(UIControl control, UIEvent event) {
                showMoreApps();
            }
        });
        
        window.addSubview(button);
        window.addSubview(buttonMore);
        
        return true;
    }
    
    @Override
    public void didBecomeActive(UIApplication application) {
        ChartboostDelegate delegate = new ChartboostDelegateAdapter() {
            // Override methods as needed
        };
        Chartboost
        .start("YOUR_APP_ID", "YOUR_APP_SIGNATURE", delegate);
        
        Chartboost.cacheInterstitial("Test Screen");
    }
    
    public static void main(String[] argv) {
        try (NSAutoreleasePool pool = new NSAutoreleasePool()) {
            UIApplication.main(argv, null, Sample.class);
        }
    }
    
    private void showInterstitial() {
        Chartboost.showInterstitial("Test Screen");
    }
    
    private void showMoreApps() {
        Chartboost.showMoreApps("More Apps screen");
    }
}
