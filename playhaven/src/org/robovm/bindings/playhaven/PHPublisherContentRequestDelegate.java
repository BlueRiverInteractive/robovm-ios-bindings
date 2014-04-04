
package org.robovm.bindings.playhaven;

import org.robovm.apple.foundation.NSError;
import org.robovm.apple.foundation.NSObjectProtocol;
import org.robovm.objc.annotation.Method;

public interface PHPublisherContentRequestDelegate extends NSObjectProtocol {
	@Method(selector = "requestWillGetContent:")
	void willGetContent (PHPublisherContentRequest request);

	@Method(selector = "requestDidGetContent:")
	void didGetContent (PHPublisherContentRequest request);

	@Method(selector = "request:contentWillDisplay:")
	void willDisplay (PHPublisherContentRequest request, PHContent content);

	@Method(selector = "request:contentDidDisplay:")
	void didDisplay (PHPublisherContentRequest request, PHContent content);

	@Method(selector = "request:contentDidDismissWithType:")
	void didDismiss (PHPublisherContentRequest request, String type);

	@Method(selector = "request:didFailWithError:")
	void didFail (PHPublisherContentRequest request, NSError error);
}
