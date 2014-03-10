
package org.robovm.bindings.thinkgaming;

import org.robovm.cocoatouch.foundation.NSArray;

public interface DidDownloadStoresBlock {
	public void invoke (boolean success, NSArray<ThinkGamingStore> stores);
}
