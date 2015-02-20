//
//  LogService.h
//  App42_iOS_SERVICE_APIs
//
//  Created by shephertz technologies on 13/02/12.
//  Copyright (c) 2012 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "App42Service.h"
/**
 * Centralize logging for your App. This service allows different levels e.g.
 * info, debug, fatal, error etc. to log a message and query the messages based
 * on different parameters. You can fetch logs based on module, level, message,
 * date range etc.
 *
 * @see Log
 *
 */
@interface LogService : App42Service
{
    
}

-(id)init __attribute__((unavailable));
-(id)initWithAPIKey:(NSString *)apiKey  secretKey:(NSString *)secretKey;

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
-(void)info:(NSString *)msg module:(NSString*)module completionBlock:(App42ResponseBlock)completionBlock;
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
-(void)debug:(NSString *)msg module:(NSString*)module completionBlock:(App42ResponseBlock)completionBlock;
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
-(void)fatal:(NSString *)msg module:(NSString*)module completionBlock:(App42ResponseBlock)completionBlock;
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
-(void)error:(NSString *)msg module:(NSString*)module completionBlock:(App42ResponseBlock)completionBlock;
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
-(void)fetchLogsCountByModule:(NSString*)moduleName completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Fetch the log messages based on the Module
 *
 * @param moduleName
 *            - Module name for which the messages has to be fetched
 *
 * @return Log object containing fetched messages.
 *
 */
-(void)fetchLogsByModule:(NSString*)moduleName completionBlock:(App42ResponseBlock)completionBlock;
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
-(void)fetchLogsByModule:(NSString*)moduleName max:(int)max offset:(int)offset completionBlock:(App42ResponseBlock)completionBlock;
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
-(void)fetchLogsCountByModuleAndText:(NSString*)moduleName text:(NSString*)text completionBlock:(App42ResponseBlock)completionBlock;
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
-(void)fetchLogsByModuleAndText:(NSString*)moduleName text:(NSString*)text completionBlock:(App42ResponseBlock)completionBlock;
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
-(void)fetchLogsByModuleAndText:(NSString*)moduleName text:(NSString*)text max:(int)max offset:(int)offset completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Fetch count of log messages based on Info Level
 *
 * @return App42Response object containing count of fetched info messages.
 *
 */
-(void)fetchLogsCountByInfo:(App42ResponseBlock)completionBlock;
/**
 * Fetch count of log messages based on Debug Level
 *
 * @return App42Response object containing count of fetched debug messages.
 *
 */
-(void)fetchLogsCountByDebug:(App42ResponseBlock)completionBlock;
/**
 * Fetch count of log messages based on Error Level
 *
 * @return App42Response object containing count of fetched error messages.
 *
 */
-(void)fetchLogsCountByError:(App42ResponseBlock)completionBlock;
/**
 * Fetch count of log messages based on Fatal Level
 *
 * @return App42Response object containing count of fetched Fatal messages.
 *
 */
-(void)fetchLogsCountByFatal:(App42ResponseBlock)completionBlock;

/**
 * Fetch log messages based on Info Level
 *
 * @return Log object containing fetched info messages.
 *
 */
-(void)fetchLogsByInfo:(App42ResponseBlock)completionBlock;
/**
 * Fetch log messages based on Debug Level
 *
 * @return Log object containing fetched debug messages
 *
 */
-(void)fetchLogsByDebug:(App42ResponseBlock)completionBlock;
/**
 * Fetch log messages based on Error Level
 *
 * @return Log object containing fetched error messages
 *
 */
-(void)fetchLogsByError:(App42ResponseBlock)completionBlock;
/**
 * Fetch log messages based on Fatal Level
 *
 * @return Log object containing fetched Fatal messages
 *
 */
-(void)fetchLogsByFatal:(App42ResponseBlock)completionBlock;
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
-(void)fetchLogsByInfo:(int)max offset:(int)offset completionBlock:(App42ResponseBlock)completionBlock;
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
-(void)fetchLogsByDebug:(int)max offset:(int)offset completionBlock:(App42ResponseBlock)completionBlock;
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
-(void)fetchLogsByError:(int)max offset:(int)offset completionBlock:(App42ResponseBlock)completionBlock;
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
-(void)fetchLogsByFatal:(int)max offset:(int)offset completionBlock:(App42ResponseBlock)completionBlock;
/**
 * Fetch count of log messages based on Date range
 * 
 * @param startDate
 *            Start date from which the count of log messages have to be fetched
 * @param endDate
 *            End date upto which the count of log messages have to be fetched
 * @return App42Response object containing count of fetched messages.
 */
-(void)fetchLogCountByDateRange:(NSDate*)startDate endDate:(NSDate*)endDate completionBlock:(App42ResponseBlock)completionBlock;
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
-(void)fetchLogByDateRange:(NSDate*)startDate endDate:(NSDate*)endDate completionBlock:(App42ResponseBlock)completionBlock;
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
-(void)fetchLogByDateRange:(NSDate*)startDate endDate:(NSDate*)endDate max:(int)max offset:(int)offset completionBlock:(App42ResponseBlock)completionBlock;


/**
 * Log event on App42 cloud for analytics purpose
 * @param eventName
 */
-(void)setEventWithName:(NSString*)eventName forModule:(NSString*)moduleName completionBlock:(App42ResponseBlock)completionBlock;
/**
* Log event on App42 cloud for analytics purpose
* @param eventName
*/
-(void)setEventWithName:(NSString*)eventName completionBlock:(App42ResponseBlock)completionBlock;

@end
