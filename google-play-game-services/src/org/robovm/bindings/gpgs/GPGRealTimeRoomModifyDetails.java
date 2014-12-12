package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
@NativeClass()
public class GPGRealTimeRoomModifyDetails extends NSObject {

//@property(nonatomic, readonly, assign) long long lastUpdateTimestamp;
//
//@property(nonatomic, readonly, retain) GPGRealTimeParticipant *participant;

	@Property(selector = "lastUpdateTimestamp")
	public native long getLastUpdateTimestamp();
	@Property(selector = "participant")
	public native GPGRealTimeParticipant getParticipant();
	
	
}
