
package org.robovm.bindings.gpp;

import org.robovm.cocoatouch.foundation.NSArray;
import org.robovm.cocoatouch.foundation.NSData;
import org.robovm.cocoatouch.foundation.NSURL;
import org.robovm.cocoatouch.uikit.UIImage;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.rt.bro.annotation.Bridge;

public class GPPNativeShareBuilderImpl extends GPPShareBuilderImpl implements GPPNativeShareBuilder {

	static {
		ObjCRuntime.bind();
	}

	// Attaches an image to be shared. If there is an existing media attachment, it is replaced.
	// If |imageAttachment| is nil, this method does nothing and returns nil.
	// This method cannot be called in combination with either |setURLToShare:| or
	// |setTitle:description:thumbnailURL:|.
	// - (id<GPPNativeShareBuilder>)attachImage:(UIImage *)imageAttachment;
	private static final Selector attachImage$ = Selector.register("attachImage:");

	@Bridge
	private native static GPPNativeShareBuilderImpl objc_attachImage (GPPNativeShareBuilderImpl __self__, Selector __cmd__,
		UIImage imageAttachment);

	@Override
	public GPPNativeShareBuilderImpl attachImage (UIImage imageAttachment) {
		return objc_attachImage(this, attachImage$, imageAttachment);
	}

	// Attaches an image to be shared, created from @param |imageData|. This should be used only if
	// there is metadata attached to the image that should be preserved. If there is an existing media
	// attachment, it is replaced. If @param |imageData| is nil, return nil. This method cannot be
	// called in combination with either |setURLToShare:| or |setTitle:description:thumbnailURL:|.
	// - (id<GPPNativeShareBuilder>)attachImageData:(NSData *)imageData;
	private static final Selector attachImageData$ = Selector.register("attachImageData:");

	@Bridge
	private native static GPPNativeShareBuilderImpl objc_attachImageData (GPPNativeShareBuilderImpl __self__, Selector __cmd__,
		NSData imageData);

	@Override
	public GPPNativeShareBuilderImpl attachImageData (NSData imageData) {
		return objc_attachImageData(this, attachImageData$, imageData);
	}

	// Attaches a video to be shared. If there is an existing media attachment, it is replaced.
	// The video URL should be a local URL referencing a file on the device. If the URL is invalid,
	// this method does nothing and returns nil.
	// This method cannot be called in combination with either |setURLToShare:| or
	// |setTitle:description:thumbnailURL:|.
	// - (id<GPPNativeShareBuilder>)attachVideoURL:(NSURL *)videoAttachment;
	private static final Selector attachVideoURL$ = Selector.register("attachVideoURL:");

	@Bridge
	private native static GPPNativeShareBuilderImpl objc_attachVideoURL (GPPNativeShareBuilderImpl __self__, Selector __cmd__,
		NSURL videoAttachment);

	@Override
	public GPPNativeShareBuilderImpl attachVideoURL (NSURL videoAttachment) {
		return objc_attachVideoURL(this, attachVideoURL$, videoAttachment);
	}

	// Pre-selects people for the post audience. |peopleIDs| is an array of |NSString| objects
	// representing IDs of selected people in the post.
	// At least 1 person and at most 10 people can be pre-selected if this method is called.
	// - (id<GPPNativeShareBuilder>)setPreselectedPeopleIDs:(NSArray *)preselectedPeopleIDs;
	private static final Selector setPreselectedPeopleIDs$ = Selector.register("setPreselectedPeopleIDs:");

	@Bridge
	private native static GPPNativeShareBuilderImpl objc_setPreselectedPeopleIDs (GPPNativeShareBuilderImpl __self__,
		Selector __cmd__, NSArray preselectedPeopleIDs);

	@Override
	public GPPNativeShareBuilderImpl setPreselectedPeopleIDs (NSArray preselectedPeopleIDs) {
		return objc_setPreselectedPeopleIDs(this, attachImageData$, preselectedPeopleIDs);
	}

}
