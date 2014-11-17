//
//  xplode.h
//  xplode
//
//  Created by Sargis Sargsyan on 11/17/14.
//
//

#import <Foundation/Foundation.h>

@interface Xplode : NSObject
+ (void)initializeWithAppHandle:(NSString *)appHandle
                      appSecret:(NSString *)appSecret;
+ (void)presentPromotionForBreakpoint:(NSString *)breakpoint;
@end
