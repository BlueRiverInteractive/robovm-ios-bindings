package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class Attribute extends NSObject
{
	/*!
	 *set and get the userName for Attribute Object 
	 */
	@Property(selector = "getSession")
	public native Session getSession();

	@Property(selector = "setSessionObj:", strongRef = true)
	public native void setSession(Session session);
	
	/*!
	 *set and get the name of the attribute. 
	 */
	@Property(selector = "getName")
	public native String getName();

	@Property(selector = "setName:", strongRef = true)
	public native void setName(String name);
	
	/*!
	 *set and get the value of the session. 
	 */
	@Property(selector = "value")
	public native String getValue();

	@Property(selector = "setValue:", strongRef = true)
	public native void setValue(String value);
	
	/*!
	 *set and get the attributeArray for Attribute Object which contains the 
	 */
	public Attribute(Session session) {
		super((SkipInit) null);
	    initObject(init(session));
	}
	
	@Method(selector = "initWithSession:")
	private native @Pointer long init(Session session);
}
