
package org.robovm.bindings.gpp;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSString;
import org.robovm.cocoatouch.foundation.NSURL;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
@NativeClass()
public class GPPShareBuilderImpl extends NSObject implements GPPShareBuilder {

	static {
		ObjCRuntime.bind();
	}

	private static final Selector setURLToShare$ = Selector.register("setURLToShare:");

	@Bridge
	private native static GPPShareBuilderImpl objc_setURLToShare (GPPShareBuilderImpl __self__, Selector __cmd__, NSURL url);

	@Override
	public GPPShareBuilderImpl setURLToShare (NSURL urlToShare) {
		return objc_setURLToShare(this, setURLToShare$, urlToShare);
	}

	// Sets the text to prefill user's comment in the share dialog.
	// - (id<GPPShareBuilder>)setPrefillText:(NSString *)prefillText;
	private static final Selector setPrefillText$ = Selector.register("setPrefillText:");

	@Bridge
	private native static GPPShareBuilderImpl objc_setPrefillText (GPPShareBuilderImpl __self__, Selector __cmd__,
		NSString prefillText);

	@Override
	public GPPShareBuilderImpl setPrefillText (NSString prefillText) {
		return objc_setPrefillText(this, setPrefillText$, prefillText);
	}

	// Sets the title, description, and thumbnail URL of the shared content preview
	// in the share dialog. Only set these fields if you are sharing with a content
	// deep link and don't have a URL resource. |title| is required.
// - (id<GPPShareBuilder>)setTitle:(NSString *)title
// description:(NSString *)description
// thumbnailURL:(NSURL *)thumbnailURL;
	private static final Selector setTitle$ = Selector.register("setTitle:description:thumbnailURL:");

	@Bridge
	private native static GPPShareBuilderImpl objc_setPrefillText (GPPShareBuilderImpl __self__, Selector __cmd__, NSString title,
		NSString description, NSURL thumbnailURL);

	@Override
	public GPPShareBuilderImpl setTitle (NSString title, NSString description, NSURL thumbnailURL) {
		return objc_setPrefillText(this, setTitle$, title, description, thumbnailURL);
	}

	// - (BOOL)open;
	private static final Selector open$ = Selector.register("open");

	@Bridge
	private static native boolean objc_open (GPPShareBuilderImpl __self__, Selector __cmd__);

	@Override
	public boolean open () {
		return objc_open(this, open$);
	}

	// - (id<GPPShareBuilder>)setContentDeepLinkID:(NSString *)contentDeepLinkID;
	private static final Selector setContentDeepLinkID$ = Selector.register("setContentDeepLinkID:");

	@Bridge
	private native static GPPShareBuilderImpl objc_setContentDeepLinkID (GPPShareBuilderImpl __self__, Selector __cmd__,
		NSString contentDeepLinkID);

	@Override
	public GPPShareBuilder setContentDeepLinkID (NSString contentDeepLinkID) {
		return objc_setPrefillText(this, setContentDeepLinkID$, contentDeepLinkID);
	}

	private static final Selector setCallToActionButtonWithLabel$ = Selector
		.register("setCallToActionButtonWithLabel:URL:deepLinkID:");

	@Bridge
	private native static GPPShareBuilderImpl objc_setCallToActionButtonWithLabel (GPPShareBuilderImpl __self__, Selector __cmd__,
		NSString label, NSURL url, NSString deepLinkID);

	/** Sets the call-to-action button of the shared content preview. The call-to-action button consists of a label, URL, and
	 * deep-link ID. The |label| is a string key defined under "data-calltoactionlabel" on
	 * http://developers.google.com/+/web/share/interactive#button_attr_calltoactionlabel that maps to the actual button text. The
	 * |url| is where the user is taken to after tapping on the button. The optional |deepLinkID| is the call-to-action deep-link
	 * ID that takes the user straight to a specific action in your app. It can either be a fully qualified URI, or URI path, which
	 * can be up to 512 characters in length. Note: In order to set the call-to-action button: 1. User must have been authenticated
	 * with scopes including "https://www.googleapis.com/auth/plus.login". 2. |setURLToShare:| must also be called. -
	 * (id<GPPShareBuilder>)setCallToActionButtonWithLabel:(NSString *)label URL:(NSURL *)url deepLinkID:(NSString *)deepLinkID; */
	@Override
	public GPPShareBuilderImpl setCallToActionButtonWithLabel (NSString label, NSURL url, NSString deepLinkID) {
		return objc_setCallToActionButtonWithLabel(this, setCallToActionButtonWithLabel$, label, url, deepLinkID);
	}
}
