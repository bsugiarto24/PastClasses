//
//  Bullets.m
//  Poly-gone_Defense
//
//  Created by Kevin McKinnis on 10/17/13.
//  Copyright (c) 2013 kmckinni. All rights reserved.
//

#import "Bullets.h"

@implementation Bullets

-(instancetype) init
{
    self = [super init];
    //fuschia
    self.fillColor = [UIColor colorWithRed:1 green:.0 blue:1 alpha:1];
    self.strokeColor = [UIColor colorWithRed:1 green:.0 blue:1 alpha:1];
    self.lineWidth = 3.0;
    
    UIBezierPath *path;
    path = [[UIBezierPath alloc] init];
    
    [path moveToPoint:CGPointMake(0, 0)];
    [path addLineToPoint:CGPointMake(3, 0)];
    
    SKPhysicsBody *bulletBody = [SKPhysicsBody bodyWithRectangleOfSize:CGSizeFromString(@"{3.0,3.0}")];
    bulletBody.affectedByGravity = NO;
    bulletBody.categoryBitMask = bulletCategory;
    bulletBody.collisionBitMask = 0;
    bulletBody.contactTestBitMask = enemyCategory;

    self.physicsBody = bulletBody;
    
    self.path = path.CGPath;
    return self;
}

-(instancetype) initWithDestination:(CGPoint) destination WithLocation:(CGPoint) location WithType:(int) type;
{
    self = [super init];
    //fuschia
    self.fillColor = [UIColor colorWithRed:1 green:.0 blue:1 alpha:1];
    self.strokeColor = [UIColor colorWithRed:1 green:.0 blue:1 alpha:1];
    self.lineWidth = 3.0;
    
    UIBezierPath *path;
    path = [[UIBezierPath alloc] init];
    
    [path moveToPoint:CGPointMake(0, 0)];
    [path addLineToPoint:CGPointMake(3, 0)];
    
    SKPhysicsBody *bulletBody = [SKPhysicsBody bodyWithRectangleOfSize:CGSizeFromString(@"{3.0,3.0}")];
    bulletBody.affectedByGravity = NO;
    bulletBody.categoryBitMask = bulletCategory;
    bulletBody.collisionBitMask = 0;
    bulletBody.contactTestBitMask = enemyCategory;
    
    self.physicsBody = bulletBody;
    
    self.path = path.CGPath;
    
    UIBezierPath *movement = [[UIBezierPath alloc] init];
    Tower *tower = [[Tower alloc] init:type];
    [movement moveToPoint:CGPointMake(location.x+tower.xOffset, location.y+tower.yOffset)];
    [movement addLineToPoint:destination];
    
    SKAction *move = [SKAction followPath: movement.CGPath duration:.2];
    SKAction *run = [SKAction sequence:@[move, [SKAction removeFromParent]]];
    [self runAction: run];

    return self;
}





@end