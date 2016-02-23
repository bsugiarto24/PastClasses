//
//  TowerToolbar3.m
//  PolyGoneTD
//
//  Created by Kevin McKinnis on 10/31/13.
//  Copyright (c) 2013 Cameron Geehr. All rights reserved.
//

#import "TowerToolbar3.h"
#import "EnemyPath.h"

@interface TowerToolbar3 ()
@property CGPoint lastTouchLocation;
@property NSMutableArray *tower3List;
@property CGPoint touchPlace;
@property CircleNode *circle;
@property CGPoint firstTouchLocation;
@property EnemyPath *path;
@end

@implementation TowerToolbar3

- (instancetype) init
{
    
    self = [super initWithImageNamed:@"towerThree"];
    self.userInteractionEnabled = YES;
    self.tower3List = [[NSMutableArray alloc] init];
    
    self.path = [[EnemyPath alloc] initPath];
    TowerThree *towerThree = [[TowerThree alloc] init];
    self.circle = [[CircleNode alloc] initWithRadius:towerThree.radius];
    self.circle.strokeColor = [UIColor colorWithRed:1 green:.9 blue:.0 alpha:1];
    self.circle.userInteractionEnabled = YES;
    
    return self;
}

-(NSMutableArray*) getTowerList
{
    return self.tower3List;
}

-(void)touchesBegan:(NSSet *)touches withEvent:(UIEvent *)event
{
    //NSLog([NSString stringWithFormat:@"currency: %d",self.player.currency]);
    if(self.player.currency>=20)
    {
        UITouch *touch = [touches anyObject];
        self.lastTouchLocation = [touch locationInNode:self];
        self.firstTouchLocation = [touch locationInNode:self];
    
        self.circle.strokeColor = [UIColor colorWithRed:1 green:.9 blue:.0 alpha:1];
        self.circle.position = self.firstTouchLocation;
    
       // [self addChild:self.circle];
    
        SKSpriteNode *tower3;
        tower3 = [[SKSpriteNode alloc] initWithImageNamed:@"towerThree"];
        tower3.position = CGPointMake(300, 150);
        tower3.size = CGSizeMake(25, 25);
    
        [self.tower3List addObject:tower3];
    }
}

-(void) touchesMoved:(NSSet *)touches withEvent:(UIEvent *)event
{
    if(self.player.currency>=20)
    {
        UITouch *touch = [touches anyObject];
        SKSpriteNode *tower3 = [self.tower3List lastObject];
        CGPoint touchPoint = [touch locationInNode:self];
        CGPoint newPosition = tower3.position;
    
        newPosition.x = touchPoint.x+300;//newPosition.x + (touchPoint.x - self.lastTouchLocation.x);
        newPosition.y = touchPoint.y+150;//newPosition.y + (touchPoint.y - self.lastTouchLocation.y);
    
        tower3.position = newPosition;
        self.circle.position = CGPointMake(self.circle.position.x + (touchPoint.x - self.lastTouchLocation.x), self.circle.position.y + (touchPoint.y - self.lastTouchLocation.y));
    
        self.lastTouchLocation = [touch locationInNode:self];
        self.touchPlace = self.lastTouchLocation;
    }
}
-(void) touchesCancelled:(NSSet *)touches withEvent:(UIEvent *)event
{
    
}

-(void) touchesEnded:(NSSet *)touches withEvent:(UIEvent *)event
{
    if(self.player.currency>=20)
    {
        TowerThree *tower;
        bool x =true;
        NSMutableArray *arr = [self.path getPathPoints];
        if(self.player.currency-tower.price)
        {
            tower = [[TowerThree alloc] init:self.lastTouchLocation];
            tower.size = CGSizeMake(25, 25);
            tower.position = self.touchPlace;
            CGPoint pos = CGPointMake(tower.position.x + 300, tower.position.y +150);
            TowerThree *tempTower;
            tempTower = [[TowerThree alloc] init:self.lastTouchLocation];
            tempTower.size = CGSizeMake(25, 25);
            tempTower.position = pos;
            // for(int i = 0; i < [arr count]; i++)
            // {
            // TowerThree *tempTower;
            // tempTower = [[TowerThree alloc] init:self.lastTouchLocation];
            // tempTower.size = CGSizeMake(25, 25);
            // tempTower.position = pos;
            // NSValue *val = [arr objectAtIndex:i];
            // CGPoint point = [val CGPointValue];
            // if([tempTower containsPoint:point] == true)
            // {
            // x = false;
            // }
            // }
            if(tempTower.position.y >= 480)
            {
                x =false;
            }
            if(tempTower.position.x >= 245 && tempTower.position.x <= 255 && tempTower.position.y >= 425 && tempTower.position.y <= 480)
            {
                x = false;
            }
            if(tempTower.position.x >= 175 && tempTower.position.x <= 260 && tempTower.position.y >= 415 && tempTower.position.y <= 425)
            {
                x = false;
            }
            if(tempTower.position.x >= 180 && tempTower.position.x <= 190 && tempTower.position.y >= 370 && tempTower.position.y <= 410)
            {
                x = false;
            }
            if(tempTower.position.x >= 90 && tempTower.position.x <= 195 && tempTower.position.y >= 352 && tempTower.position.y <= 365)
            {
                x = false;
            }
            if(tempTower.position.x >= 80 && tempTower.position.x <= 90 && tempTower.position.y >= 352 && tempTower.position.y <= 480)
            {
                x = false;
            }
            if(tempTower.position.x >= 0 && tempTower.position.x <= 75 && tempTower.position.y >= 462 && tempTower.position.y <= 480)
            {
                x = false;
            }
            if(tempTower.position.x >= 0 && tempTower.position.x <= 18 && tempTower.position.y >= 195 && tempTower.position.y <= 480)
            {
                x = false;
            }
            if(tempTower.position.x >= 0 && tempTower.position.x <= 108 && tempTower.position.y >= 182 && tempTower.position.y <= 198)
            {
                x = false;
            }
            if(tempTower.position.x >= 102 && tempTower.position.x <= 118 && tempTower.position.y >= 180 && tempTower.position.y <= 280)
            {
                x = false;
            }
            if(tempTower.position.x >= 102 && tempTower.position.x <= 250 && tempTower.position.y >= 278 && tempTower.position.y <= 292)
            {
                x = false;
            }
            if(tempTower.position.x >= 232 && tempTower.position.x <= 248 && tempTower.position.y >= 95 && tempTower.position.y <= 280)
            {
                x = false;
            }
            if(tempTower.position.x >= 60 && tempTower.position.x <= 248 && tempTower.position.y >= 82 && tempTower.position.y <= 98)
            {
                x = false;
            }
            if(tempTower.position.x >= 42 && tempTower.position.x <= 58 && tempTower.position.y >= 0 && tempTower.position.y <= 98)
            {
                x = false;
            }
            if(tempTower.position.x >= 282 && tempTower.position.x <= 320 && tempTower.position.y >= 0 && tempTower.position.y <= 198)
            {
                x = false;
            }
            for(int i = 0; i < [self.tower3List count] - 1; i++)
            {
                TowerThree *tempTower;
                tempTower = [[TowerThree alloc] init:self.lastTouchLocation];
                tempTower.size = CGSizeMake(30, 30);
                tempTower.position = pos;
                TowerThree *arrTower;
                arrTower = [self.tower3List objectAtIndex:i];
                if([tempTower intersectsNode:arrTower] == true)
                {
                    x = false;
                    break;
                }
            }
            if(x == true)
            {
                [self addChild:tower];
                self.player.currency-=tower.price;
                SKSpriteNode *tower3 = [self.tower3List lastObject];
                [tower3 removeFromParent];
                [self.circle removeFromParent];
                [self.tower3List removeLastObject];
                [self.tower3List addObject:tower];
            }
            else
            {
                SKSpriteNode *tower3 = [self.tower3List lastObject];
                [tower3 removeFromParent];
                [self.circle removeFromParent];
                //[self.tower3List removeLastObject];
            }
        }
    }
}

@end