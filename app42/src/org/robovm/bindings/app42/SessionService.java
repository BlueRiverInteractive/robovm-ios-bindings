package org.robovm.bindings.app42;

import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class SessionService extends App42Service
{
	public SessionService(String apiKey, String secretKey) {
		super((SkipInit) null);
	    initObject(init(apiKey, secretKey));
	}
	
	@Method(selector = "initWithAPIKey:secretKey:")
	private native @Pointer long init(String apiKey, String secretKey);
	
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
	@Method(selector = "getSession:completionBlock:")
	public native void getSession(String userName, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "getSession:isCreate:completionBlock:")
	public native void getSession(String userName, boolean isCreate, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "invalidate:completionBlock:")
	public native void invalidate(String sessionId, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "setAttribute:attributeName:attributeValue:completionBlock:")
	public native void invalidate(String sessionId, String attributeName, String attributeValue, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "getAttribute:attributeName:completionBlock:")
	public native void getAttribute(String sessionId, String attributeName, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "getAllAttributes:completionBlock:")
	public native void getAllAttributes(String sessionId, String attributeName, @Block App42ResponseBlock completionBlock);
	
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
	@Method(selector = "removeAttribute:attributeName:completionBlock:")
	public native void removeAttribute(String sessionId, String attributeName, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Removes all the attributes for a given session id
	 *
	 * @param sessionId
	 *            - The session id for which the attributes has to be removed
	 *
	 * @return App42Response if removed successfully
	 *
	 */
	@Method(selector = "removeAllAttributes:completionBlock:")
	public native void removeAllAttributes(String sessionId, @Block App42ResponseBlock completionBlock);
}
