//
//  OKChallenge.m
//  OpenKit
//
//  Created by Suneet Shah on 9/13/13.
//  Copyright (c) 2013 OpenKit. All rights reserved.
//

#import "OKChallenge.h"
#import "OKUser.h"
#import "OKScore.h"
#import "OKLeaderboard.h"
#import "OKFacebookUtilities.h"
#import "OKHelper.h"
#import "OKUtils.h"
#import "OKMacros.h"
#import "OKNetworker.h"

@implementation OKChallenge

+(void)sendPushChallengewithScorePostResponseJSON:(id)responseObject withPreviousScore:(OKScore*)previousScore
{
    OKLog(@"Trying to send push challenge.");
    
    if([OKUser currentUser] == nil) {
        OKLog(@"Can't issue push challenge without current OKUser");
        return;
    } else if ([[OKUser currentUser] fbUserID] == nil) {
        OKLog(@"Cant issue push challenge without user having fbID");
        return;
    } else if (![OKFacebookUtilities isFBSessionOpen]) {
        OKLog(@"Can't issue push challenge without open FB session ");
        return;
    }
    
    // See if the score was a top score
    BOOL wasTopScore = [OKHelper getBOOLSafeForKey:@"is_users_best" fromJSONDictionary:responseObject];
    if(!wasTopScore) {
        OKLog(@"Score submitted was not users best");
        return;
    }
    
    OKScore *topScore = [[OKScore alloc] initFromJSON:responseObject];
    if(!topScore ) {
        OKLog(@"Score JSON wasn't valid, couldn't create score");
        return;
    }
    
    OKLeaderboard *leaderboard;
    NSDictionary *leaderboardJSON = [OKHelper getNSDictionarySafeForKey:@"leaderboard" fromJSONDictionary:responseObject];
    
    if(leaderboardJSON != nil) {
        leaderboard = [[OKLeaderboard alloc] initFromJSON:leaderboardJSON];
    } else {
        OKLog(@"Didn't get leaderboard JSON in response, can't issue push challenge");
        return;
    }
    
    // Get the social scores
    [leaderboard getFacebookFriendsScoresWithCompletionHandler:^(NSArray *scores, NSError *error) {
        
        if(!error && scores != nil) {
            [self issuePushChallengeforLeaderboard:leaderboard withUserTopScore:topScore withPreviousScore:previousScore withFriendsScores:scores];
        } else {
            OKLog(@"Didn't get friends scores, so not sending push challenge");
        }
    }];
}

// Given a leaderboard, player top score, and list of social scores, figures out which OKScore objects (and their OKUsers) get sent
// a challenge
+(void)issuePushChallengeforLeaderboard:(OKLeaderboard*)leaderboard withUserTopScore:(OKScore*)topScore withPreviousScore:(OKScore*)previousScore withFriendsScores:(NSArray*)friendsScores
{
    // If there was no previous score stored, create a previous score with the maximum allowed value for a score
    // type based on the leaderboard sort type. 
    if(previousScore == nil)
    {
        previousScore = [[OKScore alloc] init];
        
        if([leaderboard sortType] == OKLeaderboardSortTypeHighValue) {
            previousScore.scoreValue = 0;
        } else {
            previousScore.scoreValue = INT64_MAX;
        }
    }
    
    OKLog(@"Sorting social scores to figure out which will get a challenge");
    OKLog(@"Player's previous top score is: %lld, and new top score is: %lldd", [previousScore scoreValue], [topScore scoreValue]);
    
    
    // Go through the list of friends' scores, and find scores which are < playerTopScore && > previousScore
    // If there was no previous score, the above code sets the "previous score" to the min and max values depending
    // on sort type so that all friends below the player's top score get a push
    
    NSMutableArray *scoresToSendPushTo = [[NSMutableArray alloc] init];
    for(int x = 0; x < [friendsScores count]; x++)
    {
        OKScore *score = [friendsScores objectAtIndex:x];
        
        if([leaderboard sortType] == OKLeaderboardSortTypeHighValue) {
            if([score scoreValue] < [topScore scoreValue] && [score scoreValue] > [previousScore scoreValue]) {
                [scoresToSendPushTo addObject:score];
            }
        } else {
            if([score scoreValue] > [topScore scoreValue] && [score scoreValue] < [previousScore scoreValue]) {
                [scoresToSendPushTo addObject:score];
            }
        }
    }
    
    if([scoresToSendPushTo count] > 0) {
        [self issuePushChallengeForListOfOKScores:scoresToSendPushTo andLeaderboard:leaderboard];
    } else {
        OKLog(@"Not sending push because top score was not actually better than any friends scores");
    }
}

// Actually issue the challenge
+(void)issuePushChallengeForListOfOKScores:(NSArray*)scores andLeaderboard:(OKLeaderboard*)leaderboard
{
    OKLog(@"Doing the network call to issue push challenge");
    OKLog(@"Sending challenge to %d users", [scores count]);
    
    NSMutableArray *friends_receiver_ids = [[NSMutableArray alloc] init];
    
    for(int x = 0; x < [scores count]; x++)
    {
        OKScore *friend_score = [scores objectAtIndex:x];
        [friends_receiver_ids addObject:[[friend_score user] OKUserID]];
    }
    
    NSDictionary *params = [NSDictionary dictionaryWithObjectsAndKeys:
                            friends_receiver_ids, @"receiver_ids",
                            [[OKUser currentUser] OKUserID], @"sender_id",
                            [OKUtils createUUID], @"challenge_uuid",
                            [OKUtils sqlStringFromDate:[NSDate date]], @"client_created_at",
                            nil];
    NSString *path = [NSString stringWithFormat:@"/leaderboards/%i/challenges", leaderboard.OKLeaderboard_id];
    
    [OKNetworker postToPath:path parameters:params handler:^(id responseObject, NSError *error) {
        if(error) {
            OKLog(@"Error from server is: %@", error);
        }
    }];
}


@end
