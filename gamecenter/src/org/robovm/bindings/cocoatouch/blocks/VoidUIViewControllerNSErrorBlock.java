package org.robovm.bindings.cocoatouch.blocks;

import org.robovm.cocoatouch.foundation.NSError;
import org.robovm.cocoatouch.uikit.UIViewController;
import org.robovm.objc.ObjCBlock;
import org.robovm.objc.ObjCBlock.Wrapper;
import org.robovm.rt.bro.annotation.Callback;
import org.robovm.rt.bro.annotation.Marshaler;
import org.robovm.rt.bro.annotation.Pointer;

/**
 * Block which takes a single boolean argument and returns no value. This is 
 * used to map the Objective-C {@code void (^)(BOOL)} block type.
 */
@Marshaler(VoidUIViewControllerNSErrorBlock.Marshaler.class)
public interface VoidUIViewControllerNSErrorBlock {

    /**
     * Runs this block.
     */
    public void invoke(UIViewController viewController, NSError error);
    
    static class Callbacks {
        @Callback static void run(ObjCBlock block, UIViewController viewController, NSError error) {
            ((VoidUIViewControllerNSErrorBlock) block.object()).invoke(viewController, error);
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