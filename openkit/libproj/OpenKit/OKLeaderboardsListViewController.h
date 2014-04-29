//
//  OKLeaderboardsListViewController.h
//  Leaderboard
//
//  Created by Todd Hamilton on Jan/3/13.
//  Copyright (c) 2013 Todd Hamilton. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface OKLeaderboardsListViewController : UIViewController<UITableViewDataSource, UITableViewDelegate>
{
    int playerCount;
}

-(id)initWithDefaultLeaderboardID:(int)leaderboardID;
- (IBAction)back;

@end
