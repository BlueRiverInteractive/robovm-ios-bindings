//  Copyright (c) 2014 Iddiction, Inc. All rights reserved.

@interface Xplode : NSObject

@end

@interface Xplode (Core)

/// Initializes the Xplode SDK using the assigned app credentials and allows all subsequent SDK calls to be executed.
/// This method should be called on every app launch from within applicationDidFinishLaunching:withOptions: in your app delegate.
///
/// @note The classes IDDCore and IddictionSDK have been deprecated, please use Xplode as an entry point.
///
/// @deprecated Since version 2.4.1.
/// @param appHandle			The app handle assigned to the app on the Xplode portal.
/// @param appSecret			The app secret assigned to the app on the Xplode portal.
/// @param completionHandler	A block that is executed when the SDK is initialized.
+ (void)initializeWithAppHandle:(NSString *)appHandle
					  appSecret:(NSString *)appSecret
				   onCompletion:(void(^)(NSError *error))completionHandler __attribute__((deprecated(" Since Xplode SDK v2.4.1. Use initializeWithAppHandle:appSecret:andCompletionHandler: instead.")));

/// Initializes the Xplode SDK using the assigned app credentials and allows all subsequent SDK calls to be executed.
/// This method should be called on every app launch from within applicationDidFinishLaunching:withOptions: in your app delegate.
///
/// @note The classes IDDCore and IddictionSDK have been deprecated, please use Xplode as an entry point.
///
/// @param appHandle			The app handle assigned to the app on the Xplode portal.
/// @param appSecret			The app secret assigned to the app on the Xplode portal.
/// @param completionHandler	A block that is executed when the SDK is initialized.
+ (void)initializeWithAppHandle:(NSString *)appHandle
					  appSecret:(NSString *)appSecret
		   andCompletionHandler:(void(^)(NSError *error))completionHandler;

/// Initializes the Xplode SDK using the assigned app credentials and allows all subsequent SDK calls to be executed. Use this method if you want to use Xplode push notifications.
/// This method should be called on every app launch from within applicationDidFinishLaunching:withOptions: in your app delegate.
///
/// @note The classes IDDCore and IddictionSDK have been deprecated, please use Xplode as an entry point.
///
/// @param appHandle			The app handle assigned to the app on the Xplode portal.
/// @param appSecret			The app secret assigned to the app on the Xplode portal.
///	@param launchOptions		A dictionary with the launch options as received in the app delegate.
/// @param completionHandler	A block that is executed when the SDK is initialized.
+ (void)initializeWithAppHandle:(NSString *)appHandle
                      appSecret:(NSString *)appSecret
                  launchOptions:(NSDictionary *)launchOptions
           andCompletionHandler:(void(^)(NSError *error))completionHandler;

/// Returns the app handle that was provided to initializeWithAppHandle:appSecret:onCompletion:.
///
/// @return The app handle.
+ (NSString *)appHandle;

/// Returns the app secret that was provided to initializeWithAppHandle:appSecret:onCompletion:.
///
/// @return The app secret.
+ (NSString *)appSecret;

/// Returns *YES* if initializeWithAppHandle:appSecret:onCompletion: has been called and successfully registered with the server.
/// If this method returns *NO*, no other operations with the SDK will work.
///
/// @return *YES* if the SDK was successfully initialized, *NO* otherwise.
+ (BOOL)isInitialized;

/// The error that was generated during the SDK initialization proccess if it failed.
///
/// @return An error object or nil if there was no error on initalization.
+ (NSError *)initializationError;

@end

@compatibility_alias IDDCore Xplode;
@compatibility_alias IddictionSDK Xplode;
