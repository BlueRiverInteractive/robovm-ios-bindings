//
//  OKProfileViewController.m
//  Leaderboard
//
//  Created by Todd Hamilton on Jan/14/13.
//  Copyright (c) 2013 Todd Hamilton. All rights reserved.
//

#import "OKProfileViewController.h"
#import "OKUserProfileImageView.h"
#import <QuartzCore/QuartzCore.h>
#import "OKFacebookUtilities.h"


@interface OKProfileViewController ()
@end


@implementation OKProfileViewController

@synthesize profilePic, nameLabel;

-(id)init
{
    self = [super initWithNibName:@"OKProfileViewController" bundle:nil];
    return self;
}

- (void)viewDidLoad
{
    [super viewDidLoad];
    // Do any additional setup after loading the view from its nib.
  
    [[self navigationItem] setTitle:@"Settings"];
  
    [self updateUI];
}


-(void)updateUI
{
    // If there is an OKUser and an Active Facebook Session, show the logout button
    if([OKFacebookUtilities isFBSessionOpen] && [OKUser currentUser]){
        [self.unlinkBtn setTitle: @"Disconnect Facebook" forState: UIControlStateNormal];
    } else {
        [self.unlinkBtn setTitle: @"Connect Facebook" forState: UIControlStateNormal];
    }
}


-(IBAction)logoutButtonPressed:(id)sender
{
    if([OKFacebookUtilities isFBSessionOpen] && [OKUser currentUser]) {
        [[FBSession activeSession] closeAndClearTokenInformation];
    } else {
        [OKFacebookUtilities AuthorizeUserWithFacebookWithCompletionHandler:^(OKUser *user, NSError *error) {
            [self updateUI];
            [[self navigationController] popViewControllerAnimated:YES];
        }];
    }
    [self updateUI];
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}



@end
