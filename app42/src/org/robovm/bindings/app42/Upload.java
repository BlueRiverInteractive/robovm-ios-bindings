package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSMutableArray;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class Upload extends App42Response
{
	@Property(selector = "fileListArray")
	public native NSMutableArray<?> getFileListArray();

	@Property(selector = "setFileListArray:", strongRef = true)
	public native void setFileListArray(NSMutableArray<?> fileListArray);
}
