package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSData;
import org.robovm.apple.foundation.NSError;
import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.NotImplemented;

public class GPGRealTimeRoomDelegateAdapter extends NSObject implements GPGRealTimeRoomDelegate{

	
	@NotImplemented("didAcceptRealTimeInviteForRoom:")
	public void didAcceptRealTimeInvite(GPGRealTimeRoomData roomData){ throw new UnsupportedOperationException(); }
	@NotImplemented("didDeclineRealTimeInviteForRoom:")
	public void didDeclineRealTimeInvite(GPGRealTimeRoomData roomData){ throw new UnsupportedOperationException(); }
	@NotImplemented("didReceiveRealTimeInviteForRoom:")
	public void didReceiveRealTimeInvite(GPGRealTimeRoomData roomData){ throw new UnsupportedOperationException(); }
	@NotImplemented("room:didChangeStatus:")
	public void didChangeRoomStatus(GPGRealTimeRoom room, GPGRealTimeRoomStatus status){ throw new UnsupportedOperationException(); }
 	@NotImplemented("room:didChangeConnectedSet:")
	public void didChangeConnectedSet(GPGRealTimeRoom room, boolean connected){ throw new UnsupportedOperationException(); }
 	@NotImplemented("room:participant:didChangeStatus:")
	public void didChangeParticipentStatus(GPGRealTimeRoom room, GPGRealTimeParticipant participant, GPGRealTimeParticipantStatus status){ throw new UnsupportedOperationException(); }
 	@NotImplemented("room:didReceiveData:fromParticipant:dataMode:")
	public void didReceiveData(GPGRealTimeRoom room, NSData data, GPGRealTimeParticipant participant, GPGRealTimeDataMode dataMode){ throw new UnsupportedOperationException(); }
 	@NotImplemented("room:didSendReliableId:results:")
	public void didSendReliableId(GPGRealTimeRoom room, int reliableId, NSArray results){ throw new UnsupportedOperationException(); }
 	@NotImplemented("room:didFailWithError:")
	public void didFailWithError(GPGRealTimeRoom room, NSError error){ throw new UnsupportedOperationException(); }
}
