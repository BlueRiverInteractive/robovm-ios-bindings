
package org.robovm.bindings.facebook;

import org.robovm.rt.bro.ValuedEnum;

/** Type used to specify the cropping treatment of the profile picture. */
public enum FBProfilePictureCropping implements ValuedEnum {
	/** Square (default) - the square version that the Facebook user defined. */
	Square,
	/** Original - the original profile picture, as uploaded. */
	Original;

	@Override
	public long value () {
		return ordinal();
	}
}
