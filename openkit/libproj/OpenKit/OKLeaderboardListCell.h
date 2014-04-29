//
//  OKLeaderboardListCell.h
//  OKClient
//
//  Created by Suneet Shah on 1/11/13.
//  Copyright (c) 2013 OpenKit. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "OKLeaderboard.h"


#define kOKLeaderboardListCellIdentifier @"OKLeaderboardListCell"

@interface OKLeaderboardListCell : UITableViewCell

@property (nonatomic, strong) UILabel *label1;
@property (nonatomic, strong) UILabel *label2;
@property (nonatomic, strong) OKLeaderboard *leaderboard;

- (id)init;

@end

