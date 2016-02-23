//
//  Toolbar.m
//  Poly-gone_Defense
//
//  Created by Kevin McKinnis on 10/17/13.
//  Copyright (c) 2013 kmckinni. All rights reserved.
//

#import "Toolbar.h"
#import "CircleNode.h"
#import "TowerToolbar1.h"
#import "TowerToolbar2.h"
#import "TowerToolbar3.h"

@interface Toolbar ()
@property TowerToolbar1 *t1;
@property TowerToolbar2 *t2;
@property TowerToolbar3 *t3;
@property CGPoint point;
@property CGPoint pointT1;
@property CGPoint pointT2;
@property CGPoint pointT3;
@property BOOL tool;
@end

@implementation Toolbar



-(instancetype) init
{
    self = [super init];
    
    self.tool = true;
    self.point = CGPointMake(1000, 1000);
    self.pointT1 = CGPointMake(300, 50);
    self.pointT2 = CGPointMake(300, 100);
    self.pointT3 = CGPointMake(300, 150);
    
    self.t1 = [[TowerToolbar1 alloc] init];
    self.t1.position = self.pointT1;
    self.t1.size = CGSizeMake(25, 25);
    self.t2 = [[TowerToolbar2 alloc] init];
    self.t2.position = self.pointT2;
    self.t2.size = CGSizeMake(25, 25);
    self.t3 = [[TowerToolbar3 alloc] init];
    self.t3.position = self.pointT3;
    self.t3.size = CGSizeMake(25, 25);
    
    SKLabelNode *t1price = [SKLabelNode labelNodeWithFontNamed:@"Chalkduster"];
    
    t1price.text = @"20";
    t1price.fontSize = 12;
    t1price.position = CGPointMake(300, 165);
    
    [self addChild:t1price];
    
    SKLabelNode *t2price = [SKLabelNode labelNodeWithFontNamed:@"Chalkduster"];
    
    t2price.text = @"30";
    t2price.fontSize = 12;
    t2price.position = CGPointMake(300, 115);
    
    [self addChild:t2price];
    
    SKLabelNode *t3price = [SKLabelNode labelNodeWithFontNamed:@"Chalkduster"];
    
    t3price.text = @"10";
    t3price.fontSize = 12;
    t3price.position = CGPointMake(300, 65);
    
    [self addChild:t3price];
    
    [self makeTool];
    self.userInteractionEnabled = YES;
    
    return self;
}

-(SKSpriteNode*) getTowerToolbar3
{
    return self.t3;
}

-(SKSpriteNode*) getTowerToolbar2
{
    return self.t2;
}

-(SKSpriteNode*) getTowerToolbar1
{
    return self.t1;
}

- (void) makeTool
{
    UIBezierPath *path;
    path = [[UIBezierPath alloc] init];
    self.fillColor = [UIColor colorWithRed:.6 green:.6 blue:.6 alpha:.5];
    self.strokeColor = [UIColor colorWithRed:.6 green:.6 blue:.6 alpha:.5];
    self.lineWidth = 40.0;
    self.t1.position = self.pointT1;
    self.t2.position = self.pointT2;
    self.t3.position = self.pointT3;
    
    [path moveToPoint:CGPointMake(300, 0)];
    [path addLineToPoint:CGPointMake(300, 200)];
    [self addChild:self.t1];
    [self addChild:self.t2];
    [self addChild:self.t3];
    
    self.path = path.CGPath;
}

- (void) makeTool2
{
    UIBezierPath *path;
    path = [[UIBezierPath alloc] init];
    self.fillColor = [UIColor colorWithRed:.6 green:.6 blue:.6 alpha:.5];
    self.strokeColor = [UIColor colorWithRed:.6 green:.6 blue:.6 alpha:.5];
    self.lineWidth = 40.0;
    if(self.tool == false)
    {
        self.fillColor = [UIColor colorWithRed:.6 green:.6 blue:.6 alpha:0];
        self.strokeColor = [UIColor colorWithRed:.6 green:.6 blue:.6 alpha:0];
        self.lineWidth = 40.0;
        self.t1.position = self.point;
        self.t2.position = self.point;
        self.t3.position = self.point;
    }
    
    if(self.tool == true)
    {
        self.fillColor = [UIColor colorWithRed:.6 green:.6 blue:.6 alpha:.5];
        self.strokeColor = [UIColor colorWithRed:.6 green:.6 blue:.6 alpha:.5];
        self.lineWidth = 40.0;
        self.t1.position = CGPointMake(300, 150);
        self.t2.position = CGPointMake(300, 200);
        self.t3.position = CGPointMake(300, 250);
    }
    
    [path moveToPoint:CGPointMake(300, 50)];
    [path addLineToPoint:CGPointMake(300, 300)];
    
    self.path = path.CGPath;
}

-(void)touchesBegan:(NSSet *)touches withEvent:(UIEvent *)event {
    // Called when a touch begins
    
       
}
@end
