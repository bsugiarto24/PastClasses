//
//  Toolbar.h
//  Poly-gone_Defense
//
//  Created by Kevin McKinnis on 10/17/13.
//  Copyright (c) 2013 kmckinni. All rights reserved.
//

#import <SpriteKit/SpriteKit.h>

@interface Toolbar : SKShapeNode

- (instancetype) init;
- (void) makeTool;
-(SKSpriteNode*) getTowerToolbar1;
-(SKSpriteNode*) getTowerToolbar2;
-(SKSpriteNode*) getTowerToolbar3;
-(void)touchesBegan:(NSSet *)touches withEvent:(UIEvent *)event;

@end