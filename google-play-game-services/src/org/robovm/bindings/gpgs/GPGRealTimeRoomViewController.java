package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSMutableArray;
import org.robovm.apple.uikit.UINavigationController;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;
import org.robovm.rt.bro.annotation.Library;
import org.robovm.rt.bro.annotation.Pointer;

@Library(Library.INTERNAL)
@NativeClass()
public class GPGRealTimeRoomViewController extends UINavigationController {


//- (id)initWithMinPlayers:(int)minPlayers
//              maxPlayers:(int)maxPlayers
//        exclusiveBitMask:(int)exclusiveBitMask
//                 variant:(int)variant;
//
//- (id)initWithMinPlayers:(int)minPlayers 
//			  maxPlayers:(int)maxPlayers;
//
//- (id)initAndCreateRoomWithConfig:(GPGMultiplayerConfig *)config;
//
//- (id)initWithRoomDataList:(NSMutableArray *)roomDataList;

@Method(selector = "initWithMinPlayers:maxPlayers:exclusiveBitMask:variant:")
private native @Pointer long init(int minPlayers, int maxPlayers,int exclusiveBitMask, int variant);
@Method(selector = "initWithMinPlayers:maxPlayers:")
private native @Pointer long init(int minPlayers, int maxPlayers);
@Method(selector = "initAndCreateRoomWithConfig:")
private native @Pointer long init(GPGMultiplayerConfig config);
@Method(selector = "initWithRoomDataList:")
private native @Pointer long init(NSMutableArray roomDataList);

public GPGRealTimeRoomViewController(int minPlayers, int maxPlayers,int exclusiveBitMask, int variant) {
    super((SkipInit)null);
    initObject(init(minPlayers, maxPlayers, exclusiveBitMask, variant));
}
public GPGRealTimeRoomViewController(int minPlayers, int maxPlayers) {
    super((SkipInit)null);
    initObject(init(minPlayers, maxPlayers));
}

public GPGRealTimeRoomViewController(GPGMultiplayerConfig config) {
    super((SkipInit)null);
    initObject(init(config));
}

public GPGRealTimeRoomViewController(NSMutableArray roomDataList) {
    super((SkipInit)null);
    initObject(init(roomDataList));
}


@Property(selector = "minPlayers")
public native String getMinPlayers();
@Property(selector = "setMinPlayers:", strongRef = true)
public native void setMinPlayers (int pMinPlayers);

@Property(selector = "maxPlayers")
public native String getMaxPlayers();
@Property(selector = "setMaxPlayers:", strongRef = true)
public native void setMaxPlayers (int pMaxPlayers);


}
