package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSData;
import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class App42File extends NSObject
{
	@Property(selector = "getName")
	public native String getName();

	@Property(selector = "setName:", strongRef = true)
	public native void setName(String name);
	
	@Property(selector = "getFileId")
	public native String getFileId();

	@Property(selector = "setFileId:", strongRef = true)
	public native void setFileId(String fileId);
	
	@Property(selector = "getUrl")
	public native String getUrl();

	@Property(selector = "setUrl:", strongRef = true)
	public native void setUrl(String url);
	
	@Property(selector = "getType")
	public native String getType();

	@Property(selector = "setType:", strongRef = true)
	public native void setType(String type);
	
	@Property(selector = "getFileData")
	public native NSData getFileData();

	@Property(selector = "setFileData:", strongRef = true)
	public native void setFileData(NSData fileData);
	
	@Property(selector = "getFileType")
	public native String getFileType();

	@Property(selector = "setFileType:", strongRef = true)
	public native void setFileType(String fileType);
	
	public App42File(SkipInit skipInit) {
		super(skipInit);
	}
	
	public App42File(NSData fileData, String fileName, String fileType) {
		super((SkipInit)null);
	    initObject(init(fileData, fileName, fileType));
	}
	
	@Method(selector = "initWithFileData:fileName:andType:")
	private native @Pointer long init(NSData fileData, String fileName, String fileType);
}
