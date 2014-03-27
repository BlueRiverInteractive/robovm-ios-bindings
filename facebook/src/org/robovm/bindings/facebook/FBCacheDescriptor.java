
package org.robovm.bindings.facebook;

import org.robovm.apple.foundation.NSObject;
import org.robovm.bindings.facebook.session.FBSession;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;

/** Base class from which CacheDescriptors derive, provides a method to fetch data for later use.
 * 
 * Cache descriptors allow your application to specify the arguments that will be later used with another object, such as the
 * {@link FBFriendPickerViewController}. By using a cache descriptor instance, an application can choose to fetch data ahead of
 * the point in time where the data is needed. */
@NativeClass
public class FBCacheDescriptor extends NSObject {

	/** Fetches and caches the data described by the cache descriptor instance, for the given session.
	 * @param session the {@link FBSession} to use for fetching data */
	@Method(selector = "prefetchAndCacheForSession:")
	public native void prefetchAndCache (FBSession session);
}
