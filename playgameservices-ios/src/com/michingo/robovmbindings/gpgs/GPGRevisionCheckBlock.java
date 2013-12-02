package com.michingo.robovmbindings.gpgs;

import org.robovm.cocoatouch.foundation.NSError;
import org.robovm.objc.ObjCBlock;
import org.robovm.objc.ObjCBlock.Wrapper;
import org.robovm.rt.bro.annotation.Callback;
import org.robovm.rt.bro.annotation.Marshaler;
import org.robovm.rt.bro.annotation.Pointer;

//typedef void (^GPGRevisionCheckBlock)(GPGRevisionStatus revisionStatus, NSError *error);
@Marshaler(GPGRevisionCheckBlock.Marshaler.class)
public interface GPGRevisionCheckBlock {

  /**
   * Runs this block.
   */
  void invoke(GPGRevisionStatus revisionStatus, NSError error);
  
  static class Callbacks {
      @Callback static void run(ObjCBlock block, GPGRevisionStatus revisionStatus, NSError error) {
          ((GPGRevisionCheckBlock) block.object()).invoke(revisionStatus, error);
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