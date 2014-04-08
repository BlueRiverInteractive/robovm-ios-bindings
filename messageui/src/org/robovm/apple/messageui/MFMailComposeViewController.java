
package org.robovm.apple.messageui;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSData;
import org.robovm.apple.uikit.UINavigationController;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.ObjCSuper;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

@Library("MessageUI")
@NativeClass
public class MFMailComposeViewController extends UINavigationController {
	private static final ObjCClass objCClass = ObjCClass.getByType(MFMailComposeViewController.class);

	static {
		ObjCRuntime.bind(MFMailComposeViewController.class);
	}

	// + (BOOL)canSendMail __OSX_AVAILABLE_STARTING(__MAC_NA,__IPHONE_3_0);
	private static final Selector canSendMail = Selector.register("canSendMail");

	@Bridge
	private native static boolean objc_canSendMail (ObjCClass __self__, Selector __cmd__);

	/** @method canSendMail
	 * @abstract Returns <tt>YES</tt> if the user has set up the device for sending email.
	 * @discussion The client may continue to set the recipients and content if the return value was <tt>YES</tt>. If <tt>NO</tt>
	 *             was the result, the client has a couple options. It may choose to simply notify the user of the inability to
	 *             send mail, or it may issue a "mailto" URL via <tt>-[UIApplication openURL:]</tt>. */
	public static boolean canSendMail () {
		return objc_canSendMail(objCClass, canSendMail);
	}

	// @property(nonatomic,assign) id<MFMailComposeViewControllerDelegate> mailComposeDelegate
// /*__OSX_AVAILABLE_STARTING(__MAC_NA,__IPHONE_3_0)*/;
	private static final Selector setMailComposeDelegate = Selector.register("setMailComposeDelegate:");

	@Bridge
	private native static void objc_setMailComposeDelegate (MFMailComposeViewController __self__, Selector __cmd__,
		MFMailComposeViewControllerDelegate delegate);

	@Bridge
	private native static void objc_setMailComposeDelegateSuper (ObjCSuper __super__, Selector __cmd__,
		MFMailComposeViewControllerDelegate delegate);

	/** @property mailComposeDelegate
	 * @abstract This property is the delegate for the MFMailComposeViewControllerDelegate method callbacks. */
	public void setMailComposeDelegate (MFMailComposeViewControllerDelegate delegate) {
		if (customClass) {
			objc_setMailComposeDelegateSuper(getSuper(), setMailComposeDelegate, delegate);
		} else {
			objc_setMailComposeDelegate(this, setMailComposeDelegate, delegate);
		}
	}

	// - (void)setSubject:(NSString *)subject __OSX_AVAILABLE_STARTING(__MAC_NA,__IPHONE_3_0);
	private static final Selector setSubject = Selector.register("setSubject:");

	@Bridge
	private native static void objc_setSubject (MFMailComposeViewController __self__, Selector __cmd__, String subject);

	@Bridge
	private native static void objc_setSubjectSuper (ObjCSuper __super__, Selector __cmd__, String subject);

	/** @method setSubject:
	 * @abstract This method sets the Subject header for the email message.
	 * @discussion This method will set the Subject header for the email message. This should be called prior to display. Newlines
	 *             are removed from the parameter. </p>After the view has been presented to the user, this method will no longer
	 *             change the value.
	 * @param subject A NSString specifying the message's Subject header. */
	public void setSubject (String subject) {
		if (customClass) {
			objc_setSubjectSuper(getSuper(), setSubject, subject);
		} else {
			objc_setSubject(this, setSubject, subject);
		}
	}

	// - (void)setToRecipients:(NSArray *)toRecipients __OSX_AVAILABLE_STARTING(__MAC_NA,__IPHONE_3_0);
	private static final Selector setToRecipients = Selector.register("setToRecipients:");

	@SuppressWarnings("rawtypes")
	@Bridge
	private native static void objc_setToRecipients (MFMailComposeViewController __self__, Selector __cmd__, NSArray toRecipients);

	@SuppressWarnings("rawtypes")
	@Bridge
	private native static void objc_setToRecipientsSuper (ObjCSuper __super__, Selector __cmd__, NSArray toRecipients);

	/** @method setToRecipients:
	 * @abstract This method sets the To header for the email message to the specified email addresses.
	 * @discussion This method will set the To header for the email message. This should be called prior to display. </p>Recipient
	 *             addresses should be specified as per RFC5322. </p>After the view has been presented to the user, this method
	 *             will no longer change the value.
	 * @param toRecipients A NSArray of NSString instances specifying the email addresses of recipients. */
	@SuppressWarnings("rawtypes")
	public void setToRecipients (NSArray toRecipients) {
		if (customClass) {
			objc_setToRecipientsSuper(getSuper(), setToRecipients, toRecipients);
		} else {
			objc_setToRecipients(this, setToRecipients, toRecipients);
		}
	}

	// - (void)setCcRecipients:(NSArray *)ccRecipients __OSX_AVAILABLE_STARTING(__MAC_NA,__IPHONE_3_0);
	private static final Selector setCcRecipients = Selector.register("setCcRecipients:");

	@SuppressWarnings("rawtypes")
	@Bridge
	private native static void objc_setCcRecipients (MFMailComposeViewController __self__, Selector __cmd__, NSArray ccRecipients);

	@SuppressWarnings("rawtypes")
	@Bridge
	private native static void objc_setCcRecipientsSuper (ObjCSuper __super__, Selector __cmd__, NSArray ccRecipients);

	/** @method setCcRecipients:
	 * @abstract This method sets the CC header for the email message to the specified email addresses.
	 * @discussion This method will set the CC header for the email message. This should be called prior to display. </p>Recipient
	 *             addresses should be specified as per RFC5322. </p>After the view has been presented to the user, this method
	 *             will no longer change the value.
	 * @param ccRecipients A NSArray of NSString instances specifying the email addresses of recipients. */
	@SuppressWarnings("rawtypes")
	public void setCcRecipients (NSArray ccRecipients) {
		if (customClass) {
			objc_setCcRecipientsSuper(getSuper(), setCcRecipients, ccRecipients);
		} else {
			objc_setCcRecipients(this, setCcRecipients, ccRecipients);
		}
	}

	// - (void)setBccRecipients:(NSArray *)bccRecipients __OSX_AVAILABLE_STARTING(__MAC_NA,__IPHONE_3_0);
	private static final Selector setBccRecipients = Selector.register("setBccRecipients:");

	@SuppressWarnings("rawtypes")
	@Bridge
	private native static void objc_setBccRecipients (MFMailComposeViewController __self__, Selector __cmd__, NSArray bccRecipients);

	@SuppressWarnings("rawtypes")
	@Bridge
	private native static void objc_setBccRecipientsSuper (ObjCSuper __super__, Selector __cmd__, NSArray bccRecipients);

	/** @method setBccRecipients:
	 * @abstract This method sets the BCC header for the email message to the specified email addresses.
	 * @discussion This method will set the BCC header for the email message. This should be called prior to display. </p>Recipient
	 *             addresses should be specified as per RFC5322. </p>After the view has been presented to the user, this method
	 *             will no longer change the value.
	 * @param bccRecipients A NSArray of NSString instances specifying the email addresses of recipients. */
	@SuppressWarnings("rawtypes")
	public void setBccRecipients (NSArray bccRecipients) {
		if (customClass) {
			objc_setBccRecipientsSuper(getSuper(), setBccRecipients, bccRecipients);
		} else {
			objc_setBccRecipients(this, setBccRecipients, bccRecipients);
		}
	}

	// - (void)setMessageBody:(NSString *)body isHTML:(BOOL)isHTML __OSX_AVAILABLE_STARTING(__MAC_NA,__IPHONE_3_0);
	private static final Selector setMessageBody = Selector.register("setMessageBody:isHTML:");

	@Bridge
	private native static void objc_setMessageBody (MFMailComposeViewController __self__, Selector __cmd__, String body,
		boolean isHTML);

	@Bridge
	private native static void objc_setMessageBodySuper (ObjCSuper __super__, Selector __cmd__, String body, boolean isHTML);

	/** @method setMessageBody:isHTML:
	 * @abstract This method sets the body of the email message to the specified content.
	 * @discussion This method will set the body of the email message. This should be called prior to display. The user's
	 *             signature, if specified, will be added after the body content.
	 * @param body A NSString containing the body contents of the email message.
	 * @param isHTML A boolean value indicating if the body argument is to be interpreted as HTML content. */
	public void setMessageBody (String body, boolean isHTML) {
		if (customClass) {
			objc_setMessageBodySuper(getSuper(), setMessageBody, body, isHTML);
		} else {
			objc_setMessageBody(this, setMessageBody, body, isHTML);
		}
	}

	// - (void)addAttachmentData:(NSData *)attachment mimeType:(NSString *)mimeType fileName:(NSString *)filename
// __OSX_AVAILABLE_STARTING(__MAC_NA,__IPHONE_3_0);
	private static final Selector addAttachmentData = Selector.register("addAttachmentData:mimeType:fileName:");

	@Bridge
	private native static void objc_addAttachmentData (MFMailComposeViewController __self__, Selector __cmd__, NSData attachment,
		String mimeType, String filename);

	@Bridge
	private native static void objc_addAttachmentDataSuper (ObjCSuper __super__, Selector __cmd__, NSData attachment,
		String mimeType, String filename);

	/** @method addAttachmentData:mimeType:fileName:
	 * @abstract This method adds the specified attachment to the email message.
	 * @discussion This method adds the specified attachment to the email message. This should be called prior to display.
	 *             Attachments will be appended to the end of the message.
	 * @param attachment NSData containing the contents of the attachment. Must not be <tt>nil</tt>.
	 * @param mimeType NSString specifying the MIME type for the attachment, as specified by the IANA
	 *           (http://www.iana.org/assignments/media-types/). Must not be <tt>nil</tt>.
	 * @param filename NSString specifying the intended filename for the attachment. This is displayed below the attachment's icon
	 *           if the attachment is not decoded when displayed. Must not be <tt>nil</tt>. */
	public void addAttachmentData (NSData attachment, String mimeType, String filename) {
		if (customClass) {
			objc_addAttachmentDataSuper(getSuper(), setMessageBody, attachment, mimeType, filename);
		} else {
			objc_addAttachmentData(this, setMessageBody, attachment, mimeType, filename);
		}
	}

}
