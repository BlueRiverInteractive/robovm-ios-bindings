/***********************************************************************
 *
 * Query.h
 * PAE_iOS_SDK
 * Created by shephertz technologies on 23/04/13.
 * Copyright (c) 2013 ShephertzTechnology PVT LTD. All rights reserved.
 *
 ***********************************************************************/

#import <Foundation/Foundation.h>

/***
 * Available Operators
 */

#define APP42_OP_EQUALS                  @"$eq"
#define APP42_OP_NOT_EQUALS              @"$ne"
#define APP42_OP_GREATER_THAN            @"$gt"
#define APP42_OP_LESS_THAN               @"$lt"
#define APP42_OP_GREATER_THAN_EQUALTO    @"$gte"
#define APP42_OP_LESS_THAN_EQUALTO       @"$lte"
#define APP42_OP_LIKE                    @"$lk"
#define APP42_OP_AND                     @"$and"
#define APP42_OP_OR                      @"$or"
#define APP42_OP_INLIST                  @"$in"

#define APP42_ORDER_ASCENDING            @"ASCENDING"
#define APP42_ORDER_DESCENDING           @"DESCENDING"

@interface Query : NSObject
{
    
}
@property (nonatomic,retain) NSMutableArray *jsonArray;
@property (nonatomic,retain) NSMutableDictionary *jsonObject;


-(id)initWithJsonObject:(NSMutableDictionary*)object;
-(id)initWithJsonArray:(NSMutableArray*)objectArray;
-(NSString*)getJsonQuery;
@end
