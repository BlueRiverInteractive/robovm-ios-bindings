
package org.robovm.bindings.playhaven;

import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.Bro;

@NativeClass
public class PHPublisherContentDismissType extends NSObject {
	static {
		Bro.bind();
	}

	public static final String PHPublisherContentUnitTriggeredDismiss = "PHPublisherContentUnitTriggeredDismiss";
	public static final String PHPublisherNativeCloseButtonTriggeredDismiss = "PHPublisherNativeCloseButtonTriggeredDismiss";
	public static final String PHPublisherApplicationBackgroundTriggeredDismiss = "PHPublisherApplicationBackgroundTriggeredDismiss";
	public static final String PHPublisherNoContentTriggeredDismiss = "PHPublisherNoContentTriggeredDismiss";
}
