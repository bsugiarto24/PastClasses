//
//  Spaceship.m
//  demo
//
//  Created by Bryan Sugiarto on 10/24/13.
//  Copyright (c) 2013 bsugiart. All rights reserved.
//

#import "SquareEnemy.h"
#import "MyScene.h"
#import "Player.h"

@interface SquareEnemy()
@property int lives;
@property int speed;
@property int dur;
@property UITouch *lastTouchLocation;

@end

@implementation SquareEnemy

-(instancetype) initWithLives:(int)lives inMap:(int)map{
    
   
    if(lives == 1) self = [super initWithImageNamed:@"Triangle.png"];
    else if(lives == 2) self = [super initWithImageNamed:@"square.gif"];
    else if(lives == 3) self = [super initWithImageNamed:@"pentagon.png"];
    else if(lives == 4) self = [super initWithImageNamed:@"hexagon.png"];
    else if(lives == 5) self = [super initWithImageNamed:@"potato.png"];
    else if(lives == 6) self = [super initWithImageNamed:@"octagon.png"];
    else if(lives > 6) self = [super initWithImageNamed:@"circle.png"];
    self.lives = lives;
    SKPhysicsBody *squareBody = [SKPhysicsBody bodyWithRectangleOfSize:CGSizeFromString(@"{40,40}")];
    squareBody.affectedByGravity = NO;
    squareBody.categoryBitMask = enemyCategory;
    squareBody.collisionBitMask = 0;
    squareBody.contactTestBitMask = bulletCategory + endCategory + tower1Category + tower2Category + tower3Category;
    self.physicsBody = squareBody;
    [self setupSquare:map];
    return self;
}

//default enemy
-(instancetype) initInMap:(int)map{
    self.lives = 10;
    self = [self initWithLives:self.lives inMap:map];
    return self;
}


-(instancetype) initWithDifficulty:(int)d inMap:(int)map{
    if(d==1){
        self = [self initWithLives:1 inMap:map];
    }
    else if(d==2){
        self = [self initWithLives:2 inMap:map];
    }
    else if(d==3){
        self = [self initWithLives:3 inMap:map];
    }
    else if(d==4){
        self = [self initWithLives:3 inMap:map];
        
    }
    else if(d==5){
        self = [self initWithLives:4 inMap:map];
        
    }
    else if(d==6){
        self = [self initWithLives:5 inMap:map];
    }
    else if(d==7){
        self = [self initWithLives:6 inMap:map];
    }
    else if(d==8){
        self = [self initWithLives:7 inMap:map];
        
    }
    else if(d==9){
        self = [self initWithLives:7 inMap:map];
        
    }
    else if(d==10){
        self = [self initWithLives:7 inMap:map];
    }
    else if(d==11){
        self = [self initWithLives:8 inMap:map];
    }
    else if(d==12){
        self = [self initWithLives:9 inMap:map];
        
    }
    else if(d==13){
        self = [self initWithLives:10 inMap:map];
    }
    else if (d<18){
        self = [self initWithLives:10+ (d-13) *2 inMap:map];
    }
    else if (d<23){
        self = [self initWithLives:20+ (d-18) *3 inMap:map];
    }
    else if (d<28){
        self = [self initWithLives:35+ (d-23) *4 inMap:map];
    }
    else if (d<33){
        self = [self initWithLives:55+ (d-28) *6 inMap:map];
    }
    else if (d<38){
        self = [self initWithLives:85+ (d-33) *8 inMap:map];
    }
    else if (d<43){
        self = [self initWithLives:125+ (d-38) *10 inMap:map];
    }
    else {
        self = [self initWithLives:175+ (d-43) *13 inMap:map];
    }
    
    return self;
}


-(void) setupSquare:(int) map
{
    self.size = CGSizeMake(20, 20);
    
    self.userInteractionEnabled =NO;
    UIBezierPath *movement = [[UIBezierPath alloc] init];
    if(map==1){
        [movement moveToPoint:CGPointMake(250, 480)];
        [movement addLineToPoint:CGPointMake(250, 420)];
        [movement addLineToPoint:CGPointMake(185, 420)];
        [movement addLineToPoint:CGPointMake(185, 360)];
        [movement addLineToPoint:CGPointMake(85, 360)];
        [movement addLineToPoint:CGPointMake(85, 470)];
        [movement addLineToPoint:CGPointMake(10, 470)];
        [movement addLineToPoint:CGPointMake(10, 190)];
        [movement addLineToPoint:CGPointMake(110, 190)];
        [movement addLineToPoint:CGPointMake(110, 285)];
        [movement addLineToPoint:CGPointMake(240, 285)];
        [movement addLineToPoint:CGPointMake(240, 90)];
        [movement addLineToPoint:CGPointMake(50, 90)];
        [movement addLineToPoint:CGPointMake(50, -5)];
        self.dur=10;
    }
    else if(map==2){
        [movement moveToPoint:CGPointMake(250, 480)];
        [movement addLineToPoint:CGPointMake(250, 370)];
        [movement addLineToPoint:CGPointMake(50, 370)];
        [movement addLineToPoint:CGPointMake(50, 210)];
        [movement addLineToPoint:CGPointMake(260, 210)];
        [movement addLineToPoint:CGPointMake(260, 60)];
        [movement addLineToPoint:CGPointMake(50, 60)];
        [movement addLineToPoint:CGPointMake(50, -5)];
        self.dur=7;
    }
    else if(map==3){
        [movement moveToPoint:CGPointMake(300, 480)];
        [movement addCurveToPoint:CGPointMake(15, -5) controlPoint1:CGPointMake(200, -400) controlPoint2:CGPointMake(100, 900)];
        [movement addLineToPoint:CGPointMake(5, -10)];
        self.dur = 5;
    }
    
    SKAction *run = [SKAction followPath: movement.CGPath duration:self.dur];
    SKAction *remove = [SKAction performSelector: @selector(remove) onTarget:self];
    SKAction *run2 = [SKAction sequence:@[run,remove]];
    [self runAction: run2];
}


-(void) removeOneLife{
    self.lives--;
    if(self.isOnFire==TRUE){
        self.size=CGSizeMake(20, 42);
        if(self.lives == 1) self.texture = [SKTexture textureWithImageNamed:@"triangleFire.png"];
        else if(self.lives == 2) self.texture = [SKTexture textureWithImageNamed:@"squareFire.png"];
        else if(self.lives == 3) self.texture = [SKTexture textureWithImageNamed:@"pentagonFire.png"];
        else if(self.lives == 4) self.texture = [SKTexture textureWithImageNamed:@"hexagonFire.png"];
        else if(self.lives == 5) self.texture = [SKTexture textureWithImageNamed:@"potatoFire.png"];
        else if(self.lives == 6) self.texture = [SKTexture textureWithImageNamed:@"octagonFire.png"];
        else if(self.lives > 6) self.texture = [SKTexture textureWithImageNamed:@"circleFire.png"];
        else if (self.lives<1) [self removeFromParent];
    }
    else{
        if(self.lives == 1) self.texture = [SKTexture textureWithImageNamed:@"Triangle.png"];
        else if(self.lives == 2) self.texture = [SKTexture textureWithImageNamed:@"square.gif"];
        else if(self.lives == 3) self.texture = [SKTexture textureWithImageNamed:@"pentagon.png"];
        else if(self.lives == 4) self.texture = [SKTexture textureWithImageNamed:@"hexagon.png"];
        else if(self.lives == 5) self.texture = [SKTexture textureWithImageNamed:@"potato.png"];
        else if(self.lives == 6) self.texture = [SKTexture textureWithImageNamed:@"octagon.png"];
        else if(self.lives > 6) self.texture = [SKTexture textureWithImageNamed:@"circle.png"];
        else if (self.lives<1) [self removeFromParent];
    }
}

-(void) remove{
    self.lives=0;
    [self removeFromParent];
}

-(BOOL)isAlive{
    if(self.lives<1)
        return false;
    return true;
}

-(void) touchesBegan:(NSSet *)touches withEvent:(UIEvent *)event{
    UITouch *touch = [touches anyObject];
    [touch locationInNode:self];
}
-(void) touchesEnded:(NSSet *)touches withEvent:(UIEvent *)event{}
-(void) touchesCancelled:(NSSet *)touches withEvent:(UIEvent *)event{}
-(void) touchesMoved:(NSSet *)touches withEvent:(UIEvent *)event{}

@end

