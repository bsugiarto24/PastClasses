//
//  GameOver.m
//  Poly-Gone
//
//  Created by Bryan Sugiarto on 11/7/13.
//  Copyright (c) 2013 Cameron Geehr. All rights reserved.
//

#import "Help.h"
#import "SKSubSpriteNode2.h"
#import "SKSubSpriteNodeHelp.h"


@implementation Help

-(id)initWithSize:(CGSize)size {
    if (self = [super initWithSize:size]) {
        /* Setup your scene here */
        
        self.backgroundColor = [SKColor colorWithRed:0.0 green:0.0 blue:0.0 alpha:1.0];
        
       
        SKLabelNode *score = [SKLabelNode labelNodeWithFontNamed:@"Chalkduster"];
        score.text = [NSString stringWithFormat:@"Drag towers from "];
        score.fontSize = 15;
        score.position = CGPointMake(CGRectGetMidX(self.frame),350);
        [self addChild:score];
        
        SKLabelNode *score5 = [SKLabelNode labelNodeWithFontNamed:@"Chalkduster"];
        score5.text = [NSString stringWithFormat:@"the bottom right to the screen"];
        score5.fontSize = 15;
        score5.position = CGPointMake(CGRectGetMidX(self.frame),325);
        [self addChild:score5];
        
        SKLabelNode *score4 = [SKLabelNode labelNodeWithFontNamed:@"Chalkduster"];
        score4.text = [NSString stringWithFormat:@"and get as many kills as you can!"];
        score4.fontSize = 15;
        score4.position = CGPointMake(CGRectGetMidX(self.frame),300);
        [self addChild:score4];
        
        SKLabelNode *score2 = [SKLabelNode labelNodeWithFontNamed:@"Chalkduster"];
        score2.text = [NSString stringWithFormat:@"This an endless "];
        score2.fontSize = 15;
        score2.position = CGPointMake(CGRectGetMidX(self.frame),400);
        [self addChild:score2];
        
        SKLabelNode *score3 = [SKLabelNode labelNodeWithFontNamed:@"Chalkduster"];
        score3.text = [NSString stringWithFormat:@"Polygon tower defense game. "];
        score3.fontSize = 15;
        score3.position = CGPointMake(CGRectGetMidX(self.frame),375);
        [self addChild:score3];
        
        
        
        SKSpriteNode *Ok = [[SKSubSpriteNode2 alloc] initWithImageNamed:@"O"];
        Ok.position = CGPointMake(CGRectGetMidX(self.frame)-20,180);
        Ok.size = CGSizeMake(35,60 );
        [self addChild:Ok];
        
        SKSpriteNode *K = [[SKSubSpriteNode2 alloc] initWithImageNamed:@"K"];
        K.position = CGPointMake(CGRectGetMidX(self.frame)+20,180);
        K.size = CGSizeMake(35,60 );
        [self addChild:K];
        
        

        
    }
    return self;
}


-(void)update:(CFTimeInterval)currentTime {
    /* Called before each frame is rendered */
}

@end
