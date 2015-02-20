package org.robovm.bindings.app42;

import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class QueueService extends App42Service
{
	public QueueService(String apiKey, String secretKey) {
		super((SkipInit) null);
	    initObject(init(apiKey, secretKey));
	}
	
	@Method(selector = "initWithAPIKey:secretKey:")
	private native @Pointer long init(String apiKey, String secretKey);
	
	/**
	 * Creates a type Pull Queue
	 *
	 * @param queueName
	 *            - The name of the queue which has to be created
	 * @param queueDescription
	 *            - The description of the queue
	 *
	 * @return Queue object containing queue name which has been created
	 *
	 */
	@Method(selector = "createPullQueue:description:completionBlock:")
	public native void createPullQueue(String queueName, String queueDescription, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Deletes the Pull type Queue
	 *
	 * @param queueName
	 *            - The name of the queue which has to be deleted
	 *
	 * @return App42Response if deleted successfully
	 *
	 */
	@Method(selector = "deletePullQueue:completionBlock:")
	public native void deletePullQueue(String queueName, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Purges message on the Queue. Note: once the Queue is purged the messages
	 * are removed from the Queue and wont be available for dequeuing.
	 *
	 * @param queueName
	 *            - The name of the queue which has to be purged
	 *
	 * @return App42Response object containing queue name which has been purged
	 *
	 */
	@Method(selector = "purgePullQueue:completionBlock:")
	public native void purgePullQueue(String queueName, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Messages which are pending to be dequeue. Note: Calling this method does
	 * not dequeue the messages in the Queue. The messages stay in the Queue
	 * till they are dequeued
	 *
	 * @param queueName
	 *            - The name of the queue from which pending messages have to be
	 *            fetched
	 *
	 * @return Queue object containing pending messages in the Queue
	 *
	 */
	@Method(selector = "pendingMessages:completionBlock:")
	public native void pendingMessages(String queueName, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Messages are retrieved and dequeued from the Queue.
	 *
	 * @param queueName
	 *            - The name of the queue which have to be retrieved
	 * @param receiveTimeOut
	 *            - Receive time out
	 *
	 * @return Queue object containing messages in the Queue
	 *
	 */
	@Method(selector = "getMessages:receiveTimeOut:completionBlock:")
	public native void getMessages(String queueName, long receiveTimeOut, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Send message on the queue with an expiry. The message will expire if it
	 * is not pulled/dequeued before the expiry
	 *
	 * @param queueName
	 *            - The name of the queue to which the message has to be sent
	 * @param msg
	 *            - Message that has to be sent
	 * @param exp
	 *            - Message expiry time
	 *
	 * @return Queue object containing message which has been sent with its
	 *         message id and correlation id
	 *
	 */
	@Method(selector = "sendMessage:message:expiryTime:completionBlock:")
	public native void sendMessage(String queueName, String msg, long exp, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Pulls all the message from the queue
	 *
	 * @param queueName
	 *            - The name of the queue from which messages have to be pulled
	 * @param receiveTimeOut
	 *            - Receive time out
	 *
	 * @return Queue object containing messages which have been pulled
	 *
	 */
	@Method(selector = "receiveMessage:receiveTimeOut:completionBlock:")
	public native void receiveMessage(String queueName, long receiveTimeOut, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Pull message based on the correlation id
	 *
	 * @param queueName
	 *            - The name of the queue from which the message has to be
	 *            pulled
	 * @param receiveTimeOut
	 *            - Receive time out
	 * @param correlationId
	 *            - Correlation Id for which message has to be pulled
	 *
	 * @return Queue containing message which has pulled based on the
	 *         correlation id
	 *
	 */
	@Method(selector = "receiveMessageByCorrelationId:receiveTimeOut:correlationId:completionBlock:")
	public native void receiveMessageByCorrelationId(String queueName, long receiveTimeOut, String correlationId, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Remove message from the queue based on the message id. Note: Once the
	 * message is removed it cannot be pulled
	 *
	 * @param queueName
	 *            - The name of the queue from which the message has to be
	 *            removed
	 * @param messageId
	 *            - The message id of the message which has to be removed.
	 *
	 * @return App42Response if removed successfully
	 *
	 */
	@Method(selector = "removeMessage:messageId:completionBlock:")
	public native void removeMessage(String queueName, String messageId, @Block App42ResponseBlock completionBlock);
}
