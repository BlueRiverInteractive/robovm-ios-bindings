
package org.robovm.bindings.parse;

import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;

@NativeClass
public class Parse extends NSObject {
    /** Sets the applicationId and clientKey of your application.
     * @param applicationId The application id for your Parse application.
     * @param clientKey The client key for your Parse application. */
    @Method(selector = "setApplicationId:clientKey:")
    public static native void setApplicationId (String applicationId, String clientKey);

    @Method(selector = "getApplicationId")
    public static native String getApplicationId ();

    @Method(selector = "getClientKey")
    public static native String getClientKey ();

    /** Set whether to show offline messages when using a Parse view or view controller related classes.
     * @param enabled Whether a UIAlert should be shown when the device is offline and network access is required from a view or
     *            view controller. */
    @Method(selector = "offlineMessagesEnabled:")
    public static native void setOfflineMessagesEnabled (boolean enabled);

    /** Set whether to show an error message when using a Parse view or view controller related classes and a Parse error was
     * generated via a query.
     * @param enabled Whether a UIAlert should be shown when a Parse error occurs. */
    @Method(selector = "errorMessagesEnabled:")
    public static native void setErrorMessagesEnabled (boolean enabled);

}
