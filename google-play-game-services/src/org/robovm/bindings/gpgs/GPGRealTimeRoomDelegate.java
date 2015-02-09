package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSData;
import org.robovm.apple.foundation.NSError;
import org.robovm.apple.foundation.NSObjectProtocol;
import org.robovm.objc.annotation.Method;

public interface GPGRealTimeRoomDelegate extends NSObjectProtocol {

	@Method(selector = "didAcceptRealTimeInviteForRoom:")
	void didAcceptRealTimeInvite(GPGRealTimeRoomData roomData);
	@Method(selector = "didDeclineRealTimeInviteForRoom:")
	void didDeclineRealTimeInvite(GPGRealTimeRoomData roomData);
	@Method(selector = "didReceiveRealTimeInviteForRoom:")
	void didReceiveRealTimeInvite(GPGRealTimeRoomData roomData);
	@Method(selector = "room:didChangeStatus:")
	void didChangeRoomStatus(GPGRealTimeRoom room, GPGRealTimeRoomStatus status);
 	@Method(selector = "room:didChangeConnectedSet:")
	void didChangeConnectedSet(GPGRealTimeRoom room, boolean connected);
 	@Method(selector = "room:participant:didChangeStatus:")
	void didChangeParticipentStatus(GPGRealTimeRoom room, GPGRealTimeParticipant participant, GPGRealTimeParticipantStatus status);
 	@Method(selector = "room:didReceiveData:fromParticipant:dataMode:")
	void didReceiveData(GPGRealTimeRoom room, NSData data, GPGRealTimeParticipant participant, GPGRealTimeDataMode dataMode);
 	@Method(selector = "room:didSendReliableId:results:")
	void didSendReliableId(GPGRealTimeRoom room, int reliableId, NSArray results); 	
 	@Method(selector = "room:didFailWithError:")
	void didFailWithError(GPGRealTimeRoom room, NSError error);

}
