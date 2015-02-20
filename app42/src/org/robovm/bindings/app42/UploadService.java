package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSData;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.ByVal;
import org.robovm.rt.bro.annotation.GlobalValue;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class UploadService extends App42Service
{
	@GlobalValue(symbol = "AUDIO", optional=true)
	public static native @ByVal String AUDIO();
	
	@GlobalValue(symbol = "VIDEO", optional=true)
	public static native @ByVal String VIDEO();
	
	@GlobalValue(symbol = "IMAGE", optional=true)
	public static native @ByVal String IMAGE();
	
	@GlobalValue(symbol = "BINARY", optional=true)
	public static native @ByVal String BINARY();
	
	@GlobalValue(symbol = "TXT", optional=true)
	public static native @ByVal String TXT();
	
	@GlobalValue(symbol = "XML", optional=true)
	public static native @ByVal String XML();
	
	@GlobalValue(symbol = "CSV", optional=true)
	public static native @ByVal String CSV();
	
	@GlobalValue(symbol = "JSON", optional=true)
	public static native @ByVal String JSON();
	
	@GlobalValue(symbol = "OTHER", optional=true)
	public static native @ByVal String OTHER();
	
	public UploadService(String apiKey, String secretKey) {
		super((SkipInit) null);
	    initObject(init(apiKey, secretKey));
	}
	
	@Method(selector = "initWithAPIKey:secretKey:")
	private native @Pointer long init(String apiKey, String secretKey);
	
	/**
	 * Uploads file on the cloud.
	 *
	 * @param name
	 *            - The name of the file which has to be saved. It is used to
	 *            retrieve the file.
	 * @param filePath
	 *            - The local path for the file
	 * @param fileType
	 *            - The type of the file. File can be either Audio, Video,
	 *            Image, Binary, Txt, xml, json, csv or other Use the static
	 *            constants e.g. Upload.AUDIO, Upload.XML etc.
	 * @param description
	 *            - Description of the file to be uploaded.
	 *
	 * @return Upload object
	 *
	 */
	@Method(selector = "uploadFile:filePath:uploadFileType:fileDescription:completionBlock:")
	public native void uploadFile(String name, String filePath, String uploadFileType, String fileDescription, @Block App42ResponseBlock completionBlock);
		
	/**
	 * Uploads file on the cloud via Stream.
	 *
	 * @param name
	 *            - The name of the file which has to be saved. It is used to
	 *            retrieve the file
	 * @param inputStream
	 *            - InputStream of the file to be uploaded.
	 * @param fileType
	 *            - The type of the file. File can be either Audio, Video,
	 *            Image, Binary, Txt, xml, json, csv or other Use the static
	 *            constants e.g. Upload.AUDIO, Upload.XML etc.
	 * @param description
	 *            - Description of the file to be uploaded.
	 *
	 * @return Upload object
	 *
	 */
	@Method(selector = "uploadFile:fileData:uploadFileType:fileDescription:completionBlock:")
	public native void uploadFile(String name, NSData fileData, String uploadFileType, String fileDescription, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Uploads file on the cloud for given user.
	 *
	 * @param name
	 *            - The name of the file which has to be saved. It is used to
	 *            retrieve the file
	 * @param userName
	 *            - The name of the user for which file has to be saved.
	 * @param filePath
	 *            - The local path for the file
	 * @param fileType
	 *            - The type of the file. File can be either Audio, Video,
	 *            Image, Binary, Txt, xml, json, csv or other Use the static
	 *            constants e.g. Upload.AUDIO, Upload.XML etc.
	 * @param description
	 *            - Description of the file to be uploaded.
	 *
	 * @return Upload object
	 *
	 */
	@Method(selector = "uploadFileForUser:userName:filePath:uploadFileType:fileDescription:completionBlock:")
	public native void uploadFileForUser(String name, String userName, String filePath, String uploadFileType, String fileDescription, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Uploads file on the cloud for given user via Stream.
	 *
	 * @param name
	 *            - The name of the file which has to be saved. It is used to
	 *            retrieve the file
	 * @param userName
	 *            - The name of the user for which file has to be saved.
	 * @param inputStream
	 *            - InputStream of the file to be uploaded.
	 * @param fileType
	 *            - The type of the file. File can be either Audio, Video,
	 *            Image, Binary, Txt, xml, json, csv or other Use the static
	 *            constants e.g. Upload.AUDIO, Upload.XML etc.
	 * @param description
	 *            - Description of the file to be uploaded.
	 *
	 * @return Upload object
	 *
	 */
	@Method(selector = "uploadFileForUser:userName:fileData:uploadFileType:fileDescription:completionBlock:")
	public native void uploadFileForUser(String name, String userName, NSData fileData, String uploadFileType, String fileDescription, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Gets count of all the files for the App
	 *
	 * @return App42Response object
	 *
	 */
	@Method(selector = "getAllFilesCount:")
	public native void getAllFilesCount(@Block App42ResponseBlock completionBlock);
	
	/**
	 * Gets all the files for the App
	 *
	 * @return Upload object
	 *
	 */
	@Method(selector = "getAllFiles:")
	public native void getAllFiles(@Block App42ResponseBlock completionBlock);
	
	/**
	 * Gets all the files By Paging for the App
	 *
	 * @param max
	 *            - Maximum number of records to be fetched
	 * @param offset
	 *            - From where the records are to be fetched
	 *
	 * @return Upload object
	 *
	 */
	@Method(selector = "getAllFiles:offset:completionBlock:")
	public native void getAllFiles(int max, int offset, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Gets the file based on user and file name.
	 *
	 * @param name
	 *            - The name of the file which has to be retrieved
	 * @param userName
	 *            - The name of the user for which file has to be retrieved
	 *
	 * @return Upload object
	 *
	 */
	@Method(selector = "getFileByUser:userName:completionBlock:")
	public native void getFileByUser(String fileName, String userName, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Gets the count of file based on user name.
	 *
	 * @param userName
	 *            - The name of the user for which count of the file has to be
	 *            retrieved
	 *
	 * @return App42Response object
	 *
	 */
	@Method(selector = "getAllFilesCountByUser:completionBlock:")
	public native void getAllFilesCountByUser(String userName, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Get all the file based on user name.
	 *
	 * @param userName
	 *            - The name of the user for which file has to be retrieved
	 *
	 * @return Upload object
	 *
	 */
	@Method(selector = "getAllFilesByUser:completionBlock:")
	public native void getAllFilesByUser(String userName, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Get all the files based on user name by Paging.
	 *
	 * @param userName
	 *            - The name of the user for which file has to be retrieved
	 * @param max
	 *            - Maximum number of records to be fetched
	 * @param offset
	 *            - From where the records are to be fetched
	 *
	 * @return Upload object
	 */
	@Method(selector = "getAllFilesByUser:max:offset:completionBlock:")
	public native void getAllFilesByUser(String userName, int max, int offset, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Gets the file based on file name.
	 *
	 * @param name
	 *            - The name of the file which has to be retrieved
	 *
	 * @return Upload object
	 *
	 */
	@Method(selector = "getFileByName:completionBlock:")
	public native void getFileByName(String name, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Removes the file based on file name and user name.
	 *
	 * @param name
	 *            - The name of the file which has to be removed
	 * @param userName
	 *            - The name of the user for which file has to be removed
	 *
	 * @return App42Response if deleted successfully
	 *
	 */
	@Method(selector = "removeFileByUser:userName:completionBlock:")
	public native void removeFileByUser(String name, String userName, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Removes the files based on user name.
	 *
	 * @param userName
	 *            - The name of the user for which files has to be removed
	 *
	 * @return App42Response if deleted successfully
	 *
	 */
	@Method(selector = "removeAllFilesByUser:completionBlock:")
	public native void removeAllFilesByUser(String userName, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Removes the file based on file name.
	 *
	 * @param name
	 *            - The name of the file which has to be removed
	 *
	 * @return App42Response if deleted successfully
	 *
	 */
	@Method(selector = "removeFileByName:completionBlock:")
	public native void removeFileByName(String name, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Removes all the files for the App
	 *
	 * @return App42Response if deleted successfully
	 *
	 */
	@Method(selector = "removeAllFiles:")
	public native void removeAllFiles(@Block App42ResponseBlock completionBlock);
	
	/**
	 * Get the count of files based on file type.
	 *
	 * @param uploadFileType
	 *            - Type of the file e.g. Upload.AUDIO, Upload.XML etc.
	 *
	 * @return App42Response object
	 *
	 */
	@Method(selector = "getFilesCountByType:completionBlock:")
	public native void getFilesCountByType(String uploadFileType, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Get the files based on file type.
	 *
	 * @param uploadFileType
	 *            - Type of the file e.g. Upload.AUDIO, Upload.XML etc.
	 *
	 * @return Upload object
	 *
	 */
	@Method(selector = "getFilesByType:completionBlock:")
	public native void getFilesByType(String uploadFileType, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Get the files based on file type by Paging.
	 *
	 * @param uploadFileType
	 *            - Type of the file e.g. Upload.AUDIO, Upload.XML etc.
	 * @param max
	 *            - Maximum number of records to be fetched
	 * @param offset
	 *            - From where the records are to be fetched
	 *
	 * @return Upload object
	 *
	 */
	@Method(selector = "getFilesByType:max:offset:completionBlock:")
	public native void getFilesByType(String uploadFileType, int max, int offset, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Grant access of files based on aclList.
	 *
	 * @param userName
	 *            - userName who grants the access
	 * @param aclList
	 *            - List of the Acl objects which holds the userNames and permission types
	 *
	 * @return App42Response object
	 *
	 */
   	@Method(selector = "grantAccessOnFile:ofUser:withAclList:completionBlock:")
	public native void grantAccessOnFile(String fileName, String userName, NSArray<?> aclList, @Block App42ResponseBlock completionBlock);
	
   	/**
	 * Revoke access of files based on aclList.
	 *
	 * @param userName
	 *            - userName who revokes the access
	 * @param aclList
	 *            - List of the Acl objects which holds the userNames and permission types
	 *
	 * @return App42Response object
	 *
	 */
   	@Method(selector = "revokeAccessOnFile:ofUser:withAclList:completionBlock:")
	public native void revokeAccessOnFile(String fileName, String userName, NSArray<?> aclList, @Block App42ResponseBlock completionBlock);
	/**
	 *
	 * @param name
	 *            - The name of the file which has to be saved. It is used to
	 *            retrieve the file.
	 * @param userName
	 *            - Name of the user who is uploading the file
	 * @param ownerName
	 *            - Name of owner of the group
	 * @param groupName
	 *            - Name of the group in which file has to upload
	 * @param filePath
	 *            - The local path for the file
	 * @param fileType
	 *            - Type of the file e.g. Upload.AUDIO, Upload.XML etc.
	 * @param description
	 *            - Description of the file to be uploaded.
	 * @return Upload object
	 * @throws App42Exception
	 */
	@Method(selector = "uploadFileForGroup:userName:ownerName:groupName:filePath:fileType:description:completionBlock:")
	public native void uploadFileForGroup(String fileName, String userName, String ownerName, String groupName, String filePath, String fileType, String description, @Block App42ResponseBlock completionBlock);
	/**
	 *
	 * @param name
	 *            - The name of the file which has to be saved. It is used to
	 *            retrieve the file.
	 * @param userName
	 *            - Name of the user who is uploading the file
	 * @param ownerName
	 *            - Name of owner of the group
	 * @param groupName
	 *            - Name of the group in which file has to upload
	 * @param fileData
	 *            - The File data to be uploaded
	 * @param fileType
	 *            - Type of the file e.g. Upload.AUDIO, Upload.XML etc.
	 * @param description
	 *            - Description of the file to be uploaded.
	 * @return Upload object
	 * @throws App42Exception
	 */
 	@Method(selector = "uploadFileForGroup:userName:ownerName:groupName:fileData:fileType:description:completionBlock:")
	public native void uploadFileForGroup(String fileName, String userName, String ownerName, String groupName, NSData fileData, String fileType, String description, @Block App42ResponseBlock completionBlock);
	
 	/**
	 *
	 * @param name
	 *            - The name of the file which has to be saved. It is used to
	 *            retrieve the file.
	 * @param userName
	 *            - Name of the user who is uploading the file
	 * @param buddyName
	 *            - Name of the buddy for which file has to upload
	 * @param filePath
	 * @param fileType
	 * @param filePath
	 *            - The local path for the file
	 * @param fileType
	 *            - Type of the file e.g. Upload.AUDIO, Upload.XML etc.
	 * @param description
	 *            - Description of the file to be uploaded.
	 * @return Upload object
	 * @throws App42Exception
	 */
   	@Method(selector = "uploadFileForFriend:userName:buddyName:groupName:filePath:fileType:description:completionBlock:")
	public native void uploadFileForFriend(String fileName, String userName, String buddyName, String filePath, String fileType, String description, @Block App42ResponseBlock completionBlock);
	
   	/**
	 *
	 * @param name
	 *            - The name of the file which has to be saved. It is used to
	 *            retrieve the file.
	 * @param userName
	 *            - Name of the user who is uploading the file
	 * @param buddyName
	 *            - Name of the buddy for which file has to upload
	 * @param fileData
	 *            - The data of a file to be uploaded.
	 * @param fileType
	 *            - Type of the file e.g. Upload.AUDIO, Upload.XML etc.
	 * @param description
	 *            - Description of the file to be uploaded.
	 * @return Upload object
	 * @throws App42Exception
	 */
 	@Method(selector = "uploadFileForFriend:userName:buddyName:groupName:fileData:fileType:description:completionBlock:")
	public native void uploadFileForFriend(String fileName, String userName, String buddyName, NSData fileData, String fileType, String description, @Block App42ResponseBlock completionBlock);
	
 	/**
	 *
	 * @param name
	 *            - The name of the file which has to be saved. It is used to
	 *            retrieve the file.
	 * @param userName
	 *            - Name of the user who is uploading the file
	 * @param filePath
	 *            - The local path for the file
	 * @param fileType
	 *            - Type of the file e.g. Upload.AUDIO, Upload.XML etc.
	 * @param description
	 *            - Description of the file to be uploaded.
	 * @return Upload object
	 * @throws App42Exception
	 */
	@Method(selector = "uploadFileForFriends:userName:filePath:fileType:description:completionBlock:")
	public native void uploadFileForFriends(String fileName, String userName, String filePath, String fileType, String description, @Block App42ResponseBlock completionBlock);
}
