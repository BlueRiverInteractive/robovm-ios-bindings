//
//  OKSocialLeaderboardViewController.m
//  OpenKit
//
//  Created by Suneet Shah on 6/13/13.
//  Copyright (c) 2013 OpenKit. All rights reserved.
//

#import "OKSocialLeaderboardViewController.h"
#import "OKScoreCell.h"
#import "OKGKScoreWrapper.h"
#import "OKMacros.h"
#import "OKGameCenterUtilities.h"
#import "OKFacebookUtilities.h"
#import "OKFBLoginCell.h"
#import "OKSpinnerCell.h"
#import "OKColors.h"
#import "OKLoginView.h"
#import "OKManager.h"

#define kOKScoreCellIdentifier @"OKScoreCell"

@interface OKSocialLeaderboardViewController ()

- (void)showActionSheet:(id)sender; //Declare method to show action sheet
- (void)showEmailUI; //Declare method to show action sheet
- (void)showMessageUI; //Declare method to show action sheet

@end

@implementation OKSocialLeaderboardViewController
{
    int numberOfSocialRequestsRunning;
    BOOL isShowingFBLoginCell;
    BOOL isShowingInviteFriendsCell;
}


@synthesize leaderboard, _tableView, spinner, socialScores, globalScores, containerViewForLoadMoreButton, loadMoreScoresButton, playerTopScore, mail, leaderboardID;
@synthesize gcSocialScores, fbSocialScores, playerTopScoreSocialSection;

static NSString *scoreCellIdentifier = kOKScoreCellIdentifier;
static NSString *fbCellIdentifier = @"OKFBLoginCell";
static NSString *spinnerCellIdentifier = @"OKSpinnerCell";
static NSString *inviteCellIdentifier = @"OKInviteCell";

- (id)initWithLeaderboard:(OKLeaderboard *)aLeaderboard {
    return [self initWithLeaderboard:aLeaderboard withLeaderboardID:0];
}

-(id)initWithLeaderboardID:(int)aLeaderboardID {
    return [self initWithLeaderboard:nil withLeaderboardID:aLeaderboardID];
}

-(id)initWithLeaderboard:(OKLeaderboard *)aLeaderboard withLeaderboardID:(int)aLeaderboardID
{
    self = [super initWithNibName:@"OKSocialLeaderboardVC" bundle:nil];
    if (self) {
        leaderboard = aLeaderboard;
        leaderboardID = aLeaderboardID;
        socialScores = [[NSMutableArray alloc] init];
        numberOfSocialRequestsRunning = 0;
        isShowingFBLoginCell = NO;
      
        //[_tableView setSeparatorColor:UIColorFromRGB(0xcacaca)];
        
        //Initialize the invite button
        //UIBarButtonItem *inviteButton = [[UIBarButtonItem alloc] initWithImage:[UIImage imageNamed:@"invite.png"] style:UIBarButtonItemStyleBordered target:self action:@selector(showFacebookInviteUI)];
        //UIBarButtonItem *inviteButton = [[UIBarButtonItem alloc] initWithImage:[UIImage imageNamed:@"invite.png"] style:UIBarButtonItemStylePlain target:self action:@selector(showActionSheet:)];
        //[inviteButton setTintColor:[UIColor colorWithRed:5/255.0 green:139/255.0 blue:245/255.0 alpha:1]];
      
        UIBarButtonItem *inviteButton = [[UIBarButtonItem alloc] initWithTitle:@"Invite" style:UIBarButtonItemStyleDone target:self action:@selector(showFacebookInviteUI)];
        [[self navigationItem] setRightBarButtonItem:inviteButton];
    }
    return self;
}

- (void)showActionSheet:(id)sender
{
    NSString *actionSheetTitle = @"Invite a Friend"; //Action Sheet Title
    NSString *email = @"Email";
    NSString *message = @"Message";
    NSString *facebook = @"Facebook";
    NSString *cancelTitle = @"Cancel";
    UIActionSheet *actionSheet = [[UIActionSheet alloc]
                                  initWithTitle:actionSheetTitle
                                  delegate:self
                                  cancelButtonTitle:cancelTitle
                                  destructiveButtonTitle:nil
                                  otherButtonTitles:email, message, facebook, nil];
    [actionSheet showInView:self.view];
}

- (void)actionSheet:(UIActionSheet *)actionSheet clickedButtonAtIndex:(NSInteger)buttonIndex
{
    //Get the name of the current pressed button
    NSString *buttonTitle = [actionSheet buttonTitleAtIndex:buttonIndex];
    if ([buttonTitle isEqualToString:@"Email"]) {
        [self showEmailUI];
    }
    if ([buttonTitle isEqualToString:@"Message"]) {
        [self showMessageUI];
    }
    if ([buttonTitle isEqualToString:@"Facebook"]) {
        [self showFacebookInviteUI];
    }
    if ([buttonTitle isEqualToString:@"Cancel Button"]) {
        NSLog(@"Cancel pressed --> Cancel ActionSheet");
    }
}

-(void)showFacebookInviteUI
{
    if([[FBSession activeSession] isOpen]) {
        [OKFacebookUtilities sendFacebookRequest];
    } else {
        [self fbLoginWithCompletionHandler:^{
            [OKFacebookUtilities sendFacebookRequest];
        }];
    }
}

-(void)showEmailUI
{
    
    //Set up
    mail = [[MFMailComposeViewController alloc]init];
    
    mail.mailComposeDelegate = self;
    
    //Set the subject
    [mail setSubject:@"Check out this game"];
    
    //Set the message
    NSString * sentFrom = @"<p>Check out this game:</p>";
    [mail setMessageBody:sentFrom isHTML:YES];
    
    [self presentViewController:mail animated:YES completion:nil];
    
}

- (void) mailComposeController:(MFMailComposeViewController *)controller didFinishWithResult:(MFMailComposeResult)result error:(NSError *)error
{
    switch (result)
    {
        case MFMailComposeResultCancelled:
            NSLog(@"Mail cancelled");
            break;
        case MFMailComposeResultSaved:
            NSLog(@"Mail saved");
            break;
        case MFMailComposeResultSent:
            NSLog(@"Mail sent");
            break;
        case MFMailComposeResultFailed:
            NSLog(@"Mail sent failure: %@", [error localizedDescription]);
            break;
        default:
            break;
    }
    
    // Close the Mail Interface
    [self dismissViewControllerAnimated:YES completion:NULL];
}

-(void) showMessageUI
{
	MFMessageComposeViewController *controller = [[MFMessageComposeViewController alloc] init];
	if([MFMessageComposeViewController canSendText])
	{
		controller.body = @"";
		//controller.recipients = [NSArray arrayWithObjects:@"12345678", @"87654321", nil];
		controller.messageComposeDelegate = self;
		[self presentModalViewController:controller animated:YES];
	}
}

- (void) messageComposeViewController:(MFMessageComposeViewController *)
controller didFinishWithResult:(MessageComposeResult)result
{
    
    UIAlertView *alert = [[UIAlertView alloc] initWithTitle:@"MyApp" message:@"Unknown Error"
                          
                                                   delegate:self cancelButtonTitle:@"OK" otherButtonTitles: nil];
    
    switch (result) {
            
        case MessageComposeResultCancelled:
            NSLog(@"Cancelled");
            break;
            
        case MessageComposeResultFailed:
            [alert show];
            break;
            
        case MessageComposeResultSent:
            break;
            
        default:
            break;
    }
    
    [self dismissModalViewControllerAnimated:YES];
    
}


// Used to keep track of tableView sections
enum Sections {
    kSocialLeaderboardSection = 0,
    kGlobalSection,
    NUM_SECTIONS
};

typedef enum {
    SocialSectionRowSocialScoreRow = 0,
    SocialSectionRowProgressBarRow,
    SocialSectionRowFBLoginRow,
    SocialSectionRowInviteFriends,
    SocialSectionRowUnknownRow
} SocialSectionRow;

-(BOOL)isShowingSocialScoresProgressBar {
    return (numberOfSocialRequestsRunning > 0);
}

-(NSString*)tableView:(UITableView *)tableView titleForHeaderInSection:(NSInteger)section
{
    switch(section) {
        case kSocialLeaderboardSection:
            return @"Friends";
        case kGlobalSection:
            return @"All Players";
        default:
            return @"";
    }
}

//-(CGFloat)tableView:(UITableView *)tableView heightForFooterInSection:(NSInteger)section
//{
//    return 18;
//}


-(NSInteger)numberOfSectionsInTableView:(UITableView *)tableView
{
    return NUM_SECTIONS;
}

- (CGFloat)tableView:(UITableView *)tableView heightForRowAtIndexPath:(NSIndexPath *)indexPath
{
    SocialSectionRow rowType = [self getTypeOfRow:indexPath];
    switch(rowType) {
            
        case SocialSectionRowFBLoginRow:
            return 60;
            break;
        case SocialSectionRowProgressBarRow:
            return 60;
            break;
        case SocialSectionRowInviteFriends:
            return 60;
            break;
        case SocialSectionRowSocialScoreRow:
            return 60;
            break;
        case SocialSectionRowUnknownRow:
            // Return empty cell to avoid crash
            return 60;
    }
    
}

// This method captures a lot of the logic for what type of cell is drawn at what index path so it can be reused in
// both cellForRowAtIndexPath and heightForRow
-(SocialSectionRow)getTypeOfRow:(NSIndexPath*)indexPath {
    
    int section = [indexPath section];
    int row = [indexPath row];
    
    if(section != (int)kSocialLeaderboardSection)
        return SocialSectionRowUnknownRow;
    
    if(row < [socialScores count])
        return SocialSectionRowSocialScoreRow;
    
    if(row == [socialScores count] && [self isShowingSocialScoresProgressBar])
        return SocialSectionRowProgressBarRow;
    
    if(row >= [socialScores count] && isShowingFBLoginCell)
        return SocialSectionRowFBLoginRow;
    
    if([socialScores count] == 0 && isShowingInviteFriendsCell && !isShowingFBLoginCell)
        return SocialSectionRowInviteFriends;
    
    return SocialSectionRowUnknownRow;
}

-(int)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section
{
    int numRowsInSocial = 0;
    
    switch(section) {
        case kSocialLeaderboardSection:
            // If we are not logged into FB then we need an extra row to show the login button
            if(![OKFacebookUtilities isFBSessionOpen]) {
                numRowsInSocial++;
                isShowingFBLoginCell = YES;
            } else {
            }
            
            if([self isShowingSocialScoresProgressBar]) {
                numRowsInSocial++;
            }
            
            if(isShowingInviteFriendsCell && !isShowingFBLoginCell && [socialScores count] == 0)
                numRowsInSocial++;
            
            numRowsInSocial += [socialScores count];
            return numRowsInSocial;
        case kGlobalSection:
            if(globalScores) {
                if([self shouldShowPlayerTopScore]) {
                    return [globalScores count] + 1;
                } else {
                    return [globalScores count];
                }
            } else {
                return 0;
            }
        default:
            OKLog(@"Unknown section requested for rows");
            return 0;
    }
}



-(UITableViewCell*)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath
{
    int section = [indexPath section];
    int row = [indexPath row];
    
    if(section == kGlobalSection) {
        if(row >= [globalScores count]) {
            return [self getScoreCellForPlayerTopScore:playerTopScore withTableView:tableView];
        } else {
            return [self getScoreCellForScore:[globalScores objectAtIndex:row] withTableView:tableView andShowSocialNetworkIcon:NO];
        }
    }
    else if(section == kSocialLeaderboardSection) {
        
        SocialSectionRow rowType = [self getTypeOfRow:indexPath];
        switch(rowType) {
            case SocialSectionRowFBLoginRow:
                return [self getFBLoginCell];
                break;
            case SocialSectionRowProgressBarRow:
                return [self getProgressBarCell];
                break;
            case SocialSectionRowSocialScoreRow:
                return [self getScoreCellForScore:[socialScores objectAtIndex:row] withTableView:tableView andShowSocialNetworkIcon:YES];
                break;
            case SocialSectionRowInviteFriends:
                return [self getInviteFriendsCell];
                break;
            case SocialSectionRowUnknownRow:
                OKLog(@"Unknown row type returned in social scores!");
                // Return empty cell to avoid crash
                return [self getScoreCellForScore:nil withTableView:tableView andShowSocialNetworkIcon:NO];
        }
    } else {
        OKLog(@"Uknown section type in leaderboard");
        // Return empty cell to avoid crash
        return [self getScoreCellForScore:nil withTableView:tableView andShowSocialNetworkIcon:NO];;
    }
}

-(UITableViewCell*)getFBLoginCell {
    OKFBLoginCell *cell =  [_tableView dequeueReusableCellWithIdentifier:fbCellIdentifier];
    if(!cell) {
        cell = [[OKFBLoginCell alloc] initWithStyle:UITableViewCellStyleDefault reuseIdentifier:fbCellIdentifier];
    }
    [cell setDelegate:self];
    return cell;
}

-(UITableViewCell*)getInviteFriendsCell {
    OKFBLoginCell *cell =  [_tableView dequeueReusableCellWithIdentifier:inviteCellIdentifier];
    if(!cell) {
        cell = [[OKFBLoginCell alloc] initWithStyle:UITableViewCellStyleDefault reuseIdentifier:inviteCellIdentifier];
    }
    [cell setDelegate:self];
    [cell makeCellInviteFriends];
    return cell;
}

-(UITableViewCell*)getProgressBarCell
{
    OKSpinnerCell *cell = [_tableView dequeueReusableCellWithIdentifier:spinnerCellIdentifier];
    if(!cell) {
        cell = [[OKSpinnerCell alloc] initWithStyle:UITableViewCellStyleDefault reuseIdentifier:spinnerCellIdentifier];
    }
    
    //[cell setBackgroundColor:[OKColors scoreCellBGColor]];
    [cell startAnimating];
    [cell setSelectionStyle:UITableViewCellSelectionStyleNone];
    return cell;
}

-(UITableViewCell*)getScoreCellForPlayerTopScore:(id<OKScoreProtocol>)score withTableView:(UITableView*)tableView
{
    OKScoreCell *cell = [self getScoreCellForScore:score withTableView:_tableView andShowSocialNetworkIcon:NO];
    //[cell setBackgroundColor:[OKColors playerTopScoreBGColor]];
    
    return cell;
}

-(OKScoreCell*)getScoreCellForScore:(id<OKScoreProtocol>)score withTableView:(UITableView*)tableView andShowSocialNetworkIcon:(BOOL)showSocialNetworkIcon
{
    OKScoreCell *cell = [tableView dequeueReusableCellWithIdentifier:scoreCellIdentifier];
    if(!cell) {
        cell = [[OKScoreCell alloc] init];
    }
    
    //[cell setBackgroundColor:[OKColors scoreCellBGColor]];
    
    [cell setShowSocialNetworkIcon:showSocialNetworkIcon];
    [cell setOKScoreProtocolScore:score];
    [cell setSelectionStyle:UITableViewCellSelectionStyleNone];
    return cell;
}

-(void)errorLoadingGlobalScores
{
    UIAlertView *alert = [[UIAlertView alloc] initWithTitle:@"Error" message:@"Sorry, there was an error loading the leaderboard. Please try again later." delegate:nil cancelButtonTitle:@"OK" otherButtonTitles: nil];
    [alert show];
}


- (void)viewDidLoad
{
    [super viewDidLoad];
    
    //Register the nib file for OKFBLoginCell
    [self._tableView registerNib:[UINib nibWithNibName:@"OKFBLoginCell"
                                                bundle:[NSBundle mainBundle]]
          forCellReuseIdentifier:fbCellIdentifier];
    
    //Register the nib file for InviteCEll
    [self._tableView registerNib:[UINib nibWithNibName:@"OKFBLoginCell"
                                                bundle:[NSBundle mainBundle]]
          forCellReuseIdentifier:inviteCellIdentifier];
    
    // iPad specific adjustments
    if (UI_USER_INTERFACE_IDIOM() == UIUserInterfaceIdiomPad) {
        [loadMoreScoresButton setFrame:CGRectMake(30, 0, 508, 44)];
    }else {
        // iPhone
    }
    
    // If leaderboard is already loaded, display it, else get it then show it
    if([self leaderboard]) {
        [self getScores];
        [self setTitle:[leaderboard name]];
    } else {
        [self getLeaderboardThenGetScores];
    }
    
    [self showLoginPromptIfNecessary];
}

-(void)showLoginPromptIfNecessary {
    
    if(![OKUser currentUser] && ![[OKManager sharedManager] hasShownFBLoginPrompt]) {
        OKLoginView *loginView = [[OKLoginView alloc] init];
        [loginView showWithCompletionHandler:^{
            [self getSocialScores];
        }];
        [[OKManager sharedManager] setHasShownFBLoginPrompt:YES];
    }
}

-(void)getLeaderboardThenGetScores
{
    [spinner startAnimating];
    [_tableView setHidden:YES];
    
    [OKLeaderboard getLeaderboardWithID:self.leaderboardID withCompletionHandler:^(OKLeaderboard *aLeaderboard, NSError *error) {
        if(aLeaderboard && !error) {
            [self setLeaderboard:aLeaderboard];
            [self setTitle:[aLeaderboard name]];
            [self getScores];
        } else {
            [spinner stopAnimating];
            [self errorLoadingGlobalScores];
        }
    }];
}

-(void)getScores
{
    [spinner startAnimating];
    [_tableView setHidden:YES];
    
    // Get global scores-- OKLeaderboard decides where to get them from
    [leaderboard getGlobalScoresWithPageNum:1 withCompletionHandler:^(NSArray *scores, NSError *error) {
        [spinner stopAnimating];
        [_tableView setHidden:NO];
        
        if(!error && scores) {
            globalScores = [NSMutableArray arrayWithArray:scores];
            [_tableView reloadData];
        } else if(error) {
            OKLog(@"Error getting global scores: %@", error);
            [self errorLoadingGlobalScores];
        }
    }];
    
    [self getSocialScores];
    
    // Get social scores / top score
    
    [self getPlayerTopScoreForGlobalSection];
}

-(BOOL)shouldShowPlayerTopScore
{
    if(playerTopScore != nil) {
        if([playerTopScore rank] <= [globalScores count]) {
            return NO;
        } else {
            return YES;
        }
    } else {
        return NO;
    }
}

// Get the player's top score to show in the "all scores" section
-(void)getPlayerTopScoreForGlobalSection
{
    [leaderboard getPlayerTopScoreWithCompletionHandler:^(id<OKScoreProtocol> score, NSError *error) {
        if(score && !error) {
            [self setPlayerTopScore:score];
            [_tableView reloadSections:[NSIndexSet indexSetWithIndex:kGlobalSection] withRowAnimation:UITableViewRowAnimationAutomatic];
        }
    }];
}

-(void)getMoreGlobalScores
{
    // If there are no scores already for this leaderboard, getting "More" doesn't make sense
    if(globalScores == nil)
        return;
    
    int numScores = [globalScores count];
    int currentPageNumber = numScores / NUM_SCORES_PER_PAGE;
    
    if(currentPageNumber*NUM_SCORES_PER_PAGE < numScores) {
        currentPageNumber++;
    }
    
    int nextPageNumber = currentPageNumber + 1;
    
    [loadMoreScoresButton setEnabled:NO];
    
    [leaderboard getGlobalScoresWithPageNum:nextPageNumber withCompletionHandler:^(NSArray *scores, NSError *error) {
        
        if(scores != nil) {
            [globalScores addObjectsFromArray:scores];
            [_tableView reloadSections:[NSIndexSet indexSetWithIndex:kGlobalSection] withRowAnimation:UITableViewRowAnimationAutomatic];
        }
        
        [loadMoreScoresButton setEnabled:YES];
    }];
}

-(IBAction)loadMoreScoresPressed:(id)sender {
    [self getMoreGlobalScores];
}

-(void)fbLoginButtonPressed {
    [self fbLoginWithCompletionHandler:nil];
}


-(void)fbLoginWithCompletionHandler:(void(^)())completionHandler
{
    if(!isShowingFBLoginCell && isShowingInviteFriendsCell)
    {
        [self showFacebookInviteUI];
        return;
    }
    
    if([FBSession activeSession].state == FBSessionStateOpen) {
        OKLog(@"Fb session already open");
        [self getFacebookSocialScores];
        [OKFacebookUtilities createOrUpdateCurrentOKUserWithFB];
        isShowingFBLoginCell = NO;
        [self reloadSocialScores];
        
        if(completionHandler)
            completionHandler();
    } else {
        
        isShowingFBLoginCell = NO;
        [self reloadSocialScores];
        
        [OKFacebookUtilities OpenFBSessionWithCompletionHandler:^(NSError *error) {
            if ([FBSession activeSession].state == FBSessionStateOpen) {
                [self getFacebookSocialScores];
                [OKFacebookUtilities createOrUpdateCurrentOKUserWithFB];
                if(completionHandler)
                    completionHandler();
            } else {
                [OKFacebookUtilities handleErrorLoggingIntoFacebookAndShowAlertIfNecessary:error];
                isShowingFBLoginCell = YES;
            }
            [self reloadSocialScores];
        }];
    }
}


-(void)reloadSocialScores
{
    [_tableView reloadSections:[NSIndexSet indexSetWithIndex:0] withRowAnimation:UITableViewRowAnimationAutomatic];
}



//Get Social scores
-(void)getSocialScores {
    
    // If game center
    //   get GC friends scores (including users' top score)
    // else if OKUser
    //   get top score from OpenKit (this will return local cached score if not logged in)
    
    // if FB
    //   get FB scores from OpenKit
    
    if([leaderboard gamecenter_id] && [OKGameCenterUtilities isPlayerAuthenticatedWithGameCenter])
    {
        [self getGameCenterSocialScores];
    } else if ([OKUser currentUser]) {
        [self getUsersTopScoreFromOpenKit];
    }
    
    if([OKFacebookUtilities isFBSessionOpen]) {
        [self getFacebookSocialScores];
    }
}


-(void)getGameCenterSocialScores {
    
    // If we already got the GC social scores, don't get them again
    if(gcSocialScores != nil) {
        return;
    }
    
    // Increment the counter that keeps track of requests running for social leaderboards
    [self startedSocialScoreRequest];
    
    [leaderboard getGameCenterFriendsScoreswithCompletionHandler:^(NSArray *scores, NSError *error) {
        // Decrement the counter that keeps track of requests running for social leaderboards
        [self finishedSocialScoreRequest];
        if(error) {
            OKLog(@"error getting gamecenter friends scores, %@", error);
        }
        else if(!error && scores) {
            OKLog(@"Got gamecenter friends scores");
            gcSocialScores = scores;
            [self addSocialScores:scores];
        } else if ([scores count] == 0) {
            OKLog(@"Zero gamecenter friends scores returned");
        } else {
            OKLog(@"Unknown gamecenter friends scores error");
        }
    }];
}

-(void)getUsersTopScoreFromOpenKit
{
    // Only get the player's top score for the social section ones
    if(playerTopScoreSocialSection != nil) {
        return;
    }
    
    // Increment the counter that keeps track of requests running for social leaderboards
    [self startedSocialScoreRequest];
    
    [leaderboard getPlayerTopScoreWithCompletionHandler:^(OKScore *score, NSError *error) {
        
        // Decrement the counter that keeps track of requests running for social leaderboards
        [self finishedSocialScoreRequest];
        
        if(!error && score) {
            playerTopScoreSocialSection = score;
            [self addSocialScores:[NSArray arrayWithObject:score]];
        }
    }];
    
}

-(void)getFacebookSocialScores
{
    // Only fetch the fbSocialScores once
    if(fbSocialScores != nil) {
        return;
    }
    
    //Get facebook social scores
    [self startedSocialScoreRequest];
    
    [leaderboard getFacebookFriendsScoresWithCompletionHandler:^(NSArray *scores, NSError *error) {
        fbSocialScores = scores;
        [self addSocialScores:scores];
        isShowingFBLoginCell = NO;
        [self finishedSocialScoreRequest];
    }];
}

-(void)startedSocialScoreRequest
{
    numberOfSocialRequestsRunning++;
    [self reloadSocialScores];
    
}
-(void)finishedSocialScoreRequest
{
    numberOfSocialRequestsRunning--;
    
    if(numberOfSocialRequestsRunning <0)
        numberOfSocialRequestsRunning = 0;
    
    
    // If there are no social scores, and all social score requests are finished, then show
    // an invite friends
    if(numberOfSocialRequestsRunning == 0 && [socialScores count] == 0) {
        isShowingInviteFriendsCell = YES;
    } else {
        isShowingInviteFriendsCell = NO;
    }
    
    [self reloadSocialScores];
}

-(NSMutableArray*)sortSocialScores:(NSArray*)scores
{
    NSArray *sortedScores = [leaderboard sortScoresBasedOnLeaderboardType:scores];
    NSMutableArray *mutableScores = [[NSMutableArray alloc] initWithArray:sortedScores];
    // Set the relative ranks
    for(int x = 0; x< [mutableScores count]; x++)
    {
        id<OKScoreProtocol> score = [mutableScores objectAtIndex:x];
        [score setRank:(x+1)];
    }
    return mutableScores;
}


-(void)addSocialScores:(NSArray *)scores
{
    if(scores) {
        [[self socialScores] addObjectsFromArray:scores];
        NSMutableArray *sortedScores = [self sortSocialScores:socialScores];
        [self setSocialScores:sortedScores];
        [_tableView reloadData];
    }
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

@end
