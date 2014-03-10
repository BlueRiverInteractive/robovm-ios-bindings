
package org.robovm.bindings.gpgs;

import org.robovm.bindings.gpp.GPPSignIn;
import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.objc.ObjCBlock;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
@NativeClass()
public class GPGManager extends NSObject {
	private static final ObjCClass objCClass = ObjCClass.getByType(GPGManager.class);

	static {
		ObjCRuntime.bind(GPGManager.class);
	}

	// + (GPGManager *)sharedInstance;
	private static final Selector sharedInstance$ = Selector.register("sharedInstance");

	@Bridge
	private native static GPGManager objc_sharedInstance (ObjCClass __self__, Selector __cmd__);

	public static GPGManager sharedInstance () {
		return objc_sharedInstance(objCClass, sharedInstance$);
	}

	// - (GPGApplicationModel *)applicationModel;
	private static final Selector applicationModel$ = Selector.register("applicationModel");

	@Bridge
	private native static GPGApplicationModel objc_applicationModel (GPGManager __self__, Selector __cmd__);

	public GPGApplicationModel applicationModel () {
		return objc_applicationModel(this, applicationModel$);
	}

	// - (NSString *)applicationId;
	private static final Selector applicationId$ = Selector.register("applicationId");

	@Bridge
	private native static String objc_applicationId (GPGManager __self__, Selector __cmd__);

	public String applicationId () {
		return objc_applicationId(this, applicationId$);
	}

	// - (BOOL)hasAuthorizer;
	private static final Selector hasAuthorizer$ = Selector.register("hasAuthorizer");

	@Bridge
	private native static boolean objc_hasAuthorizer (GPGManager __self__, Selector __cmd__);

	public boolean hasAuthorizer () {
		return objc_hasAuthorizer(this, hasAuthorizer$);
	}

	// - (void)signout;
	private static final Selector signout$ = Selector.register("signout");

	@Bridge
	private native static boolean objc_signout (GPGManager __self__, Selector __cmd__);

	public boolean signout () {
		return objc_signout(this, signout$);
	}

	// - (void)signIn:(GPPSignIn *)signIn reauthorizeHandler:(GPGReAuthenticationBlock)reauthenticationBlock;
	private static final Selector signIn$ = Selector.register("signIn:reauthorizeHandler:");

	@Bridge
	private native static void objc_signIn (GPGManager __self__, Selector __cmd__, GPPSignIn signIn,
		ObjCBlock reauthenticationBlock);

	public void signIn (GPPSignIn signIn, GPGReAuthenticationBlock reauthenticationBlock) {
		objc_signIn(this, signIn$, signIn, GPGReAuthenticationBlock.Marshaler.toObjCBlock(reauthenticationBlock));
	}

	// @property(nonatomic, readwrite, assign) NSUInteger validOrientationFlags;
	private static final Selector validOrientationFlags$ = Selector.register("validOrientationFlags");

	@Bridge
	private native static char objc_validOrientationFlags (GPGManager __self__, Selector __cmd__);

	public char validOrientationFlags () {
		return objc_validOrientationFlags(this, validOrientationFlags$);
	}

	private static final Selector setValidOrientationFlags$ = Selector.register("setValidOrientationFlags:");

	@Bridge
	private native static void objc_setValidOrientationFlags (GPGManager __self__, Selector __cmd__, char flags);

	public void setValidOrientationFlags (char flags) {
		objc_setValidOrientationFlags(this, setValidOrientationFlags$, flags);
	}

	// @property(nonatomic, readwrite, assign) NSUInteger welcomeBackOffset;
	private static final Selector welcomeBackOffset$ = Selector.register("welcomeBackOffset");

	@Bridge
	private native static char objc_welcomeBackOffset (GPGManager __self__, Selector __cmd__);

	public char welcomeBackOffset () {
		return objc_welcomeBackOffset(this, welcomeBackOffset$);
	}

	private static final Selector setWelcomeBackOffset$ = Selector.register("setWelcomeBackOffset:");

	@Bridge
	private native static void objc_setWelcomeBackOffset (GPGManager __self__, Selector __cmd__, char offset);

	public void setWelcomeBackOffset (char offset) {
		objc_setWelcomeBackOffset(this, setWelcomeBackOffset$, offset);
	}

	// @property(nonatomic, readwrite, assign) GPGToastPlacement welcomeBackToastPlacement;
	private static final Selector welcomeBackToastPlacement$ = Selector.register("welcomeBackToastPlacement");

	@Bridge
	private native static GPGToastPlacement objc_welcomeBackToastPlacement (GPGManager __self__, Selector __cmd__);

	public GPGToastPlacement welcomeBackToastPlacement () {
		return objc_welcomeBackToastPlacement(this, welcomeBackToastPlacement$);
	}

	private static final Selector setWelcomeBackToastPlacement$ = Selector.register("setWelcomeBackToastPlacement:");

	@Bridge
	private native static void objc_setWelcomeBackToastPlacement (GPGManager __self__, Selector __cmd__,
		GPGToastPlacement welcomeBackToastPlacement);

	public void setWelcomeBackToastPlacement (GPGToastPlacement welcomeBackToastPlacement) {
		objc_setWelcomeBackToastPlacement(this, setWelcomeBackToastPlacement$, welcomeBackToastPlacement);
	}

	// @property(nonatomic, readwrite, assign) NSUInteger achievementUnlockedOffset;
	private static final Selector achievementUnlockedOffset$ = Selector.register("achievementUnlockedOffset");

	@Bridge
	private native static char objc_achievementUnlockedOffset (GPGManager __self__, Selector __cmd__);

	public char achievementUnlockedOffset () {
		return objc_achievementUnlockedOffset(this, achievementUnlockedOffset$);
	}

	private static final Selector setAchievementUnlockedOffset$ = Selector.register("setAchievementUnlockedOffset:");

	@Bridge
	private native static void objc_setAchievementUnlockedOffset (GPGManager __self__, Selector __cmd__, char offset);

	public void setAchievementUnlockedOffset (char offset) {
		objc_setAchievementUnlockedOffset(this, setAchievementUnlockedOffset$, offset);
	}

	// @property(nonatomic, readwrite, assign) GPGToastPlacement achievementUnlockedToastPlacement;
	private static final Selector achievementUnlockedToastPlacement$ = Selector.register("achievementUnlockedToastPlacement");

	@Bridge
	private native static GPGToastPlacement objc_achievementUnlockedToastPlacement (GPGManager __self__, Selector __cmd__);

	public GPGToastPlacement achievementUnlockedToastPlacement () {
		return objc_achievementUnlockedToastPlacement(this, achievementUnlockedToastPlacement$);
	}

	private static final Selector setAchievementUnlockedToastPlacement$ = Selector
		.register("setAchievementUnlockedToastPlacement:");

	@Bridge
	private native static void objc_setAchievementUnlockedToastPlacement (GPGManager __self__, Selector __cmd__,
		GPGToastPlacement achievementUnlockedToastPlacement);

	public void setAchievementUnlockedToastPlacement (GPGToastPlacement achievementUnlockedToastPlacement) {
		objc_setAchievementUnlockedToastPlacement(this, setAchievementUnlockedToastPlacement$, achievementUnlockedToastPlacement);
	}

	// - (void)refreshRevisionStatus:(GPGRevisionCheckBlock)revisionCheckHandler;
	private static final Selector refreshRevisionStatus$ = Selector.register("refreshRevisionStatus:");

	@Bridge
	private native static void objc_refreshRevisionStatus (GPGManager __self__, Selector __cmd__, ObjCBlock revisionCheckHandler);

	public void refreshRevisionStatus (GPGRevisionCheckBlock revisionCheckHandler) {
		objc_refreshRevisionStatus(this, refreshRevisionStatus$, GPGRevisionCheckBlock.Marshaler.toObjCBlock(revisionCheckHandler));
	}

	// - (GPGRevisionStatus)revisionStatus;
	private static final Selector revisionStatus$ = Selector.register("revisionStatus");

	@Bridge
	private native static GPGRevisionStatus objc_revisionStatus (GPGManager __self__, Selector __cmd__);

	public GPGRevisionStatus revisionStatus () {
		return objc_revisionStatus(this, revisionStatus$);
	}

	// - (BOOL)isRevisionValid;
	private static final Selector isRevisionValid$ = Selector.register("isRevisionValid");

	@Bridge
	private native static boolean objc_isRevisionValid (GPGManager __self__, Selector __cmd__);

	public boolean isRevisionValid () {
		return objc_isRevisionValid(this, isRevisionValid$);
	}
}
