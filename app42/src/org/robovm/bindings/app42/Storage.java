package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSMutableArray;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class Storage extends App42Response
{
	@Property(selector = "dbName")
	public native String getDbName();

	@Property(selector = "setDbName:", strongRef = true)
	public native void setDbName(String dbName);

	@Property(selector = "recordCount")
	public native int getRecordCount();

	@Property(selector = "setRecordCount:", strongRef = true)
	public native void setRecordCount(int recordCount);

	@Property(selector = "collectionName")
	public native String getCollectionName();

	@Property(selector = "setCollectionName:", strongRef = true)
	public native void setCollectionName(String collectionName);

	@Property(selector = "jsonDocArray")
	public native NSMutableArray<?> getJsonDocArray();

	@Property(selector = "setJsonDocArray:", strongRef = true)
	public native void setJsonDocArray(NSMutableArray<?> jsonDocArray);
}
