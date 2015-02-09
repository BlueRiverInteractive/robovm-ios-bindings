package org.robovm.bindings.xplode;

import org.robovm.apple.foundation.NSData;
import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSError;
import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.uikit.UIBackgroundFetchResult;
import org.robovm.apple.uikit.UIInterfaceOrientationMask;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.ValuedEnum;

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

    /// Returns the app handle that was provided to initializeWithAppHandle:appSecret:onCompletion:.
    ///
    /// @return The app handle.
    //+ (NSString*)appHandle;
    @Method(selector = "appHandle")
    public static native String appHandle();

    /// Returns the app secret that was provided to initializeWithAppHandle:appSecret:onCompletion:.
    ///
    /// @return The app secret.
    //+ (NSString*)appSecret;
    @Method(selector = "appSecret")
    public static native String appSecret();

    /// Returns *YES* if initializeWithAppHandle:appSecret:onCompletion: has been called and successfully registered with the server.
    /// If this method returns *NO*, no other operations with the SDK will work.
    ///
    /// @return *YES* if the SDK was successfully initialized, *NO* otherwise.
    //+ (BOOL)isInitialized;
    @Method(selector = "isInitialized")
    public static native boolean isInitialized();

    /// The error that was generated during the SDK initialization proccess if it failed.
    ///
    /// @return An error object or nil if there was no error on initalization.
    //+ (NSError *)initializationError;
    @Method(selector = "initializationError")
    public static native NSError initializationError();

    /// Checks whether promotions are supported on the current device.
    ///
    /// @return *YES* if the device is supported, *NO* otherwise.
    //+ (BOOL)isCurrentDeviceSupported;
    @Method(selector = "isCurrentDeviceSupported")
    public static native boolean isCurrentDeviceSupported();

    /// Presents a view controller with the promotion for the specified breakpoint.
    /// When a promotion has been set up using setupPromotionDockForBreakpoint:atPosition:, this method only presents the loaded promotion.
    ///
    /// @param breakpoint			Name of the breakpoint.
    ///	@param completionHandler	A completion block that is executed when the promotion finishes loading.
    ///	@param dismissalHandler		A completion block that is executed when the promotion is closed.
    //+ (void)presentPromotionForBreakpoint:(NSString*)breakpoint
    //withCompletionHandler:(void(^)(BOOL isReadyToPresent, NSError *error))completionHandler
    //andDismissHandler:(void(^)(void))dismissHandler;
    @Method(selector = "presentPromotionForBreakpoint:withCompletionHandler:andDismissHandler:")
    public static native void presentPromotionForBreakpoint(String breakpoint, @Block PromotionBreakpointCompletionHandler completionHandler, @Block PromotionBreakpointDismissHandler dismissHandler);

    /// Checks if the promotion for the specified breakpoint is cached.
    ///
    /// @param breakpoint	Name of the breakpoint.
    ///
    /// @return *YES* if a promotion is cached for the specified breakpoint, *NO* otherwise.
    //+ (BOOL)isPromotionCachedForBreakpoint:(NSString*)breakpoint;
    @Method(selector = "isPromotionCachedForBreakpoint")
    public static native boolean isPromotionCachedForBreakpoint(String breakpoint);

    /// Returns a value whether any promotion is currently presented in full-screen.
    ///
    /// The state changes when the presentPromotionForBreakpoint:withCompletionHandler:andDismissalHandler:, dismissPromotion, removePromotionDock showPromotionDockAndBounce: and hidePromotionDock methods are called.
    ///
    /// @return *YES* if open, *NO* if closed.
    //+ (BOOL)isPromotionOpen;
    @Method(selector = "isPromotionOpen")
    public static native boolean isPromotionOpen();

    /// Returns the visibility of a dockable promotion. The promotion is visible if the dock is visible or if it is presented full-screen.
    /// The state changes when the showPromotionDockAndBounce: and hidePromotionDock methods are called.
    ///
    /// @note This method always returns *NO* when only a modal promotion is presented.
    ///
    /// @return *YES* if visible, *NO* if hidden.
    //+ (BOOL)isPromotionDockVisible;
    @Method(selector = "isPromotionDockVisible")
    public static native boolean isPromotionDockVisible();

    /// Initializes a dockable always-on-screen promotion for a specific breakpoint and optionally shows it at a specific position.
    ///
    /// @param breakpoint      Name of the breakpoint.
    /// @param position Dock the promotion on bottom (default), or at top.
    ///	@param completionHandler	A completion block that is executed when the promotion finishes loading.
    //+ (void)setupPromotionDockForBreakpoint:(NSString*)breakpoint
    //atPosition:(XPLPromotionDockingPosition)position
    //withCompletionHandler:(void(^)(BOOL isReadyToPresent, NSError *error))completionHandler;
    @Method(selector = "setupPromotionDockForBreakpoint:atPosition:withCompletionHandler:")
    public static native void setupPromotionDock(String breakpoint, XPLPromotionDockingPosition position, @Block PromotionDockForBreakpointCompletionHandler completionHandler);


    // Initializes a dockable always-on-screen promotion for a specific breakpoint and dimensions, optionally shown at a specific position.
    ///
    /// Currently supported dimensions are (SW - Screen Width):
    ///
    /// | Orientation | Xplode    | iAd       | IAB       |
    /// |-------------|:---------:|:---------:|:---------:|
    /// | Portrait    | SW x 35pt | SW x 32pt | SW x 50pt |
    /// | Landscape   | SW x 35pt | SW x 32pt | SW x 50pt |
    ///
    /// @see XPLPromotionDockingPosition
    /// @see XPLPromotionDockDimensions
    ///
    /// @param breakpoint      Name of the breakpoint.
    /// @param position        Dock the promotion on bottom (default), or at top.
    /// @param dimensions      Dimension standard as defined in XPLPromotionDockDimensions.
    ///	@param completionHandler	A completion block that is executed when the promotion finishes loading.
    //+ (void)setupPromotionDockForBreakpoint:(NSString*)breakpoint
    //atPosition:(XPLPromotionDockingPosition)position
    //withDimensions:(XPLPromotionDockDimensions)dimensions
    //andCompletionHandler:(void(^)(BOOL isReadyToPresent, NSError *error))completionHandler;
    @Method(selector = "setupPromotionDockForBreakpoint:atPosition:withDimensions:andCompletionHandler:")
    public static native void setupPromotionDock(String breakpoint, XPLPromotionDockingPosition position, XPLPromotionDockDimensions dimensions, @Block PromotionDockForBreakpointCompletionHandler completionHandler);

    /// Shows the promotion dock if a promotion has been set up as dockable.
    /// If you call this method with bounce *YES* while the dock is already visible then only the bounce animation is performed.
    ///
    /// @note The promotion dock can only be shown after the promotion has been set up using setupPromotionDockForBreakpoint:atPosition:.
    ///
    /// @param bounce *YES* for bouncing animation, *NO* for sliding animation.
    //+ (void)showPromotionDockAndBounce:(BOOL)bounce;
    @Method(selector = "showPromotionDockAndBounce:")
    public static native void setupPromotionDock(boolean bounce);

    /// Hides the promotion dock if a promotion has been set up as dockable.
    ///
    /// @note The promotion dock can only be hidden after the promotion has been set up using setupPromotionDockForBreakpoint:atPosition: or shown using showPromotionDockAndBounce:.
    //+ (void)hidePromotionDock;
    @Method(selector = "hidePromotionDock:")
    public static native void hidePromotionDock();

    /// Dismisses the promotion dock and removes it from memory.
    //+ (void)removePromotionDock;
    @Method(selector = "removePromotionDock:")
    public static native void removePromotionDock();

    /// Dismisses any presented modal promotion and removes it from memory.
    //+ (void)dismissPromotion;
    @Method(selector = "dismissPromotion:")
    public static native void dismissPromotion();

    /// Returns the allowed interface orientations for promotions.
    ///
    /// @return A bit mask with the allowed orientations.
    //+ (UIInterfaceOrientationMask)allowedOrientations;
    @Method(selector = "allowedOrientations:")
    public static native UIInterfaceOrientationMask allowedOrientations();

    /// Optional. Sets the allowed interface orientations for promotions.
    ///
    /// If you want to disable certain orientations for different view controllers, call this method before presenting any promotions.
    ///
    /// @note This method is optional.
    /// @param allowedOrientations Allowed promotion orientations. For possible values, see Apple's UIApplication documentation about UIInterfaceOrientationMask.
    //+ (void)setAllowedOrientations:(UIInterfaceOrientationMask)allowedOrientations;
    @Method(selector = "setAllowedOrientations:")
    public static native void setAllowedOrientations(UIInterfaceOrientationMask allowedOrientations);

    /// Logs an event.
    ///
    /// @param eventName Name of the event.
    //+ (void)logEvent:(NSString*)eventName;
    @Method(selector = "logEvent:")
    public static native void logEvent(String eventName);

    /// Logs an event with custom parameters.
    ///
    /// @param eventName  Name of the event.
    /// @param parameters A key-value dictionary with parameters.
    //+ (void)logEvent:(NSString*)eventName
    //withParameters:(NSDictionary *)parameters;
    @Method(selector = "logEvent:withParameters:")
    public static native void logEvent(String eventName, NSDictionary parameters);

    /// Registers the unparsed push token received from Apple with Xplode.
    ///
    /// @param deviceToken			The unparsed device token that is returned by the UIApplication push registration delegate method as NSData.
    /// @param completionHandler	The completion handler.
    //+ (void)registerDeviceTokenWithData:(NSData*)deviceToken
    //withCompletionHandler:(void(^)(NSError *error))completionHandler;
//    @Method(selector = "registerDeviceTokenWithData:withCompletionHandler:")
//    public static native void registerDeviceToken(NSData deviceToken, RegisterDeviceTokenCompletionHandler parameters);

    /// Registers the parsed push token received from Apple with Xplode.
    ///
    /// @param deviceToken			The parsed device token string that is returned by the UIApplication push registration delegate method.
    /// @param completionHandler	The completion handler.
    //+ (void)registerDeviceTokenWithString:(NSString*)deviceToken
    //withCompletionHandler:(void(^)(NSError *error))completionHandler;
//    @Method(selector = "registerDeviceTokenWithString:withCompletionHandler:")
//    public static native void registerDeviceToken(String deviceToken, RegisterDeviceTokenCompletionHandler parameters);

    /// Handles the received push payload content.
    ///
    /// @param userInfo				The received push payload that is returned by application:didReceiveRemoteNotification: as an NSDictionary.
    //+ (void)handlePushNotificationPayload:(NSDictionary *)userInfo
    //withFetchCompletionHandler:(void(^)(UIBackgroundFetchResult result))completionHandler;
//    @Method(selector = "handlePushNotificationPayload:withFetchCompletionHandler:")
//    public static native void handlePushNotificationPayload(NSDictionary userInfo, PushNotificationPayloadFetchCompletionHandler parameters);

    public enum XPLPromotionDockingPosition implements ValuedEnum {
        Bottom(0),
        Top(1);

        private final long n;

        private XPLPromotionDockingPosition(long n) {
            this.n = n;
        }

        @Override
        public long value() {
            return n;
        }
    }

    public enum XPLPromotionDockDimensions implements ValuedEnum {
        Default(0),
        IAd(1),
        IAB(2);

        private final long n;

        private XPLPromotionDockDimensions(long n) {
            this.n = n;
        }

        @Override
        public long value() {
            return n;
        }
    }

    public interface InitializeHandler {
        void invoke(NSError error);
    }

    public interface RegisterDeviceTokenCompletionHandler {
        void invoke(NSError error);
    }

    public interface PushNotificationPayloadFetchCompletionHandler {
        void invoke(UIBackgroundFetchResult result);
    }

    public interface PromotionDockForBreakpointCompletionHandler {
        void invoke(boolean isReadyToPresent, NSError error);
    }

    public interface PromotionBreakpointCompletionHandler {
        void invoke(boolean isReadyToPresent, NSError error);
    }

    public interface PromotionBreakpointDismissHandler {
        void invoke();
    }

}
