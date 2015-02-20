//
//  categoryItem.h
//  PAE_iOS_SDK
//
//  Created by Shephertz Technology on 13/04/12.
//  Copyright (c) 2012 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "App42Response.h"
@class CategoryData;

/**
 *categoryItem class contain the member variables and allowed to be set and get.
 * 
 */

@interface categoryItem : App42Response{
   
}

/*!
 *set and get the name of the Item.
 */
@property(nonatomic,retain)NSString *name;
/*!
 *set and get the description of the Item.
 */
@property(nonatomic,retain)NSString *description;
/*!
 *set and get the itemId of the Item. 
 */
@property(nonatomic,retain)NSString *itemId;
/*!
 *set and get the url of the Item.
 */
@property(nonatomic,retain)NSString *url;
/*!
 *set and get the tinyUrl of the Item. 
 */
@property(nonatomic,retain)NSString *tinyUrl;
/*!
 *set and get the price of the Item.
 */
@property(nonatomic,assign)double price;
/*!
 *set and get the categoryObject for categoryItem Object 
 */
@property(nonatomic,retain)CategoryData *categoryObject;


- (id) init __attribute__((unavailable));

-(id)initWithCategory:(CategoryData*)categoryObj;

@end
