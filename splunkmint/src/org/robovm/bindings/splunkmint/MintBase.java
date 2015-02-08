
package org.robovm.bindings.splunkmint;

import java.util.List;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSException;
import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.foundation.NSString;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.block.VoidBlock1;
import org.robovm.rt.bro.annotation.MachineSizedSInt;

@NativeClass
public class MintBase extends BugSense {

    /** Use this method to disable network monitoring before initAndStartSession */
    @Method
    public native void disableNetworkMonitoring ();

    /** Gets the developer's remote settings as key-value pairs.
     *
     * @return A dictionary of key-value pairs. */
    @Method
    public native NSDictionary<NSString, NSObject> getDevSettings ();

    /** Indicates whether to enable logging. When YES, NSLog console messages are cached and sent with the exception.
     *
     * @param enable Indicates whether to enable logging. */
    @Method(selector = "enableMintLoggingCache:")
    public native void enableMintLoggingCache (boolean enable);

    /** Set if device logs are attached to the crash.
     *
     * @param enable YES to enable logging. */
    @Method(selector = "enableLogging:")
    public native void enableLogging (boolean enable);

    /** Sets the maximum number of lines to cache from the console log.
     *
     * @param lines The number of lines. */
    @Method(selector = "setLogging:")
    public native void setLogging (@MachineSizedSInt long linesCount);

    /** Starts a transaction with a unique name.
     *
     * @param transactionName The unique transaction name.
     * @param resultBlock The block to invoke with additional information when complete. */
    @Method(selector = "transactionStart:andResultBlock:")
    public native void startTransaction (String transactionName, @Block VoidBlock1<TransactionStartResult> resultBlock);

    /** Stops a transaction.
     *
     * @param transactionName The name of the transaction.
     * @param resultBlock The block to invoke with additional information when complete. */
    @Method(selector = "transactionStop:andResultBlock:")
    public native void stopTransaction (String transactionName, @Block VoidBlock1<TransactionStopResult> resultBlock);

    /** Cancels a transaction.
     *
     * @param transactionName The name of the transaction.
     * @param reason The reason for cancelling the transaction.
     * @param resultBlock The block to invoke with additional information when complete. */
    @Method(selector = "transactionCancel:reason:andResultBlock:")
    public native void cancelTransaction (String transactionName, String reason,
        @Block VoidBlock1<TransactionStopResult> resultBlock);

    /** Adds a URL to the network monitoring blacklist.
     *
     * @param url The URL to ignore. This can be a partial URL. */
    @Method(selector = "addURLToBlackList:")
    public native void addURLToBlackList (String url);

    /** The URLs blacklisted from network interception.
     *
     * @return */
    @Method(selector = "blacklistUrls")
    public native @org.robovm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> getBlacklistUrls ();

    /** Logs an event with a log level, sends the log entry to the console window, and caches a request to send to the server.
     *
     * @param name The name of the event (up to 256 characters).
     * @param logLevel The MintLogLevel enumeration value for the log level.
     * @param completed The block to invoke with additional information when complete. */
    @Method(selector = "logEventAsyncWithName:logLevel:andCompletionBlock:")
    public native void logEventAsync (String name, MintLogLevel logLevel, @Block VoidBlock1<MintLogResult> completed);

    /** Get an ExceptionDataFixture from a NSException
     *
     * @param exception The NSException
     *
     * @return The ExceptionDataFixture JSON string model. */
    @Method(selector = "exceptionFixtureFrom:")
    public native String getExceptionFixtureFrom (NSException exception);
}
