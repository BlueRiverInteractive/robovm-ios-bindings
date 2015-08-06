package org.robovm.bindings.splunkmint;

import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSException;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Pointer;

/** The MintMessageException class is derived from NSException. */
@NativeClass
public class MintMessageException extends NSException {
    public MintMessageException(String aName, String aReason, NSDictionary<?, ?> aUserInfo) {
        super((SkipInit) null);
        initObject(init(aName, aReason, aUserInfo));
    }

    /**
     * Initializes an instance of MintMessageException.
     *
     * @param aName The name of the exception.
     * @param aReason The reason for the exception.
     * @param aUserInfo A dictionary with additional data, if applicable.
     *
     * @return The MintMessageException instance.
     */
    @Override
    @Method(selector = "initWithName:reason:userInfo:")
    protected native @Pointer long init(String aName, String aReson, NSDictionary aUserInfo);
}
