//
//  CategoryData.h
//  PAE_iOS_SDK
//
//  Created by Shephertz Technology on 13/04/12.
//  Copyright (c) 2012 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "App42Response.h"
@class Catalogue;

/**
 * An inner class that contains the remaining properties of the Catalogue.
 *
 */

@interface CategoryData : App42Response{
   
}
/*!
 *set and get the name of the Category.
 */
@property(nonatomic,retain)NSString *name;
/*!
 *set and get the description of the Category. 
 */
@property(nonatomic,retain)NSString *description;
/*!
 *set and get the itemList of the Category.
 */
@property(nonatomic,retain)NSMutableArray *itemListArray;
/*!
 *set and get the catalogueObject for CategoryData Object 
 */
@property(nonatomic,retain)Catalogue *catalogueObject;

- (id) init __attribute__((unavailable));

-(id)initWithCatalogue:(Catalogue*)catalogueObj;



@end
