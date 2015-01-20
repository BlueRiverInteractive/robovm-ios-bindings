/*
 * Copyright 2013 Applifier
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
#import <AudioToolbox/AudioToolbox.h>
#import <AVFoundation/AVFoundation.h>

NS_CLASS_AVAILABLE(10_7, 4_0)
@interface EveryplaySoundEngine : NSObject

@property (readwrite) float backgroundMusicVolume;
@property (readwrite) float effectsVolume;
@property (readwrite) float masterVolume;

+ (EveryplaySoundEngine *)sharedInstance;

#pragma mark - CocosDenshion compatible background music API

- (void)playBackgroundMusic:(NSString *)filename;
- (void)playBackgroundMusic:(NSString *)filename loop:(BOOL)loop;
- (void)preloadBackgroundMusic:(NSString *)filename;
- (void)stopBackgroundMusic;
- (void)pauseBackgroundMusic;
- (void)rewindBackgroundMusic;
- (void)resumeBackgroundMusic;
- (BOOL)isBackgroundMusicPlaying;
- (void)unloadBackgroundMusic:(NSString *)filename;

#pragma mark - CocosDenshion compatible effects API

- (uint)playEffect:(NSString *)filename;
- (uint)playEffect:(NSString *)filename loop:(BOOL)loop;
- (uint)playEffect:(NSString *)filename pitch:(Float32)pitch pan:(Float32)pan gain:(Float32)gain;
- (uint)playEffect:(NSString *)filename loop:(BOOL)loop pitch:(Float32)pitch pan:(Float32)pan gain:(Float32)gain;

- (void)stopEffect:(uint)soundId;
- (void)preloadEffect:(NSString *)filename;
- (void)unloadEffect:(NSString *)filename;

@end
