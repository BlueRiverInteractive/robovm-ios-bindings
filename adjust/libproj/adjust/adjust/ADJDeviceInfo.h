//
//  ADJDeviceInfo.h
//  adjust
//
//  Created by Pedro Filipe on 17/10/14.
//  Copyright (c) 2014 adjust GmbH. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface ADJDeviceInfo : NSObject<NSCopying>

@property (nonatomic, copy) NSString *macSha1;
@property (nonatomic, copy) NSString *macShortMd5;
@property (nonatomic, copy) NSString *idForAdvertisers;
@property (nonatomic, copy) NSString *fbAttributionId;
@property (nonatomic, assign) BOOL trackingEnabled;
@property (nonatomic, copy) NSString *vendorId;
@property (nonatomic, copy) NSString *pushToken;
@property (nonatomic, copy) NSString *clientSdk;
@property (nonatomic, copy) NSString *bundeIdentifier;
@property (nonatomic, copy) NSString *bundleVersion;
@property (nonatomic, copy) NSString *deviceType;
@property (nonatomic, copy) NSString *deviceName;
@property (nonatomic, copy) NSString *osName;
@property (nonatomic, copy) NSString *systemVersion;
@property (nonatomic, copy) NSString *languageCode;
@property (nonatomic, copy) NSString *countryCode;
@property (nonatomic, copy) NSString *networkType;
@property (nonatomic, copy) NSString *mobileCountryCode;
@property (nonatomic, copy) NSString *mobileNetworkCode;

- (id) initWithSdkPrefix:(NSString *)sdkPrefix;
+ (ADJDeviceInfo *)deviceInfoWithSdkPrefix:(NSString *)sdkPrefix;

@end
