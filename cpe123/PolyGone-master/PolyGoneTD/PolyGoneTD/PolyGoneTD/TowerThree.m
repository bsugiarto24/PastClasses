//
//  TowerThree.m
//  PolyGoneTD
//
//  Created by Kevin McKinnis on 10/31/13.
//  Copyright (c) 2013 Cameron Geehr. All rights reserved.
//

#import "TowerThree.h"

@implementation TowerThree

- (instancetype) init:(CGPoint) x
{
    self = [super init:x init1:3];
    
    SKPhysicsBody *towerBody = [SKPhysicsBody bodyWithCircleOfRadius:self.radius];
    towerBody.affectedByGravity = NO;
    towerBody.categoryBitMask = tower3Category;
    towerBody.collisionBitMask = 0;
    towerBody.contactTestBitMask = enemyCategory;
    self.physicsBody = towerBody;
    
    return self;
}

-(instancetype) init
{
    self = [super init:3];
    
    SKPhysicsBody *towerBody = [SKPhysicsBody bodyWithCircleOfRadius:self.radius];
    towerBody.affectedByGravity = NO;
    towerBody.categoryBitMask = tower3Category;
    towerBody.collisionBitMask = 0;
    towerBody.contactTestBitMask = enemyCategory;
    self.physicsBody = towerBody;
    
    return self;
}

@end
