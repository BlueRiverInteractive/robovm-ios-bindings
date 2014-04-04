
package org.robovm.bindings.thinkgaming;

import org.robovm.apple.foundation.NSArray;

public interface DidDownloadStoresBlock {
	public void invoke (boolean success, NSArray<ThinkGamingStore> stores);
}
