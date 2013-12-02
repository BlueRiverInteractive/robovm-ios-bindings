
package org.robovm.bindings.gpp;

import org.robovm.cocoatouch.foundation.NSArray;
import org.robovm.cocoatouch.foundation.NSData;
import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSObjectProtocol;
import org.robovm.cocoatouch.foundation.NSURL;
import org.robovm.cocoatouch.uikit.UIImage;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.BindSelector;
import org.robovm.objc.annotation.NotImplemented;
import org.robovm.rt.bro.annotation.Callback;

@SuppressWarnings("rawtypes")
public interface GPPNativeShareBuilder extends NSObjectProtocol {
	// Attaches an image to be shared. If there is an existing media attachment, it is replaced.
	// If |imageAttachment| is nil, this method does nothing and returns nil.
	// This method cannot be called in combination with either |setURLToShare:| or
	// |setTitle:description:thumbnailURL:|.
	// - (id<GPPNativeShareBuilder>)attachImage:(UIImage *)imageAttachment;
	public GPPNativeShareBuilder attachImage (UIImage imageAttachment);

	// Attaches an image to be shared, created from @param |imageData|. This should be used only if
	// there is metadata attached to the image that should be preserved. If there is an existing media
	// attachment, it is replaced. If @param |imageData| is nil, return nil. This method cannot be
	// called in combination with either |setURLToShare:| or |setTitle:description:thumbnailURL:|.
	// - (id<GPPNativeShareBuilder>)attachImageData:(NSData *)imageData;
	public GPPNativeShareBuilder attachImageData (NSData imageData);

	// Attaches a video to be shared. If there is an existing media attachment, it is replaced.
	// The video URL should be a local URL referencing a file on the device. If the URL is invalid,
	// this method does nothing and returns nil.
	// This method cannot be called in combination with either |setURLToShare:| or
	// |setTitle:description:thumbnailURL:|.
	// - (id<GPPNativeShareBuilder>)attachVideoURL:(NSURL *)videoAttachment;
	public GPPNativeShareBuilder attachVideoURL (NSURL videoAttachment);

	// Pre-selects people for the post audience. |peopleIDs| is an array of |NSString| objects
	// representing IDs of selected people in the post.
	// At least 1 person and at most 10 people can be pre-selected if this method is called.
	// - (id<GPPNativeShareBuilder>)setPreselectedPeopleIDs:(NSArray *)preselectedPeopleIDs;
	public GPPNativeShareBuilder setPreselectedPeopleIDs (NSArray preselectedPeopleIDs);

	public static class Adapter extends NSObject implements GPPNativeShareBuilder {

		@NotImplemented("attachImage:")
		@Override
		public GPPNativeShareBuilder attachImage (UIImage imageAttachment) {
			// TODO Auto-generated method stub
			return null;
		}

		@NotImplemented("attachImageData:")
		@Override
		public GPPNativeShareBuilder attachImageData (NSData imageData) {
			// TODO Auto-generated method stub
			return null;
		}

		@NotImplemented("attachVideoURL:")
		@Override
		public GPPNativeShareBuilder attachVideoURL (NSURL videoAttachment) {
			// TODO Auto-generated method stub
			return null;
		}

		@NotImplemented("setPreselectedPeopleIDs:")
		@Override
		public GPPNativeShareBuilder setPreselectedPeopleIDs (NSArray preselectedPeopleIDs) {
			// TODO Auto-generated method stub
			return null;
		}

	}

	static class Callbacks {

		// - (id<GPPNativeShareBuilder>)attachImage:(UIImage *)imageAttachment;
		@Callback
		@BindSelector("attachImage:")
		public static GPPNativeShareBuilder objc_attachImage (GPPNativeShareBuilder __self__, Selector __cmd__,
			UIImage imageAttachment) {
			return __self__.attachImage(imageAttachment);
		}

		// - (id<GPPNativeShareBuilder>)attachImageData:(NSData *)imageData;
		@Callback
		@BindSelector("attachImageData:")
		public static GPPNativeShareBuilder objc_attachImageData (GPPNativeShareBuilder __self__, Selector __cmd__, NSData imageData) {
			return __self__.attachImageData(imageData);
		}

		// - (id<GPPNativeShareBuilder>)attachVideoURL:(NSURL *)videoAttachment;
		@Callback
		@BindSelector("attachVideoURL:")
		public static GPPNativeShareBuilder objc_attachVideoURL (GPPNativeShareBuilder __self__, Selector __cmd__,
			NSURL videoAttachment) {
			return __self__.attachVideoURL(videoAttachment);
		}

		// - (id<GPPNativeShareBuilder>)setPreselectedPeopleIDs:(NSArray *)preselectedPeopleIDs;
		@Callback
		@BindSelector("setPreselectedPeopleIDs:")
		public static GPPNativeShareBuilder objc_setPreselectedPeopleIDs (GPPNativeShareBuilder __self__, Selector __cmd__,
			NSArray preselectedPeopleIDs) {
			return __self__.setPreselectedPeopleIDs(preselectedPeopleIDs);
		}
	}
}
