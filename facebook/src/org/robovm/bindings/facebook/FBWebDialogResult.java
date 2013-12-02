
package org.robovm.bindings.facebook;

import org.robovm.rt.bro.ValuedEnum;

/*!
 @typedef FBWebDialogResult enum

 @abstract
 Passed to a handler to indicate the result of a dialog being displayed to the user.
 */
public enum FBWebDialogResult implements ValuedEnum {
	/*
	 * ! Indicates that the dialog action completed successfully. Note, that cancel operations represent completed dialog
	 * operations. The url argument may be used to distinguish between success and user-cancelled cases
	 */
	Completed(0),
	/*
	 * ! Indicates that the dialog operation was not completed. This occurs in cases such as the closure of the web-view using the
	 * X in the upper left corner.
	 */
	NotCompleted(1);

	private final int n;

	private FBWebDialogResult (int n) {
		this.n = n;
	}

	@Override
	public int value () {
		return n;
	}
}
