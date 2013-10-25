
package org.robovm.bindings.vungle;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSString;
import org.robovm.cocoatouch.uikit.UIViewController;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCObject;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
@NativeClass()
public class VGVunglePub extends NSObject {
	private static final ObjCClass objCClass = ObjCClass.getByType(VGVunglePub.class);

	static {
		ObjCRuntime.bind(VGVunglePub.class);
	}

	private VGVunglePub () {
	}

	public static void start (String appID) {
		start(appID, VGUserData.defaultUserData());
	}

	public static void start (String appID, VGUserData userData) {
		objc_start(objCClass, start, new NSString(appID), userData);
	}

	private static final Selector start = Selector.register("startWithPubAppID:userData:");

	@Bridge
	private native static void objc_start (ObjCClass __self__, Selector __cmd__, NSString appID, VGUserData userData);

	public static void stop () {
		objc_stop(objCClass, stop);
	}

	private static final Selector stop = Selector.register("stop");

	@Bridge
	private native static void objc_stop (ObjCClass __self__, Selector __cmd__);

	public static String getOpenUDID () {
		return objc_getOpenUDID(objCClass, getOpenUDID).toString();
	}

	private static final Selector getOpenUDID = Selector.register("getOpenUDID");

	@Bridge
	private native static NSString objc_getOpenUDID (ObjCClass __self__, Selector __cmd__);

	public static VGStatusData getCurrentStatusData () {
		return objc_getCurrentStatusData(objCClass, getCurrentStatusData);
	}

	private static final Selector getCurrentStatusData = Selector.register("currentStatusData");

	@Bridge
	private native static VGStatusData objc_getCurrentStatusData (ObjCClass __self__, Selector __cmd__);

	/** Check if the library is running.
	 * 
	 * @return true if library is running */
	public static boolean isRunning () {
		return objc_isRunning(objCClass, isRunning);
	}

	private static final Selector isRunning = Selector.register("running");

	@Bridge
	private native static boolean objc_isRunning (ObjCClass __self__, Selector __cmd__);

	public static void printCacheFilesInfo () {
		objc_showCacheFiles(objCClass, showCacheFiles);
	}

	private static final Selector showCacheFiles = Selector.register("showCacheFiles");

	@Bridge
	private native static void objc_showCacheFiles (ObjCClass __self__, Selector __cmd__);

	public static void printDeviceSettings () {
		objc_showDeviceSettings(objCClass, showDeviceSettings);
	}

	private static final Selector showDeviceSettings = Selector.register("showDeviceSettings");

	@Bridge
	private native static void objc_showDeviceSettings (ObjCClass __self__, Selector __cmd__);

	public static String getVersion () {
		return objc_getVersion(objCClass, getVersion).toString();
	}

	private static final Selector getVersion = Selector.register("versionString");

	@Bridge
	private native static NSString objc_getVersion (ObjCClass __self__, Selector __cmd__);

	public static VGVunglePubDelegate getDelegate () {
		return objc_getDelegate(objCClass, getDelegate);
	}

	private static final Selector getDelegate = Selector.register("delegate");

	@Bridge
	private native static VGVunglePubDelegate objc_getDelegate (ObjCClass __self__, Selector __cmd__);

	public static void setDelegate (VGVunglePubDelegate delegate) {
		objCClass.addStrongRef((ObjCObject)delegate);
		objc_setDelegate(objCClass, setDelegate, delegate);
	}

	private static final Selector setDelegate = Selector.register("setDelegate:");

	@Bridge
	private native static void objc_setDelegate (ObjCClass __self__, Selector __cmd__, VGVunglePubDelegate delegate);

	/** @return true if an ad is available and this device is Internet-connected. */
	public static boolean isAdAvailable () {
		return objc_isAdAvailable(objCClass, isAdAvailable);
	}

	private static final Selector isAdAvailable = Selector.register("adIsAvailable");

	@Bridge
	private native static boolean objc_isAdAvailable (ObjCClass __self__, Selector __cmd__);

	public static void playModalAd (UIViewController controller, boolean animated, boolean showClose) {
		objc_playModalAd(objCClass, playModalAd, controller, animated, showClose);
	}

	private static final Selector playModalAd = Selector.register("playModalAd:animated:showClose:");

	@Bridge
	private native static void objc_playModalAd (ObjCClass __self__, Selector __cmd__, UIViewController controller,
		boolean animated, boolean showClose);

	public static void playIncentivizedAd (UIViewController controller, boolean animated, boolean showClose, String userTag) {
		objc_playIncentivizedAd(objCClass, playIncentivizedAd, controller, animated, showClose, new NSString(userTag));
	}

	private static final Selector playIncentivizedAd = Selector.register("playIncentivizedAd:animated:showClose:userTag:");

	@Bridge
	private native static void objc_playIncentivizedAd (ObjCClass __self__, Selector __cmd__, UIViewController controller,
		boolean animated, boolean showClose, NSString userTag);

	public static void setAlertBoxConfig (String title, String body, String leftButtonTitle, String rightButtonTitle) {
		objc_setAlertBoxConfig(objCClass, setAlertBoxConfig, new NSString(title), new NSString(body),
			new NSString(leftButtonTitle), new NSString(rightButtonTitle));
	}

	private static final Selector setAlertBoxConfig = Selector
		.register("alertBoxWithTitle:Body:leftButtonTitle:rightButtonTitle:");

	@Bridge
	private native static void objc_setAlertBoxConfig (ObjCClass __self__, Selector __cmd__, NSString title, NSString body,
		NSString leftButtonTitle, NSString rightButtonTitle);

	public boolean setCustomCountDownText (String text) {
		return objc_setCustomCountDownText(objCClass, setCustomCountDownText, new NSString(text));
	}

	private static final Selector setCustomCountDownText = Selector.register("setCustomCountDownText:");

	@Bridge
	private native static boolean objc_setCustomCountDownText (ObjCClass __self__, Selector __cmd__, NSString text);

	public static void setMuteIfMusicPlaying (boolean mute) {
		objc_setMuteIfMusicPlaying(objCClass, setMuteIfMusicPlaying, mute);
	}

	private static final Selector setMuteIfMusicPlaying = Selector.register("muteIfMusicPlaying:");

	@Bridge
	private native static void objc_setMuteIfMusicPlaying (ObjCClass __self__, Selector __cmd__, boolean mute);

	public static void setSoundEnabled (boolean enabled) {
		objc_setSoundEnabled(objCClass, setSoundEnabled, enabled);
	}

	private static final Selector setSoundEnabled = Selector.register("setSoundEnabled:");

	@Bridge
	private native static void objc_setSoundEnabled (ObjCClass __self__, Selector __cmd__, boolean enabled);

	public static int getCacheSize () {
		return objc_getCacheSize(objCClass, getCacheSize);
	}

	private static final Selector getCacheSize = Selector.register("cacheSizeGet");

	@Bridge
	private native static int objc_getCacheSize (ObjCClass __self__, Selector __cmd__);

	public static void setCacheSize (int megabytes) {
		objc_setCacheSize(objCClass, setCacheSize, megabytes);
	}

	private static final Selector setCacheSize = Selector.register("cacheSizeSet:");

	@Bridge
	private native static void objc_setCacheSize (ObjCClass __self__, Selector __cmd__, int megabytes);

	public static void setAutoRotateEnabled (boolean enabled) {
		objc_setAutoRotateEnabled(objCClass, setAutoRotateEnabled, enabled);
	}

	private static final Selector setAutoRotateEnabled = Selector.register("allowAutoRotate:");

	@Bridge
	private native static void objc_setAutoRotateEnabled (ObjCClass __self__, Selector __cmd__, boolean enabled);

	public static boolean isAdLoading () {
		return objc_isAdLoading(objCClass, isAdLoading);
	}

	private static final Selector isAdLoading = Selector.register("loadingOfAdViewControllerInProgress");

	@Bridge
	private native static boolean objc_isAdLoading (ObjCClass __self__, Selector __cmd__);

}
