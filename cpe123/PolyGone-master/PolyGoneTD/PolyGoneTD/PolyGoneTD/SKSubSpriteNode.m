//This class allows the object clicked on to bring the user to the options menu
//
//  SKSubSpriteNode.m
//  Poly-Gone
//
//  Created by Cameron Geehr on 10/17/13.
//  Copyright (c) 2013 Cameron Geehr. All rights reserved.
//

#import "SKSubSpriteNode.h"
#import "Options.h"

@implementation SKSubSpriteNode

-(void) touchesEnded:(NSSet *)touches withEvent:(UIEvent *)event
{
    
    Options * scene = [Options sceneWithSize:self.scene.view.bounds.size];
    scene.scaleMode = SKSceneScaleModeAspectFill;
    scene.backgroundMusicPlayer = nil;
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
