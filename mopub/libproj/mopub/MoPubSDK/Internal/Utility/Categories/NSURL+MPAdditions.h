//
//  NSURL+MPAdditions.h
//  MoPub
//
//  Copyright (c) 2013 MoPub. All rights reserved.
//

#import <Foundation/Foundation.h>

typedef enum {
    MPMoPubHostCommandUnrecognized,
    MPMoPubHostCommandClose,
    MPMoPubHostCommandFinishLoad,
    MPMoPubHostCommandFailLoad,
    MPMoPubHostCommandCustom,
    MPMoPubHostCommandPrecacheComplete
} MPMoPubHostCommand;

@interface NSURL (MPAdditions)

- (NSDictionary *)mp_queryAsDictionary;
- (BOOL)mp_hasTelephoneScheme;
- (BOOL)mp_hasTelephonePromptScheme;
- (BOOL)mp_isSafeForLoadingWithoutUserAction;
- (BOOL)mp_isMoPubScheme;
- (MPMoPubHostCommand)mp_mopubHostCommand;

@end
