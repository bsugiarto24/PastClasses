//
//  MyScene1.m
//  Poly-gone_Defense
//
//  Created by Kevin McKinnis on 10/16/13.
//  Copyright (c) 2013 kmckinni. All rights reserved.
//

#import "MyScene2.h"
#import "EnemyPath3.h"
#import "SquareEnemy.h"
#import "Toolbar.h"
#import "CircleNode.h"
#import "TriangleToggle.h"
#import "Tower.h"
#import "TowerOne.h"
#import "TowerTwo.h"
#import "TowerThree.h"
#import "Bullets.h"
#import "TowerToolbar1.h"
#import "TowerToolbar2.h"
#import "TowerToolbar3.h"
#import "GameOver.h"
#import "Bomb.h"
#import "Difficulty.h"
#import "SKSubSpriteNodeExit.h"

@interface MyScene2()
@property int numberOfLives;
@property int countTT3;
@property int countTT2;
@property int countTT1;
@property int objectsInArray1;
@property int objectsInArray2;
@property int objectsInArray3;
@property int currencyCount;
@property SKLabelNode* myLives;
@property SKLabelNode* myMoney;
@property SKLabelNode* waveLabel;
@property NSMutableArray *enemies;
@property NSMutableArray *towers1;
@property NSMutableArray *towers2;
@property NSMutableArray *towers3;
@property SKAction *splat;
@property SKAction *bomb;
@property SKAction *fireball;
@property Toolbar *tool;
@property Bullets *bullet;
@property SquareEnemy *enemy;
@property int count;
@property int difficulty;
@property int timeCount;
@end


@implementation MyScene2

+(UIColor *) pathColor { return [UIColor colorWithRed:1 green:0.8 blue:0.4 alpha:1.0]; }

- (void)didEvaluateActions
{
    //if(
    self.count++;
}

-(id)initWithSize:(CGSize)size {
    if (self = [super initWithSize:size]) {
        
        
        self.enemies = [[NSMutableArray alloc]init];
        //initialize sound
        self.splat= [SKAction playSoundFileNamed:@"splat1a.wav" waitForCompletion:YES];
        self.fireball= [SKAction playSoundFileNamed:@"fireball.mp3" waitForCompletion:YES];
        self.bomb= [SKAction playSoundFileNamed:@"Bomb 2.mp3" waitForCompletion:YES];
        /* Setup your scene here */
        self.player = [[Player alloc] init];
        self.player.lives = 50;
        self.player.currency = 20;
        
        self.backgroundColor = [SKColor colorWithRed:0 green:0.8 blue:0.0 alpha:1.0];
        self.physicsWorld.contactDelegate = self;
        
        EnemyPath3 *path = [[EnemyPath3 alloc] initPath];
        [self addChild:path];
        
        EnemyPath3 *end = [[EnemyPath3 alloc] initEnd];
        [self addChild:end];
        
        
        self.tool = [[Toolbar alloc] init];
        [self addChild:self.tool];
        
        //        //this tests the bullet
        //        self.bullet = [[Bullets alloc] init];
        //        self.bullet.position = CGPointMake(110, 200);
        //        [self addChild:self.bullet];
        
        //adding enemies
        SKAction *createRock = [SKAction performSelector: @selector(addEnemy) onTarget:self];
        SKAction *randomPause = [SKAction waitForDuration:.2 withRange:.1];
        SKAction *createRockSeq = [SKAction sequence:@[createRock, randomPause]];
        //SKAction *createRocksForever = [SKAction repeatAction:createRockSeq count:10];
        
        
        SKAction *pauses = [SKAction waitForDuration:10];
        SKAction *harder = [SKAction performSelector: @selector(increaseDifficulty) onTarget:self];
        
        SKAction *run = [SKAction sequence:@[createRockSeq,createRockSeq,createRockSeq,createRockSeq
                                             ,createRockSeq,createRockSeq,createRockSeq,createRockSeq,createRockSeq,createRockSeq,createRockSeq,createRockSeq,createRockSeq,
                                             createRockSeq,createRockSeq,createRockSeq,createRockSeq,
                                             createRockSeq,createRockSeq,createRockSeq,pauses,harder]];
        SKAction *runForever = [SKAction repeatActionForever:run];
        [self runAction: runForever];
        
        
        
        
        //label for number of lives
        self.myLives = [SKLabelNode labelNodeWithFontNamed:@"Chalkduster"];
        self.myLives.text = [NSString stringWithFormat:@"Lives: %d",self.player.lives];
        self.myLives.fontSize = 15;
        self.myLives.position = CGPointMake(CGRectGetMidX(self.frame),30);
        [self addChild:self.myLives];
        
        //label for currency
        self.myMoney = [SKLabelNode labelNodeWithFontNamed:@"Chalkduster"];
        self.myMoney.text = [NSString stringWithFormat:@"Money: $%d",self.player.currency];
        self.myMoney.fontSize = 15;
        self.myMoney.position = CGPointMake(CGRectGetMidX(self.frame),10);
        [self addChild:self.myMoney];
        
        //quit button
        
        SKSpriteNode *E = [[SKSubSpriteNodeExit alloc] initWithImageNamed:@"E copy" ];
        E.size = CGSizeMake(10, 20);
        E.position = CGPointMake(285,10);
        [self addChild:E];
        
        
        SKSpriteNode *X = [[SKSubSpriteNodeExit alloc] initWithImageNamed:@"X"];
        X.size = CGSizeMake(10, 20);
        X.position = CGPointMake(295,10);
        [self addChild:X];
        
        SKSpriteNode *I = [[SKSubSpriteNodeExit alloc] initWithImageNamed:@"I copy"];
        I.size = CGSizeMake(10, 20);
        I.position = CGPointMake(305,10);
        [self addChild:I];
        
        SKSpriteNode *T = [[SKSubSpriteNodeExit alloc] initWithImageNamed:@"T"];
        T.size = CGSizeMake(10, 20);
        T.position = CGPointMake(315,10);
        [self addChild:T];
        
        //label for Waves
        self.waveLabel = [SKLabelNode labelNodeWithFontNamed:@"Chalkduster"];
        self.waveLabel.text = [NSString stringWithFormat:@"Wave: %d",self.player.difficulty];
        self.waveLabel.fontSize = 30;
        self.waveLabel.position = CGPointMake(CGRectGetMidX(self.frame),CGRectGetHeight(self.frame)-40);
        [self addChild:self.waveLabel];
        
        //check to remove lives/ add money from user
        SKAction *pause = [SKAction waitForDuration:.1];
        SKAction *updateLives = [SKAction performSelector: @selector(updatePlayerLives) onTarget:self];
        SKAction *updateMoney = [SKAction performSelector: @selector(updateCurrency) onTarget:self];
        SKAction *check = [SKAction sequence:@[pause, updateMoney, updateLives]];
        SKAction *checkForever = [SKAction repeatActionForever:check];
        [self runAction:checkForever];
        
    }
    return self;
}

- (SKNode*) addEnemy{
    //NSLog([NSString stringWithFormat:@"difficulty: %d",self.player.difficulty]);
    SquareEnemy *enemy = [[SquareEnemy alloc] initWithDifficulty:self.player.difficulty inMap:3];
    [self addChild:enemy];
    [self.enemies addObject:enemy];
    return enemy;
}


-(void) increaseDifficulty
{

    self.player.difficulty++;
}


-(void) updatePlayerLives
{
    NSString* myNewString = [NSString stringWithFormat:@"Lives: %d",self.player.lives];
    self.myLives.text = myNewString;
    if(self.player.lives <=0){
        
        SKScene * scene =[[GameOver alloc]initWithSize:self.scene.view.bounds.size score:self.player.score];
        scene.scaleMode = SKSceneScaleModeAspectFill;
        // Present the scene.
        [self.scene.view presentScene:scene];
    }
    
}

-(void) updateCurrency
{
    NSString* myNewString= [NSString stringWithFormat:@"Money: $%d",self.player.currency];
    self.myMoney.text = myNewString;
    
    NSString* s = [NSString stringWithFormat:@"Wave: %d",self.player.difficulty];
    self.waveLabel.text = s;
}

-(float) randomFloatBetween: (float) low andHigh: (float) high{
    return [self randomFloat] *(high-low) +low;
}

-(float) randomFloat{
    return rand()/(float) RAND_MAX;
}

-(void)didBeginContact:(SKPhysicsContact *)contact
{
    SKPhysicsBody *firstBody;
    SKPhysicsBody *secondBody;
    if (contact.bodyA.categoryBitMask < contact.bodyB.categoryBitMask)
    {
        firstBody = contact.bodyA;
        secondBody = contact.bodyB;
    }
    else
    {
        firstBody = contact.bodyB;
        secondBody = contact.bodyA;
    }
    
    if ((firstBody.categoryBitMask & bulletCategory) != 0)
    {
        SKNode *projectile = (contact.bodyA.categoryBitMask & bulletCategory) ? contact.bodyA.node : contact.bodyB.node;
        SquareEnemy *enemy = (contact.bodyA.categoryBitMask & bulletCategory) ? contact.bodyB.node : contact.bodyA.node;
        [projectile runAction:[SKAction removeFromParent]];
        //printf("It collided");
        self.player.currency+=1;
        
        [enemy removeOneLife];
        self.player.score++;
        if(enemy.lives<0){
            [self.enemies removeObject:enemy];
        }
        [self runAction:self.splat];
        
    }
    if ((firstBody.categoryBitMask & fireBulletCategory) != 0)
    {
        SKNode *projectile = (contact.bodyA.categoryBitMask & fireBulletCategory) ? contact.bodyA.node : contact.bodyB.node;
        SquareEnemy *enemy = (contact.bodyA.categoryBitMask & fireBulletCategory) ? contact.bodyB.node : contact.bodyA.node;
        [projectile runAction:[SKAction removeFromParent]];
        //printf("It collided");
        self.player.currency+=1;
        enemy.isOnFire = TRUE;
        [enemy removeOneLife];
        self.player.score++;
        
        
    }
    //removes a life from the enemy if it collides with a bullet
    if ((firstBody.categoryBitMask & bombCategory) != 0)
    {
        SKNode *projectile = (contact.bodyA.categoryBitMask & bulletCategory) ? contact.bodyA.node : contact.bodyB.node;
        SquareEnemy *enemy = (contact.bodyA.categoryBitMask & bulletCategory) ? contact.bodyB.node : contact.bodyA.node;
        
        SKSpriteNode *explosion = [[SKSpriteNode alloc] initWithImageNamed:@"Explosion"];
        explosion.position=CGPointMake(enemy.position.x, enemy.position.y);
        explosion.size = CGSizeMake(50, 50);
        
        SKPhysicsBody *bulletBody = [SKPhysicsBody bodyWithCircleOfRadius:25];
        bulletBody.affectedByGravity = NO;
        bulletBody.categoryBitMask = explosionCategory;
        bulletBody.collisionBitMask = 0;
        bulletBody.contactTestBitMask = enemyCategory;
        
        explosion.physicsBody = bulletBody;
        [projectile removeFromParent];
        [self addChild:explosion];
        SKAction *pause = [SKAction waitForDuration:.2];
        SKAction *run = [SKAction sequence:@[pause, [SKAction removeFromParent]]];
        [explosion runAction:run];
        [self runAction:self.bomb];

    }
    if ((firstBody.categoryBitMask & explosionCategory) != 0)
    {
        SKNode *projectile = (contact.bodyA.categoryBitMask & bulletCategory) ? contact.bodyA.node : contact.bodyB.node;
        SquareEnemy *enemy = (contact.bodyA.categoryBitMask & bulletCategory) ? contact.bodyB.node : contact.bodyA.node;
        self.player.currency+=1;
        [enemy removeOneLife];
    }
    //adds bullets that come from the towers to strike the enemies
    else if ((firstBody.categoryBitMask & tower1Category) !=0)
    {
        TowerOne *tower1 = (contact.bodyA.categoryBitMask & tower1Category) ? contact.bodyA.node : contact.bodyB.node;
        SKNode *enemy = (contact.bodyA.categoryBitMask & tower1Category) ? contact.bodyB.node : contact.bodyA.node;
        
        int type = 1;
        CGPoint enemyLoc = enemy.position;
        CGPoint towerLoc = tower1.position;
        
        if([self randomFloatBetween:0 andHigh:10]>3){
            Bullets *bullet = [[Bullets alloc] initWithDestination:enemyLoc WithLocation:towerLoc WithType:type];
            [self addChild:bullet];
            [self runAction:self.fireball];

        }
        
        
        // if(![tower1.enemiesInRange containsObject:enemy]){
        //     [tower1.enemiesInRange addObject:enemy];
        //     if(![self.towers1 containsObject:tower1])[self.towers1 addObject:tower1];
        //self.objectsInArray1++;
        // }
    }
    else if ((firstBody.categoryBitMask & tower2Category) !=0)
    {
        //[self runAction:[SKAction waitForDuration:1]];
        TowerTwo *tower2 = (contact.bodyA.categoryBitMask & tower2Category) ? contact.bodyA.node : contact.bodyB.node;
        SKNode *enemy = (contact.bodyA.categoryBitMask & tower2Category) ? contact.bodyB.node : contact.bodyA.node;
        int type = 2;
        CGPoint enemyLoc = enemy.position;
        CGPoint towerLoc = tower2.position;
        if([self randomFloatBetween:0 andHigh:10]>5){
            Bomb *bomb = [[Bomb alloc] initWithDestination:enemyLoc WithLocation:towerLoc];
            [self addChild:bomb];
        }
        //if(![tower2.enemiesInRange containsObject:enemy]){
        //    [tower2.enemiesInRange addObject:enemy];
        //    if(![self.towers2 containsObject:tower2])[self.towers2 addObject:tower2];
        //self.objectsInArray2++;
        //   }
    }
    else if ((firstBody.categoryBitMask & tower3Category) !=0)
    {
        //[self runAction:[SKAction waitForDuration:1]];
        TowerThree *tower3 = (contact.bodyA.categoryBitMask & tower3Category) ? contact.bodyA.node : contact.bodyB.node;
        SquareEnemy *enemy = (contact.bodyA.categoryBitMask & tower3Category) ? contact.bodyB.node : contact.bodyA.node;
        int type = 3;
        
        
    }
    else if ((firstBody.categoryBitMask & endCategory) !=0)
    {
        SquareEnemy *enemy = (contact.bodyA.categoryBitMask & endCategory) ? contact.bodyB.node : contact.bodyA.node;
        self.player.lives -= enemy.lives;
        [self.enemies removeObject:enemy];
        [enemy runAction:[SKAction removeFromParent]];
    }
    
}

-(void) didEndContact:(SKPhysicsContact *)contact
{
    SKPhysicsBody *firstBody;
    SKPhysicsBody *secondBody;
    if (contact.bodyA.categoryBitMask < contact.bodyB.categoryBitMask)
    {
        firstBody = contact.bodyA;
        secondBody = contact.bodyB;
    }
    else
    {
        firstBody = contact.bodyB;
        secondBody = contact.bodyA;
    }
    if ((firstBody.categoryBitMask & tower1Category) != 0)
    {
        TowerOne *tower1 = (contact.bodyA.categoryBitMask & tower1Category) ? contact.bodyA.node : contact.bodyB.node;
        SquareEnemy *enemy = (contact.bodyA.categoryBitMask & tower1Category) ? contact.bodyB.node : contact.bodyA.node;
        //       [tower1.enemiesInRange removeObject:enemy];
        //      if([tower1.enemiesInRange count]==0) [self.towers1 removeObject:tower1];
        //self.objectsInArray1--;
    }
    else if ((firstBody.categoryBitMask & tower2Category) != 0)
    {
        TowerTwo *tower2 = (contact.bodyA.categoryBitMask & tower2Category) ? contact.bodyA.node : contact.bodyB.node;
        SquareEnemy *enemy = (contact.bodyA.categoryBitMask & tower2Category) ? contact.bodyB.node : contact.bodyA.node;
        //      [tower2.enemiesInRange removeObject:enemy];
        //       if([tower2.enemiesInRange count]==0) [self.towers2 removeObject:tower2];
        //self.objectsInArray2--;
    }
    else if ((firstBody.categoryBitMask & tower3Category) != 0)
    {
        TowerTwo *tower3 = (contact.bodyA.categoryBitMask & tower3Category) ? contact.bodyA.node : contact.bodyB.node;
        SquareEnemy *enemy = (contact.bodyA.categoryBitMask & tower3Category) ? contact.bodyB.node : contact.bodyA.node;
        [tower3.enemiesInRange removeObject:enemy];
        
        if([tower3.enemiesInRange count]==0) [self.towers3 removeObject:tower3];
        
    }
}




-(void)update:(CFTimeInterval)currentTime
{
    
    
    TowerToolbar3 *tt3 = [self.tool getTowerToolbar3];
    tt3.player=self.player;
    
    
    NSMutableArray *tt3List = [tt3 getTowerList];
    //draws towers
    for(int i = 0; i < [tt3List count]; i++)
    {
        if(self.countTT3 <= i)
        {
            //NSLog([NSString stringWithFormat:@"enemies: %@",self.targets]);
            
            [self addChild:[tt3List objectAtIndex:i]];
            self.countTT3 = self.countTT3 + 1;
            
        }
        
        //runs through all towers
        for(int i= 0; i<self.countTT3; i++){
            
            TowerThree *t = [tt3List objectAtIndex:i];
            
            //runs this for every 20 frames
            if(self.timeCount%20==1){
                
                //remoes from array if it is dead
                while([self.enemies count] !=0 && ![self.enemies.firstObject isAlive])
                    [self.enemies  removeObjectAtIndex:0];
                
                
                SquareEnemy *target;
                
                //runs through enemy array
                for(int arrayCount = 0; arrayCount<[self.enemies count]; i++){
                    
                    //target is the SquareEnemy being checked to see if it is in range
                    target = [self.enemies  objectAtIndex:arrayCount];
                    
                    //if the enemy is in range
                    //if([self distanceBetweenTower:t withEnemy:target]<100){
                    
                    //check for stuff in arrays
                    if([tt3List count] !=0&&[self.enemies count]!=0){
                        
                        //shoots
                        Bullets *bullet = [[Bullets alloc] initWithDestination: target.position WithLocation:t.position WithType:3];
                        [self addChild:bullet];
                        break;
                    }
                    
                    // }
                    
                }
                
                
                /*
                 
                 if([t.targets count] !=0 && ![t.targets.firstObject isAlive])
                 [t.targets removeObjectAtIndex:0];
                 
                 SquareEnemy *e = [t.targets firstObject];
                 
                 
                 SKAction *shoot = [SKAction performSelector: @selector(shoot) onTarget:self];
                 SKAction *randomPause = [SKAction waitForDuration:1];
                 SKAction *shootSeq = [SKAction sequence:@[shoot, randomPause]];
                 SKAction *shootTen = [SKAction repeatAction:shootSeq count:1];
                 */
                
            }
        }
    }
    
    
    TowerToolbar2 *tt2 = [self.tool getTowerToolbar2];
    tt2.player=self.player;
    NSMutableArray *tt2List = [tt2 getTowerList];
    for(int i = 0; i < [tt2List count]; i++)
    {
        if(self.countTT2 <= i)
        {
            [self addChild:[tt2List objectAtIndex:i]];
            self.countTT2 = self.countTT2 + 1;
        }
    }
    TowerToolbar1 *tt1 = [self.tool getTowerToolbar1];
    tt1.player=self.player;
    NSMutableArray *tt1List = [tt1 getTowerList];
    for(int i = 0; i < [tt1List count]; i++)
    {
        if(self.countTT1 <= i)
        {
            [self addChild:[tt1List objectAtIndex:i]];
            self.countTT1 = self.countTT1 + 1;
        }
    }
    
    
    self.timeCount++;
    
}

//distance formula
-(int) distanceBetweenTower: (TowerThree*)t withEnemy:(SquareEnemy*)e{
    return pow(pow(t.position.x- e.position.x,2)-pow(t.position.y-e.position.y,2),.5);
    
}




@end
