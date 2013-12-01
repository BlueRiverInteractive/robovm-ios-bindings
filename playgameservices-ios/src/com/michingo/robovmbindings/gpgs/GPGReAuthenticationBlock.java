package com.michingo.robovmbindings.gpgs;

import org.robovm.cocoatouch.foundation.NSError;
import org.robovm.objc.ObjCBlock;
import org.robovm.objc.ObjCBlock.Wrapper;
import org.robovm.rt.bro.annotation.Callback;
import org.robovm.rt.bro.annotation.Marshaler;
import org.robovm.rt.bro.annotation.Pointer;

//typedef void (^GPGReAuthenticationBlock)(BOOL requiresKeychainWipe, NSError *error);
@Marshaler(GPGReAuthenticationBlock.Marshaler.class)
public interface GPGReAuthenticationBlock {

  /**
   * Runs this block.
   */
  void invoke(boolean requiresKeychainWipe, NSError error);
  
  static class Callbacks {
      @Callback static void run(ObjCBlock block, boolean requiresKeychainWipe, NSError error) {
          ((GPGReAuthenticationBlock) block.object()).invoke(requiresKeychainWipe, error);
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