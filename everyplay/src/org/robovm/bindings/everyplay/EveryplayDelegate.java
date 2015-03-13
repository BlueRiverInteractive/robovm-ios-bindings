package org.robovm.bindings.everyplay;

import org.robovm.apple.foundation.NSNumber;
import org.robovm.apple.foundation.NSObjectProtocol;
import org.robovm.apple.foundation.NSURL;
import org.robovm.objc.annotation.Method;

public interface EveryplayDelegate extends NSObjectProtocol {

	// - (void)everyplayShown;
	@Method(selector = "everyplayShown")
	void shown();

	// - (void)everyplayHidden;
	@Method(selector = "everyplayHidden")
	void hidden();

	// - (void)everyplayReadyForRecording:(NSNumber *)enabled;
	@Method(selector = "everyplayReadyForRecording:")
	void readyForRecording(NSNumber enabled);

	// - (void)everyplayRecordingStarted;
	@Method(selector = "everyplayRecordingStarted")
	void recordingStarted();

	// - (void)everyplayRecordingStopped;
	@Method(selector = "everyplayRecordingStopped")
	void recordingStopped();

	// - (void)everyplayFaceCamSessionStarted;
	@Method(selector = "everyplayFaceCamSessionStarted")
	void faceCamSessionStarted();

	// - (void)everyplayFaceCamRecordingPermission:(NSNumber *)granted;
	@Method(selector = "everyplayFaceCamRecordingPermission:")
	void faceCamRecordingPermission(NSNumber granted);

	// - (void)everyplayFaceCamSessionStopped;
	@Method(selector = "everyplayFaceCamSessionStopped")
	void faceCamSessionStopped();

	// - (void)everyplayUploadDidStart:(NSNumber *)videoId;
	@Method(selector = "everyplayUploadDidStart:")
	void uploadDidStart(NSNumber videoId);

	// - (void)everyplayUploadDidProgress:(NSNumber *)videoId progress:(NSNumber
	// *)progress;
	@Method(selector = "everyplayUploadDidProgress:progress:")
	void uploadDidProgress(NSNumber videoId, NSNumber progress);

	// - (void)everyplayUploadDidComplete:(NSNumber *)videoId;
	@Method(selector = "everyplayUploadDidComplete:")
	void uploadDidComplete(NSNumber videoId);

	// - (void)everyplayThumbnailReadyAtFilePath:(NSString *)thumbnailFilePath;
	@Method(selector = "everyplayThumbnailReadyAtFilePath:")
	void thumbnailReadyAtFilePath(String thumbnailFilePath);

	// - (void)everyplayThumbnailReadyAtURL:(NSURL *)thumbnailUrl;
	@Method(selector = "everyplayThumbnailReadyAtURL:")
	void thumbnailReadyAtURL(NSURL thumbnailUrl);

	// - (void)everyplayThumbnailReadyAtTextureId:(NSNumber *)textureId
	// portraitMode:(NSNumber *)portrait;
	@Method(selector = "everyplayThumbnailReadyAtTextureId:portraitMode")
	void thumbnailReadyAtTextureId(NSNumber textureId,
			NSNumber portrait);
}
