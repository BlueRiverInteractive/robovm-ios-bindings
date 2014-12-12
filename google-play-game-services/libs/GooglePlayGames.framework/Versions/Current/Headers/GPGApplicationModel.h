//
// Google Play Games Platform Services
// Copyright 2013 Google Inc. All rights reserved.
//
#import "GPGKeyedModel.h"

@class GPGAppStateModel;

extern NSString *const GPGModelGetAllAppStateKey;

__attribute__ ((deprecated))
@interface GPGApplicationModel : GPGKeyedModel

// Designated initializer
- (instancetype)initWithApplicationId:(NSString *)applicationId;

#pragma mark Models 
// Models
@property(nonatomic, readonly, strong) GPGAppStateModel *appState __attribute__((deprecated));

@end

