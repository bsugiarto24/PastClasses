//
//  TowerOne.m
//  PolyGoneTD
//
//  Created by Kevin McKinnis on 10/31/13.
//  Copyright (c) 2013 Cameron Geehr. All rights reserved.
//

#import "TowerOne.h"
#import "CircleNode.h"
@interface TowerOne ()
//@property CGPoint lastTouchLocation;
//@property CGPoint firstTouchLocation;
@property CircleNode *circle;
@end

@implementation TowerOne

- (instancetype) init:(CGPoint) x
{
   
    self = [super init:x init1:1];

    SKPhysicsBody *towerBody = [SKPhysicsBody bodyWithCircleOfRadius:self.radius];
    towerBody.affectedByGravity = NO;
    towerBody.categoryBitMask = tower1Category;
    towerBody.collisionBitMask = 0;
    towerBody.contactTestBitMask = enemyCategory;
    self.physicsBody = towerBody;
     self.userInteractionEnabled =YES;
    return self;
}

-(instancetype) init
{
    self = [super init:1];
    
    SKPhysicsBody *towerBody = [SKPhysicsBody bodyWithCircleOfRadius:self.radius];
    towerBody.affectedByGravity = NO;
    towerBody.categoryBitMask = tower1Category;
    towerBody.collisionBitMask = 0;
    towerBody.contactTestBitMask = enemyCategory;
    self.physicsBody = towerBody;
    
    return self;
}

-(void) touchesBegan:(NSSet *)touches withEvent:(UIEvent *)event{
   /* UITouch *touch = [touches anyObject];
    self.lastTouchLocation = [touch locationInNode:self];
    self.firstTouchLocation = [touch locationInNode:self];
    self.circle.strokeColor = [UIColor colorWithRed:1 green:.9 blue:.0 alpha:1];
    self.circle.position = self.firstTouchLocation;
    [self addChild:self.circle];
    NSLog([NSString stringWithFormat:@"upgrade: %d",self.player.currency]);*/

    
}
-(void) touchesEnded:(NSSet *)touches withEvent:(UIEvent *)event{}
-(void) touchesCancelled:(NSSet *)touches withEvent:(UIEvent *)event{}
-(void) touchesMoved:(NSSet *)touches withEvent:(UIEvent *)event{}

@end
