//
//  ACL.h
//  PAE_iOS_SDK
//
//  Created by shephertz technologies on 30/04/13.
//  Copyright (c) 2013 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>

#define APP42_READ  @"R"
#define APP42_WRITE @"W"

@interface ACL : NSObject

@property(nonatomic,retain) NSString *_userName;
@property(nonatomic,retain) NSString *_permission;

-(id)initWithUserName:(NSString*)userName andPermission:(NSString*)permission;
-(NSString*)toString;
-(NSDictionary*)getACLParamsDict;
-(BOOL)equals:(id)object;

@end
