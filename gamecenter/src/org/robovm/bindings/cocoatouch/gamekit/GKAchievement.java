package org.robovm.bindings.cocoatouch.gamekit;

import org.robovm.bindings.cocoatouch.blocks.VoidNSArrayNSErrorBlock;
import org.robovm.bindings.cocoatouch.blocks.VoidNSErrorBlock;
import org.robovm.cocoatouch.foundation.NSArray;
import org.robovm.cocoatouch.foundation.NSDate;
import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.ObjCSuper;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

@Library("GameKit")
@NativeClass
public class GKAchievement extends NSObject {
	private static final ObjCClass objCClass = ObjCClass.getByType(GKAchievement.class);

	static{
		ObjCRuntime.bind(GKAchievement.class);
	}
	
	//- (id)initWithIdentifier:(NSString *)identifier;
	private static final Selector initWithIdentifier = Selector.register("initWithIdentifier:");
	
	@Bridge	private native static void objc_initWithIdentifier(GKAchievement __self__, Selector __cmd__, String identifier);
    @Bridge private native static void objc_initWithIdentifierSuper(ObjCSuper __super__, Selector __cmd__, String identifier);

    /**
     * Designate initializer
     * @param identifier
     */
    public GKAchievement(String identifier){
    	if(customClass){
    		objc_initWithIdentifierSuper(getSuper(), initWithIdentifier, identifier);
    	}else{
    		objc_initWithIdentifier(this, initWithIdentifier, identifier);
    	}
    }
    
    //- (id)initWithIdentifier:(NSString *)identifier forPlayer:(NSString *)playerID __OSX_AVAILABLE_STARTING(__MAC_NA,__IPHONE_7_0);
    private static final Selector initWithIdentifier$forPlayer = Selector.register("initWithIdentifier:forPlayer:");
    
    @Bridge	private native static void objc_initWithIdentifier(GKAchievement __self__, Selector __cmd__, String identifier, String playerID);
    @Bridge private native static void objc_initWithIdentifierSuper(ObjCSuper __super__, Selector __cmd__, String identifier, String playerID);
    
    /**
     * Will initialize the achievement for a player. Can be used for submitting participant achievements when ending a turn-based match.
     * @param identifier
     * @param playerID
     */
    public GKAchievement(String identifier, String playerID){
    	if(customClass){
    		objc_initWithIdentifierSuper(getSuper(), initWithIdentifier$forPlayer, identifier, playerID);
    	}else{
    		objc_initWithIdentifier(this, initWithIdentifier$forPlayer, identifier, playerID);
    	}
    }
    
    //@property(copy, NS_NONATOMIC_IOSONLY) NSString *identifier;
    private static final Selector identifier = Selector.register("identifier");
    
    @Bridge private native static String objc_getIdentifier(GKAchievement __self__, Selector __cmd__);
    @Bridge private native static String objc_getIdentifierSuper(ObjCSuper __super__, Selector __cmd__);
    
    /**
     * Get the Achievement identifier
     * @return
     */
    public String getIdentifier(){
    	if(customClass){
    		return objc_getIdentifierSuper(getSuper(), identifier);
    	}else{
    		return objc_getIdentifier(this, identifier);
    	}
    }
    
    //@property(assign, NS_NONATOMIC_IOSONLY) double percentComplete;
    private static final Selector percentComplete = Selector.register("percentComplete");
    
    @Bridge private native static double objc_getPercentComplete(GKAchievement __self__, Selector __cmd__);
    @Bridge private native static double objc_getPercentCompleteSuper(ObjCSuper __super__, Selector __cmd__);
    
    /**
     * Get the Percentage of achievement completion.
     * @return
     */
    public double getPercentComplete(){
    	if(customClass){
    		return objc_getPercentCompleteSuper(getSuper(), identifier);
    	}else{
    		return objc_getPercentComplete(this, identifier);
    	}
    }
    
    private static final Selector setPercentComplete = Selector.register("setPercentComplete:");
    
    @Bridge private native static void objc_setPercentComplete(GKAchievement __self__, Selector __cmd__, double percentComplete);
    @Bridge private native static void objc_setPercentCompleteSuper(ObjCSuper __super__, Selector __cmd__, double percentComplete);
    
    /**
     * Set the Percentage of achievement completion.
     * @param percentComplete
     */
    public void setPercentComplete(double percentComplete){
    	if(customClass){
    		objc_setPercentCompleteSuper(getSuper(), setPercentComplete, percentComplete);
    	}else{
    		objc_setPercentComplete(this, setPercentComplete, percentComplete);
    	}
    }
    
    //@property(readonly, getter=isCompleted, NS_NONATOMIC_IOSONLY) BOOL completed;
    private static final Selector isCompleted = Selector.register("isCompleted");
    
    @Bridge private native static boolean objc_isCompleted(GKAchievement __self__, Selector __cmd__);
    @Bridge private native static boolean objc_isCompletedSuper(ObjCSuper __super__, Selector __cmd__);
    
    /**
     * Set to NO until percentComplete = 100.
     * @return
     */
    public boolean isCompleted(){
    	if(customClass){
    		return objc_isCompletedSuper(getSuper(), isCompleted);
    	}else{
    		return objc_isCompleted(this, isCompleted);
    	}
    }
    
    //@property(copy, readonly, NS_NONATOMIC_IOSONLY) NSDate *lastReportedDate;
    private static final Selector lastReportedDate = Selector.register("lastReportedDate");
    
    @Bridge private native static NSDate objc_lastReportedDate(GKAchievement __self__, Selector __cmd__);
    @Bridge private native static NSDate objc_lastReportedDateSuper(ObjCSuper __super__, Selector __cmd__);
    
    /**
     * Date the achievement was last reported. Read-only. Created at initialization
     * @return
     */
    public NSDate getLastReportedDate(){
    	if(customClass){
    		return objc_lastReportedDateSuper(getSuper(), lastReportedDate);
    	}else{
    		return objc_lastReportedDate(this, lastReportedDate);
    	}
    }
    
    //@property(assign, NS_NONATOMIC_IOSONLY) BOOL showsCompletionBanner
    private static final Selector setShowsCompletionBanner = Selector.register("setShowsCompletionBanner:");
    
    @Bridge private native static void objc_setShowsCompletionBanner(GKAchievement __self__, Selector __cmd__, boolean showsCompletionBanner);
    @Bridge private native static void objc_setShowsCompletionBannerSuper(ObjCSuper __super__, Selector __cmd__, boolean showsCompletionBanner);
    
    /**
     * A banner will be momentarily displayed after reporting a completed achievement if set to true
     * @param showsCompletionBanner
     */
    public void setShowsCompletionBanner(boolean showsCompletionBanner){
    	if(customClass){
    		objc_setShowsCompletionBannerSuper(getSuper(), setShowsCompletionBanner, showsCompletionBanner);
    	}else{
    		objc_setShowsCompletionBanner(this, setShowsCompletionBanner, showsCompletionBanner);
    	}
    }

    //- (void)reportAchievementWithCompletionHandler:(void(^)(NSError *error))completionHandler __OSX_AVAILABLE_BUT_DEPRECATED(__MAC_10_8,__MAC_NA,__IPHONE_4_1,__IPHONE_7_0);
    private static final Selector reportAchievementWithCompletionHandler = Selector.register("reportAchievementWithCompletionHandler:");
    
    @Bridge private native static void objc_reportAchievement(GKAchievement __self__, Selector __cmd__, VoidNSErrorBlock completionHandler);
    @Bridge private native static void objc_reportAchievementSuper(ObjCSuper __super__, Selector __cmd__, VoidNSErrorBlock completionHandler);
    
    /**
     * Report this achievement to the server. Percent complete is required. Points, completed state are set based on percentComplete. isHidden is set to NO anytime this method is invoqued. Date is optional. Error will be nil on success.
	 * Possible reasons for error:
 	 * 1. Local player not authenticated
	 * 2. Communications failure
	 * 3. Reported Achievement does not exist
     * @param completionHandler
     */
    @Deprecated
    public void reportAchievement(VoidNSErrorBlock completionHandler){
    	if(customClass){
    		objc_reportAchievementSuper(getSuper(), reportAchievementWithCompletionHandler, completionHandler);
    	}else{
    		objc_reportAchievement(this, reportAchievementWithCompletionHandler, completionHandler);
    	}
    }
    
    //+ (void)reportAchievements:(NSArray *)achievements withCompletionHandler:(void(^)(NSError *error))completionHandler __OSX_AVAILABLE_STARTING(__MAC_10_8,__IPHONE_6_0);
    private static final Selector reportAchievements$withCompletionHandler = Selector.register("reportAchievements:withCompletionHandler:");
    
    @SuppressWarnings("rawtypes")
	@Bridge private native static void objc_reportAchievements(ObjCClass __self__, Selector __cmd__, NSArray achievements, VoidNSErrorBlock completionHandler);
    
    /**
     * Report an array of achievements to the server. Percent complete is required. Points, completed state are set based on percentComplete. isHidden is set to NO anytime this method is invoked. Date is optional. Error will be nil on success.
     * Possible reasons for error:
     * 1. Local player not authenticated
     * 2. Communications failure
     * 3. Reported Achievement does not exist
     * @param achievements
     * @param completionHandler
     */
    @SuppressWarnings("rawtypes")
	public static void reportAchievements(NSArray achievements, VoidNSErrorBlock completionHandler){
		objc_reportAchievements(objCClass, reportAchievements$withCompletionHandler, achievements, completionHandler);
    }
    
    //+ (void)loadAchievementsWithCompletionHandler:(void(^)(NSArray *achievements, NSError *error))completionHandler;
    private static final Selector loadAchievementsWithCompletionHandler = Selector.register("loadAchievementsWithCompletionHandler:");
    
    @Bridge private native static void objc_loadAchievements(ObjCClass __self__, Selector __cmd__, VoidNSArrayNSErrorBlock completionHandler);
    
    /**
     * Asynchronously load all achievements for the local player
     * @param completionHandler
     */
    public static void loadAchievements(VoidNSArrayNSErrorBlock completionHandler){
    	objc_loadAchievements(objCClass, loadAchievementsWithCompletionHandler, completionHandler);
    }
    
    //+ (void)resetAchievementsWithCompletionHandler:(void(^)(NSError *error))completionHandler;
    private static final Selector resetAchievementsWithCompletionHandler = Selector.register("resetAchievementsWithCompletionHandler:");
    
    @Bridge private native static void objc_resetAchievements(ObjCClass __self__, Selector __cmd__, VoidNSErrorBlock completionHandler);
    
    /**
     * Reset the achievements progress for the local player. All the entries for the local player are removed from the server. Error will be nil on success.
     * Possible reasons for error:
     * 1. Local player not authenticated
     * 2. Communications failure
     * @param completionHandler
     */
    public static void resetAchievements(VoidNSErrorBlock completionHandler){
    	objc_resetAchievements(objCClass, resetAchievementsWithCompletionHandler, completionHandler);
    }

}
