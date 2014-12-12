
package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.foundation.NSURL;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
@NativeClass()
public class GPGLeaderboardMetadata extends NSObject {

	@Property(selector = "iconUrl")
	public native NSURL getIconUrl();
	
	@Property(selector = "iconleaderboardIdUrl")
	public native String getLeaderboardId();
	
	@Property(selector = "order")
	public native GPGLeaderboardOrder getOrder();
	
	@Property(selector = "title")
	public native String getTitle();
	
	@Method(selector = "allMetadataWithCompletionHandler:")
	public static native void allMetadataWithCompletionHandler(@Block GPGLeaderboardAllMetadataBlock completionHandler);
	
	@Method(selector = "allMetadataFromDataSource:completionHandler:")
	public static native void allMetadataFromDataSource(GPGDataSource dataSource, @Block GPGLeaderboardAllMetadataBlock completionHandler);
	
	@Method(selector = "metadataForLeaderboardId:completionHandler:")
	public static native void allMetadataWithCompletionHandler(String leaderboardId, @Block GPGLeaderboardMetadataBlock completionHandler);
	
  	@Method(selector = "metadataForLeaderboardId:dataSource:completionHandler:")
	public static native void allMetadataFromDataSource(String leaderboardId, GPGDataSource dataSource, @Block GPGLeaderboardAllMetadataBlock completionHandler);
}
