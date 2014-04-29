//
//  OKScore.m
//  OKClient
//
//  Created by Suneet Shah on 1/3/13.
//  Copyright (c) 2013 OpenKit. All rights reserved.
//

#import "OKScore.h"
#import "OKUserUtilities.h"
#import "OKUser.h"
#import "OKManager.h"
#import "OKNetworker.h"
#import "OKDefines.h"
#import "OKGameCenterUtilities.h"
#import "OKMacros.h"
#import "OKError.h"
#import "OKScoreDB.h"
#import "OKHelper.h"
#import "OKUtils.h"
#import "OKLeaderboard.h"
#import "OKFacebookUtilities.h"
#import "OKChallenge.h"

@implementation OKScore

@synthesize OKLeaderboardID, OKScoreID, scoreValue, user, scoreRank, metadata, displayString, gamecenterLeaderboardID, submitted;
- (id)initFromJSON:(NSDictionary*)jsonDict
{
    self = [super init];
    if (self) {
        self.OKLeaderboardID= [OKHelper getIntSafeForKey:@"leaderboard_id" fromJSONDictionary:jsonDict];
        self.OKScoreID      = [OKHelper getIntSafeForKey:@"id" fromJSONDictionary:jsonDict];
        self.scoreValue     = [OKHelper getInt64SafeForKey:@"value" fromJSONDictionary:jsonDict];
        self.scoreRank      = [OKHelper getIntSafeForKey:@"rank" fromJSONDictionary:jsonDict];
        self.user           = [OKUserUtilities createOKUserWithJSONData:[jsonDict objectForKey:@"user"]];
        self.displayString  = [OKHelper getNSStringSafeForKey:@"display_string" fromJSONDictionary:jsonDict];
        self.metadata       = [OKHelper getIntSafeForKey:@"metadata" fromJSONDictionary:jsonDict];
    }
    
    return self;
}

-(id)initWithOKLeaderboardID:(int)okLeaderboardID withGameCenterLeaderboardID:(NSString*)gcID
{
    self = [super init];
    if(self) {
        self.OKLeaderboardID = okLeaderboardID;
        self.gamecenterLeaderboardID = gcID;
        self.submitted = NO;
    }
    
    return self;
}

- (void)encodeWithCoder:(NSCoder *)encoder
{
    // Set an ID on any score that is encoded so that when we submit it, we can remove it from the cache
    // This ID is not used when submitting the score, it is simply used to keep track of which
    // score to remove from the cache. We do not encode scores that are returned from the server, only
    // locally cached scores that will be submitted to the server later so it's OK to set this value
    int hashedScoreID = [[NSDate date] hash];
    self.OKScoreID = hashedScoreID;
    
    [encoder encodeInt32:self.OKLeaderboardID forKey:@"OKLeaderboardID"];
    [encoder encodeInt32:self.OKScoreID forKey:@"OKScoreID"];
    [encoder encodeInt64:self.scoreValue forKey:@"scoreValue"];
    [encoder encodeObject:self.displayString forKey:@"displayString"];
    [encoder encodeInt64:self.metadata forKey:@"metadata"];
    [encoder encodeObject:self.gamecenterLeaderboardID forKey:@"gamecenterLeaderboardID"];
}

- (id)initWithCoder:(NSCoder *)decoder
{
    self = [super init];
    if(self)
    {
        self.OKLeaderboardID = [decoder decodeInt32ForKey:@"OKLeaderboardID"];
        self.OKScoreID =  [decoder decodeInt32ForKey:@"OKScoreID"];
        self.scoreValue = [decoder decodeInt64ForKey:@"scoreValue"];
        self.displayString = [decoder decodeObjectForKey:@"displayString"];
        self.metadata = [decoder decodeInt64ForKey:@"metadata"];
        self.gamecenterLeaderboardID = [decoder decodeObjectForKey:@"gamecenterLeaderboardID"];
    }
    return self;
}

-(NSDictionary*)getScoreParamDict
{
    OKUser *currentUser = [[OKManager sharedManager] currentUser];
    
    NSMutableDictionary *paramDict = [[NSMutableDictionary alloc] initWithCapacity:3];
    
    [paramDict setValue:[NSNumber numberWithLongLong:scoreValue] forKey:@"value"];
    [paramDict setValue:[NSNumber numberWithInt:OKLeaderboardID] forKey:@"leaderboard_id"];
    [paramDict setValue:[NSNumber numberWithInt:metadata] forKey:@"metadata"];
    [paramDict setValue:displayString forKey:@"display_string"];
    [paramDict setValue:[currentUser OKUserID] forKey:@"user_id"];
    
    return paramDict;
}


-(void)submitScoreWithCompletionHandler:(void (^)(NSError *error))completionHandler
{
    // Submit to GC if GC leaderboard ID is specified
    if(self.gamecenterLeaderboardID) {
        [self submitScoreToGameCenter];
    }
    
    // Only submit scores for the current user
    [self setUser:[OKUser currentUser]];
    
    // Store the score in cache and find out if it should be submitted
    BOOL shouldSubmit = [[OKScoreDB sharedCache] isScoreBetterThanLocalCachedScores:self storeScore:YES force:NO];
    
    // If there is an OKUser and the score is better than a submitted cached score
    if([self user] && shouldSubmit) {
        [self submitScoreBaseWithCompletionHandler:^(NSError *error) {
            if(!error) {
                // Score submitted successfully, update the cace
                [[OKScoreDB sharedCache] updateCachedScoreSubmitted:self];
            }
            completionHandler(error);
        }];
    } else {
        OKLog(@"Score was not submitted");
        // Call the completionhandler with the appropriate error. When there is no user, call the nouser error.
        // When a score is not submitted because it's not better, we have an explicit error for that
        if(![self user]) {
            completionHandler([OKError noOKUserErrorScoreCached]);
        } else {
            completionHandler([OKError OKScoreNotSubmittedError]);
        }
    }
}


-(void)forceSubmitScoreWithCompletionHandler:(void (^)(NSError *error))completionHandler
{
    // Submit to GC if GC leaderboard ID is specified
    if(self.gamecenterLeaderboardID) {
        [self submitScoreToGameCenter];
    }
    
    // Only submit scores for the current user
    [self setUser:[OKUser currentUser]];
    
    // Store the score in cache and find out if it should be submitted
    [[OKScoreDB sharedCache] isScoreBetterThanLocalCachedScores:self storeScore:YES force:YES];
    
    // If there is an OKUser and the score is better than a submitted cached score
    if([self user]) {
        [self submitScoreBaseWithCompletionHandler:^(NSError *error) {
            if(!error) {
                // Score submitted successfully, update the cace
                [[OKScoreDB sharedCache] updateCachedScoreSubmitted:self];
            }
            completionHandler(error);
        }];
    } else {
        OKLog(@"Score was not submitted");
        // Call the completionhandler with the appropriate error. When there is no user, call the nouser error.
        // When a score is not submitted because it's not better, we have an explicit error for that
        if(![self user]) {
            completionHandler([OKError noOKUserErrorScoreCached]);
        } else {
            completionHandler([OKError OKScoreNotSubmittedError]);
        }
    }
}


-(void)submitScoreBaseWithCompletionHandler:(void (^)(NSError *error))completionHandler
{
    if (!self.user) {
        completionHandler([OKError noOKUserError]);
        return;
    }
    
    //Create a request and send it to OpenKit
    NSDictionary *params = [NSDictionary dictionaryWithObjectsAndKeys:
                            [self getScoreParamDict], @"score", nil];
    
    [OKNetworker postToPath:@"/scores" parameters:params
                    handler:^(id responseObject, NSError *error)
     {
         if(!error) {
             OKLog(@"Successfully posted score to OpenKit: %@", self);
             [self setSubmitted:YES];
            //OKLog(@"Response: %@", responseObject);
         }else{
             OKLog(@"Failed to post score to OpenKit: %@",self);
             OKLog(@"Error: %@", error);
             [self setSubmitted:NO];
             
             // If the user is unsubscribed to the app, log out the user.
             [OKUserUtilities checkIfErrorIsUnsubscribedUserError:error];
         }
         completionHandler(error);
         
         OKScore *previousScore = [[OKScoreDB sharedCache] previousSubmittedScore];
         [[OKScoreDB sharedCache] setPreviousSubmittedScore:nil];
         
         // If there was no error, try issuing a push challenge
         if(!error) {
             [OKChallenge sendPushChallengewithScorePostResponseJSON:responseObject withPreviousScore:previousScore];
         }
         
     }];
}


- (void)cachedScoreSubmit:(void (^)(NSError *error))completionHandler
{
    [self submitScoreBaseWithCompletionHandler:completionHandler];
}

-(void)submitScoreToGameCenter
{
    if(self.gamecenterLeaderboardID && [OKGameCenterUtilities isPlayerAuthenticatedWithGameCenter]) {
        
        GKScore *scoreReporter = [[GKScore alloc] initWithCategory:[self gamecenterLeaderboardID]];
        scoreReporter.value = [self scoreValue];
        scoreReporter.context = [self metadata];
        
        [scoreReporter reportScoreWithCompletionHandler:^(NSError *error) {
            if(error) {
                OKLog(@"Error submitting score to GameCenter: %@",error);
            }
            else {
                OKLog(@"Gamecenter score submitted successfully");
            }
        }];
        
    } else {
        OKLog(@"Not submitting score to GameCenter, GC not available");
    }
}


-(void)submitScoreToOpenKitAndGameCenterWithCompletionHandler:(void (^)(NSError *error))completionHandler
{
    OKLog(@"Submitting score to OpenKit and GC");
   [self submitScoreWithCompletionHandler:completionHandler];
}

/** OKScoreProtocol Implementation **/
-(NSString*)scoreDisplayString {
    if([self displayString])
        return displayString;
    else
        return [NSString stringWithFormat:@"%lld",[self scoreValue]];
}
-(NSString*)userDisplayString {
    return [[self user] userNick];
}

-(NSString*)rankDisplayString {
    return [NSString stringWithFormat:@"%d", [self scoreRank]];
}

-(int)rank {
    return [self scoreRank];
}

-(void)setRank:(NSInteger)rank {
    [self setScoreRank:rank];
}

-(OKScoreSocialNetwork)socialNetwork {
    if([[self user] fbUserID])
        return OKScoreSocialNetworkFacebook;
    //else if ([[self user] gameCenterID])
    //    return OKScoreSocialNetworkGameCenter;
    else
        return OKScoreSocialNetworkUnknown;
}

- (NSString *)description {
    return [NSString stringWithFormat:@"OKScore id: %d, submitted: %d, value: %lld, leaderboard id: %d, display string: %@, metadata: %d", [self OKScoreID], [self submitted],[self scoreValue], [self OKLeaderboardID], [self displayString], [self metadata]];
}

@end
