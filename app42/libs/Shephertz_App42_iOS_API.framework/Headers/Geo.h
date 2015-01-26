//
//  Geo.h
//  PAE_iOS_SDK
//
//  Created by shephertz technologies on 11/04/12.
//  Copyright (c) 2012 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "App42Response.h"

/**
 *
 * This Geo object is the value object which contains the properties of Geo
 * along with the setter & getter for those properties.
 *
 */


@interface Geo : App42Response
{
    
    NSString *storageName;
    NSString *sourceLat;
    NSString *sourceLng;   
    double distanceInKM;
    NSDate *createdOn;
    NSMutableArray *pointList;
    
}
/*!
 *set and get the name of the storage.
 */
@property(nonatomic,retain)NSString *storageName;
/*!
 *set and get the source lat point for geo.
 */
@property(nonatomic,retain)NSString *sourceLat;
/*!
 *set and get the source lng point for geo.
 */
@property(nonatomic,retain)NSString *sourceLng;
/*!
 *set and get the distance in km for geo.
 */
@property(nonatomic,assign)double distanceInKM;
/*!
 *set and get the time, day and date when the geo was created.
 */
@property(nonatomic,retain)NSDate *createdOn;
/*!
 *set and get the list of all the points in the geo.
 */
@property(nonatomic,retain)NSMutableArray *pointList;


@end
