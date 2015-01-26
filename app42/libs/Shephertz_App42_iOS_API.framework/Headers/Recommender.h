//
//  Recommender.h
//  PAE_iOS_SDK
//
//  Created by shephertz technologies on 11/04/12.
//  Copyright (c) 2012 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "App42Response.h"

/**
 *
 * This Recommender object is the value object which contains the properties of
 * Recommender along with the setter & getter for those properties.
 *
 */


@interface Recommender : App42Response{
    
    NSString *fileName;
    NSMutableArray *recommendedItemList;
    
}
/*!
 *set and get the fileName of the Recommender. 
 */
@property(nonatomic,retain)NSString *fileName;
/*!
 *set and get the recommended Item List for Recommender.
 */
@property(nonatomic,retain)NSMutableArray *recommendedItemList;

@end
