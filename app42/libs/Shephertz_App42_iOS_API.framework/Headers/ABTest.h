//
//  ABTest.h
//  PAE_iOS_SDK
//
//  Created by Rajeev Ranjan on 17/10/13.
//  Copyright (c) 2013 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Shephertz_App42_iOS_API/Shephertz_App42_iOS_API.h>

@interface ABTest : App42Response

@property(nonatomic,assign) BOOL isActive;
@property(nonatomic,retain) NSString *name;
@property(nonatomic,retain) NSString *type;
@property(nonatomic,retain) NSMutableArray *variantList;

@end
