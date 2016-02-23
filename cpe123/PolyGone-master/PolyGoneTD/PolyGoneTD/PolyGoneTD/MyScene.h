//
//  MyScene.h
//  Poly-gone_Defense
//

//  Copyright (c) 2013 kmckinni. All rights reserved.
//

#import <SpriteKit/SpriteKit.h>
#import "Player.h"
enum { bulletCategory = 1, fireBulletCategory = 2, bombCategory = 4, explosionCategory = 8, endCategory = 16, tower1Category = 32, tower2Category = 64, tower3Category = 128, enemyCategory = 256};

@interface MyScene : SKScene <SKPhysicsContactDelegate>
-(void) updatePlayerLives;

@property Player *player;

@end
