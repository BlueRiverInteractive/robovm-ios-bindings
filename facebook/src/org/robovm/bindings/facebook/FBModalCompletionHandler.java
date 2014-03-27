
package org.robovm.bindings.facebook;

/** A handler that is passed to [FBViewController presentModallyInViewController:animated:handler:] and called when the view
 * controller is dismissed via either Done or Cancel.
 * @param sender The {@link FBViewController} that is being dismissed.
 * @param donePressed If {@code true}, Done was pressed. If {@code false}, Cancel was pressed. */
public interface FBModalCompletionHandler {
	void invoke (FBViewController sender, boolean donePressed);
}
