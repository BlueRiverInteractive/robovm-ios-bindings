package org.robovm.bindings.everyplay;

import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.uikit.UIView;
import org.robovm.apple.uikit.UIViewController;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class Everyplay extends NSObject {

	private Everyplay() {
	}

	// @property (nonatomic, unsafe_unretained) EveryplayCapture *capture;
	@Property(selector = "capture")
	public native EveryplayCapture getCapture();

	@Property(selector = "everyplayDelegate")
	public native EveryplayDelegate getEveryplayDelegate();

	@Property(selector = "setEveryplayDelegate:", strongRef = true)
	public native void setEveryplayDelegate(EveryplayDelegate everyplayDelegate);

	// + (Everyplay *)sharedInstance;
	@Method(selector = "sharedInstance")
	public static native Everyplay sharedInstance();

	// + (BOOL)isSupported;
	@Method(selector = "isSupported")
	public static native boolean isSupported();

	// + (Everyplay *)initWithDelegate:(id
	// <EveryplayDelegate>)everyplayDelegate;
	@Method(selector = "initWithDelegate:")
	public static native Everyplay init(EveryplayDelegate everyplayDelegate);

	// + (Everyplay *)initWithDelegate:(id <EveryplayDelegate>)everyplayDelegate
	// andParentViewController:(UIViewController *)viewController;
	@Method(selector = "initWithDelegate:andParentViewController:")
	public static native Everyplay init(EveryplayDelegate everyplayDelegate,
			UIViewController viewController);

	// + (Everyplay *)initWithDelegate:(id <EveryplayDelegate>)everyplayDelegate
	// andAddRootViewControllerForView:(UIView *)view;
	@Method(selector = "initWithDelegate:andAddRootViewControllerForView:")
	public static native Everyplay init(EveryplayDelegate everyplayDelegate,
			UIView view);

	// - (void)showEveryplay;
	@Method(selector = "showEveryplay")
	public native void showEveryplay();

	// - (void)showEveryplayWithPath:(NSString *)path;

	// - (void)showEveryplaySharingModal;
	@Method(selector = "showEveryplaySharingModal")
	public native void showEveryplaySharingModal();

	// - (void)hideEveryplay;
	@Method(selector = "hideEveryplay")
	public native void hideEveryplay();

	// - (void)playLastRecording;
	@Method(selector = "playLastRecording")
	public native void playLastRecording();

	// - (void)mergeSessionDeveloperData:(NSDictionary *)dictionary;
	@Method(selector = "mergeSessionDeveloperData:")
	public native void mergeSessionDeveloperData(NSDictionary dictionary);

	// #pragma mark - Configuration
	// + (void)setClientId:(NSString *)client
	// clientSecret:(NSString *)secret
	// redirectURI:(NSString *)url;
	@Method(selector = "setClientId:clientSecret:redirectURI:")
	public static native void setClientId(String clientId, String clientSecret,
			String url);
}
