package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
@NativeClass()
public class GPGRealTimeReliableMessageResult extends NSObject {

//@property(nonatomic, readonly, retain) GPGRealTimeParticipant *participant;
//
//@property(nonatomic, readonly, assign) BOOL success;

	@Property(selector = "success")
	public native boolean isSuccess();
	@Property(selector = "participant")
	public native GPGRealTimeParticipant getParticipant();
	
}
