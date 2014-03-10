
package org.robovm.bindings.gpp;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
@NativeClass()
public class GPPShare extends NSObject {
	private static final ObjCClass objCClass = ObjCClass.getByType(GPPShare.class);

	static {
		ObjCRuntime.bind(GPPShare.class);
	}

	// The object to be notified when the share action has finished.
	// @property(nonatomic, weak) NSObject<GPPShareDelegate> *delegate;
	private static final Selector delegate$ = Selector.register("delegate");

	@Bridge
	private native static GPPShareDelegate objc_getDelegate (GPPShare __self__, Selector __cmd__);

	public GPPShareDelegate getGPPShareDelegate () {
		return objc_getDelegate(this, delegate$);
	}

	private static final Selector setDelegate$ = Selector.register("setDelegate:");

	@Bridge
	private native static void objc_setDelegate (GPPShare __self__, Selector __cmd__, GPPShareDelegate delegate);

	public void setDelegate (GPPShareDelegate delegate) {
		objc_setDelegate(this, setDelegate$, delegate);
	}

	// STATIC METHODS \\

	// Returns a shared |GPPShare| instance.
	// |[GPPSignIn sharedInstance].clientID| must be initialized with a client ID
	// registered in the Google API console, https://code.google.com/apis/console/
	// with the app's bundle ID.
	// + (GPPShare *)sharedInstance;
	private static final Selector sharedInstance$ = Selector.register("sharedInstance");

	@Bridge
	private native static GPPShare objc_sharedInstance (ObjCClass __self__, Selector __cmd__);

	public static GPPShare sharedInstance () {
		return objc_sharedInstance(objCClass, sharedInstance$);
	}

	// METHODS \\

	// Returns a share dialog builder instance. Call its |open| method to
	// create the dialog after setting the parameters as needed.
	// - (id<GPPShareBuilder>)shareDialog;
	private static final Selector shareDialog$ = Selector.register("shareDialog");

	@Bridge
	private native static GPPShareBuilderImpl objc_shareDialog (GPPShare __self__, Selector __cmd__);

	public GPPShareBuilderImpl shareDialog () {
		return objc_shareDialog(this, shareDialog$);
	}

	// Returns a native share dialog builder instance. Call its |open| method to
	// create the dialog after setting the parameters as needed.
	// Before the native share dialog can be opened, the user must have consented to the OAuth2 scope
	// "https://www.googleapis.com/auth/plus.login".
	// - (id<GPPShareBuilder>)nativeShareDialog;
	private static final Selector nativeShareDialog$ = Selector.register("nativeShareDialog");

	@Bridge
	private native static GPPNativeShareBuilderImpl objc_getNativeShareDialog (GPPShare __self__, Selector __cmd__);

	public GPPNativeShareBuilderImpl getNativeShareDialog () {
		return objc_getNativeShareDialog(this, nativeShareDialog$);
	}

	// Closes the active native share dialog immediately, if one exists.
	// Note that it is usually not necessary to call this method, as the sharebox closes itself
	// once the share action has completed either successfully or with an error. Only call this method
	// when you need to permanently interrupt the user in the middle of sharing, because whatever the
	// user entered will be lost.
	// - (void)closeActiveNativeShareDialog;
	// TODO implement
// private static final Selector closeActiveNativeShareDialog$ = Selector.register("closeActiveNativeShareDialog");
// @Bridge private native static void objc_closeActiveNativeShareDialog(GPPShare __self__, Selector __cmd__);
// public void closeActiveNativeShareDialog() {
// objc_closeActiveNativeShareDialog(this, nativeShareDialog$);
// }

	// This method should be called from your |UIApplicationDelegate|'s
	// |application:openURL:sourceApplication:annotation|. Returns |YES| if
	// |GPPShare| handled this URL.
	// Also see |handleURL:sourceApplication:annotation:| in |GPPURLHandler|.
	// - (BOOL)handleURL:(NSURL *)url
	// sourceApplication:(NSString *)sourceApplication
	// annotation:(id)annotation;
	// TODO: implement
	/*
	 * private static final Selector handleURL$ = Selector.register("handleURL:");
	 * 
	 * @Bridge private native static boolean objc_trySilentAuthentication(GPPSignIn __self__, Selector __cmd__, NSURL
	 * sourceApplication, String sourceApplication); public boolean handleURL() { return objc_handleURL(this, handleURL$); }
	 */
}
