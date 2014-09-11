
package org.robovm.bindings.facebook.manager.sample;

import org.robovm.apple.coregraphics.CGRect;
import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.foundation.NSPropertyList;
import org.robovm.apple.foundation.NSURL;
import org.robovm.apple.uikit.UIApplication;
import org.robovm.apple.uikit.UIApplicationDelegateAdapter;
import org.robovm.apple.uikit.UIButton;
import org.robovm.apple.uikit.UIColor;
import org.robovm.apple.uikit.UIControl;
import org.robovm.apple.uikit.UIControl.OnTouchUpInsideListener;
import org.robovm.apple.uikit.UIControlState;
import org.robovm.apple.uikit.UIEvent;
import org.robovm.apple.uikit.UIScreen;
import org.robovm.apple.uikit.UIView;
import org.robovm.apple.uikit.UIViewController;
import org.robovm.apple.uikit.UIWindow;
import org.robovm.bindings.facebook.manager.CommonFacebookRequests;
import org.robovm.bindings.facebook.manager.FBPermission;
import org.robovm.bindings.facebook.manager.FacebookConfiguration;
import org.robovm.bindings.facebook.manager.FacebookLoginListener;
import org.robovm.bindings.facebook.manager.FacebookManager;
import org.robovm.bindings.facebook.manager.FacebookRequestListener;
import org.robovm.bindings.facebook.manager.GraphObject;
import org.robovm.bindings.facebook.session.FBSessionDefaultAudience;
import org.robovm.bindings.facebook.session.FBSessionLoginBehavior;

/** Sample usage of the Facebook Manager.
 * <p>
 * Add these tags to your info.plist:
 * </p>
 * 
 * <pre>
 * {@code
 * <key>FacebookAppID</key>
 * <string>YOUR_FB_APP_ID</string>
 * <key>FacebookDisplayName</key>
 * <string>YOUR_FB_APP_NAME</string>
 * <key>CFBundleURLTypes</key>
 * <array>
 * 	<dict>
 * 		<key>CFBundleURLSchemes</key>
 * 		<array>
 * 			<string>fbYOUR_FB_APP_ID</string>
 * 		</array>
 * 	</dict>
 * </array>
 * }
 * </pre> */
public class Sample extends UIApplicationDelegateAdapter {
    private static final String APP_ID = "YOUR_FB_APP_ID";
    private static final String APP_NAMESPACE = "namespace";

    private FacebookManager facebook;
    private LoadingOverlay loadingOverlay;

    @Override
    public void didFinishLaunching (UIApplication application) {
        facebook = FacebookManager.getInstance();

        // Setup an array of all used permissions.
        FBPermission[] fbPermissions = new FBPermission[] {FBPermission.PUBLIC_PROFILE, FBPermission.USER_FRIENDS,
            FBPermission.EMAIL, FBPermission.PUBLISH_ACTION};

        // Create a Facebook configuration.
        FacebookConfiguration fbConfiguration = new FacebookConfiguration.Builder().setAppId(APP_ID).setNamespace(APP_NAMESPACE)
            .setPermissions(fbPermissions).setDefaultAudience(FBSessionDefaultAudience.Everyone)
            .setLoginBehavior(FBSessionLoginBehavior.UseSystemAccountIfPresent).build();
        facebook.setConfiguration(fbConfiguration);

        // Create our sample UI.
        loadingOverlay = new LoadingOverlay(UIScreen.getMainScreen().getApplicationFrame(), "Loading...");

        UIWindow window = new UIWindow(UIScreen.getMainScreen().getApplicationFrame());

        final UIViewController viewController = new UIViewController();

        final UIButton loginButton = new UIButton(new CGRect(10, 10, 200, 30));
        loginButton.setBackgroundColor(new UIColor(1, 0, 0, 0.5f));
        if (!facebook.isLoggedIn())
            loginButton.setTitle("Login", UIControlState.Normal);
        else
            loginButton.setTitle("Logout", UIControlState.Normal);
        loginButton.addOnTouchUpInsideListener(new OnTouchUpInsideListener() {
            @Override
            public void onTouchUpInside (UIControl control, UIEvent event) {
                if (facebook.isLoggedIn()) {
                    facebook.logout();
                } else {
                    loadingOverlay.show(viewController);
                    facebook.login(new FacebookLoginListener() {
                        @Override
                        public void onSuccess (GraphObject user) {
                            System.out.println("Successfully logged in! " + user);
                            loginButton.setTitle("Logout", UIControlState.Normal);
                            loadingOverlay.hide();
                        }

                        @Override
                        public void onError (String error) {
                            System.out.println("An error happened: " + error);
                            loadingOverlay.hide();
                        }

                        @Override
                        public void onCancel () {
                            System.out.println("User cancelled login!");
                            loadingOverlay.hide();
                        }
                    });
                }
            }
        });

        UIButton publishButton = new UIButton(new CGRect(10, 60, 200, 30));
        publishButton.setBackgroundColor(new UIColor(1, 0, 0, 0.5f));
        publishButton.setTitle("Publish with dialog", UIControlState.Normal);
        publishButton.addOnTouchUpInsideListener(new OnTouchUpInsideListener() {
            @Override
            public void onTouchUpInside (UIControl control, UIEvent event) {
                loadingOverlay.show(viewController);

                facebook.request(CommonFacebookRequests.publishFeed("Name", "Caption", "Message", "Description", null,
                    "http://www.google.com", true, new FacebookRequestListener() {
                        @Override
                        public void onSuccess (GraphObject result) {
                            System.out.println("Successfully published: " + result);
                            loadingOverlay.hide();
                        }

                        @Override
                        public void onError (String error) {
                            System.out.println("An error happened: " + error);
                            loadingOverlay.hide();
                        }

                        @Override
                        public void onCancel () {
                            System.out.println("User cancelled dialog!");
                            loadingOverlay.hide();
                        }
                    }));
            }
        });
// UIButton boton3 = new UIButton(new CGRect(10, 110, 200, 30));
// boton3.setBackgroundColor(new UIColor(1, 0, 0, 0.5f));
// boton3.setTitle("Load Achievements", UIControlState.Normal);
// boton3.addOnTouchUpInsideListener(new OnTouchUpInsideListener() {
// @Override
// public void onTouchUpInside (UIControl control, UIEvent event) {
// }
// });
// UIButton boton4 = new UIButton(new CGRect(10, 160, 200, 30));
// boton4.setBackgroundColor(new UIColor(1, 0, 0, 0.5f));
// boton4.setTitle("Reset Achievements", UIControlState.Normal);
// boton4.addOnTouchUpInsideListener(new OnTouchUpInsideListener() {
// @Override
// public void onTouchUpInside (UIControl control, UIEvent event) {
// }
// });
// UIButton boton5 = new UIButton(new CGRect(220, 10, 200, 30));
// boton5.setBackgroundColor(new UIColor(1, 0, 0, 0.5f));
// boton5.setTitle("Report Score", UIControlState.Normal);
// boton5.addOnTouchUpInsideListener(new OnTouchUpInsideListener() {
// @Override
// public void onTouchUpInside (UIControl control, UIEvent event) {
// }
// });
// UIButton boton6 = new UIButton(new CGRect(220, 60, 200, 30));
// boton6.setTitle("Load Leaderboards", UIControlState.Normal);
// boton6.addOnTouchUpInsideListener(new OnTouchUpInsideListener() {
// @Override
// public void onTouchUpInside (UIControl control, UIEvent event) {
// }
// });
// UIButton boton7 = new UIButton(new CGRect(220, 110, 200, 30));
// boton7.setTitle("Show Achievements", UIControlState.Normal);
// boton7.addOnTouchUpInsideListener(new OnTouchUpInsideListener() {
// @Override
// public void onTouchUpInside (UIControl control, UIEvent event) {
// }
// });
// UIButton boton8 = new UIButton(new CGRect(220, 160, 200, 30));
// boton8.setTitle("Show Leaderboards", UIControlState.Normal);
// boton8.addOnTouchUpInsideListener(new OnTouchUpInsideListener() {
// @Override
// public void onTouchUpInside (UIControl control, UIEvent event) {
// }
// });

        UIView view = new UIView(UIScreen.getMainScreen().getApplicationFrame());
        view.setBackgroundColor(UIColor.lightGray());
        view.addSubview(loginButton);
        view.addSubview(publishButton);
// view.addSubview(boton3);
// view.addSubview(boton4);
// view.addSubview(boton5);
// view.addSubview(boton6);
// view.addSubview(boton7);
// view.addSubview(boton8);
        viewController.setView(view);

        window.setRootViewController(viewController);
        window.makeKeyAndVisible();
    }

    @Override
    public void didBecomeActive (UIApplication application) {
        facebook.didBecomeActive(application);
    }

    @Override
    public boolean openURL (UIApplication application, NSURL url, String sourceApplication, NSPropertyList annotation) {
        return facebook.openURL(application, url, sourceApplication, annotation);
    }

    @Override
    public void willTerminate (UIApplication application) {
        facebook.willTerminate(application);
    }

    public static void main (String[] argv) {
        try (NSAutoreleasePool pool = new NSAutoreleasePool()) {
            UIApplication.main(argv, null, Sample.class);
        }
    }
}
