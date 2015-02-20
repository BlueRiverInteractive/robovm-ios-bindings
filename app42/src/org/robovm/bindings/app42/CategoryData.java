package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSMutableArray;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class CategoryData extends App42Response
{
	@Property(selector = "name")
	public native String getName();

	@Property(selector = "setName:", strongRef = true)
	public native void setName(String name);
	
	@Property(selector = "description")
	public native String getDescription();

	@Property(selector = "setDescription:", strongRef = true)
	public native void setDescription(String description);
	
	@Property(selector = "itemListArray")
	public native NSMutableArray<?> getItemListArray();

	@Property(selector = "setItemListArray:", strongRef = true)
	public native void setItemListArray(NSMutableArray<?> itemListArray);
	
	@Property(selector = "catalogueObject")
	public native Catalogue getCatalogue();

	@Property(selector = "setCatalogueObject:", strongRef = true)
	public native void setCatalogue(Catalogue catalogue);
	
	public CategoryData(Catalogue catalogue) {
		super((SkipInit) null);
	    initObject(init(catalogue));
	}
	
	@Method(selector = "initWithCatalogue:")
	private native @Pointer long init(Catalogue catalogue);
}
