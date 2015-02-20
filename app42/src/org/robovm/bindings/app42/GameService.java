package org.robovm.bindings.app42;

import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class GameService extends App42Service
{
	public GameService(String apiKey, String secretKey) {
		super((SkipInit) null);
	    initObject(init(apiKey, secretKey));
	}
	
	@Method(selector = "initWithAPIKey:secretKey:")
	private native @Pointer long init(String apiKey, String secretKey);
	
	/**
	 * Creates a game on the cloud
	 *
	 * @param gameName
	 *            - Name of the game that has to be created
	 * @param gameDescription
	 *            - Description of the game to be created
	 *
	 * @return Game object containing the game which has been created
	 *
	 */
	@Method(selector = "createGame:gameDescription:completionBlock:")
	public native void createGame(String gameName, String gameDescription, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Fetches the count of all games for the App
	 *
	 * @return App42Response object containing count of all the Game for the App
	 * 
	 */
	@Method(selector = "getAllGamesCount:")
	public native void getAllGamesCount(@Block App42ResponseBlock completionBlock);
	
	/**
	 * Fetches all games for the App
	 *
	 * @return List of Game object containing all the games for the App
	 *
	 *
	 */
	@Method(selector = "getAllGames:")
	public native void getAllGames(@Block App42ResponseBlock completionBlock);
	
	/**
	 * Fetches all games for the App by paging.
	 *
	 * @param max
	 *            - Maximum number of records to be fetched
	 * @param offset
	 *            - From where the records are to be fetched
	 *
	 * @return List of Game object containing all the games for the App
	 *
	 */
	@Method(selector = "getAllGames:offset")
	public native void getAllGames(int max, int offset, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Retrieves the game by the specified name
	 *
	 * @param gameName
	 *            - Name of the game that has to be fetched
	 *
	 * @return Game object containing the game which has been created
	 *
	 */
	@Method(selector = "getGameByName")
	public native void getGameByName(String gameName, @Block App42ResponseBlock completionBlock);
}
