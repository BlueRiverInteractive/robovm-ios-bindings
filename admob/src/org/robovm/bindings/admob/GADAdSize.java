
package org.robovm.bindings.admob;

import org.robovm.apple.coregraphics.CGSize;
import org.robovm.rt.bro.Struct;
import org.robovm.rt.bro.annotation.ByVal;
import org.robovm.rt.bro.annotation.MachineSizedUInt;
import org.robovm.rt.bro.annotation.StructMember;

public class GADAdSize extends Struct<GADAdSize> {
	private GADAdSize () {
	}

	@StructMember(0)
	public native @ByVal
	CGSize size ();

	@StructMember(0)
	public native GADAdSize size (@ByVal CGSize size);

	@StructMember(1)
	public native @MachineSizedUInt
	long flags ();

	@StructMember(1)
	public native GADAdSize flags (@MachineSizedUInt long flags);

	public boolean isValid () {
		return GADAdSizeManager.isValid(this);
	}

	@Override
	public boolean equals (Object obj) {
		return obj instanceof GADAdSize && GADAdSizeManager.equals(this, (GADAdSize)obj);
	}

	@Override
	public String toString () {
		return GADAdSizeManager.toString(this);
	}
}
