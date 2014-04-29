//
//  OKHelper.h
//  OKClient
//
//  Created by Suneet Shah on 1/7/13.
//  Copyright (c) 2013 OpenKit. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface OKHelper : NSObject

+ (NSDate *)dateNDaysFromToday:(int)n;

+(int)getIntSafeForKey:(NSString *)key fromJSONDictionary:(NSDictionary*)jsonDict;
+(int64_t)getInt64SafeForKey:(NSString *)key fromJSONDictionary:(NSDictionary*)jsonDict;
+(BOOL)getBOOLSafeForKey:(NSString *)key fromJSONDictionary:(NSDictionary*)jsonDict;
+(NSArray*)getNSArraySafeForKey:(NSString*)key fromJSONDictionary:(NSDictionary*)jsonDict;
+(NSString*)getNSStringSafeForKey:(NSString*)key fromJSONDictionary:(NSDictionary*)jsonDict;
+(NSNumber*)getNSNumberSafeForKey:(NSString*)key fromJSONDictionary:(NSDictionary*)jsonDict;
+(NSDictionary*)getNSDictionarySafeForKey:(NSString*)key fromJSONDictionary:(NSDictionary*)jsonDict;
+(NSString*)getPathToDocsDirectory;
+(BOOL)isEmpty:(id)obj;

@end
