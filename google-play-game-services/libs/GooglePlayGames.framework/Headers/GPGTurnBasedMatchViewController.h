//
// Google Play Games Platform Services
// Copyright 2013 Google Inc. All rights reserved.
//

#import <Foundation/Foundation.h>

#import "GPGMultiplayerConfig.h"

@class GPGTurnBasedMatch;
@class GPGTurnBasedMatchViewController;

@protocol GPGTurnBasedMatchViewControllerDelegate<NSObject>

- (void)turnBasedMatchViewController:(GPGTurnBasedMatchViewController *)controller
                        didJoinMatch:(GPGTurnBasedMatch *)match;
- (void)turnBasedMatchViewController:(GPGTurnBasedMatchViewController *)controller
                     didDeclineMatch:(GPGTurnBasedMatch *)match;
- (void)turnBasedMatchViewController:(GPGTurnBasedMatchViewController *)controller
                didTakeTurnWithMatch:(GPGTurnBasedMatch *)match;
- (void)turnBasedMatchViewController:(GPGTurnBasedMatchViewController *)controller
                          didRematch:(GPGTurnBasedMatch *)match;
- (void)turnBasedMatchViewController:(GPGTurnBasedMatchViewController *)controller
                   didTapMyTurnMatch:(GPGTurnBasedMatch *)match;
- (void)turnBasedMatchViewController:(GPGTurnBasedMatchViewController *)controller
                didTapTheirTurnMatch:(GPGTurnBasedMatch *)match;
- (void)turnBasedMatchViewController:(GPGTurnBasedMatchViewController *)controller
                didTapCompletedMatch:(GPGTurnBasedMatch *)match;
- (void)turnBasedMatchViewControllerDidFinish:(GPGTurnBasedMatchViewController *)controller;

@end

@interface GPGTurnBasedMatchViewController : UINavigationController

@property(nonatomic, assign) id<GPGTurnBasedMatchViewControllerDelegate> matchDelegate;

@property(nonatomic, retain) NSArray *matchListToDisplay;

@end
