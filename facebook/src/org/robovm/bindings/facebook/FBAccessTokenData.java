
package org.robovm.bindings.facebook;

import org.robovm.cocoatouch.foundation.NSArray;
import org.robovm.cocoatouch.foundation.NSMutableDictionary;
import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

/*!
 @class FBAccessTokenData

 @abstract Represents an access token used for the Facebook login flow
 and includes associated metadata such as expiration date and permissions.
 You should use factory methods (createToken...) to construct instances
 and should be treated as immutable.

 @discussion For more information, see
 https://developers.facebook.com/docs/concepts/login/access-tokens-and-types/.
 */
@Library(Library.INTERNAL)
@NativeClass()
public class FBAccessTokenData extends NSObject {
	private static final ObjCClass objCClass = ObjCClass.getByType(FBAccessTokenData.class);

	static {
		ObjCRuntime.bind(FBAccessTokenData.class);
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

	/*
	 * !
	 * 
	 * @method
	 * 
	 * @abstract Returns a dictionary representation of this instance.
	 * 
	 * @discussion This is provided for backwards compatibility with previous access token related APIs that used a NSDictionary
	 * (see `FBSessionTokenCachingStrategy`).
	 */
	// - (NSMutableDictionary *) dictionary;
	private static final Selector dictionary = Selector.register("dictionary");

	@Bridge
	private native static NSMutableDictionary objc_dictionary (FBAccessTokenData __self__, Selector __cmd__);

	public NSMutableDictionary getDictionary () {
		return objc_dictionary(this, dictionary);
	}

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

	/*
	 * !
	 * 
	 * @abstract returns the access token NSString.
	 */
	// @property (readonly, nonatomic, copy) NSString *accessToken;
	private static final Selector accessToken = Selector.register("accessToken");

	@Bridge
	private native static String objc_accessToken (FBAccessTokenData __self__, Selector __cmd__);

	public String getAccessToken () {
		return objc_accessToken(this, accessToken);
	}

	/*
	 * !
	 * 
	 * @abstract returns the permissions associated with the access token.
	 */
	// @property (readonly, nonatomic, copy) NSArray *permissions;
	private static final Selector permissions = Selector.register("urlSchemeSuffix");

	@Bridge
	private native static NSArray objc_permissions (FBAccessTokenData __self__, Selector __cmd__);

	public NSArray getPermissions () {
		return objc_permissions(this, permissions);
	}

	/*
	 * !
	 * 
	 * @abstract returns the expiration date of the access token.
	 */
	// @property (readonly, nonatomic, copy) NSDate *expirationDate;

	/*
	 * !
	 * 
	 * @abstract returns the login type associated with the token.
	 */
	// @property (readonly, nonatomic) FBSessionLoginType loginType;
	private static final Selector loginType = Selector.register("loginType");

	@Bridge
	private native static FBSessionLoginType objc_loginType (FBAccessTokenData __self__, Selector __cmd__);

	public FBSessionLoginType getLoginType () {
		return objc_loginType(this, loginType);
	}

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
