//
//  FacebookProfile.h
//  PAE_iOS_SDK
//
//  Created by Rajeev on 17/12/13.
//  Copyright (c) 2013 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>

@class Score;
@interface FacebookProfile : NSObject

/*!
 *set and get the game user name for which scores have to be added.
 */
@property(nonatomic,retain) NSString *name;

/*!
 *set and get the game user name for which scores have to be added.
 */
@property(nonatomic,retain) NSString *fbId;

/*!
 *set and get the game user name for which scores have to be added.
 */
@property(nonatomic,retain) NSString *picture;

/*!
 *set and get the Score.
 */
@property(nonatomic,retain) Score *scoreObj;


//-(id)init __attribute__((unavailable));

-(id)initWithScore:(Score*)score;


@end
