//
//  Reward.h
//  PAE_iOS_SDK
//
//  Created by shephertz technologies on 11/04/12.
//  Copyright (c) 2012 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "App42Response.h"

/**
 *
 * This Reward object is the value object which contains the properties of
 * Reward along with the setter & getter for those properties.
 *
 */


@interface Reward : App42Response{
    
    NSString *gameName;
    NSString *userName;
    NSString *name;
    NSString *description;
    double points;
    double rank;
    
}
/*!
 *set and get the name of the Game which has to be created.
 */
@property(nonatomic,retain)NSString *gameName;
/*!
 *set and get the user name of the Game.
 */
@property(nonatomic,retain)NSString *userName;
/*!
 *set and get the name of the reward.
 */
@property(nonatomic,retain)NSString *name;
/*!
 *set and get the description of the game.
 */
@property(nonatomic,retain)NSString *description;
/*!
 *set and get the points to the Reward.
 */
@property(nonatomic,assign)double points;

/*!
 *set and get the rank of the user.
 */
@property(nonatomic,assign)double rank;


@end
