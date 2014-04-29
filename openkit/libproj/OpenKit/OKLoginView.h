//
//  OKLoginView.h
//  OKClient
//
//  Created by Suneet Shah on 2/4/13.
//  Copyright (c) 2013 Suneet Shah. All rights reserved.
//

#import <Foundation/Foundation.h>

typedef void(^OKLoginViewCompletionHandler)(void);

@interface OKLoginView : NSObject

-(void)showWithCompletionHandler:(OKLoginViewCompletionHandler)block;
-(void)show;
-(id)initWithLoginString:(NSString*)loginString;


@end
