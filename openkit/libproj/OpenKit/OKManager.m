//
//  OKManager.m
//  OKManager
//
//  Created by Suneet Shah on 12/27/12.
//  Copyright (c) 2013 OpenKit. All rights reserved.
//

#import <FacebookSDK/FacebookSDK.h>
#import "OKManager.h"
#import "OKUser.h"
#import "OKUserUtilities.h"
#import "OKFacebookUtilities.h"
#import "SimpleKeychain.h"
#import "OKDefines.h"
#import "OKUserProfileImageView.h"
#import "OKLeaderboardsViewController.h"
#import "OKScoreDB.h"
#import "OKLocalCache.h"
#import "OKSessionDb.h"
#import "OKMacros.h"

#define OK_DEFAULT_ENDPOINT    @"http://api.openkit.io"
#define OK_OPENKIT_SDK_VERSION = @"1.1";

static NSString *OK_USER_KEY = @"OKUserInfo";

@interface OKManager ()
{
    OKUser *_currentUser;
}

@property (nonatomic, strong) NSString *appKey;
@property (nonatomic, strong) NSString *secretKey;
@property (nonatomic, strong) NSString *endpoint;

- (void)startSession;
@end


@implementation OKManager
@synthesize hasShownFBLoginPrompt, leaderboardListTag, cachedFbFriendsList;

+ (void)configureWithAppKey:(NSString *)appKey secretKey:(NSString *)secretKey endpoint:(NSString *)endpoint
{
    NSParameterAssert(appKey);
    NSParameterAssert(secretKey);
    OKManager *manager = [OKManager sharedManager];
    manager.appKey = appKey;
    manager.secretKey = secretKey;
    if(endpoint != nil) {
        manager.endpoint = endpoint;
    } else {
        manager.endpoint = OK_DEFAULT_ENDPOINT;
    }
    
    [manager startSession];
    
    OKLog(@"OpenKit configured with endpoint: %@", [[OKManager sharedManager] endpoint]);
}

+ (void)configureWithAppKey:(NSString *)appKey secretKey:(NSString *)secretKey
{
    [OKManager configureWithAppKey:appKey secretKey:secretKey endpoint:nil];
}

+ (id)sharedManager
{
    static dispatch_once_t pred;
    static OKManager *sharedInstance = nil;
    dispatch_once(&pred, ^{
        sharedInstance = [[OKManager alloc] init];
    });
    return sharedInstance;
}

- (id)init
{
    self = [super init];
    if (self) {
        _endpoint = OK_DEFAULT_ENDPOINT;

        // These two lines below are required for the linker to work properly such that these classes are available in XIB files
        [FBProfilePictureView class];
        [OKUserProfileImageView class];
        
        [OKFacebookUtilities OpenCachedFBSessionWithoutLoginUI];

        NSNotificationCenter *nc = [NSNotificationCenter defaultCenter];
        [nc addObserver:self selector:@selector(willShowDashboard:) name:OKLeaderboardsViewWillAppear object:nil];
        [nc addObserver:self selector:@selector(didShowDashboard:)  name:OKLeaderboardsViewDidAppear object:nil];
        [nc addObserver:self selector:@selector(willHideDashboard:) name:OKLeaderboardsViewWillDisappear object:nil];
        [nc addObserver:self selector:@selector(didHideDashboard:)  name:OKLeaderboardsViewDidDisappear object:nil];
        
        [self getSavedUserFromNSUserDefaults];
    }
    return self;
}

- (void)dealloc
{
    [[NSNotificationCenter defaultCenter] removeObserver:self];
    // Do not call super here.  Using arc.
}

- (OKUser*)currentUser
{
    @synchronized(self) {
        return _currentUser;
    }
}

+ (NSString *)appKey
{
    return [[OKManager sharedManager] appKey];
}

+ (NSString *)endpoint
{
    return [[OKManager sharedManager] endpoint];
}

+ (NSString *)secretKey
{
    return [[OKManager sharedManager] secretKey];
}

- (void)logoutCurrentUser
{
    OKLogInfo(@"Logged out of openkit");
    _currentUser = nil;
    [self removeCachedUserFromNSUserDefaults];
    //Log out and clear Facebook
    [FBSession.activeSession closeAndClearTokenInformation];
    
    [[OKScoreDB sharedCache] clearCachedSubmittedScores];
}

- (void)saveCurrentUser:(OKUser *)aCurrentUser
{
    self->_currentUser = aCurrentUser;
    [self removeCachedUserFromNSUserDefaults];
    [self saveCurrentUserToNSUserDefaults];
    [[OKScoreDB sharedCache] submitAllCachedScores];
}

-(void)getSavedUserFromNSUserDefaults
{
    NSUserDefaults *defaults = [NSUserDefaults standardUserDefaults];
    NSData *archivedUserDict = [defaults objectForKey:OK_USER_KEY];
    
    if(archivedUserDict != nil) {
        if(![archivedUserDict isKindOfClass:[NSData class]]) {
            OKLog(@"OKUser cache is busted, clearing cache");
            [self removeCachedUserFromNSUserDefaults];
        } else {
            NSDictionary *userDictionary = [NSKeyedUnarchiver unarchiveObjectWithData:archivedUserDict];
            OKUser *cachedUser = [OKUserUtilities createOKUserWithJSONData:userDictionary];
            _currentUser = cachedUser;
            OKLogInfo(@"Found  cached OKUser id: %@ from defaults", [cachedUser OKUserID]);
            
            if(_currentUser == nil) {
                OKLog(@"OKUser cache is busted, clearing cache");
                [self removeCachedUserFromNSUserDefaults];
            }
        }
    } else {
        OKLog(@"Did not find cached OKUser");
    }
}

-(void)saveCurrentUserToNSUserDefaults
{
    NSDictionary *userDict = [OKUserUtilities getJSONRepresentationOfUser:[OKUser currentUser]];
    NSData *archivedUserDict = [NSKeyedArchiver archivedDataWithRootObject:userDict];
    
    NSUserDefaults *defaults = [NSUserDefaults standardUserDefaults];
    [defaults setObject:archivedUserDict forKey:OK_USER_KEY];
    [defaults synchronize];
}

-(void)removeCachedUserFromNSUserDefaults
{
    NSUserDefaults *defaults = [NSUserDefaults standardUserDefaults];
    [defaults removeObjectForKey:OK_USER_KEY];
    [defaults synchronize];
}

+ (BOOL)handleOpenURL:(NSURL*)url
{
    return [OKFacebookUtilities handleOpenURL:url];
}

+ (void)handleDidBecomeActive
{
    [OKFacebookUtilities handleDidBecomeActive];
    [[OKManager sharedManager] submitCachedScoresAfterDelay];
}

+ (void)handleWillTerminate
{
    [OKFacebookUtilities handleWillTerminate];
}

- (void)registerToken:(NSData *)deviceToken
{
    OKLog(@"OKManager registerToken, data: %@", deviceToken);
    
    const unsigned *tokenBytes = [deviceToken bytes];
    NSString *hexToken = [NSString stringWithFormat:@"%08x%08x%08x%08x%08x%08x%08x%08x",
                          ntohl(tokenBytes[0]), ntohl(tokenBytes[1]), ntohl(tokenBytes[2]),
                          ntohl(tokenBytes[3]), ntohl(tokenBytes[4]), ntohl(tokenBytes[5]),
                          ntohl(tokenBytes[6]), ntohl(tokenBytes[7])];

    OKLogInfo(@"cache queue is %s", dispatch_queue_get_label(OK_CACHE_QUEUE()));
    dispatch_async(OK_CACHE_QUEUE(), ^{
        [[OKSessionDb db] registerPush:hexToken];
    });
}

#pragma mark - Dashboard Display State Callbacks
- (void)willShowDashboard:(NSNotification *)note
{
    if(_delegate && [_delegate respondsToSelector:@selector(openkitManagerWillShowDashboard:)]) {
        [_delegate openkitManagerWillShowDashboard:self];
    }
}

- (void)didShowDashboard:(NSNotification *)note
{
    if(_delegate && [_delegate respondsToSelector:@selector(openkitManagerDidShowDashboard:)]) {
        [_delegate openkitManagerDidShowDashboard:self];
    }
}

- (void)willHideDashboard:(NSNotification *)note
{
    if(_delegate && [_delegate respondsToSelector:@selector(openkitManagerWillHideDashboard:)]) {
        [_delegate openkitManagerWillHideDashboard:self];
    }
}

- (void)didHideDashboard:(NSNotification *)note
{
    if(_delegate && [_delegate respondsToSelector:@selector(openkitManagerDidHideDashboard:)]) {
        [_delegate openkitManagerDidHideDashboard:self];
    }
}



#pragma mark - Private
- (void)startSession
{
    dispatch_time_t delay = dispatch_time(DISPATCH_TIME_NOW, (100.0f * NSEC_PER_MSEC));
    dispatch_after(delay, OK_CACHE_QUEUE(), ^{
        [[OKSessionDb db] activate];
    });
    
    [self submitCachedScoresAfterDelay];
}

-(void)submitCachedScoresAfterDelay
{
    double delayInSeconds = 2.0;
    dispatch_time_t popTime = dispatch_time(DISPATCH_TIME_NOW, (int64_t)(delayInSeconds * NSEC_PER_SEC));
    dispatch_after(popTime, dispatch_get_main_queue(), ^(void){
        [[OKScoreDB sharedCache] submitAllCachedScores];
    });
}

@end
