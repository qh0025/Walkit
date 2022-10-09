package com.mycompany.a1;
import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;

public class Ant extends Moveable implements ISteerable
{
	private int maximumSpeed;
	private int foodLevel;
	private int foodConsumptionRate;
	private int healthLevel;
	private int lastFlagReached;
	private int winFlag;
	
	//Sets all the value passed in
	public Ant(Point loc, int clr, int head, int spd, int sz, int mxSpd, int fRate)
	{
		super(loc, clr, head, spd, sz, mxSpd, fRate);
		
		setMaxSpeed(mxSpd);
		setFoodConsumptionRate(fRate);
		setLastFlagReached(1);
		setFoodLevel(100);
		setHealthLevel(100);
		setWinFlag(4);
		
	}
	

	@Override
	public void steer(int direction) 
	{
		super.setHeading(super.getHeading() + direction);
		
	}
	
	//Sets the max speed passed in
	public void setMaxSpeed(int spd)
	{
	  maximumSpeed = spd;
	}
	//returns the new max speed
	public int getMaxSpeed()
	{
	  return maximumSpeed;	
	}
	//sets the food level passed in.
	public void setFoodLevel(int newFood)
	{
		foodLevel = newFood;
	}
	//returns the new food level.
	public int getFoodLevel()
	{
		return foodLevel;
	}
	//sets the new health level
	public void setHealthLevel(int newHealth)
	{
		healthLevel = newHealth;

	}
	//retrieves the health level currently
	public int getHealthLevel()
	{
		return healthLevel;

	}
	//sets which flag is on now
	public void setLastFlagReached(int newFlag)
	{
		lastFlagReached = newFlag;
	}
	//returns the last flag number it is on currently
	public int getLastFlagReached()
	{
		return lastFlagReached;
	}
	//sets the food consumption level to what we passed in when we initialized
	public void  setFoodConsumptionRate(int foodRate)
	{
		foodConsumptionRate = foodRate;
	}
	//returns the consumption rate of food
	public int  getFoodConsumptionRate()
	{
		return foodConsumptionRate;
	}
	//set the flag we need to reach to win.
	public void setWinFlag(int win)
	{
		winFlag = win;
	}
	//retrieve the flag limit we need to end the game
	public int getWinFlag()
	{
		return winFlag;
	}




	
	
	
}
