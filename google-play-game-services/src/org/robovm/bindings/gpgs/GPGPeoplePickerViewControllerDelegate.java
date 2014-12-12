package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSObjectProtocol;
import org.robovm.objc.annotation.Method;

public interface GPGPeoplePickerViewControllerDelegate extends NSObjectProtocol {

//@protocol GPGPeoplePickerViewControllerDelegate<NSObject>
//
// @required
//- (void)peoplePickerViewController:(GPGPeoplePickerViewController *)viewController
//                     didPickPeople:(NSArray *)people
//               autoPickPlayerCount:(int)autoPickPlayerCount;
//- (void)peoplePickerViewControllerDidCancel:(GPGPeoplePickerViewController *)controller;
	
 	@Method(selector = "peoplePickerViewController:didPickPeople:autoPickPlayerCount:")
	void peoplePickerViewController(GPGPeoplePickerViewController viewController, NSArray people, int autoPickPlayerCount);
	@Method(selector = "peoplePickerViewControllerDidCancel:")
	void didCancel(GPGPeoplePickerViewController controller);

}
