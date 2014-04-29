//
//  OKMacros.h
//  OKClient
//
//  Created by Louis Zell on 1/27/13.
//  Copyright (c) 2013 OpenKit. All rights reserved.
//

#ifndef OKClient_OKMacros_h
#define OKClient_OKMacros_h

#ifdef DEBUG
    #define OKLog(s, ...)     NSLog(@"OpenKit: %@", [NSString stringWithFormat:(s), ##__VA_ARGS__])
    #define OKLogInfo(s, ...) NSLog(@"OpenKit:Info: %@", [NSString stringWithFormat:(s), ##__VA_ARGS__])
    #define OKLogErr(s, ...)  NSLog(@"OpenKit:Err: %@", [NSString stringWithFormat:(s), ##__VA_ARGS__])
#else
    #define OKLog(s, ...)     NSLog(@"OpenKit: %@", [NSString stringWithFormat:(s), ##__VA_ARGS__])
    #define OKLogInfo(...)    {} while (0)
    #define OKLogErr(s, ...)  NSLog(@"OpenKit:Err: %@", [NSString stringWithFormat:(s), ##__VA_ARGS__])
#endif


#define OK_CURRENT_APP_VERSION [[[NSBundle mainBundle] infoDictionary] objectForKey:@"CFBundleShortVersionString"]

#define OK_RAISE(name, ...) {\
    NSString *str = [NSString stringWithFormat:__VA_ARGS__]; \
    NSLog(@"Raising %@: %@", name, str); \
    [NSException raise:name format:str]; \
}

#ifdef  DEBUG
#define OKBridgeLog( s, ... ) NSLog(@"OKBridgeIOS: %@", [NSString stringWithFormat:(s), ##__VA_ARGS__])
#else
#define OKBridgeLog( s, ...) {} while (0)
#endif


// System Versioning
#define OK_SYSTEM_VERSION_EQUAL_TO(v)                  ([[[UIDevice currentDevice] systemVersion] compare:v options:NSNumericSearch] == NSOrderedSame)
#define OK_SYSTEM_VERSION_GREATER_THAN(v)              ([[[UIDevice currentDevice] systemVersion] compare:v options:NSNumericSearch] == NSOrderedDescending)
#define OK_SYSTEM_VERSION_GREATER_THAN_OR_EQUAL_TO(v)  ([[[UIDevice currentDevice] systemVersion] compare:v options:NSNumericSearch] != NSOrderedAscending)
#define OK_SYSTEM_VERSION_LESS_THAN(v)                 ([[[UIDevice currentDevice] systemVersion] compare:v options:NSNumericSearch] == NSOrderedAscending)
#define OK_SYSTEM_VERSION_LESS_THAN_OR_EQUAL_TO(v)     ([[[UIDevice currentDevice] systemVersion] compare:v options:NSNumericSearch] != NSOrderedDescending)

#endif
