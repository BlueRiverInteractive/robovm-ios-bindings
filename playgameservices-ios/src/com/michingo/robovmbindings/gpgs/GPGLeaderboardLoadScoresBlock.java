package com.michingo.robovmbindings.gpgs;

import org.robovm.cocoatouch.foundation.NSArray;
import org.robovm.cocoatouch.foundation.NSError;
import org.robovm.objc.ObjCBlock;
import org.robovm.objc.ObjCBlock.Wrapper;
import org.robovm.rt.bro.annotation.Callback;
import org.robovm.rt.bro.annotation.Marshaler;
import org.robovm.rt.bro.annotation.Pointer;

//typedef void (^GPGLeaderboardLoadScoresBlock)(NSArray *scores, NSError *error);
@Marshaler(GPGLeaderboardLoadScoresBlock.Marshaler.class)
public interface GPGLeaderboardLoadScoresBlock {

  /**
   * Runs this block.
   */
  void invoke(NSArray<GPGScore> scores, NSError error);
  
  static class Callbacks {
      @Callback static void run(ObjCBlock block, NSArray<GPGScore> scores, NSError error) {
    	  GPGScore.class.getName();//TODO: test this
          ((GPGLeaderboardLoadScoresBlock) block.object()).invoke(scores, error);
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