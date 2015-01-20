package org.robovm.bindings.everyplay;

import org.robovm.apple.foundation.NSNumber;
import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.foundation.NSURL;
import org.robovm.objc.annotation.NotImplemented;

public class EveryplayDelegateAdapter extends NSObject implements
		EveryplayDelegate {

	@NotImplemented("everyplayShown")
	public void shown() {
		throw new UnsupportedOperationException();
	}

	@NotImplemented("everyplayHidden")
	public void hidden() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void readyForRecording(NSNumber enabled) {
	}

	@Override
	public void recordingStarted() {
	}

	@Override
	public void recordingStopped() {
	}

	@Override
	public void faceCamSessionStarted() {
	}

	@Override
	public void faceCamRecordingPermission(NSNumber granted) {
	}

	@Override
	public void faceCamSessionStopped() {
	}

	@Override
	public void uploadDidStart(NSNumber videoId) {
	}

	@Override
	public void uploadDidProgress(NSNumber videoId, NSNumber progress) {
	}

	@Override
	public void uploadDidComplete(NSNumber videoId) {
	}

	@Override
	public void thumbnailReadyAtFilePath(String thumbnailFilePath) {
	}

	@Override
	public void thumbnailReadyAtURL(NSURL thumbnailUrl) {
	}

	@Override
	public void thumbnailReadyAtTextureId(NSNumber textureId, NSNumber portrait) {
	}

}
