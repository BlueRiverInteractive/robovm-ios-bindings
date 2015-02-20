//
//  GeoPoint.h
//  App42_iOS_SERVICE_APIs
//
//  Created by shephertz technologies on 17/02/12.
//  Copyright (c) 2012 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>
/**
 *
 * This Geo Point object is the value object which contains the properties of
 * Geo Point along with the setter & getter for those properties.
 *
 */
@interface GeoPoint : NSObject{
    double latitude;
    double longitude;
    NSString *marker;
}
/*!
 *set and get the lat point for Geo.
 */
@property(nonatomic)double latitude;
/*!
 *set and get the lng point for Geo.
 */
@property(nonatomic)double longitude;
/*!
 *set and get the marker point for Geo. 
 */
@property(nonatomic,retain)NSString *marker;

-(NSMutableDictionary*)getGeoPointValues;

@end
