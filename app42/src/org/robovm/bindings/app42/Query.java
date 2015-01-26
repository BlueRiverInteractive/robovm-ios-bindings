package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSMutableArray;
import org.robovm.apple.foundation.NSMutableDictionary;
import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class Query extends NSObject
{
	public static final String APP42_OP_EQUALS 				 = "$eq";
	public static final String APP42_OP_NOT_EQUALS 			 = "$ne";
	public static final String APP42_OP_GREATER_THAN 		 = "$gt";
	public static final String APP42_OP_LESS_THAN 			 = "$lt";
	public static final String APP42_OP_GREATER_THAN_EQUALTO = "$gte";
	public static final String APP42_OP_LESS_THAN_EQUALTO 	 = "$lte";
	public static final String APP42_OP_LIKE 				 = "$lk";
	public static final String APP42_OP_AND 				 = "$and";
	public static final String APP42_OP_OR 					 = "$or";
	public static final String APP42_OP_INLIST 				 = "$in";
	
	public static final String APP42_ORDER_ASCENDING  = "ASCENDING";
	public static final String APP42_ORDER_DESCENDING = "DESCENDING";
	
	@Property(selector = "jsonArray")
	public native NSMutableArray<?> getJsonArray();

	@Property(selector = "setJsonArray:", strongRef = true)
	public native void setJsonArray(NSMutableArray<?> jsonArray);

	@Property(selector = "jsonObject")
	public native NSMutableDictionary<?, ?> getJson();

	@Property(selector = "setJsonObject:", strongRef = true)
	public native void setJson(NSMutableDictionary<?, ?> json);
	
	public Query(NSMutableDictionary<?, ?> object) {
		super((SkipInit) null);
	    initObject(init(object));
	}
	
	public Query(NSMutableArray<?> array) {
		super((SkipInit) null);
	    initObject(init(array));
	}
	
	@Method(selector = "initWithJsonObject:")
	private native @Pointer long init(NSMutableDictionary<?, ?> object);
	
	@Method(selector = "initWithJsonArray:")
	private native @Pointer long init(NSMutableArray<?> array);
	
	@Method(selector = "getJsonQuery:")
	public native String getJsonQuery();
}
