//
//  Game.h
//  PAE_iOS_SDK
//
//  Created by shephertz technologies on 11/04/12.
//  Copyright (c) 2012 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "App42Response.h"

/**
 *
 * This Game object is the value object which contains the properties of Game
 * along with the setter & getter for those properties.
 *
 */

@interface Game : App42Response
{
    NSString *name;
    NSString *description;
    NSMutableArray *scoreList;
}
/*!
 *set and get the name of the Game which has to be created.
 */
@property(nonatomic,retain)NSString *name;
/*!
 *set and get the description of the game.
 */
@property(nonatomic,retain)NSString *description;
/*!
 *set and get the score list for the Game.
 */
@property(nonatomic,retain)NSMutableArray *scoreList;

@end
