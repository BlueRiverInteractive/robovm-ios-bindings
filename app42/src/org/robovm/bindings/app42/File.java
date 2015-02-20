package org.robovm.bindings.app42;

import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class File extends App42Response
{
	@Property(selector = "name")
	public native String getName();

	@Property(selector = "setName:", strongRef = true)
	public native void setName(String name);
	
	@Property(selector = "userName")
	public native String getUserName();

	@Property(selector = "setUserName:", strongRef = true)
	public native void setUserName(String userName);
	
	@Property(selector = "type")
	public native String getType();

	@Property(selector = "setType:", strongRef = true)
	public native void setType(String type);
	
	@Property(selector = "url")
	public native String getUrl();

	@Property(selector = "setUrl:", strongRef = true)
	public native void setUrl(String url);
	
	@Property(selector = "tinyUrl")
	public native String getTinyUrl();

	@Property(selector = "setTinyUrl:", strongRef = true)
	public native void setTinyUrl(String tinyUrl);
	
	@Property(selector = "description")
	public native String getDescription();

	@Property(selector = "setDescription:", strongRef = true)
	public native void setDescription(String description);
	
	@Property(selector = "uploadObject")
	public native Upload getUpload();

	@Property(selector = "setUpload:", strongRef = true)
	public native void setUpload(Upload upload);
	
	public File(Upload upload) {
		super((SkipInit) null);
	    initObject(init(upload));
	}
	
	@Method(selector = "initWithUpload:")
	private native @Pointer long init(Upload upload);
}
