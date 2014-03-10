
package org.robovm.bindings.gpgs;

import org.robovm.cocoatouch.foundation.NSArray;
import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSString;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
@NativeClass()
public class GPGAchievementModel extends NSObject {
	private static final ObjCClass objCClass = ObjCClass.getByType(GPGAchievementModel.class);

	static {
		ObjCRuntime.bind(GPGAchievementModel.class);
	}

	// - (NSArray *)allMetadata; // GPGAchievementMetadata objects
	private static final Selector allMetadata$ = Selector.register("allMetadata");

	@Bridge
	private native static NSArray<GPGAchievementMetadata> objc_allMetadata (GPGAchievementModel __self__, Selector __cmd__);

	public NSArray<GPGAchievementMetadata> allMetadata () {
		return objc_allMetadata(this, allMetadata$);
	}

	// - (GPGAchievementMetadata *)metadataForAchievementId:(NSString *)achievementId;
	private static final Selector metadataForAchievementId$ = Selector.register("metadataForAchievementId:");

	@Bridge
	private native static GPGAchievementMetadata objc_metadataForAchievementId (GPGAchievementModel __self__, Selector __cmd__,
		NSString achievementId);

	public GPGAchievementMetadata metadataForAchievementId (String achievementId) {
		return objc_metadataForAchievementId(this, metadataForAchievementId$, new NSString(achievementId));
	}

	// - (GPGAchievementNotificationQueue *)achievementNotificationQueue;
	// TODO: check what the hell this queue is about
	/*
	 * private static final Selector achievementNotificationQueue$ = Selector.register("achievementNotificationQueue");
	 * 
	 * @Bridge private native static GPGAchievementNotificationQueue objc_achievementNotificationQueue(GPGAchievementModel
	 * __self__, Selector __cmd__); public GPGAchievementNotificationQueue achievementNotificationQueue(){ return
	 * objc_achievementNotificationQueue(this, achievementNotificationQueue$); }
	 */

	// - (void)queueAchievementNotification:(GPGAchievementMetadata *)achievement;
	private static final Selector queueAchievementNotification$ = Selector.register("queueAchievementNotification:");

	@Bridge
	private native static void objc_queueAchievementNotification (GPGAchievementModel __self__, Selector __cmd__,
		GPGAchievementMetadata achievement);

	public void queueAchievementNotification (GPGAchievementMetadata achievement) {
		objc_queueAchievementNotification(this, queueAchievementNotification$, achievement);
	}
}
