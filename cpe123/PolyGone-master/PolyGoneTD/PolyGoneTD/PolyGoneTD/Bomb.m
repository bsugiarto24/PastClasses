//
//  Bomb.m
//  PolyGoneTD
//
//  Created by Cameron Geehr on 11/26/13.
//  Copyright (c) 2013 Cameron Geehr. All rights reserved.
//

#import "Bomb.h"

@implementation Bomb
-(instancetype) init
{
    self = [super init];
    
    SKPhysicsBody *bulletBody = [SKPhysicsBody bodyWithCircleOfRadius:10];
    bulletBody.affectedByGravity = NO;
    bulletBody.categoryBitMask = bombCategory;
    bulletBody.collisionBitMask = 0;
    bulletBody.contactTestBitMask = enemyCategory;
    
    self.physicsBody = bulletBody;
    
    return self;
}

-(instancetype) initWithDestination:(CGPoint) destination WithLocation:(CGPoint) location
{
    self = [super initWithImageNamed:@"Bomb"];
    
    self.size = CGSizeMake(15, 15);
    
    SKPhysicsBody *bulletBody = [SKPhysicsBody bodyWithCircleOfRadius:3];
    bulletBody.affectedByGravity = NO;
    bulletBody.categoryBitMask = bombCategory;
    bulletBody.collisionBitMask = 0;
    bulletBody.contactTestBitMask = enemyCategory;
    
    self.physicsBody = bulletBody;
    
    UIBezierPath *movement = [[UIBezierPath alloc] init];
    Tower *tower = [[Tower alloc] init:2];
    [movement moveToPoint:CGPointMake(location.x+tower.xOffset, location.y+tower.yOffset)];
    [movement addLineToPoint:destination];
    
        
    SKAction *move = [SKAction followPath: movement.CGPath duration:.2];
    SKAction *run = [SKAction sequence:@[move, [SKAction removeFromParent]]];
    [self runAction: run];

    
    return self;
}

@end
