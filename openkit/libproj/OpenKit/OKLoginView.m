//
//  OKLoginView.m
//  OKClient
//
//  Created by Suneet Shah on 2/4/13.
//  Copyright (c) 2013 Suneet Shah. All rights reserved.
//

#import "OKLoginView.h"
#import "KGModal.h"
#import "OKBaseLoginViewController.h"
#import "OKMacros.h"

@interface OKLoginView()<OKLoginViewDelegate>
{
    OKLoginViewCompletionHandler loginDialogCompletionHandler;
}

@property (nonatomic, strong) UIView *loginView;
@property (nonatomic, strong) OKBaseLoginViewController *baseViewController;
@property (nonatomic, strong) UIWindow *previousWindow;

@end

@implementation OKLoginView
{
    BOOL _didCapturePreviousWindow;
}

@synthesize loginView, baseViewController;
@synthesize previousWindow;

-(id)init
{
    return [self initWithLoginString:@"More Friends, More Fun!"];
}

-(id)initWithLoginString:(NSString *)loginString
{
    self = [super init];
    
    if(self) {
        baseViewController = [[OKBaseLoginViewController alloc] initWithLoginString:loginString];
        _didCapturePreviousWindow = NO;
        
        [[NSNotificationCenter defaultCenter] addObserver:self selector:@selector(getLostWindow:) name:UIWindowDidResignKeyNotification object:nil];
    }
    
    return self;
}

-(void)getLostWindow:(NSNotification*)note
{
    // Only allow previousWindow to be set once!
    if(_didCapturePreviousWindow)
        return;
    
    
    // Only set the previous window if the Window is normal level, it has a root viewController, and the viewcontroller isKindOfClass OKBaseLoginViewController
    if([[note object] isKindOfClass:[UIWindow class]]) {
        UIWindow *noteWindow = [note object];
        
        if([noteWindow windowLevel] == UIWindowLevelNormal &&
           noteWindow.rootViewController != nil &&
           ![noteWindow.rootViewController isKindOfClass:[OKBaseLoginViewController class]])
        {
            [self setPreviousWindow:noteWindow];
            _didCapturePreviousWindow = YES;
            OKLogInfo(@"Setting previous window for loginview: %@", noteWindow);
        } else {
            OKLogInfo(@"Other window shown: %@", noteWindow);
        }
    }

}

-(void)show
{
    UIWindow *window = [[UIWindow alloc] initWithFrame:[[UIScreen mainScreen] bounds]];
    window.autoresizingMask = UIViewAutoresizingFlexibleWidth|UIViewAutoresizingFlexibleHeight;
    window.backgroundColor = [UIColor clearColor];
    
    [baseViewController setDelegate:self];
    
    [baseViewController setWindow:window];
    
    window = nil;
    
    [baseViewController.window setRootViewController:baseViewController];
    [baseViewController.window makeKeyAndVisible];
    [baseViewController showLoginModalView];
}

-(void)showWithCompletionHandler:(OKLoginViewCompletionHandler)block
{
    loginDialogCompletionHandler = block;
    [self show];
}

-(void)dismiss
{
    [[NSNotificationCenter defaultCenter] removeObserver:self];
    
    //Remove the base view controller on the main thread
    dispatch_async(dispatch_get_main_queue(), ^{
        [baseViewController.view removeFromSuperview];
    });
    
    [baseViewController setDelegate:nil];
    if(loginDialogCompletionHandler != nil) {
        loginDialogCompletionHandler();
        loginDialogCompletionHandler = nil;
    }
    
    OKLogInfo(@"Login view making previousWindow key");
    // Make the previous window key
    [previousWindow makeKeyAndVisible];
    [self setPreviousWindow:nil];
    
    
    
}





@end
