//
//  SimpleKeychain.h
//  controller_server
//
//  Created by Lou Zell on 7/29/11.
//  Copyright 2011 OpenKit. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface SimpleKeychain : NSObject

+ (void)store:(NSData *)str;
+ (NSData *)retrieve;
+ (void)clear;

@end
