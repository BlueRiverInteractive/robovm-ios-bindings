
package org.robovm.bindings.facebook;

import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSString;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

/** The FBGraphUser protocol enables typed access to a user object as represented in the Graph API.
 * 
 * The FBGraphUser protocol represents the most commonly used properties of a Facebook user object. It may be used to access an
 * {@link NSDictionary} object that has been wrapped with an {@link FBGraphObject} facade. */
@NativeClass
public class FBGraphUser extends FBGraphObject {
	public FBGraphUser (NSDictionary<?, ?> data) {
		Object id = data.get(new NSString("id"));
		if (id != null) setId(id.toString());
		Object name = data.get(new NSString("name"));
		if (name != null) setName(name.toString());
		Object first_name = data.get(new NSString("first_name"));
		if (first_name != null) setFirstName(first_name.toString());
		Object middle_name = data.get(new NSString("middle_name"));
		if (middle_name != null) setMiddleName(middle_name.toString());
		Object last_name = data.get(new NSString("last_name"));
		if (last_name != null) setLastName(last_name.toString());
		Object link = data.get(new NSString("link"));
		if (link != null) setLink(link.toString());
		Object username = data.get(new NSString("username"));
		if (username != null) setUsername(username.toString());
		Object birthday = data.get(new NSString("birthday"));
		if (birthday != null) setBirthday(birthday.toString());
	}

	@Property
	public native String getId ();

	/** Typed access to the user's ID. */
	@Property
	public native void setId (String id);

	@Property
	public native String getName ();

	/** Typed access to the user's name. */
	@Property
	public native void setName (String name);

	@Property(selector = "first_name")
	public native String getFirstName ();

	/** Typed access to the user's first name. */
	@Property(selector = "setFirst_name:")
	public native void setFirstName (String name);

	@Property(selector = "middle_name")
	public native String getMiddleName ();

	/** Typed access to the user's middle name. */
	@Property(selector = "setMiddle_name:")
	public native void setMiddleName (String name);

	@Property(selector = "last_name")
	public native String getLastName ();

	/** Typed access to the user's last name. */
	@Property(selector = "setLast_name:")
	public native void setLastName (String name);

	@Property
	public native String getLink ();

	/** Typed access to the user's profile URL. */
	@Property
	public native void setLink (String link);

	@Property
	public native String getUsername ();

	/** Typed access to the user's username. */
	public native void setUsername (String username);

	public native String getBirthday ();

	/** Typed access to the user's birthday. */
	public native void setBirthday (String birthday);

	@Property
	public native FBGraphPlace getLocation ();

	/** Typed access to the user's current city. */
	@Property
	public native void setLocation (FBGraphPlace location);
}
