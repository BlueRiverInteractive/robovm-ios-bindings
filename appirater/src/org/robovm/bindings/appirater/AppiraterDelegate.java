
package org.robovm.bindings.appirater;

import org.robovm.apple.foundation.NSObjectProtocol;
import org.robovm.objc.annotation.Method;

public interface AppiraterDelegate extends NSObjectProtocol {
	@Method(selector = "appiraterDidDisplayAlert:")
	void didDisplayAlert (Appirater appirater);

	@Method(selector = "appiraterDidDeclineToRate:")
	void didDeclineToRate (Appirater appirater);

	@Method(selector = "appiraterDidOptToRate:")
	void didOptToRate (Appirater appirater);

	@Method(selector = "appiraterDidOptToRemindLater:")
	void didOptToRemindLater (Appirater appirater);

	@Method(selector = "appiraterWillPresentModalView:animated:")
	void willPresentModalView (Appirater appirater, boolean animated);

	@Method(selector = "appiraterDidDismissModalView:animated:")
	void didDismissModalView (Appirater appirater, boolean animated);
}
