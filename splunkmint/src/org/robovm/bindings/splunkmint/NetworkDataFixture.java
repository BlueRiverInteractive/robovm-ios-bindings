
package org.robovm.bindings.splunkmint;

import org.robovm.apple.foundation.NSData;
import org.robovm.apple.foundation.NSError;
import org.robovm.apple.foundation.NSMutableDictionary;
import org.robovm.apple.foundation.NSNumber;
import org.robovm.apple.foundation.NSURLRequest;
import org.robovm.apple.foundation.NSURLResponse;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;
import org.robovm.rt.bro.annotation.MachineSizedUInt;

@NativeClass
public class NetworkDataFixture extends DataFixture {
    @Property
    public native String getUrl ();

    @Property
    public native String getProtocol ();

    @Property
    public native NSNumber getEndTime ();

    @Property
    public native NSNumber getDuration ();

    @Property
    public native NSNumber getStatusCode ();

    @Property
    public native NSNumber getContentLength ();

    @Property
    public native NSNumber getRequestLength ();

    @Property(selector = "failed")
    public native boolean hasFailed ();

    @Property(selector = "reqHeaders")
    public native NSMutableDictionary<?, ?> getRequestHeaders ();

    @Property(selector = "respHeaders")
    public native NSMutableDictionary<?, ?> getResponseHeaders ();

    @Property
    public native String getException ();

    @Property
    public native NSNumber getResponseLength ();

    @Property
    public native NSNumber getLatency ();

    @Method(selector = "appendWithStatusCode:")
    public native void appendStatusCode (NSNumber statusCode);

    @Method
    public native void appendStartTime ();

    @Method
    public native void appendEndTime ();

    @Method(selector = "appendRequestInfo:")
    public native void appendRequestInfo (NSURLRequest request);

    @Method(selector = "appendResponseInfo:")
    public native void appendResponseInfo (NSURLResponse response);

    @Method(selector = "appendResponseData:")
    public native void appendResponseData (NSData data);

    @Method(selector = "appendResponseDataSize:")
    public native void appendResponseDataSize (@MachineSizedUInt long dataSize);

    @Method(selector = "appendWithError:")
    public native void appendError (NSError error);

    @Method
    public native void appendGlobalExtraData ();

    @Method
    public native void debugPrint ();

    @Method
    public native void saveToDisk ();
}
