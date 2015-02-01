//
//  MPGlobal.m
//  MoPub
//
//  Copyright 2011 MoPub, Inc. All rights reserved.
//

#import "MPGlobal.h"
#import "MPConstants.h"
#import "MPLogging.h"
#import "NSURL+MPAdditions.h"
#import <CommonCrypto/CommonDigest.h>

#import <sys/types.h>
#import <sys/sysctl.h>

BOOL MPViewHasHiddenAncestor(UIView *view);
UIWindow *MPViewGetParentWindow(UIView *view);
BOOL MPViewIntersectsParentWindow(UIView *view);
NSString *MPSHA1Digest(NSString *string);

UIInterfaceOrientation MPInterfaceOrientation()
{
    return [UIApplication sharedApplication].statusBarOrientation;
}

UIWindow *MPKeyWindow()
{
    return [UIApplication sharedApplication].keyWindow;
}

CGFloat MPStatusBarHeight() {
    if ([UIApplication sharedApplication].statusBarHidden) return 0.0f;

    CGFloat width = CGRectGetWidth([UIApplication sharedApplication].statusBarFrame);
    CGFloat height = CGRectGetHeight([UIApplication sharedApplication].statusBarFrame);

    return (width < height) ? width : height;
}

CGRect MPApplicationFrame()
{
    CGRect frame = MPScreenBounds();

    frame.origin.y += MPStatusBarHeight();
    frame.size.height -= MPStatusBarHeight();

    return frame;
}

CGRect MPScreenBounds()
{
    CGRect bounds = [UIScreen mainScreen].bounds;

    if (UIInterfaceOrientationIsLandscape(MPInterfaceOrientation()) && [[UIDevice currentDevice].systemVersion compare:@"8.0"] == NSOrderedAscending) {
        CGFloat width = bounds.size.width;
        bounds.size.width = bounds.size.height;
        bounds.size.height = width;
    }

    return bounds;
}

CGFloat MPDeviceScaleFactor()
{
    if ([[UIScreen mainScreen] respondsToSelector:@selector(displayLinkWithTarget:selector:)] &&
        [[UIScreen mainScreen] respondsToSelector:@selector(scale)]) {
        return [[UIScreen mainScreen] scale];
    } else {
        return 1.0;
    }
}

NSDictionary *MPDictionaryFromQueryString(NSString *query) {
    NSMutableDictionary *queryDict = [NSMutableDictionary dictionary];
    NSArray *queryElements = [query componentsSeparatedByString:@"&"];
    for (NSString *element in queryElements) {
        NSArray *keyVal = [element componentsSeparatedByString:@"="];
        NSString *key = [keyVal objectAtIndex:0];
        NSString *value = [keyVal lastObject];
        [queryDict setObject:[value stringByReplacingPercentEscapesUsingEncoding:NSUTF8StringEncoding]
                      forKey:key];
    }
    return queryDict;
}

NSString *MPSHA1Digest(NSString *string)
{
    unsigned char digest[CC_SHA1_DIGEST_LENGTH];
    NSData *data = [string dataUsingEncoding:NSASCIIStringEncoding];
    CC_SHA1([data bytes], (CC_LONG)[data length], digest);

    NSMutableString *output = [NSMutableString stringWithCapacity:CC_SHA1_DIGEST_LENGTH * 2];
    for (int i = 0; i < CC_SHA1_DIGEST_LENGTH; i++) {
        [output appendFormat:@"%02x", digest[i]];
    }

    return output;
}

BOOL MPViewIsVisible(UIView *view)
{
    // In order for a view to be visible, it:
    // 1) must not be hidden,
    // 2) must not have an ancestor that is hidden,
    // 3) must be within the frame of its parent window.
    //
    // Note: this function does not check whether any part of the view is obscured by another view.

    return (!view.hidden &&
            !MPViewHasHiddenAncestor(view) &&
            MPViewIntersectsParentWindow(view));
}

BOOL MPViewHasHiddenAncestor(UIView *view)
{
    UIView *ancestor = view.superview;
    while (ancestor) {
        if (ancestor.hidden) return YES;
        ancestor = ancestor.superview;
    }
    return NO;
}

UIWindow *MPViewGetParentWindow(UIView *view)
{
    UIView *ancestor = view.superview;
    while (ancestor) {
        if ([ancestor isKindOfClass:[UIWindow class]]) {
            return (UIWindow *)ancestor;
        }
        ancestor = ancestor.superview;
    }
    return nil;
}

BOOL MPViewIntersectsParentWindow(UIView *view)
{
    UIWindow *parentWindow = MPViewGetParentWindow(view);

    if (parentWindow == nil) {
        return NO;
    }

    // We need to call convertRect:toView: on this view's superview rather than on this view itself.
    CGRect viewFrameInWindowCoordinates = [view.superview convertRect:view.frame toView:parentWindow];

    return CGRectIntersectsRect(viewFrameInWindowCoordinates, parentWindow.frame);
}

BOOL MPViewIntersectsParentWindowWithPercent(UIView *view, CGFloat percentVisible)
{
    UIWindow *parentWindow = MPViewGetParentWindow(view);

    if (parentWindow == nil) {
        return NO;
    }

    // We need to call convertRect:toView: on this view's superview rather than on this view itself.
    CGRect viewFrameInWindowCoordinates = [view.superview convertRect:view.frame toView:parentWindow];
    CGRect intersection = CGRectIntersection(viewFrameInWindowCoordinates, parentWindow.frame);

    CGFloat intersectionArea = CGRectGetWidth(intersection) * CGRectGetHeight(intersection);
    CGFloat originalArea = CGRectGetWidth(view.bounds) * CGRectGetHeight(view.bounds);

    return intersectionArea >= (originalArea * percentVisible);
}

NSString *MPResourcePathForResource(NSString *resourceName)
{
#ifdef MP_FABRIC
    // We store all assets inside a bundle for Fabric.
    return [@"MoPub.bundle" stringByAppendingPathComponent:resourceName];
#else
    // When using open source, the resources just live in the main bundle.
    return resourceName;
#endif
}

////////////////////////////////////////////////////////////////////////////////////////////////////

@implementation NSString (MPAdditions)

- (NSString *)URLEncodedString
{
    NSString *result = (NSString *)CFBridgingRelease(CFURLCreateStringByAddingPercentEscapes(NULL,
                                                                           (CFStringRef)self,
                                                                           NULL,
                                                                           (CFStringRef)@"!*'();:@&=+$,/?%#[]<>",
                                                                           kCFStringEncodingUTF8));
    return result;
}

@end

////////////////////////////////////////////////////////////////////////////////////////////////////

@implementation UIDevice (MPAdditions)

- (BOOL)supportsOrientationMask:(UIInterfaceOrientationMask)orientationMask
{
    NSArray *supportedOrientations = [[[NSBundle mainBundle] infoDictionary] objectForKey:@"UISupportedInterfaceOrientations"];

    if (orientationMask & UIInterfaceOrientationMaskLandscape) {
        if ([supportedOrientations containsObject:@"UIInterfaceOrientationLandscapeLeft"] || [supportedOrientations containsObject:@"UIInterfaceOrientationLandscapeRight"]) {
            return YES;
        }
    }

    if (orientationMask & UIInterfaceOrientationMaskPortrait) {
        if ([supportedOrientations containsObject:@"UIInterfaceOrientationPortrait"]) {
            return YES;
        }
    }

    if (orientationMask & UIInterfaceOrientationMaskPortraitUpsideDown) {
        if ([supportedOrientations containsObject:@"UIInterfaceOrientationPortraitUpsideDown"]) {
            return YES;
        }
    }

    return NO;
}

- (BOOL)doesOrientation:(UIInterfaceOrientation)orientation matchOrientationMask:(UIInterfaceOrientationMask)orientationMask
{
    BOOL supportsLandscape = (orientationMask & UIInterfaceOrientationMaskLandscape) > 0;
    BOOL supportsPortrait = (orientationMask & UIInterfaceOrientationMaskPortrait) > 0;
    BOOL supportsPortraitUpsideDown = (orientationMask & UIInterfaceOrientationMaskPortraitUpsideDown) > 0;

    if (supportsLandscape && (orientation == UIInterfaceOrientationLandscapeLeft || orientation == UIInterfaceOrientationLandscapeRight)) {
        return YES;
    }

    if (supportsPortrait && (orientation == UIInterfaceOrientationPortrait)) {
        return YES;
    }

    if (supportsPortraitUpsideDown && (orientation == UIInterfaceOrientationPortraitUpsideDown)) {
        return YES;
    }

    return NO;
}

- (NSString *)hardwareDeviceName
{
    size_t size;
    sysctlbyname("hw.machine", NULL, &size, NULL, 0);
    char *machine = malloc(size);
    sysctlbyname("hw.machine", machine, &size, NULL, 0);
    NSString *platform = [NSString stringWithCString:machine encoding:NSUTF8StringEncoding];
    free(machine);
    return platform;
}

@end

@implementation UIApplication (MPAdditions)

- (void)mp_preIOS7setApplicationStatusBarHidden:(BOOL)hidden
{
    // Hiding the status bar should use a fade effect.
    // Displaying the status bar should use no animation.
    UIStatusBarAnimation animation = hidden ?
    UIStatusBarAnimationFade : UIStatusBarAnimationNone;
    [[UIApplication sharedApplication] setStatusBarHidden:hidden withAnimation:animation];
}
@end
////////////////////////////////////////////////////////////////////////////////////////////////////

@interface MPTelephoneConfirmationController ()

@property (nonatomic, strong) UIAlertView *alertView;
@property (nonatomic, strong) NSURL *telephoneURL;
@property (nonatomic, copy) MPTelephoneConfirmationControllerClickHandler clickHandler;

@end

@implementation MPTelephoneConfirmationController

- (id)initWithURL:(NSURL *)url clickHandler:(MPTelephoneConfirmationControllerClickHandler)clickHandler
{
    if (![url mp_hasTelephoneScheme] && ![url mp_hasTelephonePromptScheme]) {
        // Shouldn't be here as the url must have a tel or telPrompt scheme.
        MPLogError(@"Processing URL as a telephone URL when %@ doesn't follow the tel:// or telprompt:// schemes", url.absoluteString);
        return nil;
    }

    if (self = [super init]) {
        // If using tel://xxxxxxx, the host will be the number.  If using tel:xxxxxxx, we will try the resourceIdentifier.
        NSString *phoneNumber = [url host];

        if (!phoneNumber) {
            phoneNumber = [url resourceSpecifier];
            if ([phoneNumber length] == 0) {
                MPLogError(@"Invalid telelphone URL: %@.", url.absoluteString);
                return nil;
            }
        }

        _alertView = [[UIAlertView alloc] initWithTitle: @"Are you sure you want to call?"
                                                message:phoneNumber
                                               delegate:self
                                      cancelButtonTitle:@"Cancel"
                                      otherButtonTitles:@"Call", nil];
        self.clickHandler = clickHandler;

        // We want to manually handle telPrompt scheme alerts.  So we'll convert telPrompt schemes to tel schemes.
        if ([url mp_hasTelephonePromptScheme]) {
            self.telephoneURL = [NSURL URLWithString:[NSString stringWithFormat:@"tel://%@", phoneNumber]];
        } else {
            self.telephoneURL = url;
        }
    }

    return self;
}

- (void)dealloc
{
    self.alertView.delegate = nil;
    [self.alertView dismissWithClickedButtonIndex:0 animated:YES];
}

- (void)show
{
    [self.alertView show];
}

#pragma mark - UIAlertViewDelegate

- (void)alertView:(UIAlertView *)alertView clickedButtonAtIndex:(NSInteger)buttonIndex
{
    BOOL confirmed = (buttonIndex == 1);

    if (self.clickHandler) {
        self.clickHandler(self.telephoneURL, confirmed);
    }

}

@end

