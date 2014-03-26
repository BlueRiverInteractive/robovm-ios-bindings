//
// Google Play Games Platform Services
// Copyright 2013 Google Inc. All rights reserved.
//
#import <UIKit/UIKit.h>

@interface GPGPlayer : NSObject

@property(nonatomic, readonly, copy) NSURL *avatarUrl;

@property(nonatomic, readonly, copy) NSString *name;

@property(nonatomic, readonly, copy) NSString *playerId;

@end

