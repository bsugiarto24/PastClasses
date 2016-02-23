//
//  SliderBlock.m
//  PolyGoneTD
//
//  Created by Cameron Geehr on 10/24/13.
//  Copyright (c) 2013 Cameron Geehr. All rights reserved.
//

#import "SliderBlock.h"

@interface SliderBlock ()
@property CGPoint lastTouchLocation;
@end

@implementation SliderBlock


-(instancetype) init
{
    self = [super initWithImageNamed:@"SliderBlock"];
    
    self.userInteractionEnabled = YES;
 
    return self;
}

-(void) touchesBegan:(NSSet *)touches withEvent:(UIEvent *)event
{
    UITouch *touch = [touches anyObject];
    self.lastTouchLocation = [touch locationInNode:self];
}

-(void) touchesMoved:(NSSet *)touches withEvent:(UIEvent *)event
{
    UITouch *touch = [touches anyObject];
    CGPoint touchPoint = [touch locationInNode:self];
    
    CGPoint currentPosition = self.position;
    currentPosition.x = currentPosition.x + (touchPoint.x - self.lastTouchLocation.x);
    
    if(currentPosition.x >= 200 && currentPosition.x <= 300) self.position = currentPosition;
    
    self.lastTouchLocation = [touch locationInNode:self];
}

@end
