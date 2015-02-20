//
//  Social.h
//  PAE_iOS_SDK
//
//  Created by shephertz technologies on 24/07/12.
//  Copyright (c) 2012 ShephertzTechnology PVT LTD. All rights reserved.
//

#import "App42Response.h"
/**
 *
 * This class Manage the response which comes from App42 server and set, get
 * values from the response.
 *
 */

@class FacebookProfile;
@class PublicProfile;

@interface Social : App42Response{
    
    NSString *userName;
    NSString *status;
    NSString *facebookAppId;
    NSString *facebookAppSecret;
    NSString *facebookAccessToken;
    NSString *twitterConsumerKey;
    NSString *twitterConsumerSecret;
    NSString *twitterAccessToken;
    NSString *twitterAccessTokenSecret;
    NSString *linkedinApiKey;
    NSString *linkedinSecretKey;
    NSString *linkedinAccessToken;
    NSString *linkedinAccessTokenSecret;
    NSMutableArray *friendsList;
    
}
/*!
 *set and get the user name for the social.
 */
@property(nonatomic,retain) NSString *userName;
/*!
 *set and get the status for the social.
 */
@property(nonatomic,retain) NSString *status;
/*!
 *set and get the app id for the Facebook.
 */
@property(nonatomic,retain) NSString *facebookAppId;
/*!
 *set and get the app secret for the Facebook.
 */
@property(nonatomic,retain) NSString *facebookAppSecret;
/*!
 *set and get the access token for the Facebook.
 */
@property(nonatomic,retain) NSString *facebookAccessToken;
/*!
 *set and get the consumer key for the Twitter.
 */
@property(nonatomic,retain) NSString *twitterConsumerKey;
/*!
 *set and get the consumer secret key for the Twitter.
 */
@property(nonatomic,retain) NSString *twitterConsumerSecret;
/*!
 *set and get the access token for the Twitter.
 */
@property(nonatomic,retain) NSString *twitterAccessToken;
/*!
 *set and get the access token secret for the Twitter.
 */
@property(nonatomic,retain) NSString *twitterAccessTokenSecret;
/*!
 *set and get the api key for the LinkedIn.
 */
@property(nonatomic,retain) NSString *linkedinApiKey;
/*!
 *set and get the secret key for the LinkedIn.
 */
@property(nonatomic,retain) NSString *linkedinSecretKey;
/*!
 *set and get the access token for the LinkedIn.
 */
@property(nonatomic,retain) NSString *linkedinAccessToken;
/*!
 *set and get the access token secret for the LinkedIn.
 */
@property(nonatomic,retain) NSString *linkedinAccessTokenSecret;

/*!
 *set and get friendsList.
 */
@property(nonatomic,retain) NSMutableArray *friendsList;

/*!
 *set and get facebookProfile.
 */
@property(nonatomic,retain) FacebookProfile *facebookProfile;

/*!
 *set and get publicProfile.
 */
@property(nonatomic,retain) NSMutableArray *publicProfile;
@end



