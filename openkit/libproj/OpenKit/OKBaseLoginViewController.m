//
//  OKBaseLoginViewController.m
//  OKClient
//
//  Created by Suneet Shah on 2/4/13.
//  Copyright (c) 2013 Suneet Shah. All rights reserved.
//

#import "OKBaseLoginViewController.h"

#import <FacebookSDK/FacebookSDK.h>
#import "OKManager.h"
#import "OKFacebookUtilities.h"
#import "KGModal.h"
#import "OKGameCenterUtilities.h"
#import "OKUser.h"

@interface OKBaseLoginViewController ()

@property (nonatomic, strong) UIButton *fbLoginButton;
@property (nonatomic, strong) UIButton *gcLoginButton;


@end

@implementation OKBaseLoginViewController

@synthesize  loginView,spinner, fbLoginButton, gcLoginButton, delegate, loginString;

-(id)initWithLoginString:(NSString*)aLoginString
{
    self = [super init];
    if(self)
    {
        [self setLoginString:aLoginString];
        [self initLoginView];
        [[NSNotificationCenter defaultCenter] addObserver:self selector:@selector(updateGameCenterButtonVisibility) name:OK_GAMECENTER_AUTH_NOTIFICATION object:nil];
    }
    return self;
}

- (void)loadView{
    self.view = [[UIView alloc] initWithFrame:[[UIScreen mainScreen] bounds]];
}

- (void)viewDidLoad{
    [super viewDidLoad];
    
    [self updateGameCenterButtonVisibility];
    [self updateFBButtonVisibility];
    
    self.view.backgroundColor = [UIColor clearColor];
    self.view.autoresizingMask = UIViewAutoresizingFlexibleWidth|UIViewAutoresizingFlexibleHeight;
}

-(void)showLoginModalView
{
    [self updateGameCenterButtonVisibility];
    [self updateFBButtonVisibility];
    KGModal *modal = [KGModal sharedInstance];
    [modal setTapOutsideToDismiss:NO];
    [modal setShowCloseButton:NO];
    [modal showWithContentView:loginView andAnimated:YES];
    [modal setDelegate:self];
}
-(void)dismissLoginView {
    [[NSNotificationCenter defaultCenter] removeObserver:self];
    [[KGModal sharedInstance] hide];
    [[KGModal sharedInstance] setDelegate:nil];
    [self setWindow:nil];
    [delegate dismiss];
}

-(void)dismissLoginViewWithoutBaseDismiss {
    [[KGModal sharedInstance] hide];
    [[KGModal sharedInstance] setDelegate:nil];
}

-(void)showLoginDialogSpinner
{
    [spinner startAnimating];
    [fbLoginButton setHidden:YES];
    //[twitterLoginButton setHidden:YES];
}
-(void)hideLoginDialogSpinner
{
    [spinner stopAnimating];
    [fbLoginButton setHidden:NO];
    //[twitterLoginButton setHidden:NO];
}


-(void)initLoginView
{
    loginView = [[UIView alloc] initWithFrame:CGRectMake(0, 0, 280, 260)];
  
    // Main Label
    CGRect mainLabelRect = loginView.bounds;
    mainLabelRect.origin.y = -10;
    mainLabelRect.size.height = 60;
    UIFont *mainLabelFont = [UIFont boldSystemFontOfSize:20];
    UILabel *mainLabel = [[UILabel alloc] initWithFrame:mainLabelRect];
    mainLabel.text = [self loginString];
    mainLabel.numberOfLines = 1;
    mainLabel.font = mainLabelFont;
    mainLabel.textColor = [UIColor blackColor];
    mainLabel.textAlignment = NSTextAlignmentCenter;
    mainLabel.backgroundColor = [UIColor clearColor];
    mainLabel.shadowColor = [UIColor clearColor];
    mainLabel.shadowOffset = CGSizeMake(0, 1);
    [loginView addSubview:mainLabel];
  
    // Sub Label
    CGRect subLabelRect = loginView.bounds;
    subLabelRect.origin.y = 35;
    subLabelRect.size.height = 40;
    UIFont *subLabelFont = [UIFont systemFontOfSize:14];
    UILabel *subLabel = [[UILabel alloc] initWithFrame:subLabelRect];
    NSString *subText = @"Leaderboards are more fun when you play against friends. Include friends from:";
    subLabel.text = subText;
    subLabel.numberOfLines = 2;
    subLabel.font = subLabelFont;
    subLabel.textColor = [UIColor grayColor];
    subLabel.textAlignment = NSTextAlignmentCenter;
    subLabel.backgroundColor = [UIColor clearColor];
    subLabel.shadowColor = [UIColor clearColor];
    subLabel.shadowOffset = CGSizeMake(0, 1);
    [loginView addSubview:subLabel];
  
    // Game Center Button
    CGRect gcButtonRect = CGRectMake(35,88,105,105);

    gcLoginButton = [UIButton buttonWithType:(UIButtonTypeCustom)];
    [gcLoginButton setFrame:gcButtonRect];
    [gcLoginButton addTarget:self action:@selector(gameCenterButtonPressed:) forControlEvents:UIControlEventTouchDown];
    UIImage * gcButtonImageOff = [UIImage imageNamed:@"gc_off_big.png"];
    UIImage * gcButtonImageOn = [UIImage imageNamed:@"gc_on_big.png"];
    [gcLoginButton setBackgroundImage:gcButtonImageOff forState:UIControlStateNormal];
    [gcLoginButton setBackgroundImage:gcButtonImageOn forState:UIControlStateDisabled];
    

    [self updateGameCenterButtonVisibility];
        
    // Facebook Button
    CGRect fbButtonRect = CGRectMake(140,88,105,105);
    fbLoginButton = [UIButton buttonWithType:(UIButtonTypeCustom)];
    fbLoginButton.frame = fbButtonRect;
    [fbLoginButton addTarget:self action:@selector(performFacebookLogin:) forControlEvents:UIControlEventTouchDown];
    UIImage * fbButtonImageOff = [UIImage imageNamed:@"fb_off_big.png"];
    UIImage * fbButtonImageOn = [UIImage imageNamed:@"fb_on_big.png"];
    [fbLoginButton setBackgroundImage:fbButtonImageOn forState:UIControlStateDisabled];
    [fbLoginButton setBackgroundImage:fbButtonImageOff forState:UIControlStateNormal];
    
  
    // Finished Button
    CGRect finishedButtonRect = CGRectMake(5,210,271,44);
    UIButton *finishedButton = [UIButton buttonWithType:(UIButtonTypeRoundedRect)];
    [finishedButton setFrame:finishedButtonRect];
    [finishedButton addTarget:self action:@selector(dismissLoginView) forControlEvents:UIControlEventTouchDown];
    [finishedButton setTitle:@"Finished" forState:UIControlStateNormal];
    
    // Spinner
    float spinnerSize = 44;
    float spinnerxPos = [loginView bounds].size.width /2 - spinnerSize/2;
    float spinneryPos = CGRectGetMidY(loginView.bounds);
    CGRect spinnerRect = CGRectMake(spinnerxPos, spinneryPos, spinnerSize, spinnerSize);
    spinner = [[UIActivityIndicatorView alloc] initWithActivityIndicatorStyle:UIActivityIndicatorViewStyleWhiteLarge];
    [spinner setFrame:spinnerRect];
    [spinner setColor:[UIColor darkGrayColor]];
    [spinner setHidesWhenStopped:YES];
    
    
    [loginView addSubview:finishedButton];
    [loginView addSubview:gcLoginButton];
    [loginView addSubview:fbLoginButton];
    [loginView addSubview:spinner];
    
}

-(void)updateGameCenterButtonVisibility {
    if([OKGameCenterUtilities isPlayerAuthenticatedWithGameCenter]) {
        [gcLoginButton setEnabled:NO];
    } else {
        [gcLoginButton setEnabled:YES];
    }
}

-(void)updateFBButtonVisibility {
    OKUser *currentUser = [OKUser currentUser];
    
    if(currentUser && [currentUser fbUserID] && [OKFacebookUtilities isFBSessionOpen]) {
        [fbLoginButton setEnabled:NO];
    } else {
        [fbLoginButton setEnabled:YES];
    }
}

-(IBAction)gameCenterButtonPressed:(id)sender
{
    if([OKGameCenterUtilities isGameCenterAvailable] && ![OKGameCenterUtilities isPlayerAuthenticatedWithGameCenter]) {
        
        [self dismissLoginViewWithoutBaseDismiss];
        
        [OKGameCenterUtilities authorizeUserWithGameCenterLegacyWithCompletionHandler:^(NSError *error) {
            
            if(error != nil) {
                [self dismissLoginView];
            } else {
                [self showLoginModalView];
            }
        }];
    }
}


- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation{
    return YES;
}


- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (IBAction)performFacebookLogin:(id)sender
{
    [self showLoginDialogSpinner];
    
    [OKFacebookUtilities AuthorizeUserWithFacebookWithCompletionHandler:^(OKUser *user, NSError *error) {
        [self hideLoginDialogSpinner];
        [self updateFBButtonVisibility];
        
        if(user && !error) {
            [self dismissLoginView];
        } else {
            //Did not login with Facebook, show an error if neecessary
            [OKFacebookUtilities handleErrorLoggingIntoFacebookAndShowAlertIfNecessary:error];
        }
    }];
}








@end
