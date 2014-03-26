//
// Google Play Games Platform Services
// Copyright 2013 Google Inc. All rights reserved.
//

#import <Foundation/Foundation.h>

#import "GPGEnums.h"

@interface GPGAppStateListInfo : NSObject

@property(nonatomic, readwrite, assign) BOOL dataIsStale;

@property(nonatomic, readwrite, copy) NSNumber *key;

@end

typedef void (^GPGAppStateListHandler)(NSNumber *key, NSData *state, NSError *error);

typedef void (^GPGAppStateListKeysHandler)(NSArray *states, NSNumber *maxKeyCount, NSError *error);

typedef void (^GPGAppStateLoadResultHandler)(GPGAppStateLoadStatus status, NSError *error);

typedef void (^GPGAppStateWriteResultHandler)(GPGAppStateWriteStatus status, NSError *error);

typedef NSData * (^GPGAppStateConflictHandler)(NSNumber *key,
                                               NSData *localState,
                                               NSData *remoteState);

@interface GPGAppStateModel : NSObject

- (void)setStateData:(NSData *)state forKey:(NSNumber *)key;

- (NSData *)stateDataForKey:(NSNumber *)key;


- (void)listStatesWithCompletionHandler:(GPGAppStateListHandler)completionHandler
                        conflictHandler:(GPGAppStateConflictHandler)conflictHandler;


- (void)listStateKeysWithCompletionHandler:(GPGAppStateListKeysHandler)completionHandler;


- (void)loadForKey:(NSNumber *)key
 completionHandler:(GPGAppStateLoadResultHandler)completionHandler
   conflictHandler:(GPGAppStateConflictHandler)conflictHandler;

- (void)updateForKey:(NSNumber *)key
   completionHandler:(GPGAppStateWriteResultHandler)completionHandler
     conflictHandler:(GPGAppStateConflictHandler)conflictHandler;

- (void)clearForKey:(NSNumber *)key
  completionHandler:(GPGAppStateWriteResultHandler)completionHandler
    conflictHandler:(GPGAppStateConflictHandler)conflictHandler;

- (void)deleteForKey:(NSNumber *)key
   completionHandler:(GPGAppStateWriteResultHandler)completionHandler;

@end
