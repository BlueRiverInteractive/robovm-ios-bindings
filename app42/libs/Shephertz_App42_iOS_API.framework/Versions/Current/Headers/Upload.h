//
//  Upload.h
//  App42_iOS_SERVICE_APIs
//
//  Created by shephertz technologies on 15/02/12.
//  Copyright (c) 2012 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "App42Response.h"

/**
 *
 * This Upload object is the value object which contains the properties of
 * Upload along with the setter & getter for those properties.
 *
 */

@interface Upload : App42Response{
   
}
/*!
 *set and get tthe list of all the files.
 */
@property(nonatomic,retain)NSMutableArray *fileListArray;

@end
