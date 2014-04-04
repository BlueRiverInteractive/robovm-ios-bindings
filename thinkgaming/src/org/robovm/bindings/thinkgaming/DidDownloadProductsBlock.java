
package org.robovm.bindings.thinkgaming;

import org.robovm.apple.foundation.NSArray;

public interface DidDownloadProductsBlock {
	public void invoke (boolean success, NSArray<ThinkGamingProduct> products);
}
