package org.robovm.bindings.mixpanel;

import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;
import org.robovm.rt.bro.annotation.Pointer;

/**
 * Created by sargis on 1/25/15.
 */
@NativeClass
public class Mixpanel extends NSObject {
    @Method(selector = "sharedInstanceWithToken:")
    public static native Mixpanel getSharedInstance(String apiToken);

    @Method(selector = "sharedInstanceWithToken:launchOptions:")
    public static native Mixpanel getSharedInstance(String apiToken, NSDictionary launchOptions);

    /*!
    @method

    @abstract
    Returns the previously instantiated singleton instance of the API.

    @discussion
    The API must be initialized with <code>sharedInstanceWithToken:</code> before
    calling this class method.
    */
    @Method(selector = "sharedInstance")
    public static native Mixpanel sharedInstance();

    /*!
     @property

     @abstract
     Accessor to the Mixpanel People API object.

     @discussion
     See the documentation for MixpanelDelegate below for more information.
     */
    //@property (atomic, readonly, strong) MixpanelPeople *people;
    @Property(selector = "people")
    public native MixpanelPeople getPeople();


    /*!
     @property

     @abstract
     The distinct ID of the current user.

     @discussion
     A distinct ID is a string that uniquely identifies one of your users.
     Typically, this is the user ID from your database. By default, we'll use a
     hash of the MAC address of the device. To change the current distinct ID,
     use the <code>identify:</code> method.
     */
    @Property(selector = "distinctId")
    public native String getDistinctId();


    /*!
    @property

    @abstract
    Current user's name in Mixpanel Streams.
    */
    @Property(selector = "nameTag")
    public native String getNameTag();

    @Property(selector = "setNameTag:")
    public native void setNameTag(String nameTag);

    /*!
     @property

     @abstract
     The base URL used for Mixpanel API requests.

     @discussion
     Useful if you need to proxy Mixpanel requests. Defaults to
     https://api.mixpanel.com.
     */
    @Property(selector = "serverURL")
    public native String getServerURL();

    @Property(selector = "setServerURL:")
    public native void setServerURL(String serverURL);

     /*!
     @property

     @abstract
     Flush timer's interval.

     @discussion
     Setting a flush interval of 0 will turn off the flush timer.
     */

    @Property(selector = "flushInterval")
    public native int getFlushInterval();

    @Property(selector = "setFlushInterval:")
    public native void setFlushInterval(int interval);


    /*!
     @property

     @abstract
     Control whether the library should flush data to Mixpanel when the app
     enters the background.

     @discussion
     Defaults to YES. Only affects apps targeted at iOS 4.0, when background
     task support was introduced, and later.
     */
    @Property(selector = "flushOnBackground")
    public native boolean getFlushOnBackground();

    @Property(selector = "setFlushOnBackground:")
    public native void setFlushOnBackground(boolean flushOnBackground);

    /*!
     @property

     @abstract
     Controls whether to show spinning network activity indicator when flushing
     data to the Mixpanel servers.

     @discussion
     Defaults to YES.
     */
    @Property(selector = "showNetworkActivityIndicator")
    public native boolean getShowNetworkActivityIndicator();

    @Property(selector = "setShowNetworkActivityIndicator:")
    public native void setShowNetworkActivityIndicator(boolean showNetworkActivityIndicator);


    /*!
     @property

     @abstract
     Controls whether to automatically check for surveys for the
     currently identified user when the application becomes active.

     @discussion
     Defaults to YES. Will fire a network request on
     <code>applicationDidBecomeActive</code> to retrieve a list of valid suerveys
     for the currently identified user.
     */
    @Property(selector = "checkForSurveysOnActive")
    public native boolean getCheckForSurveysOnActive();

    @Property(selector = "setCheckForSurveysOnActive:")
    public native void setCheckForSurveysOnActive(boolean checkForSurveysOnActive);


    /*!
     @property

     @abstract
     Controls whether to automatically show a survey for the
     currently identified user when the application becomes active.

     @discussion
     Defaults to YES. This will only show a survey if
     <code>checkForSurveysOnActive</code> is also set to YES, and the
     survey check retrieves at least 1 valid survey for the currently
     identified user.
     */

    @Property(selector = "showSurveyOnActive")
    public native boolean getShowSurveyOnActive();

    @Property(selector = "setShowSurveyOnActive:")
    public native void setShowSurveyOnActive(boolean showSurveyOnActive);

    /*!
     @property

     @abstract
     Controls whether to automatically check for notifications for the
     currently identified user when the application becomes active.

     @discussion
     Defaults to YES. Will fire a network request on
     <code>applicationDidBecomeActive</code> to retrieve a list of valid notifications
     for the currently identified user.
     */
    @Property(selector = "checkForNotificationsOnActive")
    public native boolean getCheckForNotificationsOnActive();

    @Property(selector = "setCheckForNotificationsOnActive:")
    public native void setCheckForNotificationsOnActive(boolean checkForNotificationsOnActive);


    /*!
     @property

     @abstract
     Controls whether to automatically check for A/B test variants for the
     currently identified user when the application becomes active.

     @discussion
     Defaults to YES. Will fire a network request on
     <code>applicationDidBecomeActive</code> to retrieve a list of valid variants
     for the currently identified user.
     */
    @Property(selector = "checkForVariantsOnActive")
    public native boolean getCheckForVariantsOnActive();

    @Property(selector = "setCheckForVariantsOnActive:")
    public native void setCheckForVariantsOnActive(boolean checkForVariantsOnActive);


    /*!
     @property

     @abstract
     Controls whether to automatically check for and show in-app notifications
     for the currently identified user when the application becomes active.

     @discussion
     Defaults to YES.
     */
    @Property(selector = "showNotificationOnActive")
    public native boolean getShowNotificationOnActive();

    @Property(selector = "setShowNotificationOnActive:")
    public native void setShowNotificationOnActive(boolean showNotificationOnActive);

    /*!
     @property

     @abstract
     Determines the time, in seconds, that a mini notification will remain on
     the screen before automatically hiding itself.

     @discussion
     Defaults to 6.0.
     */
    @Property(selector = "miniNotificationPresentationTime")
    public native float getMiniNotificationPresentationTime();

    @Property(selector = "setMiniNotificationPresentationTime:")
    public native void setMiniNotificationPresentationTime(float miniNotificationPresentationTime);

    /*!
     @method

     @abstract
     Initializes an instance of the API with the given project token.

     @discussion
     Returns the a new API object. This allows you to create more than one instance
     of the API object, which is convenient if you'd like to send data to more than
     one Mixpanel project from a single app. If you only need to send data to one
     project, consider using <code>sharedInstanceWithToken:</code>.

     @param apiToken        your project token
     @param launchOptions   optional app delegate launchOptions
     @param flushInterval   interval to run background flushing
    */
    @Method(selector = "initWithToken:launchOptions:andFlushInterval:")
    public native Mixpanel initWithToken(String apiToken, NSDictionary launchOptions, int flushInterval);


    /*!
     @method

     @abstract
     Initializes an instance of the API with the given project token.

     @discussion
     Supports for the old initWithToken method format but really just passes
     launchOptions to the above method as nil.

     @param apiToken        your project token
     @param flushInterval   interval to run background flushing
     */
    @Method(selector = "initWithToken:andFlushInterval:")
    public native Mixpanel initWithToken(String apiToken, int flushInterval);


    /*!
     @property

     @abstract
     Sets the distinct ID of the current user.

     @discussion
     As of version 2.3.1, Mixpanel will choose a default distinct ID based on
     whether you are using the AdSupport.framework or not.

     If you are not using the AdSupport Framework (iAds), then we use the
     <code>[UIDevice currentDevice].identifierForVendor</code> (IFV) string as the
     default distinct ID.  This ID will identify a user across all apps by the same
     vendor, but cannot be used to link the same user across apps from different
     vendors.

     If you are showing iAds in your application, you are allowed use the iOS ID
     for Advertising (IFA) to identify users. If you have this framework in your
     app, Mixpanel will use the IFA as the default distinct ID. If you have
     AdSupport installed but still don't want to use the IFA, you can define the
     <code>MIXPANEL_NO_IFA</code> preprocessor flag in your build settings, and
     Mixpanel will use the IFV as the default distinct ID.

     If we are unable to get an IFA or IFV, we will fall back to generating a
     random persistent UUID.

     For tracking events, you do not need to call <code>identify:</code> if you
     want to use the default.  However, <b>Mixpanel People always requires an
     explicit call to <code>identify:</code></b>. If calls are made to
     <code>set:</code>, <code>increment</code> or other <code>MixpanelPeople</code>
     methods prior to calling <code>identify:</code>, then they are queued up and
     flushed once <code>identify:</code> is called.

     If you'd like to use the default distinct ID for Mixpanel People as well
     (recommended), call <code>identify:</code> using the current distinct ID:
     <code>[mixpanel identify:mixpanel.distinctId]</code>.

     @param distinctId string that uniquely identifies the current user
     */
    @Method(selector = "identify:")
    public native void identify(String distinctId);

    /*!
     @method

     @abstract
     Tracks an event.

     @param event           event name
     */
    @Method(selector = "track:")
    public native void track(String event);

    /*!
     @method

     @abstract
     Tracks an event with properties.

     @discussion
     Properties will allow you to segment your events in your Mixpanel reports.
     Property keys must be <code>NSString</code> objects and values must be
     <code>NSString</code>, <code>NSNumber</code>, <code>NSNull</code>,
     <code>NSArray</code>, <code>NSDictionary</code>, <code>NSDate</code> or
     <code>NSURL</code> objects. If the event is being timed, the timer will
     stop and be added as a property.

     @param event           event name
     @param properties      properties dictionary
     */
    @Method(selector = "track:properties:")
    public native void track(String event, NSDictionary properties);

    /*!
     @method

     @abstract
     Track a push notification using its payload sent from Mixpanel.

     @discussion
     To simplify user interaction tracking and a/b testing, Mixpanel
     automatically sends IDs for the relevant notification and a/b variants
     of each push. This method parses the standard payload and queues a
     track call using this information.

     @param userInfo         remote notification payload dictionary
     */
    @Method(selector = "trackPushNotification:")
    public native void trackPushNotification(NSDictionary userInfo);

    /*!
     @method

     @abstract
     Registers super properties, overwriting ones that have already been set.

     @discussion
     Super properties, once registered, are automatically sent as properties for
     all event tracking calls. They save you having to maintain and add a common
     set of properties to your events. Property keys must be <code>NSString</code>
     objects and values must be <code>NSString</code>, <code>NSNumber</code>,
     <code>NSNull</code>, <code>NSArray</code>, <code>NSDictionary</code>,
     <code>NSDate</code> or <code>NSURL</code> objects.

     @param properties      properties dictionary
     */
    @Method(selector = "registerSuperProperties:")
    public native void registerSuperProperties(NSDictionary properties);

    /*!
     @method

     @abstract
     Registers super properties without overwriting ones that have already been
     set.

     @discussion
     Property keys must be <code>NSString</code> objects and values must be
     <code>NSString</code>, <code>NSNumber</code>, <code>NSNull</code>,
     <code>NSArray</code>, <code>NSDictionary</code>, <code>NSDate</code> or
     <code>NSURL</code> objects.

     @param properties      properties dictionary
     */
    @Method(selector = "registerSuperPropertiesOnce:")
    public native void registerSuperPropertiesOnce(NSDictionary properties);

    /*!
     @method

     @abstract
     Registers super properties without overwriting ones that have already been set
     unless the existing value is equal to defaultValue.

     @discussion
     Property keys must be <code>NSString</code> objects and values must be
     <code>NSString</code>, <code>NSNumber</code>, <code>NSNull</code>,
     <code>NSArray</code>, <code>NSDictionary</code>, <code>NSDate</code> or
     <code>NSURL</code> objects.

     @param properties      properties dictionary
     @param defaultValue    overwrite existing properties that have this value
     */
    //- (void)registerSuperPropertiesOnce:(NSDictionary *)properties defaultValue:(id)defaultValue;
    @Method(selector = "registerSuperPropertiesOnce:defaultValue:")
    public native void registerSuperPropertiesOnce(NSDictionary properties, @Pointer long defaultValue);


    /*!
     @method

     @abstract
     Removes a previously registered super property.

     @discussion
     As an alternative to clearing all properties, unregistering specific super
     properties prevents them from being recorded on future events. This operation
     does not affect the value of other super properties. Any property name that is
     not registered is ignored.

     Note that after removing a super property, events will show the attribute as
     having the value <code>undefined</code> in Mixpanel until a new value is
     registered.

     @param propertyName   array of property name strings to remove
     */
    //- (void)unregisterSuperProperty:(NSString*)propertyName;
    @Method(selector = "unregisterSuperProperty:")
    public native void unregisterSuperProperty(String propertyName);


    /*!
     @method

     @abstract
     Clears all currently set super properties.
     */
    //- (void)clearSuperProperties;
    @Method(selector = "clearSuperProperties:")
    public native void clearSuperProperties();


    /*!
     @method

     @abstract
     Returns the currently set super properties.
     */
    //- (NSDictionary *)currentSuperProperties;
    @Method(selector = "currentSuperProperties:")
    public native NSDictionary currentSuperProperties();


    /*!
     @method

     @abstract
     Starts a timer that will be stopped and added as a property when a
     corresponding event is tracked.

     @discussion
     This method is intended to be used in advance of events that have
     a duration. For example, if a developer were to track an "Image Upload" event
     she might want to also know how long the upload took. Calling this method
     before the upload code would implicitly cause the <code>track</code>
     call to record its duration.

     <pre>
     // begin timing the image upload
     [mixpanel timeEvent:@"Image Upload"];

     // upload the image
     [self uploadImageWithSuccessHandler:^{

        // track the event
        [mixpanel track:@"Image Upload"];
     }];
     </pre>

     @param event   a string, identical to the name of the event that will be tracked

     */
    //- (void)timeEvent:(NSString*)event;
    @Method(selector = "timeEvent:")
    public native void timeEvent(String event);


    /*!
     @method

     @abstract
     Clears all current event timers.
     */
    //- (void)clearTimedEvents;
    @Method(selector = "clearTimedEvents:")
    public native void clearTimedEvents();

    /*!
     @method

     @abstract
     Clears all stored properties and distinct IDs. Useful if your app's user logs out.
     */
    //- (void)reset;
    @Method(selector = "reset:")
    public native void reset();


    /*!
     @method

     @abstract
     Uploads queued data to the Mixpanel server.

     @discussion
     By default, queued data is flushed to the Mixpanel servers every minute (the
     default for <code>flushInvterval</code>), and on background (since
     <code>flushOnBackground</code> is on by default). You only need to call this
     method manually if you want to force a flush at a particular moment.
     */
    //- (void)flush;
    @Method(selector = "flush:")
    public native void flush();

    /*!
     @method

     @abstract
     Writes current project info, including distinct ID, super properties and pending event
     and People record queues to disk.

     @discussion
     This state will be recovered when the app is launched again if the Mixpanel
     library is initialized with the same project token. <b>You do not need to call
     this method</b>. The library listens for app state changes and handles
     persisting data as needed. It can be useful in some special circumstances,
     though, for example, if you'd like to track app crashes from main.m.
     */
    //- (void)archive;
    @Method(selector = "archive:")
    public native void archive();

    /*!
     @method

     @abstract
     Shows the survey with the given name.

     @discussion
     This method allows you to explicitly show a named survey at the time of your choosing.

     */
    //- (void)showSurveyWithID:(NSUInteger)ID;
    @Method(selector = "showSurveyWithID:")
    public native void showSurveyWithID(int ID);


    /*!
     @method

     @abstract
     Show a survey if one is available.

     @discussion
     This method allows you to display the first available survey targeted to the currently
     identified user at the time of your choosing. You would typically pair this with
     setting <code>showSurveyOnActive = NO;</code> so that the survey won't show automatically.

     */
    //- (void)showSurvey;
    @Method(selector = "showSurvey:")
    public native void showSurvey();

    /*!
     @method

     @abstract
     Shows the notification of the given id.

     @discussion
     You do not need to call this method on the main thread.
     */
    //- (void)showNotificationWithID:(NSUInteger)ID;
    @Method(selector = "showNotificationWithID:")
    public native void showNotificationWithID(int ID);

    /*!
     @method

     @abstract
     Shows a notification with the given type if one is available.

     @discussion
     You do not need to call this method on the main thread.

     @param type The type of notification to show, either @"mini", or @"takeover"
     */
    //- (void)showNotificationWithType:(NSString*)type;
    @Method(selector = "showNotificationWithType:")
    public native void showNotificationWithType(String type);

    /*!
     @method

     @abstract
     Shows a notification if one is available.

     @discussion
     You do not need to call this method on the main thread.
     */
    //- (void)showNotification;
    @Method(selector = "showNotification:")
    public native void showNotification();

    /*!
      @method

      @abstract
      Join any experiments (A/B tests) that are available for the current user.

      @discussion
      Mixpanel will check for A/B tests automatically when your app enters
      the foreground. Call this method if you would like to to check for,
      and join, any experiments are newly available for the current user.

      You do not need to call this method on the main thread.
      */
    //- (void)joinExperiments;
    @Method(selector = "joinExperiments:")
    public native void joinExperiments();

    /*!
     @method

     @abstract
     Join any experiments (A/B tests) that are available for the current user.

     @discussion
     Same as joinExperiments but will fire the given callback after all experiments
     have been loaded and applied.
     */
    //- (void)joinExperimentsWithCallback:(void(^)())experimentsLoadedCallback;
    @Method(selector = "joinExperimentsWithCallback:")
    public native void joinExperiments(@Block ExperimentsLoadedHandler experimentsLoadedHandler);

    //- (void)createAlias:(NSString*)alias forDistinctID:(NSString *)distinctID;
    @Method(selector = "createAlias:forDistinctID:")
    public native void createAlias(String alias, String distinctID);

    //- (NSString *)libVersion;
    @Method(selector = "libVersion:")
    public native String libVersion();

    public interface ExperimentsLoadedHandler {
        void invoke();
    }

}
