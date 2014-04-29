//
//  OKAchievementCell.m
//  OpenKit
//
//  Created by Suneet Shah on 12/11/13.
//  Copyright (c) 2013 OpenKit. All rights reserved.
//

#import "OKAchievementCell.h"
#import "AFImageView.h"
#import "OKColors.h"

@implementation OKAchievementCell
{
    AFImageView *imageView;
    UIProgressView *progressView;

}

@synthesize nameLabel, descriptionLabel, achievement, progressView;


- (void)setSelected:(BOOL)selected animated:(BOOL)animated
{
    [super setSelected:selected animated:animated];

    // Configure the view for the selected state
}

-(id)init
{
    static NSString *reuseID = kOKAchievementCellIdentifier;
    
    self = [super initWithStyle:UITableViewCellStyleDefault reuseIdentifier:reuseID];
    if (self) {
        
        CGRect cellFrame = CGRectMake(0, 0, 300, 57);
        CGRect achievementImageFrame = CGRectMake(17,10, 39, 39);
        CGRect nameLabelFrame = CGRectMake(70, 11, 170, 20);
        CGRect descriptionFrame = CGRectMake(70, 28, 170, 20);
        CGRect progressFrame = CGRectMake(250, 30, 50, 10);
        
        [self setFrame:cellFrame];
        
        nameLabel = [[UILabel alloc] initWithFrame:nameLabelFrame];
        nameLabel.lineBreakMode = UILineBreakModeTailTruncation;
        nameLabel.font = [UIFont boldSystemFontOfSize:15];
        nameLabel.backgroundColor = [UIColor clearColor];
        nameLabel.autoresizingMask = UIViewAutoresizingFlexibleWidth;
        [self.contentView addSubview:nameLabel];
        
        descriptionLabel = [[UILabel alloc] initWithFrame:descriptionFrame];
        descriptionLabel.font = [UIFont systemFontOfSize:12];
        descriptionLabel.textColor = UIColorFromRGB(0x828282);
        descriptionLabel.backgroundColor = [UIColor clearColor];
        descriptionLabel.autoresizingMask = UIViewAutoresizingFlexibleWidth;

        [self.contentView addSubview:descriptionLabel];
        
        imageView = [[AFImageView alloc] initWithFrame:achievementImageFrame];
        imageView.layer.masksToBounds = YES;
        imageView.layer.cornerRadius = 3;
        [self.contentView addSubview:imageView];
        
        progressView = [[UIProgressView alloc] initWithFrame:progressFrame];
        progressView.autoresizingMask = UIViewAutoresizingFlexibleLeftMargin;
        [self.contentView addSubview:progressView];
        
        self.selectionStyle = UITableViewCellSelectionStyleNone;
    }
    
    return self;
}

-(void)setAchievement:(OKAchievement *)aAchievement
{
    achievement = aAchievement;
    
    nameLabel.text = achievement.name;
    descriptionLabel.text = achievement.description;
    
    NSURL *imageURL;
    
    if([achievement unlocked]) {
        imageURL = [NSURL URLWithString:achievement.unlockedIconURL];
    } else {
        imageURL = [NSURL URLWithString:achievement.lockedIconURL];
    }
    
    [imageView setImageWithURL:imageURL];
    [progressView setProgress:achievement.progress/achievement.goal];
}
@end
