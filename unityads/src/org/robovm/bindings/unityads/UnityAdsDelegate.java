package org.robovm.bindings.unityads;

import org.robovm.apple.foundation.NSObjectProtocol;
import org.robovm.apple.foundation.NSString;
import org.robovm.objc.annotation.Method;

public interface UnityAdsDelegate extends NSObjectProtocol {

//	@required
//	- (void)unityAdsVideoCompleted:(NSString *)rewardItemKey skipped:(BOOL)skipped;
	@Method(selector = "unityAdsVideoCompleted:skipped:")
	void unityAdsVideoCompleted(NSString rewardItemKey, boolean skipped);
//
//	@optional
//	- (void)unityAdsWillShow;
	@Method(selector = "unityAdsWillShow")
	void unityAdsWillShow();
	
//	- (void)unityAdsDidShow;
	@Method(selector = "unityAdsDidShow")
	void unityAdsDidShow();
	
//	- (void)unityAdsWillHide;
	@Method(selector = "unityAdsWillHide")
	void unityAdsWillHide();
	
//	- (void)unityAdsDidHide;
	@Method(selector = "unityAdsDidHide")
	void unityAdsDidHide();
	
//	- (void)unityAdsWillLeaveApplication;
	@Method(selector = "unityAdsWillLeaveApplication")
	void unityAdsWillLeaveApplication();
	
//	- (void)unityAdsVideoStarted;
	@Method(selector = "unityAdsVideoStarted")
	void unityAdsVideoStarted();
	
//	- (void)unityAdsFetchCompleted;
	@Method(selector = "unityAdsFetchCompleted")
	void unityAdsFetchCompleted();
	
//	- (void)unityAdsFetchFailed;
	@Method(selector = "unityAdsFetchFailed")
	void unityAdsFetchFailed();
	
}
