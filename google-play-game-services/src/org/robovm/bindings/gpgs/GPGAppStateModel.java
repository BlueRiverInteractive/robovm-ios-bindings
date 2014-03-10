
package org.robovm.bindings.gpgs;

import org.robovm.bindings.other.NSData;
import org.robovm.cocoatouch.foundation.NSNumber;
import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.objc.ObjCBlock;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
@NativeClass()
public class GPGAppStateModel extends NSObject {
	private static final ObjCClass objCClass = ObjCClass.getByType(GPGAppStateModel.class);

	static {
		ObjCRuntime.bind(GPGAppStateModel.class);
	}

	// - (void)setStateData:(NSData *)state forKey:(NSNumber *)key;
	private static final Selector setStateData$ = Selector.register("setStateData:forKey:");

	@Bridge
	private native static void objc_setStateData (GPGAppStateModel __self__, Selector __cmd__, NSData state, NSNumber key);

	public void setStateData (NSData state, int key) {
		objc_setStateData(this, setStateData$, state, NSNumber.valueOf(key));
	}

	// - (NSData *)stateDataForKey:(NSNumber *)key;
	private static final Selector stateDataForKey$ = Selector.register("stateDataForKey:");

	@Bridge
	private native static NSData objc_stateDataForKey (GPGAppStateModel __self__, Selector __cmd__, NSNumber key);

	public NSData stateDataForKey (int key) {
		return objc_stateDataForKey(this, stateDataForKey$, NSNumber.valueOf(key));
	}

	// - (void)listStatesWithCompletionHandler:(GPGAppStateListHandler)completionHandler
// conflictHandler:(GPGAppStateConflictHandler)conflictHandler;
	private static final Selector listStatesWithCompletionHandler$ = Selector
		.register("listStatesWithCompletionHandler:conflictHandler:");

	@Bridge
	private native static void objc_listStatesWithCompletionHandler (GPGAppStateModel __self__, Selector __cmd__,
		ObjCBlock completionHandler, ObjCBlock conflictHandler);

	public void listStatesWithCompletionHandler (GPGAppStateListHandler completionHandler,
		GPGAppStateConflictHandler conflictHandler) {
		objc_listStatesWithCompletionHandler(this, listStatesWithCompletionHandler$,
			GPGAppStateListHandler.Marshaler.toObjCBlock(completionHandler),
			GPGAppStateConflictHandler.Marshaler.toObjCBlock(conflictHandler));
	}

	// - (void)listStateKeysWithCompletionHandler:(GPGAppStateListKeysHandler)completionHandler;
	private static final Selector listStateKeysWithCompletionHandler$ = Selector.register("listStateKeysWithCompletionHandler:");

	@Bridge
	private native static void objc_listStateKeysWithCompletionHandler (GPGAppStateModel __self__, Selector __cmd__,
		ObjCBlock completionHandler);

	public void listStateKeysWithCompletionHandler (GPGAppStateListKeysHandler completionHandler) {
		objc_listStateKeysWithCompletionHandler(this, listStateKeysWithCompletionHandler$,
			GPGAppStateListKeysHandler.Marshaler.toObjCBlock(completionHandler));
	}

	// - (void)loadForKey:(NSNumber *)key completionHandler:(GPGAppStateLoadResultHandler)completionHandler
// conflictHandler:(GPGAppStateConflictHandler)conflictHandler;
	private static final Selector loadForKey$ = Selector.register("loadForKey:completionHandler:conflictHandler:");

	@Bridge
	private native static void objc_loadForKey (GPGAppStateModel __self__, Selector __cmd__, NSNumber key,
		ObjCBlock completionHandler, ObjCBlock conflictHandler);

	public void loadForKey (int key, GPGAppStateLoadResultHandler completionHandler, GPGAppStateConflictHandler conflictHandler) {
		objc_loadForKey(this, loadForKey$, NSNumber.valueOf(key),
			GPGAppStateLoadResultHandler.Marshaler.toObjCBlock(completionHandler),
			GPGAppStateConflictHandler.Marshaler.toObjCBlock(conflictHandler));
	}

	// - (void)updateForKey:(NSNumber *)key completionHandler:(GPGAppStateWriteResultHandler)completionHandler
// conflictHandler:(GPGAppStateConflictHandler)conflictHandler;
	private static final Selector updateForKey$ = Selector.register("updateForKey:completionHandler:conflictHandler:");

	@Bridge
	private native static void objc_updateForKey (GPGAppStateModel __self__, Selector __cmd__, NSNumber key,
		ObjCBlock completionHandler, ObjCBlock conflictHandler);

	/** Writes the local AppState to the cloud. Call this after making local modifications to an AppState through the |setStateData|
	 * method. |conflictHandler| is called if the current modifications were performed on stale data (modifying before downloading
	 * the latest).
	 * @param key The key for the AppState data that is being updated.
	 * @param completionHandler The block to call when the AppState is finished downloading. ^(GPGAppStateWriteStatus status,
	 *           NSError *error)
	 * @param conflictHandler The block to call if there is a conflict. ^(NSNumber *key, NSData *localState, NSData *remoteState)
	 *           Return your resolved data from this callback to apply it. */
	public void updateForKey (int key, GPGAppStateWriteResultHandler completionHandler, GPGAppStateConflictHandler conflictHandler) {
		objc_updateForKey(this, updateForKey$, NSNumber.valueOf(key),
			GPGAppStateWriteResultHandler.Marshaler.toObjCBlock(completionHandler),
			GPGAppStateConflictHandler.Marshaler.toObjCBlock(conflictHandler));
	}

	// - (void)clearForKey:(NSNumber *)key completionHandler:(GPGAppStateWriteResultHandler)completionHandler
// conflictHandler:(GPGAppStateConflictHandler)conflictHandler;
	private static final Selector clearForKey$ = Selector.register("clearForKey:completionHandler:conflictHandler:");

	@Bridge
	private native static void objc_clearForKey (GPGAppStateModel __self__, Selector __cmd__, NSNumber key,
		ObjCBlock completionHandler, ObjCBlock conflictHandler);

	public void clearForKey (int key, GPGAppStateWriteResultHandler completionHandler, GPGAppStateConflictHandler conflictHandler) {
		objc_clearForKey(this, clearForKey$, NSNumber.valueOf(key),
			GPGAppStateWriteResultHandler.Marshaler.toObjCBlock(completionHandler),
			GPGAppStateConflictHandler.Marshaler.toObjCBlock(conflictHandler));
	}

	// - (void)deleteForKey:(NSNumber *)key completionHandler:(GPGAppStateWriteResultHandler)completionHandler;
	private static final Selector deleteForKey$ = Selector.register("deleteForKey:completionHandler:");

	@Bridge
	private native static void objc_deleteForKey (GPGAppStateModel __self__, Selector __cmd__, NSNumber key,
		ObjCBlock completionHandler);

	public void deleteForKey (int key, GPGAppStateWriteResultHandler completionHandler) {
		objc_deleteForKey(this, deleteForKey$, NSNumber.valueOf(key),
			GPGAppStateWriteResultHandler.Marshaler.toObjCBlock(completionHandler));
	}
}
