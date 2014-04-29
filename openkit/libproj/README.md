Quick Start
------------
Getting started instructions for OpenKit's iOS client: 

1. Get the repo: 

  ```
    $ git clone https://github.com/OpenKit/openkit-ios.git
  ```

  Briefly, this is what you just got: 

  <pre>openkit-ios 
				/Samples			&lt;-- OpenKit sample app
				/OpenKitSDK			&lt;-- The built OpenKitSDk. To use this, simply drag this folder into your xcode project
                /OpenKit            &lt;-- The OpenKit source
                /Vendor             &lt;-- Libraries that OpenKit depends on
                /Resources          &lt;-- Images and xib files
                /OpenKit.xcodeproj  &lt;-- A project to build the SDK
  </pre>

  When you build the OpenKit target, a new directory will be created at openkit-ios/OpenKitSDK.  
  This will contain the static lib, headers, resources, and vendor code to use in your own project.  To add
  OpenKit to your own project: 
  
  - Drag the OpenKitSDK folder into your project (build first!)

  - Add the following frameworks to your project:
    
    ```
      libsqlite3.dylib
      Security.framework
      QuartzCore.framework
      AdSupport.framework
      Accounts.framework
      Social.framework
      MobileCoreServices.framework
      SystemConfiguration.framework
    ```

  - Add the following lines to your prefix file: 

    ```
     #import <SystemConfiguration/SystemConfiguration.h>
     #import <MobileCoreServices/MobileCoreServices.h>
    ```

  - Browse the sample app found in Samples/ directory to see the API calls to make. Or keep reading...


Introduction
------------
OpenKit gives you social leaderboards, achievements, social challenges, and user account management as a service.

OpenKit relies on Facebook for user authentication. Your users login with those services, and there is no "OpenKit account" that is shown to them. 


Basic SDK Usage
---------------
Be sure to read how to integrate the SDK into your app at http://openkit.io/documentation


Initialize the SDK and set your app keys
----------------------------------------------
Be sure to intialize the SDK in didFinishLaunchingWithOptions

Import the OpenKit Header
```
#import "OpenKit.h"
```

Specify your application key in application:didFinishLaunchingWithOptions:. You can get your application key from the OpenKit dashboard.
```objc
- (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions
{
    // Always enter your app key and secretKey in didFinishLaunchingWithOptions
    NSString *myAppKey = @"BspfxiqMuYxNEotLeGLm";
    NSString *mySecretKey = @"2sHQOuqgwzocUdiTsTWzyQlOy1paswYLGjrdRWWf";
    
    [OKManager configureWithAppKey:myAppKey secretKey:mySecretKey];
	...
	
	// If you're using GameCenter, you can authenticate with GameCenter here as well. 
	// OpenKit provides some convenience methods for authenticating with GameCenter
	
	[OKGameCenterUtilities authorizeUserWithGameCenterAndallowUI:YES withPresentingViewController:self.viewController withCompletionHandler:nil];
}
```







Leaderboards
=============
The OpenKit SDK provides a drop in solution for cross-platform leaderboards that work on both iOS and Android.

You define your leaderboards and their attributes in the OpenKit dashboard, and the client 

Show Leaderboards
------------------
Import the OpenKit header file

```
#import "OpenKit.h"
```

Start the Leaderboards view controller. If the user isn't logged in, they will be prompted to login when the activity is shown.
```objc
OKLeaderboardsViewController *leaderBoards = [[OKLeaderboardsViewController alloc] init];
    [self presentModalViewController:leaderBoards animated:YES];
```

This will show a list of all the leaderboards defined for your app.

Submit a Score
--------------
To submit a score, you simply create an OKScore object, set it's value, and then call submit. If the player is not authenticated with OpenKit, their score is cached locally and submitted once they authenticate. 

You can use blocks callbacks to handle success and failure when submitting a score, and handle them appropriately. 

```objc
OKScore *scoreToSubmit = [[OKScore alloc] init];

[scoreToSubmit setScoreValue:487];
[scoreToSubmit setOKLeaderboardID:23];

// Optional, if you're using GameCenter also, set the score's gamecenter leaderboard category
[scoreToSubmit setGamecenterLeaderboardID:@"level1"];

// Optional, set the display strong
[scoreToSubmit setDisplayString:[NSString stringWithFormat:@"%d points", [scoreToSubmit scoreValue]]];

[scoreToSubmit submitScoreWithCompletionHandler:^(NSError *error) {
    if(error) {
        //There was an error submitting the score
        NSLog(@"Error submitting score: %@", error);
    }
    else {
        //Score submitted successfully
    }
}
```

User accounts
==============
Because OpenKit uses Facebook as authentication providers, you don't need to worry about user account management.

OpenKit provides a user class, OKUser, that manages most of the functionality you'll need for account management. 

Users are unique to each developer, but can be shared across multiple OpenKit applications from the same developer account. 

To get the current OpenKit user, simply call:

```objc
if([OKUser currentUser] != nil) {
	//User is logged in
	OKUser *currentUser = [OKUser currentUser];
}
else {
	// No user is logged in
}
```
You can get the current user any time, it will return null if the user is not authenticated. 

User Login
----------

If you're using OpenKit leaderboards, your users will be prompted to log in when the Leaderboards UI is shown. You can optionally prompt them to login at anytime:

```objc
OKLoginView *loginView = [[OKLoginView alloc] init];
    [loginView showWithCompletionHandler:^{
        // The login view was dismissed
		// You can check whether the user is currently logged in
		// by calling [OKUser currentUser]
    }];
```




