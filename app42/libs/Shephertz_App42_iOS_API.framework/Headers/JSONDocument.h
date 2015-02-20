//
//  JSONDocument.h
//  PAE_iOS_SDK
//
//  Created by Shephertz Technology on 13/04/12.
//  Copyright (c) 2012 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "App42File.h"

@class Storage;
@class GeoTag;
/**
 * An inner class that contains the remaining properties of the Storage.
 *
 */


@interface JSONDocument : App42File
{
    NSString *jsonDoc;
    NSString *docId;
    NSString *owner;
    Storage *storageObject;
    NSMutableArray *aclList;
}
/*!
 *set and get the json doc for Storage.
 */
@property(nonatomic,retain)NSString *jsonDoc;
/*!
 *set and get the owner of Storage.
 */
@property(nonatomic,retain)NSString *owner;
/*!
 *set and get the document Id for the Storage.
 */
@property(nonatomic,retain)NSString *docId;

/*!
 *set and get createdAt for the Storage.
 */
@property(nonatomic,retain)NSString *createdAt;

/*!
 *set and get updatedAt for the Storage.
 */
@property(nonatomic,retain)NSString *updatedAt;

/*!
 *set and get updatedAt for the Storage.
 */
@property(nonatomic,retain)NSString *event;

/*!
 * Sets the ACL list on document object
 */
@property(nonatomic,retain)NSMutableArray *aclList;

/*!
 *set and get the storageObject for JSONDocument Object.
 */
@property(nonatomic,retain)Storage *storageObject;

/*!
 *set and get the GeoTag for JSONDocument Object.
 */
@property(nonatomic,retain) GeoTag *loc;

/*!
 * Sets the File list on document object
 */
@property(nonatomic,retain)NSMutableArray *fileList;


//- (id) init __attribute__((unavailable));

-(id)initWithStorage:(Storage*)storageObj;

@end
