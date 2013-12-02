package com.michingo.robovmbindings.gpgs;

import org.robovm.cocoatouch.foundation.NSError;
import org.robovm.objc.ObjCBlock;
import org.robovm.objc.ObjCBlock.Wrapper;
import org.robovm.rt.bro.annotation.Callback;
import org.robovm.rt.bro.annotation.Marshaler;
import org.robovm.rt.bro.annotation.Pointer;

//typedef void (^GPGScoreBatchReportBlock)(NSError *error);
@Marshaler(GPGScoreBatchReportBlock.Marshaler.class)
public interface GPGScoreBatchReportBlock {

    /**
     * Runs this block.
     */
    void invoke(NSError error);
    
    static class Callbacks {
        @Callback static void run(ObjCBlock block, NSError error) {
            ((GPGScoreBatchReportBlock) block.object()).invoke(error);
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