//
//  Avatar.h
//  PAE_iOS_SDK
//
//  Created by Rajeev Ranjan on 20/11/13.
//  Copyright (c) 2013 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <Shephertz_App42_iOS_API/Shephertz_App42_iOS_API.h>
@interface Avatar : App42Response
{

}
@property(nonatomic,retain) NSString *userName;
@property(nonatomic,retain) NSString *name;
@property(nonatomic,retain) NSString *url;
@property(nonatomic,retain) NSString *tinyUrl;
@property(nonatomic,retain) NSString *description;
@property(nonatomic,retain) NSDate   *createdOn;
@property(nonatomic,assign) BOOL     isCurrent;

@end
