package com.michingo.robovmbindings.gpgs;

import org.robovm.cocoatouch.foundation.NSArray;
import org.robovm.cocoatouch.foundation.NSError;
import org.robovm.cocoatouch.foundation.NSNumber;
import org.robovm.objc.ObjCBlock;
import org.robovm.objc.ObjCBlock.Wrapper;
import org.robovm.rt.bro.annotation.Callback;
import org.robovm.rt.bro.annotation.Marshaler;
import org.robovm.rt.bro.annotation.Pointer;

//typedef void (^GPGAppStateListKeysHandler)(NSArray *states, NSNumber *maxKeyCount, NSError *error);
@SuppressWarnings("rawtypes")
@Marshaler(GPGAppStateListKeysHandler.Marshaler.class)
public interface GPGAppStateListKeysHandler {
	
	/**
     * Runs this block.
     */
    void invoke(NSArray states, NSNumber maxKeyCount, NSError error);
    
    static class Callbacks {
        @Callback static void run(ObjCBlock block, NSArray states, NSNumber maxKeyCount, NSError error) {
            ((GPGAppStateListKeysHandler) block.object()).invoke(states, maxKeyCount, error);
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
