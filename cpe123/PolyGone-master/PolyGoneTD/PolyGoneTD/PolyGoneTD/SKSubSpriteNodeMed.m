//
//  SKSubSpriteNodeMed.m
//  PolyGoneTD
//
//  Created by bsugiart on 11/12/13.
//  Copyright (c) 2013 Cameron Geehr. All rights reserved.
//

#import "MyScene1.h"
#import "SKSubSpriteNodeMed.h"
#import "Difficulty.h"

@implementation SKSubSpriteNodeMed
-(void) touchesEnded:(NSSet *)touches withEvent:(UIEvent *)event
{

    MyScene1 * scene = [MyScene1 sceneWithSize:self.scene.view.bounds.size];
    scene.scaleMode = SKSceneScaleModeAspectFill;
    scene.player.difficulty = 1;
   
    // Present the scene.
    [self.scene.view presentScene:scene];
    
}

-(instancetype) initWithImageNamed:(NSString *)name
{

    self=[super initWithImageNamed:name];
    self.userInteractionEnabled=YES;
    return self;
}
@end
