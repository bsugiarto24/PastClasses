//
//  Bomb.h
//  PolyGoneTD
//
//  Created by Cameron Geehr on 11/26/13.
//  Copyright (c) 2013 Cameron Geehr. All rights reserved.
//

#import <SpriteKit/SpriteKit.h>
#import "MyScene.h"
#import "Tower.h"


@interface Bomb : SKSpriteNode
-(instancetype) init;
-(instancetype) initWithDestination:(CGPoint) destination WithLocation:(CGPoint) location;
@end
