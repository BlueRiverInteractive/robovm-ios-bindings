package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSMutableArray;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class JSONDocument extends App42File
{
	@Property(selector = "jsonDoc")
	public native String getJsonDoc();

	@Property(selector = "setJsonDoc:", strongRef = true)
	public native void setJsonDoc(String jsonDoc);
	
	@Property(selector = "owner")
	public native String getOwner();

	@Property(selector = "setOwner:", strongRef = true)
	public native void setOwner(String owner);

	@Property(selector = "docId")
	public native String getDocId();

	@Property(selector = "setDocId:", strongRef = true)
	public native void setDocId(String docId);

	@Property(selector = "createdAt")
	public native String getCreatedAt();

	@Property(selector = "setCreatedAt:", strongRef = true)
	public native void setCreatedAt(String createdAt);

	@Property(selector = "updatedAt")
	public native String getUpdatedAt();

	@Property(selector = "setUpdatedAt:", strongRef = true)
	public native void setUpdatedAt(String updatedAt);

	@Property(selector = "event")
	public native String getEvent();

	@Property(selector = "setEvent:", strongRef = true)
	public native void setEvent(String event);
	
	@Property(selector = "aclList")
	public native NSMutableArray<?> getAclList();

	@Property(selector = "setAclList:", strongRef = true)
	public native void setAclList(NSMutableArray<?> aclList);

	@Property(selector = "storageObject")
	public native String getStorage();

	@Property(selector = "setStorageObject:", strongRef = true)
	public native void setStorage(String storage);

	@Property(selector = "loc")
	public native GeoTag getLoc();

	@Property(selector = "setLoc:", strongRef = true)
	public native void setLoc(GeoTag loc);

	@Property(selector = "fileList")
	public native NSMutableArray<?> getFileList();

	@Property(selector = "setFileList:", strongRef = true)
	public native void setFileList(NSMutableArray<?> fileList);

	public JSONDocument(Storage storage) {
		super((SkipInit) null);
	    initObject(init(storage));
	}
	
	@Method(selector = "initWithStorage:")
	private native @Pointer long init(Storage storage);
}
