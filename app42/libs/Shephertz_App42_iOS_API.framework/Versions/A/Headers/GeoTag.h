//
//  GeoTag.h
//  PAE_iOS_SDK
//
//  Created by Rajeev Ranjan on 29/07/13.
//  Copyright (c) 2013 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface GeoTag : NSObject


@property(nonatomic,assign) double lat;
@property(nonatomic,assign) double lng;

-(id)init __attribute__((unavailable));
-(id)initWithLatitude:(double)latitude andLongitude:(double)longitude;

/**
 * Values coming from response are converted NSDictionary.
 *
 * @return NSDictionary
 */
-(NSDictionary*) getGeoTag;
-(NSString*)toString;
@end
