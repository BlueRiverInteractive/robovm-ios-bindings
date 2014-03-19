
package org.robovm.bindings.facebook;

import org.robovm.cocoatouch.foundation.NSArray;
import org.robovm.cocoatouch.foundation.NSDictionary;
import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSString;
import org.robovm.cocoatouch.foundation.NSURL;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

/** This class contains information that represents an App Link from Facebook. */
@NativeClass
public class FBAppLinkData extends NSObject {
	/** @return the target. */
	@Property()
	public native NSURL getTargetURL ();

	/** @return list of the types of actions for this target. */
	@Property()
	public native NSArray<?> getActionTypes ();

	/** @return list of the ids of the actions for this target. */
	@Property()
	public native NSArray<NSString> getActionIDs ();

	/** @return reference breadcrumb provided during creation of story. */
	@Property(selector = "ref")
	public native NSArray<?> getReferenceBreadcrumb ();

	/** @return full set of query parameters for this app link. */
	@Property()
	public native NSDictionary<NSString, NSString> getOriginalQueryParameters ();

	/** @return original url from which applinkData was extracted. */
	@Property()
	public native NSURL getOriginalURL ();

	/** @return addtional arguments supplied with the App Link data. */
	@Property(selector = "arguments")
	public native NSDictionary<NSString, NSString> getAdditionalArguments ();
}
