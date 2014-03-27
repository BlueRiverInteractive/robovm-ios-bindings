
package org.robovm.bindings.facebook.dialogs;

import java.util.Map;

import org.robovm.apple.foundation.NSMutableDictionary;
import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.foundation.NSString;
import org.robovm.bindings.facebook.session.FBSession;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;

/** Provides methods to display web based dialogs to the user. */
@NativeClass
public class FBWebDialogs extends NSObject {
	private static final ObjCClass objCClass = ObjCClass.getByType(FBWebDialogs.class);

	/** Presents a Facebook web dialog (https://developers.facebook.com/docs/reference/dialogs/ ) such as feed or apprequest.
	 * 
	 * @param session Represents the session to use for the dialog. May be {@code null}, which uses the active session if present,
	 *           or returns {@code false}, if not.
	 * @param dialog Represents the dialog or method name, such as "feed".
	 * @param parameters A dictionary of parameters to be passed to the dialog.
	 * @param handler An optional handler that will be called when the dialog is dismissed. Note, that if the method returns
	 *           {@code false}, the handler is not called. May be nil. */
	public static void presentShareDialog (FBSession session, String dialog, Map<String, String> parameters,
		FBWebDialogHandler handler) {
		NSMutableDictionary<NSString, NSString> params = new NSMutableDictionary<NSString, NSString>();
		if (parameters != null) for (Map.Entry<String, String> entry : parameters.entrySet()) {
			params.put(new NSString(entry.getKey()), new NSString(entry.getValue()));
		}
		presentShareDialog(session, dialog, params, handler);
	}

	@Method(selector = "presentDialogModallyWithSession:dialog:parameters:handler:")
	public static native void presentShareDialog (FBSession session, String dialog,
		NSMutableDictionary<NSString, NSString> parameters, @Block FBWebDialogHandler handler);

	/*
	 * !
	 * 
	 * @abstract Presents a Facebook web dialog (https://developers.facebook.com/docs/reference/dialogs/ ) such as feed or
	 * apprequest.
	 * 
	 * @param session Represents the session to use for the dialog. May be nil, which uses the active session if present, or
	 * returns NO, if not.
	 * 
	 * @param dialog Represents the dialog or method name, such as @"feed"
	 * 
	 * @param parameters A dictionary of parameters to be passed to the dialog
	 * 
	 * @param handler An optional handler that will be called when the dialog is dismissed. Note, that if the method returns NO,
	 * the handler is not called. May be nil.
	 * 
	 * @param delegate An optional delegate to allow for advanced processing of web based dialogs. See 'FBWebDialogsDelegate' for
	 * more details.
	 */
	// + (void)presentDialogModallyWithSession:(FBSession *)session
	// dialog:(NSString *)dialog
	// parameters:(NSDictionary *)parameters
	// handler:(FBWebDialogHandler)handler
	// delegate:(id<FBWebDialogsDelegate>)delegate;

	/** Presents a Facebook apprequest dialog.
	 * 
	 * @param session Represents the session to use for the dialog. May be {@code null}, which uses the active session if present.
	 * @param message The required message for the dialog.
	 * @param title An optional title for the dialog.
	 * @param parameters A dictionary of additional parameters to be passed to the dialog. May be {@code null}.
	 * @param handler An optional handler that will be called when the dialog is dismissed. May be {@code null}. */
	public static void presentRequestDialog (FBSession session, String message, String title, Map<String, String> parameters,
		FBWebDialogHandler handler) {
		NSMutableDictionary<NSString, NSString> params = new NSMutableDictionary<NSString, NSString>();
		if (parameters != null) for (Map.Entry<String, String> entry : parameters.entrySet()) {
			params.put(new NSString(entry.getKey()), new NSString(entry.getValue()));
		}
		presentRequestDialog(session, message, title, params, handler);
	}

	@Method(selector = "presentRequestsDialogModallyWithSession:message:title:parameters:handler:")
	public static native void presentRequestDialog (FBSession session, String message, String title,
		NSMutableDictionary<NSString, NSString> parameters, @Block FBWebDialogHandler handler);

	/*
	 * !
	 * 
	 * @abstract Presents a Facebook apprequest dialog.
	 * 
	 * @param session Represents the session to use for the dialog. May be nil, which uses the active session if present.
	 * 
	 * @param message The required message for the dialog.
	 * 
	 * @param title An optional title for the dialog.
	 * 
	 * @param parameters A dictionary of additional parameters to be passed to the dialog. May be nil
	 * 
	 * @param handler An optional handler that will be called when the dialog is dismissed. May be nil.
	 * 
	 * @param friendCache An optional cache object used to enable frictionless sharing for a known set of friends. The cache
	 * instance should be preserved for the life of the session and reused for multiple calls to the present method. As the users
	 * set of friends enabled for frictionless sharing changes, this method auto-updates the cache.
	 */
	// + (void)presentRequestsDialogModallyWithSession:(FBSession *)session
	// message:(NSString *)message
	// title:(NSString *)title
	// parameters:(NSDictionary *)parameters
	// handler:(FBWebDialogHandler)handler
	// friendCache:(FBFrictionlessRecipientCache *)friendCache;

	/** Presents a Facebook feed dialog.
	 * 
	 * @param session Represents the session to use for the dialog. May be nil, which uses the active session if present.
	 * @param parameters A dictionary of additional parameters to be passed to the dialog. May be nil
	 * @param handler An optional handler that will be called when the dialog is dismissed. May be nil. */
	public static void presentFeedDialog (FBSession session, Map<String, String> parameters, FBWebDialogHandler handler) {
		NSMutableDictionary<NSString, NSString> params = new NSMutableDictionary<NSString, NSString>();
		if (parameters != null) for (Map.Entry<String, String> entry : parameters.entrySet()) {
			params.put(new NSString(entry.getKey()), new NSString(entry.getValue()));
		}
		presentFeedDialog(session, params, handler);
	}

	@Method(selector = "presentFeedDialogModallyWithSession:parameters:handler:")
	public static native void presentFeedDialog (FBSession session, NSMutableDictionary<NSString, NSString> parameters,
		@Block FBWebDialogHandler handler);

	//
	// /*!
	// @protocol
	//
	// @abstract
	// The `FBWebDialogsDelegate` protocol enables the plugging of advanced behaviors into
	// the presentation flow of a Facebook web dialog. Advanced uses include modification
	// of parameters and application-level handling of links on the dialog. The
	// `FBFrictionlessRequestFriendCache` class implements this protocol to add frictionless
	// behaviors to a presentation of the request dialog.
	// */
	// @protocol FBWebDialogsDelegate<NSObject>
	//
	// @optional

	/*
	 * !
	 * 
	 * @abstract Called prior to the presentation of a web dialog
	 * 
	 * @param dialog A string representing the method or dialog name of the dialog being presented.
	 * 
	 * @param parameters A mutable dictionary of parameters which will be sent to the dialog.
	 * 
	 * @param session The session object to use with the dialog.
	 */
	// - (void)webDialogsWillPresentDialog:(NSString *)dialog
	// parameters:(NSMutableDictionary *)parameters
	// session:(FBSession *)session;

	/*
	 * !
	 * 
	 * @abstract Called when the user of a dialog clicks a link that would cause a transition away from the application. Your
	 * application may handle this method, and return NO if the URL handling will be performed by the application.
	 * 
	 * @param dialog A string representing the method or dialog name of the dialog being presented.
	 * 
	 * @param parameters A dictionary of parameters which were sent to the dialog.
	 * 
	 * @param session The session object to use with the dialog.
	 * 
	 * @param url The url in question, which will not be handled by the SDK if this method NO
	 */
	// - (BOOL)webDialogsDialog:(NSString *)dialog
	// parameters:(NSDictionary *)parameters
	// session:(FBSession *)session
	// shouldAutoHandleURL:(NSURL *)url;

	/*
	 * !
	 * 
	 * @abstract Called when the dialog is about to be dismissed
	 * 
	 * @param dialog A string representing the method or dialog name of the dialog being presented.
	 * 
	 * @param parameters A dictionary of parameters which were sent to the dialog.
	 * 
	 * @param session The session object to use with the dialog.
	 * 
	 * @param result A pointer to a result, which may be read or changed by the handling method as needed
	 * 
	 * @param url A pointer to a pointer to a URL representing the URL returned by the dialog, which may be read or changed by this
	 * mehthod
	 * 
	 * @param error A pointer to a pointer to an error object which may be read or changed by this method as needed
	 */
	// - (void)webDialogsWillDismissDialog:(NSString *)dialog
	// parameters:(NSDictionary *)parameters
	// session:(FBSession *)session
	// result:(FBWebDialogResult *)result
	// url:(NSURL **)url
	// error:(NSError **)error;

}
