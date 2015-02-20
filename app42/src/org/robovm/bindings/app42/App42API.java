package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.foundation.NSURLRequestCachePolicy;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;

@NativeClass
public class App42API extends NSObject
{
	@Method(selector = "getDefaultACL")
	public native static NSArray<?> getDefaultACL();
	
	@Method(selector = "setDefaultACL:")
	public native static void setDefaultACL(NSArray<?> defaultACL);
	
	@Method(selector = "getLoggedInUser")
	public native static String getLoggedInUser();
	
	@Method(selector = "setLoggedInUser:")
	public native static void setLoggedInUser(String loggedInUser);
	
	@Method(selector = "getUserSessionId")
	public native static String getUserSessionId();
	
	@Method(selector = "setUserSessionId:")
	public native static void setUserSessionId(String userSessionId);
	
	@Method(selector = "initializeWithAPIKey:andSecretKey:")
	public native static void initializeWithAPIKey(String apiKey, String secretKey);
	
	@Method(selector = "setFbAccesToken:")
	public native static void setFbAccesToken(String fbAccesToken);
	
	@Method(selector = "getFbAccesToken")
	public native static String getFbAccesToken();
	
	@Method(selector = "setInstallId:")
	public native static void setInstallId(String installId);
	
	@Method(selector = "getInstallId")
	public native static String getInstallId();

	@Method(selector = "removeSession")
	public native static void removeSession();

	@Method(selector = "enableAppStateEventTracking:")
	public native static void enableAppStateEventTracking(boolean isEnabled);
	
	@Method(selector = "enableEventService:")
	public native static void enableEventService(boolean isEnabled);

	@Method(selector = "setBaseUrl:")
	public native static void setBaseUrl(String baseUrl);

	@Method(selector = "setCacheStoragePolicy:")
	public native static void setCacheStoragePolicy(NSURLRequestCachePolicy cachePolicy);

	@Method(selector = "getCacheStoragePolicy")
	public native static NSURLRequestCachePolicy getCacheStoragePolicy();
	
	@Method(selector = "enableApp42Trace:")
	public native static void enableApp42Trace(boolean isEnabled);

	@Method(selector = "enableCrashEventHandler:")
	public native static void enableCrashEventHandler(boolean isEnabled);
	
	@Method(selector = "getDbName:")
	public native static String getDbName();
	
	@Method(selector = "setDbName:")
	public native static void setDbName(String dbName);
	
	@Method(selector = "getSecretKey")
	public native static String getSecretKey();
	
	@Method(selector = "setOfflineStorage:")
	public native static void setOfflineStorage(boolean offlineStorage);

	@Method(selector = "setOfflineStorage:withCacheSize:")
	public native static void setOfflineStorage(boolean offlineStorage, long cacheSize);
	
	@Method(selector = "getOfflineStorage")
	public native static boolean getOfflineStorage();

	/*!
	 *@return Returns the instance of User API
	 */
	@Method(selector = "buildUserService")
	public native static UserService buildUserService();

	/*!
	 *@return Returns the instance of EmailSender API
	 */
	@Method(selector = "buildEmailService")
	public native static EmailService buildEmailService();
	
	/*!
	 *@return Returns the instance of Storage API
	 */
	@Method(selector = "buildStorageService")
	public native static StorageService buildStorageService();
	
	/*!
	 *@return Returns the instance of Session API
	 */
	@Method(selector = "buildSessionService")
	public native static SessionService buildSessionService();
	
	/*!
	 *@return Returns the instance of Photo API
	 */
	@Method(selector = "buildPhotoService")
	public native static PhotoService buildPhotoService();
	
	/*!
	 *@return Returns the instance of User API
	 */
	@Method(selector = "buildQueueService")
	public native static QueueService buildQueueService();
	
	/*!
	 *@return Returns the instance of Recommender API
	 */
	@Method(selector = "buildRecommenderService")
	public native static RecommenderService buildRecommenderService();
	
	/*!
	 *@return Returns the instance of Upload API
	 */
	@Method(selector = "buildUploadService")
	public native static UploadService buildUploadService();
	
	/*!
	 *@return Returns the instance of Catalogue API
	 */
	@Method(selector = "buildCatalogueService")
	public native static CatalogueService buildCatalogueService();
	
	/*!
	 *@return Returns the instance of Cart API
	 */
	@Method(selector = "buildCartService")
	public native static CartService buildCartService();
	
	/*!
	 *@return Returns the instance of Album API
	 */
	@Method(selector = "buildAlbumService")
	public native static AlbumService buildAlbumService();
	
	/*!
	 *@return Returns the instance of Log API
	 */
	@Method(selector = "buildLogService")
	public native static LogService buildLogService();
	
	/*!
	 *@return Returns the instance of Review API
	 */
	@Method(selector = "buildReviewService")
	public native static ReviewService buildReviewService();
	
	/*!
	 *@return Returns the instance of Geo API
	 */
	@Method(selector = "buildGeoService")
	public native static GeoService buildGeoService();
	
	/*!
	 *@return Returns the instance of Game API
	 */
	@Method(selector = "buildGameService")
	public native static GameService buildGameService();
	
	/*!
	 *@return Returns the instance of Reward API
	 */
	@Method(selector = "buildRewardService")
	public native static RewardService buildRewardService();
	
	/*!
	 *@return Returns the instance of Score API
	 */
	@Method(selector = "buildScoreService")
	public native static ScoreService buildScoreService();
	
	/*!
	 *@return Returns the instance of ScoreBoard API
	 */
	@Method(selector = "buildScoreBoardService")
	public native static ScoreBoardService buildScoreBoardService();
	
	/*!
	 *@return Returns the instance of Image Processor API
	 */
	@Method(selector = "buildImageProcessorService")
	public native static ImageProcessorService buildImageProcessorService();
	
	/*!
	 *@return Returns the instance of Push API
	 */
	@Method(selector = "buildPushService")
	public native static PushNotificationService buildPushService();
	
	/*!
	 *@return Returns the instance of Social API
	 */
	@Method(selector = "buildSocialService")
	public native static SocialService buildSocialService();
	
	/*!
	 *@return Returns the instance of Buddy API
	 */
	@Method(selector = "buildBuddyService")
	public native static BuddyService buildBuddyService();

	/*!
	 *@return Returns the instance of ABTestService API
	 */
	@Method(selector = "buildABTestService")
	public native static ABTestService buildABTestService();
	
	/*!
	 *@return Returns the instance of AvatarService API
	 */
	@Method(selector = "buildAvatarService")
	public native static AvatarService buildAvatarService();

	/*!
	 *@return Returns the instance of CustomCode API
	 */
	@Method(selector = "buildCustomCodeService")
	public native static CustomCodeService buildCustomCodeService();
	
	/*!
	 *@return Returns the instance of AchievementService API
	 */
	@Method(selector = "buildAchievementService")
	public native static AchievementService buildAchievementService();

	/*!
	 *@return Returns the instance of GiftService API
	 */
	@Method(selector = "buildGiftService")
	public native static GiftService buildGiftService();
	
	/*!
	 *@return Returns the instance of TimerService API
	 */
	@Method(selector = "buildTimerService")
	public native static TimerService buildTimerService();

	/*!
	 *@return Returns the instance of EventService API
	 */
	@Method(selector = "buildEventService")
	public native static EventService buildEventService();
}
