//
//  OKLeaderboardsViewController.m
//  OKClient
//
//  Created by Suneet Shah on 1/10/13.
//  Copyright (c) 2013 OpenKit. All rights reserved.
//

#import "OKLeaderboardsViewController.h"
#import "OKLeaderboardsListViewController.h"
#import "OKHelper.h"
#import "OKColors.h"

@interface OKLeaderboardsViewController ()
{
    int defaultLeaderboardID;
}

@end

@implementation OKLeaderboardsViewController

@synthesize showLandscapeOnly;

// Had to use a weird initializer paradigm for the initializers to fix a bug on iOS5

- (id)init {
    self = [super init];
    if (self) {
        self.modalPresentationStyle = UIModalPresentationFormSheet;
        OKLeaderboardsListViewController *list = [[OKLeaderboardsListViewController alloc]initWithDefaultLeaderboardID:defaultLeaderboardID];
        NSArray *viewControllers = [NSArray arrayWithObject:list];
        [self setViewControllers:viewControllers animated:NO];
        
        UITabBarItem *tabBarItem = [[UITabBarItem alloc] initWithTitle:@"Leaderboards" image:[UIImage imageNamed:@"leaderboards.png"] tag:1];
        [self setTabBarItem:tabBarItem];
    }
    return self;
}


-(id)initWithDefaultLeaderboardID:(int)leaderboardID
{
    defaultLeaderboardID = leaderboardID;
    return [self init];
}

- (void)viewDidLoad
{
    [super viewDidLoad];
	// Do any additional setup after loading the view.
}

- (void)viewWillAppear:(BOOL)animated
{
    [super viewWillAppear:animated];
    [[NSNotificationCenter defaultCenter] postNotificationName:OKLeaderboardsViewWillAppear
                                                        object:nil];
}

- (void)viewWillDisappear:(BOOL)animated
{
    [super viewWillDisappear:animated];
    [[NSNotificationCenter defaultCenter] postNotificationName:OKLeaderboardsViewWillDisappear
                                                        object:nil];
}

- (void)viewDidAppear:(BOOL)animated
{
    [super viewDidAppear:animated];
    [[NSNotificationCenter defaultCenter] postNotificationName:OKLeaderboardsViewDidAppear
                                                        object:nil];
}

- (void)viewDidDisappear:(BOOL)animated
{
    [super viewDidDisappear:animated];
    [[NSNotificationCenter defaultCenter] postNotificationName:OKLeaderboardsViewDidDisappear
                                                        object:nil];
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (BOOL)shouldAutorotate
{
    return YES;
}

-(NSUInteger)supportedInterfaceOrientations
{
    if(showLandscapeOnly)
        return UIInterfaceOrientationMaskLandscape;
    else
        return UIInterfaceOrientationMaskAllButUpsideDown;
}

 


@end
