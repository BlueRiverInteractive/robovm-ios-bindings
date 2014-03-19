
package org.robovm.bindings.facebook;

import org.robovm.cocoatouch.foundation.NSObjectProtocol;

/** The FBLoginViewDelegate protocol defines the methods used to receive event notifications from {@link FBLoginView} objects. */
public interface FBLoginViewDelegate extends NSObjectProtocol {

// @optional
//
// /*!
// @abstract
// Tells the delegate that the view is now in logged in mode
//
// @param loginView The login view that transitioned its view mode
// */
// - (void)loginViewShowingLoggedInUser:(FBLoginView *)loginView;
//
// /*!
// @abstract
// Tells the delegate that the view is has now fetched user info
//
// @param loginView The login view that transitioned its view mode
//
// @param user The user info object describing the logged in user
// */
// - (void)loginViewFetchedUserInfo:(FBLoginView *)loginView
// user:(id<FBGraphUser>)user;
//
// /*!
// @abstract
// Tells the delegate that the view is now in logged out mode
//
// @param loginView The login view that transitioned its view mode
// */
// - (void)loginViewShowingLoggedOutUser:(FBLoginView *)loginView;
//
// /*!
// @abstract
// Tells the delegate that there is a communication or authorization error.
//
// @param loginView The login view that transitioned its view mode
// @param error An error object containing details of the error.
// @discussion See https://developers.facebook.com/docs/technical-guides/iossdk/errors/
// for error handling best practices.
// */
// - (void)loginView:(FBLoginView *)loginView
// handleError:(NSError *)error;
}
