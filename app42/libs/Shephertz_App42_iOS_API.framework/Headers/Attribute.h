//
//  Attribute.h
//  PAE_iOS_SDK
//
//  Created by Shephertz Technology on 04/04/12.
//  Copyright (c) 2012 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>
@class Session;

/**
 * An inner class that contains the remaining properties of the Session.
 *
 */
@interface Attribute : NSObject{
    Session *sessionObj;
    NSString *name;
    NSString *value;
}
/*!
 *set and get the userName for Attribute Object 
 */
@property(nonatomic,retain)Session *sessionObj;
/*!
 *set and get the name of the attribute. 
 */
@property(nonatomic,retain)NSString *name;
/*!
 *set and get the value of the session. 
 */
@property(nonatomic,retain)NSString *value;
/*!
 *set and get the attributeArray for Attribute Object which contains the 
 */
- (id) init __attribute__((unavailable));
-(id)initWithSession:(Session *)sessionObject;
@end
