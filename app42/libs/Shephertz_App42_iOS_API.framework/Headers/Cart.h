//
//  Cart.h
//  App42_iOS_SERVICE_APIs
//
//  Created by shephertz technologies on 14/02/12.
//  Copyright (c) 2012 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "App42Response.h"
@class Payment;

/**
 *
 * This Cart object is the value object which contains the properties of Cart
 * along with the setter & getter for those properties.
 *
 */


@interface Cart : App42Response{
    
    NSString *userName;
    NSString *cartId;
    NSDate *creationTime;
    NSDate *checkOutTime;
    NSString *state;
    BOOL isEmpty;
    NSString *cartSession;
    double totalAmount;
    NSMutableArray *itemListArray;
    Payment *payemntObj;
}
/*!
 *set and get the user name for the User.
 */
@property(nonatomic,retain)NSString *userName;
/*!
 *set and get the cartId for the User. 
 */
@property(nonatomic,retain)NSString *cartId;
/*!
 *set and get the creation time of the cart.
 */
@property(nonatomic,retain)NSDate *creationTime;
/*!
 *set and get the check out time of cart. 
 */
@property(nonatomic,retain)NSDate *checkOutTime;
/*!
 *set and get the state of the cart. 
 */
@property(nonatomic,retain)NSString *state;
/*!
 *set and get true or false as per the cart information whether it's empty or
 * not.
 *
 * @return true if cart is empty, false if cart is not empty.
 */
@property(nonatomic,assign)BOOL isEmpty;
/*!
 *set and get the cartSession for the Cart. 
 */
@property(nonatomic,retain)NSString *cartSession;
/*!
 *set and get the total amount of cart. 
 */
@property(nonatomic,assign)double totalAmount;
/*!
 *set and get the list of all the items in the cart.
 */
@property(nonatomic,retain)NSMutableArray *itemListArray;
/*!
 *set and get the payment of the Cart.
 *
 */
@property(nonatomic,retain)Payment *paymentObj;
@end
