//
//  EnemyPath3.h
//  PolyGoneTD
//
//  Created by Cameron Geehr on 11/14/13.
//  Copyright (c) 2013 Cameron Geehr. All rights reserved.
//

#import <SpriteKit/SpriteKit.h>
#import "MyScene2.h"

@interface EnemyPath3 : SKShapeNode

- (instancetype) initPath;
- (instancetype) initEnd;
-(NSMutableArray*) getPathPoints;

@end
