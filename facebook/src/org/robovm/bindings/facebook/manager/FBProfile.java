
package org.robovm.bindings.facebook.manager;

import java.security.Permissions;

import org.robovm.cocoatouch.foundation.NSDictionary;
import org.robovm.cocoatouch.foundation.NSString;

public class FBProfile {
	private static final NSString ID = new NSString("id");
	private static final NSString NAME = new NSString("name");
	private static final NSString FIRST_NAME = new NSString("first_name");
	private static final NSString MIDDLE_NAME = new NSString("middle_name");
	private static final NSString LAST_NAME = new NSString("last_name");
	private static final NSString LINK = new NSString("link");
	private static final NSString USERNAME = new NSString("username");
	private static final NSString BIRTHDAY = new NSString("birthday");
	private static final NSString LOCALE = new NSString("locale");
	private static final NSString LANGUAGES = new NSString("languages");
	private static final NSString TIMEZONE = new NSString("timezone");
	private static final NSString BIO = new NSString("bio");
	private static final NSString EMAIL = new NSString("email");

	private final NSDictionary mGraphUser;

	private FBProfile (NSDictionary graphUser) {
		this.mGraphUser = graphUser;
	}

	/** Create new profile based on {@link GraphUser} instance.
	 * 
	 * @param graphUser The {@link GraphUser} instance
	 * @return */
	public static FBProfile create (NSDictionary graphUser) {
		return new FBProfile(graphUser);
	}

	/** Return the graph user
	 * 
	 * @return */
	public NSDictionary getGraphUser () {
		return mGraphUser;
	}

	/** Returns the ID of the user. <br>
	 * <br>
	 * <b> Permissions:</b><br>
	 * {@link Permissions#BASIC_INFO}
	 * 
	 * @return the ID of the user */
	public String getId () {
		return mGraphUser.get(ID).toString();
	}

	/** Returns the name of the user. <br>
	 * <br>
	 * <b> Permissions:</b><br>
	 * {@link Permissions#BASIC_INFO}
	 * 
	 * @return the name of the user */
	public String getName () {
		return mGraphUser.get(NAME).toString();
	}

	/** Returns the first name of the user. <br>
	 * <br>
	 * <b> Permissions:</b><br>
	 * {@link Permissions#BASIC_INFO}
	 * 
	 * @return the first name of the user */
	public String getFirstName () {
		return mGraphUser.get(FIRST_NAME).toString();
	}

	/** Returns the middle name of the user. <br>
	 * <br>
	 * <b> Permissions:</b><br>
	 * {@link Permissions#BASIC_INFO}
	 * 
	 * @return the middle name of the user */
	public String getMiddleName () {
		return mGraphUser.get(MIDDLE_NAME).toString();
	}

	/** Returns the last name of the user. <br>
	 * <br>
	 * <b> Permissions:</b><br>
	 * {@link Permissions#BASIC_INFO}
	 * 
	 * @return the last name of the user */
	public String getLastName () {
		return mGraphUser.get(LAST_NAME).toString();
	}

	/** Returns the Facebook URL of the user. <br>
	 * <br>
	 * <b> Permissions:</b><br>
	 * {@link Permissions#BASIC_INFO}
	 * 
	 * @return the Facebook URL of the user */
	public String getLink () {
		return mGraphUser.get(LINK).toString();
	}

	/** Returns the Facebook username of the user. <br>
	 * <br>
	 * <b> Permissions:</b><br>
	 * {@link Permissions#BASIC_INFO}
	 * 
	 * @return the Facebook username of the user */
	public String getUsername () {
		return mGraphUser.get(USERNAME).toString();
	}

	/** Returns the birthday of the user. <b>MM/DD/YYYY</b> format <br>
	 * <br>
	 * <b> Permissions:</b><br>
	 * {@link Permissions#USER_BIRTHDAY} <br>
	 * {@link Permissions#FRIENDS_BIRTHDAY}
	 * 
	 * @return the birthday of the user */
	public String getBirthday () {
		return mGraphUser.get(BIRTHDAY).toString();
	}

	/** Returns the current city of the user. <br>
	 * <br>
	 * <b> Permissions:</b><br>
	 * {@link Permissions#BASIC_INFO}
	 * 
	 * @return the current city of the user */
	// public FBGraphLocation getLocation() {
	// return mGraphUser.getLocation(); TODO
	// }

	/** Return the email of the user.<br>
	 * <br>
	 * <b> Permissions:</b> <br>
	 * {@link Permissions#EMAIL}
	 * 
	 * @return the email of the user */
	public String getEmail () {
		return mGraphUser.get(EMAIL).toString();
	}

	/** Return the ISO language code and ISO country code of the user. <br>
	 * <br>
	 * <b> Permissions:</b><br>
	 * {@link Permissions#BASIC_INFO}
	 * 
	 * @return the ISO language code and ISO country code of the user */
	public String getLocale () {
		return mGraphUser.get(LOCALE).toString();
	}

	/** Return the languages of the user.<br>
	 * <br>
	 * <b> Permissions:</b><br>
	 * {@link Permissions#USER_LIKES}
	 * 
	 * @return the languages of the user */
	// public List<Language> getLanguages() { TODO
	// List<Language> languages = new ArrayList<Language>();
	//
	// JSONArray jsonArray = (JSONArray) mGraphUser.getProperty(PROPERTY_LANGUAGES);
	// if (jsonArray != null) {
	// for (int i = 0; i < jsonArray.length(); i++) {
	// JSONObject jsonObject = jsonArray.optJSONObject(i);
	// int id = jsonObject.optInt(ID);
	// String name = jsonObject.optString(NAME);
	//
	// Language language = new Language();
	// language.setId(id);
	// language.setName(name);
	// languages.add(language);
	// }
	// }
	//
	// return languages;
	// }

	/** Return the timezone of the user.<br>
	 * <br>
	 * <b> Permissions:</b><br>
	 * {@link Permissions#BASIC_INFO}
	 * 
	 * <br>
	 * <br>
	 * <b>Note:</b> <br>
	 * Avaliable only for my profile
	 * 
	 * @return the timezone of the user */
	public int getTimeZone () {
		return Integer.valueOf(mGraphUser.get(TIMEZONE).toString());
	}

	/** Return the biography of the user.<br>
	 * <br>
	 * <b> Permissions:</b><br>
	 * {@link Permissions#USER_ABOUT_ME}<br>
	 * {@link Permissions#FRIENDS_ABOUT_ME}
	 * 
	 * @return the biography of the user */
	public String getBio () {
		return mGraphUser.get(BIO).toString();
	}
}
