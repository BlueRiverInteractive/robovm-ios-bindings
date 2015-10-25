package org.robovm.bindings.unityads;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.foundation.NSString;
import org.robovm.apple.uikit.UIViewController;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class UnityAds extends NSObject {

//	@property (nonatomic, weak) id<UnityAdsDelegate> delegate;
	@Property(selector = "delegate")
	public native UnityAdsDelegate getDelegate ();

	@Property(selector = "setDelegate:", strongRef = true)
	public native void setDelegate (UnityAdsDelegate delegate);
	

//	+ (UnityAds *)sharedInstance;
	@Method(selector = "sharedInstance")
	public static native UnityAds sharedInstance();
	
//	+ (BOOL)isSupported;
	@Method(selector = "isSupported")
	public static native boolean isSupported();
	
//	+ (NSString *)getSDKVersion;
	@Method(selector = "getSDKVersion")
	public static native NSString getSDKVersion();
	
	
	
//
//	- (void)setTestDeveloperId:(NSString *)developerId;
	@Method(selector = "setTestDeveloperId:")
	public native void setTestDeveloperId(NSString developerId);
	
//	- (void)setTestOptionsId:(NSString *)optionsId;
	@Method(selector = "setTestOptionsId:")
	public native void setTestOptionsId(NSString optionsId);
	
//	- (void)setDebugMode:(BOOL)debugMode;
	@Method(selector = "setDebugMode:")
	public native void setDebugMode(boolean debugMode);
	
//	- (void)setTestMode:(BOOL)testModeEnabled;
	@Method(selector = "setTestMode:")
	public native void setTestMode(boolean testModeEnabled);
	
//	- (void)enableUnityDeveloperInternalTestMode;
	@Method(selector = "enableUnityDeveloperInternalTestMode")
	public native void enableUnityDeveloperInternalTestMode();
	
//	- (void)setCampaignDataURL:(NSString *)campaignDataUrl;
	@Method(selector = "setCampaignDataURL:")
	public native void setCampaignDataURL(NSString campaignDataUrl);
	
//	- (void)setUnityVersion:(NSString *)unityVersion;
	@Method(selector = "setUnityVersion:")
	public native void setUnityVersion(NSString unityVersion);
//
//	- (BOOL)isDebugMode;
	@Method(selector = "isDebugMode")
	public native boolean isDebugMode();
	
//	- (BOOL)startWithGameId:(NSString *)gameId andViewController:(UIViewController *)viewController;
	@Method(selector = "startWithGameId:andViewController:")
	public native boolean startWithGameId(NSString gameId, UIViewController viewController);
	
//	- (BOOL)startWithGameId:(NSString *)gameId;
	@Method(selector = "startWithGameId:")
	public native boolean startWithGameId(NSString gameId);
	
//	- (BOOL)setViewController:(UIViewController *)viewController;
	@Method(selector = "setViewController:")
	public native boolean setViewController(UIViewController viewController);
	
//	- (BOOL)canShowAds;
	@Method(selector = "canShowAds")
	public native boolean canShowAds();
	
//	- (BOOL)canShow;
	@Method(selector = "canShow")
	public native boolean canShow();
	
//	- (BOOL)canShowZone:(NSString *)zoneId;
	@Method(selector = "canShowZone:")
	public native boolean canShowZone(NSString zoneId);
	
//	- (BOOL)setZone:(NSString *)zoneId;
	@Method(selector = "setZone:")
	public native boolean setZone(NSString zoneId);
	
//	- (BOOL)setZone:(NSString *)zoneId withRewardItem:(NSString *)rewardItemKey;
	@Method(selector = "setZone:withRewardItem:")
	public native boolean setZone(NSString zoneId, NSString rewardItemKey);
	
//	- (NSString *)getZone;
	@Method(selector = "getZone")
	public native NSString getZone();
	
//	- (BOOL)show:(NSDictionary *)options;
	@Method(selector = "show:")
	public native boolean show(NSDictionary options);
	
//	- (BOOL)show;
	@Method(selector = "show")
	public native boolean show();
	
//	- (BOOL)hide;
	@Method(selector = "hide")
	public native boolean hide();
	
//	- (void)stopAll;
	@Method(selector = "stopAll")
	public native void stopAll();
	
//	- (BOOL)hasMultipleRewardItems;
	@Method(selector = "hasMultipleRewardItems")
	public native boolean hasMultipleRewardItems();
	
//	- (NSArray *)getRewardItemKeys;
	@Method(selector = "getRewardItemKeys")
	public native NSArray getRewardItemKeys();
	
//	- (NSString *)getDefaultRewardItemKey;
	@Method(selector = "getDefaultRewardItemKey")
	public native NSString getDefaultRewardItemKey();
	
//	- (NSString *)getCurrentRewardItemKey;
	@Method(selector = "getCurrentRewardItemKey")
	public native NSString getCurrentRewardItemKey();
	
//	- (BOOL)setRewardItemKey:(NSString *)rewardItemKey;
	@Method(selector = "setRewardItemKey:")
	public native boolean setRewardItemKey(NSString rewardItemKey);
	
//	- (void)setDefaultRewardItemAsRewardItem;
	@Method(selector = "setDefaultRewardItemAsRewardItem")
	public native void setDefaultRewardItemAsRewardItem();
	
//	- (NSDictionary *)getRewardItemDetailsWithKey:(NSString *)rewardItemKey;
	@Method(selector = "getRewardItemDetailsWithKey:")
	public native NSDictionary getRewardItemDetailsWithKey(NSString rewardItemKey);
	
}
