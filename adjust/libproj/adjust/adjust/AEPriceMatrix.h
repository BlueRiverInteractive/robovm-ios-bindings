//
//  AEPriceMatrix.h
//  AEPriceMatrix
//
//  Created by Christian Wellenbrock on 04.03.14.
//  Copyright (c) 2014 adeven. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface AEPriceMatrix : NSObject

+ (NSNumber *)convert:(NSNumber *)value from:(NSString *)currencyIn to:(NSString *)currencyOut;

@end

// string constants for available currency codes
static NSString * const kAECurrencyUSD = @"USD";
static NSString * const kAECurrencyCAD = @"CAD";
static NSString * const kAECurrencyMXN = @"MXN";
static NSString * const kAECurrencyAUD = @"AUD";
static NSString * const kAECurrencyNZD = @"NZD";
static NSString * const kAECurrencyJPY = @"JPY";
static NSString * const kAECurrencyEUR = @"EUR";
static NSString * const kAECurrencyCHF = @"CHF";
static NSString * const kAECurrencyNOK = @"NOK";
static NSString * const kAECurrencyGBP = @"GBP";
static NSString * const kAECurrencyDKK = @"DKK";
static NSString * const kAECurrencySEK = @"SEK";
static NSString * const kAECurrencyCNY = @"CNY";
static NSString * const kAECurrencySGD = @"SGD";
static NSString * const kAECurrencyHKD = @"HKD";
static NSString * const kAECurrencyTWD = @"TWD";
static NSString * const kAECurrencyRUB = @"RUB";
static NSString * const kAECurrencyTRY = @"TRY";
static NSString * const kAECurrencyINR = @"INR";
static NSString * const kAECurrencyIDR = @"IDR";
static NSString * const kAECurrencyILS = @"ILS";
static NSString * const kAECurrencyZAR = @"ZAR";
static NSString * const kAECurrencySAR = @"SAR";
static NSString * const kAECurrencyAED = @"AED";
