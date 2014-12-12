//
// Google Play Games Platform Services
// Copyright 2013 Google Inc. All rights reserved.
//
#import <Foundation/Foundation.h>

typedef void (^GPGModelDidLoadBlock)(NSError *error);

@interface GPGKeyedModel : NSObject

#pragma mark Querying Data 

- (void)loadDataForKey:(NSString *)key __attribute__ ((deprecated));
- (void)loadDataForKey:(NSString *)key completionHandler:(GPGModelDidLoadBlock)completionHandler
    __attribute__ ((deprecated));

- (void)reloadDataForKey:(NSString *)key __attribute__ ((deprecated));

- (void)reloadDataForKey:(NSString *)key completionHandler:(GPGModelDidLoadBlock)completionHandler
    __attribute__ ((deprecated));

- (BOOL)isLoadingDataForKey:(NSString *)key __attribute__ ((deprecated));
- (BOOL)isDataLoadedForKey:(NSString *)key __attribute__ ((deprecated));
- (NSError *)errorFromLoadingDataForKey:(NSString *)key __attribute__ ((deprecated));

@end
