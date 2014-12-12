package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.uikit.UIImage;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class GPGSnapshotMetadataChangeCoverImage extends NSObject {

	@Method(selector = "initWithImage:")
	private native @Pointer long init(UIImage uiImage);
	
	public GPGSnapshotMetadataChangeCoverImage(UIImage uiImage) {
	    super((SkipInit)null);
	    initObject(init(uiImage));
	}
}
