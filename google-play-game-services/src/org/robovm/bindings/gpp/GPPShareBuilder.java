
package org.robovm.bindings.gpp;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSObjectProtocol;
import org.robovm.cocoatouch.foundation.NSString;
import org.robovm.cocoatouch.foundation.NSURL;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.BindSelector;
import org.robovm.objc.annotation.NotImplemented;
import org.robovm.rt.bro.annotation.Callback;

public interface GPPShareBuilder extends NSObjectProtocol {

	public GPPShareBuilder setURLToShare (NSURL urlToShare);

	public GPPShareBuilder setPrefillText (NSString prefillText);

	public GPPShareBuilder setTitle (NSString title, NSString description, NSURL thumbnailURL);

	public boolean open ();

	// - (id<GPPShareBuilder>)setContentDeepLinkID:(NSString *)contentDeepLinkID;
	public GPPShareBuilder setContentDeepLinkID (NSString contentDeepLinkID);

// - (id<GPPShareBuilder>)setCallToActionButtonWithLabel:(NSString *)label
// URL:(NSURL *)url
// deepLinkID:(NSString *)deepLinkID;
	public GPPShareBuilder setCallToActionButtonWithLabel (NSString label, NSURL url, NSString deepLinkID);

	/** Extend this adapter to listen for events triggered by a GPPShare. */
	public static class Adapter extends NSObject implements GPPShareBuilder {

		@Override
		@NotImplemented("setURLToShare:")
		public GPPShareBuilder setURLToShare (NSURL urlToShare) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		@NotImplemented("setPrefillText:")
		public GPPShareBuilder setPrefillText (NSString prefillText) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		@NotImplemented("setTitle:description:thumbnailURL:")
		public GPPShareBuilder setTitle (NSString title, NSString description, NSURL thumbnailURL) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		@NotImplemented("open:")
		public boolean open () {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		@NotImplemented("setContentDeepLinkID:")
		public GPPShareBuilder setContentDeepLinkID (NSString contentDeepLinkID) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		@NotImplemented("setCallToActionButtonWithLabel:URL:deepLinkID:")
		public GPPShareBuilder setCallToActionButtonWithLabel (NSString label, NSURL url, NSString deepLinkID) {
			// TODO Auto-generated method stub
			return null;
		}

	}

	static class Callbacks {
		@Callback
		@BindSelector("setURLToShare:")
		public static GPPShareBuilder objc_setURLToShare (GPPShareBuilder __self__, Selector __cmd__, NSURL url) {
			return __self__.setURLToShare(url);
		}

		@Callback
		@BindSelector("setPrefillText:")
		public static GPPShareBuilder objc_setPrefillText (GPPShareBuilder __self__, Selector __cmd__, NSString prefillText) {
			return __self__.setPrefillText(prefillText);
		}

		@Callback
		@BindSelector("setTitle:description:thumbnailURL:")
		public static GPPShareBuilder objc_setTitle (GPPShareBuilder __self__, Selector __cmd__, NSString title,
			NSString description, NSURL thumbnailURL) {
			return __self__.setTitle(title, description, thumbnailURL);
		}

		@Callback
		@BindSelector("open:")
		public static boolean objc_open (GPPShareBuilder __self__, Selector __cmd__) {
			return __self__.open();
		}

		@Callback
		@BindSelector("setContentDeepLinkID:")
		public static boolean objc_setContentDeepLinkID (GPPShareBuilder __self__, Selector __cmd__, NSString contentDeepLinkID) {
			return __self__.open();
		}

		@Callback
		@BindSelector("setCallToActionButtonWithLabel:URL:deepLinkID:")
		public static GPPShareBuilder objc_setCallToActionButtonWithLabel (GPPShareBuilder __self__, Selector __cmd__,
			NSString label, NSURL url, NSString deepLinkID) {
			return __self__.setCallToActionButtonWithLabel(deepLinkID, url, deepLinkID);
		}
	}
}

// private static final ObjCClass objCClass = ObjCClass.getByType(GPPShareBuilder.class);
//
// static {
// ObjCRuntime.bind(GPPShareBuilder.class);
// }
//
//
// // METHODS \\
//
// // Sets the URL resource to be shared.
// //- (id<GPPShareBuilder>)setURLToShare:(NSURL *)urlToShare;
// private static final Selector setURLToShare$ = Selector.register("setURLToShare:");
// @Bridge private native static GPPShareBuilder objc_setURLToShare(GPPShareBuilder __self__, Selector __cmd__, NSURL url);
// public GPPShareBuilder setURLToShare(NSURL url) {
// return objc_setURLToShare(this, setURLToShare$, url);
// }
//
//
// // Sets the text to prefill user's comment in the share dialog.
// //- (id<GPPShareBuilder>)setPrefillText:(NSString *)prefillText;
// private static final Selector setPrefillText$ = Selector.register("setPrefillText:");
// @Bridge private native static GPPShareBuilder objc_setPrefillText(GPPShareBuilder __self__, Selector __cmd__, NSString
// prefillText);
// public GPPShareBuilder setPrefillText(NSString prefillText) {
// return objc_setPrefillText(this, setPrefillText$, prefillText);
// }
//
//
// // Sets the title, description, and thumbnail URL of the shared content preview
// // in the share dialog. Only set these fields if you are sharing with a content
// // deep link and don't have a URL resource. |title| is required.
// //- (id<GPPShareBuilder>)setTitle:(NSString *)title
// // description:(NSString *)description
// // thumbnailURL:(NSURL *)thumbnailURL;
// private static final Selector setTitle$ = Selector.register("setTitle:description:thumbnailURL:");
// @Bridge private native static GPPShareBuilder objc_setTitle(GPPShareBuilder __self__, Selector __cmd__,
// NSString title, NSString description, NSURL thumbnailURL);
// public GPPShareBuilder setTitle(NSString title, NSString description, NSURL thumbnailURL) {
// return objc_setTitle(this, setTitle$, title, description, thumbnailURL);
// }
//
// // Opens the share dialog. Returns |NO| if there was an error, |YES| otherwise.
// //- (BOOL)open;
// private static final Selector open$ = Selector.register("open");
// @Bridge private static native boolean objc_open(GPPShareBuilder __self__, Selector __cmd__);
// public boolean open(){
// return objc_open(this, open$);
// }
