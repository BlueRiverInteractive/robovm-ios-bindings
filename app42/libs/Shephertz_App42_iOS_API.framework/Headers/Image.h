//
//  Image.h
//  App42_iOS_SERVICE_APIs
//
//  Created by Shephertz Technology on 21/02/12.
//  Copyright (c) 2012 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "App42Response.h"

/**
 *
 * This Queue object is the value object which contains the properties of Queue
 * along with the setter & getter for those properties.
 *
 */

@interface Image : App42Response{
    
}
/*!
 *set and get the name of the image.
 */
@property(nonatomic,retain) NSString *name;
/*!
 *set and get the action that has to be done on image.
 */
@property(nonatomic,retain) NSString *action;
/*!
 *set and get the original image.
 */
@property(nonatomic,retain) NSString *originalImage;
/*!
 *set and get the converted Image of the original image.
 */
@property(nonatomic,retain) NSString *convertedImage;
/*!
 *set and get the Tiny Url of the original image.
 */
@property(nonatomic,retain) NSString *originalImageTinyUrl;
/*!
 *set and get the Tiny url of the converted image.
 */
@property(nonatomic,retain) NSString *convertedImageTinyUrl;
/*!
 *set and get the percentage value for the image.
 */
@property(nonatomic,assign) double percentage;
/*!
 *set and get the width value for the image.
 */
@property(nonatomic,assign) int width;
/*!
 *set and get the height value for the image.
 */
@property(nonatomic,assign) int height;
/*!
 *set and get the x value for the image.
 */
@property(nonatomic,assign) int x;
/*!
 *set and get the y value for the image.
 */
@property(nonatomic,assign) int y;


@end
