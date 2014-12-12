package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSData;
import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.foundation.NSURL;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class GPGSnapshotMetadata extends NSObject {

	@Property(selector = "fileName")
	public native String getFileName();
	
	@Property(selector = "snapshotDescription")
	public native String getSnapshotDescription();
	
	@Property(selector = "lastModifiedTimestamp")
	public native long getLastModifiedTimestamp();
	
	@Property(selector = "playedTime")
	public native long getPlayedTime();
	
	@Property(selector = "coverImageUrl")
	public native NSURL getCoverImageUrl();
	
	@Property(selector = "isOpen")
	public native boolean isOpen();

	@Method(selector = "listWithCompletionHandler:")
	public static native void listWithCompletionHandler(@Block GPGSnapshotListBlock completionHandler);
	
  	@Method(selector = "openWithFileName:conflictPolicy:completionHandler:")
	public static native void openWithFileName(String fileName, GPGSnapshotConflictPolicy conflictPolicy, @Block GPGSnapshotOpenBlock completionHandler);
	          
	@Method(selector = "commitWithMetadataChange:data:completionHandler:")
	public native void listWithCompletionHandler(GPGSnapshotMetadataChange metadataChange, NSData data, @Block GPGSnapshotCommitBlock completionHandler);
	                            
 	@Method(selector = "resolveWithMetadataChange:conflictId:data:completionHandler:")
	public native void resolveWithMetadataChange(GPGSnapshotMetadataChange metadataChange, String conflictId, NSData data, @Block GPGSnapshotCommitBlock completionHandler);                             
 	
	@Method(selector = "readWithCompletionHandler:")
	public native void readWithCompletionHandler(@Block GPGSnapshotReadBlock completionHandler);
    
	@Method(selector = "deleteWithCompletionHandler:")
	public native void deleteWithCompletionHandler(@Block GPGSnapshotDeleteBlock completionHandler);
}
