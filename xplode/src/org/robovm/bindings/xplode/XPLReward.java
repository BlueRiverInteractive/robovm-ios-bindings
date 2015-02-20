package org.robovm.bindings.xplode;

import org.robovm.apple.foundation.NSNumber;
import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

/**
 * Created by sargis on 2/20/15.
 */
@NativeClass
public class XPLReward extends NSObject {
    /// Returns the reward identifier specified on the Xplode portal
    /// @return The reward identifier.
    //@property (nonatomic, strong, readonly)
    //NSString*identifier;
    @Property(selector = "identifier")
    public native String getIdentifier();

    /// Returns the reward value specified on the Xplode portal (optional, may be nil)
    /// @return The reward value.
    //@property (nonatomic, strong, readonly)
    //NSNumber*value;
    @Property(selector = "value")
    public native NSNumber getValue();


    /// After you reward your user, you must call this method.
    /// Otherwise reward will show up again when you call checkForAvailableRewards:.
    //- (void)consumeReward;
    @Method(selector = "consumeReward:")
    public native void consumeReward();
}
