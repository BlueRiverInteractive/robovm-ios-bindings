package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class App42Response extends NSObject
{
	@Property(selector = "isResponseSuccess")
	public native boolean isResponseSuccess();

	@Property(selector = "setResponseSuccess:", strongRef = true)
	public native void setResponseSuccess(boolean isResponseSuccess);
	
	@Property(selector = "strResponse")
	public native String getStrResponse();

	@Property(selector = "setStrResponse:", strongRef = true)
	public native void setStrResponse(String strResponse);
	
	@Property(selector = "totalRecords")
	public native int getTotalRecords();

	@Property(selector = "setTotalRecords:", strongRef = true)
	public native void setTotalRecords(int totalRecords);
	
	@Property(selector = "isFromCache")
	public native boolean isFromCache();

	@Property(selector = "setFromCache:", strongRef = true)
	public native void setFromCache(boolean isFromCache);
	
	@Property(selector = "isOfflineSync")
	public native boolean isOfflineSync();

	@Property(selector = "setOfflineSync:", strongRef = true)
	public native void setOfflineSync(boolean isOfflineSync);
	
	@Method(selector = "toString")
	public native String toString();

	@Method(selector = "setCacheParams:")
	public native void setCacheParams(NSDictionary<?, ?> dict);
	
	public App42Response() {

	}
	
	public App42Response(SkipInit skipInit) {
		super(skipInit);
	}
}
