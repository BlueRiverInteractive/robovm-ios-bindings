package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.foundation.NSString;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;

@NativeClass()
public class GPGRealTimeRoomMaker extends NSObject {

//typedef void (^GPGListRoomsHandler)(NSArray *rooms, NSError *error);
//typedef void (^GPGRoomRequestHandler)(GPGRealTimeRoomData *data, NSError *error);
//typedef void (^GPGRoomDismissHandler)(NSError *error);
	
//+ (GPGRealTimeRoomCreationResult)createRoomFromConfig:(GPGMultiplayerConfig *)config;

//+ (GPGRealTimeRoomCreationResult)createRoomFromConfig:(GPGMultiplayerConfig *)config
//    operationHandle:(GPGRealTimeRoomCreationHandle * __autoreleasing *)handle;

//+ (GPGRealTimeRoomCreationResult)joinRoomFromData:(GPGRealTimeRoomData *)data;

//+ (GPGRealTimeRoomCreationResult)joinRoomFromData:(GPGRealTimeRoomData *)data
//    operationHandle:(GPGRealTimeRoomCreationHandle * __autoreleasing *)handle;

//+ (void)listRoomsWithMaxResults:(int)maxResults
//              completionHandler:(GPGListRoomsHandler)completionHandler;
//
//+ (void)getRoomWithId:(NSString *)roomId
//    completionHandler:(GPGRoomRequestHandler)completionHandler;
//
//+ (void)getRoomFromData:(GPGRealTimeRoomData *)roomData
//      completionHandler:(GPGRoomRequestHandler)completionHandler;
//
//+ (void)declineRoomFromData:(GPGRealTimeRoomData *)data
//          completionHandler:(GPGRoomRequestHandler)completionHandler;

//+ (void)dismissRoomFromData:(GPGRealTimeRoomData *)data
//          completionHandler:(GPGRoomDismissHandler)completionHandler;
//
//+ (GPGRealTimeRoom *)activeRoom;


	@Method(selector = "createRoomFromConfig:")
	public static native GPGRealTimeRoomCreationResult createRoom(GPGMultiplayerConfig config);
	@Method(selector = "createRoomFromConfig:operationHandle:")
	public static native GPGRealTimeRoomCreationResult createRoom(GPGMultiplayerConfig config, GPGRealTimeRoomCreationHandle handle);
	@Method(selector = "joinRoomFromData:")
	public static native GPGRealTimeRoomCreationResult joinRoom(GPGRealTimeRoomData data);
	@Method(selector = "joinRoomFromData:operationHandle:")
	public static native GPGRealTimeRoomCreationResult joinRoom(GPGRealTimeRoomData data, GPGRealTimeRoomCreationHandle handle);
	@Method(selector = "listRoomsWithMaxResults:completionHandler:")
	public static native void listRooms(int maxResults, @Block GPGListRoomsHandler completionHandler);	
	@Method(selector = "getRoomWithId:completionHandler:")
	public static native void getRoom(NSString roomId, @Block GPGRoomRequestHandler completionHandler);
	@Method(selector = "getRoomFromData:completionHandler:")
	public static native void getRoom(GPGRealTimeRoomData roomData, @Block GPGRoomRequestHandler completionHandler);
	@Method(selector = "declineRoomFromData:completionHandler:")
	public static native void declineRoom(GPGRealTimeRoomData data, @Block GPGRoomRequestHandler completionHandler);
	@Method(selector = "dismissRoomFromData:completionHandler:")
	public static native void dismissRoom(GPGRealTimeRoomData data, @Block GPGRoomDismissHandler completionHandler);
	@Method(selector = "activeRoom:")
	public static native GPGRealTimeRoom activeRoom();

}
