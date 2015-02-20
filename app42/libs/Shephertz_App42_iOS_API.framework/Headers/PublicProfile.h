//
//  PublicProfile.h
//  PAE_iOS_SDK
//
//  Created by Rajeev Ranjan on 04/02/14.
//  Copyright (c) 2014 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface PublicProfile : NSObject

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

@end
