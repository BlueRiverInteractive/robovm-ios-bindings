
package org.robovm.bindings.facebook;

import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

/*!
 @protocol

 @abstract
 The `FBGraphUser` protocol enables typed access to a user object
 as represented in the Graph API.


 @discussion
 The `FBGraphUser` protocol represents the most commonly used properties of a
 Facebook user object. It may be used to access an `NSDictionary` object that has
 been wrapped with an <FBGraphObject> facade.
 */
@Library(Library.INTERNAL)
@NativeClass()
public class FBGraphUser extends FBGraphObject {
	private static final ObjCClass objCClass = ObjCClass.getByType(FBGraphUser.class);

	static {
		ObjCRuntime.bind(FBGraphUser.class);
	}

	// protected FBGraphUser(SkipInit skipInit) {
	// super(skipInit);
	// }
	//
	// public FBGraphUser() {
	// }
	//
	// public FBGraphUser(NSDictionary<?, ?> data) {
	// Object id = data.get(new NSString("id"));
	// if (id != null)
	// setId(id.toString());
	// Object name = data.get(new NSString("name"));
	// if (name != null)
	// setName(name.toString());
	// Object first_name = data.get(new NSString("first_name"));
	// if (first_name != null)
	// setFirstName(first_name.toString());
	// Object middle_name = data.get(new NSString("middle_name"));
	// if (middle_name != null)
	// setMiddleName(middle_name.toString());
	// Object last_name = data.get(new NSString("last_name"));
	// if (last_name != null)
	// setLastName(last_name.toString());
	// Object link = data.get(new NSString("link"));
	// if (link != null)
	// setLink(link.toString());
	// Object username = data.get(new NSString("username"));
	// if (username != null)
	// setUsername(username.toString());
	// Object birthday = data.get(new NSString("birthday"));
	// if (birthday != null)
	// setBirthday(birthday.toString());
	// }

	/*
	 * !
	 * 
	 * @property
	 * 
	 * @abstract Typed access to the user's ID.
	 */
	private static final Selector id = Selector.register("id");

	@Bridge
	private native static String objc_id (FBGraphUser __self__, Selector __cmd__);

	public String getId () {
		return objc_id(this, id);
	}

	private static final Selector setId$ = Selector.register("setId:");

	@Bridge
	private native static void objc_setId$ (FBGraphUser __self__, Selector __cmd__, String id);

	public void setId (String id) {
		objc_setId$(this, setId$, id);
	}

	/*
	 * !
	 * 
	 * @property
	 * 
	 * @abstract Typed access to the user's name.
	 */
	private static final Selector name = Selector.register("name");

	@Bridge
	private native static String objc_name (FBGraphUser __self__, Selector __cmd__);

	public String getName () {
		return objc_name(this, name);
	}

	private static final Selector setName$ = Selector.register("setName:");

	@Bridge
	private native static void objc_setName$ (FBGraphUser __self__, Selector __cmd__, String name);

	public void setName (String name) {
		objc_setName$(this, setName$, name);
	}

	/*
	 * !
	 * 
	 * @property
	 * 
	 * @abstract Typed access to the user's first name.
	 */
	private static final Selector first_name = Selector.register("first_name");

	@Bridge
	private native static String objc_first_name (FBGraphUser __self__, Selector __cmd__);

	public String getFirstName () {
		return objc_first_name(this, first_name);
	}

	private static final Selector setFirst_name$ = Selector.register("setFirst_name:");

	@Bridge
	private native static void objc_setFirst_name$ (FBGraphUser __self__, Selector __cmd__, String name);

	public void setFirstName (String name) {
		objc_setFirst_name$(this, setFirst_name$, name);
	}

	/*
	 * !
	 * 
	 * @property
	 * 
	 * @abstract Typed access to the user's middle name.
	 */
	private static final Selector middle_name = Selector.register("middle_name");

	@Bridge
	private native static String objc_middle_name (FBGraphUser __self__, Selector __cmd__);

	public String getMiddleName () {
		return objc_middle_name(this, middle_name);
	}

	private static final Selector setMiddle_name$ = Selector.register("setMiddle_name:");

	@Bridge
	private native static void objc_setMiddle_name$ (FBGraphUser __self__, Selector __cmd__, String name);

	public void setMiddleName (String name) {
		objc_setMiddle_name$(this, setMiddle_name$, name);
	}

	/*
	 * !
	 * 
	 * @property
	 * 
	 * @abstract Typed access to the user's last name.
	 */
	private static final Selector last_name = Selector.register("last_name");

	@Bridge
	private native static String objc_last_name (FBGraphUser __self__, Selector __cmd__);

	public String getLastName () {
		return objc_last_name(this, last_name);
	}

	private static final Selector setLast_name$ = Selector.register("setLast_name:");

	@Bridge
	private native static void objc_setLast_name$ (FBGraphUser __self__, Selector __cmd__, String name);

	public void setLastName (String name) {
		objc_setLast_name$(this, setLast_name$, name);
	}

	/*
	 * !
	 * 
	 * @property
	 * 
	 * @abstract Typed access to the user's profile URL.
	 */
	private static final Selector link = Selector.register("link");

	@Bridge
	private native static String objc_link (FBGraphUser __self__, Selector __cmd__);

	public String getLink () {
		return objc_link(this, link);
	}

	private static final Selector setLink$ = Selector.register("setLink:");

	@Bridge
	private native static void objc_setLink$ (FBGraphUser __self__, Selector __cmd__, String link);

	public void setLink (String link) {
		objc_setLink$(this, setLink$, link);
	}

	/*
	 * !
	 * 
	 * @property
	 * 
	 * @abstract Typed access to the user's username.
	 */
	private static final Selector username = Selector.register("username");

	@Bridge
	private native static String objc_username (FBGraphUser __self__, Selector __cmd__);

	public String getUsername () {
		return objc_username(this, username);
	}

	private static final Selector setUsername$ = Selector.register("setUsername:");

	@Bridge
	private native static void objc_setUsername$ (FBGraphUser __self__, Selector __cmd__, String username);

	public void setUsername (String username) {
		objc_setUsername$(this, setUsername$, username);
	}

	/*
	 * !
	 * 
	 * @property
	 * 
	 * @abstract Typed access to the user's birthday.
	 */
	private static final Selector birthday = Selector.register("birthday");

	@Bridge
	private native static String objc_birthday (FBGraphUser __self__, Selector __cmd__);

	public String getBirthday () {
		return objc_birthday(this, birthday);
	}

	private static final Selector setBirthday$ = Selector.register("setBirthday:");

	@Bridge
	private native static void objc_setBirthday$ (FBGraphUser __self__, Selector __cmd__, String birthday);

	public void setBirthday (String birthday) {
		objc_setBirthday$(this, setBirthday$, birthday);
	}

	/*
	 * !
	 * 
	 * @property
	 * 
	 * @abstract Typed access to the user's current city.
	 */
	// @property (retain, nonatomic) id<FBGraphPlace> location; TODO
}
