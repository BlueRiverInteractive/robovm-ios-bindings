//
//  PreferenceData.h
//  PAE_iOS_SDK
//
//  Created by shephertz technologies on 11/07/12.
//  Copyright (c) 2012 ShephertzTechnology PVT LTD. All rights reserved.
//

#import "App42Response.h"
/**
 *
 * This PreferenceData object is the value object which contains the properties
 * of PreferenceData along with the setter & getter for those properties.
 *
 */
@interface PreferenceData : App42Response{
    
    NSString *userId;
    NSString *itemId;
    NSString *preference;
}
/*!
 *set and get the userId of a particular User.
 */
@property(nonatomic,retain)NSString *userId;
/*!
 *set and get the itemId for a particular Preference Data file.
 */
@property(nonatomic,retain)NSString *itemId;
/*!
 *set and get the preference for Preference Data File.
 */
@property(nonatomic,retain)NSString *preference;


@end
