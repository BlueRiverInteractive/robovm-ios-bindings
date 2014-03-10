package org.robovm.bindings.playhaven;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.Bro;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
@NativeClass
public class PHPublisherContentDismissType extends NSObject{
	static{
		Bro.bind();
	}
	
	public static final String PHPublisherContentUnitTriggeredDismiss = "PHPublisherContentUnitTriggeredDismiss";
	public static final String PHPublisherNativeCloseButtonTriggeredDismiss = "PHPublisherNativeCloseButtonTriggeredDismiss";
	public static final String PHPublisherApplicationBackgroundTriggeredDismiss = "PHPublisherApplicationBackgroundTriggeredDismiss";
	public static final String PHPublisherNoContentTriggeredDismiss = "PHPublisherNoContentTriggeredDismiss";

}
