//
//  EnemyPath.m
//  Poly-gone_Defense
//
//  Created Bryan Sugiarto 10/16/13.
//  Copyright (c) 2013 BNasty. All rights reserved.
//

#import "EnemyPath.h"

@interface EnemyPath()
@property NSMutableArray* pathPoints;
@end

@implementation EnemyPath

UIBezierPath *path;

-(UIColor *) pathColor { return [UIColor colorWithRed:1 green:0.8 blue:0.4 alpha:1.0]; }

- (instancetype) initPath
{
    self = [super init];
    
    self.pathPoints = [[NSMutableArray alloc] init];

    path = [[UIBezierPath alloc] init];
    
    self.fillColor = [self pathColor];
    self.strokeColor = [self pathColor];
    self.lineWidth = 20.0;

    [path moveToPoint:CGPointMake(250, 480)];
    [path addLineToPoint:CGPointMake(250, 430)];
    
    for(float r = 245; r <= 255; r++)
    {
        for(float c = 425; c <= 480; c++)
        {
            CGPoint point = CGPointMake(r, c);
            NSValue *pointValue = [NSValue valueWithCGPoint:point];
            [self.pathPoints addObject:pointValue];
        }
    }

    
    [path moveToPoint:CGPointMake(260, 420)];
    [path addLineToPoint:CGPointMake(175, 420)];
    
    for(float r = 175; r <= 260; r++)
    {
        for(float c = 415; c <= 425; c++)
        {
            CGPoint point = CGPointMake(r, c);
            NSValue *pointValue = [NSValue valueWithCGPoint:point];
            [self.pathPoints addObject:pointValue];
        }
    }

    
    [path moveToPoint:CGPointMake(185, 410)];
    [path addLineToPoint:CGPointMake(185, 370)];
    
    for(float r = 180; r <= 190; r++)
    {
        for(float c = 365; c <= 415; c++)
        {
            CGPoint point = CGPointMake(r, c);
            NSValue *pointValue = [NSValue valueWithCGPoint:point];
            [self.pathPoints addObject:pointValue];
        }
    }

    
    [path moveToPoint:CGPointMake(195, 360)];
    [path addLineToPoint:CGPointMake(95, 360)];
    
    for(float r = 90; r <= 195; r++)
    {
        for(float c = 352; c <= 365; c++)
        {
            CGPoint point = CGPointMake(r, c);
            NSValue *pointValue = [NSValue valueWithCGPoint:point];
            [self.pathPoints addObject:pointValue];
        }
    }

    
    [path moveToPoint:CGPointMake(85, 350)];
    [path addLineToPoint:CGPointMake(85, 480)];
    
    for(float r = 80; r <= 90; r++)
    {
        for(float c = 352; c <= 480; c++)
        {
            CGPoint point = CGPointMake(r, c);
            NSValue *pointValue = [NSValue valueWithCGPoint:point];
            [self.pathPoints addObject:pointValue];
        }
    }

    
    [path moveToPoint:CGPointMake(75, 470)];
    [path addLineToPoint:CGPointMake(0, 470)];
    
    for(float r = 0; r <= 75; r++)
    {
        for(float c = 462; c <= 480; c++)
        {
            CGPoint point = CGPointMake(r, c);
            NSValue *pointValue = [NSValue valueWithCGPoint:point];
            [self.pathPoints addObject:pointValue];
        }
    }

    
    [path moveToPoint:CGPointMake(10, 470)];
    [path addLineToPoint:CGPointMake(10, 200)];
    
    for(float r = 0; r <= 18; r++)
    {
        for(float c = 195; c <= 480; c++)
        {
            CGPoint point = CGPointMake(r, c);
            NSValue *pointValue = [NSValue valueWithCGPoint:point];
            [self.pathPoints addObject:pointValue];
        }
    }

    
    [path moveToPoint:CGPointMake(0, 190)];
    [path addLineToPoint:CGPointMake(100, 190)];
    
    for(float r = 0; r <= 108; r++)
    {
        for(float c = 182; c <= 198; c++)
        {
            CGPoint point = CGPointMake(r, c);
            NSValue *pointValue = [NSValue valueWithCGPoint:point];
            [self.pathPoints addObject:pointValue];
        }
    }

    
    [path moveToPoint:CGPointMake(110, 180)];
    [path addLineToPoint:CGPointMake(110, 275)];
    
    for(float r = 102; r <= 118; r++)
    {
        for(float c = 180; c <= 280; c++)
        {
            CGPoint point = CGPointMake(r, c);
            NSValue *pointValue = [NSValue valueWithCGPoint:point];
            [self.pathPoints addObject:pointValue];
        }
    }
    
    [path moveToPoint:CGPointMake(100, 285)];
    [path addLineToPoint:CGPointMake(250, 285)];
    
    for(float r = 102; r <= 250; r++)
    {
        for(float c = 277; c <= 293; c++)
        {
            CGPoint point = CGPointMake(r, c);
            NSValue *pointValue = [NSValue valueWithCGPoint:point];
            [self.pathPoints addObject:pointValue];
        }
    }
    
    [path moveToPoint:CGPointMake(240, 275)];
    [path addLineToPoint:CGPointMake(240, 100)];
    
    for(float r = 232; r <= 248; r++)
    {
        for(float c = 95; c <= 280; c++)
        {
            CGPoint point = CGPointMake(r, c);
            NSValue *pointValue = [NSValue valueWithCGPoint:point];
            [self.pathPoints addObject:pointValue];
        }
    }
    
    [path moveToPoint:CGPointMake(250, 90)];
    [path addLineToPoint:CGPointMake(60, 90)];
    
    for(float r = 60; r <= 248; r++)
    {
        for(float c = 82; c <= 98; c++)
        {
            CGPoint point = CGPointMake(r, c);
            NSValue *pointValue = [NSValue valueWithCGPoint:point];
            [self.pathPoints addObject:pointValue];
        }
    }
    
    [path moveToPoint:CGPointMake(50, 100)];
    [path addLineToPoint:CGPointMake(50, 0)];
    
    for(float r = 42; r <= 58; r++)
    {
        for(float c = 0; c <= 98; c++)
        {
            CGPoint point = CGPointMake(r, c);
            NSValue *pointValue = [NSValue valueWithCGPoint:point];
            [self.pathPoints addObject:pointValue];
        }
    }
    
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
