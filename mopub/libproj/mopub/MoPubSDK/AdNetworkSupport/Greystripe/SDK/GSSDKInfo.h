//
//  GSSDKInfo.h
//  SDK
//
//  Created by Justine DiPrete on 1/13/12.
//  Copyright 2013 Greystripe
//
//  Licensed under the Apache License, Version 2.0 (the "License");
//  you may not use this file except in compliance with the License.
//  You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
//  Unless required by applicable law or agreed to in writing, software
//  distributed under the License is distributed on an "AS IS" BASIS,
//  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//  See the License for the specific language governing permissions and
//  limitations under the License.
//

#import <Foundation/Foundation.h>
#import <CoreLocation/CoreLocation.h>

extern NSString * const kGSSDKVersion;

@interface GSSDKInfo : NSObject

/**
 * The hashed identifier of the device that is currently running the SDK.
 */
+ (NSString *)hashedDeviceId;

/**
 * This is a convenience method to set the global unique identifier for the application.
 * This method should be called before any view controller containing a GSBannerAd is
 * initialized if the delegate does not implement the greystripeGUID method. This can
 * only be set once. All subsequent attempts to set the GUID will be ignored.
 */
+ (void)setGUID:(NSString *)a_GUID;

/**
 * If the application is monitoring location updates, this method should be called
 * whenever the location manager gets an update. 
 */
+ (void)updateLocation:(CLLocation *)a_location;


@end
