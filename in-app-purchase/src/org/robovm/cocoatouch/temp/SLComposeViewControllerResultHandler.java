
package org.robovm.cocoatouch.temp;

import org.robovm.objc.ObjCBlock;
import org.robovm.objc.ObjCBlock.Wrapper;
import org.robovm.rt.bro.annotation.Callback;
import org.robovm.rt.bro.annotation.Marshaler;

@Marshaler(SLComposeViewControllerResultHandler.Marshaler.class)
public interface SLComposeViewControllerResultHandler {
	void invoke (SLComposeViewControllerResult v);

	static class Callbacks {
		@Callback
		static void run (ObjCBlock block, SLComposeViewControllerResult v) {
			((SLComposeViewControllerResultHandler)block.object()).invoke(v);
		}
	}

	static class Marshaler {
		private static final Wrapper WRAPPER = new Wrapper(Callbacks.class);

		public static ObjCBlock toObjCBlock (SLComposeViewControllerResultHandler o) {
			return WRAPPER.toObjCBlock(o);
		}
	}
}
