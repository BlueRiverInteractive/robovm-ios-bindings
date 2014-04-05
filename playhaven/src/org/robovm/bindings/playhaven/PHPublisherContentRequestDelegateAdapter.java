
package org.robovm.bindings.playhaven;

import org.robovm.apple.foundation.NSError;
import org.robovm.apple.foundation.NSObject;

public class PHPublisherContentRequestDelegateAdapter extends NSObject implements PHPublisherContentRequestDelegate {
	@Override
	public void willGetContent (PHPublisherContentRequest request) {
	}

	@Override
	public void didGetContent (PHPublisherContentRequest request) {
	}

	@Override
	public void willDisplay (PHPublisherContentRequest request, PHContent content) {
	}

	@Override
	public void didDisplay (PHPublisherContentRequest request, PHContent content) {
	}

	@Override
	public void didDismiss (PHPublisherContentRequest request, String type) {
	}

	@Override
	public void didFail (PHPublisherContentRequest request, NSError error) {
	}
}
