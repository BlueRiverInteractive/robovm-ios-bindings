
package org.robovm.bindings.facebook;

import org.robovm.rt.bro.ValuedEnum;

public enum FBShareDialogResult implements ValuedEnum {
	/* ! Indicates that the dialog action completed successfully. */
	Succeeded(0),
	/* ! Indicates that the dialog action was cancelled (either by the user or the system). */
	Cancelled(1),
	/* ! Indicates that the dialog could not be shown (because not on ios6 or ios6 auth was not used). */
	Error(2);

	private final int n;

	private FBShareDialogResult (int n) {
		this.n = n;
	}

	@Override
	public int value () {
		return n;
	}
}
