//
//  MyScene1.h
//  PolyGoneTD
//
//  Created by Cameron Geehr on 11/14/13.
//  Copyright (c) 2013 Cameron Geehr. All rights reserved.
//

#import <SpriteKit/SpriteKit.h>
#import "Player.h"
#import "MyScene.h"

@interface MyScene2 : SKScene <SKPhysicsContactDelegate>
-(void) updatePlayerLives;

@property Player *player;
@end
