//This class allows the object clicked on to bring the user back to the main menu
//
//  SKSubSpriteNode1.m
//  Poly-Gone
//
//  Created by Cameron Geehr on 10/17/13.
//  Copyright (c) 2013 Cameron Geehr. All rights reserved.
//


#import "SKSubSpriteNode1.h"
#import "MainMenu.h"

@implementation SKSubSpriteNode1

-(void) touchesEnded:(NSSet *)touches withEvent:(UIEvent *)event
{
    SKScene * scene = [MainMenu sceneWithSize:self.scene.view.bounds.size];
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
