//
//  Photo.h
//  PAE_iOS_SDK
//
//  Created by shephertz technologies on 11/04/12.
//  Copyright (c) 2012 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "App42Response.h"
#import "Album.h"

/**
 * An inner class that contains the remaining properties of the Album.
 *
 */

@interface Photo : App42Response{
    
    NSString *name;
    NSString *description;
    NSString *url;
    NSString *tinyUrl;
    NSString *thumbnailUrl;
    NSString *thumbNailTinyUrl;
    Album *albumObject;
    NSArray *tagList;
        
}
/*!
 *set and get the name of the photo. 
 */
@property(nonatomic,retain)NSString *name;
/*!
 *set and get the description of the photo.
 */
@property(nonatomic,retain)NSString *description;
/*!
 *set and get the url of the photo. 
 */
@property(nonatomic,retain)NSString *url;
/*!
 *set and get the tiny url of the photo. 
 */
@property(nonatomic,retain)NSString *tinyUrl;
/*!
 *set and get the thumbnail url of the photo. 
 */
@property(nonatomic,retain)NSString *thumbNailUrl;
/*!
 *set and get the thumbnail url of the photo.
 */
@property(nonatomic,retain)NSString *thumbNailTinyUrl;
/*!
 *set and get the createdOn.
 */
@property(nonatomic,retain)NSString *createdOn;
/*!
 *set and get the albumObject for Photo Object. 
 */
@property(nonatomic,retain)Album *albumObject;
/*!
 *set and get the list of all the tags in the photo. 
 */
@property(nonatomic,retain) NSArray *tagList;

- (id) init __attribute__((unavailable));
-(id)initWithAlbum:(Album*)albumObj;

@end
