//
//  FireBullet.h
//  PolyGoneTD
//
//  Created by Cameron Geehr on 12/3/13.
//  Copyright (c) 2013 Cameron Geehr. All rights reserved.
//

#import <SpriteKit/SpriteKit.h>
#import "MyScene.h"
#import "Tower.h"

@interface FireBullet : SKShapeNode

-(instancetype) init;
-(instancetype) initWithDestination:(CGPoint) destination WithLocation:(CGPoint) location WithType:(int) type;


@end
