
package org.robovm.bindings.facebook;

import java.util.Map;

import org.robovm.cocoatouch.foundation.NSDictionary;
import org.robovm.cocoatouch.foundation.NSMutableDictionary;
import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSString;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

/*!
 @class FBWebDialogs

 @abstract
 Provides methods to display web based dialogs to the user.
 */
@Library(Library.INTERNAL)
@NativeClass()
public class FBWebDialogs extends NSObject {
	private static final ObjCClass objCClass = ObjCClass.getByType(FBWebDialogs.class);

	static {
		ObjCRuntime.bind(FBWebDialogs.class);
	}

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
	 */
	// + (void)presentDialogModallyWithSession:(FBSession *)session
	// dialog:(NSString *)dialog
	// parameters:(NSDictionary *)parameters
	// handler:(FBWebDialogHandler)handler;
	private static final Selector presentDialogModallyWithSession$dialog$parameters$handler$ = Selector
		.register("presentDialogModallyWithSession:dialog:parameters:handler:");

	@Bridge
	private native static void objc_presentDialogModallyWithSession$dialog$parameters$handler$ (ObjCClass __self__,
		Selector __cmd__, FBSession session, String dialog, NSDictionary<NSString, NSString> parameters, FBWebDialogHandler handler);

	public static void presentShareDialog (FBSession session, String dialog, Map<String, String> parameters,
		FBWebDialogHandler handler) {
		NSMutableDictionary<NSString, NSString> params = new NSMutableDictionary<NSString, NSString>();
		if (parameters != null) for (Map.Entry<String, String> entry : parameters.entrySet()) {
			params.put(new NSString(entry.getKey()), new NSString(entry.getValue()));
		}
		objc_presentDialogModallyWithSession$dialog$parameters$handler$(objCClass,
			presentDialogModallyWithSession$dialog$parameters$handler$, session, dialog, params, handler);
	}

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
	 */
	// + (void)presentRequestsDialogModallyWithSession:(FBSession *)session
	// message:(NSString *)message
	// title:(NSString *)title
	// parameters:(NSDictionary *)parameters
	// handler:(FBWebDialogHandler)handler;
	private static final Selector presentRequestsDialogModallyWithSession$message$title$parameters$handler$ = Selector
		.register("presentRequestsDialogModallyWithSession:message:title:parameters:handler:");

	@Bridge
	private native static void objc_presentRequestsDialogModallyWithSession$message$title$parameters$handler$ (ObjCClass __self__,
		Selector __cmd__, FBSession session, String message, String title, NSDictionary<NSString, NSString> parameters,
		FBWebDialogHandler handler);

	public static void presentRequestDialog (FBSession session, String message, String title, Map<String, String> parameters,
		FBWebDialogHandler handler) {
		NSMutableDictionary<NSString, NSString> params = new NSMutableDictionary<NSString, NSString>();
		if (parameters != null) for (Map.Entry<String, String> entry : parameters.entrySet()) {
			params.put(new NSString(entry.getKey()), new NSString(entry.getValue()));
		}
		objc_presentRequestsDialogModallyWithSession$message$title$parameters$handler$(objCClass,
			presentRequestsDialogModallyWithSession$message$title$parameters$handler$, session, message, title, params, handler);
	}

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

	/*
	 * !
	 * 
	 * @abstract Presents a Facebook feed dialog.
	 * 
	 * @param session Represents the session to use for the dialog. May be nil, which uses the active session if present.
	 * 
	 * @param parameters A dictionary of additional parameters to be passed to the dialog. May be nil
	 * 
	 * @param handler An optional handler that will be called when the dialog is dismissed. May be nil.
	 */
	// + (void)presentFeedDialogModallyWithSession:(FBSession *)session
	// parameters:(NSDictionary *)parameters
	// handler:(FBWebDialogHandler)handler;

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
