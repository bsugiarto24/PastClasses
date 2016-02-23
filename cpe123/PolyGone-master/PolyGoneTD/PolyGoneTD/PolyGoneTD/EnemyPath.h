//
//  EnemyPath.h
//  Poly-gone_Defense
//
//  Created by Kevin McKinnis on 10/16/13.
//  Copyright (c) 2013 kmckinni. All rights reserved.
//

#import <SpriteKit/SpriteKit.h>
#import "MyScene.h"

@interface EnemyPath : SKShapeNode

- (instancetype) initPath;
- (instancetype) initEnd;
-(NSMutableArray*) getPathPoints;

@end
