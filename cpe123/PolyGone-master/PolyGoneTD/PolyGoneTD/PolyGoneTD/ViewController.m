//
//  ViewController.m
//  Poly-Gone
//
//  Created by Cameron Geehr on 10/15/13.
//  Copyright (c) 2013 Cameron Geehr. All rights reserved.
//

#import "ViewController.h"
#import "MainMenu.h"
#import "Options.h"

@import AVFoundation;
@interface ViewController ()
@property float v;
@end
@implementation ViewController

- (void)viewDidLoad
{
    [super viewDidLoad];
    
    // Configure the view.
    SKView * skView = (SKView *)self.view;
//    skView.showsFPS = YES;
//    skView.showsNodeCount = YES;
    
    // Create and configure the scene.
    SKScene * scene = [MainMenu sceneWithSize:skView.bounds.size];
    scene.scaleMode = SKSceneScaleModeAspectFill;
    
    NSError *error;
    NSURL * backgroundMusicURL = [[NSBundle mainBundle] URLForResource:@"Winterbliss" withExtension:@"mp3"];
    self.backgroundMusicPlayer = [[AVAudioPlayer alloc] initWithContentsOfURL:backgroundMusicURL error:&error];
    self.backgroundMusicPlayer.numberOfLoops = -1;
    //   self.v = .001*BGMVolume;
    self.backgroundMusicPlayer.volume = 1.0f;
    //   NSLog([NSString stringWithFormat:@"v: %d",BGMVolume]);
    [self.backgroundMusicPlayer prepareToPlay];
    [self.backgroundMusicPlayer play];
    // Present the scene.
    [skView presentScene:scene];
}

- (BOOL)shouldAutorotate
{
    return YES;
}

- (NSUInteger)supportedInterfaceOrientations
{
    if ([[UIDevice currentDevice] userInterfaceIdiom] == UIUserInterfaceIdiomPhone) {
        return UIInterfaceOrientationMaskAllButUpsideDown;
    } else {
        return UIInterfaceOrientationMaskAll;
    }
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Release any cached data, images, etc that aren't in use.
}

-(void) check{
    //    NSLog([NSString stringWithFormat:@"Volume: %d",BGMVolume]);
}

-(void) volumeUpdate{
    self.backgroundMusicPlayer.volume = self.v;
}


@end
