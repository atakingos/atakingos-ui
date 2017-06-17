package xyz.juanes.atakingos.ui.utils;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;

public class PaintUtils
{
	//Paint Initialize
	public static Paint create(Style style, Cap cap)
	{
		//Create a new paint
		Paint paint = new Paint();
		
		//SetAntialias
		paint.setAntiAlias(true);
		
		//Set the style
		if(style != null) { paint.setStyle(style); }
		
		//Set the cap
		if(cap != null) { paint.setStrokeCap(cap); } 
		
		//Return
		return paint;
	}

	//Initialize All
	public static Paint create(Style style, Cap cap, String color, int stroke)
	{
		//Creates the new paint
		Paint paint = create(style, cap);

		//Set the color
		paint = color(paint, color);

		//Set the stroke
		paint = stroke(paint, stroke);

		//Return
		return paint;
	}
	
	//Paint color
	public static Paint color(Paint paint, String c)
	{
		//Set the color
		paint.setColor(Color.parseColor(c));
		
		//Return the paint
		return paint;
	}
	
	//Paint stroke
	public static Paint stroke(Paint paint, int s)
	{
		//Check the stroke
		if(s > 0)
		{
			//Set the stroke width
			paint.setStrokeWidth(s);
		}
		
		//Return
		return paint;
	}
}
