package com.googleanalytics.robovmbindings;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSString;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
@NativeClass()
public class GAIDefaultLogger extends NSObject implements GAILogger{

	static {
		ObjCRuntime.bind();
	}
	

	//- (void)verbose:(NSString *)message;
	private static final Selector  verbose$ = Selector.register("verbose:");
	@Bridge private native static void objc_verbose(GAIDefaultLogger __self__, Selector __cmd__, NSString message);
	@Override
	/** Logs message with log level |kGAILogLevelVerbose|. */
	public void verbose(NSString message) {
		objc_verbose(this, verbose$, message);
	}


	//- (void)info:(NSString *)message;
	private static final Selector  info$ = Selector.register("info:");
	@Bridge private native static void objc_info(GAIDefaultLogger __self__, Selector __cmd__, NSString message);
	@Override
	/** Logs message with log level |kGAILogLevelInfo|. */
	public void info(NSString message) {
		objc_info(this, info$, message);
	}

	//- (void)warning:(NSString *)message;
	private static final Selector  warning$ = Selector.register("warning:");
	@Bridge private native static void objc_warning(GAIDefaultLogger __self__, Selector __cmd__, NSString message);
	@Override
	/** Logs message with log level |kGAILogLevelWarning|. */
	public void warning(NSString message) {
		objc_warning(this, warning$, message);
	}

	//- (void)error:(NSString *)message;
	private static final Selector  error$ = Selector.register("error:");
	@Bridge private native static void objc_error(GAIDefaultLogger __self__, Selector __cmd__, NSString message);
	@Override
	/** Logs message with log level |kGAILogLevelError|. */
	public void error(NSString message) {
		objc_error(this, error$, message);
	}

}
