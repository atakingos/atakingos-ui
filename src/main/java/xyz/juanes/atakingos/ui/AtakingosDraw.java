package xyz.juanes.atakingos.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.graphics.drawable.VectorDrawableCompat;

public class AtakingosDraw
{
  //Draw an image
  public static void img(Canvas canvas, Bitmap imgage, float px, float py)
  {
    //Check for empty image
    if(imgage == null){ return; }

    //Draw the image
    canvas.drawBitmap(imgage, px, py, null);
  }

  //Draw a scaled image
  public static void imgScale(Canvas canvas, Bitmap image, float px, float py)
  {
    img(canvas, image, px * AtakingosLayer.scale, py * AtakingosLayer.scale);
  }

  //Draw an image on the game zone
  public static void imgZone(Canvas canvas, Bitmap image, float px, float py)
  {
    img(canvas, image, AtakingosLayer.zone.px + px * AtakingosLayer.scale, AtakingosLayer.zone.py + py * AtakingosLayer.scale);
  }

  //Draw an image on the background
  public static void imgBackground(Canvas canvas, Bitmap image)
  {
    img(canvas, image, AtakingosLayer.background.px, AtakingosLayer.background.py);
  }

  //Draw a vector image
  public static void vector(Canvas canvas, VectorDrawableCompat image, float px, float py)
  {
    //Check for empty image
    if(image == null){ return; }

    //Translate to the canvas position
    canvas.translate(px, py);

    //Draw the vector image
    image.draw(canvas);
  }

  //Draw a scaled vector image
  public static void vectorScale(Canvas canvas, VectorDrawableCompat image, float px, float py)
  {
    vector(canvas, image, px * AtakingosLayer.scale, py * AtakingosLayer.scale);
  }

  //Draw an image on the game zone
  public static void vectorZone(Canvas canvas, VectorDrawableCompat image, float px, float py)
  {
    vector(canvas, image, AtakingosLayer.zone.px + px * AtakingosLayer.scale, AtakingosLayer.zone.py + py * AtakingosLayer.scale);
  }

  //Draw an image on the background
  public static void vectorBackground(Canvas canvas, VectorDrawableCompat image, float px, float py)
  {
    vector(canvas, image, AtakingosLayer.background.px, AtakingosLayer.background.py);
  }

  //Draw text
  public static void text(Canvas canvas, String text, float px, float py, Typeface font, int size, String color, Paint.Align pos)
  {
    //Get the new paint object
    Paint paint = new Paint();

    //Paint align
    paint.setTextAlign(pos);

    //Change the paint size
    paint.setTextSize(size);

    //Change the font
    if(font != null) { paint.setTypeface(font); }

    //Change the color
    paint.setColor(Color.parseColor(color));

    //Draw the text
    canvas.drawText(text, px, py, paint);
  }

  //Draw text scaled
  public static void textScale(Canvas canvas, String text, float px, float py, Typeface font, int size, String color, Paint.Align pos)
  {
    text(canvas, text, px * AtakingosLayer.scale, py * AtakingosLayer.scale, font, (int)(AtakingosLayer.scale * size), color, pos);
  }

  //Draw Text in zone
  public static void textZone(Canvas canvas, String text, float px, float py, Typeface font, int size, String color, Paint.Align pos)
  {
    //Get the nex position x
    float new_posx = AtakingosLayer.zone.px + px * AtakingosLayer.scale;

    //Get the new position y
    float new_posy = AtakingosLayer.zone.py + py * AtakingosLayer.scale;

    //Draw the text on the canvas
    text(canvas, text, new_posx, new_posy, font, (int)(AtakingosLayer.scale*size), color, pos);
  }

  //Draw color background
  public static void color(Canvas canvas, String color)
  {
    canvas.drawColor(Color.parseColor(color));
  }
}
