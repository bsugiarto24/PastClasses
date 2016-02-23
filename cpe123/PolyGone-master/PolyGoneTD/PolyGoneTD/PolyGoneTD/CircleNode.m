//
//  CircleNode.m
//  Lab4-3
//
//  Created by Kevin McKinnis on 10/22/13.
//  Copyright (c) 2013 kmckinni. All rights reserved.
//

#import "CircleNode.h"

@implementation CircleNode

- (instancetype) init
{
    return [self initWithRadius:50];
}

- (instancetype) initWithRadius: (double) radius
{
    self = [super init];
    
    UIBezierPath *path;
    path = [[UIBezierPath alloc] init];
    
    [path addArcWithCenter:CGPointMake(0, 0) radius:radius startAngle:0 endAngle:2 * M_PI clockwise:NO];
    
    self.path = path.CGPath;
    
    return self;
}

@end
