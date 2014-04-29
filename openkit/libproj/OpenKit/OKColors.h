//
//  OKColors.h
//  OpenKit
//
//  Created by Suneet Shah on 6/25/13.
//  Copyright (c) 2013 OpenKit. All rights reserved.
//

#import <Foundation/Foundation.h>

#define UIColorFromRGB(rgbValue) [UIColor colorWithRed:((float)((rgbValue & 0xFF0000) >> 16))/255.0 green:((float)((rgbValue & 0xFF00) >> 8))/255.0 blue:((float)(rgbValue & 0xFF))/255.0 alpha:1.0]

@interface OKColors : NSObject

//+(UIColor*)navbarTextColor;
//+(UIColor*)navbarTintColor;
//+(NSDictionary*)titleTextAttributesForNavBarButton;
//+(UIColor*)playerTopScoreBGColor;
//+(UIColor*)scoreCellBGColor;

+(UIColor*)defaultBGColor;

@end

