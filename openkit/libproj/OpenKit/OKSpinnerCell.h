//
//  OKSpinnerCell.h
//  OpenKit
//
//  Created by Suneet Shah on 6/19/13.
//  Copyright (c) 2013 OpenKit. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface OKSpinnerCell : UITableViewCell

@property (nonatomic, strong) UIActivityIndicatorView *spinner;

- (void)startAnimating;

@end
