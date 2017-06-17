package xyz.juanes.atakingos.ui;

public class AtakingosTouch
{
  //Check touch on a rectangle
  public static boolean rect(float x, float y, float px, float py, float anc, float alt)
  {
    //Check the x coordinate
    if(x < px || px + anc < x){ return false; }

    //Check the y coordinate
    if(y < py || py + alt < y){ return false; }

    //Default, return true
    return true;
  }

  //Check touch on a scaled zone
  public static boolean rectScale(float x, float y, float px, float py, float anc, float alt)
  {
    //Return touch on a rectangle
    return rect(x, y, px * AtakingosLayer.scale, py * AtakingosLayer.scale, anc * AtakingosLayer.scale, alt * AtakingosLayer.scale);
  }

  //Check touch on rectangle zone
  public static boolean rectZone(float x, float y, float px, float py, float anc, float alt)
  {
    //Get the new position x
    float new_posx = AtakingosLayer.zone.px + px * AtakingosLayer.scale;

    //Get the new position y
    float new_posy = AtakingosLayer.zone.py + py * AtakingosLayer.scale;

    //Return touch on a rectangle
    return rect(x, y, new_posx, new_posy, anc * AtakingosLayer.scale, alt * AtakingosLayer.scale);
  }
}
