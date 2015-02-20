//
//  Album.h
//  PAE_iOS_SDK
//
//  Created by shephertz technologies on 11/04/12.
//  Copyright (c) 2012 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "App42Response.h"

/**
 *
 * This Album object is the value object which contains the properties of Album
 * along with the setter & getter for those properties.
 *
 */


@interface Album :  App42Response{
    
    NSString *userName;
    NSString *name;
    NSString *description;
    NSMutableArray *photoList;
    
}
/*!
 *set and get the user name of the album. 
 */
@property(nonatomic,retain)NSString *userName;
/*!
 *set and get the name of the Album. 
 */
@property(nonatomic,retain)NSString *name;
/*!
 *set and get the description of the Album. 
 */
@property(nonatomic,retain)NSString *description;
/*!
 *set and get the list of all the photos for the Album.
 */
@property(nonatomic,retain)NSMutableArray *photoList;

@end


