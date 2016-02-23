//
//  Tower.m
//  PolyGoneTD
//
//  Created by Cameron Geehr on 10/29/13.
//  Copyright (c) 2013 Cameron Geehr. All rights reserved.
//

#import "Tower.h"

@implementation Tower

-(instancetype) init:(CGPoint) loc init1:(int) towerType
{
    self = [super init];
    self.position = loc;
    if(towerType==1){
        self = [[Tower alloc] initWithImageNamed:@"towerOne"];
        self.radius = 100;
        self.price = 10;
        self.xOffset = 300;
        self.yOffset = 50;
        
        return self;
    }
    else if(towerType==2){
        self = [[Tower alloc] initWithImageNamed:@"towerTwo"];
        self.radius = 50;
        self.price = 30;
        self.xOffset = 300;
        self.yOffset = 100;
        
        return self;
    }
    else{
        self = [[Tower alloc] initWithImageNamed:@"towerThree"];
        self.radius = 150;
        self.price = 20;
        self.xOffset = 300;
        self.yOffset = 150;
        
        return self;
    }
    self.player.currency-=self.price;
    return self;
}

-(instancetype) init:(int) towerType
{
    self = [super init];
    self.towerType = towerType;
    if(towerType==1){
        self = [[Tower alloc] initWithImageNamed:@"towerOne"];
        self.radius = 100;
        self.price = 10;
        self.xOffset = 300;
        self.yOffset = 50;
        
        return self;
    }
    else if(towerType==2){
        self = [[Tower alloc] initWithImageNamed:@"towerTwo"];
        self.radius = 50;
        self.price = 15;
        self.xOffset = 300;
        self.yOffset = 100;
        
        return self;
    }
    else{
        self = [[Tower alloc] initWithImageNamed:@"towerThree"];
        self.radius = 150;
        self.price = 20;
        self.xOffset = 300;
        self.yOffset = 150;
        
        return self;
    }
    return self;
}


@end
