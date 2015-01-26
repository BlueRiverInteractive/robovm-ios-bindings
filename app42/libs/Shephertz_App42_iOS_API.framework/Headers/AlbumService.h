//
//  AlbumService.h
//  App42_iOS_SERVICE_APIs
//
//  Created by shephertz technologies on 13/02/12.
//  Copyright (c) 2012 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "App42Service.h"

@class Album;
@class App42Response;

/**
 * Create Photo Gallery on the cloud. This service allows to manage i.e. create,
 * retrieve and remove albums on the cloud. Its useful for Mobile/Device App and
 * Web App developer who want Photo Gallery functionality. It gives them a
 * complete Photo Gallery out of the box and reduces the footprint on the
 * device. Developers can focus on how the Photo Gallery will be rendered and
 * this Cloud API will manage the Gallery on the cloud thereby reducing
 * development time.
 *
 * @see Album
 * @see Photo
 */
@interface AlbumService : App42Service
{
    
}

-(id)init __attribute__((unavailable));
-(id)initWithAPIKey:(NSString *)apiKey  secretKey:(NSString *)secretKey;

/**
 * Creates Album on the cloud
 *
 * @param userName
 *            - The user to which the album belongs
 * @param albumName
 *            - Name of the album to be created on the cloud
 * @param albumDescription
 *            - Description of the album to be created
 *
 * @return Album object containing the album which has been created
 *
 */
-(void)createAlbum:(NSString*)userName albumName:(NSString*)albumName albumDescription:(NSString*)albumDescription completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Fetches the count of all the Albums based on the userName
 *
 * @param userName
 *            - The user for which the count of albums have to be fetched
 *
 * @return App42Response object containing the count of all the albums for
 *         the given userName
 *
 */
-(void)getAlbumsCount:(NSString*)userName completionBlock:(App42ResponseBlock)completionBlock;

/**
 * Fetches all the Albums based on the userName
 *
 * @param userName
 *            - The user for which the albums have to be fetched
 *
 * @return List of Album object containing all the album for the given
 *         userName
 *
 */
-(void)getAlbums:(NSString*)userName completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Fetches all the Albums based on the userName by Paging.
 *
 * @param userName
 *            - The user for which the albums have to be fetched
 * @param max
 *            - Maximum number of records to be fetched
 * @param offset
 *            - From where the records are to be fetched
 *
 * @return List of Album object containing all the album for the given
 *         userName
 *
 */
-(void)getAlbums:(NSString*)userName max:(int)max offset:(int)offset completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Fetch all Albums based on userName and albumName
 *
 * @param userName
 *            - The user for which the album has to be fetched
 * @param albumName
 *            - Name of the album that has to be fetched
 *
 * @return Album object containing album information for the given userName
 *         and albumName
 *
 */
-(void)getAlbumByName:(NSString*)userName albumName:(NSString*)albumName completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Removes a particular album based on the userName and albumName. Note: All
 * photos added to this Album will also be removed
 *
 * @param userName
 *            - The user for which the album has to be removed
 * @param albumName
 *            - Name of the album that has to be removed
 *
 * @return App42Response if removed successfully
 *
 */
-(void)removeAlbum:(NSString*)userName albumName:(NSString*)albumName completionBlock:(App42ResponseBlock)completionBlock;

@end
