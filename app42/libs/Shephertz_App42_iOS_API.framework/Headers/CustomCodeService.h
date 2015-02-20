//
//  CustomCodeService.h
//  PAE_iOS_SDK
//
//  Created by Rajeev on 09/12/13.
//  Copyright (c) 2013 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Shephertz_App42_iOS_API/Shephertz_App42_iOS_API.h>

@interface CustomCodeService : App42Service

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
 * Runs custom code deployed in the App42 Cloud
 *
 * @param name
 *            - Name of deployed CustomCode Service
 * @param jsonBody
 *            - Request Body in JSON format
 * @return JSONObject
 */
-(void) runJavaCode:(NSString*)name requestBody:(NSDictionary*)requestBody completionBlock:(App42ResponseBlock)completionBlock;

@end
