
package org.robovm.bindings.openkit;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.objc.ObjCBlock;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;
import org.robovm.rt.bro.annotation.Pointer;

@Library(Library.INTERNAL)
@NativeClass()
public class OKLoginView extends NSObject {
	private static final ObjCClass objCClass = ObjCClass.getByType(OKLoginView.class);

	static {
		ObjCRuntime.bind(OKLoginView.class);
	}

	protected OKLoginView (SkipInit skipInit) {
		super(skipInit);
	}

	public OKLoginView (String title, String description, String login, String cancel) {
		super((SkipInit)null);
		initObject(objc_iinitWithTitle$description$login$cancel$(this, initWithTitle$description$login$cancel$, title, description,
			login, cancel));
	}

	private static final Selector initWithTitle$description$login$cancel$ = Selector
		.register("initWithTitle:description:login:cancel:");

	@Bridge
	private native static @Pointer
	long objc_iinitWithTitle$description$login$cancel$ (OKLoginView __self__, Selector __cmd__, String title, String description,
		String login, String cancel);

	public void setSuccessDialogText (String title, String description) {
		objc_setSuccessDialogTitle$description$(this, setSuccessDialogTitle$description$, title, description);
	}

	private static final Selector setSuccessDialogTitle$description$ = Selector.register("setSuccessDialogTitle:description:");

	@Bridge
	private native static void objc_setSuccessDialogTitle$description$ (OKLoginView __self__, Selector __cmd__, String title,
		String description);

	public void show (OKLoginViewCompletionHandler handler) {
		objc_showWithCompletionHandler$(this, showWithCompletionHandler$,
			OKLoginViewCompletionHandler.Marshaler.toObjCBlock(handler));
	}

	private static final Selector showWithCompletionHandler$ = Selector.register("showWithCompletionHandler:");

	@Bridge
	private native static void objc_showWithCompletionHandler$ (OKLoginView __self__, Selector __cmd__, ObjCBlock handler);
}
