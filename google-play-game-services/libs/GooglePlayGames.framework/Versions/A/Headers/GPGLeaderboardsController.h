//
// Google Play Games Platform Services
// Copyright 2013 Google Inc. All rights reserved.
//

#import <UIKit/UIKit.h>

@protocol GPGLeaderboardsControllerDelegate;

@interface GPGLeaderboardsController : UINavigationController

@property (nonatomic, readwrite, assign) id<GPGLeaderboardsControllerDelegate> leaderboardsDelegate;

@end

@protocol GPGLeaderboardsControllerDelegate <NSObject>
@required

- (void)leaderboardsViewControllerDidFinish:(GPGLeaderboardsController *)viewController;

@end
