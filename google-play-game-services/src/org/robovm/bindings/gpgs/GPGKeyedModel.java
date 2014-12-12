package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSError;
import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
@NativeClass()
public class GPGKeyedModel extends NSObject {



//- (void)loadDataForKey:(NSString *)key __attribute__ ((deprecated));
//- (void)loadDataForKey:(NSString *)key completionHandler:(GPGModelDidLoadBlock)completionHandler
//    __attribute__ ((deprecated));
//
//- (void)reloadDataForKey:(NSString *)key __attribute__ ((deprecated));
//
//- (void)reloadDataForKey:(NSString *)key completionHandler:(GPGModelDidLoadBlock)completionHandler
//    __attribute__ ((deprecated));
//
//- (BOOL)isLoadingDataForKey:(NSString *)key __attribute__ ((deprecated));
//- (BOOL)isDataLoadedForKey:(NSString *)key __attribute__ ((deprecated));
//- (NSError *)errorFromLoadingDataForKey:(NSString *)key __attribute__ ((deprecated));

	@Deprecated
	@Method(selector = "loadDataForKey:")
	public native void loadData(String key);
	
	@Deprecated
	@Method(selector = "loadDataForKey:completionHandler:")
	public native void loadData(String key, @Block GPGModelDidLoadBlock completionHandler);
	
	@Deprecated
	@Method(selector = "reloadDataForKey:")
	public native void reloadData(String key);
	
	@Deprecated
	@Method(selector = "reloadDataForKey:completionHandler:")
	public native void reloadData(String key, @Block GPGModelDidLoadBlock completionHandler);
	
	@Deprecated
	@Method(selector = "isLoadingDataForKey:")
	public native boolean isLoadingData(String key);
	
	@Deprecated
	@Method(selector = "isDataLoadedForKey:")
	public native boolean isDataLoaded(String key);
	
	@Deprecated
	@Method(selector = "errorFromLoadingDataForKey:")
	public native NSError errorFromLoadingData(String key);
	
}
