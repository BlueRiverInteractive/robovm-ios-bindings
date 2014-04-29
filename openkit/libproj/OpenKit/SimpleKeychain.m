//
//  SimpleKeychain.m
//  controller_server
//
//  Created by Lou Zell on 7/29/11.
//  Copyright 2011 OpenKit. All rights reserved.
//

#import "SimpleKeychain.h"
#import <Security/Security.h>

static NSString *serviceName = @"com.openkit.clientSDK.OKcachedUserStore";
static NSString *keyIdentifier = @"currentOKUser";


@interface SimpleKeychain (Private)

+ (NSMutableDictionary *)newSearchDictionary;
+ (NSData *)searchKeychainCopyMatching;
+ (BOOL)createKeychainValue:(NSData *)password;
+ (BOOL)updateKeychainValue:(NSData *)password;
+ (void)deleteKeychainValue;

@end


@implementation SimpleKeychain

+ (void)store:(NSData *)data
{
  [self updateKeychainValue:data];
}

+ (NSData *)retrieve
{
  return [[self searchKeychainCopyMatching] autorelease];
}

+ (void)clear
{
  [self deleteKeychainValue]; 
}

#pragma mark Private
+ (NSMutableDictionary *)newSearchDictionary
{
  NSMutableDictionary *searchDictionary = [[NSMutableDictionary alloc] init];  
	
  [searchDictionary setObject:(id)kSecClassGenericPassword forKey:(id)kSecClass];
	
  NSData *encodedIdentifier = [keyIdentifier dataUsingEncoding:NSUTF8StringEncoding];
  [searchDictionary setObject:encodedIdentifier forKey:(id)kSecAttrGeneric];
  [searchDictionary setObject:encodedIdentifier forKey:(id)kSecAttrAccount];
  [searchDictionary setObject:serviceName forKey:(id)kSecAttrService];
	
  return searchDictionary; 
}

// Returned NSData needs to be released.
+ (NSData *)searchKeychainCopyMatching
{
  OSStatus status;
  NSMutableDictionary *searchDictionary = [self newSearchDictionary];
	
  // Add search attributes
  [searchDictionary setObject:(id)kSecMatchLimitOne forKey:(id)kSecMatchLimit];
	
  // Add search return types
  [searchDictionary setObject:(id)kCFBooleanTrue forKey:(id)kSecReturnData];
  
  NSData *returnData = nil;
  status = SecItemCopyMatching((CFDictionaryRef)searchDictionary, (CFTypeRef *)&returnData);
  [searchDictionary release];
  
  if(status == errSecItemNotFound) {
    return nil;
  }

  return returnData;
}

+ (BOOL)createKeychainValue:(NSData *)data
{
  NSMutableDictionary *dictionary = [self newSearchDictionary];
  
  [dictionary setObject:data forKey:(id)kSecValueData];
	
  OSStatus status = SecItemAdd((CFDictionaryRef)dictionary, NULL);
  NSAssert(status == noErr, @"Couldn't create keychain value");

  [dictionary release];
	
  return (status == errSecSuccess);
}

+ (BOOL)updateKeychainValue:(NSData *)data
{
  NSMutableDictionary *searchDictionary = [self newSearchDictionary];
  NSMutableDictionary *updateDictionary = [[NSMutableDictionary alloc] init];
  [updateDictionary setObject:data forKey:(id)kSecValueData];
	
  OSStatus status = SecItemUpdate((CFDictionaryRef)searchDictionary,
                                  (CFDictionaryRef)updateDictionary);
  
  [searchDictionary release];
  [updateDictionary release];
  
  if (status == errSecItemNotFound) {
    // Should be doing a create.
    return [self createKeychainValue:data];
  }

  return (status == errSecSuccess);
}

+ (void)deleteKeychainValue
{
  NSMutableDictionary *searchDictionary = [self newSearchDictionary];
  SecItemDelete((CFDictionaryRef)searchDictionary);
  [searchDictionary release];
}


@end
