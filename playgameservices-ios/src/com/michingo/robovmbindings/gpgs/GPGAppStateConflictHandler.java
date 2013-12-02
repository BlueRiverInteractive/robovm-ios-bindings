package com.michingo.robovmbindings.gpgs;

import com.michingo.robovmbindings.other.NSData;
import org.robovm.cocoatouch.foundation.NSNumber;
import org.robovm.objc.ObjCBlock;
import org.robovm.objc.ObjCBlock.Wrapper;
import org.robovm.rt.bro.annotation.Callback;
import org.robovm.rt.bro.annotation.Marshaler;
import org.robovm.rt.bro.annotation.Pointer;

//typedef NSData *(^GPGAppStateConflictHandler)(NSNumber *key, NSData *localState, NSData *remoteState);
@Marshaler(GPGAppStateConflictHandler.Marshaler.class)
public interface GPGAppStateConflictHandler {
	
	/**
     * Runs this block.
     */
    NSData invoke(NSNumber key, NSData localState, NSData remoteState);
    
    static class Callbacks {
        @Callback static NSData run(ObjCBlock block, NSNumber key, NSData localState, NSData remoteState) {
            return ((GPGAppStateConflictHandler) block.object()).invoke(key, localState, remoteState);
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
