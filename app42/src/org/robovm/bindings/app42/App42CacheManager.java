package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class App42CacheManager extends NSObject
{
	@Property(selector = "isCacheEnabled")
	public native boolean isCacheEnabled();

	@Property(selector = "setCacheEnabled:")
	public native void setCacheEnabled(boolean isCacheEnabled);
	
	@Property(selector = "getCacheSize")
	public native long getCacheSize();

	@Property(selector = "setCacheSize:")
	public native void setCacheSize(long cacheSize);

	/*!
	 * Returns Singleton instance
	 */
	@Method(selector = "sharedCacheManager")
	public native static App42CacheManager sharedCacheManager();
	
	/*!
	 * Terminates cache manager
	 */
	@Method(selector = "terminateApp42CacheManager")
	public native static void terminateApp42CacheManager();
	
	/*!
	 * Returns current network status
	 */
	@Method(selector = "isNetworkAvailable")
	public native boolean isNetworkAvailable();
	
	/*!
	 * Sets cachePolicy
	 */
	@Method(selector = "setPolicy:")
	public native void setPolicy(App42CachePolicy app42CachePolicy);

	/*!
	 * Returns cachePolicy
	 */
	@Method(selector = "getPolicy")
	public native App42CachePolicy getPolicy();

	/*!
	 * Sets cacheExpiryInMinutes
	 */
	@Method(selector = "setExpiryInMinutes:")
	public native void setExpiryInMinutes(long expiryInMinutes);
	
	/*!
	 * Returns cacheExpiryInMinutes
	 */
	@Method(selector = "getExpiryInMinutes")
	public native long getExpiryInMinutes();
}
