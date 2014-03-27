
package org.robovm.bindings.facebook.dialogs;

import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSObject;
import org.robovm.bindings.facebook.FBAppCallHandler;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

/** This class encapsulates state and data related to the presentation and completion of a dialog. */
@NativeClass
public class FBDialogsData extends NSObject {
	/** @return the method being performed. */
	@Property
	public native String getMethod ();

	/** @return the arguments being passed to the entity that will show the dialog. */
	@Property
	public native NSDictionary<?, ?> getArguments ();

	/** @return client JSON state that is passed through to the completion handler for context. */
	@Property
	public native NSDictionary<?, ?> getClientState ();

	/** @return results of this FBAppCall that are only set before calling an {@link FBAppCallHandler}. */
	@Property
	public native NSDictionary<?, ?> getResults ();
}
