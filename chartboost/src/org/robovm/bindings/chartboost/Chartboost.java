
package org.robovm.bindings.chartboost;

import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class Chartboost extends NSObject {
	@Property
	public native void setAppId (String appId);

	@Property
	public native String getAppId ();

	@Property
	public native void setAppSignature (String appSignature);

	@Property
	public native String getAppSignature ();

	/** @return the singleton. */
	@Method
	public static native Chartboost sharedChartboost ();

	/** Start the Chartboost session */
	@Method
	public native void startSession ();

	/** Show an interstitial */
	@Method
	public native void showInterstitial ();

	/** Show an interstitial, optionally takes a location and/or a view argument. */
	@Method(selector = "showInterstitial:")
	public native void showInterstitial (String location);

	/** Cache an interstitial */
	@Method
	public native void cacheInterstitial ();

	@Method(selector = "cacheInterstitial:")
	public native void cacheInterstitial (String location);

	/** Show the More Apps page. */
	@Method
	public native void showMoreApps ();

	@Property(strongRef = true)
	public native void setDelegate (ChartboostDelegate delegate);
}
