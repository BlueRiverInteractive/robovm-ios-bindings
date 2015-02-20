//
//  Configurations.h
//  PAE_iOS_SDK
//
//  Created by Shephertz Technology on 10/04/12.
//  Copyright (c) 2012 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>
@class Email;
/**
 * An inner class that contains the remaining properties of the Cart.
 *
 */
@interface Configurations : NSObject {
    Email *emailObj;
    NSString *emailId;
    NSString *host;
    int port;
    BOOL ssl;
}
/*!
 *set and get the emailObj for Email Object 
 */
@property(nonatomic,retain)Email *emailObj;
/*!
 *set and get the emailId of the User.
 */
@property(nonatomic,retain)NSString *emailId;
/*!
 *set and get the host of the Email.
 */
@property(nonatomic,retain)NSString *host;
/*!
 *set and get the port of the Email.
 */
@property(nonatomic,assign)int port;
/*!
 *set and get the ssl of the Email. 
 */
@property(assign)BOOL ssl;
- (id) init __attribute__((unavailable));
-(id)initWithEmail:(Email *)emailObj;
//-(void)setPort:(int)port;

@end

