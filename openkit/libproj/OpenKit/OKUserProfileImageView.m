//
//  OKUserProfileImageView.m
//  OKClient
//
//  Created by Suneet Shah on 1/8/13.
//  Copyright (c) 2013 OpenKit. All rights reserved.
//

#import "OKUserProfileImageView.h"
#import "AFImageView.h"
#import "OKGameCenterUtilities.h"
#import "OKScore.h"
#import "OKGKScoreWrapper.h"
#import "OKMacros.h"

@interface OKUserProfileImageView ()

@property (nonatomic, strong) FBProfilePictureView *fbProfileImageView;
@property (nonatomic, strong) AFImageView *imageView;


@end


@implementation OKUserProfileImageView

+(UIImage*)placeHolderImage{
    return [UIImage imageNamed:@"user_icon.png"];
}

#pragma mark - Init
- (id)init
{
    if ((self = [super init])) {
        [self initialize];
    }
    return self;
}

- (id)initWithFrame:(CGRect)frame
{
    if ((self = [super initWithFrame:frame])) {
        [self initialize];
    }
    return self;
}

- (id)initWithCoder:(NSCoder *)aDecoder
{
    if ((self = [super initWithCoder:aDecoder])) {
        [self initialize];
    }
    return self;
}

- (void)initialize
{
    if(self.imageView)
        return;
    
    self.imageView = [[AFImageView alloc] initWithFrame:self.bounds];
    self.autoresizesSubviews = YES;
    self.clipsToBounds = YES;
    self.fbProfileImageView = [[FBProfilePictureView alloc] initWithFrame:self.bounds];
    
    [self addSubview:self.imageView];
    [self addSubview:self.fbProfileImageView];
}

#pragma mark - Overridden Setters
- (void)setFrame:(CGRect)frame
{
    [super setFrame:frame];
    [self.fbProfileImageView setFrame:frame];
    [self.imageView setFrame:frame];
}

-(void)setOKScoreProtocolScore:(id<OKScoreProtocol>)aScore
{
    if([aScore isKindOfClass:[OKScore class]]) {
        OKScore *okscore = (OKScore*)aScore;
        [self setUser:[okscore user]];
    } else if ([aScore isKindOfClass:[OKGKScoreWrapper class]]) {
        OKGKScoreWrapper *wrapper = (OKGKScoreWrapper*)aScore;
        [self setGKPlayer:[wrapper player]];
    } else {
        [self setUser:nil];
        OKLog(@"Unknown object type for OKScoreProtocol");
    }
}

#pragma mark - Custom Setters
- (void)setUser:(OKUser *)aUser
{
    // Use the built in FB placeholder for nil user.
    //Clear out the FbProfileImageView
    [self.fbProfileImageView setProfileID:nil];
    
    if(!aUser) {
        [self.fbProfileImageView setHidden:YES];
        [self.imageView setHidden:NO];
        [self.imageView setImage:[OKUserProfileImageView placeHolderImage]];
    }
    else if([aUser fbUserID] != nil) {
        [self.fbProfileImageView setHidden:NO];
        [self.imageView setHidden:YES];
        [self.fbProfileImageView setProfileID:aUser.fbUserID];
    }
    //else if ([aUser gameCenterID]) {
    //    [self loadGameCenterImageForGameCenterID:[aUser gameCenterID]];
    //}
    else {
        [self.fbProfileImageView setProfileID:nil];
    }
    _user = aUser;
}

-(void)setGKPlayer:(GKPlayer*)player {
    [self loadGameCenterImageForGameCenterID:[player playerID]];
}

-(void)loadGameCenterImageForGameCenterID:(NSString *)gameCenterID {
    [self.fbProfileImageView setHidden:YES];
    [self.imageView setHidden:NO];
    [self.imageView setImage:[OKUserProfileImageView placeHolderImage]];

    
    [OKGameCenterUtilities loadPlayerPhotoForGameCenterID:gameCenterID withPhotoSize:GKPhotoSizeSmall withCompletionHandler:^(UIImage *photo, NSError *error) {
        
        if(photo != nil) {
            [self.imageView setImage:photo];
        }
    }];
}




- (void)setImage:(UIImage *)aImage
{
    [self.fbProfileImageView setHidden:YES];
    [self.imageView setImage:aImage];
    [self.imageView setHidden:NO];
    _image = aImage;
}

#pragma mark - Actions
- (void)setImageURL:(NSString *)url
{
    [self.fbProfileImageView setHidden:YES];
    [self.imageView setHidden:NO];
    [self.imageView setImageWithURL:[NSURL URLWithString:url]];
}

- (void)setImageURL:(NSString *)url withPlaceholderImage:(UIImage *)placeholder
{
    [self setImage:placeholder];
    [self.imageView setImageWithURL:[NSURL URLWithString:url] placeholderImage:placeholder];
}


@end
