//
// Copyright (c) 2013 MoPub. All rights reserved.
//

#import <Foundation/Foundation.h>

@protocol MRImageDownloaderDelegate;

@interface MRImageDownloader : NSObject

@property (nonatomic, weak) id<MRImageDownloaderDelegate> delegate;
@property (nonatomic, strong) NSOperationQueue *queue;
@property (nonatomic, strong) NSMutableDictionary *pendingOperations;

- (id)initWithDelegate:(id<MRImageDownloaderDelegate>)delegate;
- (void)downloadImageWithURL:(NSURL *)URL;

@end

@protocol MRImageDownloaderDelegate <NSObject>

@required
- (void)downloaderDidFailToSaveImageWithURL:(NSURL *)URL error:(NSError *)error;

@end
