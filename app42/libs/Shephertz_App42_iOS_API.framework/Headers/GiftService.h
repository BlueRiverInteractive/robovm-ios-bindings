//
//  GiftService.h
//  PAE_iOS_SDK
//
//  Created by Shephertz Technologies Pvt Ltd on 12/06/14.
//  Copyright (c) 2014 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Shephertz_App42_iOS_API/Shephertz_App42_iOS_API.h>
@class Gift;

@interface GiftService : App42Service

- (id) init __attribute__((unavailable));
/**
 * This is a constructor that takes
 *
 * @param apiKey
 * @param secretKey
 * @param baseURL
 *
 */
-(id)initWithAPIKey:(NSString *)apiKey  secretKey:(NSString *)secretKey;

/**
 * Create a gift.
 *
 * @param giftName
 *            - Name of gift to be created.
 * @param giftIconPath
 *            - File path of the gift icon
 * @param displayName
 *            - An alternate name of the gift that can be used to display
 * @param tag
 *            - tag for the Gift
 * @param description
 *            - Description of the Gift to be created
 * @return Gift Object
 * @throws App42Exception
 */
-(void)createGiftWithName:(NSString*)giftName giftIconPath:(NSString*)giftIconPath displayName:(NSString*)displayName giftTag:(NSString*)tag description:(NSString*)description completionBlock:(App42ResponseBlock)completionBlock;

/**
 * Get all gifts available.
 *
 * @return NSArray of gift Object
 * @throws App42Exception
 */
-(void)getAllGifts:(App42ResponseBlock)completionBlock;

/**
 * Get gift with its name.
 *
 * @param giftName
 *            - Name of gift to be fetched.
 * @return Gift Object
 * @throws App42Exception
 */
-(void)getGiftByName:(NSString*)giftName completionBlock:(App42ResponseBlock)completionBlock;

/**
 * Get all gifts having same tag.
 *
 * @param tag
 *            - tag for the Gift
 * @return NSArray of gift Objects
 * @throws App42Exception
 */
-(void)getGiftsByTag:(NSString*)tag completionBlock:(App42ResponseBlock)completionBlock;

/**
 * Delete a gift with name.
 *
 * @param giftName
 *            - Name of gift to be created.
 * @return App42Response
 * @throws App42Exception
 */
-(void)deleteGiftByName:(NSString*)giftName completionBlock:(App42ResponseBlock)completionBlock;

/**
 * Send a gift with name to other users.
 *
 * @param giftName
 *            - Name of gift to be created.
 * @param sender
 *            - Name of the user who is sending the gift.
 * @param recipients
 *            - Array of the user who will receive the gift.
 * @param message
 *            - message that you want to send with gift.
 * @return Gift Object
 * @throws App42Exception
 */
-(void)sendGiftWithName:(NSString*)giftName from:(NSString*)sender to:(NSArray*)recipients withMessage:(NSString*)message completionBlock:(App42ResponseBlock)completionBlock;

/**
 * Request a gift with name from other users.
 *
 * @param giftName
 *            - Name of gift to be created.
 * @param sender
 *            - Name of the user who is requesting for the gift.
 * @param recipients
 *            - Array of the user who will receive the request.
 * @param message
 *            - message that you want to send with request.
 * @return Gift Object
 * @throws App42Exception
 */
-(void)requestGiftWithName:(NSString*)giftName from:(NSString*)sender to:(NSArray*)recipients withMessage:(NSString*)message completionBlock:(App42ResponseBlock)completionBlock;

/**
 * Get a gift request from a user.
 *
 * @param giftName
 *            - Name of gift to be created.
 * @param userName
 *            - Name of the user who is requesting for the gift.
 * @return Gift Object
 * @throws App42Exception
 */
-(void)getGiftRequestWithName:(NSString*)giftName fromUser:(NSString*)userName completionBlock:(App42ResponseBlock)completionBlock;


-(void)distributeGiftsWithName:(NSString*)giftName to:(NSArray*)recipients count:(int)count completionBlock:(App42ResponseBlock)completionBlock;

-(void)getGiftCountWithName:(NSString*)giftName forUser:(NSString*)userName completionBlock:(App42ResponseBlock)completionBlock;

-(void)acceptGiftRequestWithId:(NSString*)requestId by:(NSString*)recipient completionBlock:(App42ResponseBlock)completionBlock;

-(void)rejectGiftRequestWithId:(NSString*)requestId by:(NSString*)recipient completionBlock:(App42ResponseBlock)completionBlock;

-(void)removeGiftWithRequestId:(NSString*)requestId by:(NSString*)recipient completionBlock:(App42ResponseBlock)completionBlock;

@end
