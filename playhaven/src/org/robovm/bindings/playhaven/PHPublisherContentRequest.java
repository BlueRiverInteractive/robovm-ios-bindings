
package org.robovm.bindings.playhaven;

import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class PHPublisherContentRequest extends PHAPIRequest {
	/** Returns a PHPublisherContentRequest instance for a given token secret and placement. If a request was preloaded for the same
	 * placement, this method will return that instance instead
	 * 
	 * @param token The token
	 * 
	 * @param secret The secret
	 * 
	 * @param placement The placement
	 * 
	 * @param delegate The delegate
	 * 
	 * @return A PHPublisherContentRequest instance **/
	@Method(selector = "requestForApp:secret:placement:delegate:")
	public static native PHPublisherContentRequest request (String token, String secret, String placement,
		PHPublisherContentRequestDelegate delegate);

	@Property(strongRef = true)
	public native void setShowsOverlayImmediately (boolean showsOverlayImmediately);

	@Property
	public native boolean isShowsOverlayImmediately ();

	/** Request the content unit from the API, but stop before actually displaying it until PHAPIRequest#send is called **/
	@Method(selector = "preload")
	public native void preload ();

	@Property
	public native PHPublisherContentRequestState getState ();
}
