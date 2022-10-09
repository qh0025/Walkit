package com.mycompany.a1;
import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;

public abstract class Moveable extends GameObject 
{
	private int heading;
	private int speed;
	
	//assists in setting the moveable objects
	public Moveable(Point loc, int clr, int head, int spd, int sz, int mxSpd, int fRate)
	{
		setSpeed(spd);
		setHeading(head);
		super.setColor(clr);
		super.setSize(sz);
		super.setLocation(loc);
	}
	
	//does the calculation in order to move adding the new x y locations.
	public void move() 
	{
		//exception for when it is 0 degrees it results in radian 0
		if (heading == 0)
		{
			setHeading(1);
		}
		
		float tempRad = (float) Math.toRadians(getHeading());
		float deltaX =  Math.round(tempRad * speed);
		float deltaY = Math.round(tempRad * speed);
	
			//Boundary Restriction.  You can keep getting close to the edge but not touch it.
			
			if((super.getX() + deltaX) < 1000 && (super.getY() + deltaY) < 1000)
			{
				super.setX((super.getX() + deltaX));
				super.setY((super.getY() + deltaY));
			}
	
			if((super.getX() + deltaX) > 1000)
			{
				
				super.setX(super.getX() - deltaX/2); 
					
			}
			if((super.getY() + deltaY) > 1000)
			{
				super.setY(super.getY() - deltaY/2);
			}
	
			
	}
	
	//sets the speed passed in
	public void setSpeed(int newSpeed)
	{
		speed = newSpeed;
	}
	//returns the speed
	public int getSpeed()
	{
	 return speed;
	}
	//sets the heading passed in from initializtion
	public void setHeading(int newHeading)
	{
		
		heading = newHeading;
		
		//logic to keep heading in positive 359 value.
		if (heading > 359)
		{
			heading -= 359;
		}
		if (heading < 0)
		{
			heading += 359;
		}
		
	}
	//returns the heading.
	public int getHeading()
	{
		return heading;
	}
	

}
