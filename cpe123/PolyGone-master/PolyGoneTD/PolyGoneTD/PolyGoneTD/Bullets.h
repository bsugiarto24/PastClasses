//
//  Bullets.h
//  Poly-gone_Defense
//
//  Created by Kevin McKinnis on 10/17/13.
//  Copyright (c) 2013 kmckinni. All rights reserved.
//

#import <SpriteKit/SpriteKit.h>
#import "MyScene.h"
#import "Tower.h"

@interface Bullets : SKShapeNode
-(instancetype) init;
-(instancetype) initWithDestination:(CGPoint) destination WithLocation:(CGPoint) location WithType:(int) type;


@end
