package org.robovm.bindings.gpgs;

import org.robovm.apple.uikit.UINavigationController;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
@NativeClass()
public class GPGPeoplePickerViewController extends UINavigationController {


@Property(selector = "maxPlayersToPick")
public native int getMaxPlayersToPick();
@Property(selector = "setMaxPlayersToPick:", strongRef = true)
public native void setMaxPlayersToPick (int pMaxPlayers);

@Property(selector = "minPlayersToPick")
public native int getMinPlayersToPick();
@Property(selector = "setMinPlayersToPick:", strongRef = true)
public native void setMinPlayersToPick (int pMinPlayers);

@Property(selector = "peoplePickerDelegate")
public native GPGPeoplePickerViewControllerDelegate getPeoplePickerDelegate();
@Property(selector = "setPeoplePickerDelegate:", strongRef = true)
public native void setPeoplePickerDelegate (GPGPeoplePickerViewControllerDelegate pPlayerPickerDelegate);

}
