//
//  MPURLResolver.m
//  MoPub
//
//  Copyright (c) 2013 MoPub. All rights reserved.
//

#import "MPURLResolver.h"
#import "NSURL+MPAdditions.h"
#import "MPInstanceProvider.h"
#import "MPLogging.h"
#import "MPCoreInstanceProvider.h"

static NSString * const kMoPubSafariScheme = @"mopubnativebrowser";
static NSString * const kMoPubSafariNavigateHost = @"navigate";
static NSString * const kMoPubHTTPHeaderContentType = @"Content-Type";

@interface MPURLResolver ()

@property (nonatomic, retain) NSURL *URL;
@property (nonatomic, retain) NSURLConnection *connection;
@property (nonatomic, retain) NSMutableData *responseData;
@property (nonatomic, assign) NSStringEncoding responseEncoding;

- (BOOL)handleURL:(NSURL *)URL;
- (NSString *)storeItemIdentifierForURL:(NSURL *)URL;
- (BOOL)URLShouldOpenInApplication:(NSURL *)URL;
- (BOOL)URLIsHTTPOrHTTPS:(NSURL *)URL;
- (BOOL)URLPointsToAMap:(NSURL *)URL;
- (NSStringEncoding)stringEncodingFromContentType:(NSString *)contentType;

@end

@implementation MPURLResolver

@synthesize URL = _URL;
@synthesize delegate = _delegate;
@synthesize connection = _connection;
@synthesize responseData = _responseData;

+ (MPURLResolver *)resolver
{
    return [[[MPURLResolver alloc] init] autorelease];
}

- (void)dealloc
{
    self.URL = nil;
    self.connection = nil;
    self.responseData = nil;

    [super dealloc];
}

- (void)startResolvingWithURL:(NSURL *)URL delegate:(id<MPURLResolverDelegate>)delegate
{
    [self.connection cancel];

    self.URL = URL;
    self.delegate = delegate;
    self.responseData = [NSMutableData data];
    self.responseEncoding = NSUTF8StringEncoding;

    if (![self handleURL:self.URL]) {
        NSURLRequest *request = [[MPCoreInstanceProvider sharedProvider] buildConfiguredURLRequestWithURL:self.URL];
        self.connection = [NSURLConnection connectionWithRequest:request delegate:self];
    }
}

- (void)cancel
{
    [self.connection cancel];
    self.connection = nil;
}

#pragma mark - Handling Application/StoreKit URLs

/*
 * Parses the provided URL for actions to perform (opening StoreKit, opening Safari, etc.).
 * If the URL represents an action, this method will inform its delegate of the correct action to
 * perform.
 *
 * Returns YES if the URL contained an action, and NO otherwise.
 */
- (BOOL)handleURL:(NSURL *)URL
{
    if ([self storeItemIdentifierForURL:URL]) {
        [self.delegate showStoreKitProductWithParameter:[self storeItemIdentifierForURL:URL] fallbackURL:URL];
    } else if ([self safariURLForURL:URL]) {
        NSURL *safariURL = [NSURL URLWithString:[self safariURLForURL:URL]];
        [self.delegate openURLInApplication:safariURL];
    } else if ([self URLShouldOpenInApplication:URL]) {
        if ([[UIApplication sharedApplication] canOpenURL:URL]) {
            [self.delegate openURLInApplication:URL];
        } else {
            [self.delegate failedToResolveURLWithError:[NSError errorWithDomain:@"com.mopub" code:-1 userInfo:nil]];
        }
    } else {
        return NO;
    }

    return YES;
}

#pragma mark Identifying Application URLs

- (BOOL)URLShouldOpenInApplication:(NSURL *)URL
{
    return ![self URLIsHTTPOrHTTPS:URL] || [self URLPointsToAMap:URL];
}

- (BOOL)URLIsHTTPOrHTTPS:(NSURL *)URL
{
    return [URL.scheme isEqualToString:@"http"] || [URL.scheme isEqualToString:@"https"];
}

- (BOOL)URLPointsToAMap:(NSURL *)URL
{
    return [URL.host hasSuffix:@"maps.google.com"] || [URL.host hasSuffix:@"maps.apple.com"];
}

#pragma mark Extracting StoreItem Identifiers

- (NSString *)storeItemIdentifierForURL:(NSURL *)URL
{
    NSString *itemIdentifier = nil;
    if ([URL.host hasSuffix:@"itunes.apple.com"]) {
        NSString *lastPathComponent = [[URL path] lastPathComponent];
        if ([lastPathComponent hasPrefix:@"id"]) {
            itemIdentifier = [lastPathComponent substringFromIndex:2];
        } else {
            itemIdentifier = [URL.mp_queryAsDictionary objectForKey:@"id"];
        }
    } else if ([URL.host hasSuffix:@"phobos.apple.com"]) {
        itemIdentifier = [URL.mp_queryAsDictionary objectForKey:@"id"];
    }

    NSCharacterSet *nonIntegers = [[NSCharacterSet decimalDigitCharacterSet] invertedSet];
    if (itemIdentifier && itemIdentifier.length > 0 && [itemIdentifier rangeOfCharacterFromSet:nonIntegers].location == NSNotFound) {
        return itemIdentifier;
    }

    return nil;
}

#pragma mark - Identifying URLs to open in Safari

- (NSString *)safariURLForURL:(NSURL *)URL
{
    NSString *safariURL = nil;

    if ([[URL scheme] isEqualToString:kMoPubSafariScheme] &&
        [[URL host] isEqualToString:kMoPubSafariNavigateHost]) {
        safariURL = [URL.mp_queryAsDictionary objectForKey:@"url"];
    }

    return safariURL;
}

#pragma mark - Identifying NSStringEncoding from NSURLResponse Content-Type header

- (NSStringEncoding)stringEncodingFromContentType:(NSString *)contentType
{
    NSStringEncoding encoding = NSUTF8StringEncoding;
    
    if (![contentType length]) {
        MPLogWarn(@"Attempting to set string encoding from nil %@", kMoPubHTTPHeaderContentType);
        return encoding;
    }
    
    NSRegularExpression *regex = [NSRegularExpression regularExpressionWithPattern:@"(?<=charset=)[^;]*" options:kNilOptions error:nil];
    
    NSTextCheckingResult *charsetResult = [regex firstMatchInString:contentType options:kNilOptions range:NSMakeRange(0, [contentType length])];
    if (charsetResult && charsetResult.range.location != NSNotFound) {
        NSString *charset = [contentType substringWithRange:[charsetResult range]];
        
        CFStringRef cfCharset = (CFStringRef)charset;
        
        CFStringEncoding cfEncoding = CFStringConvertIANACharSetNameToEncoding(cfCharset);
        if (cfEncoding == kCFStringEncodingInvalidId) {
            return encoding;
        }
        encoding = CFStringConvertEncodingToNSStringEncoding(cfEncoding);
    }
    
    return encoding;
}

#pragma mark - <NSURLConnectionDataDelegate>

- (void)connection:(NSURLConnection *)connection didReceiveData:(NSData *)data
{
    [self.responseData appendData:data];
}

- (NSURLRequest *)connection:(NSURLConnection *)connection willSendRequest:(NSURLRequest *)request redirectResponse:(NSURLResponse *)response
{
    if ([self handleURL:request.URL]) {
        [connection cancel];
        return nil;
    } else {
        self.URL = request.URL;
        return request;
    }
}

- (void)connection:(NSURLConnection *)connection didReceiveResponse:(NSURLResponse *)response
{
    NSDictionary *headers = [(NSHTTPURLResponse *)response allHeaderFields];
    NSString *contentType = [headers objectForKey:kMoPubHTTPHeaderContentType];
    self.responseEncoding = [self stringEncodingFromContentType:contentType];
}

- (void)connectionDidFinishLoading:(NSURLConnection *)connection
{
    [self.delegate showWebViewWithHTMLString:[[[NSString alloc] initWithData:self.responseData encoding:self.responseEncoding] autorelease] baseURL:self.URL];
}

- (void)connection:(NSURLConnection *)connection didFailWithError:(NSError *)error
{
    [self.delegate failedToResolveURLWithError:error];
}

@end
