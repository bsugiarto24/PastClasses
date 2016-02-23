//
//  SKSubSpriteNodeEasy.m
//  PolyGoneTD
//
//  Created by bsugiart on 11/12/13.
//  Copyright (c) 2013 Cameron Geehr. All rights reserved.
//

#import "MyScene.h"
#import "SKSubSpriteNodeEasy.h"
#import "Difficulty.h"

@implementation SKSubSpriteNodeEasy



-(void) touchesEnded:(NSSet *)touches withEvent:(UIEvent *)event
{
    
  
    MyScene *scene = [MyScene sceneWithSize:self.scene.view.bounds.size];
    scene.player.difficulty = 1;
    scene.scaleMode = SKSceneScaleModeAspectFill;
    
    
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
