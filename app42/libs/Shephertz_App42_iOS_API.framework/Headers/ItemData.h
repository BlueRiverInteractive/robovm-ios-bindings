//
//  ItemData.h
//  App42_iOS_SERVICE_APIs
//
//  Created by Shephertz Technology on 17/02/12.
//  Copyright (c) 2012 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>
/**
 *
 * This ItemData object is the value object which contains the properties of
 * ItemData along with the setter & getter for those properties.
 *
 */
@interface ItemData : NSObject{
    NSString *itemId;
    NSString *name;
    NSString *image;
    NSString *description;
    double price;
    NSData *imageInputStream;
    NSString *imageName;
}
/*!
 *set the price of the Item in Catalogue.
 */
@property(nonatomic)double price;
/*!
 *set the itemId of the Catalogue.
 */
@property(nonatomic,retain)NSString *itemId;
/*!
 *set the name of the Catalogue.
 */
@property(nonatomic,retain)NSString *name;
/*!
 *set the image of the Item in Catalogue.
 */
@property(nonatomic,retain)NSString *image;
/*!
 *set the description of the Catalogue.
 */
@property(nonatomic,retain)NSString *description;
/*!
 *set the imageInputStream of the Item in Catalogue.
 */
@property(nonatomic,retain)NSData *imageInputStream;
/*!
 *set the imageName of the Item in Catalogue.
 */
@property(nonatomic,retain)NSString *imageName;

@end
