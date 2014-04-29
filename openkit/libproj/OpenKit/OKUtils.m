//
//  OKUtils.m
//  OpenKit
//
//  Created by Louis Zell on 6/16/13.
//  Copyright (c) 2013 OpenKit. All rights reserved.
//

#import "OKUtils.h"

void OKEncodeObj(id obj, NSString **strOut, NSError **errOut)
{
    NSData *jsonData = [NSJSONSerialization dataWithJSONObject:obj options:0 error:errOut];
    if (!*errOut) {
        *strOut = [[NSString alloc] initWithData:jsonData encoding:NSUTF8StringEncoding];
        NSLog(@"Json is: %@", *strOut);
    }
}

id OKDecodeObj(NSData *dataIn, NSError **errOut)
{
    NSJSONReadingOptions opts = NSJSONReadingAllowFragments | NSJSONReadingMutableContainers | NSJSONReadingMutableLeaves;
    return [NSJSONSerialization JSONObjectWithData:dataIn options:opts error:errOut];
}

@implementation OKUtils

+ (NSString *)createUUID
{
    CFUUIDRef theUUID = CFUUIDCreate(NULL);
    CFStringRef string = CFUUIDCreateString(NULL, theUUID);
    CFRelease(theUUID);
    return (__bridge NSString *)string;
}

+ (NSString *)sqlStringFromDate:(NSDate *)date
{
    NSDateFormatter *dateFormatter = [[NSDateFormatter alloc] init];
    [dateFormatter setDateFormat: @"yyyy-MM-dd HH:mm:ss"];
    [dateFormatter setTimeZone: [NSTimeZone timeZoneWithName:@"UTC"]];
    return [dateFormatter stringFromDate:date];
}


@end

