//
//  Payment.h
//  PAE_iOS_SDK
//
//  Created by Shephertz Technology on 13/04/12.
//  Copyright (c) 2012 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "App42Response.h"
@class Cart;
/**
 *Payment class contain the member variables and allowed to be set and get.
 * 
 */

@interface Payment : NSObject{
    NSString *transactionId;
    NSString *status;
    NSDate *date;
    double totalAmount;
    Cart *cartObject;
}
/*!
 *set and get the transactionId for Payment Object 
 */
@property(nonatomic,retain)NSString *transactionId;
/*!
 *set and get the status for Payment Object 
 */
@property(nonatomic,retain)NSString *status;
/*!
 *set and get the date for Payment Object 
 */
@property(nonatomic,retain)NSDate *date;
/*!
 *set and get the totalAmount for Payment Object 
 */
@property(nonatomic,assign)double totalAmount;
/*!
 *set and get the cartObject for Payment Object 
 */
@property(nonatomic,retain)Cart *cartObject;

- (id) init __attribute__((unavailable));

-(id)initWithCart:(Cart*)cartObj;

@end
