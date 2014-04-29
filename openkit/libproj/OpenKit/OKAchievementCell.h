//
//  OKAchievementCell.h
//  OpenKit
//
//  Created by Suneet Shah on 12/11/13.
//  Copyright (c) 2013 OpenKit. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "OKAchievement.h"
#define kOKAchievementCellIdentifier @"OKAchievementCell"

@interface OKAchievementCell : UITableViewCell

@property (nonatomic, strong) UILabel *nameLabel, *descriptionLabel;
@property (nonatomic, strong) OKAchievement *achievement;
@property (nonatomic, strong) UIProgressView *progressView;

@end
