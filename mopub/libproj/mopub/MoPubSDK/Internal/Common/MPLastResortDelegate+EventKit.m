//
//  MPLastResortDelegate+EventKit.m
//  MoPub
//
//  Copyright (c) 2014 MoPub. All rights reserved.
//

#import "MPLastResortDelegate+EventKit.h"
#import "MPGlobal.h"
#import "UIViewController+MPAdditions.h"


@implementation MPLastResortDelegate (EventKit)

- (void)eventEditViewController:(EKEventEditViewController *)controller didCompleteWithAction:(EKEventEditViewAction)action
{
    [controller mp_dismissModalViewControllerAnimated:MP_ANIMATED];
}

@end
