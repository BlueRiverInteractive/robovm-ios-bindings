package org.robovm.bindings.app42;

import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class CategoryItem extends App42Response
{
	@Property(selector = "name")
	public native String getName();

	@Property(selector = "setName:", strongRef = true)
	public native void setName(String name);
	
	@Property(selector = "description")
	public native String getDescription();

	@Property(selector = "setDescription:", strongRef = true)
	public native void setDescription(String description);

	@Property(selector = "itemId")
	public native String getItemId();

	@Property(selector = "setItemId:", strongRef = true)
	public native void setItemId(String itemId);
	
	@Property(selector = "url")
	public native String getUrl();

	@Property(selector = "setUrl:", strongRef = true)
	public native void setUrl(String url);

	@Property(selector = "tinyUrl")
	public native String getTinyUrl();

	@Property(selector = "setTinyUrl:", strongRef = true)
	public native void setTinyUrl(String tinyUrl);
	
	@Property(selector = "price")
	public native double getPrice();

	@Property(selector = "setPrice:", strongRef = true)
	public native void setPrice(double price);
	
	@Property(selector = "categoryObject")
	public native CategoryData getCategory();

	@Property(selector = "setCategoryObject:", strongRef = true)
	public native void setCategory(CategoryData category);

	public CategoryItem(CategoryData catalogue) {
		super((SkipInit) null);
	    initObject(init(catalogue));
	}
	
	@Method(selector = "initWithCategory:")
	private native @Pointer long init(CategoryData catalogue);
}
