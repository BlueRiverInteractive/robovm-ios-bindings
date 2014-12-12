package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass()
public class GPGMultiplayerConfig extends NSObject {


@Property(selector = "exclusiveBitMask")
public native long getExclusiveBitMask();

@Property(selector = "invitedPlayerIds")
public native String getInvitedPlayerIDs();
@Property(selector = "setInvitedPlayerIDs:")
public native void setInvitedPlayerIDs (NSArray pIDs);

@Property(selector = "maxAutoMatchingPlayers")
public native int getMaxAutoMatchingPlayers();
@Property(selector = "setMaxAutoMatchingPlayers:", strongRef = true)
public native void setMaxAutoMatchingPlayers (int pMaxPlayers);

@Property(selector = "minAutoMatchingPlayers")
public native int getMinAutoMatchingPlayers();
@Property(selector = "setMinAutoMatchingPlayers:", strongRef = true)
public native void setMinAutoMatchingPlayers (int pMinPlayers);

@Property(selector = "variant")
public native int getVariant();

}
