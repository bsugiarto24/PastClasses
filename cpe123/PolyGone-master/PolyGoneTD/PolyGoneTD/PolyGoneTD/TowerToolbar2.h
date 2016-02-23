//
//  TowerToolbar2.h
//  PolyGoneTD
//
//  Created by Kevin McKinnis on 10/31/13.
//  Copyright (c) 2013 Cameron Geehr. All rights reserved.
//

#import "TowerTwo.h"
#import "CircleNode.h"
#import "Player.h"
#import <SpriteKit/SpriteKit.h>

@interface TowerToolbar2 : SKSpriteNode
@property Player *player;

- (instancetype) init;
-(void)touchesBegan:(NSSet *)touches withEvent:(UIEvent *)event;
-(void) touchesMoved:(NSSet *)touches withEvent:(UIEvent *)event;
-(void) touchesCancelled:(NSSet *)touches withEvent:(UIEvent *)event;
-(void) touchesEnded:(NSSet *)touches withEvent:(UIEvent *)event;
-(NSMutableArray*) getTowerList;

@end
