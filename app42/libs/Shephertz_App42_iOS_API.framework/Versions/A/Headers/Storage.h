//
//  Storage.h
//  App42_iOS_SERVICE_APIs
//
//  Created by shephertz technologies on 15/02/12.
//  Copyright (c) 2012 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>

#import "App42Response.h"

/**
 *
 * This Storage object is the value object which contains the properties of
 * Storage along with the setter & getter for those properties.
 *
 */

@class JSONDocument;
@interface Storage : App42Response
{
    NSString *dbName;
    NSString *collectionName;
    NSMutableArray *jsonDocArray;
}
/*!
 *set and get the name of the database.
 */
@property(nonatomic,retain) NSString *dbName;

/*!
 *set and get the name of the database.
 */
@property(nonatomic,assign) int recordCount;


/*!
 *set and get the collection name of storage.
 */
@property(nonatomic,retain) NSString *collectionName;
/*!
 *set and get the jsonDocArray for Storage Object which contains JSONDocument Objects.
 */
@property(nonatomic,retain) NSMutableArray *jsonDocArray;

@end
