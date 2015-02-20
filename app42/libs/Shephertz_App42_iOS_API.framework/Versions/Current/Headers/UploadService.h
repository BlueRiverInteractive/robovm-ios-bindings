//
//  UploadService.h
//  PAE_iOS_SDK
//
//  Created by Shephertz Technology on 13/04/12.
//  Copyright (c) 2012 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "Upload.h"
#import "App42Service.h"
/**
 * Uploads file on the cloud. Allows access to the files through url. Its
 * especially useful for mobile/device apps. It minimizes the App footprint on
 * the device.
 *
 * @see Upload
 * @see App42Response
 */


extern NSString *const AUDIO;
extern NSString *const VIDEO;
extern NSString *const IMAGE;
extern NSString *const BINARY;
extern NSString *const TXT;
extern NSString *const XML;
extern NSString *const CSV;
extern NSString *const JSON;
extern NSString *const OTHER;

/*
 typedef enum fileType{
 Audio,Video,Image,Binary,Txt,Xml,Csv,Json,Other
 }FileType;*/


@interface UploadService : App42Service
{
    
}


-(id)init __attribute__((unavailable));
-(id)initWithAPIKey:(NSString *)apiKey  secretKey:(NSString *)secretKey;


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
-(void)uploadFile:(NSString*)name filePath:(NSString*)filePath uploadFileType:(NSString*)uploadFileType fileDescription:(NSString*)description completionBlock:(App42ResponseBlock)completionBlock;
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
-(void)uploadFile:(NSString*)name fileData:(NSData*)fileData uploadFileType:(NSString*)uploadFileType fileDescription:(NSString*)description completionBlock:(App42ResponseBlock)completionBlock;
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
-(void)uploadFileForUser:(NSString*)name userName:(NSString*)userName filePath:(NSString*)filePath uploadFileType:(NSString*)uploadFileType fileDescription:(NSString*)description completionBlock:(App42ResponseBlock)completionBlock;
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
-(void)uploadFileForUser:(NSString*)name userName:(NSString*)userName fileData:(NSData*)fileData uploadFileType:(NSString*)uploadFileType fileDescription:(NSString*)description completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Gets count of all the files for the App
 *
 * @return App42Response object
 *
 */
-(void)getAllFilesCount:(App42ResponseBlock)completionBlock;
/**
 * Gets all the files for the App
 *
 * @return Upload object
 *
 */
-(void)getAllFiles:(App42ResponseBlock)completionBlock;
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
-(void)getAllFiles:(int)max offset:(int)offset completionBlock:(App42ResponseBlock)completionBlock;
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
-(void)getFileByUser:(NSString*)fileName userName:(NSString*)userName completionBlock:(App42ResponseBlock)completionBlock;

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
-(void)getAllFilesCountByUser:(NSString*)userName completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Get all the file based on user name.
 *
 * @param userName
 *            - The name of the user for which file has to be retrieved
 *
 * @return Upload object
 *
 */
-(void)getAllFilesByUser:(NSString*)userName completionBlock:(App42ResponseBlock)completionBlock;
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
-(void)getAllFilesByUser:(NSString*)userName max:(int)max offset:(int)offset completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Gets the file based on file name.
 *
 * @param name
 *            - The name of the file which has to be retrieved
 *
 * @return Upload object
 *
 */
-(void)getFileByName:(NSString*)name completionBlock:(App42ResponseBlock)completionBlock;
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
-(void)removeFileByUser:(NSString*)name userName:(NSString*)userName completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Removes the files based on user name.
 *
 * @param userName
 *            - The name of the user for which files has to be removed
 *
 * @return App42Response if deleted successfully
 *
 */
-(void)removeAllFilesByUser:(NSString*)userName completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Removes the file based on file name.
 *
 * @param name
 *            - The name of the file which has to be removed
 *
 * @return App42Response if deleted successfully
 *
 */
-(void)removeFileByName:(NSString*)name completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Removes all the files for the App
 *
 * @return App42Response if deleted successfully
 *
 */
-(void)removeAllFiles:(App42ResponseBlock)completionBlock;
/**
 * Get the count of files based on file type.
 *
 * @param uploadFileType
 *            - Type of the file e.g. Upload.AUDIO, Upload.XML etc.
 *
 * @return App42Response object
 *
 */
-(void)getFilesCountByType:(NSString*)uploadFileType completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Get the files based on file type.
 *
 * @param uploadFileType
 *            - Type of the file e.g. Upload.AUDIO, Upload.XML etc.
 *
 * @return Upload object
 *
 */
-(void)getFilesByType:(NSString*)uploadFileType completionBlock:(App42ResponseBlock)completionBlock;

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
-(void)getFilesByType:(NSString*)uploadFileType max:(int)max offset:(int)offset completionBlock:(App42ResponseBlock)completionBlock;

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

-(void)grantAccessOnFile:(NSString*)fileName
                            ofUser:(NSString*)userName
                       withAclList:(NSArray*) aclList
                   completionBlock:(App42ResponseBlock)completionBlock;

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
-(void)revokeAccessOnFile:(NSString*)fileName
                             ofUser:(NSString*)userName
                        withAclList:(NSArray*) aclList
                    completionBlock:(App42ResponseBlock)completionBlock;

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
-(void)uploadFileForGroup:(NSString*)fileName
                    userName:(NSString*) userName
                   ownerName:(NSString*) ownerName
                   groupName:(NSString*) groupName
                    filePath:(NSString*) filePath
                    fileType:(NSString*) fileType
                 description:(NSString*) description
             completionBlock:(App42ResponseBlock)completionBlock;

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

-(void)uploadFileForGroup:(NSString*) fileName
                    userName:(NSString*) userName
                   ownerName:(NSString*) ownerName
                   groupName:(NSString*) groupName
                    fileData:(NSData  *) fileData
                    fileType:(NSString*) fileType
                 description:(NSString*) description
             completionBlock:(App42ResponseBlock)completionBlock;


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

-(void)uploadFileForFriend:(NSString*)fileName
                     userName:(NSString*) userName
                    buddyName:(NSString*) buddyName
                     filePath:(NSString*) filePath
                     fileType:(NSString*) fileType
                  description:(NSString*) description
              completionBlock:(App42ResponseBlock)completionBlock;

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

-(void)uploadFileForFriend:(NSString*) fileName
                     userName:(NSString*) userName
                    buddyName:(NSString*) buddyName
                     fileData:(NSData  *) fileData
                     fileType:(NSString*) fileType
                  description:(NSString*) description
              completionBlock:(App42ResponseBlock)completionBlock;


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

-(void)uploadFileForFriends:(NSString*)fileName
                      userName:(NSString*) userName
                      filePath:(NSString*) filePath
                      fileType:(NSString*) fileType
                   description:(NSString*) description
               completionBlock:(App42ResponseBlock)completionBlock;

@end
