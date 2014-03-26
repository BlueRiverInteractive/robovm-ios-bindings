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
@class GPGRealTimeRoomViewController;

typedef void(^GPGRealTimeParticipantIterator)(GPGRealTimeParticipant *participant);

@protocol GPGRealTimeRoomDelegate <NSObject>
@optional

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

- (void)roomViewControllerDidClose:(GPGRealTimeRoomViewController *)roomViewController;

@end

@interface GPGRealTimeRoomCreationHandle : NSObject

- (BOOL)cancel;

@end

@interface GPGRealTimeRoomModifyDetails : NSObject

@property(nonatomic, readonly, assign) long long lastUpdateTimestamp;

@property(nonatomic, readonly, retain) GPGRealTimeParticipant *participant;

@end

@interface GPGRealTimeReliableMessageResult : NSObject

@property(nonatomic, readonly, retain) GPGRealTimeParticipant *participant;

@property(nonatomic, readonly, assign) BOOL success;

@end

@interface GPGRealTimeParticipant : NSObject

- (BOOL)canCommunicate;

- (int)sendReliableData:(NSData *)data;

- (void)sendUnreliableData:(NSData *)data;

@property(nonatomic, readonly, copy) NSURL *avatarUrl;

@property(nonatomic, readonly, copy) NSString *displayName;

@property(nonatomic, readonly, copy) NSString *participantId;

@property(nonatomic, readonly, assign) BOOL isAutoMatchedPlayer;

@property(nonatomic, readonly, assign) BOOL isLocalParticipant;

@property(nonatomic, readonly, assign) GPGRealTimeParticipantStatus status;

@end

@interface GPGRealTimeRoom : NSObject

@property(nonatomic, readonly, retain) GPGMultiplayerConfig *config;

@property(nonatomic, readonly, retain) NSArray *participants;

@property(nonatomic, readonly, retain) NSArray *connectedParticipants;

@property(nonatomic, readonly, retain) GPGRealTimeParticipant *localParticipant;

@property(nonatomic, readonly, copy) NSString *roomDescription;

@property(nonatomic, readonly, copy) NSString *roomID;

@property(nonatomic, readonly, assign) BOOL inConnectedSet;

@property(nonatomic, readonly, retain) GPGRealTimeRoomModifyDetails *creationDetails;

@property(nonatomic, readonly, assign) GPGRealTimeRoomStatus status;

@property(nonatomic, readonly, retain) NSNumber *waitEstimateSeconds;

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
