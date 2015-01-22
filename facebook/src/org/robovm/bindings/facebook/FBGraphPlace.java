
package org.robovm.bindings.facebook;

import org.robovm.apple.foundation.NSDictionary;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

/** The FBGraphPlace class enables typed access to a place object as represented in the Graph API.
 * 
 * 
 * The FBGraphPlace class represents the most commonly used properties of a Facebook place object. It may be used to access an
 * {@link NSDictionary} object that has been wrapped with an {@link FBGraphObject} facade. */
@NativeClass
public class FBGraphPlace extends FBGraphObject {
    /** @return the place ID. */
    @Property
    public native String getId ();

    @Property
    public native void setId (String id);

    /** @return the place name. */
    @Property
    public native String getName ();

    @Property
    public native void setName (String name);

    /** @return the place category. */
    @Property
    public native String getCategory ();

    @Property
    public native void setCategory (String category);

    /** @return the place location. */
    @Property
    public native FBGraphLocation getLocation ();

    @Property
    public native void setLocation (FBGraphLocation location);
}
