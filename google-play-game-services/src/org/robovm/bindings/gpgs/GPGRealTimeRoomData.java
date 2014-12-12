package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.foundation.NSString;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass()
public class GPGRealTimeRoomData extends NSObject {

//@property(nonatomic, readonly, retain) GPGMultiplayerConfig *config;
//
//@property(nonatomic, readonly, retain) GPGRealTimeRoomModifyDetails *creationDetails;
//
//@property(nonatomic, readonly, retain) NSArray *participants;
//
//@property(nonatomic, readonly, copy) NSString *roomDescription;
//
//@property(nonatomic, readonly, copy) NSString *roomID;
//
//@property(nonatomic, readonly, assign) GPGRealTimeRoomStatus status;


@Property(selector = "config")
public native GPGMultiplayerConfig getConfig();
@Property(selector = "creationDetails")
public native GPGRealTimeRoomModifyDetails getCreationDetails();
@Property(selector = "participants")
public native NSArray getParticipants();
@Property(selector = "roomDescription")
public native NSString getRoomDescription();
@Property(selector = "roomID")
public native NSString getRoomID();
@Property(selector = "status")
public native GPGRealTimeRoomStatus getStatus();


}
