//
//  SessionService.h
//  App42_iOS_SERVICE_APIs
//
//  Created by shephertz technologies on 11/02/12.
//  Copyright (c) 2012 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "Session.h"
#import "App42Service.h"

/**
 * The Session Manager manages user sessions on the server side. It is a
 * persistent Session Manager. It allows to save attributes in the session and
 * retrieve them. This Session Manager is especially useful for Mobile/Device
 * Apps which want to do session management.
 *
 * @see Session
 *
 */
@interface SessionService : App42Service
{
    
}

-(id)init __attribute__((unavailable));
-(id)initWithAPIKey:(NSString *)apiKey  secretKey:(NSString *)secretKey;


/**
 * Create Session for the User. If the session does not exist it will create
 * a new session
 *
 * @param uName
 *            - UserName for which the session has to be created.
 *
 * @return Session object containing the session id of the created session.
 *         This id has to be used for storing or retrieving attributes.
 *
 */
-(void)getSession:(NSString*)uName completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Create User Session based on the isCreate boolean parameter. If isCreate
 * is true and there is an existing session for the user, the existing
 * session is returned. If there is no existing session for the user a new
 * one is created. If isCreate is false and there is an existing session,
 * the existing session is returned if there is no existing session new one
 * is not created
 *
 * @param uName
 *            - UserName for which the session has to be created.
 * @param isCreate
 *            - A boolean value for specifying if an existing session is not
 *            there, should a new one is to be created or not.
 *
 * @return Session object containing the session id of the created session.
 *         This id has to be used for storing or retrieving attributes.
 *
 */
-(void)getSession:(NSString*)uName isCreate:(BOOL)isCreate completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Invalidate a session based on the session id. All the attributes store in
 * the session will be lost.
 *
 * @param sessionId
 *            - The session id for which the session has to be invalidated.
 *
 * @return App42Response if invalidated successfully
 *
 */
-(void)invalidate:(NSString*)sessionId completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Sets attribute in a session whose session id is provided. Attributes are
 * stored in a key value pair.
 *
 * @param sessionId
 *            - Session id for which the attribute has to be saved.
 * @param attributeName
 *            - The attribute key that needs to be stored
 * @param attributeValue
 *            - The attribute value that needs to be stored
 *
 * @return Session object containing the attribute and value which is stored
 *
 */
-(void)setAttribute:(NSString *)sessionId attributeName:(NSString *)attributeName attributeValue:(NSString*) attributeValue completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Gets the attribute value in a session whose session id is provided.
 *
 * @param sessionId
 *            - The session id for which the attribute has to be fetched
 * @param attributeName
 *            - The attribute key that has to be fetched
 *
 * @return Session object containing the attribute and value which is stored
 *         for the session id and attribute name
 *
 */
-(void)getAttribute:(NSString *)sessionId attributeName:(NSString *)attributeName completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Get all the attributes for a given session id
 *
 * @param sessionId
 *            - The session id for which the attribute has to be fetched
 *
 * @return Session object containing all the attributes and values which are
 *         stored for the session id
 *
 */
-(void)getAllAttributes:(NSString *)sessionId completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Removes the attribute from a session whose session id is provided.
 *
 * @param sessionId
 *            - The session id for which the attribute has to be removed
 * @param attributeName
 *            - The attribute key that has to be removed
 *
 * @return App42Response if removed successfully
 *
 */
-(void)removeAttribute:(NSString*)sessionId attributeName:(NSString*)attributeName completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Removes all the attributes for a given session id
 *
 * @param sessionId
 *            - The session id for which the attributes has to be removed
 *
 * @return App42Response if removed successfully
 *
 */
-(void)removeAllAttributes:(NSString*)sessionId completionBlock:(App42ResponseBlock)completionBlock;
@end
