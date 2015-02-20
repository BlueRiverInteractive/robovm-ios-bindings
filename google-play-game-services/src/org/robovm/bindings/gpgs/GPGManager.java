
package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSData;
import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.uikit.UIRemoteNotification;
import org.robovm.apple.uikit.UIUserNotificationType;
import org.robovm.bindings.gpp.GPPSignIn;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;
import org.robovm.rt.bro.annotation.Library;
import org.robovm.rt.bro.annotation.MachineSizedUInt;

@Library(Library.INTERNAL)
@NativeClass()
public class GPGManager extends NSObject {

	@Method(selector = "sharedInstance")
	public static native GPGManager sharedInstance();
	
	@Deprecated
	@Method(selector = "applicationModel")
	public native GPGApplicationModel getApplicationModel();
	
	@Deprecated
	@Method(selector = "applicationId")
	public native String getApplicationId();
	
	@Deprecated
	@Method(selector = "hasAuthorizer")
	public native boolean hasAuthorizer();

	@Method(selector = "signOut")
	public native void signOut();

	@Deprecated
	@Method(selector = "signIn:reauthorizeHandler:")
	public native void signIn(GPPSignIn signIn, @Block GPGReAuthenticationBlock reauthenticationBlock);
	
	@Method(selector = "signIn")
	public native void signIn();
	
	@Method(selector = "signInWithClientID:silently:")
	public native void signInWithClientID(String clientID, boolean silently);
	
	@Method(selector = "signInWithClientID:silently:withExtraScopes:")
	public native void signInWithClientID(String clientID, boolean silently, NSArray scopes);
	
	@Method(selector = "tryHandleRemoteNotification:")
	public native boolean tryHandleRemoteNotification(UIRemoteNotification userInfo);

	@Method(selector = "tryHandleRemoteNotification:forActionWithIdentifier:completionHandler:")
	public native boolean tryHandleRemoteNotification(UIRemoteNotification userInfo, String identifier, @Block Runnable completionHandler);
    
	@Method(selector = "registerDeviceToken:forEnvironment:")
	public native boolean registerDeviceToken(NSData deviceTokenData, GPGPushNotificationEnvironment environment);

	@Method(selector = "unregisterCurrentDeviceToken")
	public native void unregisterCurrentDeviceToken();
	
	@Method(selector = "registerForInteractiveGamesNotificationsWithType:")
	public native void registerForInteractiveGamesNotificationsWithType(UIUserNotificationType type);
	
	@Property(selector = "turnBasedMatchDelegate")
	public native GPGTurnBasedMatchDelegate getturnBasedMatchDelegate();
	
	@Property(selector = "setTurnBasedMatchDelegate:", strongRef = true)
	public native void setTurnBasedMatchDelegate(GPGTurnBasedMatchDelegate realTimeRoomDelegate);
	
	@Property(selector = "realTimeRoomDelegate")
	public native GPGRealTimeRoomDelegate getRealTimeRoomDelegate();
	
	@Property(selector = "setRealTimeRoomDelegate:", strongRef = true)
	public native void setRealTimeRoomDelegate(GPGRealTimeRoomDelegate realTimeRoomDelegate);
	
	@Property(selector = "statusDelegate")
	public native GPGStatusDelegate getStatusDelegate();
	
	@Property(selector = "setStatusDelegate:", strongRef = true)
	public native void setStatusDelegate(GPGStatusDelegate statusDelegate);
	
	@Property(selector = "questDelegate")
	public native GPGQuestDelegate getQuestDelegate();
	
	@Property(selector = "setQuestDelegate:", strongRef = true)
	public native void setQuestDelegate(GPGQuestDelegate questDelegate);
	
	@Property(selector = "isSignedIn")
	public native boolean isSignedIn();
	
	@Property(selector = "appStateEnabled")
	public native boolean getAppStateEnabled();
	
	@Property(selector = "setAppStateEnabled:", strongRef = true)
	public native void setAppStateEnabled(boolean appStateEnabled);
	
	@Property(selector = "snapshotsEnabled")
	public native boolean getSnapshotsEnabled();
	
	@Property(selector = "setSnapshotsEnabled:", strongRef = true)
	public native void setSnapshotsEnabled(boolean snapshotsEnabled);
	
	@Property(selector = "sdkTag")
	public native @MachineSizedUInt long getSdkTag();

	@Property(selector = "setSdkTag:", strongRef = true)
	public native void setSdkTag(@MachineSizedUInt long sdkTag);
	
	@Property(selector = "validOrientationFlags")
	public native @MachineSizedUInt long getValidOrientationFlags();

	@Property(selector = "setValidOrientationFlags:", strongRef = true)
	public native void setValidOrientationFlags(@MachineSizedUInt long validOrientationFlags);
	
	@Property(selector = "welcomeBackOffset")
	public native @MachineSizedUInt long getWelcomeBackOffset();

	@Property(selector = "setWelcomeBackOffset:", strongRef = true)
	public native void setWelcomeBackOffset(@MachineSizedUInt long welcomeBackOffset);
	
	@Property(selector = "welcomeBackToastPlacement")
	public native GPGToastPlacement getWelcomeBackToastPlacement();

	@Property(selector = "setWelcomeBackToastPlacement:", strongRef = true)
	public native void setWelcomeBackToastPlacement(GPGToastPlacement welcomeBackToastPlacement);

	@Property(selector = "achievementUnlockedOffset")
	public native @MachineSizedUInt long getAchievementUnlockedOffset();

	@Property(selector = "setAchievementUnlockedOffset:", strongRef = true)
	public native void setAchievementUnlockedOffset(@MachineSizedUInt long achievementUnlockedOffset);

	@Property(selector = "achievementUnlockedToastPlacement")
	public native GPGToastPlacement getAchievementUnlockedToastPlacement();

	@Property(selector = "setAchievementUnlockedToastPlacement:", strongRef = true)
	public native void setAchievementUnlockedToastPlacement(GPGToastPlacement achievementUnlockedToastPlacement);

	@Property(selector = "questCompletedOffset")
	public native @MachineSizedUInt long getQuestCompletedOffset();

	@Property(selector = "setQuestCompletedOffset:", strongRef = true)
	public native void setQuestCompletedOffset(@MachineSizedUInt long questCompletedOffset);
	
	@Property(selector = "questCompletedToastPlacement")
	public native GPGToastPlacement getQuestCompletedToastPlacement();

	@Property(selector = "setQuestCompletedToastPlacement:", strongRef = true)
	public native void setQuestCompletedToastPlacement(GPGToastPlacement questCompletedToastPlacement);
	
	@Method(selector = "refreshRevisionStatus:")
	public native void refreshRevisionStatus(@Block GPGRevisionCheckBlock revisionCheckHandler);
	
	@Method(selector = "revisionStatus")
	public native GPGRevisionStatus getRevisionStatus();

	@Method(selector = "isRevisionValid")
	public native boolean isRevisionValid();
}
