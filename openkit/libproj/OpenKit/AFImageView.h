//
//  AFImageView.h
//  OpenKit
//
//  Created by Suneet Shah on 3/8/13.
//  Copyright (c) 2013 OpenKit. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "AFImageRequestOperation.h"

#import <Availability.h>

#if __IPHONE_OS_VERSION_MIN_REQUIRED
#import <UIKit/UIKit.h>

@interface AFImageView : UIImageView

@property (readwrite, nonatomic, strong, setter = af_setImageRequestOperation:) AFImageRequestOperation *af_imageRequestOperation;

/**
 This category adds methods to the UIKit framework's `UIImageView` class. The methods in this category provide support for loading remote images asynchronously from a URL.
 */

/**
 Creates and enqueues an image request operation, which asynchronously downloads the image from the specified URL, and sets it the request is finished. Any previous image request for the receiver will be cancelled. If the image is cached locally, the image is set immediately, otherwise the specified placeholder image will be set immediately, and then the remote image will be set once the request is finished.
 
 @discussion By default, URL requests have a cache policy of `NSURLCacheStorageAllowed` and a timeout interval of 30 seconds, and are set not handle cookies. To configure URL requests differently, use `setImageWithURLRequest:placeholderImage:success:failure:`
 
 @param url The URL used for the image request.
 */
- (void)setImageWithURL:(NSURL *)url;

/**
 Creates and enqueues an image request operation, which asynchronously downloads the image from the specified URL. Any previous image request for the receiver will be cancelled. If the image is cached locally, the image is set immediately, otherwise the specified placeholder image will be set immediately, and then the remote image will be set once the request is finished.
 
 @param url The URL used for the image request.
 @param placeholderImage The image to be set initially, until the image request finishes. If `nil`, the image view will not change its image until the image request finishes.
 
 @discussion By default, URL requests have a cache policy of `NSURLCacheStorageAllowed` and a timeout interval of 30 seconds, and are set not handle cookies. To configure URL requests differently, use `setImageWithURLRequest:placeholderImage:success:failure:`
 */
- (void)setImageWithURL:(NSURL *)url
       placeholderImage:(UIImage *)placeholderImage;

/**
 Creates and enqueues an image request operation, which asynchronously downloads the image with the specified URL request object. Any previous image request for the receiver will be cancelled. If the image is cached locally, the image is set immediately, otherwise the specified placeholder image will be set immediately, and then the remote image will be set once the request is finished.
 
 @param urlRequest The URL request used for the image request.
 @param placeholderImage The image to be set initially, until the image request finishes. If `nil`, the image view will not change its image until the image request finishes.
 @param success A block to be executed when the image request operation finishes successfully, with a status code in the 2xx range, and with an acceptable content type (e.g. `image/png`). This block has no return value and takes three arguments: the request sent from the client, the response received from the server, and the image created from the response data of request. If the image was returned from cache, the request and response parameters will be `nil`.
 @param failure A block object to be executed when the image request operation finishes unsuccessfully, or that finishes successfully. This block has no return value and takes three arguments: the request sent from the client, the response received from the server, and the error object describing the network or parsing error that occurred.
 
 @discussion If a success block is specified, it is the responsibility of the block to set the image of the image view before returning. If no success block is specified, the default behavior of setting the image with `self.image = image` is executed.
 */
- (void)setImageWithURLRequest:(NSURLRequest *)urlRequest
              placeholderImage:(UIImage *)placeholderImage
                       success:(void (^)(NSURLRequest *request, NSHTTPURLResponse *response, UIImage *image))success
                       failure:(void (^)(NSURLRequest *request, NSHTTPURLResponse *response, NSError *error))failure;

/**
 Cancels any executing image request operation for the receiver, if one exists.
 */
- (void)cancelImageRequestOperation;

@end

#endif

