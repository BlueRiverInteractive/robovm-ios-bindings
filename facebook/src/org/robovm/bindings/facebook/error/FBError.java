
package org.robovm.bindings.facebook.error;

import org.robovm.cocoatouch.foundation.NSError;
import org.robovm.objc.annotation.NativeClass;

/** Adds additional properties to {@link NSError} to provide more information for Facebook related errors. */
@NativeClass
public class FBError extends NSError {

// /*!
// @abstract
// Categorizes the error, if it is Facebook related, to simplify application mitigation behavior
//
// @discussion
// In general, in response to an error connecting to Facebook, an application should, retry the
// operation, request permissions, reconnect the application, or prompt the user to take an action.
// The error category can be used to understand the class of error received from Facebook. For more infomation on this
// see https://developers.facebook.com/docs/reference/api/errors/
// */
// @property (readonly) FBErrorCategory fberrorCategory;
//
// /*!
// @abstract
// If YES indicates that a user action is required in order to successfully continue with the facebook operation
//
// @discussion
// In general if fberrorShouldNotifyUser is NO, then the application has a straightforward mitigation, such as
// retry the operation or request permissions from the user, etc. In some cases it is necessary for the user to
// take an action before the application continues to attempt a Facebook connection. For more infomation on this
// see https://developers.facebook.com/docs/reference/api/errors/
// */
// @property (readonly) BOOL fberrorShouldNotifyUser;
//
// /*!
// @abstract
// A message suitable for display to the user, describing a user action necessary to enable Facebook functionality.
// Not all Facebook errors yield a message suitable for user display; however in all cases where
// fberrorShouldNotifyUser is YES, this property returns a localizable message suitable for display.
// */
// @property (readonly, copy) NSString *fberrorUserMessage;
// /*!
// The NSError domain of all errors returned by the Facebook SDK.
// */
// extern NSString *const FacebookSDKDomain;
//
// /*!
// The NSError domain of all errors surfaced by the Facebook SDK that
// were returned by the Facebook Application
// */
// extern NSString *const FacebookNativeApplicationDomain;
//
// /*!
// The key in the userInfo NSDictionary of NSError where you can find
// the inner NSError (if any).
// */
// extern NSString *const FBErrorInnerErrorKey;
//
// /*!
// The key in the userInfo NSDictionary of NSError for the parsed JSON response
// from the server. In case of a batch, includes the JSON for a single FBRequest.
// */
// extern NSString *const FBErrorParsedJSONResponseKey;
//
// /*!
// The key in the userInfo NSDictionary of NSError indicating
// the HTTP status code of the response (if any).
// */
// extern NSString *const FBErrorHTTPStatusCodeKey;

// /*!
// The key in the userInfo NSDictionary of NSError where you can find
// the inner NSError (if any).
// */
// extern NSString *const FBErrorInnerErrorKey;
//
// /*!
// The key in the userInfo NSDictionary of NSError where you can find
// the session associated with the error (if any).
// */
// extern NSString *const FBErrorSessionKey;
//
// /*!
// The key in the userInfo NSDictionary of NSError that points to the URL
// that caused an error, in its processing by FBAppCall.
// */
// extern NSString *const FBErrorUnprocessedURLKey;
//
// /*!
// The key in the userInfo NSDictionary of NSError for unsuccessful
// logins (error.code equals FBErrorLoginFailedOrCancelled). If present,
// the value will be one of the constants prefixed by FBErrorLoginFailedReason*.
// */
// extern NSString *const FBErrorLoginFailedReason;
//
// /*!
// The key in the userInfo NSDictionary of NSError for unsuccessful
// logins (error.code equals FBErrorLoginFailedOrCancelled). If present,
// the value indicates an original login error code wrapped by this error.
// This is only used in the web dialog login flow.
// */
// extern NSString *const FBErrorLoginFailedOriginalErrorCode;
//
// /*!
// A value that may appear in an NSError userInfo dictionary under the
// `FBErrorLoginFailedReason` key for login failures. Indicates the user
// cancelled a web dialog auth.
// */
// extern NSString *const FBErrorLoginFailedReasonInlineCancelledValue;
//
// /*!
// A value that may appear in an NSError userInfo dictionary under the
// `FBErrorLoginFailedReason` key for login failures. Indicates the user
// did not cancel a web dialog auth.
// */
// extern NSString *const FBErrorLoginFailedReasonInlineNotCancelledValue;
//
// /*!
// A value that may appear in an NSError userInfo dictionary under the
// `FBErrorLoginFailedReason` key for login failures. Indicates the user
// cancelled a non-iOS 6 SSO (either Safari or Facebook App) login.
// */
// extern NSString *const FBErrorLoginFailedReasonUserCancelledValue;
//
// /*!
// A value that may appear in an NSError userInfo dictionary under the
// `FBErrorLoginFailedReason` key for login failures. Indicates the user
// cancelled an iOS system login.
// */
// extern NSString *const FBErrorLoginFailedReasonUserCancelledSystemValue;
//
// /*!
// A value that may appear in an NSError userInfo dictionary under the
// `FBErrorLoginFailedReason` key for login failures. Indicates an error
// condition. You may inspect the rest of userInfo for other data.
// */
// extern NSString *const FBErrorLoginFailedReasonOtherError;
//
// /*!
// A value that may appear in an NSError userInfo dictionary under the
// `FBErrorLoginFailedReason` key for login failures. Indicates the app's
// slider in iOS 6 (device Settings -> Privacy -> Facebook {app} ) has
// been disabled.
// */
// extern NSString *const FBErrorLoginFailedReasonSystemDisallowedWithoutErrorValue;
//
// /*!
// A value that may appear in an NSError userInfo dictionary under the
// `FBErrorLoginFailedReason` key for login failures. Indicates an error
// has occurred when requesting Facebook account acccess in iOS 6 that was
// not `FBErrorLoginFailedReasonSystemDisallowedWithoutErrorValue` nor
// a user cancellation.
// */
// extern NSString *const FBErrorLoginFailedReasonSystemError;
// extern NSString *const FBErrorLoginFailedReasonUnitTestResponseUnrecognized;
//
// /*!
// A value that may appear in the NSError userInfo dictionary under the
// `FBErrorLoginFailedReason` key when requesting new permissions fails. Indicates
// the request for new permissions has failed because the session was closed.
// */
// extern NSString *const FBErrorReauthorizeFailedReasonSessionClosed;
//
// /*!
// A value that may appear in the NSError userInfo dictionary under the
// `FBErrorLoginFailedReason` key when requesting new permissions fails. Indicates
// the request for new permissions has failed because the user cancelled.
// */
// extern NSString *const FBErrorReauthorizeFailedReasonUserCancelled;
//
// /*!
// A value that may appear in the NSError userInfo dictionary under the
// `FBErrorLoginFailedReason` key when requesting new permissions fails on
// iOS 6 with the Facebook account. Indicates the request for new permissions has
// failed because the user cancelled.
// */
// extern NSString *const FBErrorReauthorizeFailedReasonUserCancelledSystem;
//
// /*!
// A value that may appear in the NSError userInfo dictionary under the
// `FBErrorLoginFailedReason` key when requesting new permissions fails. Indicates
// the request for new permissions has failed because the request was
// for a different user than the original permission set.
// */
// extern NSString *const FBErrorReauthorizeFailedReasonWrongUser;
//
// /*!
// The key in the userInfo NSDictionary of NSError for errors
// encountered with `FBDialogs` operations. (error.code equals FBErrorDialog).
// If present, the value will be one of the constants prefixed by FBErrorDialog*.
// */
// extern NSString *const FBErrorDialogReasonKey;
//
// /*!
// A value that may appear in the NSError userInfo dictionary under the
// `FBErrorDialogReasonKey` key. Indicates that a native dialog is not supported
// in the current OS.
// */
// extern NSString *const FBErrorDialogNotSupported;
//
// /*!
// A value that may appear in the NSError userInfo dictionary under the
// `FBErrorDialogReasonKey` key. Indicates that a native dialog cannot be
// displayed because it is not appropriate for the current session.
// */
// extern NSString *const FBErrorDialogInvalidForSession;
//
// /*!
// A value that may appear in the NSError userInfo dictionary under the
// `FBErrorDialogReasonKey` key. Indicates that a native dialog cannot be
// displayed for some other reason.
// */
// extern NSString *const FBErrorDialogCantBeDisplayed;
//
// /*!
// A value that may appear in the NSError userInfo ditionary under the
// `FBErrorDialogReasonKey` key. Indicates that a native dialog cannot be
// displayed because an Open Graph object that was passed was not configured
// correctly. The object must either (a) exist by having an 'id' or 'url' value;
// or, (b) configured for creation (by setting the 'type' value and
// provisionedForPost property)
// */
// extern NSString *const FBErrorDialogInvalidOpenGraphObject;
//
// /*!
// A value that may appear in the NSError userInfo ditionary under the
// `FBErrorDialogReasonKey` key. Indicates that a native dialog cannot be
// displayed because the parameters for sharing an Open Graph action were
// not configured. The parameters must include an 'action', 'actionType', and
// 'previewPropertyName'.
// */
// extern NSString *const FBErrorDialogInvalidOpenGraphActionParameters;
//
// /*!
// The key in the userInfo NSDictionary of NSError for errors
// encountered with `FBAppEvents` operations (error.code equals FBErrorAppEvents).
// */
// extern NSString *const FBErrorAppEventsReasonKey;
//
// // Exception strings raised by the Facebook SDK
//
// /*!
// This exception is raised by methods in the Facebook SDK to indicate
// that an attempted operation is invalid
// */
// extern NSString *const FBInvalidOperationException;
//
// // Facebook SDK also raises exceptions the following common exceptions:
// // NSInvalidArgumentException
}
