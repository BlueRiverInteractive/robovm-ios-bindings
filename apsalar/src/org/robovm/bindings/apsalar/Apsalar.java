
package org.robovm.bindings.apsalar;

import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.foundation.NSURL;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;

@NativeClass
public class Apsalar extends NSObject {

    @Method(selector = "startSession:withKey:")
    public static native void startSession (String apiKey, String apiSecret);

    @Method(selector = "startSession:withKey:andLaunchOptions:")
    public static native void startSession (String apiKey, String apiSecret, NSDictionary<?, ?> launchOptions);

    @Method(selector = "startSession:withKey:andURL:")
    public static native void startSession (String apiKey, String apiSecret, NSURL url);

// + (void) reStartSession:(NSString *)apiKey withKey:(NSString *)apiSecret;
// + (BOOL) sessionStarted;
// + (void) endSession;
// + (void) event:(NSString *)name;
// + (void) event:(NSString *)name withArgs:(NSDictionary *)args;
// + (void) eventWithArgs:(NSString *)name, ...; // use only subclasses of
// // NSObject, not primitive types
// // like int
// + (Apsalar *) shared;
// + (NSTimeInterval) sessionDuration;
// + (NSDate *) sessionStartDate;
// + (NSString *) sessionID;
// + (NSString *) version;
// + (NSString *)apsalarID;
// + (NSString *)apsalarKeyspace;
// + (void) setBufferLimit:(int)size;
// @property(nonatomic, readonly) NSString *applicationName;
// @property(nonatomic, readonly) NSString *applicationIdentifier;
// + (BOOL) processJSRequest:(UIWebView *)webView withURL:(NSURLRequest *)url;
// @property(nonatomic) int minSessionDuration; // Default: 5
// + (void) setMinSessionDuration:(int)seconds;
//
// // IAP
// + (void)setAllowAutoIAPComplete:(BOOL)boolean;
// + (void)iapComplete:(id)transaction;
// + (void)iapComplete:(id)transaction withAttributes:(id)value, ...;
//
// // DEMO
// + (void)setGender:(NSString *)gender;
// + (void)setAge:(id)age;
//
// // BATCHING
// + (int)batchInterval;
// + (void)setBatchInterval:(int)interval;
// + (BOOL)batchesEvents;
// + (void)setBatchesEvents:(BOOL)boolean;
// + (void)sendAllBatches;
}
