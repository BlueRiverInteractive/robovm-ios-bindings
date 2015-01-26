//
//  Util.h
//  App42_iOS_SERVICE_API
//
//  Created by Shephertz Technology on 07/02/12.
//  Copyright (c) 2012 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface Utils : NSObject
{
    NSString *appErrorCode;
}

extern void APP42Log(NSString * format, ... ) NS_FORMAT_FUNCTION(1,2);

+(NSString*)getBaseURL;
+(void)setBaseURL:(NSString*)url;
+(NSString*)getCustomCodeURL;
+(NSString*)getAnalyticsURL;

+(NSString*)getLoggedInUser;
+(void)setLoggedInUser:(NSString*)user;

+(BOOL)isAppStateEventTrackingEnabled;
+(BOOL)isEventServiceEnabled;


+(void)setCacheStoragePolicy:(NSURLRequestCachePolicy)cachePolicy;
+(NSURLRequestCachePolicy)getCacheStoragePolicy;

+(NSString*)createSignatureFromDataDict:(NSMutableDictionary *)data andSecretKey:(NSString*)secretKey;
+(NSString*)getUTCTimeFormattedStamp;
+(NSString*)getUTCTimeFormattedStamp:(NSDate*)date;
+(NSString*)multipartRequestWithRequestName:(NSString*)name forFileWithPath:(NSString*)filePath queryParams:(NSMutableDictionary*)queryParams postParams:(NSMutableDictionary*)postParams headerParams:(NSMutableDictionary*)headerParams postUrl:(NSString*)postUrl;
+(NSString*)multipartRequestWithRequestName:(NSString*)name forFileData:(NSData*)fileData fileName:(NSString*)fileName queryParams:(NSMutableDictionary*)queryParams postParams:(NSMutableDictionary*)postParams headerParams:(NSMutableDictionary*)headerParams postUrl:(NSString*)postUrl;


+(NSString*)multipartRequestWithRequestName:(NSString*)name forFileWithPath:(NSString*)filePath queryParams:(NSMutableDictionary*)queryParams postParams:(NSMutableDictionary*)postParams postUrl:(NSString*)postUrl;
+(NSString*)multipartRequestWithRequestName:(NSString*)name forFileData:(NSData*)fileData fileName:(NSString*)fileName queryParams:(NSMutableDictionary*)queryParams postParams:(NSMutableDictionary*)postParams postUrl:(NSString*)postUrl;
+(void)throwExceptionIfNullOrBlank:(id)Obj :(NSString*)name;
+(void)validateMax:(int)max;
+(void)validateBadges:(int)badges;
+(void)throwExceptionIfEmailNotValid:(id)obj :(NSString*)name;
+(void)throwExceptionIfNotValidExtension:(NSString*)fileName name:(NSString*)name;
+(void)throwExceptionIfNotValidImageExtension:(NSString*)fileName name:(NSString*)name;
+(void)validateHowMany:(int)howMany;
+(void)enableApp42Log:(BOOL)isEnable;
+(void)throwExceptionIfStringIsNotAlphanumeric:(NSString*)obj objectName:(NSString*)name;
+(void)throwExceptionIfEventServiceNotEnabled;

@end

