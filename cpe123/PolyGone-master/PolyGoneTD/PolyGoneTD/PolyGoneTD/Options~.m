//
//  Options.m
//  Poly-Gone
//
//  Created by Cameron Geehr on 10/15/13.
//  Copyright (c) 2013 Cameron Geehr. All rights reserved.
//

#import "Options.h"
#import "SKSubSpriteNode1.h"
#import "SliderBlock.h"
#import "ViewController.h"

@interface Options()

@property SliderBlock *sB;
@property int BGMVolume;
@end

@implementation Options


-(id)initWithSize:(CGSize)size {
    if (self = [super initWithSize:size]) {
        /* Setup your scene here */
        
        self.backgroundColor = [SKColor colorWithRed:0.0 green:0.0 blue:0.0 alpha:1.0];
        
        SKSpriteNode *O2 = [[SKSpriteNode alloc] initWithImageNamed:@"O copy"];
        O2.position = CGPointMake(25,420);
        [self addChild:O2];
        
        SKSpriteNode *P2 = [[SKSpriteNode alloc] initWithImageNamed:@"P copy 2"];
        P2.position = CGPointMake(70,420);
        [self addChild:P2];
        
        SKSpriteNode *T = [[SKSpriteNode alloc] initWithImageNamed:@"T"];
        T.position = CGPointMake(115,420);
        [self addChild:T];
        
        SKSpriteNode *I = [[SKSpriteNode alloc] initWithImageNamed:@"I copy"];
        I.position = CGPointMake(160,420);
        [self addChild:I];
        
        SKSpriteNode *O3 = [[SKSpriteNode alloc] initWithImageNamed:@"O green"];
        O3.position = CGPointMake(205,420);
        [self addChild:O3];
        
        SKSpriteNode *N2 = [[SKSpriteNode alloc] initWithImageNamed:@"N copy"];
        N2.position = CGPointMake(250,420);
        [self addChild:N2];
        
        SKSpriteNode *S = [[SKSpriteNode alloc] initWithImageNamed:@"S"];
        S.position = CGPointMake(295,420);
        [self addChild:S];
        
        SKSpriteNode *B = [[SKSpriteNode alloc] initWithImageNamed:@"B"];
        B.position = CGPointMake(40,260);
        [self addChild:B];
        
        SKSpriteNode *G = [[SKSpriteNode alloc] initWithImageNamed:@"G copy"];
        G.position = CGPointMake(100,260);
        [self addChild:G];
        
        SKSpriteNode *M = [[SKSpriteNode alloc] initWithImageNamed:@"M"];
        M.position = CGPointMake(160,260);
        [self addChild:M];
        
        SKSpriteNode *sL = [[SKSpriteNode alloc] initWithImageNamed:@"SliderLine"];
        sL.position = CGPointMake(250,260);
        [self addChild:sL];
        
        self.sB = [[SliderBlock alloc] init];
        self.sB.position = CGPointMake(300,260);
        [self addChild:self.sB];
        self.BGMVolume = self.sB.position.x;
        
        SKAction *pause = [SKAction waitForDuration:.1];
        SKAction *updateVolume =[SKAction performSelector: @selector(volumeUpdate) onTarget:self];
        SKAction *checking = [SKAction performSelector: @selector(check) onTarget:self];
        SKAction *check = [SKAction sequence:@[pause, updateVolume, checking]];
        SKAction *checkForever = [SKAction repeatActionForever:check];
        [self runAction:checkForever];
        
        SKSpriteNode *S1 = [[SKSpriteNode alloc] initWithImageNamed:@"S copy"];
        S1.position = CGPointMake(40,160);
        [self addChild:S1];
        
        SKSpriteNode *F = [[SKSpriteNode alloc] initWithImageNamed:@"F"];
        F.position = CGPointMake(100,160);
        [self addChild:F];
        
        SKSpriteNode *X = [[SKSpriteNode alloc] initWithImageNamed:@"X"];
        X.position = CGPointMake(160,160);
        [self addChild:X];
        
        SKSpriteNode *sL1 = [[SKSpriteNode alloc] initWithImageNamed:@"SliderLine"];
        sL1.position = CGPointMake(250,160);
        [self addChild:sL1];
        
        SliderBlock *sB1 = [[SliderBlock alloc] init];
        sB1.position = CGPointMake(250,160);
        [self addChild:sB1];
        
        SKSpriteNode *B2 = [[SKSubSpriteNode1 alloc] initWithImageNamed:@"B red"];
        B2.position = CGPointMake(80,60);
        [self addChild:B2];
        
        SKSpriteNode *A = [[SKSubSpriteNode1 alloc] initWithImageNamed:@"A"];
        A.position = CGPointMake(140,60);
        [self addChild:A];
        
        SKSpriteNode *C = [[SKSubSpriteNode1 alloc] initWithImageNamed:@"C"];
        C.position = CGPointMake(200,60);
        [self addChild:C];
        
        SKSpriteNode *K = [[SKSubSpriteNode1 alloc] initWithImageNamed:@"K"];
        K.position = CGPointMake(260,60);
        [self addChild:K];
        
        
    }
    return self;
}


-(void) check{
    ViewController *vc = [[UIApplication sharedApplication] delegate].window.rootViewController;
    
    vc.backgroundMusicPlayer.Volume =  (self.BGMVolume-200.0f)/100.0f;
    //NSLog([NSString stringWithFormat:@"Volume: %d",self.BGMVolume]);
}

-(void) volumeUpdate{
    self.BGMVolume= self.sB.position.x;
}


-(void)update:(CFTimeInterval)currentTime {
    /* Called before each frame is rendered */
}

@end