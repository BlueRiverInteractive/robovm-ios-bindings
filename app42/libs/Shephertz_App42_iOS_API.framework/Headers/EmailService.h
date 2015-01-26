//
//  EmailService.h
//  App42_iOS_SERVICE_APIs
//
//  Created by shephertz technologies on 11/02/12.
//  Copyright (c) 2012 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "App42Service.h"

@class Email;

/**
 * Constants value for text/plain or text/html EmailMIME.
 *
 *
 */
extern NSString *const PLAIN_TEXT_MIME_TYPE;
extern NSString *const HTML_TEXT_MIME_TYPE;

/**
 *
 * Service to send Email
 *
 * @see Email
 */
@interface EmailService : App42Service
{
        
}

-(id)init __attribute__((unavailable));
-(id)initWithAPIKey:(NSString *)apiKey  secretKey:(NSString *)secretKey;

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

-(void)sendMail: (NSString*)sendTo subject:(NSString*)sendSubject Message:(NSString*)sendMsg fromEmail:(NSString*)fromEmail emailMIME:(NSString*)emailMIME completionBlock:(App42ResponseBlock)completionBlock;
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
-(void)createEmailConfiguration:(NSString*)emailHost emailPort:(int)emailPort emailId:(NSString*)mailId emailPassword:(NSString*)emailPassword isSSL:(BOOL)isSSL completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Gets all Email Configurations for the app
 *
 * @return Email object containing all Email Configurations
 *
 */
-(void)getEmailConfiguration:(App42ResponseBlock)completionBlock;
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
-(void)removeEmailConfiguration:(NSString*)emailId completionBlock:(App42ResponseBlock)completionBlock;

@end
