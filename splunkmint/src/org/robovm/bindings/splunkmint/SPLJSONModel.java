
package org.robovm.bindings.splunkmint;

import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Method;

/** The JSONModel is an abstract model class, you should ot instantiate it directly, as it does not have any properties, and
 * therefore cannot serve as a data model. Instead you should subclass it, and define the properties you want your data model to
 * have as properties of your own class. */
public class SPLJSONModel extends NSObject /* SPLAbstractJSONModelProtocol */{

    /** Export the whole object to a JSON data text string
     * @return JSON text describing the data model */
    @Method
    public native String toJSONString ();
}
