//
//  MPGlobal.m
//  MoPub
//
//  Created by Andrew He on 5/5/11.
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
BOOL MPViewIsDescendantOfKeyWindow(UIView *view);
BOOL MPViewIsDescendantOfApplicationWindow(UIView *view);
BOOL MPViewIntersectsKeyWindow(UIView *view);
BOOL MPViewIntersectsApplicationWindow(UIView *view);
NSString *MPSHA1Digest(NSString *string);

UIInterfaceOrientation MPInterfaceOrientation()
{
    return [UIApplication sharedApplication].statusBarOrientation;
}

UIWindow *MPKeyWindow()
{
    return [UIApplication sharedApplication].keyWindow;
}

UIWindow *MPApplicationWindow()
{
    return [[UIApplication sharedApplication].delegate window];
}

CGFloat MPStatusBarHeight() {
    if ([UIApplication sharedApplication].statusBarHidden) return 0.0;

    UIInterfaceOrientation orientation = MPInterfaceOrientation();

    return UIInterfaceOrientationIsLandscape(orientation) ?
        CGRectGetWidth([UIApplication sharedApplication].statusBarFrame) :
        CGRectGetHeight([UIApplication sharedApplication].statusBarFrame);
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

    if (UIInterfaceOrientationIsLandscape(MPInterfaceOrientation()))
    {
        CGFloat width = bounds.size.width;
        bounds.size.width = bounds.size.height;
        bounds.size.height = width;
    }

    return bounds;
}

CGFloat MPDeviceScaleFactor()
{
    if ([[UIScreen mainScreen] respondsToSelector:@selector(displayLinkWithTarget:selector:)] &&
        [[UIScreen mainScreen] respondsToSelector:@selector(scale)])
    {
        return [[UIScreen mainScreen] scale];
    }
    else return 1.0;
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
    for (int i = 0; i < CC_SHA1_DIGEST_LENGTH; i++)
    {
        [output appendFormat:@"%02x", digest[i]];
    }

    return output;
}

BOOL MPViewIsVisible(UIView *view)
{
    // In order for a view to be visible, it:
    // 1) must not be hidden,
    // 2) must not have an ancestor that is hidden,
    // 3) must be a descendant of the key window, and
    // 4) must be within the frame of the key window.
    //
    // Note: this function does not check whether any part of the view is obscured by another view.

    return (!view.hidden &&
            !MPViewHasHiddenAncestor(view) &&
            MPViewIsDescendantOfApplicationWindow(view) &&
            MPViewIntersectsApplicationWindow(view));
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

BOOL MPViewIsDescendantOfKeyWindow(UIView *view)
{
    UIView *ancestor = view.superview;
    UIWindow *keyWindow = MPKeyWindow();
    while (ancestor) {
        if (ancestor == keyWindow) return YES;
        ancestor = ancestor.superview;
    }
    return NO;
}

BOOL MPViewIsDescendantOfApplicationWindow(UIView *view)
{
    UIView *ancestor = view.superview;
    UIWindow *appWindow = MPApplicationWindow();
    while (ancestor) {
        if (ancestor == appWindow) return YES;
        ancestor = ancestor.superview;
    }
    return NO;
}

BOOL MPViewIntersectsKeyWindow(UIView *view)
{
    UIWindow *keyWindow = MPKeyWindow();

    // We need to call convertRect:toView: on this view's superview rather than on this view itself.
    CGRect viewFrameInWindowCoordinates = [view.superview convertRect:view.frame toView:keyWindow];

    return CGRectIntersectsRect(viewFrameInWindowCoordinates, keyWindow.frame);
}

BOOL MPViewIntersectsApplicationWindow(UIView *view)
{
    UIWindow *appWindow = MPApplicationWindow();

    // We need to call convertRect:toView: on this view's superview rather than on this view itself.
    CGRect viewFrameInWindowCoordinates = [view.superview convertRect:view.frame toView:appWindow];

    return CGRectIntersectsRect(viewFrameInWindowCoordinates, appWindow.frame);
}

BOOL MPViewIntersectsKeyWindowWithPercent(UIView *view, CGFloat percentVisible)
{
    UIWindow *keyWindow = MPKeyWindow();

    // We need to call convertRect:toView: on this view's superview rather than on this view itself.
    CGRect viewFrameInWindowCoordinates = [view.superview convertRect:view.frame toView:keyWindow];
    CGRect intersection = CGRectIntersection(viewFrameInWindowCoordinates, keyWindow.frame);

    CGFloat intersectionArea = CGRectGetWidth(intersection) * CGRectGetHeight(intersection);
    CGFloat originalArea = CGRectGetWidth(view.bounds) * CGRectGetHeight(view.bounds);

    return intersectionArea >= (originalArea * percentVisible);
}

BOOL MPViewIntersectsApplicationWindowWithPercent(UIView *view, CGFloat percentVisible)
{
    UIWindow *appWindow = MPApplicationWindow();

    // We need to call convertRect:toView: on this view's superview rather than on this view itself.
    CGRect viewFrameInWindowCoordinates = [view.superview convertRect:view.frame toView:appWindow];
    CGRect intersection = CGRectIntersection(viewFrameInWindowCoordinates, appWindow.frame);

    CGFloat intersectionArea = CGRectGetWidth(intersection) * CGRectGetHeight(intersection);
    CGFloat originalArea = CGRectGetWidth(view.bounds) * CGRectGetHeight(view.bounds);

    return intersectionArea >= (originalArea * percentVisible);
}

////////////////////////////////////////////////////////////////////////////////////////////////////

@implementation NSString (MPAdditions)

- (NSString *)URLEncodedString
{
    NSString *result = (NSString *)CFURLCreateStringByAddingPercentEscapes(NULL,
                                                                           (CFStringRef)self,
                                                                           NULL,
                                                                           (CFStringRef)@"!*'();:@&=+$,/?%#[]<>",
                                                                           kCFStringEncodingUTF8);
    return [result autorelease];
}

@end

////////////////////////////////////////////////////////////////////////////////////////////////////

@implementation UIDevice (MPAdditions)

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

////////////////////////////////////////////////////////////////////////////////////////////////////

@interface MPTelephoneConfirmationController ()

@property (nonatomic, retain) UIAlertView *alertView;
@property (nonatomic, retain) NSURL *telephoneURL;
@property (nonatomic, copy) MPTelephoneConfirmationControllerClickHandler clickHandler;

@end

@implementation MPTelephoneConfirmationController

- (id)initWithURL:(NSURL *)url clickHandler:(MPTelephoneConfirmationControllerClickHandler)clickHandler
{
    if (![url mp_hasTelephoneScheme] && ![url mp_hasTelephonePromptScheme]) {
        // Shouldn't be here as the url must have a tel or telPrompt scheme.
        MPLogError(@"Processing URL as a telephone URL when %@ doesn't follow the tel:// or telprompt:// schemes", url.absoluteString);
        [self release];
        return nil;
    }

    if (self = [super init]) {
        // If using tel://xxxxxxx, the host will be the number.  If using tel:xxxxxxx, we will try the resourceIdentifier.
        NSString *phoneNumber = [url host];

        if (!phoneNumber) {
            phoneNumber = [url resourceSpecifier];
            if ([phoneNumber length] == 0) {
                MPLogError(@"Invalid telelphone URL: %@.", url.absoluteString);
                [self release];
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
    self.alertView = nil;

    self.clickHandler = nil;
    self.telephoneURL = nil;
    [super dealloc];
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

