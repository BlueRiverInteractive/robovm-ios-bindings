package org.robovm.bindings.playhaven;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.ObjCSuper;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
@NativeClass()
public class PHAPIRequest extends NSObject{
	private static final ObjCClass objCClass = ObjCClass.getByType(PHAPIRequest.class);

	static {
		ObjCRuntime.bind(PHAPIRequest.class);
	}
	
	//+ (id)requestForApp:(NSString *)token secret:(NSString *)secret;
	private static final Selector requestForApp$secret = Selector.register("requestForApp:secret:");
	
	@Bridge
	private native static PHAPIRequest objc_request(ObjCClass __self__, Selector __cmd__, String token, String secret);
	
	/**
	 * Returns a new PHAPIRequest instance with the given token and secret
	 *
	 * @param token
	 *   The token
	 *
	 * @param secret
	 *   The secret
	 *
	 * @return
	 *   The PHAPIRequest instance
	 **/
	public static PHAPIRequest request(String token, String secret){
		return objc_request(objCClass, requestForApp$secret, token, secret);
	}
	
	//- (void)send;
	private static final Selector send = Selector.register("send");
	
	@Bridge
	private native static void objc_send(PHAPIRequest __self__, Selector __cmd__);
	
	@Bridge
	private native static void objc_sendSuper(ObjCSuper __super__, Selector __cmd__);
	
	/**
	 * Start the request if it has not already started
	 **/
	public void send(){
		if(customClass){
			objc_sendSuper(getSuper(), send);
		}else{
			objc_send(this, send);
		}
	}

}
