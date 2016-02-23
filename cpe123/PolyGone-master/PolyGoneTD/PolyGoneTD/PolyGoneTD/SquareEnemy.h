//
//  SquareEnemy.h
//  PolyGoneTD
//
//  Created by Bryan Sugiarto on 10/29/13.
//  Copyright (c) 2013 Cameron Geehr. All rights reserved.
//

#import <SpriteKit/SpriteKit.h>
#import "MyScene.h"

@interface SquareEnemy : SKSpriteNode

-(void) removeOneLife;
-(int) lives;
-(int) speed;
-(instancetype) initWithDifficulty:(int)d inMap: (int) map;
-(instancetype) initInMap:(int) map;
@property BOOL isOnFire;
-(void) remove;
-(BOOL)isAlive;

@end
