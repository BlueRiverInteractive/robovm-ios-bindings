package org.robovm.bindings.playhaven;

import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.ObjCSuper;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
@NativeClass()
public class PHPublisherContentRequest extends PHAPIRequest{
	private static final ObjCClass objCClass = ObjCClass.getByType(PHPublisherContentRequest.class);

	static {
		ObjCRuntime.bind(PHPublisherContentRequest.class);
	}
	
	//+ (id)requestForApp:(NSString *)token secret:(NSString *)secret placement:(NSString *)placement delegate:(id)delegate;
	private static final Selector requestForApp$secret$placement$delegate = Selector.register("requestForApp:secret:placement:delegate:");
	
	@Bridge
	private native static PHPublisherContentRequest objc_request(ObjCClass __self__, Selector __cmd__, String token, String secret, String placement, PHPublisherContentRequestDelegate delegate);
	
	/**
	 * Returns a PHPublisherContentRequest instance for a given token secret and
	 * placement. If a request was preloaded for the same placement, this method
	 * will return that instance instead
	 *
	 * @param token
	 *   The token
	 *
	 * @param secret
	 *   The secret
	 *
	 * @param placement
	 *   The placement
	 *
	 * @param delegate
	 *   The delegate
	 *
	 * @return
	 *   A PHPublisherContentRequest instance
	 **/
	public static PHPublisherContentRequest request(String token, String secret, String placement, PHPublisherContentRequestDelegate delegate){
		return objc_request(objCClass, requestForApp$secret$placement$delegate, token, secret, placement, delegate);
	}
	
	//@property (nonatomic, assign)   BOOL            showsOverlayImmediately;
	private static final Selector setShowsOverlayImmediately = Selector.register("setShowsOverlayImmediately:");

	@Bridge
	private native static void objc_setShowsOverlayImmediately(PHPublisherContentRequest __self__, Selector __cmd__, boolean showsOverlayImmediately);

	@Bridge
	private native static void objc_setShowsOverlayImmediatelySuper(ObjCSuper __super__, Selector __cmd__, boolean showsOverlayImmediately);

	public void setShowsOverlayImmediately(boolean showsOverlayImmediately) {
		if (customClass) {
			objc_setShowsOverlayImmediatelySuper(getSuper(), setShowsOverlayImmediately, showsOverlayImmediately);
		} else {
			objc_setShowsOverlayImmediately(this, setShowsOverlayImmediately, showsOverlayImmediately);
		}
	}
	
	//- (void)preload;
	private static final Selector preload = Selector.register("preload");
	
	@Bridge
	private native static void objc_preload(PHPublisherContentRequest __self__, Selector __cmd__);
	
	@Bridge
	private native static void objc_preloadSuper(ObjCSuper __super__, Selector __cmd__);
	
	/**
	 * Request the content unit from the API, but stop before actually displaying it until PHAPIRequest#send is called
	 **/
	public void preload(){
		if(customClass){
			objc_preloadSuper(getSuper(), preload);
		}else{
			objc_preload(this, preload);
		}
	}
	
	//@property (nonatomic, readonly) PHPublisherContentRequestState state;
	private static final Selector getState = Selector.register("state");

	@Bridge
	private native static PHPublisherContentRequestState objc_getState(PHPublisherContentRequest __self__, Selector __cmd__);

	@Bridge
	private native static PHPublisherContentRequestState objc_getStateSuper(ObjCSuper __super__, Selector __cmd__);

	public PHPublisherContentRequestState getState() {
		if (customClass) {
			return objc_getStateSuper(getSuper(), getState);
		} else {
			return objc_getState(this, getState);
		}
	}

}
