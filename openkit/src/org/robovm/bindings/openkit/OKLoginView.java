
package org.robovm.bindings.openkit;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class OKLoginView extends NSObject {
	public OKLoginView (String title, String description, String login, String cancel) {
		super((SkipInit)null);
		initObject(init(title, description, login, cancel));
	}

	@Method(selector = "initWithTitle:description:login:cancel:")
	private native @Pointer
	long init (String title, String description, String login, String cancel);

	@Method(selector = "setSuccessDialogTitle:description:")
	public native void setSuccessDialogText (String title, String description);

	@Method(selector = "showWithCompletionHandler:")
	public native void show (/* @Block */OKLoginViewCompletionHandler handler);
}
