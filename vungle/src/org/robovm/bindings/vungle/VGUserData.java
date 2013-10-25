
package org.robovm.bindings.vungle;

import org.robovm.cocoatouch.foundation.NSDictionary;
import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

/** User and preferences data. Supplied to VGVunglePub class at startup. */
@Library(Library.INTERNAL)
@NativeClass()
public class VGUserData extends NSObject {
	private static final ObjCClass objCClass = ObjCClass.getByType(VGUserData.class);

	static {
		ObjCRuntime.bind(VGUserData.class);
	}

	public static VGUserData defaultUserData () {
		return objc_defaultUserData(objCClass, defaultUserData);
	}

	private static final Selector defaultUserData = Selector.register("defaultUserData");

	@Bridge
	private native static VGUserData objc_defaultUserData (ObjCClass __self__, Selector __cmd__);

	public int getAge () {
		return objc_getAge(this, getAge);
	}

	private static final Selector getAge = Selector.register("age");

	@Bridge
	private native static int objc_getAge (VGUserData __self__, Selector __cmd__);

	public void setAge (int age) {
		objc_setAge(this, setAge, age);
	}

	private static final Selector setAge = Selector.register("setAge:");

	@Bridge
	private native static int objc_setAge (VGUserData __self__, Selector __cmd__, int age);

	public VGGender getGender () {
		return objc_getGender(this, getGender);
	}

	private static final Selector getGender = Selector.register("gender");

	@Bridge
	private native static VGGender objc_getGender (VGUserData __self__, Selector __cmd__);

	public void setGender (VGGender gender) {
		objc_setGender(this, setGender, gender);
	}

	private static final Selector setGender = Selector.register("setGender:");

	@Bridge
	private native static VGGender objc_setGender (VGUserData __self__, Selector __cmd__, VGGender gender);

	public VGAdOrientation getAdOrientation () {
		return objc_getAdOrientation(this, getAdOrientation);
	}

	private static final Selector getAdOrientation = Selector.register("adOrientation");

	@Bridge
	private native static VGAdOrientation objc_getAdOrientation (VGUserData __self__, Selector __cmd__);

	public void setAdOrientation (VGAdOrientation orientation) {
		objc_setAdOrientation(this, setAdOrientation, orientation);
	}

	private static final Selector setAdOrientation = Selector.register("setAdOrientation:");

	@Bridge
	private native static VGGender objc_setAdOrientation (VGUserData __self__, Selector __cmd__, VGAdOrientation orientation);

	public boolean isLocationEnabled () {
		return objc_isLocationEnabled(this, isLocationEnabled);
	}

	private static final Selector isLocationEnabled = Selector.register("locationEnabled");

	@Bridge
	private native static boolean objc_isLocationEnabled (VGUserData __self__, Selector __cmd__);

	public void setLocationEnabled (boolean enabled) {
		objc_setLocationEnabled(this, setLocationEnabled, enabled);
	}

	private static final Selector setLocationEnabled = Selector.register("setLocationEnabled:");

	@Bridge
	private native static boolean objc_setLocationEnabled (VGUserData __self__, Selector __cmd__, boolean enabled);

	public NSDictionary<NSObject, NSObject> getJSONData () {
		return objc_getJSONData(this, getJSONData);
	}

	private static final Selector getJSONData = Selector.register("JSONData");

	@Bridge
	private native static NSDictionary<NSObject, NSObject> objc_getJSONData (VGUserData __self__, Selector __cmd__);
}
