//
//  OKFBLoginCell.m
//  OpenKit
//
//  Created by Suneet Shah on 6/18/13.
//  Copyright (c) 2013 OpenKit. All rights reserved.
//

#import "OKFBLoginCell.h"
#import "OKFacebookUtilities.h"
#import <FacebookSDK/FacebookSDK.h>
#import <QuartzCore/QuartzCore.h>
#import "OKMacros.h"
#import "OKColors.h"
#import "OKGameCenterUtilities.h"
#import "OKUser.h"

@implementation OKFBLoginCell

@synthesize connectFBButton, textLabel, spinner, delegate, gameCenterButton;


-(id)initWithCoder:(NSCoder *)aDecoder {
    self = [super initWithCoder:aDecoder];
    
    if(self) {
        //Score cell is not selectable        
    }
    
    return self;
}

-(void)layoutSubviews
{
    [super layoutSubviews];
    [self updateButtonVisibility];
}

-(void)updateButtonVisibility
{
    if([OKGameCenterUtilities isPlayerAuthenticatedWithGameCenter]) {
        [gameCenterButton setEnabled:NO];
    } else {
        [gameCenterButton setEnabled:YES];
    }
    
    OKUser *currentUser = [OKUser currentUser];
    if(currentUser && [currentUser fbUserID] && [OKFacebookUtilities isFBSessionOpen]) {
        [connectFBButton setEnabled:NO];
    } else {
        [connectFBButton setEnabled:YES];
    }
}

-(void)makeCellInviteFriends
{
    [textLabel setText:@"Invite friends from"];
    [gameCenterButton setHidden:YES];
}

- (void)setSelected:(BOOL)selected animated:(BOOL)animated
{
    // Don't show the selection blue color
    [super setSelected:NO animated:NO];
    
    // If it was selected, trigger the Facebook login action
    if(selected) {
        [self connectButtonPressed:nil];
    }
}

-(void)startSpinner
{
    [spinner startAnimating];
    [connectFBButton setHidden:YES];
}

-(void)stopSpinner
{
    [spinner stopAnimating];
    [connectFBButton setHidden:NO];
}

-(IBAction)connectButtonPressed:(id)sender
{
    if(delegate) {
        [delegate fbLoginButtonPressed];
    }
}

-(IBAction)gcButtonPressed:(id)sender
{
    if([OKGameCenterUtilities isGameCenterAvailable] && ![OKGameCenterUtilities isPlayerAuthenticatedWithGameCenter]) {
        [OKGameCenterUtilities authenticateLocalPlayerWithCompletionHandler:^(NSError *error) {
            [self updateButtonVisibility];
        }];
    }
}




@end
