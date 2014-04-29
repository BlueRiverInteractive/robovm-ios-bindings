//
//  OKSpinnerCell.m
//  OpenKit
//
//  Created by Suneet Shah on 6/19/13.
//  Copyright (c) 2013 OpenKit. All rights reserved.
//

#import "OKSpinnerCell.h"

@implementation OKSpinnerCell

@synthesize spinner;

- (id)initWithStyle:(UITableViewCellStyle)style reuseIdentifier:(NSString *)reuseIdentifier
{
    self = [super initWithStyle:style reuseIdentifier:reuseIdentifier];
    if (self) {
        // Initialization code
        CGRect cellFrame = CGRectMake(0, 0, 300, 60);
        
        [self setFrame:cellFrame];
        
        spinner = [[UIActivityIndicatorView alloc] initWithActivityIndicatorStyle:UIActivityIndicatorViewStyleGray];
        
        //Resize the spinner for horizontal view
        [spinner setAutoresizingMask:(UIViewAutoresizingFlexibleLeftMargin | UIViewAutoresizingFlexibleRightMargin)];
        [spinner setCenter:CGPointMake(self.frame.size.width/2, self.frame.size.height/2)];
        [spinner setColor:[UIColor blackColor]];
        
        [self addSubview:spinner];
        
        //Spinner cell is not selectable
        self.selectionStyle = UITableViewCellSelectionStyleNone;

    }
    return self;
}

- (void)startAnimating {
    [spinner startAnimating];
}


- (void)setSelected:(BOOL)selected animated:(BOOL)animated
{
    [super setSelected:selected animated:animated];

    // Configure the view for the selected state
}

@end
