package org.robovm.bindings.app42;

import org.json.JSONException;
import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;

@NativeClass
public class QueryBuilder extends NSObject
{
	/**
	 * @param key
	 * @param Value
	 * @param op
	 * @return Query object
	 * @throws JSONException
	 */
	@Method(selector = "buildQueryWithKey:value:andOperator:")
	public native static Query buildQueryWithKey(String key, NSObject value, String op);
	
	/**
	 * @param q1
	 * @param q2
	 * @param op
	 * @return Query object
	 */
	@Method(selector = "combineQuery:withQuery:usingOperator:")
	public native static Query combineQuery(Query q1, Query q2, String op);

	/**
	 * @param getTag
	 * @param op
	 * @return
	 * @throws JSONException
	 */
	@Method(selector = "buildGeoQueryWithTag:andOperator:")
	public native static Query buildGeoQueryWithTag(GeoTag geoTag, String op);
	
	/**
	 * @param getTag
	 * @param op
	 * @param maxDistance
	 * @return
	 * @throws JSONException
	 */
	@Method(selector = "buildGeoQueryWithTag:andOperator:maxDistance:")
	public native static Query buildGeoQueryWithTag(GeoTag geoTag, String op, double maxDistance);
	
	/**
	 * @param logged
	 * @return
	 * @throws App42Exception
	 */
	@Method(selector = "setLoggedInUser:")
	public native Query setLoggedInUser(String logged);
}
