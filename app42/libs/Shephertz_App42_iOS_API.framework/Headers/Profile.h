//
//  Profile.h
//  App42_iOS_SERVICE_APIs
//
//  Created by Shephertz Technology on 08/02/12.
//  Copyright (c) 2012 ShephertzTechnology PVT LTD. All rights reserved.
//




#import <Foundation/Foundation.h>
@class User;
/**
 * Data object which captures User Profile Information.
 * Profile is used with User service
 * @see User
 * 
 */
@interface Profile : NSObject{
    
    NSString *firstName;
    NSString *lastName;
    NSString *sex;
    NSString *mobile;
    NSString *line1;
    NSString *line2;
    NSString *city;
    NSString *state;
    NSString *country;
    NSString *pincode;
    NSString *homeLandLine;
    NSString *officeLandLine;
    NSDate *dateOfBirth;
    User *userObj;
}
/*!
 *set and get the first name of the User.
 */
@property(nonatomic,retain) NSString *firstName;
/*!
 *set and get the last name of the User.
 */
@property(nonatomic,retain) NSString *lastName;
/*!
 *set and get the gender of the User.. We have defined Constants Value in enum SEX for them. Use the defined constants i.e. MALE and FEMALE. 
 */
@property(nonatomic,retain) NSString *sex;
/*!
 *set and get the mobile number of the User.
 */
@property(nonatomic,retain) NSString *mobile;
/*!
 *set and get the address line1 of the User.
 */
@property(nonatomic,retain) NSString *line1;
/*!
 *set and get the address line2 of the User.
 */
@property(nonatomic,retain) NSString *line2;
/*!
 *set and get the city in profile for user
 */
@property(nonatomic,retain) NSString *city;
/*!
 *set and get  the state of the User.
 */
@property(nonatomic,retain) NSString *state;
/*!
 *set and get the country of the User.
 */
@property(nonatomic,retain) NSString *country;
/*!
 *set and get the pincode of the User.
 */
@property(nonatomic,retain) NSString *pincode;
/*!
 *set and get the home land line of the User.
 */
@property(nonatomic,retain) NSString *homeLandLine;
/*!
 *set and get the office land line of the User.
 */
@property(nonatomic,retain) NSString *officeLandLine;
/*!
 *set and get the date of birth of the User.
 */
@property(nonatomic,retain) NSDate *dateOfBirth;

@property(nonatomic,retain) User *userObj;


-(id)initWithUser:(User*)userObj;

@end
