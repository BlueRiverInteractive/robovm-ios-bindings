
package org.robovm.apple.temp;

import org.robovm.apple.foundation.NSError;
import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.foundation.NSString;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

@Library("AVFoundation")
@NativeClass
public class AVAudioSession extends NSObject {
	static {
		ObjCRuntime.bind(AVAudioSession.class);
	}

	private static final ObjCClass objCClass = ObjCClass.getByType(AVAudioSession.class);

	private AVAudioSession () {
	}

	// + (id)sharedInstance;
	private static final Selector sharedInstance = Selector.register("sharedInstance");

	@Bridge
	private native static AVAudioSession objc_sharedInstance (ObjCClass __self__, Selector __cmd__);

	public static AVAudioSession getSharedInstance () {
		return objc_sharedInstance(objCClass, sharedInstance);
	}

	public static final NSString CategoryAmbient = new NSString("AVAudioSessionCategoryAmbient");

	// - (BOOL)setCategory:(NSString *)category error:(NSError **)outError;
	private static final Selector setCategory$error$ = Selector.register("setCategory:error:");

	@Bridge
	private native static boolean objc_setCategoryError (AVAudioSession __self__, Selector __cmd__, NSString category,
		NSError error);

	public boolean setCategory (NSString category, NSError outError) {
		return objc_setCategoryError(this, setCategory$error$, category, outError);
	}

	// @property(readonly) NSString * category;
	private static final Selector category = Selector.register("category");

	@Bridge
	private native static NSString objc_getCategory (AVAudioSession __self__, Selector __cmd__);

	public String getCategory () {
		return objc_getCategory(this, category).toString();
	}
}
