package org.robovm.bindings.cocoatouch.blocks;

import org.robovm.cocoatouch.foundation.NSArray;
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
@Marshaler(VoidNSArrayNSErrorBlock.Marshaler.class)
public interface VoidNSArrayNSErrorBlock {

    /**
     * Runs this block.
     */
    @SuppressWarnings("rawtypes")
	public void invoke(NSArray array, NSError error);
    
    static class Callbacks {
        @SuppressWarnings("rawtypes")
		@Callback static void run(ObjCBlock block, NSArray array, NSError error) {
            ((VoidNSArrayNSErrorBlock) block.object()).invoke(array, error);
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