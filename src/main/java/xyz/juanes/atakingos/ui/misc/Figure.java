package xyz.juanes.atakingos.ui.misc;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

public class Figure
{
  //Path
  public Path path;

  //Paint
  public Paint paint;

  //Constructor
  public Figure()
  {
    //Initialize the path
    this.path = new Path();

    //Initialize the new paint
    this.paint = new Paint();

    //Set antialias
    this.paint.setAntiAlias(true);
  }

  //Draw the path
  public void draw(Canvas canvas)
  {
    //Draw the figure
    canvas.drawPath(path, paint);
  }
}
