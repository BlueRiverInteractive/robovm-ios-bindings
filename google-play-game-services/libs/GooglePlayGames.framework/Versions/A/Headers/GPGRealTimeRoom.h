//
// Google Play Games Platform Services
// Copyright 2013 Google Inc. All rights reserved.
//
#import <Foundation/Foundation.h>

#import "GPGEnums.h"

@class GPGMultiplayerConfig;
@class GPGRealTimeRoom;
@class GPGRealTimeRoomData;
@class GPGRealTimeParticipant;

typedef void(^GPGRealTimeParticipantIterator)(GPGRealTimeParticipant *participant);

#pragma mark -

@protocol GPGRealTimeRoomDelegate <NSObject>
@optional

- (void)didAcceptRealTimeInviteForRoom:(GPGRealTimeRoomData *)roomData;

- (void)didDeclineRealTimeInviteForRoom:(GPGRealTimeRoomData *)roomData;

- (void)didReceiveRealTimeInviteForRoom:(GPGRealTimeRoomData *)roomData;

- (void)room:(GPGRealTimeRoom *)room didChangeStatus:(GPGRealTimeRoomStatus)status;

- (void)room:(GPGRealTimeRoom *)room didChangeConnectedSet:(BOOL)connected;

- (void)room:(GPGRealTimeRoom *)room
        participant:(GPGRealTimeParticipant *)participant
    didChangeStatus:(GPGRealTimeParticipantStatus)status;

- (void)room:(GPGRealTimeRoom *)room
     didReceiveData:(NSData *)data
    fromParticipant:(GPGRealTimeParticipant *)participant
           dataMode:(GPGRealTimeDataMode)dataMode;

- (void)room:(GPGRealTimeRoom *)room
    didSendReliableId:(int)reliableId
              results:(NSArray *)results;

- (void)room:(GPGRealTimeRoom *)room didFailWithError:(NSError *)error;

@end

#pragma mark -

@interface GPGRealTimeRoomCreationHandle : NSObject

- (BOOL)cancel;

@end

#pragma mark -

@interface GPGRealTimeRoomModifyDetails : NSObject

@property(nonatomic, readonly, assign) int64_t lastUpdateTimestamp;

@property(nonatomic, readonly, strong) GPGRealTimeParticipant *participant;

@end

#pragma mark -

@interface GPGRealTimeReliableMessageResult : NSObject

@property(nonatomic, readonly, strong) GPGRealTimeParticipant *participant;

@property(nonatomic, readonly, assign) BOOL success;

@end

#pragma mark -

@interface GPGRealTimeParticipant : NSObject

@property (nonatomic, readonly) BOOL canCommunicate;

- (int)sendReliableData:(NSData *)data;

- (void)sendUnreliableData:(NSData *)data;

@property(nonatomic, readonly, copy) NSURL *avatarUrl;

@property(nonatomic, readonly, copy) NSString *displayName;

@property(nonatomic, readonly, copy) NSString *participantId;

@property(nonatomic, readonly, assign) BOOL isAutoMatchedPlayer;

@property(nonatomic, readonly, assign) BOOL isLocalParticipant;

@property(nonatomic, readonly, assign) GPGRealTimeParticipantStatus status;

@end

#pragma mark -

@interface GPGRealTimeRoom : NSObject

@property(nonatomic, readonly, strong) GPGMultiplayerConfig *config;

@property(nonatomic, readonly, copy) NSArray *participants;

@property(nonatomic, readonly, copy) NSArray *connectedParticipants;

@property(nonatomic, readonly, strong) GPGRealTimeParticipant *localParticipant;

@property(nonatomic, readonly, copy) NSString *roomDescription;

@property(nonatomic, readonly, copy) NSString *roomID;

@property(nonatomic, readonly, assign) BOOL inConnectedSet;

@property(nonatomic, readonly, strong) GPGRealTimeRoomModifyDetails *creationDetails;

@property(nonatomic, readonly, assign) GPGRealTimeRoomStatus status;

@property(nonatomic, readonly, copy) NSNumber *waitEstimateSeconds;

- (GPGRealTimeParticipant *)findParticipantById:(NSString *)participantId;

- (void)enumerateParticipantsUsingBlock:(GPGRealTimeParticipantIterator)iterator;

- (void)enumerateOtherParticipantsUsingBlock:(GPGRealTimeParticipantIterator)iterator;

- (void)enumerateConnectedParticipantsUsingBlock:(GPGRealTimeParticipantIterator)iterator;

- (int)sendReliableData:(NSData *)data
         toParticipants:(NSArray *)participants;

- (void)sendUnreliableData:(NSData *)data
            toParticipants:(NSArray *)participants;

- (int)sendReliableDataToAll:(NSData *)data;

- (void)sendUnreliableDataToAll:(NSData *)data;

- (int)sendReliableDataToOthers:(NSData *)data;

- (void)sendUnreliableDataToOthers:(NSData *)data;

- (void)leave;

@end
