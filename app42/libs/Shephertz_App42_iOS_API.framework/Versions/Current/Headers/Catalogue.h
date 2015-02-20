//
//  Catalogue.h
//  App42_iOS_SERVICE_APIs
//
//  Created by shephertz technologies on 14/02/12.
//  Copyright (c) 2012 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "App42Response.h"
/**
 *
 * This Catalogue object is the value object which contains the properties of
 * Catalogue along with the setter & getter for those properties.
 *
 */


@interface Catalogue : App42Response{
    
}
/*!
 *set and get the name of the Catalogue.
 */
@property(nonatomic,retain)NSString *name;
/*!
 *set and get the description of the Catalogue. 
 */
@property(nonatomic,retain)NSString *description;
/*!
 *set and get the List of the Categories of the Catalogue.
 */
@property(nonatomic,retain)NSMutableArray *categoryListArray;
@end

