//
//  GeoQuery.h
//  PAE_iOS_SDK
//
//  Created by Rajeev Ranjan on 29/07/13.
//  Copyright (c) 2013 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>

#define APP42_OP_NEAR                @"$near"
#define APP42_OP_WITHIN              @"$within"

@interface GeoQuery : NSObject

@property(nonatomic,retain) NSMutableDictionary *geoQueryObject;
@property(nonatomic,retain) NSMutableArray *geoQueryObjectArray;

-(id)initWithGeoQuery:(id)geoQueryObj;
-(NSString*)getStr;
@end
