package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSData;
import org.robovm.apple.foundation.NSNumber;
import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
@NativeClass()
public class GPGAppStateModel extends NSObject {

	@Method(selector = "setStateData:forKey:")
	public native void setStateData(NSData state, NSNumber key);
	@Method(selector = "stateDataForKey:")
	public native NSData setStateData(NSNumber key);
	@Method(selector = "listStatesWithCompletionHandler:conflictHandler:")
	public native void listStates(@Block GPGAppStateListHandler completionHandler, @Block GPGAppStateConflictHandler conflictHandler);
	@Method(selector = "listStateKeysWithCompletionHandler:")
	public native void listStateKeys(@Block GPGAppStateListKeysHandler completionHandler);
	@Method(selector = "loadForKey:completionHandler:conflictHandler:")
	public native void load(NSNumber key, @Block GPGAppStateLoadResultHandler completionHandler, @Block GPGAppStateConflictHandler conflictHandler);
	@Method(selector = "updateForKey:completionHandler:conflictHandler:")
	public native void update(NSNumber key, @Block GPGAppStateWriteResultHandler completionHandler, @Block GPGAppStateConflictHandler conflictHandler);
	@Method(selector = "clearForKey:completionHandler:conflictHandler:")
	public native void clear(NSNumber key, @Block GPGAppStateWriteResultHandler completionHandler, @Block GPGAppStateConflictHandler conflictHandler);
	@Method(selector = "updateForKey:completionHandler:")
	public native void delete(NSNumber key, @Block GPGAppStateWriteResultHandler completionHandler);
	
}
