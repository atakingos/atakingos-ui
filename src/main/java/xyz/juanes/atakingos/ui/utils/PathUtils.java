package xyz.juanes.atakingos.ui.utils;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import xyz.juanes.atakingos.ui.AtakingosLayer;

import java.util.ArrayList;

public class PathUtils
{
	//Scale a path
	public static Path scale(Path path, int width, int height, int real_width, int real_height)
	{
		//Creates the matrix
		Matrix matrix = new Matrix();
		
		//Scale the width
		width = (int)(width * AtakingosLayer.scale);

		//Scale the height
		height = (int)(height * AtakingosLayer.scale);
		
		//Calculate the width proportion
		float sw = (float) width / real_width;

		//Calculate the height proportion
		float sh = (float) height / real_height;
		
		//Resize the bit map
		matrix.postScale(sw, sh);
		
		//Apply
		path.transform(matrix);
		
		//Return
		return path;
	}

  //Move a path to a point
	public static Path moveTo(Path path, float x, float y)
	{
		//Creates a new path
		Path new_path = new Path(path);
		
		//Offset the path
		new_path.offset(x, y);
		
		//Return
		return new_path;
	}

  //Move to a scaled point
	public static Path moveToScale(Path path, float x, float y)
	{
		return moveTo(path, x * AtakingosLayer.scale, y * AtakingosLayer.scale);
	}

  //Move to a zone point
	public static Path moveToZone(Path path, float x, float y)
	{
		return moveTo(path, AtakingosLayer.zone.px + x * AtakingosLayer.scale, AtakingosLayer.zone.py + y * AtakingosLayer.scale);
	}

  //Draw a path
	public static void draw(Canvas canvas, Path path, Paint paint)
	{
    //Draw the path
		canvas.drawPath(path, paint);
	}
	
	//Add a Semicircle
	public static Path arc(Path path, int center_x, int center_y, int start_x, int start_y, int end_x, int end_y, int control_points)
	{
		//Check the points number
		if(control_points < 1) control_points = 1;
		
		//Calculate the two vectors
		MathUtils.Point cs = new MathUtils.Point(start_x - center_x, start_y - center_y);
		MathUtils.Point ce = new MathUtils.Point(end_x - center_x, end_y - center_y);
		
		//Calculate the angle
		float angle = (float) MathUtils.angleTwoVectors(cs, ce);
		
		//Get the partitions
		float angleP = (float) angle/(control_points + 1);
		
		//Get the start point
		MathUtils.Point start = MathUtils.coordPolar(cs);
		
		//Generates the x points array
		ArrayList<Float> px = new ArrayList<>();

    //Generate the y points array
		ArrayList<Float> py = new ArrayList<>();
		
		//Add start
		px.add((float) start_x); py.add((float) start_y);
		
		//Get the points
		for(int i = 0; i < control_points; i++)
		{
			//Apply the angle
			start.y = start.y + angleP;
			
			//Add the x coordinate
			px.add(MathUtils.coordRect(start).x + center_x);

      //Add the y coordinate
			py.add(MathUtils.coordRect(start).y + center_y);
		}
		
		//Add end x point
		px.add((float) end_x);

    //Add end y point
    py.add((float) end_y);
		
		//Move to start
		path.moveTo(start_x, start_y);
		
		//Loop
		for(int i = 0; i < control_points; i++)
		{
			//Add to the path
			path.cubicTo(px.get(i), py.get(i), px.get(i+1), py.get(i+1), px.get(i+2), py.get(i+2));
		}
		
		//Returns the path
		return path;
	}
}
