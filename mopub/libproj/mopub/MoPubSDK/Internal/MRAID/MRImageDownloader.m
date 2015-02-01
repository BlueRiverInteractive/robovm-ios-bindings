//
// Copyright (c) 2013 MoPub. All rights reserved.
//

#import "MRImageDownloader.h"
#import "MPCoreInstanceProvider.h"

@interface MRAIDStorePictureOperation : NSOperation

@property (nonatomic, strong) NSURL *URL;
@property (nonatomic, strong) NSData *imageData;

- (id)initWithURL:(NSURL *)URL;

@end

@implementation MRAIDStorePictureOperation

@synthesize URL = _URL;
@synthesize imageData = _imageData;

- (id)initWithURL:(NSURL *)URL
{
    if (self = [super init]) {
        self.URL = URL;
    }
    return self;
}


- (void)main
{
    self.imageData = [NSData dataWithContentsOfURL:self.URL];
}

@end

@implementation MRImageDownloader

@synthesize queue = _queue;
@synthesize delegate = _delegate;
@synthesize pendingOperations = _pendingOperations;

- (id)initWithDelegate:(id<MRImageDownloaderDelegate>)delegate
{
    self = [super init];

    if (self) {
        self.delegate = delegate;
        self.pendingOperations = [NSMutableDictionary dictionary];
    }

    return self;
}


- (void)downloadImageWithURL:(NSURL *)URL
{
    if (!self.queue) {
        self.queue = [[MPCoreInstanceProvider sharedProvider] sharedOperationQueue];
    }

    if ([self.pendingOperations objectForKey:URL]) {
        // Already trying to download this image, so no need to kick off another download.
        return;
    }

    MRAIDStorePictureOperation *operation = [[MRAIDStorePictureOperation alloc] initWithURL:URL];
    [operation addObserver:self forKeyPath:@"isFinished" options:NSKeyValueObservingOptionNew context:nil];
    [self.pendingOperations setObject:operation forKey:URL];
    [self.queue addOperation:operation];
}

- (void)observeValueForKeyPath:(NSString *)keyPath ofObject:(id)object change:(NSDictionary *)change context:(void *)context
{
    if ([keyPath isEqualToString:@"isFinished"] &&
            [[change objectForKey:NSKeyValueChangeKindKey] unsignedIntegerValue] == NSKeyValueChangeSetting &&
            [[change objectForKey:NSKeyValueChangeNewKey] boolValue] == YES) {
        MRAIDStorePictureOperation *operation = object;
        [self performSelectorOnMainThread:@selector(saveImageForOperation:)
                               withObject:operation
                            waitUntilDone:NO];
    }
}

- (void)saveImageForOperation:(MRAIDStorePictureOperation *)operation
{
    UIImage *image = [UIImage imageWithData:operation.imageData];
    UIImageWriteToSavedPhotosAlbum(image, self, @selector(image:didFinishSavingWithError:contextInfo:), (__bridge void *)(operation));
}

- (void)image:(UIImage *)image didFinishSavingWithError:(NSError *)error contextInfo:(void *)contextInfo
{
    MRAIDStorePictureOperation *operation = (__bridge MRAIDStorePictureOperation *)(contextInfo);

    if (error) {
        [self.delegate downloaderDidFailToSaveImageWithURL:operation.URL error:error];
    }

    [operation removeObserver:self forKeyPath:@"isFinished"];
    [self.pendingOperations removeObjectForKey:operation.URL];
}

@end
