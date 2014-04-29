//
//  OKLeaderboardListCell.m
//  OKClient
//
//  Created by Suneet Shah on 1/11/13.
//  Copyright (c) 2013 OpenKit. All rights reserved.
//

#import "OKLeaderboardListCell.h"
#import <QuartzCore/QuartzCore.h>
#import "AFImageView.h"


@interface OKLeaderboardListCell ()
{
    AFImageView *leaderboardIcon;
}
@end


@implementation OKLeaderboardListCell
@synthesize label1, label2, leaderboard;

- (id)init
{
    static NSString *reuseID = kOKLeaderboardListCellIdentifier;
    
    self = [super initWithStyle:UITableViewCellStyleDefault reuseIdentifier:reuseID];
    if (self) {
        CGRect CellFrame = CGRectMake(0, 0, 300, 60);
        CGRect LeaderbordLabel = CGRectMake(68, 0, 300, 60);
        
        self.accessoryType = UITableViewCellAccessoryDisclosureIndicator;
        
        //Initialize Label with tag 1.
        label1 = [[UILabel alloc] initWithFrame:LeaderbordLabel];
        label1.tag = 1;
        label1.font = [UIFont boldSystemFontOfSize:15];
        label1.backgroundColor = [UIColor clearColor];
        [self.contentView addSubview:label1];
      
        // Initialize leaderboard icon
        leaderboardIcon = [[AFImageView alloc] initWithFrame:CGRectMake(15,10, 39, 39)];
        leaderboardIcon.layer.masksToBounds = YES;
        leaderboardIcon.layer.cornerRadius = 3;
        [self.contentView addSubview:leaderboardIcon];
        
        [self setFrame:CellFrame];
    }
    return self;
}

- (void)setLeaderboard:(OKLeaderboard *)aLeaderboard
{
    leaderboard = aLeaderboard;
    
    label1.text = [leaderboard name];
    //label2.text = [leaderboard playerCountString];
    
    [leaderboardIcon setImageWithURL:[NSURL URLWithString:[leaderboard icon_url]]];
}

@end

