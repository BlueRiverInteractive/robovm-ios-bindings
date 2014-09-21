//
//  MPImageDownloadQueue.m
//
//  Copyright (c) 2014 MoPub. All rights reserved.
//

#import "MPImageDownloadQueue.h"
#import "MPNativeAdError.h"
#import "MPLogging.h"
#import "MPNativeCache.h"

#define kMaxAllowedUIImageSize (1024 * 1024)

@interface MPImageDownloadQueue ()

@property (atomic, retain) NSOperationQueue *imageDownloadQueue;
@property (atomic, assign) BOOL isCanceled;

@end

@implementation MPImageDownloadQueue

- (id)init
{
    self = [super init];

    if (self != nil) {
        _imageDownloadQueue = [[NSOperationQueue alloc] init];
        [_imageDownloadQueue setMaxConcurrentOperationCount:1]; // serial queue
    }

    return self;
}

- (void)dealloc
{
    [_imageDownloadQueue cancelAllOperations];
    [_imageDownloadQueue release];

    [super dealloc];
}

- (void)addDownloadImageURLs:(NSArray *)imageURLs completionBlock:(MPImageDownloadQueueCompletionBlock)completionBlock
{
    [self addDownloadImageURLs:imageURLs completionBlock:completionBlock useCachedImage:YES];
}

- (void)addDownloadImageURLs:(NSArray *)imageURLs completionBlock:(MPImageDownloadQueueCompletionBlock)completionBlock useCachedImage:(BOOL)useCachedImage
{
    __block NSMutableArray *errors = nil;

    for (NSURL *imageURL in imageURLs) {
        [self.imageDownloadQueue addOperationWithBlock:^{
            @autoreleasepool {
                if (![[MPNativeCache sharedCache] cachedDataExistsForKey:imageURL.absoluteString] || !useCachedImage) {
                    MPLogDebug(@"Downloading %@", imageURL);

                    NSURLResponse *response = nil;
                    NSError *error = nil;
                    NSData *data = [NSURLConnection sendSynchronousRequest:[NSURLRequest requestWithURL:imageURL]
                                                         returningResponse:&response
                                                                     error:&error];

                    BOOL validImageDownloaded = data != nil;
                    if (validImageDownloaded) {
                        UIImage *downloadedImage = [UIImage imageWithData:data];
                        BOOL validImageSize = downloadedImage.size.width * downloadedImage.size.height <= kMaxAllowedUIImageSize;
                        if (downloadedImage != nil && validImageSize) {
                            [[MPNativeCache sharedCache] storeData:data forKey:imageURL.absoluteString];
                        } else {
                            if (downloadedImage == nil) {
                                MPLogDebug(@"Error: invalid image data downloaded");
                            } else if (!validImageSize) {
                                MPLogDebug(@"Error: image data exceeds acceptable size limit of 1 MP (actual: %@)", NSStringFromCGSize(downloadedImage.size));
                            }

                            validImageDownloaded = NO;
                        }
                    }

                    if (!validImageDownloaded) {
                        if (error == nil) {
                            error = [NSError errorWithDomain:MoPubNativeAdsSDKDomain code:MPNativeAdErrorImageDownloadFailed userInfo:nil];
                        }

                        if (errors == nil) {
                            errors = [[NSMutableArray array] retain];
                        }

                        [errors addObject:error];
                    }
                }
            }
        }];
    }

    // after all images have been downloaded, invoke callback on main thread
    [self.imageDownloadQueue addOperationWithBlock:^{
        dispatch_async(dispatch_get_main_queue(), ^{
            if (!self.isCanceled) {
                completionBlock([errors autorelease]);
            }
            else {
                [errors release];
            }
        });
    }];
}

- (void)cancelAllDownloads
{
    self.isCanceled = YES;
    [self.imageDownloadQueue cancelAllOperations];
}

@end
