package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSData;
import org.robovm.apple.foundation.NSNumber;
import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass()
public class GPGRealTimeRoom extends NSObject {

	@Property(selector = "config")
	public native GPGMultiplayerConfig getConfig();
	@Property(selector = "participants")
	public native NSArray getParticipants();
	@Property(selector = "connectedParticipants")
	public native NSArray getConnectedParticipants();
	@Property(selector = "localParticipant")
	public native GPGRealTimeParticipant getLocalParticipant();
	@Property(selector = "roomDescription")
	public native String getRoomDescription();
	@Property(selector = "roomID")
	public native String getRoomID();
	@Property(selector = "inConnectedSet")
	public native boolean isInConnectedSet();
	@Property(selector = "creationDetails")
	public native GPGRealTimeRoomModifyDetails getCreationDetails();
	@Property(selector = "status")
	public native GPGRealTimeRoomStatus getStatus();
	@Property(selector = "waitEstimateSeconds")
	public native NSNumber getWaitEstimateSeconds();

	@Method(selector = "findParticipantById:")
	public native GPGRealTimeParticipant findParticipant(String participantId);
	@Method(selector = "enumerateParticipantsUsingBlock:")
	public native void enumerateParticipantsUsingBlock(@Block GPGRealTimeParticipantIterator iterator);
	@Method(selector = "enumerateOtherParticipantsUsingBlock:")
	public native void enumerateOtherParticipantsUsingBlock(@Block GPGRealTimeParticipantIterator iterator);
	@Method(selector = "enumerateConnectedParticipantsUsingBlock:")
	public native void enumerateConnectedParticipantsUsingBlock(@Block GPGRealTimeParticipantIterator iterator);
	@Method(selector = "sendReliableData:")
	public native int sendReliableData(NSData data, NSArray participants);
	@Method(selector = "sendUnreliableData:toParticipants:")
	public native void sendUnreliableData(NSData data, NSArray participants);
	@Method(selector = "sendReliableDataToAll:")
	public native int sendReliableDataToAll(NSData data);
	@Method(selector = "sendUnreliableDataToAll:")
	public native void sendUnreliableDataToAll(NSData data);
	@Method(selector = "sendReliableDataToOthers:")
	public native int sendReliableDataToOthers(NSData data);
	@Method(selector = "sendUnreliableDataToOthers:")
	public native void sendUnreliableDataToOthers(NSData data);
	@Method(selector = "leave")
	public native void leave();
	
}
