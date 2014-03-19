
package org.robovm.bindings.facebook.dialogs;

import org.robovm.rt.bro.ValuedEnum;

public enum FBShareDialogResult implements ValuedEnum {
	/** Indicates that the dialog action completed successfully. */
	Succeeded,
	/** Indicates that the dialog action was cancelled (either by the user or the system). */
	Cancelled,
	/** Indicates that the dialog could not be shown (because not on ios6 or ios6 auth was not used). */
	Error;

	@Override
	public long value () {
		return ordinal();
	}
}
