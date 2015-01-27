package org.robovm.bindings.mixpanel;

import org.robovm.apple.foundation.*;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Pointer;

/**
 * Created by sargis on 1/26/15.
 */
@NativeClass
public class MixpanelPeople extends NSObject {
    /*!
     @method

     @abstract
     Register the given device to receive push notifications.

     @discussion
     This will associate the device token with the current user in Mixpanel People,
     which will allow you to send push notifications to the user from the Mixpanel
     People web interface. You should call this method with the <code>NSData</code>
     token passed to
     <code>application:didRegisterForRemoteNotificationsWithDeviceToken:</code>.

     @param deviceToken     device token as returned <code>application:didRegisterForRemoteNotificationsWithDeviceToken:</code>
     */
    // - (void)addPushDeviceToken:(NSData *)deviceToken;
    @Method(selector = "addPushDeviceToken:")
    public native void addPushDeviceToken(NSData deviceToken);


    /*!
     @method

     @abstract
     Set properties on the current user in Mixpanel People.

     @discussion
     The properties will be set on the current user. The keys must be NSString
     objects and the values should be NSString, NSNumber, NSArray, NSDate, or
     NSNull objects. We use an NSAssert to enforce this type requirement. In
     release mode, the assert is stripped out and we will silently convert
     incorrect types to strings using [NSString stringWithFormat:@"%@", value]. You
     can override the default the current project token and distinct ID by
     including the special properties: $token and $distinct_id. If the existing
     user record on the server already has a value for a given property, the old
     value is overwritten. Other existing properties will not be affected.

     <pre>
     // applies to both Mixpanel Engagement track: AND Mixpanel People set: and
     // increment: calls
     [mixpanel identify:distinctId];

     // applies ONLY to Mixpanel People set: and increment: calls
     [mixpanel.people identify:distinctId];
     </pre>

     @param properties       properties dictionary

     */
    //- (void)set:(NSDictionary *)properties;
    @Method(selector = "set:")
    public native void set(NSDictionary properties);


    /*!
     @method

     @abstract
     Convenience method for setting a single property in Mixpanel People.

     @discussion
     Property keys must be <code>NSString</code> objects and values must be
     <code>NSString</code>, <code>NSNumber</code>, <code>NSNull</code>,
     <code>NSArray</code>, <code>NSDictionary</code>, <code>NSDate</code> or
     <code>NSURL</code> objects.

     @param property        property name
     @param object          property value
     */
    //- (void)set:(NSString *)property to:(id)object;
    @Method(selector = "set:to:")
    public native void set(String properties, @Pointer long object);

    /*!
    @method

    @abstract
    Set properties on the current user in Mixpanel People, but don't overwrite if
    there is an existing value.

    @discussion
    This method is identical to <code>set:</code> except it will only set
    properties that are not already set. It is particularly useful for collecting
    data about the user's initial experience and source, as well as dates
    representing the first time something happened.

    @param properties       properties dictionary

    */
    //- (void)setOnce:(NSDictionary *)properties;
    @Method(selector = "setOnce:")
    public native void setOnce(NSDictionary properties);

    /*!
     @method

     @abstract
     Increment the given numeric properties by the given values.

     @discussion
     Property keys must be NSString names of numeric properties. A property is
     numeric if its current value is a number. If a property does not exist, it
     will be set to the increment amount. Property values must be NSNumber objects.

     @param properties      properties dictionary
     */
    //- (void)increment:(NSDictionary *)properties;
    @Method(selector = "increment:")
    public native void increment(NSDictionary properties);

    /*!
     @method

     @abstract
     Convenience method for incrementing a single numeric property by the specified
     amount.

     @param property        property name
     @param amount          amount to increment by
     */
    //- (void)increment:(NSString *)property by:(NSNumber *)amount;
    @Method(selector = "increment:by:")
    public native void incrementBy(NSString property, NSNumber amount);

    /*!
     @method

     @abstract
     Append values to list properties.

     @discussion
     Property keys must be <code>NSString</code> objects and values must be
     <code>NSString</code>, <code>NSNumber</code>, <code>NSNull</code>,
     <code>NSArray</code>, <code>NSDictionary</code>, <code>NSDate</code> or
     <code>NSURL</code> objects.

     @param properties      mapping of list property names to values to append
     */
    //- (void)append:(NSDictionary *)properties;
    @Method(selector = "append:")
    public native void append(NSDictionary properties);

    /*!
     @method

     @abstract
     Union list properties.

     @discussion
     Property keys must be <code>NSArray</code> objects.

     @param properties      mapping of list property names to lists to union
     */
    //- (void)union:(NSDictionary *)properties;
    @Method(selector = "union:")
    public native void union(NSDictionary properties);

    /*!
     @method

     @abstract
     Track money spent by the current user for revenue analytics.

     @param amount          amount of revenue received
     */
    //- (void)trackCharge:(NSNumber *)amount;
    @Method(selector = "trackCharge:")
    public native void trackCharge(NSNumber amount);

    /*!
     @method

     @abstract
     Track money spent by the current user for revenue analytics and associate
     properties with the charge.

     @discussion
     Charge properties allow you segment on types of revenue. For instance, you
     could record a product ID with each charge so that you could segement on it in
     revenue analytics to see which products are generating the most revenue.
     */
    //- (void)trackCharge:(NSNumber *)amount withProperties:(NSDictionary *)properties;
    @Method(selector = "trackCharge:withProperties:")
    public native void trackCharge(NSNumber amount, NSDictionary properties);

    /*!
     @method

     @abstract
     Delete current user's revenue history.
     */
    //- (void)clearCharges;
    @Method(selector = "clearCharges:")
    public native void clearCharges();

    /*!
     @method

     @abstract
     Delete current user's record from Mixpanel People.
     */
    //- (void)deleteUser;
    @Method(selector = "deleteUser:")
    public native void deleteUser();

}
