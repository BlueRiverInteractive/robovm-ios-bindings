package org.robovm.bindings.xplode.sample;

import org.robovm.apple.coregraphics.CGRect;
import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.foundation.NSError;
import org.robovm.apple.uikit.*;
import org.robovm.bindings.xplode.Xplode;

public class Sample extends UIApplicationDelegateAdapter {
    private static final String APP_HANDLE = "SampleApp";
    private static final String APP_SECRET = "3be79ba6b97f5025c91195249a235182";
    private UIWindow window;

    public static void main(String[] argv) {
        try (NSAutoreleasePool pool = new NSAutoreleasePool()) {
            UIApplication.main(argv, null, Sample.class);
        }
    }

    @Override
    public boolean didFinishLaunching(UIApplication application, UIApplicationLaunchOptions launchOptions) {
        window = new UIWindow(UIScreen.getMainScreen().getBounds());
        window.makeKeyAndVisible();

        Xplode.initialize(APP_HANDLE, APP_SECRET, new Xplode.InitializeHandler() {
            @Override
            public void invoke(NSError error) {
                if (error == null) {
                    System.out.println("[Xplode] (PROMOTIONS): initialized!");
                } else {
                    System.out.println("[Xplode] (PROMOTIONS): initialization error : " + error.getLocalizedDescription());
                }
                initView();
            }
        });
        return true;
    }

    private void initView() {
        CGRect bounds = UIScreen.getMainScreen().getBounds();
        int btnMargin = 60;
        int btnInterstitialWidth = 300;
        int btnInterstitialHeight = 50;
        UIButton btnInterstitial = new UIButton(new CGRect((bounds.getWidth() - btnInterstitialWidth) * .5, (bounds.getHeight() - btnInterstitialHeight) * .5 - btnMargin, btnInterstitialWidth, btnInterstitialHeight));
        btnInterstitial.setBackgroundColor(new UIColor(1, 0, 0, 0.5f));
        btnInterstitial.setTitle("Show breakpoint \"interstitial\"", UIControlState.Normal);
        btnInterstitial.addOnTouchUpInsideListener(new UIControl.OnTouchUpInsideListener() {
            @Override
            public void onTouchUpInside(UIControl control, UIEvent event) {
                showPromotion("interstitial");
            }
        });
        int btnGridWidth = 300;
        int btnGridHeight = 50;
        UIButton btnGrid = new UIButton(new CGRect((bounds.getWidth() - btnGridWidth) * .5, (bounds.getHeight() - btnGridHeight) * .5 + btnMargin, btnGridWidth, btnGridHeight));
        btnGrid.setBackgroundColor(new UIColor(1, 0, 0, 0.5f));
        btnGrid.setTitle("Show breakpoint \"grid\"", UIControlState.Normal);
        btnGrid.addOnTouchUpInsideListener(new UIControl.OnTouchUpInsideListener() {
            @Override
            public void onTouchUpInside(UIControl control, UIEvent event) {
                showPromotion("grid");
            }
        });

        window.addSubview(btnInterstitial);
        window.addSubview(btnGrid);
    }

    private void showPromotion(final String breakpoint) {
        Xplode.presentPromotionForBreakpoint(breakpoint, new Xplode.PromotionBreakpointCompletionHandler() {
            @Override
            public void invoke(boolean isReadyToPresent, NSError error) {
                if (isReadyToPresent) {
                    System.out.println("[XplodeBinding] (PROMOTIONS): Breakpoint " + breakpoint + " did load.");
                } else {
                    System.out.println("[XplodeBinding] (PROMOTIONS): Breakpoint " + breakpoint + " returned no promotion!");
                }
            }
        }, new Xplode.PromotionBreakpointDismissHandler() {
            @Override
            public void invoke() {
                System.out.println("[XplodeBinding] (PROMOTIONS): Breakpoint " + breakpoint + " closed.");
            }
        });
    }
}
