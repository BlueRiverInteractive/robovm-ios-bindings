//
// Google Play Games Platform Services
// Copyright 2013 Google Inc. All rights reserved.
//

#import <UIKit/UIKit.h>

@class GPGMultiplayerConfig;
@protocol GPGPeoplePickerViewControllerDelegate;

@interface GPGPeoplePickerViewController : UINavigationController

@property(nonatomic, assign) int minPlayersToPick;

@property(nonatomic, assign) int maxPlayersToPick;

@property(nonatomic, assign) id<GPGPeoplePickerViewControllerDelegate> peoplePickerDelegate;

@end

@protocol GPGPeoplePickerViewControllerDelegate<NSObject>

 @required
- (void)peoplePickerViewController:(GPGPeoplePickerViewController *)viewController
                     didPickPeople:(NSArray *)people
               autoPickPlayerCount:(int)autoPickPlayerCount;

- (void)peoplePickerViewControllerDidCancel:(GPGPeoplePickerViewController *)controller;

@end
