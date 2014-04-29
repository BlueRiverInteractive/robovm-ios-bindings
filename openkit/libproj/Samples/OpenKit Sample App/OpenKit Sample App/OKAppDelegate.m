//
//  OKAppDelegate.m
//  SampleApp
//
//  Created by Suneet Shah on 12/26/12.
//  Copyright (c) 2013 OpenKit. All rights reserved.
//

#import "OKAppDelegate.h"
#import "OpenKit.h"
#import "OKViewController.h"
#import "OKGameCenterUtilities.h"


@interface OKAppDelegate ()
-(void)handlePushDictionary:(NSDictionary *)dictionary;
@end

@implementation OKAppDelegate

- (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions
{
    
    NSString *myAppKey = @"BspfxiqMuYxNEotLeGLm";
    NSString *mySecretKey = @"2sHQOuqgwzocUdiTsTWzyQlOy1paswYLGjrdRWWf";
    
    [OKManager configureWithAppKey:myAppKey secretKey:mySecretKey];
    
    // Set the leaderboard list tag. By default, client asks
    // for tag = "v1". In the OpenKit dashboard, new leaderboards
    // have a default tag of "v1" as well. You can use this
    // tag feature to display different leaderboards in different
    // versions of your game. Each leaderboard can have multiple tags, but the client
    // will only display one tag.
    [[OKManager sharedManager] setLeaderboardListTag:@"v1"];

    [[UIApplication sharedApplication] registerForRemoteNotificationTypes:UIRemoteNotificationTypeAlert | UIRemoteNotificationTypeSound];  
    if (launchOptions != nil && [launchOptions objectForKey:UIApplicationLaunchOptionsRemoteNotificationKey] != nil) {
		NSDictionary* dictionary = [launchOptions objectForKey:UIApplicationLaunchOptionsRemoteNotificationKey];
        [self handlePushDictionary:dictionary];
    }

    // Set root view controller.
    self.window = [[UIWindow alloc] initWithFrame:[[UIScreen mainScreen] bounds]];
    self.viewController = [[OKViewController alloc] init];
    UINavigationController *navi = [[UINavigationController alloc] initWithRootViewController:self.viewController];
    self.window.rootViewController = navi;
    [self.window makeKeyAndVisible];
    
    // If you're using GameCenter, you can call this convenience method to authorize with game center. Set allowUI to YES if you want to show
    // the GameCenter leaderboard controller
    
    [OKGameCenterUtilities authorizeUserWithGameCenterAndallowUI:YES withPresentingViewController:self.viewController withCompletionHandler:nil];

    return YES;
}

// We should handle the push differently if the app is already open, but for now will well forward it
// to the same handlePushDictionary method that is used for opens.
- (void)application:(UIApplication*)application didReceiveRemoteNotification:(NSDictionary*)userInfo
{
    NSLog(@"Push notification received while open:%@", userInfo);
    [self handlePushDictionary:userInfo];
}

-(void)application:(UIApplication*)application didRegisterForRemoteNotificationsWithDeviceToken:(NSData*)deviceToken
{
    NSLog(@"Didregister for notificatrion");
    [[OKManager sharedManager] registerToken:deviceToken];
}


- (BOOL)application:(UIApplication *)application openURL:(NSURL *)url sourceApplication:(NSString *)sourceApplication annotation:(id)annotation
{
    return [OKManager handleOpenURL:url];
}

- (void)applicationWillResignActive:(UIApplication *)application
{
    // Sent when the application is about to move from active to inactive state. This can occur for certain types of temporary interruptions (such as an incoming phone call or SMS message) or when the user quits the application and it begins the transition to the background state.
    // Use this method to pause ongoing tasks, disable timers, and throttle down OpenGL ES frame rates. Games should use this method to pause the game.
}

- (void)applicationDidEnterBackground:(UIApplication *)application
{
    // Use this method to release shared resources, save user data, invalidate timers, and store enough application state information to restore your application to its current state in case it is terminated later. 
    // If your application supports background execution, this method is called instead of applicationWillTerminate: when the user quits.
}

- (void)applicationWillEnterForeground:(UIApplication *)application
{
    // Called as part of the transition from the background to the inactive state; here you can undo many of the changes made on entering the background.
}

- (void)applicationDidBecomeActive:(UIApplication *)application
{
    // Restart any tasks that were paused (or not yet started) while the application was inactive. If the application was previously in the background, optionally refresh the user interface.
    [OKManager handleDidBecomeActive];
}

- (void)applicationWillTerminate:(UIApplication *)application
{
    // Called when the application is about to terminate. Save data if appropriate. See also applicationDidEnterBackground:.
    [OKManager handleWillTerminate];
}

- (void)handlePushDictionary:(NSDictionary *)dict
{
    NSLog(@"Handling push dictionary: %@", dict);
    // int someId = [[dict valueForKey:@"some_id"] intValue];
}

@end
