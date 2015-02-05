package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSDate;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class LogService extends App42Service
{
	public LogService(String apiKey, String secretKey) {
		super((SkipInit) null);
	    initObject(init(apiKey, secretKey));
	}
	
	@Method(selector = "initWithAPIKey:secretKey:")
	private native @Pointer long init(String apiKey, String secretKey);
	
	/**
	 * Logs the info message
	 *
	 * @param msg
	 *            - Message to be logged
	 * @param module
	 *            - Module name for which the message is getting logged
	 *
	 * @return Log object containing logged message
	 *
	 *
	 */
	@Method(selector = "info:module:completionBlock:")
	public native void info(String msg, String module, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Logs the debug message
	 *
	 * @param msg
	 *            - Message to be logged
	 * @param module
	 *            - Module name for which the message is getting logged
	 *
	 * @return Log object containing logged message.
	 *
	 */
	@Method(selector = "debug:module:completionBlock:")
	public native void debug(String msg, String module, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Logs the fatal message
	 *
	 * @param msg
	 *            - Message to be logged
	 * @param module
	 *            - Module name for which the message is getting logged
	 *
	 * @return Log object containing logged message.
	 *
	 */
	@Method(selector = "fatal:module:completionBlock:")
	public native void fatal(String msg, String module, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Logs the error message
	 *
	 * @param msg
	 *            - Message to be logged
	 * @param module
	 *            - Module name for which the message is getting logged
	 *
	 * @return Log object containing logged message
	 *
	 */
	@Method(selector = "error:module:completionBlock:")
	public native void error(String msg, String module, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Fetch the count of log messages based on the Module
	 *
	 * @param moduleName
	 *            - Module name for which the count of messages has to be
	 *            fetched
	 *
	 * @return App42Response object containing count of fetched messages.
	 *
	 */
	@Method(selector = "fetchLogsCountByModule:completionBlock:")
	public native void fetchLogsCountByModule(String moduleName, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Fetch the log messages based on the Module
	 *
	 * @param moduleName
	 *            - Module name for which the messages has to be fetched
	 *
	 * @return Log object containing fetched messages.
	 *
	 */
	@Method(selector = "fetchLogsByModule:completionBlock:")
	public native void fetchLogsByModule(String moduleName, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Fetch the log messages based on the Module by paging.
	 *
	 * @param moduleName
	 *            - Module name for which the messages has to be fetched
	 * @param max
	 *            - Maximum number of records to be fetched
	 * @param offset
	 *            - From where the records are to be fetched
	 *
	 * @return Log object containing fetched messages.
	 *
	 */
	@Method(selector = "fetchLogsByModule:max:offset:completionBlock:")
	public native void fetchLogsByModule(String moduleName, int max, int offset, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Fetch count of log messages based on the Module and Message Text
	 *
	 * @param moduleName
	 *            - Module name for which the count of messages has to be
	 *            fetched
	 * @param text
	 *            - The log message on which count of logs have to be searched
	 *
	 * @return App42Response object containing count of fetched messages.
	 *
	 */
	@Method(selector = "fetchLogsCountByModuleAndText:text:completionBlock:")
	public native void fetchLogsCountByModuleAndText(String moduleName, String text, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Fetch log messages based on the Module and Message Text
	 *
	 * @param moduleName
	 *            - Module name for which the messages has to be fetched
	 * @param text
	 *            - The log message on which logs have to be searched
	 *
	 * @return Log object containing fetched messages.
	 *
	 */
	@Method(selector = "fetchLogsByModuleAndText:text:completionBlock:")
	public native void fetchLogsByModuleAndText(String moduleName, String text, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Fetch log messages based on the Module and Message Text by paging.
	 *
	 * @param moduleName
	 *            - Module name for which the messages has to be fetched
	 * @param text
	 *            - The log message on which logs have to be searched
	 *
	 * @param max
	 *            - Maximum number of records to be fetched
	 * @param offset
	 *            - From where the records are to be fetched
	 *
	 * @return Log object containing fetched messages.
	 *
	 */
	@Method(selector = "fetchLogsByModuleAndText:text:max:offset:completionBlock:")
	public native void fetchLogsByModuleAndText(String moduleName, String text, int max, int offset, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Fetch count of log messages based on Info Level
	 *
	 * @return App42Response object containing count of fetched info messages.
	 *
	 */
	@Method(selector = "fetchLogsCountByInfo:")
	public native void fetchLogsCountByInfo(@Block App42ResponseBlock completionBlock);
	
	/**
	 * Fetch count of log messages based on Debug Level
	 *
	 * @return App42Response object containing count of fetched debug messages.
	 *
	 */
	@Method(selector = "fetchLogsCountByDebug:")
	public native void fetchLogsCountByDebug(@Block App42ResponseBlock completionBlock);
	
	/**
	 * Fetch count of log messages based on Error Level
	 *
	 * @return App42Response object containing count of fetched error messages.
	 *
	 */
	@Method(selector = "fetchLogsCountByError:")
	public native void fetchLogsCountByError(@Block App42ResponseBlock completionBlock);
	
	/**
	 * Fetch count of log messages based on Fatal Level
	 *
	 * @return App42Response object containing count of fetched Fatal messages.
	 *
	 */
	@Method(selector = "fetchLogsCountByFatal:")
	public native void fetchLogsCountByFatal(@Block App42ResponseBlock completionBlock);
	
	/**
	 * Fetch log messages based on Info Level
	 *
	 * @return Log object containing fetched info messages.
	 *
	 */
	@Method(selector = "fetchLogsByInfo:")
	public native void fetchLogsByInfo(@Block App42ResponseBlock completionBlock);
	
	/**
	 * Fetch log messages based on Debug Level
	 *
	 * @return Log object containing fetched debug messages
	 *
	 */
	@Method(selector = "fetchLogsByDebug:")
	public native void fetchLogsByDebug(@Block App42ResponseBlock completionBlock);
	
	/**
	 * Fetch log messages based on Error Level
	 *
	 * @return Log object containing fetched error messages
	 *
	 */
	@Method(selector = "fetchLogsByError:")
	public native void fetchLogsByError(@Block App42ResponseBlock completionBlock);
	
	/**
	 * Fetch log messages based on Fatal Level
	 *
	 * @return Log object containing fetched Fatal messages
	 *
	 */
	@Method(selector = "fetchLogsByFatal:")
	public native void fetchLogsByFatal(@Block App42ResponseBlock completionBlock);
	
	/**
	 * Fetch log messages based on Info Level by paging.
	 *
	 * @param max
	 *            - Maximum number of records to be fetched
	 * @param offset
	 *            - From where the records are to be fetched
	 *
	 * @return Log object containing fetched info messages.
	 * 
	 */
	@Method(selector = "fetchLogsByInfo:offset:completionBlock:")
	public native void fetchLogsByInfo(int max, int offset, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Fetch log messages based on Debug Level by paging.
	 *
	 * @param max
	 *            - Maximum number of records to be fetched
	 * @param offset
	 *            - From where the records are to be fetched
	 *
	 * @return Log object containing fetched debug messages.
	 *
	 */
	@Method(selector = "fetchLogsByDebug:offset:completionBlock:")
	public native void fetchLogsByDebug(int max, int offset, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Fetch log messages based on Error Level by paging.
	 *
	 * @param max
	 *            - Maximum number of records to be fetched
	 * @param offset
	 *            - From where the records are to be fetched
	 *
	 * @return Log object containing fetched error messages.
	 *
	 */
	@Method(selector = "fetchLogsByError:offset:completionBlock:")
	public native void fetchLogsByError(int max, int offset, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Fetch log messages based on Fatal Level by paging.
	 *
	 * @param max
	 *            - Maximum number of records to be fetched
	 * @param offset
	 *            - From where the records are to be fetched
	 *
	 * @return Log object containing fetched Fatal messages.
	 *
	 */
	@Method(selector = "fetchLogsByFatal:offset:completionBlock:")
	public native void fetchLogsByFatal(int max, int offset, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Fetch count of log messages based on Date range
	 * 
	 * @param startDate
	 *            Start date from which the count of log messages have to be fetched
	 * @param endDate
	 *            End date upto which the count of log messages have to be fetched
	 * @return App42Response object containing count of fetched messages.
	 */
	@Method(selector = "fetchLogCountByDateRange:endDate:completionBlock:")
	public native void fetchLogCountByDateRange(NSDate startDate, NSDate endDate, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Fetch count of log messages based on Date range
	 *
	 * @param startDate
	 *            - Start date from which the count of log messages have to be
	 *            fetched
	 * @param endDate
	 *            - End date upto which the count of log messages have to be
	 *            fetched
	 *
	 * @return App42Response object containing count of fetched messages.
	 *
	 */
	@Method(selector = "fetchLogByDateRange:endDate:completionBlock:")
	public native void fetchLogByDateRange(NSDate startDate, NSDate endDate, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Fetch log messages based on Date range by paging.
	 *
	 * @param startDate
	 *            - Start date from which the log messages have to be fetched
	 * @param endDate
	 *            - End date upto which the log messages have to be fetched
	 *
	 * @param max
	 *            - Maximum number of records to be fetched
	 * @param offset
	 *            - From where the records are to be fetched
	 *
	 * @return Log object containing fetched messages
	 *
	 */
	@Method(selector = "fetchLogByDateRange:endDate:max:offset:completionBlock:")
	public native void fetchLogByDateRange(NSDate startDate, NSDate endDate, int max, int offset, @Block App42ResponseBlock completionBlock);

	/**
	 * Log event on App42 cloud for analytics purpose
	 * @param eventName
	 */
	@Method(selector = "setEventWithName:forModule:completionBlock:")
	public native void setEvent(String eventName, String moduleName, @Block App42ResponseBlock completionBlock);
	
	/**
	* Log event on App42 cloud for analytics purpose
	* @param eventName
	*/
	@Method(selector = "setEventWithName:completionBlock:")
	public native void setEvent(String eventName, @Block App42ResponseBlock completionBlock);
}
