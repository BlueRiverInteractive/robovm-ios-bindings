package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSError;
import org.robovm.apple.foundation.NSObjectProtocol;
import org.robovm.objc.annotation.Method;

public interface GPGTurnBasedMatchDelegate extends NSObjectProtocol {

	@Method(selector = "didReceiveTurnBasedInviteForMatch:participant:fromPushNotification:")
	void didReceiveTurnBasedInviteForMatch(GPGTurnBasedMatch match, GPGTurnBasedParticipant participant, boolean fromPushNotification);

	@Method(selector = "didReceiveTurnEventForMatch:participant:fromPushNotification:")
	void didReceiveTurnEventForMatch(GPGTurnBasedMatch match, GPGTurnBasedParticipant participant, boolean fromPushNotification);

	@Method(selector = "matchEnded:participant:fromPushNotification:")
	void matchEnded(GPGTurnBasedMatch match, GPGTurnBasedParticipant participant, boolean fromPushNotification);

	@Method(selector = "failedToProcessMatchUpdate:error:")
	void failedToProcessMatchUpdate(GPGTurnBasedMatch match, NSError error);
}
