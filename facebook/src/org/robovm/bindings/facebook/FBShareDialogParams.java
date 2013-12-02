
package org.robovm.bindings.facebook;

import org.robovm.cocoatouch.foundation.NSArray;
import org.robovm.cocoatouch.foundation.NSURL;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

/*!
 @class FBShareDialogParams

 @abstract
 This object is used to encapsulate state for parameters to a share dialog that
 opens in the Facebook app.
 */
@Library(Library.INTERNAL)
@NativeClass()
public class FBShareDialogParams extends FBDialogsParams {
	private static final ObjCClass objCClass = ObjCClass.getByType(FBShareDialogParams.class);

	static {
		ObjCRuntime.bind(FBShareDialogParams.class);
	}

	/*
	 * ! @abstract The URL link to be attached to the post. Only "http" or "https" schemes are supported.
	 */
	// @property (nonatomic, copy) NSURL *link;
	private static final Selector link = Selector.register("link");

	@Bridge
	private native static NSURL objc_link (FBShareDialogParams __self__, Selector __cmd__);

	public NSURL getLink () {
		return objc_link(this, link);
	}

	private static final Selector setLink$ = Selector.register("setLink:");

	@Bridge
	private native static void objc_setLink$ (FBShareDialogParams __self__, Selector __cmd__, NSURL link);

	public void setLink (NSURL link) {
		objc_setLink$(this, setLink$, link);
	}

	/*
	 * ! @abstract The name, or title associated with the link. Is only used if the link is non-nil.
	 */
	// @property (nonatomic, copy) NSString *name;
	private static final Selector name = Selector.register("name");

	@Bridge
	private native static String objc_name (FBShareDialogParams __self__, Selector __cmd__);

	public String getName () {
		return objc_name(this, name);
	}

	private static final Selector setName$ = Selector.register("setName:");

	@Bridge
	private native static void objc_setName$ (FBShareDialogParams __self__, Selector __cmd__, String name);

	public void setName (String name) {
		objc_setName$(this, setName$, name);
	}

	/*
	 * ! @abstract The caption to be used with the link. Is only used if the link is non-nil.
	 */
	// @property (nonatomic, copy) NSString *caption;
	private static final Selector caption = Selector.register("caption");

	@Bridge
	private native static String objc_caption (FBShareDialogParams __self__, Selector __cmd__);

	public String getCaption () {
		return objc_caption(this, caption);
	}

	private static final Selector setCaption$ = Selector.register("setCaption:");

	@Bridge
	private native static void objc_setCaption$ (FBShareDialogParams __self__, Selector __cmd__, String caption);

	public void setCaption (String caption) {
		objc_setCaption$(this, setCaption$, caption);
	}

	/*
	 * ! @abstract The description associated with the link. Is only used if the link is non-nil.
	 */
	// @property (nonatomic, copy) NSString *description;
	private static final Selector description = Selector.register("description");

	@Bridge
	private native static String objc_description (FBShareDialogParams __self__, Selector __cmd__);

	public String getDescription () {
		return objc_description(this, description);
	}

	private static final Selector setDescription$ = Selector.register("setDescription:");

	@Bridge
	private native static void objc_setDescription$ (FBShareDialogParams __self__, Selector __cmd__, String description);

	public void setDescription (String description) {
		objc_setDescription$(this, setDescription$, description);
	}

	/*
	 * ! @abstract The link to a thumbnail to associate with the post. Is only used if the link is non-nil. Only "http" or "https"
	 * schemes are supported.
	 */
	// @property (nonatomic, copy) NSURL *picture;
	private static final Selector picture = Selector.register("picture");

	@Bridge
	private native static NSURL objc_picture (FBShareDialogParams __self__, Selector __cmd__);

	public NSURL getPicture () {
		return objc_picture(this, picture);
	}

	private static final Selector setPicture$ = Selector.register("setPicture:");

	@Bridge
	private native static void objc_setPicture$ (FBShareDialogParams __self__, Selector __cmd__, NSURL picture);

	public void setPicture (NSURL picture) {
		objc_setPicture$(this, setPicture$, picture);
	}

	/*
	 * ! @abstract An array of NSStrings or FBGraphUsers to tag in the post. If using NSStrings, the values must represent the IDs
	 * of the users to tag.
	 */
	// @property (nonatomic, copy) NSArray *friends;
	private static final Selector friends = Selector.register("friends");

	@Bridge
	private native static NSArray objc_friends (FBShareDialogParams __self__, Selector __cmd__);

	public NSArray getFriends () {
		return objc_friends(this, friends);
	}

	private static final Selector setFriends$ = Selector.register("setFriends:");

	@Bridge
	private native static void objc_setFriends$ (FBShareDialogParams __self__, Selector __cmd__, NSArray friends);

	public void setFriends (NSArray friends) {
		objc_setFriends$(this, setFriends$, friends);
	}

	/*
	 * ! @abstract An NSString or FBGraphPlace to tag in the status update. If NSString, the value must be the ID of the place to
	 * tag.
	 */
	// @property (nonatomic, copy) id place;

	/*
	 * ! @abstract A text reference for the category of the post, used on Facebook Insights.
	 */
	// @property (nonatomic, copy) NSString *ref;

	/*
	 * ! @abstract If YES, treats any data failures (e.g. failures when getting data for IDs passed through "friends" or "place")
	 * as a fatal error, and will not continue with the status update.
	 */
	// @property (nonatomic, assign) BOOL dataFailuresFatal;
}
