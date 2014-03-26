//
// Google Play Games Platform Services
// Copyright 2013 Google Inc. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "GPGEnums.h"

@class GPGTurnBasedMatch;

@interface GPGTurnBasedModel : NSObject

- (NSArray *)allMatches;

- (NSArray *)matchesForMatchStatus:(GPGTurnBasedMatchStatus)status;

- (NSArray *)matchesForUserMatchStatus:(GPGTurnBasedUserMatchStatus)status;

- (GPGTurnBasedMatch *)matchForId:(NSString *)matchId;

@end
