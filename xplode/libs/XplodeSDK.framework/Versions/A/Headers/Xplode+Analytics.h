//  Copyright (c) 2014 Iddiction, Inc. All rights reserved.

#import "Xplode.h"

@interface Xplode (Analytics)

///---------------------
/// @name Custom analytics events
///---------------------

/// Logs an event.
///
/// @param eventName Name of the event.
+ (void)logEvent:(NSString *)eventName;

/// Logs an event with custom parameters.
///
/// @param eventName  Name of the event.
/// @param parameters A key-value dictionary with parameters.
+ (void)logEvent:(NSString *)eventName
  withParameters:(NSDictionary *)parameters;

@end
