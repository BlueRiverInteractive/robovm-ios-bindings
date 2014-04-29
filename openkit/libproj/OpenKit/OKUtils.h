//
//  OKUtils.h
//  OpenKit
//
//  Created by Louis Zell on 6/16/13.
//  Copyright (c) 2013 OpenKit. All rights reserved.
//

#import <Foundation/Foundation.h>

void OKEncodeObj(id obj, NSString **strOut, NSError **errOut);
id OKDecodeObj(NSData *dataIn, NSError **errOut);

@interface OKUtils : NSObject
+ (NSString *)createUUID;
+ (NSString *)sqlStringFromDate:(NSDate *)date;
@end

