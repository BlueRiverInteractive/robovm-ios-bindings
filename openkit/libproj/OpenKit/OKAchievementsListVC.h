//
//  OKAchievementsListVC.h
//  OpenKit
//
//  Created by Suneet Shah on 12/11/13.
//  Copyright (c) 2013 OpenKit. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface OKAchievementsListVC : UIViewController<UITableViewDataSource, UITableViewDelegate>

@property (nonatomic, strong) NSArray *achievementsList;


@end
