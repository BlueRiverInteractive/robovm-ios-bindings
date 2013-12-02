
package org.robovm.bindings.gpp;

import org.robovm.bindings.gt.GTMOAuth2Authentication;
import org.robovm.cocoatouch.foundation.NSArray;
import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSString;
import org.robovm.cocoatouch.foundation.NSURL;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

//This class signs the user in with Google. It provides single sign-on
//via the Google+ app (if installed), Chrome for iOS (if installed), or Mobile
//Safari.
//
//For reference, please see "Google+ Sign-In for iOS" at
//https://developers.google.com/+/mobile/ios/sign-in .
//Here is sample code to use |GPPSignIn|:
//1) Get a reference to the |GPPSignIn| shared instance:
//   GPPSignIn *signIn = [GPPSignIn sharedInstance];
//2) Set the OAuth 2.0 scopes you want to request:
//   [signIn setScopes:[NSArray arrayWithObject:
//       @"https://www.googleapis.com/auth/plus.login"]];
//2) Call [signIn setDelegate:self];
//3) Set up delegate method |finishedWithAuth:error:|.
//4) Call |handleURL| on the shared instance from |application:openUrl:...|
//   in your app delegate.
//5) Call [signIn authenticate];
@Library(Library.INTERNAL)
@NativeClass()
public class GPPSignIn extends NSObject {
	private static final ObjCClass objCClass = ObjCClass.getByType(GPPSignIn.class);

	static {
		ObjCRuntime.bind(GPPSignIn.class);
	}

	private GPPSignIn () {

	}

	// FIELDS

	// The authentication object for the current user, or |nil| if there is
	// currently no logged in user.
	// @property(nonatomic, strong, readonly) GTMOAuth2Authentication *authentication;
	// TODO: implement
	private static final Selector authentication$ = Selector.register("authentication");

	@Bridge
	private native static GTMOAuth2Authentication objc_getAuthentication (GPPSignIn __self__, Selector __cmd__);

	public GTMOAuth2Authentication getAuthentication () {
		return objc_getAuthentication(this, authentication$);
	}

	// A JSON Web Token identifying the user. Send this token to your server to
	// authenticate the user on the server. For more information on JWTs, see
	// http://tools.ietf.org/html/draft-ietf-oauth-json-web-token-05
	// @property(nonatomic, strong, readonly) NSString *idToken;
	private static final Selector idToken$ = Selector.register("idToken");

	@Bridge
	private native static NSString objc_getIdToken (GPPSignIn __self__, Selector __cmd__);

	public NSString getIdToken () {
		return objc_getIdToken(this, idToken$);
	}

	// The Google user ID. It is only available if |shouldFetchGoogleUserID| is set
	// and either |trySilentAuthentication| or |authenticate| has been completed
	// successfully.
	// @property(nonatomic, strong, readonly) NSString *userID;
	private static final Selector userID$ = Selector.register("userID");

	@Bridge
	private native static NSString objc_getUserId (GPPSignIn __self__, Selector __cmd__);

	public NSString getUserId () {
		return objc_getUserId(this, userID$);
	}

	// The Google user's email. It is only available if |shouldFetchGoogleUserEmail|
	// is set and either |trySilentAuthentication| or |authenticate| has been
	// completed successfully.
	// @property(nonatomic, strong, readonly) NSString *userEmail;
	private static final Selector userEmail$ = Selector.register("userEmail");

	@Bridge
	private native static NSString objc_getUserEmail (GPPSignIn __self__, Selector __cmd__);

	public NSString getUserEmail () {
		return objc_getUserEmail(this, userEmail$);
	}

	// The Google+ user profile. It is only available if |shouldFetchGooglePlusUser|
	// is set and either |trySilentAuthentication| or |authenticate| has been
	// completed successfully.
	// @property(nonatomic, strong, readonly) GTLPlusPerson *googlePlusUser;
	// TODO: implement
	/*
	 * private static final Selector googlePlusUser$ = Selector.register("googlePlusUser:");
	 * 
	 * @Bridge private native static GTLPlusPerson objc_getGooglePlusUser(GPPSignIn __self__, Selector __cmd__); public
	 * GTLPlusPerson getGooglePlusUser(){ return objc_getGooglePlusUser(this, googlePlusUser$); }
	 */

	// The object to be notified when authentication is finished.
	// @property(nonatomic, weak) id<GPPSignInDelegate> delegate;
	private static final Selector delegate$ = Selector.register("setDelegate:");

	@Bridge
	private native static void objc_setDelegate (GPPSignIn __self__, Selector __cmd__, GPPSignInDelegate del);

	public void setDelegate (GPPSignInDelegate del) {
		objc_setDelegate(this, delegate$, del);
	}

	// The client ID of the app from the Google APIs console.
	// Must set for sign-in to work.
	// @property(nonatomic, copy) NSString *clientID;
	private static final Selector clientID$ = Selector.register("setClientID:");

	@Bridge
	private native static void objc_setClientID (GPPSignIn __self__, Selector __cmd__, NSString clientID);

	public void setClientID (String clientID) {
		objc_setClientID(this, clientID$, new NSString(clientID));
	}

	// The client ID of the home web server. This will be returned as the
	// |audience| property of the JWT ID token. For more info on the ID token:
	// https://developers.google.com/accounts/docs/OAuth2Login#obtainuserinfo
	// @property(nonatomic, copy) NSString *homeServerClientID;
	private static final Selector homeServerClientID$ = Selector.register("setHomeServerClientID:");

	@Bridge
	private native static void objc_setHomeClientID (GPPSignIn __self__, Selector __cmd__, NSString homeClientID);

	public void setHomeClientID (String homeClientID) {
		objc_setHomeClientID(this, homeServerClientID$, new NSString(homeClientID));
	}

	// The API scopes requested by the app in an array of |NSString|s.
	// The default value is |@[@"https://www.googleapis.com/auth/plus.login"]|.
	// @property(nonatomic, copy) NSArray *scopes;
	private static final Selector getScopes$ = Selector.register("scopes");

	@Bridge
	private native static NSArray<NSString> objc_scopes (GPPSignIn __self__, Selector __cmd__);

	public NSArray<NSString> getScopes () {
		return objc_scopes(this, getScopes$);
	}

	private static final Selector scopes$ = Selector.register("setScopes:");

	@Bridge
	private native static void objc_setScopes (GPPSignIn __self__, Selector __cmd__, NSArray<NSString> scopes);

	public void setScopes (NSArray<NSString> scopes) {
		objc_setScopes(this, scopes$, scopes);
	}

	// Whether or not to attempt Single-Sign-On when signing in.
	// If |attemptSSO| is true, the sign-in button tries to authenticate with the
	// Google+ application if it is installed. If false, it always uses Google+ via
	// Chrome for iOS, if installed, or Mobile Safari for authentication.
	// The default value is |YES|.
	// @property(nonatomic, assign) BOOL attemptSSO;
	private static final Selector attemptSSO$ = Selector.register("setAttemptSSO:");

	@Bridge
	private native static void objc_setAttemptSSO (GPPSignIn __self__, Selector __cmd__, boolean attemptSSO);

	public void setAttemptSSO (boolean attemptSSO) {
		objc_setAttemptSSO(this, attemptSSO$, attemptSSO);
	}

	// The language for sign-in, in the form of ISO 639-1 language code
	// optionally followed by a dash and ISO 3166-1 alpha-2 region code,
	// such as |@"it"| or |@"pt-PT"|.
	// Only set if different from system default.
	// @property(nonatomic, copy) NSString *language;
	private static final Selector language$ = Selector.register("setLanguage:");

	@Bridge
	private native static void objc_setLanguage (GPPSignIn __self__, Selector __cmd__, String language);

	public void setLanguage (String language) {
		objc_setLanguage(this, language$, language);
	}

	// Name of the keychain to save the sign-in state.
	// Only set if a custom name needs to be used.
	// @property(nonatomic, copy) NSString *keychainName;
	private static final Selector keychainName$ = Selector.register("setKeychainName:");

	@Bridge
	private native static void objc_setKeychainName (GPPSignIn __self__, Selector __cmd__, String name);

	public void setKeychainName (String keychainName) {
		objc_setKeychainName(this, keychainName$, keychainName);
	}

	// An |NSString| array of moment types used by your app. Use values from the
	// full list at
	// https://developers.google.com/+/api/moment-types .
	// such as "http://schemas.google.com/AddActivity".
	// This property is required only for writing moments, with
	// "https://www.googleapis.com/auth/plus.login" as a scope.
	// @property(nonatomic, copy) NSArray *actions;
	private static final Selector actions$ = Selector.register("setActions:");

	@Bridge
	private native static void objc_setActions (GPPSignIn __self__, Selector __cmd__, NSArray actions);

	public void setActions (NSArray actions) {
		objc_setScopes(this, actions$, actions);
	}

	// Whether or not to fetch user email after signing in. The email is saved in
	// the |GTMOAuth2Authentication| object. Note that using this flag automatically
	// adds "https://www.googleapis.com/auth/userinfo.email" scope to the request.
	// @property(nonatomic, assign) BOOL shouldFetchGoogleUserEmail;
	private static final Selector shouldFetchGoogleUserEmail$ = Selector.register("setShouldFetchGoogleUserEmail:");

	@Bridge
	private native static void objc_setShouldFetchGoogleUserEmail (GPPSignIn __self__, Selector __cmd__, boolean fetch);

	public void setShouldFetchGoogleUserEmail (boolean shouldFetchGoogleUserEmail) {
		objc_setShouldFetchGoogleUserEmail(this, shouldFetchGoogleUserEmail$, shouldFetchGoogleUserEmail);
	}

	// Whether or not to fetch user ID after signing in. The ID can be retrieved
	// by |googleUserID| after user has been authenticated. Note that using this
	// flag automatically adds "https://www.googleapis.com/auth/userinfo.profile"
	// scope to the request if a scope that provides user ID is not already present.
	// @property(nonatomic, assign) BOOL shouldFetchGoogleUserID;
	private static final Selector shouldFetchGoogleUserID$ = Selector.register("setShouldFetchGoogleUserID:");

	@Bridge
	private native static void objc_setShouldFetchGoogleUserID (GPPSignIn __self__, Selector __cmd__, boolean fetch);

	public void setShouldFetchGoogleUserID (boolean shouldFetchGoogleUserID) {
		objc_setShouldFetchGoogleUserID(this, shouldFetchGoogleUserID$, shouldFetchGoogleUserID);
	}

	// Whether or not to fetch Google+ user profile after signing in. The user
	// profile object can be retrieved by |googlePlusUser| after user has been
	// authenticated. Note that using this flag automatically adds
	// "https://www.googleapis.com/auth/plus.me" scope to the request if needed.
	// @property(nonatomic, assign) BOOL shouldFetchGooglePlusUser;
	private static final Selector shouldFetchGooglePlusUser$ = Selector.register("setShouldFetchGooglePlusUser:");

	@Bridge
	private native static void objc_setShouldFetchGooglePlusUser (GPPSignIn __self__, Selector __cmd__, boolean fetch);

	public void setShouldFetchGooglePlusUser (boolean shouldFetchGooglePlusUser) {
		objc_setShouldFetchGooglePlusUser(this, shouldFetchGooglePlusUser$, shouldFetchGooglePlusUser);
	}

	// STATIC METHODS

	// Returns a shared |GPPSignIn| instance.
	// + (GPPSignIn *)sharedInstance;
	private static final Selector sharedInstance$ = Selector.register("sharedInstance");

	@Bridge
	private native static GPPSignIn objc_sharedInstance (ObjCClass __self__, Selector __cmd__);

	public static GPPSignIn sharedInstance () {
		return objc_sharedInstance(objCClass, sharedInstance$);
	}

	// METHODS

	// Checks whether the user has either currently signed in or has previous
	// authentication saved in keychain.
	// - (BOOL)hasAuthInKeychain;
	private static final Selector hasAuthInKeychain$ = Selector.register("hasAuthInKeychain");

	@Bridge
	private native static boolean objc_hasAuthInKeychain (GPPSignIn __self__, Selector __cmd__);

	public boolean hasAuthInKeychain () {
		return objc_hasAuthInKeychain(this, hasAuthInKeychain$);
	}

	// Attempts to authenticate silently without user interaction.
	// Returns |YES| and calls the delegate if the user has either currently signed
	// in or has previous authentication saved in keychain.
	// Note that if the previous authentication was revoked by the user, this method
	// still returns |YES| but |finishedWithAuth:error:| callback will indicate
	// that authentication has failed.
	// - (BOOL)trySilentAuthentication;
	private static final Selector trySilentAuthentication$ = Selector.register("trySilentAuthentication");

	@Bridge
	private native static boolean objc_trySilentAuthentication (GPPSignIn __self__, Selector __cmd__);

	public boolean trySilentAuthentication () {
		return objc_trySilentAuthentication(this, trySilentAuthentication$);
	}

	// Starts the authentication process. Set |attemptSSO| to try single sign-on.
	// If |attemptSSO| is true, try to authenticate with the Google+ app, if
	// installed. If false, always use Google+ via Chrome or Mobile Safari for
	// authentication. The delegate will be called at the end of this process.
	// Note that this method should not be called when the app is starting up,
	// (e.g in application:didFinishLaunchingWithOptions:). Instead use the
	// |trySilentAuthentication| method.
	// - (void)authenticate;
	private static final Selector authenticate$ = Selector.register("authenticate");

	@Bridge
	private native static void objc_authenticate (GPPSignIn __self__, Selector __cmd__);

	public void authenticate () {
		objc_authenticate(this, authenticate$);
	}

	// This method should be called from your |UIApplicationDelegate|'s
	// |application:openURL:sourceApplication:annotation|. Returns |YES| if
	// |GPPSignIn| handled this URL.
	// Also see |handleURL:sourceApplication:annotation:| in |GPPURLHandler|.
	// - (BOOL)handleURL:(NSURL *)url sourceApplication:(NSString *)sourceApplication annotation:(id)annotation;
	private static final Selector handleURL$ = Selector.register("handleURL:sourceApplication:annotation:");

	@Bridge
	private native static boolean objc_handleURL (GPPSignIn __self__, Selector __cmd__, NSURL url, NSString sourceApplication,
		NSObject annotation);

	public boolean handleURL (NSURL url, String sourceApplication, NSObject annotation) {
		return objc_handleURL(this, handleURL$, url, new NSString(sourceApplication), annotation);
	}

	// Removes the OAuth 2.0 token from the keychain.
	// - (void)signOut;
	private static final Selector signOut$ = Selector.register("signOut");

	@Bridge
	private native static void objc_signOut (GPPSignIn __self__, Selector __cmd__);

	public void signOut () {
		objc_signOut(this, signOut$);
	}

	// Disconnects the user from the app and revokes previous authentication.
	// If the operation succeeds, the OAuth 2.0 token is also removed from keychain.
	// The token is needed to disconnect so do not call |signOut| if |disconnect| is
	// to be called.
	// - (void)disconnect;
	private static final Selector disconnect$ = Selector.register("disconnect");

	@Bridge
	private native static void objc_disconnect (GPPSignIn __self__, Selector __cmd__);

	public void disconnect () {
		objc_disconnect(this, disconnect$);
	}

	// Gets a service object authenticated as the current user. The service object
	// can execute queries, for example, to get list of people that is visible to
	// this app. The user must be signed in for this method to work.
	// - (GTLServicePlus *)plusService;
	// TODO: implement
	/*
	 * private static final Selector plusService$ = Selector.register("plusService:");
	 * 
	 * @Bridge private native static GTLServicePlus objc_plusService(GPPSignIn __self__, Selector __cmd__); public GTLServicePlus
	 * plusService() { return objc_plusService(this, plusService$); }
	 */
}
