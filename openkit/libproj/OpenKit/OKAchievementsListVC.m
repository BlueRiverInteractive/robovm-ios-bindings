//
//  OKAchievementsListVC.m
//  OpenKit
//
//  Created by Suneet Shah on 12/11/13.
//  Copyright (c) 2013 OpenKit. All rights reserved.
//

#import "OKAchievementsListVC.h"
#import "OKAchievement.h"
#import "OKAchievementCell.h"
#import "OKMacros.h"
#import "OKColors.h"

@interface OKAchievementsListVC ()
{
    UITableView *_tableView;
    UIActivityIndicatorView *spinner;
}

@end

@implementation OKAchievementsListVC

@synthesize achievementsList;

- (id)init
{
    self = [super init];
    if(self) {
        UIBarButtonItem *backButton = [[UIBarButtonItem alloc] initWithTitle:@"Back" style:UIBarButtonItemStylePlain target:self action:@selector(back)];
        
        [[self navigationItem] setLeftBarButtonItem:backButton];
        [[self navigationItem] setBackBarButtonItem:backButton];
    }
    return self;
}

- (void)viewDidLoad
{
    [super viewDidLoad];
	// Do any additional setup after loading the view.
    
    self.view.backgroundColor = [OKColors defaultBGColor];
    
    CGRect viewFrame = self.view.frame;
    float spinnerSize = 30.0;
    
    spinner = [[UIActivityIndicatorView alloc] initWithActivityIndicatorStyle:UIActivityIndicatorViewStyleGray];
    CGRect spinnerFrame = CGRectMake(viewFrame.size.width/2 - spinnerSize/2, viewFrame.size
                                     .height/2 - spinnerSize/2, 30, 30);
    [spinner setFrame:spinnerFrame];
    [spinner setHidesWhenStopped:YES];
    
    
    [[self navigationItem] setTitle:@"Achievements"];
    _tableView = [[UITableView alloc] initWithFrame:self.view.frame style:UITableViewStyleGrouped];
    [_tableView setDelegate:self];
    [_tableView setDataSource:self];
    _tableView.autoresizingMask = UIViewAutoresizingFlexibleWidth | UIViewAutoresizingFlexibleHeight;
    
    [self.view addSubview:_tableView];
    [self.view addSubview:spinner];
    
    [_tableView setBackgroundColor:[OKColors defaultBGColor]];
    [[self view] setBackgroundColor:[OKColors defaultBGColor]];
    
    
    [self getListOfAchievements];
}

-(void)getListOfAchievements
{
    [_tableView setHidden:YES];
    [spinner startAnimating];
    
    [OKAchievement getAchievementsWithCompletionHandler:^(NSArray *achievements, NSError *error) {
        [spinner stopAnimating];
        [_tableView setHidden:NO];
        
        if(!error) {
            [self setAchievementsList:achievements];
            OKLogInfo(@"Got achievements");
        } else {
            [self showErrorGettingAchievements];
        }
        
        [_tableView reloadData];
    }];
}

-(void)showErrorGettingAchievements
{
    UIAlertView *alert = [[UIAlertView alloc] initWithTitle:@"Error" message:@"Sorry, but there was an error getting achievements right now. Please try again later." delegate:nil cancelButtonTitle:@"OK" otherButtonTitles:nil];
    [alert show];
}

- (IBAction)back
{
    // Have to call dismiss on presentingViewController otherwise the presenting view controller won't get the dismissViewController message, and we need the presenting view controller to get this message in OKBridgeBaseViewController
    [[self presentingViewController] dismissViewControllerAnimated:YES completion:nil];
}

-(NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section
{
    return [achievementsList count];
}

//RootViewController.m
-(CGFloat)tableView:(UITableView *)tableView heightForRowAtIndexPath:(NSIndexPath *)indexPath
{
    return 57;
}

- (UITableViewCell*)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath
{
    int row = [indexPath row];
    static NSString *cellIdentifer = kOKAchievementCellIdentifier;
    
    OKAchievementCell *cell = (OKAchievementCell*)[tableView dequeueReusableCellWithIdentifier:cellIdentifer];
    if(!cell) {
        cell = [[OKAchievementCell alloc] init];
    }
    
    [cell setAchievement:[achievementsList objectAtIndex:row]];
    return cell;
}

- (NSString *)tableView:(UITableView *)tableView titleForHeaderInSection:(NSInteger)section
{
    return [NSString stringWithFormat:@"%d ACHIEVEMENTS",[achievementsList count]];
}

- (NSString *)tableView:(UITableView *)tableView titleForFooterInSection:(NSInteger)section
{
    return @"Powered by OpenKit";
}



- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

@end
