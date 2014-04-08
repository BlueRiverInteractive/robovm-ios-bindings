
package org.robovm.apple.temp;

import org.robovm.apple.uikit.UINavigationController;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCObject;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

@Library("MessageUI")
@NativeClass
public class MFMessageComposeViewController extends UINavigationController {
	static {
		ObjCRuntime.bind(MFMessageComposeViewController.class);
	}

	private static final ObjCClass objCClass = ObjCClass.getByType(MFMessageComposeViewController.class);

	// + (BOOL)canSendText __OSX_AVAILABLE_STARTING(__MAC_NA,__IPHONE_4_0);
	private static final Selector canSendText = Selector.register("canSendText");

	@Bridge
	private native static boolean objc_canSendText (ObjCClass __self__, Selector __cmd__);

	public static boolean canSendText () {
		return objc_canSendText(objCClass, canSendText);
	}

	// @property(nonatomic,assign) id<MFMessageComposeViewControllerDelegate> messageComposeDelegate
	// /*__OSX_AVAILABLE_STARTING(__MAC_NA,__IPHONE_4_0)*/;
	private static final Selector messageComposeDelegate = Selector.register("messageComposeDelegate");

	@Bridge
	private native static MFMessageComposeViewControllerDelegate objc_getMessageComposeDelegate (
		MFMessageComposeViewController __self__, Selector __cmd__);

	public MFMessageComposeViewControllerDelegate getMessageComposeDelegate () {
		return objc_getMessageComposeDelegate(this, messageComposeDelegate);
	}

	private static final Selector setMessageComposeDelegate = Selector.register("setMessageComposeDelegate:");

	@Bridge
	private native static MFMessageComposeViewControllerDelegate objc_setMessageComposeDelegate (
		MFMessageComposeViewController __self__, Selector __cmd__, MFMessageComposeViewControllerDelegate delegate);

	public void setMessageComposeDelegate (MFMessageComposeViewControllerDelegate delegate) {
		addStrongRef((ObjCObject)delegate);
		objc_setMessageComposeDelegate(this, setMessageComposeDelegate, delegate);
	}

	// @property(nonatomic,copy) NSString *body;
	private static final Selector getBody = Selector.register("body");

	@Bridge
	private native static String objc_getBody (MFMessageComposeViewController __self__, Selector __cmd__);

	public String getBody () {
		return objc_getBody(this, getBody);
	}

	private static final Selector setBody = Selector.register("setBody:");

	@Bridge
	private native static void objc_setBody (MFMessageComposeViewController __self__, Selector __cmd__, String body);

	public void setBody (String body) {
		objc_setBody(this, setBody, body);
	}
}
