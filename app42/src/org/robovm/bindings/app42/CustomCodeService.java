package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSDictionary;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class CustomCodeService extends App42Service
{
	public CustomCodeService(String apiKey, String secretKey) {
		super((SkipInit) null);
	    initObject(init(apiKey, secretKey));
	}
	
	@Method(selector = "initWithAPIKey:secretKey:")
	private native @Pointer long init(String apiKey, String secretKey);

	/**
	 * Runs custom code deployed in the App42 Cloud
	 *
	 * @param name
	 *            - Name of deployed CustomCode Service
	 * @param jsonBody
	 *            - Request Body in JSON format
	 * @return JSONObject
	 */
	@Method(selector = "runJavaCode:requestBody:completionBlock:")
	public native void runJavaCode(String name, NSDictionary<?, ?> requestBody, @Block App42ResponseBlock completionBlock);
}
