/*
 
 BugSenseController.h
 BugSense-iOS
 
 Copyright (c) 2012 BugSense Inc.
 
 Permission is hereby granted, free of charge, to any person
 obtaining a copy of this software and associated documentation
 files (the "Software"), to deal in the Software without
 restriction, including without limitation the rights to use,
 copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the
 Software is furnished to do so, subject to the following
 conditions:
 
 The above copyright notice and this permission notice shall be
 included in all copies or substantial portions of the Software.
 
 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 OTHER DEALINGS IN THE SOFTWARE.
 
 Author: Nick Toumpelis, nick@bugsense.com
 Author: John Lianeris, jl@bugsense.com 
 
 */

/**
 The [BugSenseController](BugSenseController) class provides a centralized point of access to BugSense's
 reporting facilities.
 
 Every application can have exactly one instance of BugSenseController. This instance should be created at the
 start of the application's lifecycle; typically application:didFinishLaunchingWithOptions:.
 This instance can only be created using one of the parameter-taking sharedControllerWith... constructors. Thereafter, you
 can access this instance using the sharedController method.
 
 The main role of the controller is to send crash reports to the BugSense service. These are sent either immediately
 after the crash, or on relaunch. Typically, crashes are reported with partially symbolicated stack traces, that contain
 the function/method names and program counter offsets. Fully symbolicated stack traces would included the file and
 line for each call in the stack, but obviously this is impossible to take place on the device. Typically, information
 of this kind is recorded in the dSYM bundle (DWARF) during the archiving process (Xcode). If the dSYM is uploaded in the 
 user's dashboard, and the plugin is configured to not symbolicate stack traces on the device, it will be fully 
 symbolicated on the server (depending on the user's subscription plan).
 
 The controller also provides a facility for informing users of updates for the crashing apps. This can be enabled by
 the developer, through the [BugSense Dashboard](http://bugsense.com/). The controller also provides a facility for
 logging exceptions with tags.
 
 Priority is given to the proper execution/crashing of the app, hence, no guarantee is given that all crashes will be
 reported accurately and at all times. Experience has shown that, meddling with the crashing process may result to all
 kinds of errors and data corruption. We avoid this by not meddling too much with the app itself.
 
 Immediate dispatch for apps that are live on the App Store is discouraged; immediate dispatch is not 100% safe. This is
 because it takes place inside the signal handler and it's not async-safe. Immediate dispatch is recommended for beta
 testing only.
 */

#define BUGSENSE_LOG(__EXCEPTION, __EXTRADATA) [BugSenseController logException:__EXCEPTION withExtraData:__EXTRADATA];

OBJC_EXPORT @interface BugSenseController : NSObject <UIAlertViewDelegate>

/** @name Creating a shared controller instance */

/**
 Creates and returns a singleton crash controller instance with the given API key. If a singleton has already been
 created, this method has no effect.
 
 @param APIKey The BugSense API key
 
 @return A new singleton crash controller with the given API key, or an existing controller with no changes to it (has
 the API key of its original call).
 */
+ (BugSenseController *) sharedControllerWithBugSenseAPIKey:(NSString *)APIKey;

/**
 Creates and returns a singleton crash controller instance with the given API key and user dictionary. If a singleton
 has already been created, this method has no effect.
 
 @param APIKey The BugSense API key
 
 @param userDictionary A dictionary containing custom, user-defined data.
 
 @return A new singleton crash controller with the given values, or an existing controller with no changes to it (has
 the values of its original call).
 */
+ (BugSenseController *) sharedControllerWithBugSenseAPIKey:(NSString *)APIKey
                                             userDictionary:(NSDictionary *)userDictionary;

/**
 Creates and returns a singleton crash controller instance with the given API key, user dictionary and option whether to
 send crash reports immediately or not. If a singleton has already been created, this method has no effect.
 
 @warning This is the designated initializer.
 
 @param APIKey The BugSense API key
 
 @param userDictionary A dictionary containing custom, user-defined data.
 
 @param immediately A value indicating whether the reports should be sent immediately to the service (if YES) or
 on relaunch (if NO).
 
 @return A new singleton crash controller with the given values, or an existing controller with no changes to it (has
 the values of its original call).
 */
+ (BugSenseController *) sharedControllerWithBugSenseAPIKey:(NSString *)APIKey
                                             userDictionary:(NSDictionary *)userDictionary
                                            sendImmediately:(BOOL)immediately;

/** @name Getting the shared controller instance */

/**
 Returns the singleton crash controller instance.
 
 @warning This method cannot be used to create a new instance. It can only be used to refer to an existing singleton
 crash controller instance, in conjunction with any of the instance methods specified for this class.
 
 @return The existing singleton crash controller instance or nil, if none was found.
 */
+ (BugSenseController *) sharedController;

/** @name Advanced Options */

/**
 Configures the plugin to use an alternate url endpoint, mainly for users in China and other countries where the IPs that BugSense normally uses are blocked.
 
 @param flag A boolean specifying if the alternate url endpoint should be enabled or not.
 */
+ (void) setUsesProxy:(BOOL)flag;

/**
 Configures the log messages line count to be sent along with crashes.
 
 @param count An unsigned long specifying the maximum lines that should be saved.
 
 */
+ (void) setLogMessagesCount:(unsigned long)count;

/**
 Configures the log messages logging level to be sent along with crashes.
 
 @param level An unsigned long specifying the level of the log messages that are saved.
 
 */
+ (void) setLogMessagesLevel:(unsigned long)level;
 
/**
 Forces the plugin to show a predefined fix notification to the user.
 
 @param title The title of the fix notification to be shown.
 
 @param message The message of the fix notification to be shown.
 
 */
+ (void) setFixNotificationsTitle:(NSString *)title message:(NSString *)message;

/**
 Sets a string for identifying the user.
 
 @param identifier the string identifying the user.
 */
+ (void)setUserIdentifier:(NSString *)identifier;

/** @name Logging exceptions */

/**
 Logs a given exception to the service asynchronously, reports its stacktrace and adds extra data as defined by the developer.
 
 @param exception The exception to log.
 
 @param extraData A dictionary containing extra data to be sent along with the exception.
 
 @return A boolean indicating whether the method completed successfully. This doesn't necessarily mean that the
 exception was logged successfully on the server, only that exception data was generated appropriately and that an
 attempt to send them was made.
 */
+ (BOOL) logException:(NSException *)exception withExtraData:(NSDictionary *)extraData;

/** @name Breadcrumbs */

/**
 Appends a new breadcrumb to the current breadcrumb trail, allowing you to keep track of the user's path in the application. These are transmitted along with crash reports.
 
 @param breadcrumb A string describing the user's location.
 
 @return A boolean indicating whether the breadcrumb was successfully saved on the device.
 
*/

+ (BOOL) leaveBreadcrumb:(NSString *)breadcrumb;

/** @name Quality Metrics */

/** 
 Sends an event, usually after the user has done an action in the application.
 
 @param tag A tag describing the event. Maximum length is 256 characters.
 
 @return A boolean indicating whether the event was generated successfully. It doesn't necessarily mean that it was sent and received successfully by the server.
 
 */

+ (BOOL) sendCustomEventWithTag:(NSString *)tag;

+ (NSString *)apiKey;
+ (NSString *)endpointURL;
+ (NSString *)userIdentifier;

+ (BOOL) usesProxy;

/** @name Crash on Last Run functions */

/**
 Returns the id of the last crash that was sent to the BugSense servers.
 
 @return A long integer identifying the crash.
  
 */
+ (long)lastCrashId;

/**
 Returns the number of crashes that the user has experienced since the last reset.
 
 @return The number of crashes.
 
 */
+ (int)crashCount;

/**
 Resets the number of crashes that the user has experienced to zero.
  
 @return A boolean indicating whether the number of crashes was successfully reset to zero.
 
 */
+ (BOOL)resetCrashCount;

typedef void (^ OperationsCompletionBlock)();
+ (void)setErrorNetworkOperationsCompletionBlock:(OperationsCompletionBlock)block;

@end
