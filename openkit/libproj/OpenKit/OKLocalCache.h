//
//  OKLocalCache.h
//  OpenKit
//
//  Created by Louis Zell on 8/20/13.
//  Copyright (c) 2013 OpenKit. All rights reserved.
//
// --------------------------------------------------------------------
//
// This is a very light wrapper over FMDB.  It creates sqlite databases in the
// ApplicationSupport directory. Note, this class is configured to _not_ backup
// contents in iCloud.  If a user changes device, contents of this cache will
// not be found.
//
// Please see the section marked "API".

#define OK_CACHE_USES_MAIN    0
#if OK_CACHE_USES_MAIN
#define OK_CACHE_QUEUE()  dispatch_get_main_queue()
#else
extern dispatch_queue_t __OKCacheQueue;
#define OK_CACHE_QUEUE() ((__OKCacheQueue == nil) ? (__OKCacheQueue = dispatch_queue_create("com.openkit.cache_queue", NULL)) : __OKCacheQueue)
#endif



@class FMDatabase;
#import <Foundation/Foundation.h>

@interface OKLocalCache : NSObject
{
    NSString *_createSql;
    NSString *_version;
    FMDatabase *_database;
    int lastInsertRowID;
}
@property (nonatomic, readonly) NSString *name;


#pragma mark - API
- (id)initWithCacheName:(NSString *)name createSql:(NSString *)sql version:(NSString *)version;
- (void)access:(void(^)(FMDatabase *))block;

// You can use this for insert/update/delete without access block.  Selects should
// go through access block so FMResultSet access is contained.
- (BOOL)update:(NSString *)sql, ...;

// Get the autoincrement primary key int ID of the last inserted row
-(int)lastInsertRowID;

// Get the last error message from FMDB
-(NSString*)lastErrorMessage;

#pragma mark - OK Specific
- (BOOL)insertToken:(NSString *)tokenStr;

@end
