//
//  EnemyPath3.m
//  Poly-gone_Defense
//
//  Created Bryan Sugiarto 10/16/13.
//  Copyright (c) 2013 BNasty. All rights reserved.
//

#import "EnemyPath3.h"

@interface EnemyPath3()
@property NSMutableArray* pathPoints;
@end


@implementation EnemyPath3

-(UIColor *) pathColor { return [UIColor colorWithRed:0 green:.1 blue:1 alpha:1.0]; }

- (instancetype) initPath
{
    self = [super init];
    
    UIBezierPath *path;
    
    path = [[UIBezierPath alloc] init];
    
    self.strokeColor = [self pathColor];
    self.lineWidth = 20.0;
    
    [path moveToPoint:CGPointMake(300, 480)];
    [path addCurveToPoint:CGPointMake(15, 0) controlPoint1:CGPointMake(200, -400) controlPoint2:CGPointMake(100, 900)];
    
    for(float r = 282; r <= 320; r++)
    {
        for(float c = 0; c <= 198; c++)
        {
            CGPoint point = CGPointMake(r, c);
            NSValue *pointValue = [NSValue valueWithCGPoint:point];
            [self.pathPoints addObject:pointValue];
        }
    }
    
    //[path closePath];
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
    
    [end moveToPoint:CGPointMake(5, 0)];
    [end addLineToPoint:CGPointMake(25, 0)];
    
    self.path = end.CGPath;
    SKPhysicsBody *endBody = [SKPhysicsBody bodyWithEdgeFromPoint:CGPointMake(5, 0) toPoint:CGPointMake(25, 0)];
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