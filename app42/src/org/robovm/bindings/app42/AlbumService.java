package org.robovm.bindings.app42;

import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class AlbumService extends App42Service
{
	public AlbumService(String apiKey, String secretKey) {
		super((SkipInit) null);
	    initObject(init(apiKey, secretKey));
	}
	
	@Method(selector = "initWithAPIKey:secretKey:")
	private native @Pointer long init(String apiKey, String secretKey);
	
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
	@Method(selector = "createAlbum:albumName:albumDescription:completionBlock:")
	public native void createAlbum(String userName, String albumName, String albumDescription, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "getAlbumsCount:completionBlock:")
	public native void getAlbumsCount(String userName, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "getAlbums:completionBlock:")
	public native void getAlbums(String userName, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "getAlbums:max:offset:completionBlock:")
	public native void getAlbums(String userName, int max, int offset, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "getAlbumByName:albumName:completionBlock:")
	public native void getAlbums(String userName, String albumName, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "removeAlbum:albumName:completionBlock:")
	public native void removeAlbum(String userName, String albumName, @Block App42ResponseBlock completionBlock);
}
