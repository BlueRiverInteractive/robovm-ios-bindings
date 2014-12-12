package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.NotImplemented;

public class GPGPeoplePickerViewControllerDelegateAdapter extends NSObject implements GPGPeoplePickerViewControllerDelegate{


 	@NotImplemented("peoplePickerViewController:didPickPeople:autoPickPlayerCount:")
	public void peoplePickerViewController(GPGPeoplePickerViewController viewController, NSArray people, int autoPickPlayerCount) { throw new UnsupportedOperationException(); }
	@NotImplemented("peoplePickerViewControllerDidCancel:")
	public void didCancel(GPGPeoplePickerViewController controller) { throw new UnsupportedOperationException(); }

}
