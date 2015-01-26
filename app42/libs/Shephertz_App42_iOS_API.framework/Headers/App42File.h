//
//  App42File.h
//  PAE_iOS_SDK
//
//  Created by Rajeev Ranjan on 10/02/14.
//  Copyright (c) 2014 ShephertzTechnology PVT LTD. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface App42File : NSObject

@property(nonatomic,retain) NSString *name;
@property(nonatomic,retain) NSString *fileId;
@property(nonatomic,retain) NSString *url;
@property(nonatomic,retain) NSString *type;
@property(nonatomic,retain) NSData *fileData;
@property(nonatomic,retain) NSString *fileType;

-(id)initWithFileData:(NSData*)_fileData fileName:(NSString*)_fileName andType:(NSString*)_fileType;

@end
