//
//  OKAchievement.m
//  OpenKit
//
//  Created by Suneet Shah on 12/10/13.
//  Copyright (c) 2013 OpenKit. All rights reserved.
//

#import "OKAchievement.h"
#import "OKHelper.h"
#import "OKNetworker.h"
#import "OKUser.h"
#import "OKMacros.h"
#import "OKError.h"

@implementation OKAchievement

@synthesize achievementID, points, progress, goal, lockedIconURL, unlockedIconURL, description;

-(id)initFromJSON:(NSDictionary*)jsonDict
{
    self = [super init];
    if(self) {
        self.name =             [OKHelper getNSStringSafeForKey:@"name" fromJSONDictionary:jsonDict];
        self.lockedIconURL =    [OKHelper getNSStringSafeForKey:@"icon_locked_url" fromJSONDictionary:jsonDict];
        self.unlockedIconURL =  [OKHelper getNSStringSafeForKey:@"icon_url" fromJSONDictionary:jsonDict];
        self.description =      [OKHelper getNSStringSafeForKey:@"desc" fromJSONDictionary:jsonDict];
        self.achievementID =    [OKHelper getIntSafeForKey:@"id" fromJSONDictionary:jsonDict];
        self.points =           [OKHelper getIntSafeForKey:@"points" fromJSONDictionary:jsonDict];
        self.goal =             [OKHelper getIntSafeForKey:@"goal" fromJSONDictionary:jsonDict];
        self.progress =         [OKHelper getIntSafeForKey:@"progress" fromJSONDictionary:jsonDict];
    }
    return self;
}

+(void)getAchievementsWithCompletionHandler:(void (^)(NSArray *achievements, NSError *error))completionHandler
{
    NSMutableDictionary *requestParams = [[NSMutableDictionary alloc] init];
    
    // If a user_id is supplied, progress for each achievement will come back for this user.
    OKUser *currentUser = [OKUser currentUser];
    if(currentUser != nil) {
        [requestParams setObject:[currentUser OKUserID] forKey:@"user_id"];
    }
    
    [OKNetworker getFromPath:@"achievements" parameters:requestParams handler:^(id responseObject, NSError *error)
    {
        if(!error) {
            if(![responseObject isKindOfClass:[NSArray class]]) {
                OKLog(@"Expected an array of achievements, got back something else");
                completionHandler(nil, [OKError unknownError]);
                return;
            }
            
            NSArray *achievementsJSON = (NSArray*)responseObject;
            NSMutableArray *achievements = [NSMutableArray arrayWithCapacity:[achievementsJSON count]];
            
            for(id obj in achievementsJSON) {
                OKAchievement  *achievement = [[OKAchievement alloc] initFromJSON:obj];
                [achievements addObject:achievement];
            }
            
            completionHandler(achievements, nil);
        } else {
            OKLog(@"Failed to get list of achievements with error: %@",error);
            completionHandler(nil, error);
        }
    }];

}

-(BOOL)unlocked
{
    return (progress >= goal);
}


@end
