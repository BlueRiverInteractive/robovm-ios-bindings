
package org.robovm.bindings.facebook;

import org.robovm.rt.bro.ValuedEnum;

public enum FBSessionLoginBehavior implements ValuedEnum {
	/* ! Attempt Facebook Login, ask user for credentials if necessary */
	FallbackToWebView(0),
	/* ! Attempt Facebook Login, no direct request for credentials will be made */
	NoFallbackToWebView(1),
	/* ! Only attempt WebView Login; ask user for credentials */
	ForcingWebView(2),
	/* ! Attempt Facebook Login, prefering system account and falling back to fast app switch if necessary */
	UseSystemAccountIfPresent(3);

	private final int n;

	private FBSessionLoginBehavior (int n) {
		this.n = n;
	}

	@Override
	public int value () {
		return n;
	}
}
