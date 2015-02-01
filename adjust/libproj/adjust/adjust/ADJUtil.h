//
//  ADJUtil.h
//  Adjust
//
//  Created by Christian Wellenbrock on 2013-07-05.
//  Copyright (c) 2013 adjust GmbH. All rights reserved.
//
#import <Foundation/Foundation.h>

@interface ADJUtil : NSObject

+ (NSString *)baseUrl;
+ (NSString *)clientSdk;

+ (void)excludeFromBackup:(NSString *)filename;
+ (NSString *)formatSeconds1970:(double)value;
+ (NSString *)formatDate:(NSDate *)value;
+ (NSDictionary *) buildJsonDict:(NSString *)jsonString;

+ (NSString *)getFullFilename:(NSString *) baseFilename;

+ (id)readObject:(NSString *)filename
      objectName:(NSString *)objectName
           class:(Class) classToRead;

+ (void)writeObject:(id)object
           filename:(NSString *)filename
         objectName:(NSString *)objectName;

+ (NSString *) queryString:(NSDictionary *)parameters;
@end
