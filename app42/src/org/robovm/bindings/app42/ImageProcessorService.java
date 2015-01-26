package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSData;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class ImageProcessorService extends App42Service
{
	public ImageProcessorService(String apiKey, String secretKey) {
		super((SkipInit) null);
	    initObject(init(apiKey, secretKey));
	}
	
	@Method(selector = "initWithAPIKey:secretKey:")
	private native @Pointer long init(String apiKey, String secretKey);

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
	@Method(selector = "resize:imagePath:width:height:completionBlock:")
	public native void resize(String name, String imagePath, int width, int height, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "thumbnail:imagePath:width:height:completionBlock:")
	public native void thumbnail(String name, String imagePath, int width, int height, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "scale:imagePath:width:height:completionBlock:")
	public native void scale(String name, String imagePath, int width, int height, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "crop:imagePath:width:height:x:ycompletionBlock:")
	public native void crop(String name, String imagePath, int width, int height, int x, int y, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "resizeByPercentage:imagePath:percentage:completionBlock:")
	public native void resizeByPercentage(String name, String imagePath, double percentage, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "thumbnailByPercentage:imagePath:percentage:completionBlock:")
	public native void thumbnailByPercentage(String name, String imagePath, double percentage, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "scaleByPercentage:imagePath:percentage:completionBlock:")
	public native void scaleByPercentage(String name, String imagePath, double percentage, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "resize:imageData:width:height:completionBlock:")
	public native void resize(String name, NSData imageData, int width, int height, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "thumbnail:imageData:width:height:completionBlock:")
	public native void thumbnail(String name, NSData imageData, int width, int height, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "scale:imageData:width:height:completionBlock:")
	public native void scale(String name, NSData imageData, int width, int height, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "crop:imageData:width:height:x:y:completionBlock:")
	public native void crop(String name, NSData imageData, int width, int height, int x, int y, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "resizeByPercentage:imageData:percentage:completionBlock:")
	public native void resizeByPercentage(String name, NSData imageData, double percentage, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "thumbnailByPercentage:imageData:percentage:completionBlock:")
	public native void thumbnailByPercentage(String name, NSData imageData, double percentage, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "scaleByPercentage:imageData:percentage:completionBlock:")
	public native void scaleByPercentage(String name, NSData imageData, double percentage, @Block App42ResponseBlock completionBlock);
}
