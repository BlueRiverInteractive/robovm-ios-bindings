package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSData;
import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.foundation.NSURL;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;
import org.robovm.rt.bro.annotation.Library;

@NativeClass()
public class GPGRealTimeParticipant extends NSObject {

	@Property(selector = "canCommunicate")
	public native boolean canCommunicate();
	@Property(selector = "avatarUrl")
	public native NSURL getAvatarUrl();
	@Property(selector = "displayName")
	public native String getDisplayName();
	@Property(selector = "participantId")
	public native String getParticipantID();
	@Property(selector = "isAutoMatchedPlayer")
	public native boolean isAutoMatchedPlayer();
	@Property(selector = "isLocalParticipant")
	public native boolean isLocalParticipant();
	@Property(selector = "status")
	public native GPGRealTimeParticipantStatus getStatus();

	@Method(selector = "sendUnreliableData:")
	public native void sendUnreliableData(NSData data);
	@Method(selector = "sendReliableData:")
	public native int sendReliableData(NSData data);
	
}
