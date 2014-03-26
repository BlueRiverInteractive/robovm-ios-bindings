//
// Google Play Games Platform Services
// Copyright 2013 Google Inc. All rights reserved.
//

#import <Foundation/Foundation.h>

@class GPGPlayer;

@interface GPGPlayerModel : NSObject

- (GPGPlayer *)localPlayer;

- (NSArray *)recentlyPlayedPlayers;

@end
