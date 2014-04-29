//
//  OKFileUtil.h
//  OpenKit
//
//  Created by Louis Zell on 8/21/13.
//  Copyright (c) 2013 OpenKit. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface OKFileUtil : NSObject

+ (BOOL)createDir:(NSString *)path;
+ (BOOL)createDir:(NSString *)path skipBackup:(BOOL)skipBackup;
+ (NSString *)applicationSupportPath;

// Does not sync with iCloud or iTunes.
+ (NSString *)localOnlyCachePath;

@end
