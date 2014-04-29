//
//  OKViewController.m
//  SampleApp
//
//  Created by Suneet Shah on 12/26/12.
//  Copyright (c) 2013 OpenKit. All rights reserved.
//

#import "OKScoreDB.h"
#import "OKViewController.h"
#import "ScoreSubmitterVC.h"
#import "OKFacebookUtilities.h"
#import "OKFacebookUtilities.h"



@implementation OKViewController

@synthesize profileImageView;


- (id)init
{
    self = [super initWithNibName:@"OKViewController" bundle:nil];
    self.navigationItem.title = @"OpenKit Sample App";
    return self;
}


-(void)updateUIforOKUser
{
    if ([OKUser currentUser]) {
        [self.loginButton setHidden:YES];
        [self.logoutButton setHidden:NO];
        
        [profileImageView setUser:[OKUser currentUser]];
        [self.userNickLabel setHidden:NO];
        [self.userNickLabel setText:[NSString stringWithFormat:@"%@", [[OKUser currentUser] userNick] ]];
    } else {
        [self.loginButton setHidden:NO];
        [self.logoutButton setHidden:YES];
        [self.profileImageView setUser:nil];
        [self.userNickLabel setHidden:YES];
        
    }
}

-(IBAction)launchGameCenter:(id)sender
{
    GKGameCenterViewController *gameCenterController = [[GKGameCenterViewController alloc] init];
    if (gameCenterController != nil) {
        gameCenterController.gameCenterDelegate = self;
        [self presentViewController: gameCenterController animated: YES completion:nil];
    }
}

- (void)gameCenterViewControllerDidFinish:(GKGameCenterViewController *)gameCenterViewController
{
    [self dismissViewControllerAnimated:YES completion:nil];
}


-(IBAction)logoutOfOpenKit:(id)sender
{
    //[OKUser logoutCurrentUserFromOpenKit];
    //[self updateUIforOKUser];
    
    OKAchievementScore *score = [[OKAchievementScore alloc] init];
    score.OKAchievementID = 188;
    score.progress = 12;
    
    // This is the GameCenter achievement identifier
    score.GKAchievementID = @"achievement1";
    score.progress = 1;
    
    [score submitAchievementScoreWithCompletionHandler:^(NSError *error) {
        if(!error) {
            NSLog(@"Submitted achievement successfully");
        } else {
            NSLog(@"Error submitting achievement, %@", error);
        }
    }];
    
}

-(IBAction)loginToOpenKit:(id)sender
{
    OKLoginView *loginView = [[OKLoginView alloc] init];
    [loginView showWithCompletionHandler:^{
        [self updateUIforOKUser];
    }];
}


-(void)viewWillAppear:(BOOL)animated
{
    [super viewWillAppear:animated];
    [self updateUIforOKUser];
}

-(IBAction)viewLeaderboards:(id)sender
{
    OKLeaderboardsViewController *leaderBoards = [[OKLeaderboardsViewController alloc] init];
    // Set the showLandscapeOnly property on OKLeaderboardsViewController to force landscape orientation
    //[leaderBoards setShowLandscapeOnly:YES];
    
    // If you want to show a specific leaderboard, use the following method
    //OKLeaderboardsViewController *leaderBoards = [[OKLeaderboardsViewController alloc] initWithDefaultLeaderboardID:385];
    
    [self presentViewController:leaderBoards animated:YES completion:nil];
}

- (IBAction)viewAchievements:(id)sender
{
    OKAchievementsViewController *achievements = [[OKAchievementsViewController alloc] init];
    
    [self presentViewController:achievements animated:YES completion:^{
        
    }];
}

-(IBAction)unlockAchievement:(id)sender
{
    OKAchievementScore *score = [[OKAchievementScore alloc] init];
    [score setOKAchievementID:190];
    [score setProgress:10];
    [score setGKAchievementID:@"achievement3"];
    [score setGKPercentComplete:100.0];
    [score submitAchievementScoreWithCompletionHandler:^(NSError *error) {
        if(error) {
            NSLog(@"Failed to submit achievement with error: %@", error);
        } else {
            NSLog(@"Submitted achievement score");
        }
    }];
}

-(IBAction)submitScore:(id)sender
{
    ScoreSubmitterVC *scoreSubmitter = [[ScoreSubmitterVC alloc] initWithNibName:@"ScoreSubmitterVC" bundle:nil];
    scoreSubmitter.modalPresentationStyle = UIModalPresentationFormSheet;
    [self presentViewController:scoreSubmitter animated:YES completion:nil];
}




- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

@end
