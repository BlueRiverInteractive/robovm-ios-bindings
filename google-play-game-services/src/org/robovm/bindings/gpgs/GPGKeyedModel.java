
package org.robovm.bindings.gpgs;

import org.robovm.cocoatouch.foundation.NSError;
import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSString;
import org.robovm.objc.ObjCBlock;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
@NativeClass()
public class GPGKeyedModel extends NSObject {
	private static final ObjCClass objCClass = ObjCClass.getByType(GPGKeyedModel.class);

	static {
		ObjCRuntime.bind(GPGKeyedModel.class);
	}

	// - (void)loadDataForKey:(NSString *)key;
	private static final Selector loadDataForKey$ = Selector.register("loadDataForKey:");

	@Bridge
	private native static void objc_loadDataForKey (GPGKeyedModel __self__, Selector __cmd__, NSString key);

	public void loadDataForKey (String key) {
		objc_loadDataForKey(this, loadDataForKey$, new NSString(key));
	}

	// Executes the completion handler immediately if the data is already loaded.
	// - (void)loadDataForKey:(NSString *)key completionHandler:(GPGModelDidLoadBlock)completionHandler;
	private static final Selector loadDataForKey$completionHandler$ = Selector.register("loadDataForKey:completionHandler:");

	@Bridge
	private native static void objc_loadDataForKey2 (GPGKeyedModel __self__, Selector __cmd__, NSString key,
		ObjCBlock completionHandler);

	public void loadDataForKey (String key, GPGModelDidLoadBlock completionHandler) {
		objc_loadDataForKey2(this, loadDataForKey$completionHandler$, new NSString(key),
			GPGModelDidLoadBlock.Marshaler.toObjCBlock(completionHandler));
	}

	// - (void)reloadDataForKey:(NSString *)key;
	private static final Selector reloadDataForKey$ = Selector.register("reloadDataForKey:");

	@Bridge
	private native static void objc_reloadDataForKey (GPGKeyedModel __self__, Selector __cmd__, NSString key);

	public void reloadDataForKey (String key) {
		objc_reloadDataForKey(this, reloadDataForKey$, new NSString(key));
	}

	// - (void)reloadDataForKey:(NSString *)key completionHandler:(GPGModelDidLoadBlock)completionHandler;
	private static final Selector reloadDataForKey$completionHandler$ = Selector.register("reloadDataForKey:completionHandler:");

	@Bridge
	private native static void objc_reloadDataForKey2 (GPGKeyedModel __self__, Selector __cmd__, NSString key,
		ObjCBlock completionHandler);

	public void reloadDataForKey (String key, GPGModelDidLoadBlock completionHandler) {
		objc_reloadDataForKey2(this, reloadDataForKey$completionHandler$, new NSString(key),
			GPGModelDidLoadBlock.Marshaler.toObjCBlock(completionHandler));
	}

	// - (BOOL)isLoadingDataForKey:(NSString *)key;
	private static final Selector isLoadingDataForKey$ = Selector.register("isLoadingDataForKey:");

	@Bridge
	private native static boolean objc_isLoadingDataForKey (GPGKeyedModel __self__, Selector __cmd__, NSString key);

	public boolean isLoadingDataForKey (String key) {
		return objc_isLoadingDataForKey(this, isLoadingDataForKey$, new NSString(key));
	}

	// - (BOOL)isDataLoadedForKey:(NSString *)key;
	private static final Selector isDataLoadedForKey$ = Selector.register("isDataLoadedForKey:");

	@Bridge
	private native static boolean objc_isDataLoadedForKey (GPGKeyedModel __self__, Selector __cmd__, NSString key);

	public boolean isDataLoadedForKey (String key) {
		return objc_isDataLoadedForKey(this, isDataLoadedForKey$, new NSString(key));
	}

	// - (NSError *)errorFromLoadingDataForKey:(NSString *)key;
	private static final Selector errorFromLoadingDataForKey$ = Selector.register("errorFromLoadingDataForKey:");

	@Bridge
	private native static NSError objc_errorFromLoadingDataForKey (GPGKeyedModel __self__, Selector __cmd__, NSString key);

	public NSError errorFromLoadingDataForKey (String key) {
		return objc_errorFromLoadingDataForKey(this, errorFromLoadingDataForKey$, new NSString(key));
	}
}
