package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSArray;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class GeoService extends App42Service
{
	public GeoService(String apiKey, String secretKey) {
		super((SkipInit) null);
	    initObject(init(apiKey, secretKey));
	}
	
	@Method(selector = "initWithAPIKey:secretKey:")
	private native @Pointer long init(String apiKey, String secretKey);
	
	/**
	 * Stores the geopints with unique handler on the cloud. Geo point data
	 * contains lat, long and marker of the point.
	 *
	 * @param geoStorageName
	 *            - Unique handler for storage name
	 * @param geoPointsList
	 *            - List of Geo Points to be saved
	 *
	 * @return Geo object containing List of Geo Points that have been saved
	 *
	 */
	@Method(selector = "createGeoPoints:geoPointsList:completionBlock:")
	public native void createGeoPoints(String geoStorageName, NSArray<?> geoPointsList, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Search the near by point in given range(In KM) from specified source
	 * point. Points to be searched should already be stored on cloud using
	 * unique storage name handler.
	 *
	 * @param storageName
	 *            - Unique handler for storage name
	 * @param lat
	 *            - Latitude of source point
	 * @param lng
	 *            - Longitude of source point
	 * @param distanceInKM
	 *            - Range in KM
	 *
	 * @return Geo object containing the target points in ascending order of
	 *         distance from source point.
	 *
	 *
	 */
	@Method(selector = "getNearByPointsByMaxDistance:latitude:longitude:distanceInKM:completionBlock:")
	public native void getNearByPointsByMaxDistance(String storageName, double lat, double lng, double distanceInKM, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Search the near by point from specified source point. Points to be
	 * searched should already be stored on cloud using unique storage name
	 * handler.
	 *
	 * @param storageName
	 *            - Unique handler for storage name
	 * @param lat
	 *            - Latitude of source point
	 * @param lng
	 *            - Longitude of source point
	 * @param resultLimit
	 *            - Maximum number of results to be retrieved
	 *
	 * @return Geo object containing the target points in ascending order of
	 *         distance from source point.
	 *
	 */
	@Method(selector = "getNearByPoint:latitude:longitude:resultLimit:completionBlock:")
	public native void getNearByPoint(String storageName, double lat, double lng, double resultLimit, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Search the near by point from specified source point with in specified
	 * radius. Points to be searched should already be stored on cloud using
	 * unique storage name handler.
	 *
	 * @param storageName
	 *            - Unique handler for storage name
	 * @param lat
	 *            - Lattitude of source point
	 * @param lng
	 *            - Longitude of source point
	 * @param radiusInKM
	 *            - Radius in KM
	 * @param resultLimit
	 *            - Maximum number of results to be retrieved
	 *
	 * @return Geo object containing the target points in ascending order of
	 *         distance from source point.
	 *
	 */
	@Method(selector = "getPointsWithInCircle:latitude:longitude:radiusInKM:resultLimit:completionBlock:")
	public native void getPointsWithInCircle(String storageName, double lat, double lng, double radiusInKM, double resultLimit, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Fetch the name of all storage stored on the cloud.
	 *
	 * @return Geo object containing List of all the storage created
	 *
	 */
	@Method(selector = "getAllStorage:")
	public native void getAllStorage(@Block App42ResponseBlock completionBlock);
	
	/**
	 * Fetch the name of storage page-wise stored on the cloud.
	 * @param max
	 *            - max result parameter
	 * @param offset
	 *            - offset result parameter
	 *
	 * @return Geo object containing List of all the storage created
	 *
	 */
	@Method(selector = "getAllStorageByPaging:offset:completionBlock:")
	public native void getAllStorageByPaging(int max, int offset, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Delete the specified Geo Storage from Cloud.
	 *
	 * @param storageName
	 *            - Unique handler for storage name
	 *
	 * @return App42Response object containing the name of the storage that has
	 *         been deleted.
	 *
	 */
	@Method(selector = "deleteStorage:completionBlock:")
	public native void deleteStorage(String storageName, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Get All Point from storage.
	 *
	 * @param storageName
	 *            - Unique handler for storage name
	 *
	 * @return Geo object containing all the stored Geo Points for the specified
	 *         storage
	 *
	 */
	@Method(selector = "getAllPoints:completionBlock:")
	public native void getAllPoints(String storageName, @Block App42ResponseBlock completionBlock);

	/**
	 * Get Points page-wise from storage.
	 *
	 * @param storageName
	 *            - Unique handler for storage name
	 * @param max
	 *            - max result parameter
	 * @param offset
	 *            - offset result parameter
	 *
	 * @return Geo object containing all the stored Geo Points for the specified
	 *         storage
	 *
	 */
	@Method(selector = "getAllPointsByPaging:max:offset:completionBlock:")
	public native void getAllPointsByPaging(String storageName, int max, int offset, @Block App42ResponseBlock completionBlock);

	/**
	 * Delete Geo points.
	 *
	 * @param geoPointsArray
	 *            - Array of geo points need to be deleted
	 * @param geoStorageName
	 *            - Unique handler for storage name
	 *
	 * @return App42Response object containing the name of the storage that has
	 *         been deleted.
	 *
	 */
	@Method(selector = "deleteGeoPoints:geoStorageName:completionBlock:")
	public native void deleteGeoPoints(NSArray<?> geoPointsArray, String geoStorageName, @Block App42ResponseBlock completionBlock);
}
