//
//  xplode.h
//  xplode
//
//  Created by Sargis Sargsyan on 11/18/14.
//  Copyright (c) 2014 Sargis Sargsyan. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface XplodeBinding : NSObject

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

/// Presents a view controller with the promotion for the specified breakpoint.
/// When a promotion has been set up using setupPromotionDockForBreakpoint:atPosition:, this method only presents the loaded promotion.
///
/// @param breakpoint			Name of the breakpoint.
///	@param completionHandler	A completion block that is executed when the promotion finishes loading.
///	@param dismissalHandler		A completion block that is executed when the promotion is closed.
+ (void)presentPromotionForBreakpoint:(NSString *)breakpoint
                withCompletionHandler:(void(^)(BOOL isReadyToPresent, NSError *error))completionHandler
                    andDismissHandler:(void(^)(void))dismissHandler;
@end
