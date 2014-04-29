//
//  OKAchievementsViewController.m
//  OpenKit
//
//  Created by Suneet Shah on 12/11/13.
//  Copyright (c) 2013 OpenKit. All rights reserved.
//

#import "OKAchievementsViewController.h"
#import "OKAchievementsListVC.h"

@interface OKAchievementsViewController ()

@end

@implementation OKAchievementsViewController

@synthesize showLandscapeOnly;

-(id)init {
    self = [super init];
    if(self) {
        OKAchievementsListVC *achievementsVC = [[OKAchievementsListVC alloc] init];
        NSArray *viewControllers = [NSArray arrayWithObject:achievementsVC];
        [self setViewControllers:viewControllers animated:NO];
        
        UITabBarItem *tabBarItem = [[UITabBarItem alloc] initWithTitle:@"Achievements" image:[UIImage imageNamed:@"achievements.png"] tag:2];
        [self setTabBarItem:tabBarItem];
    }
    return self;
}


- (void)viewDidLoad
{
    [super viewDidLoad];
	// Do any additional setup after loading the view.
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
