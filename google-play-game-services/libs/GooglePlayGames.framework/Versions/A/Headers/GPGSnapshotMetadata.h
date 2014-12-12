//
// Google Play Games Platform Services
// Copyright 2013 Google Inc. All rights reserved.
//
#import "GPGEnums.h"

@class GPGSnapshotMetadata;
@class GPGSnapshotMetadataChange;

typedef void (^GPGSnapshotCompletionBlock)(NSError *error);

typedef void (^GPGSnapshotListBlock)(NSArray *snapshotMetadata, NSError *error);

typedef void (^GPGSnapshotOpenBlock)(GPGSnapshotMetadata *snapshot,
                                     NSString *conflictId,
                                     GPGSnapshotMetadata *conflictingSnapshot,
                                     GPGSnapshotMetadata *conflictingSnapshotUnmerged,
                                     NSError *error);

typedef void (^GPGSnapshotReadBlock)(NSData *data, NSError *error);

typedef void (^GPGSnapshotDeleteBlock)(NSError *error);


typedef void (^GPGSnapshotCommitBlock)(GPGSnapshotMetadata *snapshotMetadata, NSError *error);



@interface GPGSnapshotMetadata : NSObject

@property(readonly, nonatomic, copy) NSString *fileName;

@property(readonly, nonatomic, copy) NSString *snapshotDescription;

@property(readonly, nonatomic, assign) int64_t lastModifiedTimestamp;

@property(readonly, nonatomic, assign) int64_t playedTime;

@property(readonly, nonatomic, strong) NSURL *coverImageUrl;

@property(readonly, nonatomic, assign) BOOL isOpen;


+ (void)listWithCompletionHandler:(GPGSnapshotListBlock)completionHandler;

+ (void)openWithFileName:(NSString *)fileName
          conflictPolicy:(GPGSnapshotConflictPolicy)conflictPolicy
       completionHandler:(GPGSnapshotOpenBlock)completionHandler;

- (void)commitWithMetadataChange:(GPGSnapshotMetadataChange *)metadataChange
                            data:(NSData *)data
               completionHandler:(GPGSnapshotCommitBlock)completionHandler;

- (void)resolveWithMetadataChange:(GPGSnapshotMetadataChange *)metadataChange
                       conflictId:(NSString *)conflictId
                             data:(NSData *)data
                completionHandler:(GPGSnapshotCommitBlock)completionHandler;
- (void)readWithCompletionHandler:(GPGSnapshotReadBlock)completionHandler;

- (void)deleteWithCompletionHandler:(GPGSnapshotDeleteBlock)completionHandler;


@end
