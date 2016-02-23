//This class allows the object clicked on to bring the user to the difficulty menu
//
//  SKSubSpriteNode2.m
//  Poly-Gone
//
//  Created by Cameron Geehr on 10/18/13.
//  Copyright (c) 2013 Cameron Geehr. All rights reserved.
//

#import "SKSubSpriteNode2.h"
#import "Difficulty.h"

@implementation SKSubSpriteNode2

-(void) touchesEnded:(NSSet *)touches withEvent:(UIEvent *)event
{
    SKScene * scene = [Difficulty sceneWithSize:self.scene.view.bounds.size];
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
