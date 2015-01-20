package org.robovm.bindings.everyplay;

import org.robovm.apple.foundation.NSNumber;
import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.foundation.NSURL;

import com.badlogic.gdx.Gdx;
import com.riftergames.ovi.PuffGame;

public class EveryplayDelegateAdapter extends NSObject implements
		EveryplayDelegate {

	@Override
	public void everyplayShown() {
		Gdx.app.log(PuffGame.LOG, "EveryplayDelegate everyplayShown");
	}

	@Override
	public void everyplayHidden() {
		Gdx.app.log(PuffGame.LOG, "EveryplayDelegate everyplayHidden");
	}

	@Override
	public void everyplayReadyForRecording(NSNumber enabled) {
		Gdx.app.log(PuffGame.LOG,
				"EveryplayDelegate everyplayReadyForRecording");
	}

	@Override
	public void everyplayRecordingStarted() {
		Gdx.app.log(PuffGame.LOG, "EveryplayDelegate everyplayRecordingStarted");
	}

	@Override
	public void everyplayRecordingStopped() {
		Gdx.app.log(PuffGame.LOG, "EveryplayDelegate everyplayRecordingStopped");
	}

	@Override
	public void everyplayFaceCamSessionStarted() {
		Gdx.app.log(PuffGame.LOG,
				"EveryplayDelegate everyplayFaceCamSessionStarted");
	}

	@Override
	public void everyplayFaceCamRecordingPermission(NSNumber granted) {
		Gdx.app.log(PuffGame.LOG,
				"EveryplayDelegate everyplayFaceCamRecordingPermission");
	}

	@Override
	public void everyplayFaceCamSessionStopped() {
		Gdx.app.log(PuffGame.LOG,
				"EveryplayDelegate everyplayFaceCamSessionStopped");
	}

	@Override
	public void everyplayUploadDidStart(NSNumber videoId) {
		Gdx.app.log(PuffGame.LOG, "EveryplayDelegate everyplayUploadDidStart");
	}

	@Override
	public void everyplayUploadDidProgress(NSNumber videoId, NSNumber progress) {
		Gdx.app.log(PuffGame.LOG,
				"EveryplayDelegate everyplayUploadDidProgress");
	}

	@Override
	public void everyplayUploadDidComplete(NSNumber videoId) {
		Gdx.app.log(PuffGame.LOG,
				"EveryplayDelegate everyplayUploadDidComplete");
	}

	@Override
	public void everyplayThumbnailReadyAtFilePath(String thumbnailFilePath) {
		Gdx.app.log(PuffGame.LOG,
				"EveryplayDelegate everyplayThumbnailReadyAtFilePath");
	}

	@Override
	public void everyplayThumbnailReadyAtURL(NSURL thumbnailUrl) {
		Gdx.app.log(PuffGame.LOG,
				"EveryplayDelegate everyplayThumbnailReadyAtURL");
	}

	@Override
	public void everyplayThumbnailReadyAtTextureId(NSNumber textureId,
			NSNumber portrait) {
		Gdx.app.log(PuffGame.LOG,
				"EveryplayDelegate everyplayThumbnailReadyAtTextureId");
	}

}
