//
//  UserService.h
//  PAE_iOS_SDK
//
//  Created by Shephertz Technology on 09/04/12.
//  Copyright (c) 2012 ShephertzTechnology PVT LTD. All rights reserved.
//




#import <Foundation/Foundation.h>
#import "Profile.h"
#import "App42Service.h"
#import "App42Exception.h"

@class User;
@class App42Response;

extern NSString *const MALE;
extern NSString *const FEMALE;

/**
 * Creates User for the App. App42 Cloud API's provides a complete User
 * Management for any Mobile or Web App. It supports User registration,
 * retrieval, state management e.g. lock, delete and Authentication.
 * 
 * Along with User Management the platform provides API's for persistent
 * SessionManagement
 * 
 * @see SessionService
 * @see User
 * @see App42Response
 */


@interface UserService : App42Service
{
    
   
}
-(id)init __attribute__((unavailable));
-(id)initWithAPIKey:(NSString *)apiKey  secretKey:(NSString *)secretKey;

/**
 * Create a User with userName, password & emailAddress
 *
 * @param uName
 *            - Name of the User
 * @param pwd
 *            - Password for the User
 * @param emailAddress
 *            - Email address of the user
 *
 * @return The created User object. Developer, using this method, is solely responsible for releasing this returned object.
 *
 */
-(void)createUser:(NSString*)uName password:(NSString*)pwd emailAddress:(NSString*)emailAddress completionBlock:(App42ResponseBlock)completionBlock;

/**
 * Create a User with userName, password & emailAddress and assigns the
 * roles to the created User
 *
 * @param uName
 *            - Name of the User
 * @param pwd
 *            - Password for the User
 * @param emailAddress
 *            - Email address of the user
 * @param roleList
 *            - List of roles to be assigned to User
 *
 * @return The created User object with role list.Developer, using this method, is solely responsible for releasing this returned object.
 *
 */
-(void)createUser:(NSString*)uName password:(NSString*)pwd emailAddress:(NSString*)emailAddress roleList:(NSArray*)roleList completionBlock:(App42ResponseBlock)completionBlock;

/**
 * Assign Roles to the existing User
 *
 * @param uName
 *            - Name of the User to whom the roles have to be assigned
 * @param roleList
 *            - List of roles to be added to User
 *
 * @return The created User object with assigned roles.
 *
 */
-(void)assignRoles:(NSString*)uName roleList:(NSArray*)roleList completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Gets the User details based on userName
 *
 * @param userName
 *            - Name of the User to retrieve
 *
 * @return User Object containing the profile information
 *
 */
-(void)getUser:(NSString*)userName completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Get the assigned roles to the specified User
 *
 * @param userName
 *            - Name of the User for whom roles have to be retrieved
 *
 * @return User Object containing the role information
 *
 */
-(void)getRolesByUser:(NSString*)userName completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Get all the Users who have the specified role assigned
 *
 * @param role
 *            - Role for which Users needs to be retrieved
 *
 * @return List of User Object for that particular role
 *
 */
-(void)getUsersByRole:(NSString*)role completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Gets the count of all the users
 *
 * @return the count of all User exists
 *
 * @throws App42Exception
 */
-(void)getAllUsersCount:(App42ResponseBlock)completionBlock;
/**
 * Gets the count of all the locked users
 *
 * @return the count of locked User exists
 *
 */
-(void)getLockedUsersCount:(App42ResponseBlock)completionBlock;
/**
 * Gets the details of all users
 *
 * @return the List that contains all User Object
 *
 */
-(void)getAllUsers:(App42ResponseBlock)completionBlock;
/**
 * Gets all users by Paging
 *
 * @param max
 *            - Maximum number of records to be fetched
 * @param offset
 *            - From where the records are to be fetched
 *
 * @return the List that contains all User Object
 *
 */
-(void)getAllUsers:(int)max offset:(int)offset completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Gets the details of all the locked users
 *
 * @return the list containing locked User Objects
 *
 */
-(void)getLockedUsers:(App42ResponseBlock)completionBlock;

/**
 * Gets the details of all the locked users By paging.
 *
 * @param max
 *            - Maximum number of records to be fetched
 * @param offset
 *            - From where the records are to be fetched
 *
 * @return the List containing locked User Objects
 *
 */
-(void)getLockedUsers:(int)max offset:(int)offset completionBlock:(App42ResponseBlock)completionBlock;

/**
 * Gets user details based on emailId
 *
 * @param emailId
 *            - EmailId of the user to be retrieved
 *
 * @return User Object
 *
 */
-(void)getUserByEmailId:(NSString*)emailId completionBlock:(App42ResponseBlock)completionBlock;

/**
 * Updates the User's Email Address based on userName. Note: Only email can
 * be updated. Username cannot be updated.
 *
 * @param uName
 *            - UserName which should be unique for the App
 * @param emailAddress
 *            - Email address of the user
 *
 * @returns updated User Object
 *
 */
-(void)updateEmail:(NSString*)uName emailAddress:(NSString*)emailAddress completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Deletes a particular user based on userName.
 *
 * @param userName
 *            - UserName which should be unique for the App
 *
 * @returns App42Response Object if user deleted successfully
 *
 */
-(void)deleteUser:(NSString*)userName completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Creates or Updates User Profile. First time the Profile for the user is
 * created and in future calls user profile will be updated. This will
 * always update the profile with new value passed in profile object. Call
 * to this method should have all the values you want to retain in user
 * profile object, otherwise old values of profile will get updated with
 * null. Method only updates the profile of user, passing email/password in
 * user object does not have any significance for this method call.
 *
 * @param user
 *            - User for which profile has to be updated, this should
 *            contain the userName and profile object in it.
 *
 * @returns User Object with updated Profile information
 *
 * @see Profile
 */
-(void)createOrUpdateProfile:(User *)user completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Authenticate user based on userName and password
 *
 * @param uName
 *            - UserName which should be unique for the App
 * @param pwd
 *            - Password for the User
 *
 * @returns The authenticated User object. Developer, using this method, is solely responsible for releasing this returned object.
 *
 */
-(void)authenticateUser:(NSString*)uName password:(NSString*)password completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Locks the user based on the userName. Apps can use these feature to lock
 * a user because of reasons specific to their usercase e.g. If payment not
 * received and the App wants the user to be inactive
 *
 * @param uName
 *            - UserName which should be unique for the App
 *
 * @returns the locked User Object
 *
 */
-(void)lockUser:(NSString*)uName completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Unlocks the user based on the userName. App developers can use this
 * feature to unlock a user because of reasons specific to their usercase
 * e.g. When payment received, the App developer wants the user to be
 * active.
 *
 * @param uName
 *            - UserName which should be unique for the App
 *
 * @returns the unlocked User Object
 *
 */
-(void)unlockUser:(NSString*)uName completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Changes the password for user based on the userName.
 *
 * @param uName
 *            - UserName which should be unique for the App
 * @param oldPwd
 *            - Old Password for the user for authentication
 * @param newPwd
 *            - New Password for the user to change
 *
 * @returns App42Response Object if updated successfully
 *
 */
-(void)changeUserPassword:(NSString*)uName oldPassword:(NSString*)oldPwd newPassword:(NSString*)newPwd completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Revokes the specified role from the user.
 *
 * @param userName
 *            - UserName from whom the role has to be revoked
 * @param role
 *            - Role that has to be revoked
 *
 * @returns App42Response of the object that contains the information about
 *          User with its role
 *
 */
-(void)revokeRole:(NSString*)userName role:(NSString*)role completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Revokes all the roles from the user.
 *
 * @param userName
 *            - Name of the User from whom Roles have to be revoked
 *
 * @returns App42Response of the object that contains the User information
 *
 */
-(void)revokeAllRoles:(NSString*)userName completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Gets the list of Users based on Profile Data
 *
 * @param profileData
 *            - Profile Data key/value for which Users need to be retrieved
 *
 * @return List of User Object for the specified profile data
 *
 */
-(void)getUsersByProfileData:(Profile*)profileData completionBlock:(App42ResponseBlock)completionBlock;

/**
 * Updates the User password based on userName. Username cannot be updated.
 *
 * @param uName
 *            - UserName which should be unique for the App
 *
 * @returns App42Response Object
 *
 */

-(void)resetUserPassword:(NSString*)uName completionBlock:(App42ResponseBlock)completionBlock;

/**
 * logout
 *
 * @param sessionId
 *            - sessionId
 * @throws App42Exception
 */
-(void)logout:(NSString*) sessionId completionBlock:(App42ResponseBlock)completionBlock;

/**
 *
 * @param uName
 * @param pwd
 * @param emailAddress
 * @param profile
 * @return
 * @throws App42Exception
 */
-(void)createUserWithProfile:(NSString*)userName
                    password:(NSString*)password
                emailAddress:(NSString*) emailAddress
                     profile:(Profile*) profile
             completionBlock:(App42ResponseBlock)completionBlock;

/**
 *
 * @param users : Array of userNames for which details need to be retrieved
 * @return
 * @throws App42Exception
 */
-(void)getUsersByGroup:(NSArray*)users completionBlock:(App42ResponseBlock)completionBlock;


-(void)addUserInfo:(NSDictionary*)userInfo collectionName:(NSString*) collectionName completionBlock:(App42ResponseBlock)completionBlock;
@end
