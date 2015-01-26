package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSDictionary;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class UserService extends App42Service
{
	public UserService(String apiKey, String secretKey) {
		super((SkipInit) null);
	    initObject(init(apiKey, secretKey));
	}
	
	@Method(selector = "initWithAPIKey:secretKey:")
	private native @Pointer long init(String apiKey, String secretKey);
	
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
	@Method(selector = "createUser:password:emailAddress:completionBlock:")
	public native void createUser(String userName, String password, String emailAddress, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "createUser:password:emailAddress:roleList:completionBlock:")
	public native void createUser(String userName, String password, String emailAddress, NSArray<?> roleList, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "assignRoles:roleList:completionBlock:")
	public native void assignRoles(String userName, NSArray<?> roleList, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Gets the User details based on userName
	 *
	 * @param userName
	 *            - Name of the User to retrieve
	 *
	 * @return User Object containing the profile information
	 *
	 */
	@Method(selector = "getUser:completionBlock:")
	public native void getUser(String userName, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Get the assigned roles to the specified User
	 *
	 * @param userName
	 *            - Name of the User for whom roles have to be retrieved
	 *
	 * @return User Object containing the role information
	 *
	 */
	@Method(selector = "getRolesByUser:completionBlock:")
	public native void getRolesByUser(String userName, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Get all the Users who have the specified role assigned
	 *
	 * @param role
	 *            - Role for which Users needs to be retrieved
	 *
	 * @return List of User Object for that particular role
	 *
	 */
	@Method(selector = "getUsersByRole:completionBlock:")
	public native void getUsersByRole(String role, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Gets the count of all the users
	 *
	 * @return the count of all User exists
	 *
	 * @throws App42Exception
	 */
	@Method(selector = "getAllUsersCount:")
	public native void getAllUsersCount(@Block App42ResponseBlock completionBlock);
	
	/**
	 * Gets the count of all the locked users
	 *
	 * @return the count of locked User exists
	 *
	 */
	@Method(selector = "getLockedUsersCount:")
	public native void getLockedUsersCount(@Block App42ResponseBlock completionBlock);
	
	/**
	 * Gets the details of all users
	 *
	 * @return the List that contains all User Object
	 *
	 */
	@Method(selector = "getAllUsers:")
	public native void getAllUsers(@Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "getAllUsers:offset:completionBlock:")
	public native void getAllUsers(int max, int offset, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Gets the details of all the locked users
	 *
	 * @return the list containing locked User Objects
	 *
	 */
	@Method(selector = "getLockedUsers:")
	public native void getLockedUsers(@Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "getLockedUsers:offset:completionBlock:")
	public native void getLockedUsers(int max, int offset, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Gets user details based on emailId
	 *
	 * @param emailId
	 *            - EmailId of the user to be retrieved
	 *
	 * @return User Object
	 *
	 */
	@Method(selector = "getUserByEmailId:completionBlock:")
	public native void getUserByEmailId(String emailId, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "updateEmail:emailAddress:completionBlock:")
	public native void updateEmail(String userName, String emailId, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Deletes a particular user based on userName.
	 *
	 * @param userName
	 *            - UserName which should be unique for the App
	 *
	 * @returns App42Response Object if user deleted successfully
	 *
	 */
	@Method(selector = "deleteUser:completionBlock:")
	public native void deleteUser(String userName, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "createOrUpdateProfile:completionBlock:")
	public native void createOrUpdateProfile(User user, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "authenticateUser:password:completionBlock:")
	public native void authenticateUser(String userName, String password, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "lockUser:completionBlock:")
	public native void lockUser(String userName, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "unlockUser:completionBlock:")
	public native void unlockUser(String userName, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "changeUserPassword:oldPassword:newPassword:completionBlock:")
	public native void changeUserPassword(String userName, String oldPassword, String newPassword, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "revokeRole:role:completionBlock:")
	public native void revokeRole(String userName, String role, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Revokes all the roles from the user.
	 *
	 * @param userName
	 *            - Name of the User from whom Roles have to be revoked
	 *
	 * @returns App42Response of the object that contains the User information
	 *
	 */
	@Method(selector = "revokeAllRoles:completionBlock:")
	public native void revokeAllRoles(String userName, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Gets the list of Users based on Profile Data
	 *
	 * @param profileData
	 *            - Profile Data key/value for which Users need to be retrieved
	 *
	 * @return List of User Object for the specified profile data
	 *
	 */
	@Method(selector = "getUsersByProfileData:completionBlock:")
	public native void getUsersByProfileData(Profile profileData, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Updates the User password based on userName. Username cannot be updated.
	 *
	 * @param uName
	 *            - UserName which should be unique for the App
	 *
	 * @returns App42Response Object
	 *
	 */
	@Method(selector = "resetUserPassword:completionBlock:")
	public native void resetUserPassword(String userName, @Block App42ResponseBlock completionBlock);
	
	/**
	 * logout
	 *
	 * @param sessionId
	 *            - sessionId
	 * @throws App42Exception
	 */
	@Method(selector = "logout:completionBlock:")
	public native void logout(String sessionId, @Block App42ResponseBlock completionBlock);
		
	/**
	 *
	 * @param uName
	 * @param pwd
	 * @param emailAddress
	 * @param profile
	 * @return
	 * @throws App42Exception
	 */
 	@Method(selector = "createUserWithProfile:password:emailAddress:profile:completionBlock:")
	public native void createUserWithProfile(String userName, String password, String emailAddress, Profile profile, @Block App42ResponseBlock completionBlock);
	
 	/**
	 *
	 * @param users : Array of userNames for which details need to be retrieved
	 * @return
	 * @throws App42Exception
	 */
 	@Method(selector = "getUsersByGroup:completionBlock:")
	public native void getUsersByGroup(NSArray<?> users, @Block App42ResponseBlock completionBlock);

 	@Method(selector = "addUserInfo:")
	public native void addUserInfo(NSDictionary<?, ?> userInfo, String collectionName, @Block App42ResponseBlock completionBlock);
}
