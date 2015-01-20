package org.robovm.bindings.everyplay;

import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class EveryplayCapture extends NSObject {

	// @property (nonatomic, readonly) BOOL isPaused;

	// @property (nonatomic, readonly) BOOL isRecordingSupported;
	@Property(selector = "isRecordingSupported")
	public native boolean isRecordingSupported();

	// @property (nonatomic, readonly) BOOL isRecording;
	@Property(selector = "isRecording")
	public native boolean isRecording();

	// @property (nonatomic, readonly) BOOL isPaused;
	@Property(selector = "isPaused")
	public native boolean isPaused();

	// - (void)startRecording;
	@Method(selector = "startRecording")
	public native void startRecording();

	// - (void)stopRecording;
	@Method(selector = "stopRecording")
	public native void stopRecording();

	// - (void)pauseRecording;
	@Method(selector = "pauseRecording")
	public native void pauseRecording();

	// - (void)resumeRecording;
	@Method(selector = "resumeRecording")
	public native void resumeRecording();
}
