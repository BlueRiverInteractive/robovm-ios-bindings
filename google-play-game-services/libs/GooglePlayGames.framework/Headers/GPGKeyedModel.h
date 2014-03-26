//
// Google Play Games Platform Services
// Copyright 2013 Google Inc. All rights reserved.
//

#import <Foundation/Foundation.h>

typedef void (^GPGModelDidLoadBlock)(NSError *error);

@interface GPGKeyedModel : NSObject

#pragma mark Querying Data 

- (void)loadDataForKey:(NSString *)key;
// Executes the completion handler immediately if the data is already loaded.
- (void)loadDataForKey:(NSString *)key completionHandler:(GPGModelDidLoadBlock)completionHandler;

- (void)reloadDataForKey:(NSString *)key;
- (void)reloadDataForKey:(NSString *)key completionHandler:(GPGModelDidLoadBlock)completionHandler;

- (BOOL)isLoadingDataForKey:(NSString *)key;
- (BOOL)isDataLoadedForKey:(NSString *)key;
- (NSError *)errorFromLoadingDataForKey:(NSString *)key;

@end
