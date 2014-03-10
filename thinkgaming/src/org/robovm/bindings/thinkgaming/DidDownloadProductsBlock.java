
package org.robovm.bindings.thinkgaming;

import org.robovm.cocoatouch.foundation.NSArray;

public interface DidDownloadProductsBlock {
	public void invoke (boolean success, NSArray<ThinkGamingProduct> products);
}
