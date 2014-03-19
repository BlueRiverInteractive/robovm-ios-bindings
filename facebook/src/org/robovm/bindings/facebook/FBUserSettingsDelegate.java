
package org.robovm.bindings.facebook;

/** The FBUserSettingsDelegate protocol defines the methods called by a {@link FBUserSettingsViewController}. */
public interface FBUserSettingsDelegate extends FBViewControllerDelegate {

// @optional
//
// /*!
// @abstract
// Called when the view controller will log the user out in response to a button press.
//
// @param sender The view controller sending the message.
// */
// - (void)loginViewControllerWillLogUserOut:(id)sender;
//
// /*!
// @abstract
// Called after the view controller logged the user out in response to a button press.
//
// @param sender The view controller sending the message.
// */
// - (void)loginViewControllerDidLogUserOut:(id)sender;
//
// /*!
// @abstract
// Called when the view controller will log the user in in response to a button press.
// Note that logging in can fail for a number of reasons, so there is no guarantee that this
// will be followed by a call to loginViewControllerDidLogUserIn:. Callers wanting more granular
// notification of the session state changes can use KVO or the NSNotificationCenter to observe them.
//
// @param sender The view controller sending the message.
// */
// - (void)loginViewControllerWillAttemptToLogUserIn:(id)sender;
//
// /*!
// @abstract
// Called after the view controller successfully logged the user in in response to a button press.
//
// @param sender The view controller sending the message.
// */
// - (void)loginViewControllerDidLogUserIn:(id)sender;
//
// /*!
// @abstract
// Called if the view controller encounters an error while trying to log a user in.
//
// @param sender The view controller sending the message.
// @param error The error encountered.
// @discussion See https://developers.facebook.com/docs/technical-guides/iossdk/errors/
// for error handling best practices.
// */
// - (void)loginViewController:(id)sender receivedError:(NSError *)error;

}
