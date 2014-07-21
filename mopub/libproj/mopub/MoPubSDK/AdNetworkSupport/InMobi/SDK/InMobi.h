//
//  InMobi.h
//  InMobi Monetization SDK
//
//  Copyright (c) 2013 InMobi. All rights reserved.
//


#import "IMConstants.h"


/**
 * General functions common to all InMobi SDKs
 */
@interface InMobi : NSObject

/**
 * Initialize InMobi SDKs with the Publisher App Id obtained from InMobi portal.
 * @param publisherAppId publisher's app id
 */
+ (void)initialize:(NSString *)publisherAppId;

#pragma mark Console Log Levels

/**
 * Set the console logging level.
 * @param logLevel Log level to be set.
 */
+ (void)setLogLevel:(IMLogLevel)logLevel;

#pragma mark Device ID Mask

/**
 * This sets the Device Id Mask to restrict the Device Tracking not to be
 * based on certain Device Ids.
 * @param deviceIdMask Device id mask to be set.
 */
+ (void)setDeviceIdMask:(IMDeviceIdMask)deviceIdMask;

#pragma mark SDK Information

/**
 * Returns the sdk version.
 * @return the sdk version
 */
+ (NSString *)getVersion;

#pragma mark User Information

/**
 * Set user's gender.
 * @param gender Gender of the user
 */
+ (void)setGender:(IMGender)gender;

/**
 * Set user's educational qualification.
 * @param education Educational qualification of the user
 */
+ (void)setEducation:(IMEducation)education;

/**
 * Set user's ethnicity.
 * @param ethnicity Ethnicity of the user
 */
+ (void)setEthnicity:(IMEthnicity)ethnicity;

/**
 * Set user's date of birth.
 * @param dateOfBirth Date of Birth of the user as NSDate object
 */
+ (void)setDateOfBirth:(NSDate *)dateOfBirth;

/**
 * Set user's date of birth
 * @param month Birth month of the user
 * @param day Birth day of the user
 * @param year Birth year of the user
 */
+ (void)setDateOfBirthWithMonth:(NSUInteger)month
                            day:(NSUInteger)day
                           year:(NSUInteger)year;

/**
 * Set user's annual income.
 * @param income Annual income of the user in USD
 */
+ (void)setIncome:(NSInteger)income;

/**
 * Set user's age.
 * @param age Age of the user
 */
+ (void)setAge:(NSInteger)age;

/**
 * Set user's marital status.
 * @param status Marital status of the user
 */
+ (void)setMaritalStatus:(IMMaritalStatus)status;

/**
 * Set whether the user has any children.
 * @param children Boolean for whether the user has any children
 */
+ (void)setHasChildren:(IMHasChildren)children;

/**
 * Set user's sexual orientation.
 * @param sexualOrientation Sexual orientation of the user
 */
+ (void)setSexualOrientation:(IMSexualOrientation)sexualOrientation;

/**
 * Set user's language preference.
 * @param langugage Preferred language of the user
 */
+ (void)setLanguage:(NSString *)langugage;

/**
 * Set user's postal code.
 * @param postalCode Postal code of the user
 */
+ (void)setPostalCode:(NSString *)postalCode;

/**
 * Set user's area code.
 * @param areaCode Area code of the user
 */
+ (void)setAreaCode:(NSString *)areaCode;

/**
 * Set user's interests (contextually relevant strings comma separated).
 * @param interests Interests of the user. E.g: @"cars,bikes,racing"
 */
+ (void)setInterests:(NSString *)interests;

#pragma mark User Location

/**
 * Use this to set the user's current location to deliver more relevant ads.
 * However do not use Core Location just for advertising, make sure it is used
 * for more beneficial reasons as well.  It is both a good idea and part of
 * Apple's guidelines.
 * @param latitude Location latitude
 * @param longitude Location longitude
 * @param accuracyInMeters Location accuracy in meters
 */
+ (void)setLocationWithLatitude:(CGFloat)latitude
                      longitude:(CGFloat)longitude
                       accuracy:(CGFloat)accuracyInMeters;

/**
 * Provide user location for city level targeting.
 * @param city User's city
 * @param state User's state
 * @param country User's country
 */
+ (void)setLocationWithCity:(NSString *)city
                      state:(NSString *)state
                    country:(NSString *)country;

#pragma mark User IDs

/**
 * Set user ids such as facebook, twitter etc to deliver more relevant ads.
 * @param userId User id type
 * @param idValue User id value
 */
+ (void)addUserID:(IMUserId)userId withValue:(NSString *)idValue;

/**
 * Remove the user ids which was set before. This fails silently if the id type
 * was not set before.
 * @param userId User id type to remove
 */
+ (void)removeUserID:(IMUserId)userId;

@end
