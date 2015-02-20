//
//  File.h
//  PAE_iOS_SDK
//
//  Created by Shephertz Technology on 13/04/12.
//  Copyright (c) 2012 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "App42Response.h"
@class Upload;

/**
 * An inner class that contains the remaining properties of Upload.
 *
 */

@interface File : App42Response{
    
}
/*!
 *set and get the name of the File.
 */
@property(nonatomic,retain)NSString *name;
/*!
 *set and get the name of the User. 
 */
@property(nonatomic,retain)NSString *userName;
/*!
 *set and get the type of the file to be uploaded. 
 */
@property(nonatomic,retain)NSString *type;
/*!
 *set and get the url of the Upload File. 
 */
@property(nonatomic,retain)NSString *url;
/*!
 *set and get the tinyUrl of the Upload File. 
 */
@property(nonatomic,retain)NSString *tinyUrl;
/*!
 *set and get the description of the Upload File.
 */
@property(nonatomic,retain)NSString *description;
/*!
 *set and get the uploadObject for File Object 
 */
@property(nonatomic,retain)Upload *uploadObject;

- (id) init __attribute__((unavailable));

-(id)initWithUpload:(Upload*)uploadObj;

@end
