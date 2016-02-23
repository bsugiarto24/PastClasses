//
//  FireBullet.m
//  PolyGoneTD
//
//  Created by Cameron Geehr on 12/3/13.
//  Copyright (c) 2013 Cameron Geehr. All rights reserved.
//

#import "FireBullet.h"

@implementation FireBullet

-(instancetype) init
{
    self = [super init];
    //orange
    self.fillColor = [UIColor colorWithRed:1 green:.5 blue:0 alpha:1];
    self.strokeColor = [UIColor colorWithRed:1 green:.5 blue:0 alpha:1];
    self.lineWidth = 3.0;
    
    UIBezierPath *path;
    path = [[UIBezierPath alloc] init];
    
    [path moveToPoint:CGPointMake(0, 0)];
    [path addLineToPoint:CGPointMake(3, 0)];
    
    SKPhysicsBody *bulletBody = [SKPhysicsBody bodyWithRectangleOfSize:CGSizeFromString(@"{3.0,3.0}")];
    bulletBody.affectedByGravity = NO;
    bulletBody.categoryBitMask = fireBulletCategory;
    bulletBody.collisionBitMask = 0;
    bulletBody.contactTestBitMask = enemyCategory;
    
    self.physicsBody = bulletBody;
    
    self.path = path.CGPath;
    return self;
}

-(instancetype) initWithDestination:(CGPoint) destination WithLocation:(CGPoint) location WithType:(int) type;
{
    self = [super init];
    //orange
    self.fillColor = [UIColor colorWithRed:1 green:.1 blue:0 alpha:1];
    self.strokeColor = [UIColor colorWithRed:1 green:.3 blue:0 alpha:1];
    self.lineWidth = 3.0;
    
    UIBezierPath *path;
    path = [[UIBezierPath alloc] init];
    
    [path moveToPoint:CGPointMake(0, 0)];
    [path addLineToPoint:CGPointMake(3, 0)];
    
    SKPhysicsBody *bulletBody = [SKPhysicsBody bodyWithRectangleOfSize:CGSizeFromString(@"{3.0,3.0}")];
    bulletBody.affectedByGravity = NO;
    bulletBody.categoryBitMask = fireBulletCategory;
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