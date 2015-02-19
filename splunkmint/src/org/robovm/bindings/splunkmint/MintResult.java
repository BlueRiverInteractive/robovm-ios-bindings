
package org.robovm.bindings.splunkmint;

import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

/** The MintResult class contains information about the completion of a request. */
@NativeClass
public class MintResult extends NSObject {

    /** The type of request. */
    @Property
    public native MintRequestType getRequestType ();

    @Property
    public native void setRequestType (MintRequestType requestType);

    /** A description with information about the request, such as a value when something has gone wrong or a notification. */
    @Property
    public native String getDescriptionResult ();

    @Property
    public native void setDescriptionResult (String descriptionResult);

    /** The result of the request. */
    @Property
    public native MintResultState getResultState ();

    @Property
    public native void setResultState (MintResultState resultState);

    /** A NSException instance that provides you with information when a request fails. */
    @Property
    public native MintMessageException getExceptionError ();

    @Property
    public native void setExceptionError (MintMessageException exceptionError);

    /** The JSON model that is sent to the server. */
    @Property
    public native String getClientRequest ();

    @Property
    public native void setClientRequest (String clientRequest);

    /** A Boolean that indicates whether the request was properly handled while debugging. */
    @Property
    public native boolean isHandledWhileDebugging ();

    @Property
    public native void setHandledWhileDebugging (boolean handledWhileDebugging);
}
