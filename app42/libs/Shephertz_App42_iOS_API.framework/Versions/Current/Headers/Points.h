//
//  Points.h
//  PAE_iOS_SDK
//
//  Created by Shephertz Technology on 12/04/12.
//  Copyright (c) 2012 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "App42Response.h"
#import "Geo.h"

/**
 * An inner class that contains the remaining properties of the Geo.
 *
 */

@interface Points : App42Response
{
    double lat;
    double lng;
    NSString *marker;
    Geo *geoObject;
}
/*!
 *set and get the lat point for Geo.
 */
@property(nonatomic,assign)double lat;
/*!
 *set and get the lng point for Geo.
 */
@property(nonatomic,assign)double lng;
/*!
 *set and get the marker point for Geo.
 */
@property(nonatomic,retain)NSString *marker;
/*!
 *set and get the geoObject Ref for Points Object.
 */
@property(nonatomic,retain)Geo *geoObject;

- (id) init __attribute__((unavailable));

-(id)initWithGeo:(Geo*)geoObj;
@end
