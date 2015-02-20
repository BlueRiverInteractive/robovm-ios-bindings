package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSMutableArray;
import org.robovm.apple.foundation.NSMutableDictionary;
import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class App42Service extends NSObject
{
	@Property(selector = "apiKey")
	public native String getApiKey();

	@Property(selector = "setApiKey:", strongRef = true)
	public native void setApiKey(String apiKey);
	
	@Property(selector = "secretKey")
	public native String getSecretKey();

	@Property(selector = "setSecretKey:", strongRef = true)
	public native void setSecretKey(String secretKey);

	@Property(selector = "appVersion")
	public native String getAppVersion();

	@Property(selector = "setAppVersion:", strongRef = true)
	public native void setAppVersion(String appVersion);
	
	@Property(selector = "sessionId")
	public native String getSessionId();

	@Property(selector = "setSessionId:", strongRef = true)
	public native void setSessionId(String sessionId);
	
	@Property(selector = "adminKey")
	public native String getAdminKey();

	@Property(selector = "setAdminKey:", strongRef = true)
	public native void setAdminKey(String adminKey);
	
	@Property(selector = "geoTag")
	public native String getGeoTag();

	@Property(selector = "setGeoTag:", strongRef = true)
	public native void setGeoTag(String geoTag);
	
	@Property(selector = "fbAccessToken")
	public native String getFbAccessToken();

	@Property(selector = "setFbAccessToken:", strongRef = true)
	public native void setFbAccessToken(String fbAccessToken);
	
	@Property(selector = "orderByDescending")
	public native String getOrderByDescending();

	@Property(selector = "setOrderByDescending:", strongRef = true)
	public native void setOrderByDescending(String orderByDescending);
	
	@Property(selector = "orderByAscending")
	public native String getOrderByAscending();

	@Property(selector = "setOrderByAscending:", strongRef = true)
	public native void setOrderByAscending(String orderByAscending);
	
	@Property(selector = "aclList")
	public native NSMutableArray<?> getAclList();

	@Property(selector = "setAclList:", strongRef = true)
	public native void setAclList(NSMutableArray<?> aclList);
	
	@Property(selector = "selectKeys")
	public native NSMutableArray<?> getSelectKeys();

	@Property(selector = "setSelectKeys:", strongRef = true)
	public native void setSelectKeys(NSMutableArray<?> selectKeys);
	
	@Property(selector = "otherMetaHeaders")
	public native NSMutableDictionary<?, ?> getOtherMetaHeaders();

	@Property(selector = "setOtherMetaHeaders:", strongRef = true)
	public native void setOtherMetaHeaders(NSMutableDictionary<?, ?> otherMetaHeaders);

	@Property(selector = "pageOffset")
	public native int getPageOffset();

	@Property(selector = "setPageOffset:", strongRef = true)
	public native void setPageOffset(int pageOffset);
	
	@Property(selector = "pageMaxRecords")
	public native int getPageMaxRecords();

	@Property(selector = "setPageMaxRecords:", strongRef = true)
	public native void setPageMaxRecords(int pageMaxRecords);
	
	@Property(selector = "event")
	public native String getEvent();

	@Property(selector = "setEvent:", strongRef = true)
	public native void setEvent(String event);
	
	@Property(selector = "metaInfo")
	public native String getMetaInfo();

	@Property(selector = "setMetaInfo:", strongRef = true)
	public native void setMetaInfo(String metaInfo);
	
	@Property(selector = "metaInfoQuery")
	public native String getMetaInfoQuery();

	@Property(selector = "setMetaInfoQuery:", strongRef = true)
	public native void setMetaInfoQuery(String metaInfoQuery);

	@Property(selector = "dbName")
	public native String getDbName();

	@Property(selector = "setDbName:", strongRef = true)
	public native void setDbName(String dbName);
	
	@Property(selector = "collectionName")
	public native String getCollectionName();

	@Property(selector = "setCollectionName:", strongRef = true)
	public native void setCollectionName(String collectionName);
	
	@Property(selector = "query")
	public native String getQuery();

	@Property(selector = "setQuery:", strongRef = true)
	public native void setQuery(String query);
	
	@Property(selector = "jsonObject")
	public native String getJsonObject();

	@Property(selector = "setJsonObject:", strongRef = true)
	public native void setJsonObject(String jsonObject);
	
	public App42Service(SkipInit skipInit) {
		super(skipInit);
	}
}
