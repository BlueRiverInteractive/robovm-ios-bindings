package org.robovm.bindings.app42;

import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class CatalogueService extends App42Service 
{
	public CatalogueService(String apiKey, String secretKey) {
		super((SkipInit) null);
	    initObject(init(apiKey, secretKey));
	}
	
	@Method(selector = "initWithAPIKey:secretKey:")
	private native @Pointer long init(String apiKey, String secretKey);
	
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
	@Method(selector = "createCatalogue:catalogueDescription:completionBlock:")
	public native void createCatalogue(String catalogueName, String catalogueDescription, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "createCategory:categoryName:categoryDescription:completionBlock:")
	public native void createCategory(String catalogueName, String categoryName, String categoryDescription, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "addItem:categoryName:itemData:completionBlock:")
	public native void addItem(String catalogueName, String categoryName, ItemData itemData, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Fetches all items for a Catalogue
	 *
	 * @param catalogueName
	 *            - Name of the Catalogue from which item has to be fetched
	 *
	 * @returns Catalogue object containing all Items
	 *
	 */
	@Method(selector = "getItems:completionBlock:")
	public native void getItems(String catalogueName, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "getItemsByCategory:categoryName:completionBlock:")
	public native void getItemsByCategory(String catalogueName, String categoryName, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "getItemsCountByCategory:categoryName:completionBlock:")
	public native void getItemsCountByCategory(String catalogueName, String categoryName, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "getItemsByCategory:categoryName:max:offset:completionBlock:")
	public native void getItemsByCategory(String catalogueName, String categoryName, int max, int offset, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "getItemById:categoryName:itemId:completionBlock:")
	public native void getItemById(String catalogueName, String categoryName, String itemId, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Removes all the Items of the given Catalogue.
	 *
	 * @param catalogueName
	 *            - Name of the Catalogue from which item has to be removed
	 *
	 * @returns App42Response object containing all removed items
	 *
	 */
	@Method(selector = "removeAllItems:completionBlock:")
	public native void removeAllItems(String catalogueName, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "removeItemsByCategory:categoryName:completionBlock:")
	public native void removeItemsByCategory(String catalogueName, String categoryName, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "removeItemById:categoryName:itemId:completionBlock:")
	public native void removeItemById(String catalogueName, String categoryName, String itemId, @Block App42ResponseBlock completionBlock);
}
