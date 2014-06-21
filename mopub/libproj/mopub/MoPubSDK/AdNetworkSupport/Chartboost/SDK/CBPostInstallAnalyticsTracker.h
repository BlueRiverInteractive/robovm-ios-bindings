//
//  CBPostInstallAnalyticsTracker.h
//  Chartboost
//  VERSION
//
//  Copyright 2011 Chartboost. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <StoreKit/StoreKit.h>

@interface CBPostInstallAnalyticsTracker:NSObject

+ (CBPostInstallAnalyticsTracker *) shared;

- (void)trackInAppPurchaseEvent:(NSData *)receipt product:(SKProduct *)product;

@end