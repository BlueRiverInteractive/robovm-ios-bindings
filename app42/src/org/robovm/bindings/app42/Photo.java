package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSArray;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class Photo extends App42Response
{
	@Property(selector = "name")
	public native String getName();

	@Property(selector = "setName:", strongRef = true)
	public native void setName(String name);

	@Property(selector = "description")
	public native String getDescription();

	@Property(selector = "setDescription:", strongRef = true)
	public native void setDescription(String description);

	@Property(selector = "url")
	public native String getUrl();

	@Property(selector = "setUrl:", strongRef = true)
	public native void setUrl(String url);
	
	@Property(selector = "tinyUrl")
	public native String getTinyUrl();

	@Property(selector = "setTinyUrl:", strongRef = true)
	public native void setTinyUrl(String tinyUrl);

	@Property(selector = "thumbNailUrl")
	public native String getThumbNailUrl();

	@Property(selector = "setThumbNailUrl:", strongRef = true)
	public native void setThumbNailUrl(String thumbNailUrl);

	@Property(selector = "thumbNailTinyUrl")
	public native String getThumbNailTinyUrl();

	@Property(selector = "setThumbNailTinyUrl:", strongRef = true)
	public native void setThumbNailTinyUrl(String thumbNailTinyUrl);

	@Property(selector = "createdOn")
	public native String getCreatedOn();

	@Property(selector = "setCreatedOn:", strongRef = true)
	public native void setCreatedOn(String createdOn);

	@Property(selector = "albumObject")
	public native Album getAlbum();

	@Property(selector = "setAlbumObject:", strongRef = true)
	public native void setAlbum(Album album);

	@Property(selector = "tagList")
	public native NSArray<?> getTagList();

	@Property(selector = "setTagList:", strongRef = true)
	public native void setTagList(NSArray<?> tagList);

	public Photo(Album album) {
		super((SkipInit) null);
	    initObject(init(album));
	}
	
	@Method(selector = "initWithAlbum:")
	private native @Pointer long init(Album album);
}
