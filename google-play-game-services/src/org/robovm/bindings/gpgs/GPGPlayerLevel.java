package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class GPGPlayerLevel extends NSObject {

	@Property(selector = "level")
	public native int getLevel();

	@Property(selector = "minExperiencePoints")
	public native long getMinExperiencePoints();

	@Property(selector = "maxExperiencePoints")
	public native long getMaxExperiencePoints();
}
