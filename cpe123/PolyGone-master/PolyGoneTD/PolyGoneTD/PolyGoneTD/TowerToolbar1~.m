//
//  TowerToolbar1.m
//  PolyGoneTD
//
//  Created by Kevin McKinnis on 10/31/13.
//  Copyright (c) 2013 Cameron Geehr. All rights reserved.
//

#import "TowerToolbar1.h"
#import "EnemyPath.h"

@interface TowerToolbar1 ()
@property CGPoint lastTouchLocation;
@property NSMutableArray *tower1List;
@property CGPoint touchPlace;
@property CircleNode *circle;
@property CGPoint firstTouchLocation;
@property EnemyPath *path;
@end

@implementation TowerToolbar1

- (instancetype) init
{
    //NSLog([NSString stringWithFormat:@"currency: %d",self.player.currency]);
    self = [super initWithImageNamed:@"towerOne"];
    self.userInteractionEnabled = YES;
    self.tower1List = [[NSMutableArray alloc] init];
    self.path = [[EnemyPath alloc] initPath];

    TowerOne *towerOne = [[TowerOne alloc] init];
    self.circle = [[CircleNode alloc] initWithRadius:towerOne.radius];
    self.circle.strokeColor = [UIColor colorWithRed:1 green:.9 blue:.0 alpha:1];
    self.circle.userInteractionEnabled = YES;
    return self;
}

-(NSMutableArray*) getTowerList
{
    return self.tower1List;
}

-(void)touchesBegan:(NSSet *)touches withEvent:(UIEvent *)event
{
    //NSLog([NSString stringWithFormat:@"currency: %d",self.player.currency]);
    if(self.player.currency>=25)
    {
        UITouch *touch = [touches anyObject];
        self.lastTouchLocation = [touch locationInNode:self];
        self.firstTouchLocation = [touch locationInNode:self];
        self.circle.strokeColor = [UIColor colorWithRed:1 green:.9 blue:.0 alpha:1];
        self.circle.position = self.firstTouchLocation;
        [self addChild:self.circle];
    
        SKSpriteNode *tower1;
        tower1 = [[SKSpriteNode alloc] initWithImageNamed:@"towerOne"];
        tower1.position = CGPointMake(300, 50);
        tower1.size = CGSizeMake(25, 25);
    
        [self.tower1List addObject:tower1];
    }
    
}

-(void) touchesMoved:(NSSet *)touches withEvent:(UIEvent *)event
{
   // NSLog([NSString stringWithFormat:@"currency: %d",self.player.currency]);
    if(self.player.currency>=25)
    {
        UITouch *touch = [touches anyObject];
        SKSpriteNode *tower1 = [self.tower1List lastObject];
        CGPoint touchPoint = [touch locationInNode:self];
        CGPoint newPosition = tower1.position;
    
        newPosition.x = touchPoint.x+300;//newPosition.x + (touchPoint.x - self.lastTouchLocation.x);
        newPosition.y = touchPoint.y+50;//newPosition.y + (touchPoint.y - self.lastTouchLocation.y);
        tower1.position = newPosition;
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
    //NSLog([NSString stringWithFormat:@"currency: %d",self.player.currency]);
    if(self.player.currency>=25)
    {
        TowerOne *tower;
        bool x =true;
        NSMutableArray *arr = [self.path getPathPoints];
        if(self.player.currency-tower.price)
        {
            tower = [[TowerOne alloc] init:self.lastTouchLocation];
            tower.size = CGSizeMake(25, 25);
            tower.position = self.touchPlace;
            CGPoint pos = CGPointMake(tower.position.x + 300, tower.position.y +50);
            for(int i = 0; i < [arr count]; i++)
            {
                TowerOne *tempTower;
                tempTower = [[TowerOne alloc] init:self.lastTouchLocation];
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
                SKSpriteNode *tower1 = [self.tower1List lastObject];
                [tower1 removeFromParent];
                [self.circle removeFromParent];
                [self.tower1List removeLastObject];
                [self.tower1List addObject:tower];
            }
            else
            {
                SKSpriteNode *tower1 = [self.tower1List lastObject];
                [tower1 removeFromParent];
                [self.circle removeFromParent];
                //[self.tower3List removeLastObject];
            }
        }

    }
    
}

@end
