//
//  Score.h
//  PAE_iOS_SDK
//
//  Created by shephertz technologies on 11/04/12.
//  Copyright (c) 2012 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "App42Response.h"
#import "MetaResponse.h"


@class Game;
@class FacebookProfile;

/**
 * An inner class that contains the remaining properties of the Game.
 */
@interface Score : MetaResponse
{
    NSString *userName;
    NSString *rank;
    NSDate *createdOn;
    double value;
    NSString *scoreId;
    Game *gameObject;
    
}
/*!
 *set and get the game user name for which scores have to be added.
 */
@property(nonatomic,retain)NSString *userName;
/*!
 *set and get the rank for the game.
 */
@property(nonatomic,retain)NSString *rank;
/*!
 *set and get the time when the game was created.
 */
@property(nonatomic,retain)NSDate *createdOn;
/*!
 *set and get the id of the score
 */
@property(nonatomic, retain)NSString *scoreId;
/*!
 *set and get the value for the game.
 */
@property(nonatomic,assign)double value;
/*!
 *set and get the gameObject for Score 
 */
@property(nonatomic,retain)Game *gameObject;

/*!
 *set and get the gameObject for Score
 */
@property(nonatomic,retain) FacebookProfile *facebookProfile;


- (id) init __attribute__((unavailable));

-(id)initWithGame:(Game*)gameObj;

@end
