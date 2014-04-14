
package org.robovm.bindings.facebook;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSDate;
import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSMutableDictionary;
import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.foundation.NSString;
import org.robovm.apple.foundation.NSURL;
import org.robovm.bindings.facebook.session.FBSessionLoginType;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

/** Represents an access token used for the Facebook login flow and includes associated metadata such as expiration date and
 * permissions. You should use factory methods (createToken...) to construct instances and should be treated as immutable.
 * 
 * For more information, see https://developers.facebook.com/docs/concepts/login/access-tokens-and-types/. */
@NativeClass
public class FBAccessTokenData extends NSObject {

	private FBAccessTokenData () {
	}

	/** Creates an FBAccessTokenData from an App Link provided by the Facebook application or {@code null} if the url is not valid.
	 * 
	 * @param url The url provided.
	 * 
	 * @param appID needed in order to verify URL format.
	 * 
	 * @param urlSchemeSuffix needed in order to verify URL format. */
	@Method(selector = "createTokenFromFacebookURL:appID:urlSchemeSuffix:")
	public static native FBAccessTokenData create (NSURL url, String appID, String urlSchemeSuffix);

	/** Creates an FBAccessTokenData from a dictionary or returns {@code null} if required data is missing.
	 * 
	 * @param dictionary the dictionary with FBSessionTokenCachingStrategy keys. */
	@Method(selector = "createTokenFromDictionary:")
	public static native FBAccessTokenData create (NSDictionary<?, ?> dictionary);

	/** Creates an FBAccessTokenData from existing information or returns {@code null} if required data is missing.
	 * 
	 * @param accessToken The token string. If {@code null} or empty, this method will return {@code null}.
	 * 
	 * @param permissions The permissions set. A value of {@code null} indicates basic permissions.
	 * 
	 * @param expirationDate The expiration date. A value of {@code null} defaults to {@link NSDate#distantFuture()}.
	 * 
	 * @param loginType The login source of the token.
	 * 
	 * @param refreshDate The date that token was last refreshed. A value of {@code null} defaults to {@link NSDate#date()}. */
	@Method(selector = "createTokenFromString:permissions:expirationDate:loginType:refreshDate:")
	public static native FBAccessTokenData create (String accessToken, NSArray<NSString> permissions, NSDate expirationDate,
		FBSessionLoginType loginType, NSDate refreshDate);

	/** Creates an FBAccessTokenData from existing information or returns {@code null} if required data is missing.
	 * 
	 * @param accessToken The token string. If {@code null} or empty, this method will return {@code null}.
	 * 
	 * @param permissions The permissions set. A value of {@code null} indicates basic permissions.
	 * 
	 * @param expirationDate The expiration date. A value of {@code null} defaults to {@link NSDate#distantFuture()}.
	 * 
	 * @param loginType The login source of the token.
	 * 
	 * @param refreshDate The date that token was last refreshed. A value of {@code null} defaults to {@link NSDate#date()}.
	 * 
	 * @param permissionsRefreshDate The date the permissions were last refreshed. A value of {@code null} defaults to
	 *           {@link NSDate#distantPast()}. */
	@Method(selector = "createTokenFromString:permissions:expirationDate:loginType:refreshDate:permissionsRefreshDate:")
	public static native FBAccessTokenData create (String accessToken, NSArray<NSString> permissions, NSDate expirationDate,
		FBSessionLoginType loginType, NSDate refreshDate, NSDate permissionsRefreshDate);

	/** @return a dictionary representation of this instance. This is provided for backwards compatibility with previous access token
	 *         related APIs that used a NSDictionary.
	 * @see FBSessionTokenCachingStrategy. */
	@Method(selector = "dictionary")
	public native NSMutableDictionary<?, ?> getDictionary ();

	@Override
	public boolean equals (Object obj) {
		return super.equals(obj) && obj instanceof FBAccessTokenData && equals(obj);
	}

	/** @return a Boolean value that indicates whether a given object is an FBAccessTokenData object and exactly equal the receiver.
	 * 
	 * @param accessTokenData the data to compare to the receiver. */
	@Method(selector = "isEqualToAccessTokenData:")
	public native boolean equals (FBAccessTokenData other);

	/** @return the access token String. */
	@Property
	public native String getAccessToken ();

	/** @return the permissions associated with the access token. */
	@Property
	public native NSArray<?> getPermissions ();

	/** @return the login type associated with the token. */
	@Property
	public native FBSessionLoginType getLoginType ();

	/** @return the expiration date of the access token. */
	@Property
	public native NSDate getExpirationDate ();

	/** @return the date the token was last refreshed. */
	@Property
	public native NSDate getRefreshDate ();

	/** @return the date the permissions were last refreshed. */
	@Property
	public native NSDate getPermissionsRefreshDate ();
}
