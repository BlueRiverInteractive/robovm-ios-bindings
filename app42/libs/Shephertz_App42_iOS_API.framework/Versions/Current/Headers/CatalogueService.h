//
//  CatalogueService.h
//  PAE_iOS_SDK
//
//  Created by Shephertz Technology on 13/04/12.
//  Copyright (c) 2012 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "ItemData.h"
#import "App42Service.h"
/**
 * This Service provides a complete cloud based catalogue management. An app can
 * keep all its items based on category on the Cloud. This service provides
 * several utility methods to manage catalogue on the cloud. One can add items
 * with its related information in a particular category. And there can be
 * several categories in a catalogue. The App developer can create several
 * catalogues if needed.
 *
 * The Cart service can be used along with Catalogue service to create an end to
 * end Shopping feature for a Mobile and Web App
 *
 * @see Cart, ItemData
 *
 */
@interface CatalogueService : App42Service
{
    
}

-(id)init __attribute__((unavailable));
-(id)initWithAPIKey:(NSString *)apiKey  secretKey:(NSString *)secretKey;

/**
 * Creates a Catalogue for a particular App. Categories can be added to the
 * Catalogue
 *
 * @param catalogueName
 *            - Name of the Catalogue to be created
 * @param catalogueDescription
 *            - Description of the catalogue to be created
 *
 * @returns Catalogue object
 *
 */
-(void)createCatalogue:(NSString*)catalogueName catalogueDescription:(NSString*)catalogueDescription completionBlock:(App42ResponseBlock)completionBlock;;
/**
 * Creates a Category for a particular Catalogue e.g. Books, Music etc.
 *
 * @param catalogueName
 *            - Name of the Catalogue for which Category has to be created
 * @param categoryName
 *            - Name of the Category that has to be created
 * @param categoryDescription
 *            - Description of the category to be created
 *
 * @returns Catalogue object containing created category information
 *
 */
-(void)createCategory:(NSString*)catalogueName categoryName:(NSString*)categoryName categoryDescription:(NSString*)categoryDescription completionBlock:(App42ResponseBlock)completionBlock;;
/**
 * Creates a Item in a Category for a particular Catelogue
 *
 * @param catalogueName
 *            - Name of the Catalogue to which item has to be added
 * @param categoryName
 *            - Name of the Category to which item has to be added
 * @param itemData
 *            - Item Information that has to be added
 *
 * @returns Catalogue object containing added item.
 *
 * @see ItemData
 */
-(void)addItem:(NSString*)catalogueName categoryName:(NSString*)categoryName itemData:(ItemData*)itemData completionBlock:(App42ResponseBlock)completionBlock;;
/**
 * Fetches all items for a Catalogue
 *
 * @param catalogueName
 *            - Name of the Catalogue from which item has to be fetched
 *
 * @returns Catalogue object containing all Items
 *
 */
-(void)getItems:(NSString*)catalogueName completionBlock:(App42ResponseBlock)completionBlock;;
/**
 * Fetches all items for a Catalogue and Category
 *
 * @param catalogueName
 *            - Name of the Catalogue from which item has to be fetched
 * @param categoryName
 *            - Name of the Category from which item has to be fetched
 *
 * @returns Catalogue object
 *
 */
-(void)getItemsByCategory:(NSString*)catalogueName categoryName:(NSString*)categoryName completionBlock:(App42ResponseBlock)completionBlock;;
/**
 * Fetches count of all items for a Catalogue and Category
 *
 * @param catalogueName
 *            - Name of the Catalogue from which count of item has to be
 *            fetched
 * @param categoryName
 *            - Name of the Category from which count of item has to be
 *            fetched
 *
 * @returns App42Response object
 *
 */
-(void)getItemsCountByCategory:(NSString*)catalogueName categoryName:(NSString*)categoryName completionBlock:(App42ResponseBlock)completionBlock;;
/**
 * Fetches all items for a Catalogue and Category by paging.
 *
 * @param catalogueName
 *            - Name of the Catalogue from which item has to be fetched
 * @param categoryName
 *            - Name of the Category from which item has to be fetched
 * @param max
 *            - Maximum number of records to be fetched
 * @param offset
 *            - From where the records are to be fetched
 *
 * @returns Catalogue object
 *
 */
-(void)getItemsByCategory:(NSString*)catalogueName categoryName:(NSString*)categoryName max:(int)max offset:(int)offset completionBlock:(App42ResponseBlock)completionBlock;;

/**
 * Fetches Item by id for a Catalogue and Category
 *
 * @param catalogueName
 *            - Name of the Catalogue from which item has to be fetched
 * @param categoryName
 *            - Name of the Category from which item has to be fetched
 * @param itemId
 *            - Item id for which information has to be fetched.
 *
 * @returns Catalogue object
 *
 */
-(void)getItemById:(NSString*)catalogueName categoryName:(NSString*)categoryName itemId:(NSString*)itemId completionBlock:(App42ResponseBlock)completionBlock;;

/**
 * Removes all the Items of the given Catalogue.
 *
 * @param catalogueName
 *            - Name of the Catalogue from which item has to be removed
 *
 * @returns App42Response object containing all removed items
 *
 */
-(void)removeAllItems:(NSString*)catalogueName completionBlock:(App42ResponseBlock)completionBlock;;
/**
 * Removes all the Items from a given Catalogue and Category
 *
 * @param catalogueName
 *            - Name of the Catalogue from which item has to be removed
 * @param categoryName
 *            - Name of the Category from which item has to be removed
 *            returns App42Response object containing removed items
 *
 * @returns App42Response object containing removed items by category
 *
 */
-(void)removeItemsByCategory:(NSString*)catalogueName categoryName:(NSString*)categoryName completionBlock:(App42ResponseBlock)completionBlock;;
/**
 * Removes the Item for the given Id
 *
 * @param catalogueName
 *            - Name of the Catalogue from which item has to be removed
 * @param categoryName
 *            - Name of the Category from which item has to be removed
 * @param itemId
 *            - Item id which has to be removed returns App42Response object
 *            containing removed items
 *
 * @returns App42Response object containing removed items by ID
 *
 */
-(void)removeItemById:(NSString*)catalogueName categoryName:(NSString*)categoryName itemId:(NSString*)itemId completionBlock:(App42ResponseBlock)completionBlock;;


@end
