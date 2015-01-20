package org.robovm.bindings.everyplay;

import org.robovm.apple.foundation.NSNumber;
import org.robovm.apple.foundation.NSObjectProtocol;
import org.robovm.apple.foundation.NSURL;
import org.robovm.objc.annotation.Method;

public interface EveryplayDelegate extends NSObjectProtocol {

	// - (void)everyplayShown;
	@Method(selector = "everyplayShown")
	void everyplayShown();

	// - (void)everyplayHidden;
	@Method(selector = "everyplayHidden")
	void everyplayHidden();

	// - (void)everyplayReadyForRecording:(NSNumber *)enabled;
	@Method(selector = "everyplayReadyForRecording:")
	void everyplayReadyForRecording(NSNumber enabled);

	// - (void)everyplayRecordingStarted;
	@Method(selector = "everyplayRecordingStarted")
	void everyplayRecordingStarted();

	// - (void)everyplayRecordingStopped;
	@Method(selector = "everyplayRecordingStopped")
	void everyplayRecordingStopped();

	// - (void)everyplayFaceCamSessionStarted;
	@Method(selector = "everyplayFaceCamSessionStarted")
	void everyplayFaceCamSessionStarted();

	// - (void)everyplayFaceCamRecordingPermission:(NSNumber *)granted;
	@Method(selector = "everyplayFaceCamRecordingPermission:")
	void everyplayFaceCamRecordingPermission(NSNumber granted);

	// - (void)everyplayFaceCamSessionStopped;
	@Method(selector = "everyplayFaceCamSessionStopped")
	void everyplayFaceCamSessionStopped();

	// - (void)everyplayUploadDidStart:(NSNumber *)videoId;
	@Method(selector = "everyplayUploadDidStart:")
	void everyplayUploadDidStart(NSNumber videoId);

	// - (void)everyplayUploadDidProgress:(NSNumber *)videoId progress:(NSNumber
	// *)progress;
	@Method(selector = "everyplayUploadDidProgress:progress:")
	void everyplayUploadDidProgress(NSNumber videoId, NSNumber progress);

	// - (void)everyplayUploadDidComplete:(NSNumber *)videoId;
	@Method(selector = "everyplayUploadDidComplete:")
	void everyplayUploadDidComplete(NSNumber videoId);

	// - (void)everyplayThumbnailReadyAtFilePath:(NSString *)thumbnailFilePath;
	@Method(selector = "everyplayThumbnailReadyAtFilePath:")
	void everyplayThumbnailReadyAtFilePath(String thumbnailFilePath);

	// - (void)everyplayThumbnailReadyAtURL:(NSURL *)thumbnailUrl;
	@Method(selector = "everyplayThumbnailReadyAtURL:")
	void everyplayThumbnailReadyAtURL(NSURL thumbnailUrl);

	// - (void)everyplayThumbnailReadyAtTextureId:(NSNumber *)textureId
	// portraitMode:(NSNumber *)portrait;
	@Method(selector = "everyplayThumbnailReadyAtTextureId:portraitMode")
	void everyplayThumbnailReadyAtTextureId(NSNumber textureId,
			NSNumber portrait);
}
