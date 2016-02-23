//
//  TowerToolbar2.m
//  PolyGoneTD
//
//  Created by Kevin McKinnis on 10/31/13.
//  Copyright (c) 2013 Cameron Geehr. All rights reserved.
//

#import "TowerToolbar2.h"
#import "EnemyPath.h"

@interface TowerToolbar2 ()
@property CGPoint lastTouchLocation;
@property NSMutableArray *tower2List;
@property CGPoint touchPlace;
@property CircleNode *circle;
@property CGPoint firstTouchLocation;
@property EnemyPath *path;
@end

@implementation TowerToolbar2

- (instancetype) init
{
    self = [super initWithImageNamed:@"towerTwo"];
    self.userInteractionEnabled = YES;
    self.tower2List = [[NSMutableArray alloc] init];
    self.path = [[EnemyPath alloc] initPath];

    TowerTwo *towerTwo = [[TowerTwo alloc] init];
    self.circle = [[CircleNode alloc] initWithRadius:towerTwo.radius];
    self.circle.strokeColor = [UIColor colorWithRed:1 green:.9 blue:.0 alpha:1];
    self.circle.userInteractionEnabled = YES;
    
    return self;
}

-(NSMutableArray*) getTowerList
{
    return self.tower2List;
}

-(void)touchesBegan:(NSSet *)touches withEvent:(UIEvent *)event
{
   
   // NSLog([NSString stringWithFormat:@"currency: %d",self.player.currency]);
    if(self.player.currency>=30)
    {
        UITouch *touch = [touches anyObject];
        self.lastTouchLocation = [touch locationInNode:self];
        self.firstTouchLocation = [touch locationInNode:self];
    
        self.circle.strokeColor = [UIColor colorWithRed:1 green:.9 blue:.0 alpha:1];
        self.circle.position = self.firstTouchLocation;
    
        [self addChild:self.circle];
    
        SKSpriteNode *tower2;
        tower2 = [[SKSpriteNode alloc] initWithImageNamed:@"towerTwo"];
        tower2.position = CGPointMake(300, 100);
        tower2.size = CGSizeMake(25, 25);
    
        [self.tower2List addObject:tower2];
    }
}
-(void) touchesMoved:(NSSet *)touches withEvent:(UIEvent *)event
{

    if(self.player.currency>=30)
    {
        UITouch *touch = [touches anyObject];
        SKSpriteNode *tower2 = [self.tower2List lastObject];
        CGPoint touchPoint = [touch locationInNode:self];
        CGPoint newPosition = tower2.position;
    
        newPosition.x = touchPoint.x+300;//newPosition.x + (touchPoint.x - self.lastTouchLocation.x);
        newPosition.y = touchPoint.y+100;//newPosition.y + (touchPoint.y - self.lastTouchLocation.y);
    
        tower2.position = newPosition;
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

    if(self.player.currency>=30)
    {
        TowerTwo *tower;
        bool x =true;
        NSMutableArray *arr = [self.path getPathPoints];
        if(self.player.currency-tower.price)
        {
            tower = [[TowerTwo alloc] init:self.lastTouchLocation];
            tower.size = CGSizeMake(25, 25);
            tower.position = self.touchPlace;
            CGPoint pos = CGPointMake(tower.position.x + 300, tower.position.y +100);
            for(int i = 0; i < [arr count]; i++)
            {
                TowerTwo *tempTower;
                tempTower = [[TowerTwo alloc] init:self.lastTouchLocation];
                tempTower.size = CGSizeMake(25, 25);
                tempTower.position = pos;
                NSValue *val = [arr objectAtIndex:i];
                CGPoint point = [val CGPointValue];
                if([tempTower containsPoint:point] == true)
                {
                    x = false;
                }
            }
            if(x == true)
            {
                [self addChild:tower];
                self.player.currency-=tower.price;
                SKSpriteNode *tower2 = [self.tower2List lastObject];
                [tower2 removeFromParent];
                [self.circle removeFromParent];
                [self.tower2List removeLastObject];
                [self.tower2List addObject:tower];
            }
            else
            {
                SKSpriteNode *tower2 = [self.tower2List lastObject];
                [tower2 removeFromParent];
                [self.circle removeFromParent];
                //[self.tower3List removeLastObject];
            }
        }

    }
}
@end
