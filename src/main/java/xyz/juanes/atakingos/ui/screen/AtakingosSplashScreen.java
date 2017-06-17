package xyz.juanes.atakingos.ui.screen;

import android.graphics.Canvas;
import android.graphics.Color;

import xyz.juanes.latte.Game;

import xyz.juanes.atakingos.ui.AtakingosLayer;
import xyz.juanes.atakingos.ui.AtakingosDraw;

public class AtakingosSplashScreen
{
  //Game object
  private Game game;

  //Background color
  private String background = null;

  //Logo positions
  private float logo_posx, logo_posy;

  //Constructor
  public AtakingosSplashScreen(Game game)
  {
    //Initialize the game object
    this.game = game;

    //Add the vector to the list
    this.game.vector.add("_blocks_logo_white", this.game.getResID("blocks_logo_white"), AtakingosLayer.scale);

    //Calculate the logo position x
    this.logo_posx = - 25;

    //Calculate the logo position y
    this.logo_posy = 120;
  }

  //Set the background
  public void setBackground(String bg)
  {
    //Set the background color
    this.background = bg;
  }

  //Draw the splash
  public void draw(Canvas canvas)
  {
    //Check the background color
    if(this.background != null)
    {
      //Set the background color
      canvas.drawColor(Color.parseColor(this.background));
    }

    //Draw the logo
    AtakingosDraw.vectorZone(canvas, this.game.vector.get("_blocks_logo_white"), this.logo_posx, this.logo_posy);
  }
}
