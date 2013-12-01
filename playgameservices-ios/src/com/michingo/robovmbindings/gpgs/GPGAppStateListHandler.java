package com.michingo.robovmbindings.gpgs;

import com.michingo.robovmbindings.other.NSData;
import org.robovm.cocoatouch.foundation.NSError;
import org.robovm.cocoatouch.foundation.NSNumber;
import org.robovm.objc.ObjCBlock;
import org.robovm.objc.ObjCBlock.Wrapper;
import org.robovm.rt.bro.annotation.Callback;
import org.robovm.rt.bro.annotation.Marshaler;
import org.robovm.rt.bro.annotation.Pointer;

//typedef void (^GPGAppStateListHandler)(NSNumber *key, NSData *state, NSError *error);
@Marshaler(GPGAppStateListHandler.Marshaler.class)
public interface GPGAppStateListHandler {
	
	/**
     * Runs this block.
     */
    void invoke(NSNumber key, NSData state, NSError error);
    
    static class Callbacks {
        @Callback static void run(ObjCBlock block, NSNumber key, NSData state, NSError error) {
            ((GPGAppStateListHandler) block.object()).invoke(key, state, error);
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
