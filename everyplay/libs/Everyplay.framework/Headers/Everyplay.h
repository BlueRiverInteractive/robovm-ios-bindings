/*
 * Copyright 2012-2014 Applifier
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

#import <Foundation/Foundation.h>
#if TARGET_OS_IPHONE
#import <UIKit/UIKit.h>
#else
#import <AppKit/AppKit.h>
#endif

#import "EveryplayFaceCam.h"
#import "EveryplayCapture.h"
#import "EveryplayAccount.h"
#import "EveryplayRequest.h"
#import "EveryplaySoundEngine.h"

#pragma mark - Developer metadata
extern NSString * const kEveryplayMetadataScoreInteger;    // @"score"
extern NSString * const kEveryplayMetadataLevelInteger;    // @"level"
extern NSString * const kEveryplayMetadataLevelNameString; // @"level_name"

#pragma mark - View controller flow settings

typedef enum  {
    EveryplayFlowReturnsToGame         = 1 << 0,    // Default
    EveryplayFlowReturnsToVideoPlayer  = 1 << 1
} EveryplayFlowDefs;

#pragma mark - Error codes
extern NSString * const kEveryplayErrorDomain;       // @"com.everyplay"

extern const int kEveryplayLoginCanceledError;       // 100
extern const int kEveryplayMovieExportCanceledError; // 101
extern const int kEveryplayFileUploadError;          // 102

#pragma mark - Notifications

extern NSString * const EveryplayAccountDidChangeNotification;
extern NSString * const EveryplayDidFailToRequestAccessNotification;

#pragma mark - Handler

typedef void(^EveryplayAccessRequestCompletionHandler)(NSError *error);
typedef void(^EveryplayPreparedAuthorizationURLHandler)(NSURL *preparedURL);
typedef void(^EveryplayDataLoadingHandler)(NSError *error, id data);

#pragma mark - Compile-time options

NS_CLASS_AVAILABLE(10_7, 4_0)
@interface EveryplayFeatures : NSObject
/*
 * Is running on iOS 5 or later?
 * Useful for disabling functionality on older devices.
 */
+ (BOOL) isSupported;

/*
 * Returns the number of CPU cores on device.
 * Useful for disabling functionality on older devices.
 */
+ (NSUInteger) numCores;

/*
 * To disable Everyplay OpenAL implementation, override this class
 * method to return NO.
 */
+ (BOOL) supportsOpenAL;

/*
 * To disable Everyplay OpenAL "missing implementation" messages, override
 * this class method to return YES.
 */
+ (BOOL) disableOpenALMessages;

/*
 * AVFoundation AVAudioPlayer support currently lacks hardware
 * decoder support. To disable recording support for background music,
 * override this class method to return NO.
 */
+ (BOOL) supportsAVFoundation;
@end

#pragma mark -

@class EveryplayAccount;

NS_CLASS_AVAILABLE(10_7, 4_0)
@protocol EveryplayDelegate <NSObject>
- (void)everyplayShown;
- (void)everyplayHidden;
@optional
- (void)everyplayReadyForRecording:(NSNumber *)enabled;
- (void)everyplayRecordingStarted;
- (void)everyplayRecordingStopped;

- (void)everyplayFaceCamSessionStarted;
- (void)everyplayFaceCamRecordingPermission:(NSNumber *)granted;
- (void)everyplayFaceCamSessionStopped;

- (void)everyplayUploadDidStart:(NSNumber *)videoId;
- (void)everyplayUploadDidProgress:(NSNumber *)videoId progress:(NSNumber *)progress;
- (void)everyplayUploadDidComplete:(NSNumber *)videoId;

- (void)everyplayThumbnailReadyAtFilePath:(NSString *)thumbnailFilePath;
- (void)everyplayThumbnailReadyAtURL:(NSURL *)thumbnailUrl;

- (void)everyplayThumbnailReadyAtTextureId:(NSNumber *)textureId portraitMode:(NSNumber *)portrait;
@end

NS_CLASS_AVAILABLE(10_7, 4_0)
@interface Everyplay : NSObject

#pragma mark - Properties
@property (nonatomic, unsafe_unretained) EveryplayCapture *capture;
@property (nonatomic, strong) EveryplayFaceCam *faceCam;
#if TARGET_OS_IPHONE
@property (nonatomic, weak) UIViewController *parentViewController;
#endif
@property (nonatomic, weak) id <EveryplayDelegate> everyplayDelegate;
@property (nonatomic, assign) EveryplayFlowDefs flowControl;

#pragma mark - Singleton
+ (Everyplay *)sharedInstance;

+ (BOOL)isSupported;

+ (Everyplay *)initWithDelegate:(id <EveryplayDelegate>)everyplayDelegate;
#if TARGET_OS_IPHONE
+ (Everyplay *)initWithDelegate:(id <EveryplayDelegate>)everyplayDelegate andParentViewController:(UIViewController *)viewController;
+ (Everyplay *)initWithDelegate:(id <EveryplayDelegate>)everyplayDelegate andAddRootViewControllerForView:(UIView *)view;
#endif

#pragma mark - Public Methods
- (void)showEveryplay;
- (void)showEveryplayWithPath:(NSString *)path;
- (void)showEveryplaySharingModal;
- (void)hideEveryplay;
- (void)playLastRecording;

- (void)mergeSessionDeveloperData:(NSDictionary *)dictionary;

#pragma mark - Video playback
- (void)playVideoWithURL:(NSURL *)videoURL;
- (void)playVideoWithDictionary:(NSDictionary *)videoDictionary;

#pragma mark - Theming
- (void)setTheme:(NSDictionary *)theme;

#pragma mark - Manage Accounts
+ (EveryplayAccount *)account;

+ (void)requestAccessWithCompletionHandler:(EveryplayAccessRequestCompletionHandler)aCompletionHandler;
+ (void)requestAccessforScopes:(NSString *)scopes
         withCompletionHandler:(EveryplayAccessRequestCompletionHandler)aCompletionHandler;
+ (void)removeAccess;

#pragma mark - Facebook authentication
+ (BOOL)handleOpenURL:(NSURL *)url sourceApplication:(id)sourceApplication annotation:(id)annotation;

#pragma mark - Configuration
+ (void)setClientId:(NSString *)client
       clientSecret:(NSString *)secret
        redirectURI:(NSString *)url;

#pragma mark - OAuth2 Flow
+ (BOOL)handleRedirectURL:(NSURL *)URL;

@end

#pragma mark - Macros

#define EVERYPLAY_CANCELED(error) ([error.domain isEqualToString:(NSString *)kEveryplayErrorDomain] && error.code == kEveryplayLoginCanceledError)
