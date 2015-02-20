//
//  RecommendedItem.h
//  PAE_iOS_SDK
//
//  Created by Shephertz Technology on 12/04/12.
//  Copyright (c) 2012 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>
@class Recommender;

/**
 * An inner class that contains the remaining properties of the Recommender.
 *
 */

@interface RecommendedItem : NSObject{
    NSString *userId;
    NSString *item;
    double value;
    Recommender *recommenderObject;
}
/*!
 *set and get the userId of the User. 
 */
@property(nonatomic,retain)NSString *userId;
/*!
 *set and get the item for the Recommended Item.
 */
@property(nonatomic,retain)NSString *item;
/*!
 *set and get the value for the Recommended Item. 
 */
@property(nonatomic,assign)double value;
/*!
 *set and get the recommenderObject for RecommendedItem Object 
 */
@property(nonatomic,retain)Recommender *recommenderObject;


- (id) init __attribute__((unavailable));

-(id)initWithRecommender:(Recommender*)recommenderObj;

@end
