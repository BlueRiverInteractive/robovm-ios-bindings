package com.michingo.robovmbindings.gpgs;

import org.robovm.cocoatouch.foundation.NSError;
import org.robovm.objc.ObjCBlock;
import org.robovm.objc.ObjCBlock.Wrapper;
import org.robovm.rt.bro.annotation.Callback;
import org.robovm.rt.bro.annotation.Marshaler;
import org.robovm.rt.bro.annotation.Pointer;

//typedef void (^GPGAppStateWriteResultHandler)(GPGAppStateWriteStatus status, NSError *error);
@Marshaler(GPGAppStateWriteResultHandler.Marshaler.class)
public interface GPGAppStateWriteResultHandler {
	
	/**
     * Runs this block.
     */
    void invoke(GPGAppStateWriteStatus status, NSError error);
    
    static class Callbacks {
        @Callback static void run(ObjCBlock block, GPGAppStateWriteStatus status, NSError error) {
            ((GPGAppStateWriteResultHandler) block.object()).invoke(status, error);
        }
    }
    
    static class Marshaler {
        private static final Wrapper WRAPPER = new Wrapper(Callbacks.class);
        public static @Pointer long toNative(Object o) {
            return WRAPPER.toNative(o);
        }
        public static void updateObject(Object o, long handle) {}
    }
}
