
package org.robovm.bindings.facebook;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSMutableDictionary;
import org.robovm.apple.foundation.NSObject;
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

	/*
	 * !
	 * 
	 * @method
	 * 
	 * @abstract Creates an FBAccessTokenData from an App Link provided by the Facebook application or nil if the url is not valid.
	 * 
	 * @param url The url provided.
	 * 
	 * @param appID needed in order to verify URL format.
	 * 
	 * @param urlSchemeSuffix needed in order to verify URL format.
	 */
	// + (FBAccessTokenData *) createTokenFromFacebookURL:(NSURL *)url appID:(NSString *)appID urlSchemeSuffix:(NSString
// *)urlSchemeSuffix;

	/*
	 * !
	 * 
	 * @method
	 * 
	 * @abstract Creates an FBAccessTokenData from a dictionary or returns nil if required data is missing.
	 * 
	 * @param dictionary the dictionary with FBSessionTokenCachingStrategy keys.
	 */
	// + (FBAccessTokenData *) createTokenFromDictionary:(NSDictionary *)dictionary;

	/*
	 * !
	 * 
	 * @method
	 * 
	 * @abstract Creates an FBAccessTokenData from existing information or returns nil if required data is missing.
	 * 
	 * @param accessToken The token string. If nil or empty, this method will return nil.
	 * 
	 * @param permissions The permissions set. A value of nil indicates basic permissions.
	 * 
	 * @param expirationDate The expiration date. A value of nil defaults to `[NSDate distantFuture]`.
	 * 
	 * @param loginType The login source of the token.
	 * 
	 * @param refreshDate The date that token was last refreshed. A value of nil defaults to `[NSDate date]`.
	 */
	// + (FBAccessTokenData *) createTokenFromString:(NSString *)accessToken
	// permissions:(NSArray *)permissions
	// expirationDate:(NSDate *)expirationDate
	// loginType:(FBSessionLoginType)loginType
	// refreshDate:(NSDate *)refreshDate;

	/*
	 * !
	 * 
	 * @method
	 * 
	 * @abstract Creates an FBAccessTokenData from existing information or returns nil if required data is missing.
	 * 
	 * @param accessToken The token string. If nil or empty, this method will return nil.
	 * 
	 * @param permissions The permissions set. A value of nil indicates basic permissions.
	 * 
	 * @param expirationDate The expiration date. A value of nil defaults to `[NSDate distantFuture]`.
	 * 
	 * @param loginType The login source of the token.
	 * 
	 * @param refreshDate The date that token was last refreshed. A value of nil defaults to `[NSDate date]`.
	 * 
	 * @param permissionsRefreshDate The date the permissions were last refreshed. A value of nil defaults to `[NSDate
	 * distantPast]`.
	 */
	// + (FBAccessTokenData *) createTokenFromString:(NSString *)accessToken
	// permissions:(NSArray *)permissions
	// expirationDate:(NSDate *)expirationDate
	// loginType:(FBSessionLoginType)loginType
	// refreshDate:(NSDate *)refreshDate
	// permissionsRefreshDate:(NSDate *)permissionsRefreshDate;

	/** @return a dictionary representation of this instance. This is provided for backwards compatibility with previous access token
	 *         related APIs that used a NSDictionary.
	 * @see FBSessionTokenCachingStrategy. */
	@Method(selector = "dictionary")
	public native NSMutableDictionary<?, ?> getDictionary ();

	/*
	 * !
	 * 
	 * @method
	 * 
	 * @abstract Returns a Boolean value that indicates whether a given object is an FBAccessTokenData object and exactly equal the
	 * receiver.
	 * 
	 * @param accessTokenData the data to compare to the receiver.
	 */
	// - (BOOL) isEqualToAccessTokenData:(FBAccessTokenData *)accessTokenData;

	/** @return the access token String. */
	@Property
	public native String getAccessToken ();

	/** @return the permissions associated with the access token. */
	@Property
	public native NSArray<?> getPermissions ();

	/** @return the login type associated with the token. */
	@Property
	public native FBSessionLoginType getLoginType ();
	/*
	 * !
	 * 
	 * @abstract returns the expiration date of the access token.
	 */
	// @property (readonly, nonatomic, copy) NSDate *expirationDate;
	/*
	 * !
	 * 
	 * @abstract returns the date the token was last refreshed.
	 */
	// @property (readonly, nonatomic, copy) NSDate *refreshDate;

	/*
	 * !
	 * 
	 * @abstract returns the date the permissions were last refreshed.
	 */
	// @property (readonly, nonatomic, copy) NSDate *permissionsRefreshDate;
}
