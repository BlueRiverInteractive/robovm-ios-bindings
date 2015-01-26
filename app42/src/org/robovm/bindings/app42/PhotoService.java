package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSData;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class PhotoService extends App42Service
{
	public PhotoService(String apiKey, String secretKey) {
		super((SkipInit) null);
	    initObject(init(apiKey, secretKey));
	}
	
	@Method(selector = "initWithAPIKey:secretKey:")
	private native @Pointer long init(String apiKey, String secretKey);
	
	/**
	 * Adds Photo for a particular user and album. The Photo is uploaded on the
	 * cloud
	 *
	 * @param userName
	 *            - Name of the User whose photo has to be added
	 * @param albumName
	 *            - Name of the Album in which photo has to be added
	 * @param photoName
	 *            - Name of the Photo that has to be added
	 * @param photoDescription
	 *            - Description of the Photo that has to be added
	 * @param path
	 *            - Path from where Photo has to be picked for addition
	 *
	 * @return Album object containing the Photo which has been added
	 *
	 */
	@Method(selector = "addPhoto:albumName:photoName:photoDescription:path:completionBlock:")
	public native void addPhoto(String userName, String albumName, String photoName, String photoDescription, String path, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Adds Photo for a particular user and album via Stream. The Photo is
	 * uploaded on the cloud
	 *
	 * @param userName
	 *            - Name of the User whose photo has to be added
	 * @param albumName
	 *            - Name of the Album in which photo has to be added
	 * @param photoName
	 *            - Name of the Photo that has to be added
	 * @param photoDescription
	 *            - Description of the Photo that has to be added
	 * @param inputStream
	 *            - Input Stream for the Photo that has to be added
	 *
	 * @return Album object containing the Photo which has been added
	 *
	 */
	@Method(selector = "addPhoto:albumName:photoName:photoDescription:fileData:completionBlock:")
	public native void addPhoto(String userName, String albumName, String photoName, String photoDescription, NSData fileData, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Add tags to the Photos for the user in the album.
	 *
	 * @param userName
	 *            - Name of the User whose name has to be tagged to photo
	 * @param albumName
	 *            - Album name whose photo is to be tagged
	 * @param photoName
	 *            - Photo name to be tagged
	 * @param tagList
	 *            - List of tages in Photo
	 *
	 * @return Album object containing the Photo which has been added
	 *
	 **/
	@Method(selector = "addTagToPhoto:albumName:photoName:tagList:completionBlock:")
	public native void addTagToPhoto(String userName, String albumName, String photoName, NSArray<?> tagList, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Fetches all the Photos based on the userName
	 *
	 * @param userName
	 *            - Name of the User whose photos have to be fetched
	 *
	 * @return List of Album object containing all the Photos for the given
	 *         userName
	 *
	 */
	@Method(selector = "getPhotos:completionBlock:")
	public native void getPhotos(String userName, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Fetches all the Photos based on the userName and tag
	 *
	 * @param userName
	 *            - Name of the User whose photos have to be fetched
	 * @param tag
	 *            - tag on which basis photos have to be fetched
	 *
	 * @return List of Album object containing all the Photos for the given
	 *         userName
	 *
	 */
	@Method(selector = "getTaggedPhotos:tag:completionBlock:")
	public native void getTaggedPhotos(String userName, String tag, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Fetches the count of all Photos based on the userName and album name
	 *
	 * @param userName
	 *            - Name of the User whose count of photos have to be fetched
	 * @param albumName
	 *            - Name of the Album from which count of photos have to be
	 *            fetched
	 *
	 * @return App42Response object containing the count of all the Photos for
	 *         the given userName and albumName
	 *
	 */
	@Method(selector = "getPhotosCountByAlbumName:albumName:completionBlock:")
	public native void getPhotosCountByAlbumName(String userName, String albumName, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Fetches all Photos based on the userName and albumName
	 *
	 * @param userName
	 *            - Name of the User whose photos have to be fetched
	 * @param albumName
	 *            - Name of the Album from which photos have to be fetched
	 *
	 * @return Album object containing all the Photos for the given userName and
	 *         albumName
	 *
	 */
	@Method(selector = "getPhotosByAlbumName:albumName:completionBlock:")
	public native void getPhotosByAlbumName(String userName, String albumName, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Fetches all Photos based on the userName and album name by paging.
	 *
	 * @param userName
	 *            - Name of the User whose photos have to be fetched
	 * @param albumName
	 *            - Name of the Album from which photos have to be fetched
	 * @param max
	 *            - Maximum number of records to be fetched
	 * @param offset
	 *            - From where the records are to be fetched
	 *
	 * @return Album object containing all the Photos for the given userName and
	 *         albumName
	 *
	 */
	@Method(selector = "getPhotosByAlbumName:offset:userName:albumName:completionBlock:")
	public native void getPhotosByAlbumName(int max, int offset, String userName, String albumName, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Fetches the particular photo based on the userName, album name and photo
	 * name
	 *
	 * @param userName
	 *            - Name of the User whose photo has to be fetched
	 * @param albumName
	 *            - Name of the Album from which photo has to be fetched
	 * @param photoName
	 *            - Name of the Photo that has to be fetched
	 *
	 * @return Album object containing the Photo for the given userName,
	 *         albumName and photoName
	 *
	 */
	@Method(selector = "getPhotosByAlbumAndPhotoName:albumName:photoName:completionBlock:")
	public native void getPhotosByAlbumAndPhotoName(String userName, String albumName, String photoName, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Removes the particular Photo from the specified Album for a particular
	 * user. Note: The Photo is removed from the cloud and wont be accessible in
	 * future
	 *
	 * @param userName
	 *            - Name of the User whose photo has to be removed
	 * @param albumName
	 *            - Name of the Album in which photo has to be removed
	 * @param photoName
	 *            - Name of the Photo that has to be removed
	 *
	 * @return App42Response if removed successfully
	 *
	 */
	@Method(selector = "removePhoto:albumName:photoName:completionBlock:")
	public native void removePhoto(String userName, String albumName, String photoName, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Grant access to the particular Photo from the specified Album of a particular
	 * user for the list of ACls. 
	 *
	 * @param userName
	 *            - Name of the User who is giving access permission
	 * @param albumName
	 *            - Name of the Album in which photo has to be accessed
	 * @param photoName
	 *            - Name of the Photo for which access is requested
	 * @param aclList
	 *            - List of the Acl objects which holds the userNames and permission types
	 *
	 * @return Album object 
	 *         
	 */
 	@Method(selector = "grantAccessToPhoto:inAlbum:ofUser:withAclList:completionBlock:")
	public native void grantAccessToPhoto(String photoName, String albumName, String userName, NSArray<?> aclList, @Block App42ResponseBlock completionBlock);

	/**
	 * Revoke access to the particular Photo from the specified Album of a particular
	 * user for the list of ACls.
	 *
	 * @param userName
	 *            - Name of the User who is giving access permission
	 * @param albumName
	 *            - Name of the Album in which photo has to be accessed
	 * @param photoName
	 *            - Name of the Photo for which access is requested
	 * @param aclList
	 *            - List of the Acl objects which holds the userNames and permission types
	 *
	 * @return Album object
	 *
	 */
   	@Method(selector = "revokeAccessToPhoto:inAlbum:ofUser:withAclList:completionBlock:")
	public native void revokeAccessToPhoto(String photoName, String albumName, String userName, NSArray<?> aclList, @Block App42ResponseBlock completionBlock);

	/**
	 * Update Photo to the specified Album of a particular user.
	 *
	 * @param userName
	 *            - Name of the User who is giving access permission
	 * @param albumName
	 *            - Name of the Album in which photo has to be accessed
	 * @param photoName
	 *            - Name of the Photo for which access is requested
	 * @param path
	 *            - Path from where the photo need to be updated to the album.
	 *
	 * @return Album object
	 *
	 */
   	@Method(selector = "updatePhoto:inAlbum:ofUser:withAclList:completionBlock:")
	public native void updatePhoto(String userName, String albumName, String photoName, String photoDescription, String path, @Block App42ResponseBlock completionBlock);
}
