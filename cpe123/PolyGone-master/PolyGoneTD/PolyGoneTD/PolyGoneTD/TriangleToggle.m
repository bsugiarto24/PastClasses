//
//  TriangleToggle.m
//  Poly-gone_Defense
//
//  Created by kmckinni on 10/29/13.
//  Copyright (c) 2013 kmckinni. All rights reserved.
//

#import "TriangleToggle.h"
#import "CircleNode.h"

@interface TriangleToggle ()
    @property bool toolToggle;
    @property CircleNode *node3;
@end

@implementation TriangleToggle

- (instancetype) initToolbarToggle
{
    self = [super init];
    self.toolToggle = true;
    
    [self makeTri];
    self.node3 = [[CircleNode alloc] initWithRadius:20];
    self.node3.fillColor = [UIColor colorWithRed:.6 green:.6 blue:.6 alpha:0];
    self.node3.strokeColor = [UIColor colorWithRed:.6 green:.6 blue:.6 alpha:0];

    self.node3.position = CGPointMake(300, 80);
    [self addChild:self.node3];
    return self;
}

-(void) toggle
{
    if(self.toolToggle == true)
    {
        self.toolToggle = false;
    }
    else if(self.toolToggle == false)
    {
        self.toolToggle = true;
    }
    [self makeTri];
    
}

-(void) makeTri
{
    UIBezierPath *path;
    
    path = [[UIBezierPath alloc] init];
    if(self.toolToggle == false)
    {
        [path moveToPoint:CGPointMake(290, 100)];
        [path addLineToPoint:CGPointMake(290, 60)];
        [path addLineToPoint:CGPointMake(310,80)];
        [path addLineToPoint:CGPointMake(290, 100)];
    }
    
    if(self.toolToggle == true)
    {
        [path moveToPoint:CGPointMake(310, 100)];
        [path addLineToPoint:CGPointMake(310, 60)];
        [path addLineToPoint:CGPointMake(290,80)];
        [path addLineToPoint:CGPointMake(310, 100)];
        
    }
    [path closePath];
    self.fillColor = [SKColor whiteColor];
    self.path = path.CGPath;

}

-(CircleNode*) circle
{
    return self.node3;
}

-(BOOL) touchToggle:(CGPoint)p : (SKNode*) node
{
    if([node containsPoint:p])
    {
        return true;
    }
    else return false;
}

-(BOOL) getToolToggle
{
    return self.toolToggle;
}

@end
