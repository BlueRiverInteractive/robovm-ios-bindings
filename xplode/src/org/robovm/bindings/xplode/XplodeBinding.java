package org.robovm.bindings.xplode;

import org.robovm.apple.foundation.NSError;
import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;

/**
 * Created by sargis on 11/17/14.
 */

@NativeClass
public class XplodeBinding extends NSObject {

    /**
     * Initializes the Xplode SDK using the assigned app credentials and allows all subsequent SDK calls to be executed.
     * This method should be called on every app launch from within applicationDidFinishLaunching in your app delegate.
     *
     * @param appHandle         The app handle assigned to the app on the Xplode portal.
     * @param appSecret         The app secret assigned to the app on the Xplode portal.
     * @param initializeHandler A block that is executed when the SDK is initialized.
     */
    @Method(selector = "initializeWithAppHandle:appSecret:andCompletionHandler:")
    public static native void initialize(String appHandle, String appSecret, @Block InitializeHandler initializeHandler);

    /**
     * Presents a view controller with the promotion for the specified breakpoint.
     * When a promotion has been set up using setupPromotionDockForBreakpoint:atPosition:, this method only presents the loaded promotion.
     *
     * @param breakpoint        Name of the breakpoint.
     * @param completionHandler A completion block that is executed when the promotion finishes loading.
     * @param dismissHandler    A completion block that is executed when the promotion is closed.
     */


    @Method(selector = "presentPromotionForBreakpoint:withCompletionHandler:andDismissHandler:")
    public static native void presentPromotionForBreakpoint(String breakpoint, @Block CompletionHandler completionHandler, @Block DismissHandler dismissHandler);

    public interface InitializeHandler {
        void invoke(NSError error);
    }

    public interface CompletionHandler {
        void invoke(boolean isReadyToPresent, NSError error);
    }

    public interface DismissHandler {
        void invoke();
    }


}
