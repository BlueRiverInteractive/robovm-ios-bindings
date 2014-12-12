//
// Google Play Games Platform Services
// Copyright 2013 Google Inc. All rights reserved.
//
#import <UIKit/UIKit.h>

@interface GPGSnapshotMetadataChangeCoverImage : NSObject

- (instancetype)initWithImage:(UIImage *)uiImage;

@end

@interface GPGSnapshotMetadataChange : NSObject

@property(nonatomic, copy) NSString *snapshotDescription;

@property(nonatomic, assign) int64_t playedTime;

@property(nonatomic, strong) GPGSnapshotMetadataChangeCoverImage *coverImage;

@end
