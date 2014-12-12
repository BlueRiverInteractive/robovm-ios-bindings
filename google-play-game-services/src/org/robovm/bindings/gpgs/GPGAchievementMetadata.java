package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.foundation.NSURL;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
@NativeClass()
public class GPGAchievementMetadata extends NSObject {

	@Property(selector = "achievementId")
	public native String getAchievementId();
	@Property(selector = "state")
	public native GPGAchievementState getState();
	@Property(selector = "type")
	public native GPGAchievementType getType();
	@Property(selector = "name")
	public native String getName();
	@Property(selector = "achievementDescription")
	public native String getAchievementDescription();
	@Property(selector = "revealedIconUrl")
	public native NSURL getRevealedIconUrl();
	@Property(selector = "unlockedIconUrl")
	public native NSURL getUnlockedIconUrl();
	@Property(selector = "completedSteps")
	public native int getCompletedSteps();
	@Property(selector = "numberOfSteps")
	public native int getNumberOfSteps();
	@Property(selector = "formattedCompletedSteps")
	public native String getFormattedCompletedSteps();
	@Property(selector = "formattedNumberOfSteps")
	public native String getFormattedNumberOfSteps();
	@Property(selector = "lastUpdatedTimestamp")
	public native long getLastUpdatedTimestamp();
	@Property(selector = "progress")
	public native float getProgress();
	@Property(selector = "experiencePoints")
	public native int getExperiencePoints();

	@Method(selector = "metadataForAchievementId:completionHandler:")
	public static native void metadata(String achievementId, @Block GPGAchievementMetadataBlock completionHandler);
	@Method(selector = "metadataForAchievementId:dataSource:completionHandler:")
	public static native void metadata(String achievementId, GPGDataSource dataSource, @Block GPGAchievementMetadataBlock completionHandler);
	@Method(selector = "allMetadataWithCompletionHandler:")
	public static native void allMetadata(@Block GPGAchievementAllMetadataBlock completionHandler);
	@Method(selector = "allMetadataWithCompletionHandler:completionHandler")
	public static native void allMetadata(GPGDataSource dataSource, @Block GPGAchievementAllMetadataBlock completionHandler);
	
}
