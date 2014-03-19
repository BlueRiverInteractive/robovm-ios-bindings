
package org.robovm.bindings.facebook;

/** A handler that is passed to [FBViewController presentModallyInViewController:animated:handler:] and called when the view
 * controller is dismissed via either Done or Cancel.
 * @param sender The {@link FBViewController} that is being dismissed.
 * @param donePressed If YES, Done was pressed. If NO, Cancel was pressed. */
public interface FBModalCompletionHandler {

// typedef void (^FBModalCompletionHandler)(FBViewController *sender, BOOL donePressed);

}
