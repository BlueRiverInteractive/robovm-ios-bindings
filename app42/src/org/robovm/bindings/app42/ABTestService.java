package org.robovm.bindings.app42;

import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class ABTestService extends App42Service 
{
	public ABTestService(String apiKey, String secretKey) {
		super((SkipInit) null);
	    initObject(init(apiKey, secretKey));
	}
	
	@Method(selector = "initWithAPIKey:secretKey:")
	private native @Pointer long init(String apiKey, String secretKey);
	
	/**
	 * Goal Achieved for given test case variant.
	 * @param testName
	 * @param variantName
	 * @return
	 * @throws App42Exception
	 */
	@Method(selector = "goalAchievedForTest:withVariant:completionBlock:")
	public native void goalAchievedForTest(String testName, String variantName, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Executes given TestCase and returns variant profile from server
	 * @param testName
	 * @return
	 * @throws App42Exception
	 */
	@Method(selector = "execute:completionBlock:")
	public native void execute(String testName, @Block App42ResponseBlock completionBlock);
	
	/**
	 * Executes given Data Driven TestCase and returns variant profile from server
	 * @param testName
	 * @return
	 * @throws App42Exception
	 */
	@Method(selector = "executeDataDriven:completionBlock:")
	public native void executeDataDriven(String testName, @Block App42ResponseBlock completionBlock);
	
	@Method(selector = "isActive:completionBlock:")
	public native void isActive(String testName, @Block App42ResponseBlock completionBlock);
}
