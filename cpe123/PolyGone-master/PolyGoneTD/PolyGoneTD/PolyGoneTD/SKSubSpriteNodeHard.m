//This class allows the object clicked on to bring the user to the map screen
//
//  SKSubSpriteNode3.m
//  Poly-Gone
//
//  Created by Cameron Geehr on 10/22/13.
//  Copyright (c) 2013 Cameron Geehr. All rights reserved.
//

#import "SKSubSpriteNodeHard.h"
#import "MyScene2.h"

@implementation SKSubSpriteNodeHard

-(void) touchesEnded:(NSSet *)touches withEvent:(UIEvent *)event
{
    MyScene2 * scene = [MyScene2 sceneWithSize:self.scene.view.bounds.size];
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
