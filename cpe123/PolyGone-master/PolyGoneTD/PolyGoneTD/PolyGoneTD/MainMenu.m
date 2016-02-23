//
//  MainMenu.m
//  Poly-Gone
//
//  Created by Cameron Geehr on 10/15/13.
//  Copyright (c) 2013 Cameron Geehr. All rights reserved.
//

#import "MainMenu.h"
#import "SKSubSpriteNode.h"
#import "SKSubSpriteNodeHelp.h"


@implementation MainMenu

-(id)initWithSize:(CGSize)size {    
    if (self = [super initWithSize:size]) {
        /* Setup your scene here */
        
        self.backgroundColor = [SKColor colorWithRed:0.0 green:0.0 blue:0.0 alpha:1.0];
        
        SKSpriteNode *P = [[SKSpriteNode alloc] initWithImageNamed:@"P"];
        P.position = CGPointMake(40,410);
        [self addChild:P];
        
        SKSpriteNode *O = [[SKSpriteNode alloc] initWithImageNamed:@"O"];
        O.position = CGPointMake(119,410);
        [self addChild:O];
        
        SKSpriteNode *L = [[SKSpriteNode alloc] initWithImageNamed:@"L"];
        L.position = CGPointMake(198,410);
        [self addChild:L];
        
        SKSpriteNode *Y = [[SKSpriteNode alloc] initWithImageNamed:@"Y"];
        Y.position = CGPointMake(257,410);
        [self addChild:Y];
        
        SKSpriteNode *dash = [[SKSpriteNode alloc] initWithImageNamed:@"-"];
        dash.position = CGPointMake(296,400);
        [self addChild:dash];
        
        SKSpriteNode *G = [[SKSpriteNode alloc] initWithImageNamed:@"G"];
        G.position = CGPointMake(40,300);
        [self addChild:G];
        
        SKSpriteNode *O1 = [[SKSpriteNode alloc] initWithImageNamed:@"O"];
        O1.position = CGPointMake(120,300);
        [self addChild:O1];

        SKSpriteNode *N = [[SKSpriteNode alloc] initWithImageNamed:@"N"];
        N.position = CGPointMake(200,300);
        [self addChild:N];

        SKSpriteNode *E = [[SKSpriteNode alloc] initWithImageNamed:@"E"];
        E.position = CGPointMake(280,300);
        [self addChild:E];
        
        SKSpriteNode *P1 = [[SKSubSpriteNodeHelp alloc] initWithImageNamed:@"P copy"];
        P1.position = CGPointMake(70,170);
        [self addChild:P1];
        
        SKSpriteNode *L1 = [[SKSubSpriteNodeHelp alloc] initWithImageNamed:@"L copy"];
        L1.position = CGPointMake(125,170);
        [self addChild:L1];
        
        SKSpriteNode *A = [[SKSubSpriteNodeHelp alloc] initWithImageNamed:@"A"];
        A.position = CGPointMake(180,170);
        [self addChild:A];
        
        SKSpriteNode *Y1 = [[SKSubSpriteNodeHelp alloc] initWithImageNamed:@"Y copy"];
        Y1.position = CGPointMake(220,170);
        [self addChild:Y1];
        
        SKSpriteNode *ex = [[SKSubSpriteNodeHelp alloc] initWithImageNamed:@"!"];
        ex.position = CGPointMake(260,170);
        [self addChild:ex];
        
        SKSpriteNode *O2 = [[SKSubSpriteNode alloc] initWithImageNamed:@"O copy"];
        O2.position = CGPointMake(25,90);
        [self addChild:O2];
        
        SKSpriteNode *P2 = [[SKSubSpriteNode alloc] initWithImageNamed:@"P copy 2"];
        P2.position = CGPointMake(70,90);
        [self addChild:P2];
        
        SKSpriteNode *T = [[SKSubSpriteNode alloc] initWithImageNamed:@"T"];
        T.position = CGPointMake(115,90);
        [self addChild:T];
        
        SKSpriteNode *I = [[SKSubSpriteNode alloc] initWithImageNamed:@"I copy"];
        I.position = CGPointMake(160,90);
        [self addChild:I];
        
        SKSpriteNode *O3 = [[SKSubSpriteNode alloc] initWithImageNamed:@"O green"];
        O3.position = CGPointMake(205,90);
        [self addChild:O3];
        
        SKSpriteNode *N2 = [[SKSubSpriteNode alloc] initWithImageNamed:@"N copy"];
        N2.position = CGPointMake(250,90);
        [self addChild:N2];
        
        SKSpriteNode *S = [[SKSubSpriteNode alloc] initWithImageNamed:@"S"];
        S.position = CGPointMake(295,90);
        [self addChild:S];
    }
    return self;
}


-(void)update:(CFTimeInterval)currentTime {
    /* Called before each frame is rendered */
}

@end
