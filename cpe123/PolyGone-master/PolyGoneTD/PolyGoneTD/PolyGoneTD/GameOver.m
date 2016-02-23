//
//  GameOver.m
//  Poly-Gone
//
//  Created by Bryan Sugiarto on 11/7/13.
//  Copyright (c) 2013 Cameron Geehr. All rights reserved.
//

#import "GameOver.h"
#import "SKSubSpriteNode1.h"
#import "SKSubSpriteNodeHard.h"


@implementation GameOver

-(id)initWithSize:(CGSize)size score: (int) killed {
    if (self = [super initWithSize:size]) {
        /* Setup your scene here */
        
        self.backgroundColor = [SKColor colorWithRed:0.0 green:0.0 blue:0.0 alpha:1.0];
        
        SKSpriteNode *G = [[SKSpriteNode alloc] initWithImageNamed:@"G"];
        G.position = CGPointMake(30,400);
        G.size = CGSizeMake(50,100);
        [self addChild:G];
        
        SKSpriteNode *A = [[SKSpriteNode alloc] initWithImageNamed:@"A"];
        A.position = CGPointMake(80,400);
        A.size = CGSizeMake(50,100 );
        [self addChild:A];
        
        SKSpriteNode *M = [[SKSpriteNode alloc] initWithImageNamed:@"M yellow"];
        M.position = CGPointMake(130,400);
        M.size = CGSizeMake(50,100 );
        [self addChild:M];
        
        SKSpriteNode *E = [[SKSpriteNode alloc] initWithImageNamed:@"E copy"];
        E.position = CGPointMake(180,400);
        E.size = CGSizeMake(50,100 );
        [self addChild:E];
        
        
        SKSpriteNode *O = [[SKSpriteNode alloc] initWithImageNamed:@"O red"];
        O.position = CGPointMake(120,300);
        O.size = CGSizeMake(50,100 );
        [self addChild:O];
        
        SKSpriteNode *v = [[SKSpriteNode alloc] initWithImageNamed:@"V"];
        v.position = CGPointMake(170,300);
        v.size = CGSizeMake(50,100 );
        [self addChild:v];
        
        SKSpriteNode *Ee = [[SKSpriteNode alloc] initWithImageNamed:@"E copy"];
        Ee.position = CGPointMake(220,300);
        Ee.size = CGSizeMake(50,100 );
        [self addChild:Ee];
        
        SKSpriteNode *R = [[SKSpriteNode alloc] initWithImageNamed:@"R"];
        R.position = CGPointMake(270,300);
        R.size = CGSizeMake(50,100 );
        [self addChild:R];
        
        SKSpriteNode *ex = [[SKSpriteNode alloc] initWithImageNamed:@"!"];
        ex.position = CGPointMake(320,300);
        ex.size = CGSizeMake(50,100 );
        [self addChild:ex];
        
        SKSpriteNode *Ok = [[SKSubSpriteNode1 alloc] initWithImageNamed:@"O"];
        Ok.position = CGPointMake(CGRectGetMidX(self.frame)-20,180);
        Ok.size = CGSizeMake(35,60 );
        [self addChild:Ok];
        
        SKSpriteNode *K = [[SKSubSpriteNode1 alloc] initWithImageNamed:@"K"];
        K.position = CGPointMake(CGRectGetMidX(self.frame)+20,180);
        K.size = CGSizeMake(35,60 );
        [self addChild:K];
        
        
        SKLabelNode *score = [SKLabelNode labelNodeWithFontNamed:@"Chalkduster"];
        score.text = [NSString stringWithFormat:@"Score: %d",killed];
        score.fontSize = 15;
        score.position = CGPointMake(CGRectGetMidX(self.frame),100);
        [self addChild:score];
        
        
    }
    return self;
}


-(void)update:(CFTimeInterval)currentTime {
    /* Called before each frame is rendered */
}

@end
