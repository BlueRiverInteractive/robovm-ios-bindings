//
//  Friends.h
//  PAE_iOS_SDK
//
//  Created by shephertz technologies on 30/04/13.
//  Copyright (c) 2013 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface Friends : NSObject

@property(nonatomic,retain) NSString    *name;
@property(nonatomic,retain) NSString    *picture;
@property(nonatomic,retain) NSString    *friendId;
@property(nonatomic,assign) BOOL        installed;

@end
