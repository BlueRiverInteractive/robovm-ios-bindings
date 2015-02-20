//
//  ImageProcessorService.h
//  PAE_iOS_SDK
//
//  Created by Shephertz Technology on 13/04/12.
//  Copyright (c) 2012 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "Image.h"
#import "App42Service.h"
/**
 * The ImageProcessor service is a Image utility service on the Cloud.
 * Developers can upload files on the cloud and perform various Image
 * Manipulation operations on the Uploaded Images e.g. resize, scale, thumbnail,
 * crop etc. It is especially useful for Mobile Apps when they dont want to
 * store Images locally and dont want to perform processor intensive operations.
 * It is also useful for web applications who want to perform complex Image
 * Operations
 *
 * @see Image
 */
@interface ImageProcessorService : App42Service
{
    
}

-(id)init __attribute__((unavailable));
-(id)initWithAPIKey:(NSString *)apiKey  secretKey:(NSString *)secretKey;
/**
 * Resize image. Returns the original image url and converted image url.
 * Images are stored on the cloud and can be accessed through the urls
 * Resizing is done based on the width and height provided
 *
 * @param name
 *            - Name of the image to resize
 * @param imagePath
 *            - Path of the local file to resize
 * @param width
 *            - Width of the image to resize
 * @param height
 *            - Height of the image to resize
 *
 * @returns Image object containing urls for the original and converted
 *          images
 *
 *
 */
-(void)resize:(NSString *)name imagePath:(NSString*)imagePath width:(int)width height:(int)height completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Creates a thumbnail of the image. There is a difference between thumbnail
 * and resize The thumbnail operation is optimized for speed, it removes
 * information of the image which is not necessary for a thumbnail e.g
 * header information. Returns the original image url and converted image
 * url. Images are stored on the cloud and can be accessed through the urls
 * Resizing is done based on the width and height provided
 *
 * @param name
 *            - Name of the image file for which thumbnail has to be created
 * @param imagePath
 *            - Path of the local file whose thumbnail has to be created
 * @param width
 *            - Width of the image for thumbnail
 * @param height
 *            - Height of the image for thumbnail
 *
 * @returns Image object containing urls for the original and converted
 *          images
 *
 */
-(void)thumbnail:(NSString *)name imagePath:(NSString*)imagePath width:(int)width height:(int)height completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Scales the image based on width and height. Returns the original image
 * url and converted image url. Images are stored in the cloud and can be
 * accessed through the urls Resizing is done based on the width and height
 * provided.
 *
 * @param name
 *            - Name of the image to scale
 * @param imagePath
 *            - Path of the local file to scale
 * @param width
 *            - Width of the image to scale
 * @param height
 *            - Height of the image to scale
 *
 * @returns Image object containing urls for the original and converted
 *          images
 *
 */
-(void)scale:(NSString *)name imagePath:(NSString*)imagePath width:(int)width height:(int)height completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Crops image based on width, height and x, y coordinates. Returns the
 * original image url and converted image url. Images are stored in the
 * cloud and can be accessed through the urls Resizing is done based on the
 * width and height provided.
 *
 * @param name
 *            - Name of the image to crop
 * @param imagePath
 *            - Path of the local file to crop
 * @param width
 *            - Width of the image to crop
 * @param height
 *            - Height of the image to crop
 * @param x
 *            - Coordinate X
 * @param y
 *            - Coordinate Y
 *
 * @returns Image object containing urls for the original and converted
 *          images
 *
 */
-(void)crop:(NSString *)name imagePath:(NSString*)imagePath width:(int)width height:(int)height x:(int)x y:(int)y completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Resize image by Percentage. Returns the original image url and converted
 * image url. Images are stored in the cloud and can be accessed through the
 * urls Resizing is done based on the width and height provided
 *
 * @param name
 *            - Name of the image to resize
 * @param imagePath
 *            - Path of the local file to resize
 * @param percentage
 *            - Percentage to which image has to be resized
 *
 * @returns Image object containing urls for the original and converted
 *          images
 *
 */
-(void)resizeByPercentage:(NSString *)name imagePath:(NSString*)imagePath percentage:(double)percentage completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Creates a thumbnail of the image by Percentage. There is a difference
 * between thumbnail and resize The thumbnail operation is optimized for
 * speed removes information of the image which is not necessary for a
 * thumbnail to reduce size e.g hearder information. Returns the original
 * image url and converted image url. Images are stored in the cloud and can
 * be accessed through the urls Resizing is done based on the width and
 * height provided
 *
 * @param name
 *            - Name of the image file for which thumbnail has to be created
 * @param imagePath
 *            - Path of the local file whose thumbnail has to be created
 * @param percentage
 *            - Percentage for thumbnail
 *
 * @returns Image object containing urls for the original and converted
 *          images
 *
 */
-(void)thumbnailByPercentage:(NSString *)name imagePath:(NSString*)imagePath percentage:(double)percentage completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Scales the image by Percentage. Returns the original image url and
 * converted image url. Images are stored in the cloud and can be accessed
 * through the urls Resizing is done based on the width and height provided
 *
 * @param name
 *            - Name of the image file to scale
 * @param imagePath
 *            - Path of the local file to scale
 * @param percentage
 *            - Percentage to which image has to be scaled
 *
 * @returns Image object containing urls for the original and converted
 *          images
 *
 */
-(void)scaleByPercentage:(NSString *)name imagePath:(NSString*)imagePath percentage:(double)percentage completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Resize image via Stream. Returns the original image url and converted image url.
 * Images are stored on the cloud and can be accessed through the urls
 * Resizing is done based on the width and height provided
 *
 * @param name
 *            - Name of the image to resize
 * @param inputStream
 *            - InputStream of the local file to resize
 * @param width
 *            - Width of the image to resize
 * @param height
 *            - Height of the image to resize
 *
 * @returns Image object containing urls for the original and converted
 *          images
 *
 */
-(void)resize:(NSString *)name imageData:(NSData*)imageData width:(int)width height:(int)height completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Creates a thumbnail of the image via Stream. There is a difference between thumbnail
 * and resize The thumbnail operation is optimized for speed, it removes
 * information of the image which is not necessary for a thumbnail e.g
 * hearder information. Returns the original image url and converted image
 * url. Images are stored on the cloud and can be accessed through the urls
 * Resizing is done based on the width and height provided
 *
 * @param name
 *            - Name of the image file for which thumbnail has to be created
 * @param inputStream
 *            - InputStream of the local file whose thumbnail has to be
 *            created
 * @param width
 *            - Width of the image for thumbnail
 * @param height
 *            - Height of the image for thumbnail
 *
 * @returns Image object containing urls for the original and converted
 *          images
 *
 */
-(void)thumbnail:(NSString *)name imageData:(NSData*)imageData width:(int)width height:(int)height completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Scales the image based on width and height via Stream. Returns the original image
 * url and converted image url. Images are stored in the cloud and can be
 * accessed through the urls Resizing is done based on the width and height
 * provided
 *
 * @param name
 *            - Name of the image to scale
 * @param inputStream
 *            - InputStream of the local file to scale
 * @param width
 *            - Width of the image to scale
 * @param height
 *            - Height of the image to scale
 *
 * @returns Image object containing urls for the original and converted
 *          images
 *
 */
-(void)scale:(NSString *)name imageData:(NSData*)imageData width:(int)width height:(int)height completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Crops image based on width, height and x, y coordinates via Stream. Returns the
 * original image url and converted image url. Images are stored in the
 * cloud and can be accessed through the urls Resizing is done based on the
 * width and height provided
 *
 * @param name
 *            - Name of the image to crop
 * @param inputStream
 *            - InputStream of the local file to crop
 * @param width
 *            - Width of the image to crop
 * @param height
 *            - Height of the image to crop
 * @param x
 *            - Coordinate X
 * @param y
 *            - Coordinate Y
 *
 * @returns Image object containing urls for the original and converted
 *          images
 *
 */
-(void)crop:(NSString *)name imageData:(NSData*)imageData width:(int)width height:(int)height x:(int)x y:(int)y completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Resize image by Percentage via Stream. Returns the original image url and converted
 * image url. Images are stored in the cloud and can be accessed through the
 * urls Resizing is done based on the width and height provided
 *
 * @param name
 *            - Name of the image to resize
 * @param inputStream
 *            - InputStream of the local file to resize
 * @param percentage
 *            - Percentage to which image has to be resized
 *
 * @returns Image object containing urls for the original and converted
 *          images
 *
 */
-(void)resizeByPercentage:(NSString *)name imageData:(NSData*)imageData percentage:(double)percentage completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Creates a thumbnail of the image by Percentage via Stream. There is a difference
 * between thumbnail and resize The thumbnail operation is optimized for
 * speed removes information of the image which is not necessary for a
 * thumbnail to reduce size e.g hearder information. Returns the original
 * image url and converted image url. Images are stored in the cloud and can
 * be accessed through the urls Resizing is done based on the width and
 * height provided
 *
 * @param name
 *            - Name of the image file for which thumbnail has to be created
 * @param inputStream
 *            - InputStream of the local file whose thumbnail has to be
 *            created
 * @param percentage
 *            - Percentage for thumbnail
 *
 * @returns Image object containing urls for the original and converted
 *          images
 *
 */
-(void)thumbnailByPercentage:(NSString *)name imageData:(NSData*)imageData percentage:(double)percentage completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Scales the image by Percentage via Stream. Returns the original image url and
 * converted image url. Images are stored in the cloud and can be accessed
 * through the urls Resizing is done based on the width and height provided
 *
 * @param name
 *            - Name of the image file to scale
 * @param inputStream
 *            - InputStream of the local file to scale
 * @param percentage
 *            - Percentage to which image has to be scaled
 *
 * @returns Image object containing urls for the original and converted
 *          images
 *
 */
-(void)scaleByPercentage:(NSString *)name imageData:(NSData*)imageData percentage:(double)percentage completionBlock:(App42ResponseBlock)completionBlock;

@end

