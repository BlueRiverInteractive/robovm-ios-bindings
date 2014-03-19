
package org.robovm.bindings.facebook;

/** The FBFriendPickerDelegate protocol defines the methods used to receive event notifications and allow for deeper control of the
 * {@link FBFriendPickerViewController} view. */
public interface FBFriendPickerDelegate extends FBViewControllerDelegate {

// @optional
//
// /*!
// @abstract
// Tells the delegate that data has been loaded.
//
// @discussion
// The <FBFriendPickerViewController> object's `tableView` property is automatically
// reloaded when this happens. However, if another table view, for example the
// `UISearchBar` is showing data, then it may also need to be reloaded.
//
// @param friendPicker The friend picker view controller whose data changed.
// */
// - (void)friendPickerViewControllerDataDidChange:(FBFriendPickerViewController *)friendPicker;
//
// /*!
// @abstract
// Tells the delegate that the selection has changed.
//
// @param friendPicker The friend picker view controller whose selection changed.
// */
// - (void)friendPickerViewControllerSelectionDidChange:(FBFriendPickerViewController *)friendPicker;
//
// /*!
// @abstract
// Asks the delegate whether to include a friend in the list.
//
// @discussion
// This can be used to implement a search bar that filters the friend list.
//
// @param friendPicker The friend picker view controller that is requesting this information.
// @param user An <FBGraphUser> object representing the friend.
// */
// - (BOOL)friendPickerViewController:(FBFriendPickerViewController *)friendPicker
// shouldIncludeUser:(id <FBGraphUser>)user;
//
// /*!
// @abstract
// Tells the delegate that there is a communication error.
//
// @param friendPicker The friend picker view controller that encountered the error.
// @param error An error object containing details of the error.
// */
// - (void)friendPickerViewController:(FBFriendPickerViewController *)friendPicker
// handleError:(NSError *)error;
}
