
package org.robovm.bindings.facebook.error;

import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.NativeClass;

/** A utility class with methods to provide more information for Facebook related errors if you do not want to use the
 * NSError(FBError) category. */
@NativeClass
public class FBErrorUtility extends NSObject {
	/*
	 * !
	 * 
	 * @abstract Categorizes the error, if it is Facebook related, to simplify application mitigation behavior
	 * 
	 * @discussion In general, in response to an error connecting to Facebook, an application should, retry the operation, request
	 * permissions, reconnect the application, or prompt the user to take an action. The error category can be used to understand
	 * the class of error received from Facebook. For more infomation on this see
	 * https://developers.facebook.com/docs/reference/api/errors/
	 * 
	 * @param error the error to be categorized.
	 */
// +(FBErrorCategory) errorCategoryForError:(NSError *)error;
//
// /*!
// @abstract
// If YES indicates that a user action is required in order to successfully continue with the facebook operation
//
// @discussion
// In general if this returns NO, then the application has a straightforward mitigation, such as
// retry the operation or request permissions from the user, etc. In some cases it is necessary for the user to
// take an action before the application continues to attempt a Facebook connection. For more infomation on this
// see https://developers.facebook.com/docs/reference/api/errors/
//
// @param error the error to inspect.
// */
// +(BOOL) shouldNotifyUserForError:(NSError *)error;
//
// /*!
// @abstract
// A message suitable for display to the user, describing a user action necessary to enable Facebook functionality.
// Not all Facebook errors yield a message suitable for user display; however in all cases where
// fberrorShouldNotifyUser is YES, this property returns a localizable message suitable for display.
//
// @param error the error to inspect.
// */
// +(NSString *) userMessageForError:(NSError *)error;

}
