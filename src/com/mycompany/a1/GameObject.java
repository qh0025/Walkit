package com.mycompany.a1;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;

public class GameObject 
{
	int size;
	Point location;
	int color;
	float xPoint;
	float yPoint; 
	
	
	
	//sets the size
	public void setSize(int newSize)
	{
		size = newSize;
	}
	//returns the size
	public int getSize()
	{
	  return size;
	}
	//sets the location
	public void setLocation(Point loc)
    {
		location = loc;   
    }
	//returns the location
	public Point getLocation()
    {
    	return location;
    }
	//sets x value
	public void setX(float x)
	{
		location.setX(x);
	}
	//get x value
	public float getX()
	{
		return location.getX();
	}
	//sets y value
	public void setY(float y)
	{
		location.setY(y);;
	}
	//get the y value
	public float getY()
	{
		return location.getY();	
	}
	//sets the color
	public void setColor(int newColor)
    {
		color = newColor;
    }
	//gets the color
	public int getColor()
    {
    	return color;
    }
	//formats the color string to return to display
	public String toString()
	{
		
		String myDesc = "color = " + "[" + ColorUtil.red(color) + ","
		+ ColorUtil.green(color) + ","
		+ ColorUtil.blue(color) + "]";
		return myDesc ;
	}

}
