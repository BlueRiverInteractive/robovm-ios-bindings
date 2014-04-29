//
//  OKViewController.h
//  SampleApp
//
//  Created by Suneet Shah on 12/26/12.
//  Copyright (c) 2013 OpenKit. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "OpenKit.h"


@interface OKViewController : UIViewController<GKGameCenterControllerDelegate>

- (IBAction)viewLeaderboards:(id)sender;
- (IBAction)logoutOfOpenKit:(id)sender;
- (IBAction)loginToOpenKit:(id)sender;
- (IBAction)submitScore:(id)sender;
- (IBAction)viewAchievements:(id)sender;
- (IBAction)launchGameCenter:(id)sender;
-(IBAction)unlockAchievement:(id)sender;

@property (nonatomic, strong) IBOutlet OKUserProfileImageView *profileImageView;
@property (nonatomic, strong) IBOutlet UIButton *logoutButton;
@property (nonatomic, strong) IBOutlet UIButton *loginButton;
@property (nonatomic, strong) IBOutlet UILabel *userNickLabel;

@end
