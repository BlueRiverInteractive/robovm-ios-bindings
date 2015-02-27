
package org.robovm.bindings.testfairy;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.uikit.UIView;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;

@NativeClass
public class TestFairy extends NSObject {
    /** Initialize a TestFairy session.
     *
     * @param apiKey */
    @Method(selector = "begin:")
    public static native void begin (String apiKey);

    /** Hides a specific view from appearing in the video generated.
     *
     * @param view */
    @Method(selector = "hideView:")
    public static native void hideView (UIView view);

    /** Pushes the feedback view controller. Hook a button to this method to allow users to provide feedback about the current
     * session. All feedback will appear in your build report page, and in the recorded session page. */
    @Method
    public static native void pushFeedbackController ();

    /** Proxy didUpdateLocation delegate values and these locations will appear in the recorded sessions. Useful for debugging
     * actual long/lat values against what the user sees on screen.
     *
     * @param locations */
    @Method(selector = "updateLocation:")
    public static native void updateLocation (NSArray<?> locations);

    /** Marks a checkpoint in session. Use this text to tag a session with a checkpoint name. Later you can filter sessions where
     * your user passed through this checkpoint, for bettering understanding user experience and behavior.
     *
     * @param name */
    @Method(selector = "checkpoint:")
    public static native void checkpoint (String name);

    /** Sets a correlation identifier for this session. This value can be looked up via web dashboard. For example, setting
     * correlation to the value of the user-id after they logged in. Can be called only once per session (subsequent calls will be
     * ignored.)
     *
     * @param correlationId */
    @Method(selector = "setCorrelationId:")
    public static native void setCorrelationId (String correlationId);

    /** Pauses the current session. This method stops recoding of the current session until resume has been called.
     *
     * @see resume */
    @Method
    public static native void pause ();

    /** Resumes the recording of the current session. This method resumes a session after it was paused.
     *
     * @see pause */
    @Method
    public static native void resume ();

    /** Returns the address of the recorded session on testfairy's developer portal. Will return nil if recording not yet started.
     *
     * @return session URL */
    @Method(selector = "sessionUrl")
    public static native String getSessionUrl ();
}
