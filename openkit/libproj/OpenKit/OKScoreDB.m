//
//  OKScoreDB.m
//  OpenKit
//
//  Created by Suneet Shah on 10/3/13.
//  Copyright (c) 2013 OpenKit. All rights reserved.
//

#import "OKScoreDB.h"
#import "OKScore.h"
#import "OKMacros.h"
#import "OKHelper.h"
#import "OKUser.h"
#import "OKNetworker.h"
#import "FMResultSet.h"
#import "FMDatabase.h"


// DB Schema is:
// --------------------------------------------------------------------------------
// | integer | integer       | Bigint     | integer  | varchar(255)  | integer   |
// --------------------------------------------------------------------------------
// | id      | leaderboardID | scoreValue | metadata | displayString | submitted |


static NSString* const dbVersion = @"1";
static NSString* const dbName = @"okScoreCache";
static NSString* const kScoreTableCreateSQL = @"CREATE TABLE IF NOT EXISTS OKCACHE(id INTEGER PRIMARY KEY AUTOINCREMENT, leaderboardID INTEGER, scoreValue BIGINT, metadata INTEGER, displayString VARCHAR(255), submitted BOOLEAN);";

@implementation OKScoreDB
@synthesize previousSubmittedScore;

+ (OKScoreDB*)sharedCache
{
    static dispatch_once_t pred;
    static OKScoreDB *sharedInstance = nil;
    dispatch_once(&pred, ^{
        sharedInstance = [[OKScoreDB alloc] init];
    });
    return sharedInstance;
}


-(id)init
{
    self = [super initWithCacheName:dbName createSql:kScoreTableCreateSQL version:dbVersion];
    
    if(self) {
        // Custom init code
    }
    return self;
}

-(void)insertScore:(OKScore*)score
{
    NSString *scoreUpdateString = @"INSERT INTO OKCACHE (leaderboardID,scoreValue,metadata,displayString,submitted) VALUES(?,?,?,?,?)";
    
    BOOL inserted = [self update:scoreUpdateString,
                     [NSNumber numberWithInt:score.OKLeaderboardID],
                     [NSNumber numberWithLongLong:score.scoreValue],
                     [NSNumber numberWithInt:score.metadata],
                     score.displayString,
                     [NSNumber numberWithBool:score.submitted]];
    
    if(inserted) {
        int scoreID = [self lastInsertRowID];
        [score setOKScoreID:scoreID];
        
        if(scoreID == 0) {
            OKLogInfo(@"Failed to get last inserted row");
        }
    } else {
        OKLog(@"Failed to insert score in db with error message %@", [self lastErrorMessage]);
    }
}

-(void)deleteScore:(OKScore*)score
{
    if(![score OKScoreID]) {
        OKLog(@"Tried to remove a score without a scoreID set from cache db");
        return;
    }
    
    NSString *deleteSQL = @"DELETE FROM OKCACHE WHERE id=?";
    
    BOOL deleted = [self update:deleteSQL,[NSNumber numberWithInt:[score OKScoreID]]];
    
    if(deleted) {
        OKLogInfo(@"Removed score: %@", score);
    } else {
        OKLog(@"Failed to remove score in cache with error message%@",[self lastErrorMessage]);
    }
}

-(void)updateCachedScoreSubmitted:(OKScore*)score
{
    if(![score OKScoreID]) {
        OKLog(@"Tried to update a score without a scoreID set from cache db");
        return;
    }
    
    NSString *updateString = @"UPDATE OKCACHE SET Submitted=1 WHERE id=?";
    
    BOOL updated = [self update:updateString, [NSNumber numberWithInt:[score OKScoreID]]];
    
    if(!updated) {
        OKLog(@"Failed to update score row with error message %@", [self lastErrorMessage]);
    }
}

-(NSArray*)getAllCachedScores
{
    NSString *querySQL = @"SELECT * FROM OKCACHE";
    return [self getCachedScoresWithSQL:querySQL];
}

-(NSArray*)getCachedScoresForLeaderboardID:(int)leaderboardID andOnlyGetSubmittedScores:(BOOL)submittedOnly
{
    //OKLog(@"Getting cached scores for leaderboard ID: %d",leaderboardID);
    NSString *queryString;
    
    if(submittedOnly) {
        queryString = [NSString stringWithFormat:@"SELECT * FROM OKCACHE WHERE leaderboardID=%d AND submitted=1",leaderboardID];
    } else {
        queryString = [NSString stringWithFormat:@"SELECT * FROM OKCACHE WHERE leaderboardID=%d",leaderboardID];
    }
    return [self getCachedScoresWithSQL:queryString];
}

-(NSArray*)getUnsubmittedCachedScores
{
    NSString *queryString = [NSString stringWithFormat:@"SELECT * FROM OKCACHE WHERE submitted=0"];
    return [self getCachedScoresWithSQL:queryString];
}

-(NSArray*)getCachedScoresWithSQL:(NSString*)selectSQL
{
    __block NSArray *scores = nil;
    [self access:^(FMDatabase *db) {
        FMResultSet *rs = [db executeQuery:selectSQL];
        scores = [self getArrayOfScoresFromResultSet:rs];
    }];
    
    return scores;
}

-(NSMutableArray*)getArrayOfScoresFromResultSet:(FMResultSet*)resultSet
{
    NSMutableArray *scoresArray = [[NSMutableArray alloc] init];
    
    while([resultSet next]) {
        OKScore *score = [self getScoreFromResultSet:resultSet];
        [scoresArray addObject:score];
    }
    
    return scoresArray;
}

-(OKScore*)getScoreFromResultSet:(FMResultSet*)resultSet
{
    OKScore *scoreRow = [[OKScore alloc] init];
    
    [scoreRow setOKScoreID:[resultSet intForColumn:@"id"]];
    [scoreRow setOKLeaderboardID:[resultSet intForColumn:@"leaderboardID"]];
    [scoreRow setScoreValue:[resultSet longLongIntForColumn:@"scoreValue"]];
    [scoreRow setMetadata:[resultSet intForColumn:@"metadata"]];
    
    NSString *displayString = [resultSet stringForColumn:@"displayString"];
    
    if(displayString && ![OKHelper isEmpty:displayString]) {
        [scoreRow setDisplayString:displayString];
    }
    
    [scoreRow setSubmitted:[resultSet boolForColumn:@"submitted"]];
    
    return scoreRow;
}

-(void)submitCachedScore:(OKScore *)score
{
    
    if([OKUser currentUser]) {
        [score setUser:[OKUser currentUser]];
        
        [score cachedScoreSubmit:^(NSError *error) {
            if(!error) {
                [self updateCachedScoreSubmitted:score];
                OKLog(@"Submitted cached core succesfully");
            } else {
                // If the error code returned is in the 400s, delete the score from the cache
                int errorCode = [OKNetworker getStatusCodeFromAFNetworkingError:error];
                if(errorCode >= 400 && errorCode <= 500) {
                    OKLog(@"Deleted cached score because of error code: %d",errorCode);
                    [self deleteScore:score];
                }
                OKLog(@"Failed to submit cached score");
            }
        }];
        
    } else {
        OKLog(@"Tried to submit a cached score without having an OKUser logged in");
        return;
    }
}

-(void)clearCachedSubmittedScores
{
    OKLogInfo(@"Clear cached submitted scores");
    OKLogInfo(@"Score cache before delete: %@", [self getAllCachedScores]);
    
    NSString *deleteSQL = @"DELETE FROM OKCACHE WHERE submitted=1";
    
    BOOL success = [self update:deleteSQL];
    
    if(success) {
        OKLogInfo(@"Cleared all cached submitted scores");
    } else {
        OKLog(@"Failed to clear cached scores");
    }
    
    OKLogInfo(@"Score cache after delete: %@", [self getAllCachedScores]);
}

-(void)submitAllCachedScores
{
    if(![OKUser currentUser])
        return;
    
    NSArray *cachedScores = [self getUnsubmittedCachedScores];
    
    if([cachedScores count] > 0)
    {
        OKLogInfo(@"Submiting %d cached OpenKit scores", [cachedScores count]);
        
        for(int x = 0; x < [cachedScores count]; x++)
        {
            OKScore *score = [cachedScores objectAtIndex:x];
            [self submitCachedScore:score];
        }
    }
}



-(BOOL)isScoreBetterThanLocalCachedScores:(OKScore *)score
{
    return [self isScoreBetterThanLocalCachedScores:score storeScore:NO force:NO];
}

-(void)storeScoreIfBetter:(OKScore*)score
{
    [self isScoreBetterThanLocalCachedScores:score storeScore:YES force:NO];
}

//Returns YES if the score is stored in the cache
-(BOOL)isScoreBetterThanLocalCachedScores:(OKScore*)scoreToStore storeScore:(BOOL)shouldStoreScore force:(BOOL)shouldForce
{
    // if (score) > largestCachedScore || score < lowestCachedScore )
    // store it
    // return YES
    // else
    // don't store it, return no
    
    // If there is a user logged in, we should compare against scores that have already been submitted to decide whether
    // to submit the new score, and not all scores. E.g. if there is an unsubmitted score for some reason that has a higher value than the
    // one to submit, we should still submit it. This is because for some reason there might be an unsubmitted score stored that will never
    // get submitted for some unknown reason.
    
    
    NSArray *cachedScores;
    if([OKUser currentUser]) {
        cachedScores = [self getCachedScoresForLeaderboardID:[scoreToStore OKLeaderboardID] andOnlyGetSubmittedScores:YES];
    } else {
        cachedScores = [self getCachedScoresForLeaderboardID:[scoreToStore OKLeaderboardID] andOnlyGetSubmittedScores:NO];
    }
    
    int numCachedScores = [cachedScores count];
    
    if(numCachedScores <= 1) {
        if(shouldStoreScore) {
            [self insertScore:scoreToStore];
        }
        
        // Store the previousSubmittedScore in a var on OKScoreCache
        if(numCachedScores == 0) {
            [self setPreviousSubmittedScore:nil];
        } else if (numCachedScores == 1) {
            [self setPreviousSubmittedScore:[cachedScores objectAtIndex:0]];
        }
        
        return YES;
    } else {
        NSArray *sortedCachedScores = [OKScoreDB sortScoresDescending:cachedScores];
        
        OKScore *highestScore = [sortedCachedScores objectAtIndex:0];
        OKScore *lowestScore = [sortedCachedScores objectAtIndex:numCachedScores-1];
        
        if(shouldForce || [scoreToStore scoreValue] > [highestScore scoreValue]) {
            if(shouldStoreScore) {
                [self insertScore:scoreToStore];
                [self deleteScore:highestScore];
            }
            [self setPreviousSubmittedScore:highestScore];
            return YES;
        } else if (shouldForce || [scoreToStore scoreValue] < [lowestScore scoreValue]) {
            if(shouldStoreScore) {
                [self insertScore:scoreToStore];
                [self deleteScore:lowestScore];
            }
            [self setPreviousSubmittedScore:lowestScore];
            return YES;
        }
    }
    
    return NO;
}


+(NSArray*)sortScoresDescending:(NSArray*)scores
{
    NSSortDescriptor *sortDescriptor = [[NSSortDescriptor alloc] initWithKey:@"scoreValue" ascending:NO];
    NSArray *sortDescriptors = [NSArray arrayWithObject:sortDescriptor];
    NSArray *sortedArray = [scores sortedArrayUsingDescriptors:sortDescriptors];
    
    return sortedArray;
}

- (void)dealloc
{
    // Do not call super here.  Using arc.
}



@end

