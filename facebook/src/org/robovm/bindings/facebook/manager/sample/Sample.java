
package org.robovm.bindings.facebook.manager.sample;

import org.robovm.apple.coregraphics.CGRect;
import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.foundation.NSError;
import org.robovm.apple.foundation.NSObject;
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
import org.robovm.bindings.facebook.manager.FBFeed;
import org.robovm.bindings.facebook.manager.FBPermission;
import org.robovm.bindings.facebook.manager.FacebookConfiguration;
import org.robovm.bindings.facebook.manager.FacebookManager;
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
		FBPermission[] fbPermissions = new FBPermission[] {FBPermission.BASIC_INFO, FBPermission.FRIENDS_LIKES, FBPermission.EMAIL,
			FBPermission.PUBLISH_ACTION};

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
		if (!facebook.isLogged())
			loginButton.setTitle("Login", UIControlState.Normal);
		else
			loginButton.setTitle("Logout", UIControlState.Normal);
		loginButton.addOnTouchUpInsideListener(new OnTouchUpInsideListener() {
			@Override
			public void onTouchUpInside (UIControl control, UIEvent event) {
				if (facebook.isLogged()) {
					facebook.logout(new FacebookManager.LogoutListener() {
						@Override
						public void onLogout () {
							// Successfully logged out.
							loadingOverlay.hide();
							loginButton.setTitle("Login", UIControlState.Normal);
						}

						@Override
						public void onRequest () {
							loadingOverlay.show(viewController);
						}

						@Override
						public void onException (NSError throwable) {
							loadingOverlay.hide();
						}

						@Override
						public void onFail (String reason) {
							loadingOverlay.hide();
						}
					});
				} else {
					facebook.login(new FacebookManager.LoginListener() {
						@Override
						public void onLogin () {
							// Successfully logged in.
							loadingOverlay.hide();
							loginButton.setTitle("Logout", UIControlState.Normal);
						}

						@Override
						public void onRequest () {
							loadingOverlay.show(viewController);
						}

						@Override
						public void onFail (String reason) {
							loadingOverlay.hide();
						}

						@Override
						public void onException (NSError throwable) {
							loadingOverlay.hide();
						}

						@Override
						public void onNotAcceptingPermissions () {
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
				FBFeed feed = new FBFeed.Builder().setLink("http://www.google.com").setMessage("Message").setName("Name")
					.setCaption("Caption").setDescription("Description").build();
				facebook.publishWithDialog(feed, new FacebookManager.PublishDialogListener() {
					@Override
					public void onComplete (String postId) {
						// Publish successfully.
						loadingOverlay.hide();
					}

					@Override
					public void onRequest () {
						loadingOverlay.show(viewController);
					}

					@Override
					public void onFail (String reason) {
						loadingOverlay.hide();
					}

					@Override
					public void onException (NSError throwable) {
						loadingOverlay.hide();
					}

					@Override
					public void onCancel () {
						loadingOverlay.hide();
					}
				});
			}
		});
		UIButton boton3 = new UIButton(new CGRect(10, 110, 200, 30));
		boton3.setBackgroundColor(new UIColor(1, 0, 0, 0.5f));
		boton3.setTitle("Load Achievements", UIControlState.Normal);
		boton3.addOnTouchUpInsideListener(new OnTouchUpInsideListener() {
			@Override
			public void onTouchUpInside (UIControl control, UIEvent event) {
			}
		});
		UIButton boton4 = new UIButton(new CGRect(10, 160, 200, 30));
		boton4.setBackgroundColor(new UIColor(1, 0, 0, 0.5f));
		boton4.setTitle("Reset Achievements", UIControlState.Normal);
		boton4.addOnTouchUpInsideListener(new OnTouchUpInsideListener() {
			@Override
			public void onTouchUpInside (UIControl control, UIEvent event) {
			}
		});
		UIButton boton5 = new UIButton(new CGRect(220, 10, 200, 30));
		boton5.setBackgroundColor(new UIColor(1, 0, 0, 0.5f));
		boton5.setTitle("Report Score", UIControlState.Normal);
		boton5.addOnTouchUpInsideListener(new OnTouchUpInsideListener() {
			@Override
			public void onTouchUpInside (UIControl control, UIEvent event) {
			}
		});
		UIButton boton6 = new UIButton(new CGRect(220, 60, 200, 30));
		boton6.setTitle("Load Leaderboards", UIControlState.Normal);
		boton6.addOnTouchUpInsideListener(new OnTouchUpInsideListener() {
			@Override
			public void onTouchUpInside (UIControl control, UIEvent event) {
			}
		});
		UIButton boton7 = new UIButton(new CGRect(220, 110, 200, 30));
		boton7.setTitle("Show Achievements", UIControlState.Normal);
		boton7.addOnTouchUpInsideListener(new OnTouchUpInsideListener() {
			@Override
			public void onTouchUpInside (UIControl control, UIEvent event) {
			}
		});
		UIButton boton8 = new UIButton(new CGRect(220, 160, 200, 30));
		boton8.setTitle("Show Leaderboards", UIControlState.Normal);
		boton8.addOnTouchUpInsideListener(new OnTouchUpInsideListener() {
			@Override
			public void onTouchUpInside (UIControl control, UIEvent event) {
			}
		});

		UIView view = new UIView(UIScreen.getMainScreen().getApplicationFrame());
		view.setBackgroundColor(UIColor.lightGrayColor());
		view.addSubview(loginButton);
		view.addSubview(publishButton);
		view.addSubview(boton3);
		view.addSubview(boton4);
		view.addSubview(boton5);
		view.addSubview(boton6);
		view.addSubview(boton7);
		view.addSubview(boton8);
		viewController.setView(view);

		window.setRootViewController(viewController);
		window.makeKeyAndVisible();
	}

	@Override
	public void didBecomeActive (UIApplication application) {
		facebook.handleDidBecomeActive();
	}

	@Override
	public boolean openURL (UIApplication application, NSURL url, String sourceApplication, NSObject annotation) {
		return facebook.handleOpenUrl(url, sourceApplication);
	}

	public static void main (String[] argv) {
		NSAutoreleasePool pool = new NSAutoreleasePool();
		UIApplication.main(argv, null, Sample.class);
		pool.drain();
	}
}
