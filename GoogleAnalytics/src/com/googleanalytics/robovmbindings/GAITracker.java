package com.googleanalytics.robovmbindings;

import org.robovm.cocoatouch.foundation.NSDictionary;
import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSObjectProtocol;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.BindSelector;
import org.robovm.rt.bro.annotation.Callback;

/**
 *Google Analytics tracking interface. Obtain instances of this interface from
 *[GAI trackerWithTrackingId:] to track screens, events, transactions, timing,
 *and exceptions. The implementation of this interface is thread-safe, and no
 *calls are expected to block or take a long time.  All network and disk activity
 *will take place in the background.
 */
public interface GAITracker extends NSObjectProtocol{
	
	//@property(nonatomic, readonly) NSString *name;
	/** Name of this tracker. */
	public String getName();
	
	//- (void)set:(NSString *)parameterName
	//      value:(NSString *)value;
	/**
	 * Set a tracking parameter.
	 *
	 *	 @param parameterName The parameter name.
	 *
	 *	 @param value The value to set for the parameter. If this is nil, the
	 *	 value for the parameter will be cleared.
	 */
	public void set(String parameterName, String value);
	
	//- (NSString *)get:(NSString *)parameterName;
	/**
	 *Get a tracking parameter.
	 *
	 *	 @param parameterName The parameter name.
	 *
	 *	 @returns The parameter value, or nil if no value for the given parameter is
	 *	 set.
	 */
	public String get(String parameterName);
	
	//- (void)send:(NSDictionary *)parameters;
	/**
	 *Queue tracking information with the given parameter values.
	 *
	 *	 @param parameters A map from parameter names to parameter values which will be
	 *	 set just for this piece of tracking information, or nil for none.
	 */
	public void send(NSDictionary parameters);
	
	public static class Adapter extends NSObject implements GAITracker {

		@Override
		public String getName() {
			return null;
		}

		@Override
		public void set(String parameterName, String value) {
		}

		@Override
		public String get(String parameterName) {
			return null;
		}

		@Override
		public void send(NSDictionary parameters) {
		}
	}
	
	static class Callbacks {
		@Callback
		@BindSelector("set:")
		public static void objc_set(GAITracker __self__, Selector __cmd__,String parameterName, String value){
			__self__.set(parameterName, value);
		}
		
		@Callback
		@BindSelector("get:")
		public static void objc_get(GAITracker __self__, Selector __cmd__,String parameterName){
			__self__.get(parameterName);
		}
		
		@Callback
		@BindSelector("send:")
		public static void objc_send(GAITracker __self__, Selector __cmd__,NSDictionary parameters){
			__self__.send(parameters);
		}
	}
	
}
