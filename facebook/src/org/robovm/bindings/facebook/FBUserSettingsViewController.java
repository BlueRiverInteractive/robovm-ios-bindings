
package org.robovm.bindings.facebook;

import org.robovm.objc.annotation.NativeClass;

/** The FBUserSettingsViewController class provides a user interface exposing a user's Facebook-related settings. Currently, this
 * is limited to whether they are logged in or out of Facebook.
 * 
 * Because of the size of some graphics used in this view, its resources are packaged as a separate bundle. In order to use
 * FBUserSettingsViewController, drag the `FBUserSettingsViewResources.bundle` from the SDK directory into your Xcode project. */
@NativeClass
public class FBUserSettingsViewController extends FBViewController {
//
//
// /*!
// @abstract
// The read permissions to request if the user logs in via this view.
//
// @discussion
// Note, that if read permissions are specified, then publish permissions should not be specified.
// */
// @property (nonatomic, copy) NSArray *readPermissions;
//
// /*!
// @abstract
// The publish permissions to request if the user logs in via this view.
//
// @discussion
// Note, that a defaultAudience value of FBSessionDefaultAudienceOnlyMe, FBSessionDefaultAudienceEveryone, or
// FBSessionDefaultAudienceFriends should be set if publish permissions are specified. Additionally, when publish
// permissions are specified, then read should not be specified.
// */
// @property (nonatomic, copy) NSArray *publishPermissions;
//
// /*!
// @abstract
// The default audience to use, if publish permissions are requested at login time.
// */
// @property (nonatomic, assign) FBSessionDefaultAudience defaultAudience;

}
