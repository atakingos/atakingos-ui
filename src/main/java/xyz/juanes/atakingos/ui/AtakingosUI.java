package xyz.juanes.atakingos.ui;

import xyz.juanes.latte.Game;
import xyz.juanes.atakingos.ui.screen.AtakingosSplashScreen;

public class AtakingosUI
{
  //Game object
  private Game game;

  //Splash screen
  public AtakingosSplashScreen splash;

  //Constructor
  public AtakingosUI(Game game)
  {
    //Initialize the game
    this.game = game;

    //Initialize the Atakingos layer
    AtakingosLayer.init(this.game.device.getWidth(), this.game.device.getHeight(), this.game.device.getMode());

    //Initialize the splash screen
    this.splash = new AtakingosSplashScreen(this.game);
  }
}
