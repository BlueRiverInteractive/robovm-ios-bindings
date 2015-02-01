//
//  ADJEvent.m
//  adjust
//
//  Created by Pedro Filipe on 15/10/14.
//  Copyright (c) 2014 adjust GmbH. All rights reserved.
//

#import "ADJEvent.h"
#import "ADJAdjustFactory.h"

#pragma mark -
@interface ADJEvent()
@property (nonatomic, retain) id<ADJLogger> logger;
@property (nonatomic, retain) NSMutableDictionary* callbackMutableParameters;
@property (nonatomic, retain) NSMutableDictionary* partnerMutableParameters;
@end

@implementation ADJEvent

+ (ADJEvent *)eventWithEventToken:(NSString *)eventToken {
    return [[ADJEvent alloc] initWithEventToken:eventToken];
}

- (id) initWithEventToken:(NSString *)eventToken {
    self = [super init];
    if (self == nil) return nil;

    self.logger     = ADJAdjustFactory.logger;

    if (![self checkEventToken:eventToken]) return nil;

    _eventToken = eventToken;

    return self;
}

- (void) addCallbackParameter:(NSString *)key
                        value:(NSString *)value
{
    if (![self isValidParameter:key
                  attributeType:@"key"
                  parameterName:@"Callback"]) return;

    if (![self isValidParameter:value
                  attributeType:@"value"
                  parameterName:@"Callback"]) return;

    if (self.callbackMutableParameters == nil) {
        self.callbackMutableParameters = [[NSMutableDictionary alloc] init];
    }

    if ([self.callbackMutableParameters objectForKey:key]) {
        [self.logger warn:@"key %@ will be overwritten", key];
    }

    [self.callbackMutableParameters setObject:value forKey:key];
}

- (void) addPartnerParameter:(NSString *)key
                       value:(NSString *)value {

    if (![self isValidParameter:key
                  attributeType:@"key"
                  parameterName:@"Partner"]) return;

    if (![self isValidParameter:value
                  attributeType:@"value"
                  parameterName:@"Partner"]) return;

    if (self.partnerMutableParameters == nil) {
        self.partnerMutableParameters = [[NSMutableDictionary alloc] init];
    }

    if ([self.partnerMutableParameters objectForKey:key]) {
        [self.logger warn:@"key %@ will be overwritten", key];
    }

    [self.partnerMutableParameters setObject:value forKey:key];
}

- (void) setRevenue:(double) amount currency:(NSString *)currency{
    NSNumber * revenue = [NSNumber numberWithDouble:amount];

    if (![self checkRevenue:revenue currency:currency]) return;

    _revenue = revenue;
    _currency = currency;
}

- (void) setTransactionId:(NSString *)transactionId {
    _transactionId = transactionId;
}

- (NSDictionary *) callbackParameters {
    return (NSDictionary *) self.callbackMutableParameters;
}

- (NSDictionary *) partnerParameters {
    return (NSDictionary *) self.partnerMutableParameters;
}

- (BOOL) checkEventToken:(NSString *)eventToken {
    if (eventToken == nil) {
        [self.logger error:@"Missing Event Token"];
        return NO;
    }

    if (eventToken.length != 6) {
        [self.logger error:@"Malformed Event Token '%@'", eventToken];
        return NO;
    }

    return YES;
}

- (BOOL) checkRevenue:(NSNumber*) revenue
             currency:(NSString*) currency
{
    if (revenue != nil) {
        double amount =  [revenue doubleValue];
        if (amount < 0.0) {
            [self.logger error:@"Invalid amount %.4f", amount];
            return NO;
        }

        if (currency == nil) {
            [self.logger error:@"Currency must be set with revenue"];
            return NO;
        }

        if ([currency isEqualToString:@""]) {
            [self.logger error:@"Currency is empty"];
            return NO;
        }
    } else {
        if (currency != nil) {
            [self.logger error:@"Revenue must be set with currency"];
            return NO;
        }
    }

    return YES;
}

- (BOOL) isValid {
    if (![self checkEventToken:self.eventToken]) return NO;
    if (![self checkRevenue:self.revenue currency:self.currency]) return NO;

    return YES;
}

- (BOOL) isValidParameter:(NSString *)attribute
            attributeType:(NSString *)attributeType
            parameterName:(NSString *)parameterName
{
    if (attribute == nil) {
        [self.logger error:@"%@ parameter %@ is missing", parameterName, attributeType];
        return NO;
    }

    if ([attribute isEqualToString:@""]) {
        [self.logger error:@"%@ parameter %@ is empty", parameterName, attributeType];
        return NO;
    }

    return YES;
}

-(id)copyWithZone:(NSZone *)zone
{
    ADJEvent* copy = [[[self class] allocWithZone:zone]
                      initWithEventToken:[self.eventToken copyWithZone:zone]];
    if (copy) {
        if (self.revenue != nil) {
            double amount = [[self.revenue copyWithZone:zone] doubleValue];
            [copy setRevenue:amount currency:[self.currency copyWithZone:zone]];
        }
        copy.callbackMutableParameters = [self.callbackMutableParameters copyWithZone:zone];
        copy.partnerMutableParameters = [self.partnerMutableParameters copyWithZone:zone];
        copy.transactionId = [self.transactionId copyWithZone:zone];
    }
    return copy;
}

@end
