package xyz.juanes.atakingos.ui.utils;

public class MathUtils
{
	//Return a float number between [Min, Max]
	public static float random(int Min, int Max)
	{		
		return Min + (float)(Math.random() * ((Max - Min) + 1));
	}
	
	//Return an integer between [Min, Max]
	public static int randomInt(int Min, int Max)
	{		
		return Min + (int)(Math.random() * ((Max - Min) + 1));
	}
	
	//Point class
	public static class Point
	{
		//Variables
		public float x, y;
		
		//Constructor
		public Point(float x, float y)
		{
			this.x = x;
			this.y = y;
		}
	}
	
	//Return the angle between two points
	public static float angleTwoVectors(float a_x, float a_y, float b_x, float b_y)
	{
		//Calculate the distances
		float a = (float) Math.sqrt(a_x*a_x + a_y*a_y);
		float b = (float) Math.sqrt(b_x*b_x + b_y*b_y);
		
		//Calculate the angle
		float angle = (float) Math.acos((float) (a_x*b_x + a_y*b_y)/(a*b));
		
		//Return the angle
		return angle;
	}
	
	//Calculate the angle between two points
	public static float angleTwoVectors(Point a, Point b) { return angleTwoVectors(a.x, a.y, b.x, b.y); }
	
	//FReturn the polar coordinates
	public static Point coordPolar(float x, float y)
	{
		//Creates the new point
		MathUtils.Point p = new MathUtils.Point(0,0);
		
		//Get the radius
		p.x = (float) Math.sqrt(x*x + y*y);
		
		//Get the angle
		if(x > 0 && y > 0)
		{
			p.y = (float) Math.atan(y/x);
		}
		else if(x == 0 && y > 0)
		{
			p.y = (float) Math.PI/2;
		}
		else if(x < 0)
		{
			p.y = (float) ((float) Math.atan(y/x) + Math.PI);
		}
		else if(x == 0 && y < 0)
		{
			p.y = (float) ((float) 3*Math.PI/2);
		}
		else if(x > 0 && y < 0)
		{
			p.y = (float) ((float) Math.atan(y/x) + 2*Math.PI);
		}
		
		//Return
		return p;
	}
	
	//Return the polar coordinates
	public static Point coordPolar(Point p) { return coordPolar(p.x, p.y); }
	
	//Return the rectangle coordinates
	public static Point coordRect(float ro, float angle)
	{
		//Creates the point
		MathUtils.Point point = new MathUtils.Point(0, 0);
		
		//Get the x coordinate
		point.x = (float) ((float) ro*Math.cos(angle));

		//Calculate the y coordinate
		point.y = (float) ((float) ro*Math.sin(angle));
		
		//Return the point
		return point;
	}

  //Return the rectangle coordinates
	public static Point coordRect(Point p) { return coordRect(p.x, p.y); }
}
