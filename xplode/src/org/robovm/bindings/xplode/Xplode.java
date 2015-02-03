package org.robovm.bindings.xplode;

import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSError;
import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;

/**
 * Created by sargis on 2/3/15.
 */
@NativeClass
public class Xplode extends NSObject {

    /// Initializes the Xplode SDK using the assigned app credentials and allows all subsequent SDK calls to be executed.
    /// This method should be called on every app launch from within applicationDidFinishLaunching:withOptions: in your app delegate.
    ///
    /// @note The classes IDDCore and IddictionSDK have been deprecated, please use Xplode as an entry point.
    ///
    /// @param appHandle			The app handle assigned to the app on the Xplode portal.
    /// @param appSecret			The app secret assigned to the app on the Xplode portal.
    /// @param completionHandler	A block that is executed when the SDK is initialized.

    //+ (void)initializeWithAppHandle:(NSString*)appHandle
    //appSecret:(NSString *)appSecret
    //andCompletionHandler:(void(^)(NSError*error))completionHandler;
    @Method(selector = "initializeWithAppHandle:appSecret:andCompletionHandler:")
    public static native void initialize(String appHandle, String appSecret, @Block InitializeHandler initializeHandler);


    /// Initializes the Xplode SDK using the assigned app credentials and allows all subsequent SDK calls to be executed. Use this method if you want to use Xplode push notifications.
    /// This method should be called on every app launch from within applicationDidFinishLaunching:withOptions: in your app delegate.
    ///
    /// @note The classes IDDCore and IddictionSDK have been deprecated, please use Xplode as an entry point.
    ///
    /// @param appHandle			The app handle assigned to the app on the Xplode portal.
    /// @param appSecret			The app secret assigned to the app on the Xplode portal.
    ///	@param launchOptions		A dictionary with the launch options as received in the app delegate.
    /// @param completionHandler	A block that is executed when the SDK is initialized.

    //+ (void)initializeWithAppHandle:(NSString*)appHandle
    //appSecret:(NSString *)appSecret
    //launchOptions:(NSDictionary*)launchOptions
    //andCompletionHandler:(void(^)(NSError *error))completionHandler;

    @Method(selector = "initializeWithAppHandle:appSecret:launchOptions:andCompletionHandler:")
    public static native void initialize(String appHandle, String appSecret, NSDictionary launchOptions, @Block InitializeHandler initializeHandler);

    public interface InitializeHandler {
        void invoke(NSError error);
    }

}
