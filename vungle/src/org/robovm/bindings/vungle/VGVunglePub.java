
package org.robovm.bindings.vungle;

import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.uikit.UIViewController;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;

@NativeClass
public class VGVunglePub extends NSObject {
	private VGVunglePub () {
	}

	public static void start (String appID) {
		start(appID, VGUserData.defaultUserData());
	}

	@Method(selector = "startWithPubAppID:userData:")
	public native static void start (String appID, VGUserData userData);

	@Method(selector = "stop")
	public native static void stop ();

	@Method(selector = "getOpenUDID")
	public native static String getOpenUDID ();

	@Method(selector = "currentStatusData")
	public native static VGStatusData getCurrentStatusData ();

	/** Check if the library is running.
	 * 
	 * @return true if library is running. */
	@Method(selector = "running")
	public native static boolean isRunning ();

	@Method(selector = "showCacheFiles")
	public native static void printCacheFilesInfo ();

	@Method(selector = "showDeviceSettings")
	public native static void printDeviceSettings ();

	@Method(selector = "versionString")
	public native static String getVersion ();

	@Method(selector = "delegate")
	public native static VGVunglePubDelegate getDelegate ();

	public static void setDelegate (VGVunglePubDelegate delegate) {
		ObjCClass clazz = ObjCClass.getByType(VGVunglePub.class);
		VGVunglePubDelegate before = getDelegate();
		if (before != null) {
			clazz.removeStrongRef(before);
		}
		if (delegate != null) {
			clazz.addStrongRef(delegate);
		}
		setDelegateImpl(delegate);
	}

	@Method(selector = "setDelegate:")
	private native static void setDelegateImpl (VGVunglePubDelegate delegate);

	/** @return true if an ad is available and this device is Internet-connected. */
	@Method(selector = "adIsAvailable")
	public native static boolean isAdAvailable ();

	@Method(selector = "playModalAd:animated:showClose:")
	public native static void playModalAd (UIViewController controller, boolean animated, boolean showClose);

	@Method(selector = "playIncentivizedAd:animated:showClose:userTag:")
	public native static void playIncentivizedAd (UIViewController controller, boolean animated, boolean showClose, String userTag);

	@Method(selector = "alertBoxWithTitle:Body:leftButtonTitle:rightButtonTitle:")
	public native static void setAlertBoxConfig (String title, String body, String leftButtonTitle, String rightButtonTitle);

	@Method(selector = "setCustomCountDownText:")
	public native boolean setCountDownText (String text);

	@Method(selector = "muteIfMusicPlaying:")
	public native static void setMuteIfMusicPlaying (boolean mute);

	@Method(selector = "setSoundEnabled:")
	public native static void setSoundEnabled (boolean enabled);

	@Method(selector = "cacheSizeGet")
	public native static int getCacheSize ();

	@Method(selector = "cacheSizeSet:")
	public native static void setCacheSize (int megabytes);

	@Method(selector = "allowAutoRotate:")
	public native static void setAutoRotateEnabled (boolean enabled);

	@Method(selector = "loadingOfAdViewControllerInProgress")
	public native static boolean isAdLoading ();
}
