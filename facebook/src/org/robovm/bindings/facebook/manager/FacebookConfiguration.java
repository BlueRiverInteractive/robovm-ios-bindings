
package org.robovm.bindings.facebook.manager;

import java.util.ArrayList;
import java.util.List;

import org.robovm.bindings.facebook.FBSessionDefaultAudience;
import org.robovm.bindings.facebook.FBSessionLoginBehavior;

/** <p>
 * This class provides all the necessary settings for Facebook to work correctly. Use the Builder to create a new configuration.
 * </p>
 * Settings to change:
 * <ul>
 * <li>appId</li>
 * <li>namespace</li>
 * <li>read and publish permissions</li>
 * <li>login behavior</li>
 * <li>default audience</li>
 * <ul> */
public class FacebookConfiguration {
	private final String appId;
	private final String namespace;
	private List<String> readPermissions = null;
	private List<String> publishPermissions = null;
	private FBSessionDefaultAudience defaultAudience = null;
	private FBSessionLoginBehavior loginBehavior = null;

	private FacebookConfiguration (Builder builder) {
		appId = builder.appId;
		namespace = builder.namespace;
		readPermissions = builder.readPermissions;
		publishPermissions = builder.publishPermissions;
		defaultAudience = builder.defaultAudience;
		loginBehavior = builder.loginBehavior;
	}

	/** Get Facebook application id. */
	String getAppId () {
		return appId;
	}

	/** Get application namespace. */
	String getNamespace () {
		return namespace;
	}

	/** Get read permissions. */
	List<String> getReadPermissions () {
		return readPermissions;
	}

	/** Get publish permissions. */
	List<String> getPublishPermissions () {
		return publishPermissions;
	}

	/** Get session login behavior. n */
	FBSessionLoginBehavior getSessionLoginBehavior () {
		return loginBehavior;
	}

	/** Get session default audience. */
	FBSessionDefaultAudience getSessionDefaultAudience () {
		return defaultAudience;
	}

	public static class Builder {
		private String appId = null;
		private String namespace = null;
		private final List<String> readPermissions = new ArrayList<String>();
		private final List<String> publishPermissions = new ArrayList<String>();
		private FBSessionDefaultAudience defaultAudience = FBSessionDefaultAudience.Friends;
		private FBSessionLoginBehavior loginBehavior = FBSessionLoginBehavior.FallbackToWebView;

		public Builder () {
		}

		/** Set Facebook application id. <br>
		 * The application id is located in the dashboard of the app in the admin panel of Facebook.
		 * 
		 * @param appId */
		public Builder setAppId (String appId) {
			this.appId = appId;
			return this;
		}

		/** Set application namespace.
		 * 
		 * @param namespace
		 * @return */
		public Builder setNamespace (String namespace) {
			this.namespace = namespace;
			return this;
		}

		/** Set the array of permissions you want to use in your application.
		 * 
		 * @param permissions */
		public Builder setPermissions (FBPermission[] permissions) {
			for (FBPermission permission : permissions) {
				switch (permission.getType()) {
				case READ:
					readPermissions.add(permission.getValue());
					break;
				case PUBLISH:
					publishPermissions.add(permission.getValue());
					break;
				default:
					break;
				}
			}

			return this;
		}

		/** Set default audience.
		 * 
		 * @param defaultAudience */
		public Builder setDefaultAudience (FBSessionDefaultAudience defaultAudience) {
			this.defaultAudience = defaultAudience;
			return this;
		}

		/** Set the login behavior.
		 * 
		 * @param loginBehavior */
		public Builder setLoginBehavior (FBSessionLoginBehavior loginBehavior) {
			this.loginBehavior = loginBehavior;
			return this;
		}

		/** Build the configuration. */
		public FacebookConfiguration build () {
			return new FacebookConfiguration(this);
		}
	}
}
