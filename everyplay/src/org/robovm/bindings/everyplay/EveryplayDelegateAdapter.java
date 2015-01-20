package org.robovm.bindings.everyplay;

import org.robovm.apple.foundation.NSNumber;
import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.foundation.NSURL;

public class EveryplayDelegateAdapter extends NSObject implements
		EveryplayDelegate {

	@Override
	public void everyplayShown() {
	}

	@Override
	public void everyplayHidden() {
	}

	@Override
	public void everyplayReadyForRecording(NSNumber enabled) {
	}

	@Override
	public void everyplayRecordingStarted() {
	}

	@Override
	public void everyplayRecordingStopped() {
	}

	@Override
	public void everyplayFaceCamSessionStarted() {
	}

	@Override
	public void everyplayFaceCamRecordingPermission(NSNumber granted) {
	}

	@Override
	public void everyplayFaceCamSessionStopped() {
	}

	@Override
	public void everyplayUploadDidStart(NSNumber videoId) {
	}

	@Override
	public void everyplayUploadDidProgress(NSNumber videoId, NSNumber progress) {
	}

	@Override
	public void everyplayUploadDidComplete(NSNumber videoId) {
	}

	@Override
	public void everyplayThumbnailReadyAtFilePath(String thumbnailFilePath) {
	}

	@Override
	public void everyplayThumbnailReadyAtURL(NSURL thumbnailUrl) {
	}

	@Override
	public void everyplayThumbnailReadyAtTextureId(NSNumber textureId,
			NSNumber portrait) {
	}

}
