
package org.robovm.bindings.facebook;

import org.robovm.cocoatouch.foundation.NSArray;
import org.robovm.cocoatouch.foundation.NSDictionary;
import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.uikit.UIViewController;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

/*!
 @class FBDialogs

 @abstract
 Provides methods to display native (i.e., non-Web-based) dialogs to the user.

 @discussion
 If you are building an app with a urlSchemeSuffix, you should also set the appropriate
 plist entry. See `[FBSettings defaultUrlSchemeSuffix]`.
 */
@Library(Library.INTERNAL)
@NativeClass()
public class FBDialogs extends NSObject {
	private static final ObjCClass objCClass = ObjCClass.getByType(FBDialogs.class);

	static {
		ObjCRuntime.bind(FBDialogs.class);
	}
	/*
	 * !
	 * 
	 * @abstract Presents a dialog that allows the user to share a status update that may include text, images, or URLs. This
	 * dialog is only available on iOS 6.0 and above. The current active session returned by [FBSession activeSession] will be used
	 * to determine whether the dialog will be displayed. If a session is active, it must be open and the login method used to
	 * authenticate the user must be native iOS 6.0 authentication. If no session active, then whether the call succeeds or not
	 * will depend on whether Facebook integration has been configured.
	 * 
	 * @param viewController The view controller which will present the dialog.
	 * 
	 * @param initialText The text which will initially be populated in the dialog. The user will have the opportunity to edit this
	 * text before posting it. May be nil.
	 * 
	 * @param image A UIImage that will be attached to the status update. May be nil.
	 * 
	 * @param url An NSURL that will be attached to the status update. May be nil.
	 * 
	 * @param handler A handler that will be called when the dialog is dismissed, or if an error occurs. May be nil.
	 * 
	 * @return YES if the dialog was presented, NO if not (in the case of a NO result, the handler will still be called, with an
	 * error indicating the reason the dialog was not displayed)
	 */
	// + (BOOL)presentOSIntegratedShareDialogModallyFrom:(UIViewController*)viewController
	// initialText:(NSString*)initialText
	// image:(UIImage*)image
	// url:(NSURL*)url
	// handler:(FBOSIntegratedShareDialogHandler)handler;

	/*
	 * !
	 * 
	 * @abstract Presents a dialog that allows the user to share a status update that may include text, images, or URLs. This
	 * dialog is only available on iOS 6.0 and above. The current active session returned by [FBSession activeSession] will be used
	 * to determine whether the dialog will be displayed. If a session is active, it must be open and the login method used to
	 * authenticate the user must be native iOS 6.0 authentication. If no session active, then whether the call succeeds or not
	 * will depend on whether Facebook integration has been configured.
	 * 
	 * @param viewController The view controller which will present the dialog.
	 * 
	 * @param initialText The text which will initially be populated in the dialog. The user will have the opportunity to edit this
	 * text before posting it. May be nil.
	 * 
	 * @param images An array of UIImages that will be attached to the status update. May be nil.
	 * 
	 * @param urls An array of NSURLs that will be attached to the status update. May be nil.
	 * 
	 * @param handler A handler that will be called when the dialog is dismissed, or if an error occurs. May be nil.
	 * 
	 * @return YES if the dialog was presented, NO if not (in the case of a NO result, the handler will still be called, with an
	 * error indicating the reason the dialog was not displayed)
	 */
	// + (BOOL)presentOSIntegratedShareDialogModallyFrom:(UIViewController*)viewController
	// initialText:(NSString*)initialText
	// images:(NSArray*)images
	// urls:(NSArray*)urls
	// handler:(FBOSIntegratedShareDialogHandler)handler;

	/*
	 * !
	 * 
	 * @abstract Presents a dialog that allows the user to share a status update that may include text, images, or URLs. This
	 * dialog is only available on iOS 6.0 and above. An <FBSession> may be specified, or nil may be passed to indicate that the
	 * current active session should be used. If a session is specified (whether explicitly or by virtue of being the active
	 * session), it must be open and the login method used to authenticate the user must be native iOS 6.0 authentication. If no
	 * session is specified (and there is no active session), then whether the call succeeds or not will depend on whether Facebook
	 * integration has been configured.
	 * 
	 * @param viewController The view controller which will present the dialog.
	 * 
	 * @param session The <FBSession> to use to determine whether or not the user has been authenticated with iOS native
	 * authentication. If nil, then [FBSession activeSession] will be checked. See discussion above for the implications of nil or
	 * non-nil session.
	 * 
	 * @param initialText The text which will initially be populated in the dialog. The user will have the opportunity to edit this
	 * text before posting it. May be nil.
	 * 
	 * @param images An array of UIImages that will be attached to the status update. May be nil.
	 * 
	 * @param urls An array of NSURLs that will be attached to the status update. May be nil.
	 * 
	 * @param handler A handler that will be called when the dialog is dismissed, or if an error occurs. May be nil.
	 * 
	 * @return YES if the dialog was presented, NO if not (in the case of a NO result, the handler will still be called, with an
	 * error indicating the reason the dialog was not displayed)
	 */
	// + (BOOL)presentOSIntegratedShareDialogModallyFrom:(UIViewController*)viewController
	// session:(FBSession*)session
	// initialText:(NSString*)initialText
	// images:(NSArray*)images
	// urls:(NSArray*)urls
	// handler:(FBOSIntegratedShareDialogHandler)handler;

	private static final Selector presentOSIntegratedShareDialogModallyFrom$session$initialText$images$urls$handler$ = Selector
		.register("presentOSIntegratedShareDialogModallyFrom:session:initialText:images:urls:handler:");

	@Bridge
	private native static boolean objc_presentOSIntegratedShareDialogModallyFrom$session$initialText$images$urls$handler$ (
		ObjCClass __self__, Selector __cmd__, UIViewController viewController, FBSession session, String initialText,
		NSArray images, NSArray urls, FBOSIntegratedShareDialogHandler handler);

	public static boolean presentModalShareDialog (UIViewController viewController, FBSession session, String initialText,
		NSArray images, NSArray urls, FBOSIntegratedShareDialogHandler handler) {
		return objc_presentOSIntegratedShareDialogModallyFrom$session$initialText$images$urls$handler$(objCClass,
			presentOSIntegratedShareDialogModallyFrom$session$initialText$images$urls$handler$, viewController, session,
			initialText, images, urls, handler);
	}

	/*
	 * !
	 * 
	 * @abstract Determines whether a call to presentShareDialogModallyFrom: will successfully present a dialog. This is useful for
	 * applications that need to modify the available UI controls depending on whether the dialog is available on the current
	 * platform and for the current user.
	 * 
	 * @param session The <FBSession> to use to determine whether or not the user has been authenticated with iOS native
	 * authentication. If nil, then [FBSession activeSession] will be checked. See discussion above for the implications of nil or
	 * non-nil session.
	 * 
	 * @return YES if the dialog would be presented for the session, and NO if not
	 */
	// + (BOOL)canPresentOSIntegratedShareDialogWithSession:(FBSession*)session;
	private static final Selector canPresentOSIntegratedShareDialogWithSession$ = Selector
		.register("canPresentOSIntegratedShareDialogWithSession:");

	@Bridge
	private native static boolean objc_canPresentOSIntegratedShareDialogWithSession$ (ObjCClass __self__, Selector __cmd__,
		FBSession session);

	public static boolean canPresentModalShareDialog (FBSession session) {
		return objc_canPresentOSIntegratedShareDialogWithSession$(objCClass, canPresentOSIntegratedShareDialogWithSession$, session);
	}

	/*
	 * !
	 * 
	 * @abstract Determines whether a call to presentFBShareDialogWithTarget: will successfully present a dialog in the Facebook
	 * application. This is useful for applications that need to modify the available UI controls depending on whether the dialog
	 * is available on the current platform.
	 * 
	 * @param params The parameters for the FB share dialog.
	 * 
	 * @return YES if the dialog would be presented, and NO if not
	 * 
	 * @discussion A return value of YES here indicates that the corresponding presentFBShareDialogWithParams method will return a
	 * non-nil FBAppCall for the same params. And vice versa.
	 */
	// + (BOOL)canPresentShareDialogWithParams:(FBShareDialogParams *)params;
	private static final Selector canPresentShareDialogWithParams$ = Selector.register("canPresentShareDialogWithParams:");

	@Bridge
	private native static boolean objc_canPresentShareDialogWithParams$ (ObjCClass __self__, Selector __cmd__,
		FBShareDialogParams params);

	public static boolean canPresentShareDialog (FBShareDialogParams params) {
		return objc_canPresentShareDialogWithParams$(objCClass, canPresentShareDialogWithParams$, params);
	}

	/*
	 * !
	 * 
	 * @abstract Presents a dialog in the Facebook application that allows the user to share a status update that may include text,
	 * images, or URLs. No session is required, and the app does not need to be authorized to call this.
	 * 
	 * Note that this will perform an app switch to the Facebook app, and will cause the current app to be suspended. When the
	 * share is complete, the Facebook app will redirect to a url of the form "fb{APP_ID}://" that the application must handle. The
	 * app should then call [FBAppCall handleOpenURL:sourceApplication:fallbackHandler:] to trigger the appropriate handling. Note
	 * that FBAppCall will first try to call the completion handler associated with this method, but since during an app switch,
	 * the calling app may be suspended or killed, the app must also give a fallbackHandler to the handleOpenURL: method in
	 * FBAppCall.
	 * 
	 * @param params The parameters for the FB share dialog.
	 * 
	 * @param clientState An NSDictionary that's passed through when the completion handler is called. This is useful for the app
	 * to maintain state about the share request that was made so as to have appropriate action when the handler is called. May be
	 * nil.
	 * 
	 * @param handler A completion handler that may be called when the status update is complete. May be nil. If non-nil, the
	 * handler will always be called asynchronously.
	 * 
	 * @return An FBAppCall object that will also be passed into the provided FBAppCallCompletionHandler.
	 * 
	 * @discussion A non-nil FBAppCall object is only returned if the corresponding canPresetFBShareDialogWithParams method is also
	 * returning YES for the same params.
	 */
	// + (FBAppCall *)presentShareDialogWithParams:(FBShareDialogParams *)params
	// clientState:(NSDictionary *)clientState
	// handler:(FBDialogAppCallCompletionHandler)handler;
	private static final Selector presentShareDialogWithParams$clientState$handler$ = Selector
		.register("presentShareDialogWithParams:clientState:handler:");

	@Bridge
	private native static FBAppCall objc_presentShareDialogWithParams$clientState$handler$ (ObjCClass __self__, Selector __cmd__,
		FBShareDialogParams params, NSDictionary clientState, FBDialogAppCallCompletionHandler handler);

	public static FBAppCall presentShareDialog (FBShareDialogParams params, NSDictionary clientState,
		FBDialogAppCallCompletionHandler handler) {
		return objc_presentShareDialogWithParams$clientState$handler$(objCClass, presentShareDialogWithParams$clientState$handler$,
			params, clientState, handler);
	}

	/*
	 * !
	 * 
	 * @abstract Presents a dialog in the Facebook application that allows the user to share the supplied link. No session is
	 * required, and the app does not need to be authorized to call this.
	 * 
	 * Note that this will perform an app switch to the Facebook app, and will cause the current app to be suspended. When the
	 * share is complete, the Facebook app will redirect to a url of the form "fb{APP_ID}://" that the application must handle. The
	 * app should then call [FBAppCall handleOpenURL:sourceApplication:fallbackHandler:] to trigger the appropriate handling. Note
	 * that FBAppCall will first try to call the completion handler associated with this method, but since during an app switch,
	 * the calling app may be suspended or killed, the app must also give a fallbackHandler to the handleOpenURL: method in
	 * FBAppCall.
	 * 
	 * @param link The URL link to be attached to the post.
	 * 
	 * @param handler A completion handler that may be called when the status update is complete. May be nil. If non-nil, the
	 * handler will always be called asynchronously.
	 * 
	 * @return An FBAppCall object that will also be passed into the provided FBAppCallCompletionHandler.
	 * 
	 * @discussion A non-nil FBAppCall object is only returned if the corresponding canPresetFBShareDialogWithParams method is also
	 * returning YES for the same params.
	 */
	// + (FBAppCall *)presentShareDialogWithLink:(NSURL *)link
	// handler:(FBDialogAppCallCompletionHandler)handler;

	/*
	 * !
	 * 
	 * @abstract Presents a dialog in the Facebook application that allows the user to share the supplied link. No session is
	 * required, and the app does not need to be authorized to call this.
	 * 
	 * Note that this will perform an app switch to the Facebook app, and will cause the current app to be suspended. When the
	 * share is complete, the Facebook app will redirect to a url of the form "fb{APP_ID}://" that the application must handle. The
	 * app should then call [FBAppCall handleOpenURL:sourceApplication:fallbackHandler:] to trigger the appropriate handling. Note
	 * that FBAppCall will first try to call the completion handler associated with this method, but since during an app switch,
	 * the calling app may be suspended or killed, the app must also give a fallbackHandler to the handleOpenURL: method in
	 * FBAppCall.
	 * 
	 * @param link The URL link to be attached to the post.
	 * 
	 * @param name The name, or title associated with the link. May be nil.
	 * 
	 * @param handler A completion handler that may be called when the status update is complete. May be nil. If non-nil, the
	 * handler will always be called asynchronously.
	 * 
	 * @return An FBAppCall object that will also be passed into the provided FBAppCallCompletionHandler.
	 * 
	 * @discussion A non-nil FBAppCall object is only returned if the corresponding canPresetFBShareDialogWithParams method is also
	 * returning YES for the same params.
	 */
	// + (FBAppCall *)presentShareDialogWithLink:(NSURL *)link
	// name:(NSString *)name
	// handler:(FBDialogAppCallCompletionHandler)handler;

	/*
	 * !
	 * 
	 * @abstract Presents a dialog in the Facebook application that allows the user to share the supplied link. No session is
	 * required, and the app does not need to be authorized to call this.
	 * 
	 * Note that this will perform an app switch to the Facebook app, and will cause the current app to be suspended. When the
	 * share is complete, the Facebook app will redirect to a url of the form "fb{APP_ID}://" that the application must handle. The
	 * app should then call [FBAppCall handleOpenURL:sourceApplication:fallbackHandler:] to trigger the appropriate handling. Note
	 * that FBAppCall will first try to call the completion handler associated with this method, but since during an app switch,
	 * the calling app may be suspended or killed, the app must also give a fallbackHandler to the handleOpenURL: method in
	 * FBAppCall.
	 * 
	 * @param link The URL link to be attached to the post.
	 * 
	 * @param name The name, or title associated with the link. May be nil.
	 * 
	 * @param caption The caption to be used with the link. May be nil.
	 * 
	 * @param description The description associated with the link. May be nil.
	 * 
	 * @param picture The link to a thumbnail to associate with the link. May be nil.
	 * 
	 * @param clientState An NSDictionary that's passed through when the completion handler is called. This is useful for the app
	 * to maintain state about the share request that was made so as to have appropriate action when the handler is called. May be
	 * nil.
	 * 
	 * @param handler A completion handler that may be called when the status update is complete. May be nil. If non-nil, the
	 * handler will always be called asynchronously.
	 * 
	 * @return An FBAppCall object that will also be passed into the provided FBAppCallCompletionHandler.
	 * 
	 * @discussion A non-nil FBAppCall object is only returned if the corresponding canPresetFBShareDialogWithParams method is also
	 * returning YES for the same params.
	 */
	// + (FBAppCall *)presentShareDialogWithLink:(NSURL *)link
	// name:(NSString *)name
	// caption:(NSString *)caption
	// description:(NSString *)description
	// picture:(NSURL *)picture
	// clientState:(NSDictionary *)clientState
	// handler:(FBDialogAppCallCompletionHandler)handler;

	/*
	 * !
	 * 
	 * @abstract Determines whether a call to presentFBShareDialogWithOpenGraphActionParams:clientState:handler: will successfully
	 * present a dialog in the Facebook application. This is useful for applications that need to modify the available UI controls
	 * depending on whether the dialog is available on the current platform.
	 * 
	 * @param params The parameters for the FB share dialog.
	 * 
	 * @return YES if the dialog would be presented, and NO if not
	 * 
	 * @discussion A return value of YES here indicates that the corresponding presentFBShareDialogWithOpenGraphActionParams method
	 * will return a non-nil FBAppCall for the same params. And vice versa.
	 */
	// + (BOOL)canPresentShareDialogWithOpenGraphActionParams:(FBOpenGraphActionShareDialogParams *)params;

	/*
	 * !
	 * 
	 * @abstract Presents a dialog in the Facebook application that allows the user to publish an Open Graph action. No session is
	 * required, and the app does not need to be authorized to call this.
	 * 
	 * Note that this will perform an app switch to the Facebook app, and will cause the current app to be suspended. When the
	 * share is complete, the Facebook app will redirect to a url of the form "fb{APP_ID}://" that the application must handle. The
	 * app should then call [FBAppCall handleOpenURL:sourceApplication:fallbackHandler:] to trigger the appropriate handling. Note
	 * that FBAppCall will first try to call the completion handler associated with this method, but since during an app switch,
	 * the calling app may be suspended or killed, the app must also give a fallbackHandler to the handleOpenURL: method in
	 * FBAppCall.
	 * 
	 * @param params The parameters for the Open Graph action dialog.
	 * 
	 * @param clientState An NSDictionary that's passed through when the completion handler is called. This is useful for the app
	 * to maintain state about the share request that was made so as to have appropriate action when the handler is called. May be
	 * nil.
	 * 
	 * @param handler A completion handler that may be called when the status update is complete. May be nil. If non-nil, the
	 * handler will always be called asynchronously.
	 * 
	 * @return An FBAppCall object that will also be passed into the provided FBAppCallCompletionHandler.
	 * 
	 * @discussion A non-nil FBAppCall object is only returned if the corresponding
	 * canPresentFBShareDialogWithOpenGraphActionParams method is also returning YES for the same params.
	 */
	// + (FBAppCall *)presentShareDialogWithOpenGraphActionParams:(FBOpenGraphActionShareDialogParams *)params
	// clientState:(NSDictionary *)clientState
	// handler:(FBDialogAppCallCompletionHandler)handler;

	/*
	 * !
	 * 
	 * @abstract Presents a dialog in the Facebook application that allows the user to publish the supplied Open Graph action. No
	 * session is required, and the app does not need to be authorized to call this.
	 * 
	 * Note that this will perform an app switch to the Facebook app, and will cause the current app to be suspended. When the
	 * share is complete, the Facebook app will redirect to a url of the form "fb{APP_ID}://" that the application must handle. The
	 * app should then call [FBAppCall handleOpenURL:sourceApplication:fallbackHandler:] to trigger the appropriate handling. Note
	 * that FBAppCall will first try to call the completion handler associated with this method, but since during an app switch,
	 * the calling app may be suspended or killed, the app must also give a fallbackHandler to the handleOpenURL: method in
	 * FBAppCall.
	 * 
	 * @param action The Open Graph action to be published. May not be nil.
	 * 
	 * @param actionType the fully-specified Open Graph action type of the action (e.g., my_app_namespace:my_action).
	 * 
	 * @param previewPropertyName the name of the property on the action that represents the primary Open Graph object associated
	 * with the action; this object will be displayed in the preview portion of the share dialog.
	 * 
	 * @param handler A completion handler that may be called when the status update is complete. May be nil. If non-nil, the
	 * handler will always be called asynchronously.
	 * 
	 * @return An FBAppCall object that will also be passed into the provided FBAppCallCompletionHandler.
	 * 
	 * @discussion A non-nil FBAppCall object is only returned if the corresponding
	 * canPresentFBShareDialogWithOpenGraphActionParams method is also returning YES for the same params.
	 */
	// + (FBAppCall *)presentShareDialogWithOpenGraphAction:(id<FBOpenGraphAction>)action
	// actionType:(NSString *)actionType
	// previewPropertyName:(NSString *)previewPropertyName
	// handler:(FBDialogAppCallCompletionHandler) handler;

	/*
	 * !
	 * 
	 * @abstract Presents a dialog in the Facebook application that allows the user to publish the supplied Open Graph action. No
	 * session is required, and the app does not need to be authorized to call this.
	 * 
	 * Note that this will perform an app switch to the Facebook app, and will cause the current app to be suspended. When the
	 * share is complete, the Facebook app will redirect to a url of the form "fb{APP_ID}://" that the application must handle. The
	 * app should then call [FBAppCall handleOpenURL:sourceApplication:fallbackHandler:] to trigger the appropriate handling. Note
	 * that FBAppCall will first try to call the completion handler associated with this method, but since during an app switch,
	 * the calling app may be suspended or killed, the app must also give a fallbackHandler to the handleOpenURL: method in
	 * FBAppCall.
	 * 
	 * @param action The Open Graph action to be published. May not be nil.
	 * 
	 * @param actionType the fully-specified Open Graph action type of the action (e.g., my_app_namespace:my_action).
	 * 
	 * @param previewPropertyName the name of the property on the action that represents the primary Open Graph object associated
	 * with the action; this object will be displayed in the preview portion of the share dialog.
	 * 
	 * @param clientState An NSDictionary that's passed through when the completion handler is called. This is useful for the app
	 * to maintain state about the share request that was made so as to have appropriate action when the handler is called. May be
	 * nil.
	 * 
	 * @param handler A completion handler that may be called when the status update is complete. May be nil. If non-nil, the
	 * handler will always be called asynchronously.
	 * 
	 * @return An FBAppCall object that will also be passed into the provided FBAppCallCompletionHandler.
	 * 
	 * @discussion A non-nil FBAppCall object is only returned if the corresponding
	 * canPresentFBShareDialogWithOpenGraphActionParams method is also returning YES for the same params.
	 */
	// + (FBAppCall *)presentShareDialogWithOpenGraphAction:(id<FBOpenGraphAction>)action
	// actionType:(NSString *)actionType
	// previewPropertyName:(NSString *)previewPropertyName
	// clientState:(NSDictionary *)clientState
	// handler:(FBDialogAppCallCompletionHandler) handler;

}
