//
//  OKFileUtil.m
//  OpenKit
//
//  Created by Louis Zell on 8/21/13.
//  Copyright (c) 2013 OpenKit. All rights reserved.
//

#import "OKFileUtil.h"
#import "OKMacros.h"

@implementation OKFileUtil


+ (BOOL)createDir:(NSString *)path
{
    return [self createDir:path skipBackup:NO];
}

+ (BOOL)createDir:(NSString *)path skipBackup:(BOOL)skipBackup
{
    NSError *err = nil;
    if (![[NSFileManager defaultManager] createDirectoryAtPath:path withIntermediateDirectories:YES attributes:nil error:&err]) {
        OKLogErr(@"%@", err.localizedDescription);
        return NO;
    }

    if (skipBackup) {
        NSURL *u = [NSURL fileURLWithPath:path];
        if (![u setResourceValue:[NSNumber numberWithBool:YES] forKey:NSURLIsExcludedFromBackupKey error:&err]) {
            OKLogErr(@"Error excluding %@ from backup %@", u.lastPathComponent, err.localizedDescription);
        }
    }
    return YES;
}


+ (NSString *)localOnlyCachePath
{
    NSString *p1, *p2;
    p1 = [self applicationSupportPath];
    if (p1 == nil)
        return nil;

    p2 = [p1 stringByAppendingPathComponent:@"OpenKit"];
    BOOL isDir;
    if (![[NSFileManager defaultManager] fileExistsAtPath:p2 isDirectory:&isDir]) {
        if (![self createDir:p2 skipBackup:YES]) {
            OKLogErr(@"Could not create local only cache directory.");
        }
    }
    return p2;
}


+ (NSString *)applicationSupportPath
{
    NSArray *arr = NSSearchPathForDirectoriesInDomains(NSApplicationSupportDirectory, NSUserDomainMask, YES);
    NSString *p = [arr lastObject];
    BOOL isDir;
    if (![[NSFileManager defaultManager] fileExistsAtPath:p isDirectory:&isDir]) {
        if (![self createDir:p]) {
            OKLogErr(@"Could not create application support directory.");
            p = nil;
        }
    }
    return p;
}

@end
