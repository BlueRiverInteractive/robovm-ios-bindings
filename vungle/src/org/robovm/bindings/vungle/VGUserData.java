
package org.robovm.bindings.vungle;

import org.robovm.cocoatouch.foundation.NSDictionary;
import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

/** User and preferences data. Supplied to VGVunglePub class at startup. */
@NativeClass
public class VGUserData extends NSObject {
	@Method(selector = "defaultUserData")
	public static native VGUserData defaultUserData ();

	@Property
	public native int getAge ();

	@Property
	public native void setAge (int age);

	@Property
	public native VGGender getGender ();

	@Property
	public native void setGender (VGGender gender);

	@Property
	public native VGAdOrientation getAdOrientation ();

	@Property
	public native void setAdOrientation (VGAdOrientation orientation);

	@Property
	public native boolean isLocationEnabled ();

	@Property
	public native void setLocationEnabled (boolean enabled);

	@Property
	public native NSDictionary<?, ?> getJSONData ();
}
