package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSMutableDictionary;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class StorageService extends App42Service
{
	public StorageService(String apiKey, String secretKey) {
		super((SkipInit) null);
	    initObject(init(apiKey, secretKey));
	}
	
	@Method(selector = "initWithAPIKey:secretKey:")
	private native @Pointer long init(String apiKey, String secretKey);
	
	/**
	 * Save the JSON String in given database name and collection name.
	 *
	 * @param dbName
	 *            - Unique handler for storage name
	 * @param collectionName
	 *            - Name of collection under which JSON doc has to be saved
	 * @param json
	 *            - Target JSON document to be saved
	 *
	 * @return Storage object
	 *
	 *
	 */
	@Method(selector = "insertJSONDocument:collectionName:json:completionBlock:")
	public native void insertJSONDocument(String dbName, String collectionName, String json, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Save the data supplied as Dictionary in the given database name and collection name.
	 *
	 * @param dbName
	 *            - Unique handler for storage name
	 * @param collectionName
	 *            - Name of collection under which JSON doc has to be saved
	 * @param dataDict
	 *            - Target data as Dictionary to be saved
	 *
	 * @return Storage object
	 *
	 *
	 */
	@Method(selector = "insertJSONDocument:collectionName:dataDict:completionBlock:")
	public native void insertJSONDocument(String dbName, String collectionName, NSDictionary<?, ?> dataDict, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Save the data supplied as JSON String with an attachment file in the given database name and collection name.
	 *
	 * @param dbName
	 *            - Unique handler for storage name
	 * @param collectionName
	 *            - Name of collection under which JSON doc has to be saved
	 * @param json
	 *            - Target JSON document to be saved
	 *
	 * @return Storage object
	 *
	 *
	 */
	@Method(selector = "insertJSONDocument:collectionName:json:attachment:completionBlock:")
	public native void insertJSONDocument(String dbName, String collectionName, String json, App42File file, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Save the data supplied as Dictionary with an attachment file in the given database name and collection name.
	 *
	 * @param dbName
	 *            - Unique handler for storage name
	 * @param collectionName
	 *            - Name of collection under which JSON doc has to be saved
	 * @param json
	 *            - Target JSON document to be saved
	 *
	 * @return Storage object
	 *
	 */
	@Method(selector = "insertJSONDocument:collectionName:dataDict:attachment:completionBlock:")
	public native void insertJSONDocument(String dbName, String collectionName, NSDictionary<?, ?> dataDict, App42File file, @Block App42ResponseBlock completionBlock);
		
	/**
	 * Find all documents stored in given database and collection.
	 *
	 * @param dbName
	 *            - Unique handler for storage name
	 * @param collectionName
	 *            - Name of collection under which JSON doc needs to be searched
	 *
	 * @return Storage object
	 *
	 */
	@Method(selector = "findAllDocuments:collectionName:completionBlock:")
	public native void findAllDocuments(String dbName, String collectionName, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Gets the count of all documents stored in given database and collection.
	 *
	 * @param dbName
	 *            - Unique handler for storage name
	 * @param collectionName
	 *            - Name of collection under which JSON doc needs to be searched
	 *
	 * @return App42Response object
	 *
	 *
	 */
	@Method(selector = "findAllDocumentsCount:collectionName:completionBlock:")
	public native void findAllDocumentsCount(String dbName, String collectionName, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Find all documents stored in given database and collection.
	 *
	 * @param dbName
	 *            - Unique handler for storage name
	 * @param collectionName
	 *            - Name of collection under which JSON doc needs to be searched
	 * @param max
	 *            - Maximum number of records to be fetched
	 * @param offset
	 *            - From where the records are to be fetched
	 *
	 * @return Storage object
	 *
	 *
	 */
	@Method(selector = "findAllDocuments:collectionName:max:offset:completionBlock:")
	public native void findAllDocuments(String dbName, String collectionName, int max, int offset, @Block App42ResponseBlock completionBlock);

	/**
	 * Find all collections stored in given database.
	 *
	 * @param dbName
	 *            - Unique handler for storage name
	 *
	 * @return Storage object
	 *
	 * @throws App42Exception
	 *
	 */
	@Method(selector = "findAllCollections:completionBlock:")
	public native void findAllCollections(String dbName, @Block App42ResponseBlock completionBlock);

	/**
	 * Find target document by given unique object id.
	 *
	 * @param dbName
	 *            - Unique handler for storage name
	 * @param collectionName
	 *            - Name of collection under which JSON doc needs to be searched
	 * @param docId
	 *            - Unique Object Id handler
	 *
	 * @return Storage object
	 *
	 *
	 */
	@Method(selector = "findDocumentById:collectionName:docId:completionBlock:")
	public native void findDocumentById(String dbName, String collectionName, String docId, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Find target document using key value search parameter. This key value
	 * pair will be searched in the JSON doc stored on the cloud and matching
	 * Doc will be returned as a result of this method.
	 *
	 * @param dbName
	 *            - Unique handler for storage name
	 * @param collectionName
	 *            - Name of collection under which JSON doc needs to be searched
	 * @param key
	 *            - Key to be searched for target JSON doc
	 * @param value
	 *            - Value to be searched for target JSON doc
	 *
	 * @return Storage object
	 *
	 *
	 */
	@Method(selector = "findDocumentByKeyValue:collectionName:key:value:completionBlock:")
	public native void findDocumentByKeyValue(String dbName, String collectionName, String key, String value, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Update target document using key value search parameter. This key value
	 * pair will be searched in the JSON doc stored in the cloud and matching
	 * Doc will be updated with new value passed.
	 *
	 * @param dbName
	 *            - Unique handler for storage name
	 * @param collectionName
	 *            - Name of collection under which JSON doc needs to be searched
	 * @param key
	 *            - Key to be searched for target JSON doc
	 * @param value
	 *            - Value to be searched for target JSON doc
	 * @param newJsonDoc
	 *            - New Json document to be added
	 *
	 * @return Storage object
	 *
	 *
	 */
	@Method(selector = "updateDocumentByKeyValue:collectionName:key:value:newJsonDoc:completionBlock:")
	public native void updateDocumentByKeyValue(String dbName, String collectionName, String key, String value, String newJsonDoc, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Update target document using key value search parameter. This key value
	 * pair will be searched in the JSON doc stored in the cloud and matching
	 * Doc will be updated with new JsonObject value.
	 *
	 * @param dbName
	 *            - Unique handler for storage name
	 * @param collectionName
	 *            - Name of collection under which JSON doc needs to be searched
	 * @param key
	 *            - Key to be searched for target JSON doc
	 * @param value
	 *            - Value to be searched for target JSON doc
	 * @param newDataDict
	 *            - New newDataDict to be added
	 *
	 * @return Storage object
	 * @throws App42Exception
	 */
	@Method(selector = "updateDocumentByKeyValue:collectionName:key:value:newDataDict:completionBlock:")
	public native void updateDocumentByKeyValue(String dbName, String collectionName, String key, String value, NSDictionary<?, ?> newDataDict, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Update target document using the document id.
	 *
	 * @param dbName
	 *            - Unique handler for storage name
	 * @param collectionName
	 *            - Name of collection under which JSON doc needs to be searched
	 * @param docId
	 *            - Id of the document to be searched for target JSON doc
	 * @param newJsonDoc
	 *            - New Json document to be added
	 *
	 * @return Storage object
	 *
	 *
	 */
	@Method(selector = "updateDocumentByDocId:collectionName:key:value:newDataDict:completionBlock:")
	public native void updateDocumentByDocId(String dbName, String collectionName, String docId, String newJsonDoc, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Update target document with NSDictionary doc using the document id.
	 *
	 * @param dbName
	 *            - Unique handler for storage name
	 * @param collectionName
	 *            - Name of collection under which JSON doc needs to be searched
	 * @param docId
	 *            - Id of the document to be searched for target JSON doc
	 * @param newDataDict
	 *            - New NSDictionary document to be added.
	 * @return Storage Object
	 * @throws App42Exception
	 */
	@Method(selector = "updateDocumentByDocId:collectionName:docId:newDataDict:completionBlock:")
	public native void updateDocumentByDocId(String dbName, String collectionName, String docId, NSDictionary<?, ?> newDataDict, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Delete target document using Object Id from given db and collection. The
	 * Object Id will be searched in the JSON doc stored on the cloud and
	 * matching Doc will be deleted.
	 *
	 * @param dbName
	 *            - Unique handler for storage name
	 * @param collectionName
	 *            - Name of collection under which JSON doc needs to be searched
	 * @param docId
	 *            - Unique Object Id handler
	 *
	 * @return App42Response object if deleted successfully
	 *
	 *
	 */
	@Method(selector = "deleteDocumentById:collectionName:docId:completionBlock:")
	public native void deleteDocumentById(String dbName, String collectionName, String docId, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Save the JSON document in given database name and collection name. It
	 * accepts the HashMap containing key-value and convert it into JSON.
	 * Converted JSON doc further saved on the cloud using given db name and
	 * collection name.
	 *
	 * @param dbName
	 *            - Unique handler for storage name
	 * @param collectionName
	 *            - Name of collection under which JSON doc has to be saved
	 * @param map
	 *            - HashMap containing key-value pairs
	 *
	 * @return Storage object
	 *
	 *
	 */
	@Method(selector = "insertJsonDocUsingMap:collectionName:map:completionBlock:")
	public native void insertJsonDocUsingMap(String dbName, String collectionName, NSMutableDictionary<?, ?> map, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Map reduce function to search the target document. Please see detail
	 * information on map-reduce http://en.wikipedia.org/wiki/MapReduce
	 *
	 * @param dbName
	 *            - Unique handler for storage name
	 * @param collectionName
	 *            - Name of collection under which JSON doc needs to be searched
	 * @param mapFunction
	 *            - Map function to be used to search the document
	 * @param reduceFunction
	 *            - Reduce function to be used to search the document
	 *
	 * @return Returns the target JSON document.
	 *
	 */
	@Method(selector = "mapReduce:collectionName:mapFunction:reduceFunction:completionBlock:")
	public native void mapReduce(String dbName, String collectionName, String mapFunction, String reduceFunction, @Block App42ResponseBlock completionBlock);

	/**
	 * Find target document using Custom Query.
	 *
	 * @param Query
	 *            - Query Object containing custom query for searching docs
	 * @param dbName
	 *            - Unique handler for storage name
	 * @param collectionName
	 *            - Name of collection under which JSON doc needs to be searched
	 * @return Storage object
	 *
	 * @throws App42Exception
	 *
	 */
	@Method(selector = "findDocumentsByQuery:dbName:collectionName:completionBlock:")
	public native void findDocumentsByQuery(Query query, String dbName, String collectionName, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Find target document using Custom Query with paging.
	 *
	 * @param dbName
	 *            - Unique handler for storage name
	 * @param collectionName
	 *            - Name of collection under which JSON doc needs to be searched
	 * @param Query
	 *            - Query Object containing custom query for searching docs
	 * @param max
	 *            - Maximum number of records to be fetched
	 * @param offset
	 *            - From where the records are to be fetched
	 *
	 * @return Storage object
	 *
	 * @throws App42Exception
	 *
	 */
	@Method(selector = "findDocumentsByQueryWithPaging:collectionName:query:max:offset:completionBlock:")
	public native void findDocumentsByQueryWithPaging(String dbName, String collectionName, Query query, int max, int offset, @Block App42ResponseBlock completionBlock);

	/**
	 * Find target document using Custom Query with paging and orderby.
	 *
	 * @param dbName
	 *            - Unique handler for storage name
	 * @param collectionName
	 *            - Name of collection under which JSON doc needs to be searched
	 * @param Query
	 *            - Query Object containing custom query for searching docs
	 * @param max
	 *            - max result parameter
	 * @param offset
	 *            - offset result parameter
	 * @param orderByKey
	 *            - Name of Key on which order by has to be applied
	 * @param type
	 *            - ASCENDING/DESCENDING mode
	 * @return
	 * @throws App42Exception
	 */
   	@Method(selector = "findDocsWithQueryPagingOrderBy:collectionName:query:max:offset:orderByKey:orderByType:completionBlock:")
	public native void findDocsWithQueryPagingOrderBy(String dbName, String collectionName, Query query, int max, int offset, String orderByKey, String orderType, @Block App42ResponseBlock completionBlock);
	                               
	@Method(selector = "grantAccessOnDoc:collectionName:docId:andAclList:completionBlock:")
	public native void grantAccessOnDoc(String dbName, String collectionName, String docId, NSArray<?> aclList, @Block App42ResponseBlock completionBlock);
	                 
  	@Method(selector = "revokeAccessOnDoc:collectionName:docId:andAclList:completionBlock:")
	public native void revokeAccessOnDoc(String dbName, String collectionName, String docId, NSArray<?> aclList, @Block App42ResponseBlock completionBlock);
	            
  	@Method(selector = "deleteAllDocuments:collectionName:completionBlock:")
	public native void deleteAllDocuments(String dbName, String collectionName, @Block App42ResponseBlock completionBlock);

  	@Method(selector = "findDocumentsByLocation:collectionName:geoQuery:completionBlock:")
	public native void findDocumentsByLocation(String dbName, String collectionName, GeoQuery geoQuery, @Block App42ResponseBlock completionBlock);
  	
	/**
	 * Delete target document using key and value from given db and collection.
	 * The key value will be searched in the JSON doc stored on the cloud and
	 * matching value will be deleted.
	 *
	 * @param dbName
	 *            - Unique handler for storage name
	 * @param collectionName
	 *            - Name of collection under which JSON doc needs to be searched
	 * @param key
	 *            - Unique key handler
	 * @param value
	 *            - Unique value handler
	 *
	 * @return App42Response object if deleted successfully
	 *
	 * @throws App42Exception
	 *
	 */
  	@Method(selector = "deleteDocumentsByKeyValue:collectionName:key:value:completionBlock:")
	public native void deleteDocumentsByKeyValue(String dbName, String collectionName, String key, String value, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Update target document using key value search parameter. This key value
	 * pair will be searched in the JSON doc stored in the cloud and matching
	 * Doc will be updated with new value passed. If match document is not found it will insert the json
	 * doc with that key value
	 *
	 * @param dbName
	 *            - Unique handler for storage name
	 * @param collectionName
	 *            - Name of collection under which JSON doc needs to be searched
	 * @param key
	 *            - Key to be searched for target JSON doc
	 * @param value
	 *            - Value to be searched for target JSON doc
	 * @param newJsonDoc
	 *            - New Json document to be added
	 *
	 * @return Storage object
	 *
	 * @throws App42Exception
	 *
	 */
  	@Method(selector = "saveOrUpdateDocumentByKeyValue:collectionName:key:value:newJsonDoc:completionBlock:")
	public native void saveOrUpdateDocumentByKeyValue(String dbName, String collectionName, String key, String value, String newJsonDoc, @Block App42ResponseBlock completionBlock);
	                                
	/**
	 * Update target document using key value search parameter. This key value
	 * pair will be searched in the JSON doc stored in the cloud and matching
	 * Doc will be updated with new value passed. If match document is not found it will insert the json
	 * doc with that key value
	 *
	 * @param dbName
	 *            - Unique handler for storage name
	 * @param collectionName
	 *            - Name of collection under which JSON doc needs to be searched
	 * @param key
	 *            - Key to be searched for target JSON doc
	 * @param value
	 *            - Value to be searched for target JSON doc
	 * @param dataDict
	 *            - New JsonObject document to be added
	 *
	 * @return Storage object
	 *
	 * @throws App42Exception
	 *
	 */
	@Method(selector = "saveOrUpdateDocumentByKeyValue:collectionName:key:value:dataDict:completionBlock:")
	public native void saveOrUpdateDocumentByKeyValue(String dbName, String collectionName, String key, String value, NSDictionary<?, ?> dataDict, @Block App42ResponseBlock completionBlock);
	                                  
	/**
	 * Add or Update keys of target document using doc id search parameter. This docId
	 * will be searched in the JSON doc stored in the cloud and matching
	 * Doc will be updated with new value passed. If matching key is not found it will insert a key
	 * in that doc with that key and value passed.
	 *
	 * @param dbName
	 *            - Unique handler for storage name
	 * @param collectionName
	 *            - Name of collection under which JSON doc needs to be searched
	 * @param docId
	 *            - DocId to be searched for target JSON doc
	 * @param dataDict
	 *            - New JsonObject document to be added
	 *
	 * @return Storage object
	 *
	 * @throws App42Exception
	 *
	 */     
   	@Method(selector = "addOrUpdateKeys:collectionName:docId:dataDict:completionBlock:")
	public native void addOrUpdateKeys(String dbName, String collectionName, String docId, NSDictionary<?, ?> dataDict, @Block App42ResponseBlock completionBlock);
	                   
	/**
	 *
	 * @param dbName
	 * @param collectionName
	 * @param docId
	 * @param file
	 * @return
	 * @throws App42Exception
	 */
   	@Method(selector = "addAttachmentToDocs:collectionName:docId:attachment:completionBlock:")
	public native void addAttachmentToDocs(String dbName, String collectionName, String docId, App42File file, @Block App42ResponseBlock completionBlock);
	
	/**
	 *
	 * @param dbName
	 * @param collectionName
	 * @param query
	 * @param newJsonDoc
	 * @return
	 * @throws App42Exception
	 */
   	@Method(selector = "updateDocumentByQuery:collectionName:query:newJsonDoc:completionBlock:")
	public native void updateDocumentByQuery(String dbName, String collectionName, Query query, String newJsonDoc, @Block App42ResponseBlock completionBlock);
	
	/**
	 *
	 * @param dbName
	 * @param collectionName
	 * @param query
	 * @param newDataDict
	 * @return
	 * @throws App42Exception
	 */
   	@Method(selector = "updateDocumentByQuery:collectionName:query:newDataDict:completionBlock:")
	public native void updateDocumentByQuery(String dbName, String collectionName, Query query, NSDictionary<?, ?> newDataDict, @Block App42ResponseBlock completionBlock);

   	@Method(selector = "findDocumentsByQueryCount:collectionName:query:completionBlock:")
	public native void findDocumentsByQueryCount(String dbName, String collectionName, Query query, @Block App42ResponseBlock completionBlock);
}
