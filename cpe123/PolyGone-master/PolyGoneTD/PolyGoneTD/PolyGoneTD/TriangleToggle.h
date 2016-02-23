//
//  TriangleToggle.h
//  Poly-gone_Defense
//
//  Created by kmckinni on 10/29/13.
//  Copyright (c) 2013 kmckinni. All rights reserved.
//

#import <SpriteKit/SpriteKit.h>
#import "CircleNode.h"

@interface TriangleToggle : SKShapeNode

- (instancetype) initToolbarToggle;
- (void) toggle;
- (CircleNode*) circle;
- (BOOL) touchToggle:(CGPoint)p : (SKNode*) node;
- (BOOL) getToolToggle;

@end
