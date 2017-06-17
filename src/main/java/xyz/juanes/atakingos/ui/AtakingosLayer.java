package xyz.juanes.atakingos.ui;

import android.util.Log;

public class AtakingosLayer
{
  //Default width
  public static int def_width = 400;

  //Default height (only for landscape)
  public static int def_height = 400;

  //Screen width and height
  public static int width, height;

  //Scale
  public static float scale;

  //Game zone class
  public static class zone
  {
    //Zone positions
    public static int width, height, px, py;
  }

  //Game background class
  public static class background
  {
    //background positions
    public static int width, height, px, py;
  }

  //Constructor
  public static void init(int w, int h, String mode)
  {
    //Save the game width
    width = w;

    //Save the game height
    height = h;

    //Calculate the game scale
    scale = (mode.equals("landscape")) ? (float) height / def_height : (float) width / def_width;

    //Display in console
    Log.i("Blocks Scale", scale + "");

    //Zone width
    zone.width = (mode.equals("landscape")) ? (int)(450 * scale) : (int)(350 * scale);

    //Zone height
    zone.height = (mode.equals("landscape")) ? (int)(350 * scale) : (int)(450 * scale);

    //Background width
    background.width = (mode.equals("landscape")) ? (int)(800 * scale) : (int)(400 * scale);

    //Background height
    background.height = (mode.equals("landscape")) ? (int)(400 * scale) : (int)(800 * scale);

    //Zone position x
    zone.px = (int)(width / 2 - zone.width / 2);

    //Zone position y
    zone.py = (int)(height / 2 - zone.height / 2);

    //Background position x
    background.px = (int)(width / 2 - background.width / 2);

    //Background position y
    background.py = (int)(height / 2 - background.height / 2);
  }
}
