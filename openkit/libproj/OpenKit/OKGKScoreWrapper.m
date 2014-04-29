//
//  OKGKScoreWrapper.m
//  OpenKit
//
//  Created by Suneet Shah on 6/13/13.
//  Copyright (c) 2013 OpenKit. All rights reserved.
//

#import "OKGKScoreWrapper.h"

@implementation OKGKScoreWrapper

@synthesize score, player, explicitlySetRank;

/** OKScoreProtocol Implementation **/
-(NSString*)scoreDisplayString {
    return [[self score] formattedValue];
}
-(NSString*)userDisplayString {
    return [[self player] displayName];
}

-(NSString*)rankDisplayString {
    
    if([self explicitlySetRank])
        return explicitlySetRank;
    
    return [NSString stringWithFormat:@"%d",[[self score] rank]];
}

-(int64_t)scoreValue {
    return [[self score] value];
}

-(int)rank {
    return [[self score] rank];
}

-(void)setRank:(NSInteger)rank {
    [self setExplicitlySetRank:[NSString stringWithFormat:@"%d",rank]];
}

-(OKScoreSocialNetwork)socialNetwork {
    return OKScoreSocialNetworkGameCenter;
}


@end
