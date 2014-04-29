//
//  OKBridgeUIHelper.m
//  OpenKit
//
//  Created by Suneet Shah on 12/9/13.
//  Copyright (c) 2013 OpenKit. All rights reserved.
//

#import "OKBridgeUIHelper.h"
#import "OKMacros.h"
#import "OKGameCenterUtilities.h"

extern void UnitySendMessage(const char *, const char *, const char *);


@implementation BaseBridgeViewController

@synthesize window = _window;
@synthesize previousWindow;

- (id)init
{
    if(self = [super init]) {
        _didDisplay = NO;
        _didCapturePreviousWindow = NO;
        [[NSNotificationCenter defaultCenter] addObserver:self selector:@selector(getLostWindow:) name:UIWindowDidResignKeyNotification object:nil];
    }
    return self;
}

-(void)getLostWindow:(NSNotification*)note
{
    // Only allow previousWindow to be set once!
    if(_didCapturePreviousWindow)
        return;
    
    
    // Only set the previous window if the Window is normal level, it has a root viewController, and the viewcontroller isKindOfClass BaseBridgeViewController
    if([[note object] isKindOfClass:[UIWindow class]]) {
        UIWindow *noteWindow = [note object];
        
        if([noteWindow windowLevel] == UIWindowLevelNormal &&
           noteWindow.rootViewController != nil &&
           ![noteWindow.rootViewController isKindOfClass:[BaseBridgeViewController class]])
        {
            [self setPreviousWindow:noteWindow];
            _didCapturePreviousWindow = YES;
            OKBridgeLog(@"****Setting previous window: %@", noteWindow);
        } else {
            OKBridgeLog(@"****Other window shown: %@", noteWindow);
        }
    }
}

- (void)customLaunch
{
    // Override me.
}

- (void)viewDidAppear:(BOOL)animated
{
    [super viewDidAppear:animated];
    if (!_didDisplay) {
        _didDisplay = YES;
        [self customLaunch];
    }
}

-(void)dismissViewControllerAnimated:(BOOL)flag completion:(void (^)(void))completion
{
    [super dismissViewControllerAnimated:flag completion:^(void){
        if(completion != nil) {
            completion();
        }
        
        if(_didDisplay) {
            _didDisplay = NO;
            [self.window setRootViewController:nil];
            [self release];
        } else {
            OKBridgeLog(@"dismissViewController called but didDisplayIsFalse");
        }
    }];
}

- (void)dealloc
{
    OKBridgeLog(@"Dealloc BaseBridgeViewController");
    
    [[NSNotificationCenter defaultCenter] removeObserver:self];
    
    OKBridgeLog(@"Make previous window key, previous window is: %@",previousWindow);
    [previousWindow makeKeyAndVisible];
    
    [_window release];
    OKBridgeLog(@"Release OK window, retain count after release: %d", [_window retainCount]);
    
    
    [super dealloc];
}


@end


@implementation OKDashBridgeViewController
@synthesize leaderboardsVC = _leaderboardsVC;
@synthesize shouldShowLandscapeOnly = _shouldShowLandscapeOnly;
@synthesize defaultLeaderboardID = _defaultLeaderboardID;
- (id)init
{
    if ((self = [super init])) {
        [[OKManager sharedManager] setDelegate:self];
    }
    return self;
}

- (void)customLaunch
{
    OKBridgeLog(@"Showing OKLeaderboardsViewController with default id: %d", _defaultLeaderboardID);
    self.leaderboardsVC = [[[OKLeaderboardsViewController alloc] initWithDefaultLeaderboardID:_defaultLeaderboardID] autorelease];
    
    if(self.leaderboardsVC == nil) {
        OKLog(@"OKDashBridgeVC: couldn't alloc OKleaderboardsViewController");
        [self dismissViewControllerAnimated:NO completion:nil];
        return;
    }
    
    [self.leaderboardsVC setShowLandscapeOnly:_shouldShowLandscapeOnly];
    [self presentModalViewController:self.leaderboardsVC animated:YES];
}

- (void)openkitManagerWillShowDashboard:(OKManager *)manager
{
    UnitySendMessage("OpenKitPrefab", "NativeViewWillAppear", "");
}

- (void)openkitManagerDidShowDashboard:(OKManager *)manager
{
    UnitySendMessage("OpenKitPrefab", "NativeViewDidAppear", "");
}

- (void)openkitManagerWillHideDashboard:(OKManager *)manager
{
    UnitySendMessage("OpenKitPrefab", "NativeViewWillDisappear", "");
}

- (void)openkitManagerDidHideDashboard:(OKManager *)manager
{
    UnitySendMessage("OpenKitPrefab", "NativeViewDidDisappear", "");
}


- (void)dealloc
{
    OKBridgeLog(@"Deallocing OKDashboardViewController");
    [[OKManager sharedManager] setDelegate:nil];
    [_leaderboardsVC release];
    [super dealloc];
}

@end

@implementation OKBridgeAchievementsViewController
@synthesize achievementsVC, shouldShowLandscapeOnly;

-(void)customLaunch
{
    OKBridgeLog(@"Showing OKAchievements view controller");
    self.achievementsVC = [[[OKAchievementsViewController alloc] init] autorelease];
    
    if(self.achievementsVC == nil) {
        OKBridgeLog(@"OKDashBridgeVC: couldn't alloc OKAchievementsViewController");
        [self dismissViewControllerAnimated:NO completion:nil];
        return;
    }
    
    [self.achievementsVC setShowLandscapeOnly:shouldShowLandscapeOnly];
    [self presentModalViewController:self.achievementsVC animated:YES];
}

-(void)dealloc
{
    OKBridgeLog(@"Deallocing OKBridgeAchievementsViewController");
    [achievementsVC release];
    [super dealloc];
}

@end

@implementation OKBridgeLeaderboardsAndAchievmentsViewController
@synthesize tabBar;
-(void)customLaunch
{
    tabBar = [[UITabBarController alloc] init];
    OKLeaderboardsViewController *leaderboards = [[[OKLeaderboardsViewController alloc] init] autorelease];
    OKAchievementsViewController *achievements = [[[OKAchievementsViewController alloc] init] autorelease];
    
    if(achievements == nil || leaderboards == nil || tabBar == nil) {
        OKBridgeLog(@"OKBridgeLeaderboardsAndAchievmentsViewController couldn't alloc child view controllers");
        [self dismissModalViewControllerAnimated:NO];
        return;
    }
    
    [tabBar setViewControllers:[NSArray arrayWithObjects:leaderboards,achievements, nil]];
    [self presentModalViewController:tabBar animated:YES];
}

-(void)dealloc
{
    OKBridgeLog(@"Deallocing OKBridgeLeaderboardsAndAchievmentsViewController");
    [tabBar release];
    [super dealloc];
}

@end

@implementation OKGameCenterBridgeViewController


@synthesize gcViewControllerToLaunch = _gcViewControllerToLaunch;


- (void)customLaunch
{
    if(_gcViewControllerToLaunch)
        [self presentModalViewController:_gcViewControllerToLaunch animated:YES];
    else
        OKBridgeLog(@"OKGameCenterBridgeViewController VC to launch was null");
}

- (void)dealloc
{
    
    OKBridgeLog(@"Deallocing OKGameCenterBridgeViewController");
    [_gcViewControllerToLaunch release];
    // Release gc stuff if there is any.
    [super dealloc];
}

@end
