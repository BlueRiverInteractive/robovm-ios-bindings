package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class RecommendedItem extends NSObject
{
	@Property(selector = "userId")
	public native String getUserId();

	@Property(selector = "setUserId:", strongRef = true)
	public native void setUserId(String userId);
	
	@Property(selector = "item")
	public native String getItem();

	@Property(selector = "setItem:", strongRef = true)
	public native void setItem(String item);

	@Property(selector = "value")
	public native double getValue();

	@Property(selector = "setValue:", strongRef = true)
	public native void setValue(double value);

	@Property(selector = "recommender")
	public native Recommender getRecommender();

	@Property(selector = "setRecommenderObject:", strongRef = true)
	public native void setRecommender(Recommender recommender);

	public RecommendedItem(Recommender recommender) {
		super((SkipInit) null);
	    initObject(init(recommender));
	}
	
	@Method(selector = "initWithRecommender:")
	private native @Pointer long init(Recommender recommender);
}
