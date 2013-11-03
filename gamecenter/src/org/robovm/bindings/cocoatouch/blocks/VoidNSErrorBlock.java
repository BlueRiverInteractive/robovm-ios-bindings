package org.robovm.bindings.cocoatouch.blocks;

import org.robovm.cocoatouch.foundation.NSError;
import org.robovm.objc.ObjCBlock;
import org.robovm.objc.ObjCBlock.Wrapper;
import org.robovm.rt.bro.annotation.Callback;
import org.robovm.rt.bro.annotation.Marshaler;
import org.robovm.rt.bro.annotation.Pointer;

/**
 * Block which takes a single boolean argument and returns no value. This is 
 * used to map the Objective-C {@code void (^)(BOOL)} block type.
 */
@Marshaler(VoidNSErrorBlock.Marshaler.class)
public interface VoidNSErrorBlock {

    /**
     * Runs this block.
     */
    public void invoke(NSError error);
    
    static class Callbacks {
        @Callback static void run(ObjCBlock block, NSError error) {
            ((VoidNSErrorBlock) block.object()).invoke(error);
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