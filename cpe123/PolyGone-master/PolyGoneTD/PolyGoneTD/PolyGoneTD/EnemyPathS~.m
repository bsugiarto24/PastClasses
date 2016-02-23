//
//  EnemyPath.m
//  Poly-gone_Defense
//
//  Created Bryan Sugiarto 10/16/13.
//  Copyright (c) 2013 BNasty. All rights reserved.
//

#import "EnemyPathS.h"

@interface EnemyPathS()
@property NSMutableArray* pathPoints;
@end


@implementation EnemyPathS

-(UIColor *) pathColor { return [UIColor colorWithRed:.8 green:.8 blue:0.1 alpha:1]; }

- (instancetype) initPath
{
    self = [super init];
    
    UIBezierPath *path;
    
    path = [[UIBezierPath alloc] init];
    
    self.fillColor = [self pathColor];
    self.strokeColor = [self pathColor];
    self.lineWidth = 20.0;
    
    [path moveToPoint:CGPointMake(250, 480)];
    [path addLineToPoint:CGPointMake(250, 360)];
    
    [path moveToPoint:CGPointMake(260, 370)];
    [path addLineToPoint:CGPointMake(50, 370)];
    
    [path moveToPoint:CGPointMake(50, 380)];
    [path addLineToPoint:CGPointMake(50, 220)];
    
    [path moveToPoint:CGPointMake(270, 210)];
    [path addLineToPoint:CGPointMake(40, 210)];
    
    [path moveToPoint:CGPointMake(260, 210)];
    [path addLineToPoint:CGPointMake(260, 50)];
    
    [path moveToPoint:CGPointMake(260, 60)];
    [path addLineToPoint:CGPointMake(40, 60)];
    
    [path moveToPoint:CGPointMake(50, 0)];
    [path addLineToPoint:CGPointMake(50, 70)];
    
    for(float r = 282; r <= 320; r++)
    {
        for(float c = 0; c <= 198; c++)
        {
            CGPoint point = CGPointMake(r, c);
            NSValue *pointValue = [NSValue valueWithCGPoint:point];
            [self.pathPoints addObject:pointValue];
        }
    }

    [path closePath];
    self.path = path.CGPath;
    return self;
}

-(UIColor *) invisible { return [UIColor colorWithRed:0 green:0.0 blue:0.0 alpha:0.0]; }

- (instancetype) initEnd
{
    self = [super init];
    
    UIBezierPath *end;
    
    end = [[UIBezierPath alloc] init];
    
    self.fillColor = [self invisible];
    self.strokeColor = [self invisible];
    self.lineWidth = 1.0;
    
    [end moveToPoint:CGPointMake(40, 0)];
    [end addLineToPoint:CGPointMake(60, 0)];
    
    self.path = end.CGPath;
    SKPhysicsBody *endBody = [SKPhysicsBody bodyWithEdgeFromPoint:CGPointMake(40, 0) toPoint:CGPointMake(60, 0)];
    endBody.affectedByGravity = NO;
    endBody.categoryBitMask = endCategory;
    endBody.collisionBitMask = 0;
    endBody.contactTestBitMask = enemyCategory;
    
    
    self.physicsBody = endBody;
    return self;
}

-(NSMutableArray*) getPathPoints
{
    return self.pathPoints;
}

@end