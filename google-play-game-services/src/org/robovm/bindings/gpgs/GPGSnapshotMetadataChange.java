package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class GPGSnapshotMetadataChange extends NSObject {

	@Property(selector = "snapshotDescription")
	public native String getSnapshotDescription();
	
	@Property(selector = "setSnapshotDescription:", strongRef = true)
	public native void setSnapshotDescription(String snapshotDescription);
	
	@Property(selector = "playedTime")
	public native long getPlayedTime();
	
	@Property(selector = "setPlayedTime:", strongRef = true)
	public native void setPlayedTime(long playedTime);

	@Property(selector = "coverImage")
	public native GPGSnapshotMetadataChangeCoverImage getCoverImage();
	
	@Property(selector = "setCoverImage:", strongRef = true)
	public native void setCoverImage(GPGSnapshotMetadataChangeCoverImage coverImage);
}
