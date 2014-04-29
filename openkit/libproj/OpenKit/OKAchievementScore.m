//
//  OKAchievementScore.m
//  OpenKit
//
//  Created by Suneet Shah on 12/10/13.
//  Copyright (c) 2013 OpenKit. All rights reserved.
//

#import "OKAchievementScore.h"
#import "OKUser.h"
#import "OKError.h"
#import "OKNetworker.h"
#import "OKMacros.h"
#import "OKUserUtilities.h"
#import <GameKit/GameKit.h>
#import "OKGameCenterUtilities.h"
#import "OKHelper.h"

@implementation OKAchievementScore

@synthesize progress, GKAchievementID, OKAchievementID, GKPercentComplete;

-(NSDictionary*)getAchievementScoreAsJSON
{
    NSMutableDictionary *jsonDict = [[NSMutableDictionary alloc] init];
    [jsonDict setObject:[NSNumber numberWithInt:progress] forKey:@"progress"];
    [jsonDict setObject:[NSNumber numberWithInt:OKAchievementID] forKey:@"achievement_id"];
    
    if([OKUser currentUser]) {
        [jsonDict setObject:[[OKUser currentUser] OKUserID] forKey:@"user_id"];
    }
    return jsonDict;
}

-(void)submitAchievementScoreWithCompletionHandler:(void (^)(NSError *error))completionHandler
{
    // Always submit the gamecenter achievement even if no OKUser
    if(![OKHelper isEmpty:GKAchievementID]) {
        [self reportGKAchievementForIdentifier:GKAchievementID percentComplete:GKPercentComplete];
    }
    
    if(![OKUser currentUser]) {
        //TODO cache local achievement scores
        completionHandler([OKError noOKUserError]);
        return;
    }
    
    NSDictionary *requestParams = [NSDictionary dictionaryWithObject:[self getAchievementScoreAsJSON] forKey:@"achievement_score"];
    
    [OKNetworker postToPath:@"/achievement_scores" parameters:requestParams handler:^(id responseObject, NSError *error) {
        
        if(!error) {
            OKLogInfo(@"Submitted achievement score to OpenKit successfully");
            completionHandler(nil);
        } else {
            [OKUserUtilities checkIfErrorIsUnsubscribedUserError:error];
            completionHandler(error);
            OKLog(@"Error submitting achievement score: %@",error);
        }
    }];
}

-(void)reportGKAchievementForIdentifier:(NSString*)identifier percentComplete:(float)percent
{
    if(![OKGameCenterUtilities isPlayerAuthenticatedWithGameCenter]) {
        OKLog(@"Reporting GameCenter achievement but GKPlayer is not signed in with GC");
    }
    
    GKAchievement *achievement = [[GKAchievement alloc] initWithIdentifier:identifier];
    if(achievement) {
        achievement.percentComplete = percent;
        achievement.showsCompletionBanner = YES;
        
        OKLogInfo(@"Reporting achievement identifier %@ to GameCenter",GKAchievementID);
        
        [achievement reportAchievementWithCompletionHandler:^(NSError *error) {
            if(error != nil) {
                OKLog(@"Error reporting GameCenter achievement for identifier: %@ %@", identifier, error);
            } else {
                OKLog(@"Reported GameCenter achievement successfully for identifier: %@",identifier);
            }
        }];
    } else {
        
    }
}

@end
