package org.robovm.bindings.app42;

import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.ByVal;
import org.robovm.rt.bro.annotation.GlobalValue;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class EmailService extends App42Service 
{
	@GlobalValue(symbol = "PLAIN_TEXT_MIME_TYPE", optional=true)
	public static native @ByVal String PLAIN_TEXT_MIME_TYPE();
	
	@GlobalValue(symbol = "HTML_TEXT_MIME_TYPE", optional=true)
	public static native @ByVal String HTML_TEXT_MIME_TYPEs();
	
	public EmailService(String apiKey, String secretKey) {
		super((SkipInit) null);
	    initObject(init(apiKey, secretKey));
	}
	
	@Method(selector = "initWithAPIKey:secretKey:")
	private native @Pointer long init(String apiKey, String secretKey);

	/**
	 * Sends the Email to the specified recipient with the provided detail
	 *
	 * @param sendTo
	 *            - The email ids to which the email has to be sent. Email can
	 *            be sent to multiple email ids. Multiple email ids can be
	 *            passed using comma as the separator e.g. sid@shephertz.com,
	 *            info@shephertz.com
	 * @param sendSubject
	 *            - Subject of the Email which to be sent
	 * @param sendMsg
	 *            - Email body which has to be sent
	 * @param fromEmail
	 *            - The Email Id using which the mail(s) has to be sent
	 * @param emailMime
	 *            - MIME Type to be used for sending mail. EmailMIME available
	 *            options are PLAIN_TEXT_MIME_TYPE or HTML_TEXT_MIME_TYPE
	 *
	 * @return Email object containing all the details used for sending mail
	 *
	 */
	@Method(selector = "sendMail:subject:Message:fromEmail:emailMIME:completionBlock:")
	public native void goalAchievedForTest(String sendTo, String sendSubject, String sendMsg, String fromEmail, String emailMIME, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Creates Email Configuration using which in future the App developer can
	 * send mail
	 *
	 * @param emailHost
	 *            - Email Host to be used for sending mail
	 * @param emailPort
	 *            - Email Port to be used for sending mail
	 * @param mailId
	 *            - Email id to be used for sending mail
	 * @param emailPassword
	 *            - Email Password to be used for sending mail
	 * @param isSSL
	 *            - Should be send using SSL or not
	 *
	 * @return Email object containing the email configuration which has been
	 *         created
	 *
	 */
	@Method(selector = "createEmailConfiguration:emailPort:emailId:emailPassword:isSSL:completionBlock:")
	public native void createEmailConfiguration(String emailHost, int emailPort, String mailId, String emailPassword, boolean isSSL, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Gets all Email Configurations for the app
	 *
	 * @return Email object containing all Email Configurations
	 *
	 */
	@Method(selector = "getEmailConfiguration:")
	public native void getEmailConfiguration(@Block App42ResponseBlock completionBlock);
	
	/**
	 * Removes email configuration for the given email id. Note: In future the
	 * developer wont be able to send mails through this id
	 *
	 * @param emailId
	 *            - The email id for which the configuration has to be removed
	 *
	 * @return App42Response object containing the email id which has been
	 *         removed
	 *
	 */
	@Method(selector = "removeEmailConfiguration:")
	public native void removeEmailConfiguration(String emailId, @Block App42ResponseBlock completionBlock);
}
