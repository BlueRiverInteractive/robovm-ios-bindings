//
//  ADJActivityPackage.m
//  Adjust
//
//  Created by Christian Wellenbrock on 2013-07-03.
//  Copyright (c) 2013 adjust GmbH. All rights reserved.
//

#import "ADJActivityPackage.h"
#import "ADJActivityKind.h"

#pragma mark -
@implementation ADJActivityPackage

- (NSString *)description {
    return [NSString stringWithFormat:@"%@%@",
            ADJActivityKindToString(self.activityKind),
            self.suffix];
}

- (NSString *)extendedString {
    NSMutableString *builder = [NSMutableString string];
    [builder appendFormat:@"Path:      %@\n", self.path];
    [builder appendFormat:@"ClientSdk: %@\n", self.clientSdk];

    if (self.parameters != nil) {
        [builder appendFormat:@"Parameters:"];
        for (NSString *key in self.parameters) {
            NSString *value = [self.parameters objectForKey:key];
            [builder appendFormat:@"\n\t\t%-22s %@", [key UTF8String], value];
        }
    }

    return builder;
}

- (NSString *)successMessage {
    return [NSString stringWithFormat:@"Tracked %@%@",
            ADJActivityKindToString(self.activityKind),
            self.suffix];
}

- (NSString *)failureMessage {
    return [NSString stringWithFormat:@"Failed to track %@%@",
            ADJActivityKindToString(self.activityKind),
            self.suffix];
}

#pragma mark NSCoding
- (id)initWithCoder:(NSCoder *)decoder {
    self = [super init];
    if (self == nil) return self;

    self.path = [decoder decodeObjectForKey:@"path"];
    self.clientSdk = [decoder decodeObjectForKey:@"clientSdk"];
    self.parameters = [decoder decodeObjectForKey:@"parameters"];
    NSString *kindString = [decoder decodeObjectForKey:@"kind"];
    self.suffix = [decoder decodeObjectForKey:@"suffix"];

    self.activityKind = ADJActivityKindFromString(kindString);

    return self;
}

- (void)encodeWithCoder:(NSCoder *)encoder {
    NSString *kindString = ADJActivityKindToString(self.activityKind);

    [encoder encodeObject:self.path forKey:@"path"];
    [encoder encodeObject:self.clientSdk forKey:@"clientSdk"];
    [encoder encodeObject:self.parameters forKey:@"parameters"];
    [encoder encodeObject:kindString forKey:@"kind"];
    [encoder encodeObject:self.suffix forKey:@"suffix"];
}

@end
