//
//  MPHTMLInterstitialCustomEvent.h
//  MoPub
//
//  Copyright (c) 2013 MoPub. All rights reserved.
//

#import "MPInterstitialCustomEvent.h"
#import "MPHTMLInterstitialViewController.h"
#import "MPPrivateInterstitialCustomEventDelegate.h"

@interface MPHTMLInterstitialCustomEvent : MPInterstitialCustomEvent <MPInterstitialViewControllerDelegate>

@property (nonatomic, weak) id<MPPrivateInterstitialCustomEventDelegate> delegate;

@end
