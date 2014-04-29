//
//  OKScoreProtocol.h
//  OpenKit
//
//  Created by Suneet Shah on 6/17/13.
//  Copyright (c) 2013 OpenKit. All rights reserved.
//

#import <Foundation/Foundation.h>

typedef enum {
    OKScoreSocialNetworkGameCenter,
    OKScoreSocialNetworkFacebook,
    OKScoreSocialNetworkUnknown
} OKScoreSocialNetwork;

@protocol OKScoreProtocol <NSObject>

-(NSString*)scoreDisplayString;
-(NSString*)userDisplayString;
-(NSString*)rankDisplayString;
-(int)rank;
-(int64_t)scoreValue;
-(void)setRank:(NSInteger)rank;
-(OKScoreSocialNetwork)socialNetwork;
@end
