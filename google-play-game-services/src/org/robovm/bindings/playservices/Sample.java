
package org.robovm.bindings.playservices;

import org.robovm.bindings.gpgs.GPGToastPlacement;
import org.robovm.bindings.gpp.GPPURLHandler;
import org.robovm.bindings.playservices.PlayServicesManager.LoginCallback;
import org.robovm.cocoatouch.foundation.NSAutoreleasePool;
import org.robovm.cocoatouch.foundation.NSError;
import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSURL;
import org.robovm.cocoatouch.uikit.UIApplication;
import org.robovm.cocoatouch.uikit.UIApplicationDelegate;
import org.robovm.cocoatouch.uikit.UIScreen;
import org.robovm.cocoatouch.uikit.UIView;
import org.robovm.cocoatouch.uikit.UIViewController;
import org.robovm.cocoatouch.uikit.UIWindow;

public class Sample extends UIApplicationDelegate.Adapter {

	private PlayServicesManager gpgManager;
	private UIWindow window;
	private UIViewController viewController;
	private UIView view;

	private LoginCallback loginCallback = new LoginCallback() {
		@Override
		public void success () {
			// load savegame from the cloud, load achievement list etc...
		}

		@Override
		public void error (NSError error) {

		}
	};

	@Override
	public void didFinishLaunching (UIApplication application) {

		// create a simple window, view controller and view
		// in a libGDX game you do this differently
		gpgManager = new PlayServicesManager();
		window = new UIWindow(UIScreen.getMainScreen().getBounds());
		window.makeKeyAndVisible();
		viewController = new UIViewController();
		view = new UIView(UIScreen.getMainScreen().getBounds());
		viewController.setView(view);
		window.setRootViewController(viewController);

		// pass all your identifiers to the manager
		gpgManager.setClientId("349069207524-m9oi4dh8okmdfqppfk975u6ub56l3a3m.apps.googleusercontent.com");

		// (optional) tell the manager where you want to see your toasts
		gpgManager.setToastLocation(PlayServicesManager.TOAST_BOTH, GPGToastPlacement.GPGToastPlacementTop);

		// (optional) tell the manager what user data you would like to retrieve while signing in.
		gpgManager.setUserDataToRetrieve(true, false);

		// tell the manager what your root view controller is.
		gpgManager.setViewController(viewController);

		// set the callback
		gpgManager.setLoginCallback(loginCallback);

		// call the manager's didFinishLaunching method.
		gpgManager.didFinishLaunching();

		/*
		 * Now you only have to do the following:
		 * 
		 * 1) place a login button in your app. The button must call gpgManager.login(); 2) check gpgManager.isLoggedIn() to check
		 * whether the user is logged in. 3) if the user is logged in, there must be a logout button. You could replace the login
		 * button with a logout button. This button must call gpgManager.logout(); 4) once you are logged in, you can show buttons
		 * to display leaderboards or achievements. simply check the manager's methods and you will easily find the functions you
		 * need to call in order to user leaderboards and achievements. 5) if you want to save and load data online, use
		 * gpgManager.cloudSave() and gpgManager.cloudLoad().
		 */
	}

	// IMPORTANT: add this code to your UIApplicationDelegate! Without this, google will not be able to redirect to your app after
// login.
	@Override
	public boolean openURL (UIApplication application, NSURL url, String sourceApplication, NSObject annotation) {
		return GPPURLHandler.handleURL(url, sourceApplication, annotation);
	}

	public static void main (String[] argv) {
		NSAutoreleasePool pool = new NSAutoreleasePool();
		UIApplication.main(argv, null, Sample.class);
		pool.drain();
	}
}
