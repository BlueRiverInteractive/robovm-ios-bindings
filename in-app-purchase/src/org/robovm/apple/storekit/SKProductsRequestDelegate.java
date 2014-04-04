
package org.robovm.apple.storekit;

import org.robovm.objc.Selector;
import org.robovm.objc.annotation.BindSelector;
import org.robovm.objc.annotation.NotImplemented;
import org.robovm.rt.bro.annotation.Callback;

public interface SKProductsRequestDelegate extends SKRequestDelegate {

	// - (void)productsRequest:(SKProductsRequest *)request didReceiveResponse:(SKProductsResponse *)response
	// __OSX_AVAILABLE_STARTING(__MAC_NA,__IPHONE_3_0);
	void receivedResponse (SKProductsRequest request, SKProductsResponse response);

	public static class Adapter extends SKRequestDelegate.Adapter implements SKProductsRequestDelegate {
		@NotImplemented("productsRequest:didReceiveResponse:")
		@Override
		public void receivedResponse (SKProductsRequest request, SKProductsResponse response) {
			throw new UnsupportedOperationException();
		}
	}

	static class Callbacks extends SKRequestDelegate.Callbacks {
		@Callback
		@BindSelector("productsRequest:didReceiveResponse:")
		public static void receivedResponse (SKProductsRequestDelegate __self__, Selector __cmd__, SKProductsRequest request,
			SKProductsResponse response) {
			__self__.receivedResponse(request, response);
		}
	}
}
