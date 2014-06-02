//
//  MPIdentityProvider.m
//  MoPub
//
//  Copyright (c) 2013 MoPub. All rights reserved.
//

#import "MPIdentityProvider.h"
#import "MPGlobal.h"

#if __IPHONE_OS_VERSION_MAX_ALLOWED >= MP_IOS_6_0
#import <AdSupport/AdSupport.h>
#endif

#define MOPUB_IDENTIFIER_DEFAULTS_KEY @"com.mopub.identifier"

@interface MPIdentityProvider ()

+ (BOOL)deviceHasASIdentifierManager;

+ (NSString *)identifierFromASIdentifierManager:(BOOL)obfuscate;
+ (NSString *)mopubIdentifier:(BOOL)obfuscate;

@end

@implementation MPIdentityProvider

+ (BOOL)deviceHasASIdentifierManager
{
    return !!NSClassFromString(@"ASIdentifierManager");
}

+ (NSString *)identifier
{
    return [self _identifier:NO];
}

+ (NSString *)obfuscatedIdentifier
{
    return [self _identifier:YES];
}

+ (NSString *)_identifier:(BOOL)obfuscate
{
    if ([self deviceHasASIdentifierManager]) {
        return [self identifierFromASIdentifierManager:obfuscate];
    } else {
        return [self mopubIdentifier:obfuscate];
    }
}

+ (BOOL)advertisingTrackingEnabled
{
    BOOL enabled = YES;

    if ([self deviceHasASIdentifierManager]) {
#if __IPHONE_OS_VERSION_MAX_ALLOWED >= MP_IOS_6_0
        enabled = [[ASIdentifierManager sharedManager] isAdvertisingTrackingEnabled];
#endif
    }

    return enabled;
}

+ (NSString *)identifierFromASIdentifierManager:(BOOL)obfuscate
{
    if (obfuscate) {
        return @"ifa:XXXX";
    }
    
    NSString *identifier = nil;
#if __IPHONE_OS_VERSION_MAX_ALLOWED >= MP_IOS_6_0
    identifier = [[ASIdentifierManager sharedManager].advertisingIdentifier UUIDString];
#endif
    
    return [NSString stringWithFormat:@"ifa:%@", [identifier uppercaseString]];
}

+ (NSString *)mopubIdentifier:(BOOL)obfuscate
{
    if (obfuscate) {
        return @"mopub:XXXX";
    }

    NSString *identifier = [[NSUserDefaults standardUserDefaults] objectForKey:MOPUB_IDENTIFIER_DEFAULTS_KEY];
    if (!identifier) {
        CFUUIDRef uuidObject = CFUUIDCreate(kCFAllocatorDefault);
        NSString *uuidStr = (NSString *)CFUUIDCreateString(kCFAllocatorDefault, uuidObject);
        CFRelease(uuidObject);
        [uuidStr autorelease];

        identifier = [NSString stringWithFormat:@"mopub:%@", [uuidStr uppercaseString]];
        [[NSUserDefaults standardUserDefaults] setObject:identifier forKey:MOPUB_IDENTIFIER_DEFAULTS_KEY];
        [[NSUserDefaults standardUserDefaults] synchronize];
    }

    return identifier;
}

@end
