package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.foundation.NSURL;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class GPGTurnBasedParticipant extends NSObject {

	@Property(selector = "displayName")
	public native String getDisplayName();
	
	@Property(selector = "imageUrl")
	public native NSURL getImageUrl();
	
	@Property(selector = "participantId")
	public native String getParticipantId();
	
	@Property(selector = "player")
	public native GPGPlayer getPlayer();
	
	@Property(selector = "status")
	public native GPGTurnBasedParticipantStatus getStatus();
}
