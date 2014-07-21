//
//  IMIncentivisedDelegate.h
//  InMobi Monetization SDK
//
//  Copyright (c) 2013 InMobi. All rights reserved.
//

#import <Foundation/Foundation.h>
@class IMInterstitial;
@protocol IMIncentivisedDelegate <NSObject>

#pragma mark Incentivised action complete notification

/**
 * Sent when an incentivised ad action is complete.
 * @param ad The IMInterstitial instance which completed the incentivised action.
 * @param params The params returned to the publisher. These are setup by the publisher to be received when an incent action completes.
 */
- (void)incentivisedAd:(IMInterstitial *)ad didCompleteWithParams:(NSDictionary*)params;


@end
