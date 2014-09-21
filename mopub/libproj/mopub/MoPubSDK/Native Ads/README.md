## Native Ad Integration for iOS

This document describes how to incorporate native advertisements into your application.

Native advertising allows you to conveniently monetize your application in a manner that is cohesive and consistent with its existing design. Using the MoPub SDK, your application can obtain the individual assets that comprise an ad and lay them out in a completely custom fashion, rather than displaying ads in webviews, which do not allow for appearance customization. The SDK automatically handles image caching and metrics tracking so you can simply focus on how, when, and where to display ads.

## Essentials

The foundation of the MoPub native ad interface lies in two objects: `MPNativeAdRequest` and `MPNativeAd`.

The `MPNativeAdRequest` class provides a simple, block-based interface for asynchronously fetching ads.

The `MPNativeAd` class provides the necessary information and assets needed to manage the display and interaction behavior of an ad.

## Requesting Native Ads

1. Create an `MPNativeAdRequest` object using the `+requestWithAdUnitIdentifier:` method.

    ```
    MPNativeAdRequest *adRequest = [MPNativeAdRequest requestWithAdUnitIdentifier:@"YOUR_AD_UNIT_ID"];
    ```

2. You may optionally set an `MPNativeAdRequestTargeting` object on the request in order to provide targeting information, such as location.

    ```
    MPNativeAdRequestTargeting *targeting = [MPNativeAdRequestTargeting targeting];
    targeting.location = [self getCurrentLocation]; // developer-provided location
    adRequest.targeting = targeting;
    ```

3. Start the request via `-startWithCompletionHandler:`, providing a completion block to handle the results of the request. If the request is successful, the completion block's `MPNativeAd` parameter will represent an object that contains the ad's assets. The following sections of this guide provide more information on how to access ad assets.

    ```
    [adRequest startWithCompletionHandler:^(MPNativeAdRequest *request, MPNativeAd *response, NSError *error) {
        if (error) {
            // Handle error.
        } else {
            // Use the 'response' object to render a native ad.
        }
    }];
    ```

## Rendering Native Ads in Generic UIView Subclasses

Advertising content can be displayed in any new or existing UIView subclass that implements the `MPNativeAdRendering` protocol. This protocol provides a method for your view class to load the ad assets of an `MPNativeAd` into the appropriate components of your view.

1. Implement the `MPNativeAdRendering` protocol in your view subclass.

    In particular, the `-layoutAdAssets:` method will pass your view an `MPNativeAd` instance, which has convenience methods for displaying its assets. Typically, an `MPNativeAd` instance has a base set of assets (as configured on the MoPub website):
    - title
    - main text
    - call-to-action text
    - icon image URL
    - main image URL

    ```
    // YourNativeAdView.h
    
    @interface YourNativeAdView : UIView <MPNativeAdRendering>
    
    @property (strong, nonatomic) UILabel *titleLabel;
    @property (strong, nonatomic) UILabel *mainTextLabel;
    @property (strong, nonatomic) UIButton *callToActionButton;
    @property (strong, nonatomic) UIImageView *iconImageView;
    @property (strong, nonatomic) UIImageView *mainImageView;
    
    @end
    
    // YourNativeAdView.m
    
    @implementation YourNativeAdView
    
    ...
    
    - (void)layoutAdAssets:(MPNativeAd *)adObject
    {
        [adObject loadTitleIntoLabel:self.titleLabel];
        [adObject loadTextIntoLabel:self.mainTextLabel];
        [adObject loadCallToActionTextIntoLabel:self.callToActionButton.titleLabel];
        [adObject loadIconIntoImageView:self.iconImageView];
        [adObject loadImageIntoImageView:self.mainImageView];
    }
    
    @end
    ```
    
    **Rendering Custom Assets for Direct-Sold Ads**

    When creating a direct-sold ad creative on the MoPub website, you have the option of adding custom assets to supplement the pre-defined ones described above. `MPNativeAd` provides access to all assets via its `properties` dictionary.
    
    The example below demonstrates how to access custom text and images that you have provided:
    
    ```    
    - (void)layoutAdAssets:(MPNativeAd *)adObject
    {
        self.additionalLabel.text = [adObject.properties objectForKey:@"customAdditionalText"];
        
        // To load custom images, you can use the convenience method -loadImageForURL:intoImageView:.
        NSString *customImageURLString = [adObject.properties objectForKey:@"customImage"];
        if ([customImageURLString length]) {        
     	    NSURL *customImageURL = [NSURL URLWithString:customImageURLString];
       	    [adObject loadImageForURL:customImageURL intoImageView:self.additionalImageView];
       	}
    }
    ```

2. When you have obtained an `MPNativeAd` (via the completion handler of an MPNativeAdRequest), call `-prepareForDisplayInView:` in your view controller, passing in an instance of your view class.

    This method sets up automatic impression tracking for the given ad object, and lays out the ad's assets as defined in the previous step.

    ```
    [adObject prepareForDisplayInView:yourNativeAdView];
    ```

3. When you detect that the user has tapped on an ad (e.g. via gesture recognizer or a button action), trigger the ad's default action by calling the `-displayContentForURL:rootViewController:completionBlock:` method on the corresponding `MPNativeAd`.

    ```
    [adObject displayContentForURL:adObject.defaultActionURL rootViewController:self completion:^(BOOL success, NSError *error) {
        if (success) {
            NSLog(@"Completed ad action.");
        } else {
            NSLog(@"Ad action could not be completed. Error: %@", error);
        }
    }];
    ```

4. Add the view to your view hierarchy.


## Rendering Native Ads in Table Views

The `MPTableViewAdManager` class provides convenient functionality for adding advertisements to a table view. Such advertisements are displayed in table view cells alongside your application's content, and can be styled to support your application's native look and feel. `MPTableViewAdManager` also handles impression tracking behind the scenes. 

1. Create a UITableViewCell subclass that implements `MPNativeAdRendering`, as described above for generic UIView subclasses.

2. Instantiate an `MPTableViewAdManager`, passing in the table view where you intend to show ads. The table view ad manager is responsible for automatically tracking impressions and providing ad cells to your table view's data source.

    ```
    // YourTableViewController.m
    
    - (void)viewDidLoad
    {
        ...
        self.adManager = [[MPTableViewAdManager alloc] initWithTableView:self.tableView];
    }
    ```

3. Then, your table view's data source will need to decide where in the table view (at which index paths) to display advertising cells. The data source can obtain advertising cells from the manager using the `-adCellForAd:cellClass:` method, which accepts an `MPNativeAd` to be rendered along with a table view cell class object.

    ```
    // The following code assumes that you have inserted any received ad objects into your data source's backing array (self.contentArray in the example).
    
    - (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath
    {
        if ([self shouldShowAdAtIndexPath:indexPath]) {
            MPNativeAd *adObject = (MPNativeAd *)[self.contentArray objectAtIndex:indexPath.row];
            
            // YourNativeAdCell is a UITableViewCell subclass that implements MPNativeAdRendering.
            return [self.adManager adCellForAd:adObject cellClass:[YourNativeAdCell class]];
        }
        else {
            // Return a regular content cell.
        }
    }
    
    - (BOOL)shouldShowAdAtIndexPath:(NSIndexPath *)indexPath
    {
        return [[self.contentArray objectAtIndex:indexPath.row] isKindOfClass:[MPNativeAd class]];
    }
    ```

4. You will need to additionally modify your table view's data source and delegate to account for the presence of ad cells alongside your regular content. As a general guideline, any methods that associate index paths with regular content need to consider that such paths may now be associated with ad objects. At a minimum, the following methods will require modification.

    **UITableViewDataSource**

    `-tableView:numberOfRowsInSection:`

    Your implementation must return the sum of the number of ads you wish to insert and the original number of rows.

    `-tableView:cellForRowAtIndexPath:`

    Your implementation must be able to decide whether to return an ad cell (versus a regular content cell) depending on the given index path. You can obtain an ad cell by calling the table view ad manager's `-adCellForAd:cellClass:`.
    
    **UITableViewDelegate**
    
    `-tableView:didSelectRowAtIndexPath:`
    
    Your implementation should determine whether the selected row corresponds to an ad -- if so, it should trigger the ad's default action by calling the `-displayContentForURL:rootViewController:completionBlock:` method on the corresponding `MPNativeAd` object.
    
    Example:
    
    ```
    - (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath
    {
        [self.tableView deselectRowAtIndexPath:indexPath animated:YES];
        
        if ([self shouldShowAdAtIndexPath:indexPath]) {
            MPNativeAd *adObject = (MPNativeAd *)[self.contentArray objectAtIndex:indexPath.row];
            [adObject displayContentForURL:adObject.defaultActionURL rootViewController:self completion:^(BOOL success, NSError *error) {
                if (success) {
                    NSLog(@"Completed ad action.");
                } else {
                    NSLog(@"Ad action could not be completed. Error: %@", error);
                }
            }];
        } else {
            // Regular cell selection handling.
        }
    }
    ```

## Tracking Impressions and Clicks

If you use the provided APIs for display and interaction, impressions and clicks will be tracked automatically.

- For a UIView implementation, this entails calling `[adObject prepareForDisplayInView:yourNativeAdView]` before displaying the ad view.

- For a UITableView implementation, impressions are automatically tracked when using the `MPTableViewAdManager`.

- Click tracking occurs automatically when using the `-displayContentForURL:rootViewController:completion:` method of `MPNativeAd`.

## Best Practices

### Hide Blank Ad Views

Your application should avoid displaying ad views that have not yet been configured with assets. In addition, it should adapt gracefully when ad requests fail due to lack of inventory or connectivity issues.

For example, if your application displays ads in a table view, you should ensure that failed ad requests do not cause unnecessary blank cells or gaps in the table.

### Avoid Excessive Ad Requests

Making requests for ads which are never displayed to the user will consume unnecessary resources and may negatively impact your revenue. Therefore, your application should make an effort to request ads only when they are likely to be displayed. In particular, avoid caching large quantities of ads for long periods of time.

For example, when a user initially navigates to a table view with many content cells, you should avoid requesting ads that will be displayed near the bottom of the table view (i.e. far below the fold). Instead, wait for the user to begin scrolling through the feed before making additional ad requests.