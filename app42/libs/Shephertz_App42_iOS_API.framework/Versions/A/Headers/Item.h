//
//  Item.h
//  PAE_iOS_SDK
//
//  Created by Shephertz Technology on 13/04/12.
//  Copyright (c) 2012 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "App42Response.h"
@class Cart;

/**
 * An inner class that contains the remaining properties of the Cart.
 *
 */

@interface Item : App42Response{
    NSString *itemId;
    NSString *name;
    NSString *image;
    int quantity;
    NSDecimalNumber *price;
    double totalAmount;
    Cart *cartObject;
}

/*!
 *set and get the itemId for the items in Cart. 
 */
@property(nonatomic,retain)NSString *itemId;
/*!
 *set and get the name of the item.
 */
@property(nonatomic,retain)NSString *name;
/*!
 *set and get the image of the Item.
 */
@property(nonatomic,retain)NSString *image;
/*!
 *set and get the quantity of the Cart.
 */
@property(nonatomic,assign)int quantity;
/*!
 *set and get the price of the Item in Cart.
 */
@property(nonatomic,assign)NSDecimalNumber *price;
/*!
 *set and get the totalAmount of the Cart. 
 */
@property(nonatomic,assign)double totalAmount;
/*!
 *set and get the cartObject for Item Object 
 */
@property(nonatomic,retain)Cart *cartObject;

- (id) init __attribute__((unavailable));

-(id)initWithCart:(Cart*)cartObj;


@end
