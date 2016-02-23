//
//  Tower.h
//  PolyGoneTD
//
//  Created by Cameron Geehr on 10/29/13.
//  Copyright (c) 2013 Cameron Geehr. All rights reserved.
//

#import <SpriteKit/SpriteKit.h>
#import "MyScene.h"
#import "Player.h"

@interface Tower : SKSpriteNode
@property int price;
@property int radius;
@property Player *player;
@property int xOffset;
@property int yOffset;
@property int towerType;
@property NSMutableArray *enemiesInRange;
-(instancetype) init:(CGPoint) point init1:(int) towerType;
-(instancetype) init:(int) towerType;

@end
