package com.googleanalytics.robovmbindings;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSObjectProtocol;
import org.robovm.cocoatouch.foundation.NSString;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.BindSelector;
import org.robovm.rt.bro.annotation.Callback;

/**
 *Protocol to be used for logging debug and informational messages from the SDK.
 *Implementations of this protocol can be provided to the |GAI| class,
 *to be used as the logger by the SDK.  See the |logger| property in GAI.h.
 */
public interface GAILogger extends NSObjectProtocol{
	/*!
	 Only messages of |logLevel| and below are logged.
	 */
	//@property (nonatomic, assign) GAILogLevel logLevel;
	
	/*!
	 Logs message with log level |kGAILogLevelVerbose|.
	 */
	//- (void)verbose:(NSString *)message;
	public void verbose(NSString message);

	/*!
	 Logs message with log level |kGAILogLevelInfo|.
	 */
	//- (void)info:(NSString *)message;
	public void info(NSString message);

	/*!
	 Logs message with log level |kGAILogLevelWarning|.
	 */
	//- (void)warning:(NSString *)message;
	public void warning(NSString message);
	
	/*!
	 Logs message with log level |kGAILogLevelError|.
	 */
	//- (void)error:(NSString *)message;
	public void error(NSString message);
	
	public static class Adapter extends NSObject implements GAILogger {

		@Override
		public void verbose(NSString message) {
		}

		@Override
		public void info(NSString message) {
		}

		@Override
		public void warning(NSString message) {
		}

		@Override
		public void error(NSString message) {
		}
	}
	
	static class Callbacks {
		@Callback
		@BindSelector("verbose:")
		public static void objc_verbose(GAILogger __self__, Selector __cmd__, NSString message){
			__self__.verbose(message);
		}
		
		@Callback
		@BindSelector("info:")
		public static void objc_info(GAILogger __self__, Selector __cmd__, NSString message){
			__self__.info(message);
		}
		
		@Callback
		@BindSelector("warning:")
		public static void objc_warning(GAILogger __self__, Selector __cmd__, NSString message){
			__self__.warning(message);
		}
		
		@Callback
		@BindSelector("error:")
		public static void objc_error(GAILogger __self__, Selector __cmd__, NSString message){
			__self__.error(message);
		}
	}
}
