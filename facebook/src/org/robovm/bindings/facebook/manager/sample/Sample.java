
package org.robovm.bindings.facebook.manager.sample;

import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.foundation.NSPropertyList;
import org.robovm.apple.foundation.NSURL;
import org.robovm.apple.uikit.UIApplication;
import org.robovm.apple.uikit.UIApplicationDelegateAdapter;
import org.robovm.apple.uikit.UIApplicationLaunchOptions;
import org.robovm.apple.uikit.UINavigationController;
import org.robovm.apple.uikit.UIScreen;
import org.robovm.apple.uikit.UIWindow;
import org.robovm.bindings.facebook.manager.FacebookError;
import org.robovm.bindings.facebook.manager.FacebookLoginListener;
import org.robovm.bindings.facebook.manager.FacebookManager;
import org.robovm.bindings.facebook.manager.FacebookPermission;
import org.robovm.bindings.facebook.manager.request.GraphUser;

/** Sample usage of the Facebook Manager.
 * <p>
 * Add these tags to your Info.plist:
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
    private UIWindow window;
    private UINavigationController navigationController;
    private SampleViewController sampleViewController;

    @Override
    public boolean didFinishLaunching (UIApplication application, UIApplicationLaunchOptions launchOptions) {
        sampleViewController = new SampleViewController();
        navigationController = new UINavigationController(sampleViewController);

        window = new UIWindow(UIScreen.getMainScreen().getApplicationFrame());
        window.setRootViewController(navigationController);
        window.makeKeyAndVisible();

        addStrongRef(window);

        FacebookPermission[] permissions = new FacebookPermission[] {FacebookPermission.PUBLIC_PROFILE,
            FacebookPermission.USER_FRIENDS, FacebookPermission.EMAIL};
        // Silently attempt to login the user. This will never show any UI.
        FacebookManager.getInstance().login(permissions, false, new FacebookLoginListener() {
            @Override
            public void onSuccess (GraphUser result) {
                // Login was successful!

                sampleViewController.setMe(result);

                // Update UI
                sampleViewController.getTableView().reloadData();
            }

            @Override
            public void onError (FacebookError error) {
                // We ignore any errors because this is a silent login.
            }

            @Override
            public void onCancel () {
            }
        });

        return true;
    }

    @Override
    public void didBecomeActive (UIApplication application) {
        // You need to add this line, otherwise Facebook will not work correctly!
        FacebookManager.getInstance().handleDidBecomeActive(application);
    }

    @Override
    public boolean openURL (UIApplication application, NSURL url, String sourceApplication, NSPropertyList annotation) {
        // You need to add this line, otherwise Facebook will not work correctly!
        return FacebookManager.getInstance().handleOpenURL(application, url, sourceApplication, annotation);
    }

    @Override
    public void willTerminate (UIApplication application) {
        // You need to add this line, otherwise Facebook will not work correctly!
        FacebookManager.getInstance().handleWillTerminate(application);
    }

    public static void main (String[] argv) {
        try (NSAutoreleasePool pool = new NSAutoreleasePool()) {
            UIApplication.main(argv, null, Sample.class);
        }
    }
}
