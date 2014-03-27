
package org.robovm.bindings.facebook;

import org.robovm.apple.uikit.UIView;
import org.robovm.objc.annotation.NativeClass;

/** FBLoginView is a custom UIView that renders a button to login or logout based on the state of `FBSession.activeSession`
 * 
 * This view is closely associated with `FBSession.activeSession`. Upon initialization, it will attempt to open an active session
 * without UI if the current active session is not open.
 * 
 * The FBLoginView instance also monitors for changes to the active session. */
@NativeClass
public class FBLoginView extends UIView {

// /*!
// @abstract
// The read permissions to request if the user logs in via this view. The basic_info permission must be explicitly requested at
// first login, and is no longer inferred, (subject to an active migration.)
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
//
//
// /*!
// @abstract
// Initializes and returns an `FBLoginView` object. The underlying session has basic permissions granted to it.
// */
// - (id)init;
//
// /*!
// @method
//
// @abstract
// Initializes and returns an `FBLoginView` object constructed with the specified permissions.
//
// @param permissions An array of strings representing the permissions to request during the
// authentication flow. A value of nil will indicates basic permissions.
//
// @discussion Methods and properties that specify permissions without a read or publish
// qualification are deprecated; use of a read-qualified or publish-qualified alternative is preferred.
// */
// - (id)initWithPermissions:(NSArray *)permissions __attribute__((deprecated));
//
// /*!
// @method
//
// @abstract
// Initializes and returns an `FBLoginView` object constructed with the specified permissions.
//
// @param readPermissions An array of strings representing the read permissions to request during the
// authentication flow. A value of nil will indicates basic permissions.
//
// */
// - (id)initWithReadPermissions:(NSArray *)readPermissions;
//
// /*!
// @method
//
// @abstract
// Initializes and returns an `FBLoginView` object constructed with the specified permissions.
//
// @param publishPermissions An array of strings representing the publish permissions to request during the
// authentication flow.
//
// @param defaultAudience An audience for published posts; note that FBSessionDefaultAudienceNone is not valid
// for permission requests that include publish or manage permissions.
//
// */
// - (id)initWithPublishPermissions:(NSArray *)publishPermissions
// defaultAudience:(FBSessionDefaultAudience)defaultAudience;
//
// /*!
// @abstract
// The delegate object that receives updates for selection and display control.
// */
// @property (nonatomic, assign) IBOutlet id<FBLoginViewDelegate> delegate;

}
