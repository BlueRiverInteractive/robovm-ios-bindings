
package org.robovm.bindings.thinkgaming;

import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class ThinkGamingStore extends NSObject {
	public ThinkGamingStore (NSDictionary<?, ?> response) {
		super((SkipInit)null);
		initObject(init(response));
	}

	@Method(selector = "initWithResponse:")
	private native @Pointer
	long init (NSDictionary<?, ?> response);

	@Property
	private native String getDisplayName ();

	@Property
	private native void setDisplayName (String name);

	@Property
	private native String getStoreIdentifier ();

	@Property
	private native void setStoreIdentifier (String identifier);
}
