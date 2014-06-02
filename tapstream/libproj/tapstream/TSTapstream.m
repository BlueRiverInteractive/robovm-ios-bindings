#import "TSTapstream.h"
#import "TSHelpers.h"
#import "TSPlatformImpl.h"
#import "TSCoreListenerImpl.h"
#import "TSAppEventSourceImpl.h"

@interface TSDelegateImpl : NSObject<TSDelegate> {
	TSTapstream *ts;
}
@property(nonatomic, STRONG_OR_RETAIN) TSTapstream *ts;
- (id)initWithTapstream:(TSTapstream *)ts;
- (int)getDelay;
- (void)setDelay:(int)delay;
- (bool)isRetryAllowed;
@end
// DelegateImpl comes at the end of the file so it can access a private property of the Tapstream interface



static TSTapstream *instance = nil;


@interface TSTapstream()

@property(nonatomic, STRONG_OR_RETAIN) TSCore *core;

- (id)initWithAccountName:(NSString *)accountName developerSecret:(NSString *)developerSecret config:(TSConfig *)config;

@end


@implementation TSTapstream

@synthesize core;

+ (void)createWithAccountName:(NSString *)accountName developerSecret:(NSString *)developerSecret config:(TSConfig *)config
{
	@synchronized(self)
	{
		if(instance == nil)
		{
			instance = [[TSTapstream alloc] initWithAccountName:accountName developerSecret:developerSecret config:config];
		}
		else
		{
			[TSLogging logAtLevel:kTSLoggingWarn format:@"Tapstream Warning: Tapstream already instantiated, it cannot be re-created."];
		}
	}
}

+ (id)instance
{
	@synchronized(self)
	{
		NSAssert(instance != nil, @"You must first call +createWithAccountName:developerSecret:config:");
		return instance;
	}
}


- (id)initWithAccountName:(NSString *)accountName developerSecret:(NSString *)developerSecret config:(TSConfig *)config
{
	if((self = [super init]) != nil)
	{
		del = [[TSDelegateImpl alloc] initWithTapstream:self];
		platform = [[TSPlatformImpl alloc] init];
		listener = [[TSCoreListenerImpl alloc] init];
		appEventSource = [[TSAppEventSourceImpl alloc] init];

		self.core = AUTORELEASE([[TSCore alloc] initWithDelegate:del
			platform:platform
			listener:listener
			appEventSource:appEventSource
			accountName:accountName
			developerSecret:developerSecret
			config:config]);
		[core start];
	}
	return self;
}

- (void)dealloc
{
	RELEASE(del);
	RELEASE(platform);
	RELEASE(listener);
	RELEASE(appEventSource);
	RELEASE(core);
	SUPER_DEALLOC;
}

- (void)fireEvent:(TSEvent *)event
{
	[core fireEvent:event];
}

- (void)fireHit:(TSHit *)hit completion:(void(^)(TSResponse *))completion
{
	[core fireHit:hit completion:completion];
}

- (void)getConversionData:(void(^)(NSData *))completion
{
	[core getConversionData:completion];
}

@end





@implementation TSDelegateImpl
@synthesize ts;

- (id)initWithTapstream:(TSTapstream *)tsVal
{
	if((self = [super init]) != nil)
	{
		self.ts = tsVal;
	}
	return self;
}

- (void)dealloc
{
	RELEASE(ts);
	SUPER_DEALLOC;
}

- (int)getDelay
{
	return [ts.core getDelay];
}

- (void)setDelay:(int)delay
{
}

- (bool)isRetryAllowed
{
	return true;
}
@end


