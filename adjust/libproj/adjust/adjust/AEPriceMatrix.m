//
//  AEPriceMatrix.m
//  AEPriceMatrix
//
//  Created by Christian Wellenbrock on 04.03.14.
//  Copyright (c) 2014 adeven. All rights reserved.
//

#import "AEPriceMatrix.h"

#if !__has_feature(objc_arc)
#error AEPriceMatrix requires ARC
#endif

static NSDictionary *priceMatrix = nil;


@interface AEPriceMatrix(private)

+ (NSDictionary *)priceMatrix;
+ (int)findTierFor:(NSNumber *)value in:(NSArray *)array;
+ (int)findTierFor:(NSNumber *)value in:(NSArray *)array between:(int)low and:(int)high;

@end


#pragma mark -
@implementation AEPriceMatrix

+ (NSNumber *)convert:(NSNumber *)value from:(NSString *)currencyIn to:(NSString *)currencyOut {
    if (value == nil || currencyIn == nil || currencyOut == nil) {
        NSLog(@"AEPriceMatrix can't convert nil values and nil currencies");
        return nil;
    }
    if ([value compare:@0] == NSOrderedSame || [currencyIn isEqualToString:currencyOut]) {
        return value; // no conversion needed for zero and equal currencies
    }
    if (self.priceMatrix == nil) {
        NSLog(@"AEPriceMatrix couldn't find AEPriceMatrix.plist file");
        return nil;
    }

    NSArray *tiersIn  = [self.priceMatrix valueForKey:currencyIn];
    if (tiersIn == nil) {
        NSLog(@"AEPriceMatrix couldn't find prices for currency '%@'", currencyIn);
        return nil;
    }

    NSArray *tiersOut = [self.priceMatrix valueForKey:currencyOut];
    if (tiersOut == nil) {
        NSLog(@"AEPriceMatrix couldn't find prices for currency '%@'", currencyOut);
        return nil;
    }

    int tier = [self findTierFor:value in:tiersIn];

    NSNumber *valueIn  = [tiersIn  objectAtIndex:tier];
    if (valueIn == nil) {
        NSLog(@"AEPriceMatrix couldn't find tier %d for currency %@", tier, currencyIn);
        return nil;
    }

    NSNumber *valueOut = [tiersOut objectAtIndex:tier];
    if (valueOut == nil) {
        NSLog(@"AEPriceMatrix couldn't find tier %d for currency %@", tier, currencyOut);
        return nil;
    }

    return [NSNumber numberWithFloat:value.floatValue * valueOut.floatValue / valueIn.floatValue];
}

@end


#pragma mark -
@implementation AEPriceMatrix(private)

// lazily read price matrix from plist file
+ (NSDictionary *)priceMatrix {
    if (priceMatrix == nil) {
        NSBundle *bundle = [NSBundle mainBundle];
        NSString *path = [bundle pathForResource:@"AEPriceMatrix" ofType:@"plist"];
        priceMatrix = [NSDictionary dictionaryWithContentsOfFile:path];
    }
    return priceMatrix;
}

+ (int)findTierFor:(NSNumber *)value in:(NSArray *)array {
    int max = (int)array.count - 1;
    int tier = [self findTierFor:value in:array between:0 and:max];
    if (tier > max) {
        tier = max;
    }
    return tier;
}

// find lowest array index of element greater or equal to value with binary search
// return last index if value is greater than last element
+ (int)findTierFor:(NSNumber *)value in:(NSArray *)array between:(int)low and:(int)high {
    if (low > high) {
        return low;
    }
    int mid = (low + high) / 2;
    NSNumber *midValue = [array objectAtIndex:mid];
    switch ([value compare:midValue]) {
        case NSOrderedSame:
            return mid;
        case NSOrderedAscending:
            return [self findTierFor:value in:array between:low and:mid-1];
        case NSOrderedDescending:
            return [self findTierFor:value in:array between:mid+1 and:high];
    }
}

@end
