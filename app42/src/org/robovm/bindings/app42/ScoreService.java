package org.robovm.bindings.app42;

import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class ScoreService extends App42Service
{
	public ScoreService(String apiKey, String secretKey) {
		super((SkipInit) null);
	    initObject(init(apiKey, secretKey));
	}
	
	@Method(selector = "initWithAPIKey:secretKey:")
	private native @Pointer long init(String apiKey, String secretKey);

	/**
	 * Adds game score for the specified user.
	 *
	 * @param gameName
	 *            - Name of the game for which scores have to be added
	 * @param gameUserName
	 *            - The user for whom scores have to be added
	 * @param gameScore
	 *            - The scores that have to be added
	 *
	 * @return Game object containing the scores that has been added
	 *
	 */
	@Method(selector = "addScore:gameUserName:gScore:completionBlock:")
	public native void addScore(String gameName, String gameUserName, double gameScore, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Deducts the score from users account for a particular Game
	 *
	 * @param gameName
	 *            - Name of the game for which scores have to be deducted
	 * @param gameUserName
	 *            - The user for whom scores have to be deducted
	 * @param gameScore
	 *            - The scores that have to be deducted
	 *
	 * @return Game object containing the scores that has been deducted
	 *
	 */
	@Method(selector = "deductScore:gameUserName:gameScore:completionBlock:")
	public native void deductScore(String gameName, String gameUserName, double gameScore, @Block App42ResponseBlock completionBlock);
}
