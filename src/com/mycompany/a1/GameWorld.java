package com.mycompany.a1;
import java.util.ArrayList;
import java.util.Random;
import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;

public class GameWorld 
{
	
	
	private int time;
	private int lives;
	private int ants;
	private int spiders;
	private int food;
	private int flags;
	private int tempHealth;
	private int gameWorldHeight = 1000;
	private int gameWorldWidth = 1000;
	private Random ran;
	private ArrayList <GameObject> theWorldArray; 
	
	
	
	
	

	//Initiate the game and all the values of objects we created.
	public void init()
	{
	 time = 0;
	 lives = 3;
	 ants = 1;
	 flags = 4;
	 spiders = 2;
	 food = 2;
	 gameWorldHeight = 1000;
	 gameWorldWidth = 1000;
	 ran = new Random();
	 theWorldArray = new ArrayList<GameObject>();
	 
	 
	
	
	 theWorldArray.add(new Flag(new Point (0,0), ColorUtil.GREEN, 10,1));
	 theWorldArray.add(new Flag(new Point(300,300),ColorUtil.GREEN,10,2));
	 theWorldArray.add(new Flag(new Point (600,600), ColorUtil.GREEN, 10,3));
	 theWorldArray.add(new Flag(new Point(900,900),ColorUtil.GREEN,10,4));
	 theWorldArray.add(new Ant(new Point(0,0), ColorUtil.LTGRAY,90, 50, 50, 100, 5));
	 theWorldArray.add(new Spider(new Point(ran.nextInt(1000),ran.nextInt(1000)), ColorUtil.MAGENTA,ran.nextInt(359), 15+ran.nextInt(45), 20, 0, 0));
	 theWorldArray.add(new Spider(new Point(ran.nextInt(1000),ran.nextInt(1000)), ColorUtil.MAGENTA,ran.nextInt(359), 15+ran.nextInt(45), 20, 0, 0));
	 theWorldArray.add(new FoodStation(new Point(ran.nextInt(1000),ran.nextInt(1000)), ColorUtil.BLUE, 10 +ran.nextInt(40) ,100));
	 theWorldArray.add(new FoodStation(new Point(ran.nextInt(1000),ran.nextInt(1000)),ColorUtil.BLUE,10 + ran.nextInt(40),100));
	
	 

	 
	}
	 
	
	 
	 
	
	//Speeds up the speed of ant by 10.  Max Speed is set so it cannot go any faster than that.
	public void accelerate()
	{
		
		for (int i=0; i<theWorldArray.size(); i++) 
		{ 
			if (theWorldArray.get(i) instanceof Ant) 
				{ 
					
					Ant aObj = (Ant)theWorldArray.get(i);
					
						
					if(aObj.getMaxSpeed() - aObj.getSpeed() >= 10 )
					{
						aObj.setSpeed(aObj.getSpeed() + 10);
						System.out.println("You have accelerated.");
					}
					else
					{
						System.out.println("You are at max speed!");
					}
						
					
				} 
		}
		
	}
	
	
	//Slows the ant down by 5.  Cannot go slower than 0 (Full Stop)
	public void brake()
	{
		
		
		for (int i=0; i<theWorldArray.size(); i++) 
		{ 
			if (theWorldArray.get(i) instanceof Ant) 
				{ 
					Ant aObj = (Ant)theWorldArray.get(i); 
					
					if(aObj.getSpeed() >= 5 )
					{
						aObj.setSpeed(aObj.getSpeed() - 5);
						System.out.println("You have slowed down.");
					}
					else
					{
						System.out.println("You are at a complete stop");
					}
				} 
		}
		
	}
	
	//Steers the Ant's heading by 5 in the negative side.
	public void steerLeft()
	{
		System.out.println("You have steered left.");
		
		for (int i=0; i<theWorldArray.size(); i++) 
		{ 
			if (theWorldArray.get(i) instanceof Ant) 
				{ 
					Ant aObj = (Ant)theWorldArray.get(i); 
					aObj.steer(-10);    
				} 
		}
	}
	//Steers the Ant's heading by 5 in the positive side.
	public void steerRight()
	{
		System.out.println("You have steered right.");
		
		for (int i=0; i<theWorldArray.size(); i++) 
		{ 
			if (theWorldArray.get(i) instanceof Ant) 
				{ 
					Ant aObj = (Ant)theWorldArray.get(i); 
					aObj.steer(10);    
				} 
		}
	}
	//"Pretends" to collide Ant with Spider.  Ant changes lighter red. Health is diminished. Speed is dependent on your health ratio to full health.
	//Lower health = lower speed
	public void collideSpider()
	{
		System.out.println("Ow! You have got attacked by a Spider and took damage");
		
		for (int i=0; i<theWorldArray.size(); i++) 
		{ 
			if (theWorldArray.get(i) instanceof Ant) 
				{ 
					Ant aObj = (Ant)theWorldArray.get(i); 
					aObj.setHealthLevel(aObj.getHealthLevel() - 35);
				
					aObj.setSpeed((int)(aObj.getSpeed() * (aObj.getHealthLevel()/100.0)));
					
					if (aObj.getHealthLevel() < 70)
					{	
						aObj.setColor(ColorUtil.rgb(255, 102, 102));
					}
					if (aObj.getHealthLevel() < 40)
					{	
						aObj.setColor(ColorUtil.rgb(255, 0, 0));
					}
					
					//Lose Life and Game Over condition check.  If Health or Speed equals 0, you lose a life.
					//Add in new Ant with stats resetted
					//If all lives are gone: Game Over.
					if (aObj.getHealthLevel() <= 0 || aObj.getFoodLevel() <= 0)
					{
						if (lives >= 1)
						{
							lives -= 1;
							System.out.println("You lost a life.  Remaining lives: " +lives);
							theWorldArray.remove(i);
							theWorldArray.add(new Ant(new Point(0,0), ColorUtil.LTGRAY,90, 50, 50, 100, 5));
						}
						if (lives == 0)
						{
							System.out.println("You died. Game Over");
						}
					}
				} 
		}
	}
	
	//"Pretends" to collide Ant with Spider.  Ant changes lighter red. Health is replenished dependent on the capacity of food station size.
	//Food Station is destroyed a new one will randomly spawn.
	public void collideFood()
	{
		System.out.println("Yay. You found food and restored some health!");
		for (int i=0; i<theWorldArray.size(); i++) 
		{ 
			
			
			if (theWorldArray.get(i) instanceof FoodStation) 
			{
				FoodStation fsObj = (FoodStation)theWorldArray.get(i); 
				tempHealth = fsObj.getCapacity();
				theWorldArray.remove(i);
				theWorldArray.add(new FoodStation(new Point(ran.nextInt(1000),ran.nextInt(1000)),ColorUtil.BLUE,10 + ran.nextInt(40),100));
			}
			
			if (theWorldArray.get(i) instanceof Ant) 
				{ 
					Ant aObj = (Ant)theWorldArray.get(i); 
					if(aObj.getHealthLevel() + tempHealth <= 100)
					{
						aObj.setHealthLevel(aObj.getHealthLevel() + tempHealth);
					}
					if(aObj.getHealthLevel() + tempHealth >= 100)
					{
						aObj.setHealthLevel(100);
					}
					if (aObj.getHealthLevel() > 70)
					{	
						aObj.setColor(ColorUtil.rgb(192, 192, 192));
					}
					if (aObj.getHealthLevel() < 70)
					{	
						aObj.setColor(ColorUtil.rgb(255, 102, 102));
					}
					if (aObj.getHealthLevel() < 40)
					{	
						aObj.setColor(ColorUtil.rgb(255, 0, 0));
					}
				} 
			
		}
	}
	//keeps track of the flag and the sequence in order.  You only advance if they are in the correct numerical order
	public void collideFlag(int flagNum)
	{
		
		for (int i=0; i<theWorldArray.size(); i++) 
		{ 
			if (theWorldArray.get(i) instanceof Ant) 
				{   
					
					Ant aObj = (Ant)theWorldArray.get(i); 
					
					if(flagNum - aObj.getLastFlagReached() == 0)
					{
						System.out.println("Sorry, you currently just reached this flag");
					
					}
					if(flagNum - aObj.getLastFlagReached() == 1)
					{
						
						if(flagNum == aObj.getWinFlag())
						{
							System.out.println("YOU WIN! Total Time: " +time +" seconds.");
							break;
						}
						aObj.setLastFlagReached(aObj.getLastFlagReached() +1);
						System.out.println("Yay. You reached the next flag");
					
					}
					if(flagNum - aObj.getLastFlagReached() > 1)
					{
						
						System.out.println("Sorry, you must reach flags in correct order");
					
					}
					
					
				} 
		}
	}
	//Move time forward, move method is called on Ant and Spider.  Deplete foodlevel by foodconsumption rate.  Check to see if 0 conditions are met. lose a life.
	public void addTime()
	{
		System.out.println("Time has moved forward 1 second.");
		time += 1;
		
		for (int i=0; i<theWorldArray.size(); i++) 
		{ 
			//Each second time moves forward, Spider objects advance as well according to their speed and heading. Spider will have random heading set
			if (theWorldArray.get(i) instanceof Spider) 
			{
				
				Spider sObj = (Spider)theWorldArray.get(i);
				sObj.setHeading(ran.nextInt(359));
				sObj.move();
			
			}
			
			if (theWorldArray.get(i) instanceof Ant) 
			{
				
				Ant aObj = (Ant)theWorldArray.get(i);
				//Subtract the food level of each time the game ticks.
				aObj.setFoodLevel(aObj.getFoodLevel() - aObj.getFoodConsumptionRate());
		
				//Lose Life and Game Over condition check.  If Health or Speed equals 0, you lose a life.  If all lives are gone: Game Over.
				if (aObj.getHealthLevel() <= 0 || aObj.getFoodLevel() <= 0)
				{
					if (lives >= 1)
					{
						lives -= 1;
						System.out.println("You lost a life.  Remaining lives: " +lives);
						theWorldArray.remove(i);
						theWorldArray.add(new Ant(new Point(0,0), ColorUtil.LTGRAY,90, 50, 50, 100, 5));	
					}
					if (lives == 0)
					{
						System.out.println("You died. Game Over");
						break;
					}
			
				}
				//ant moves
				aObj.move();
				
			}
		}
	}
	//shows all the information and where each object is on the map.
	public void map()
	{
		System.out.println("Displaying map...");
		for (int i=0; i<theWorldArray.size(); i++) 
		{ 
			if (theWorldArray.get(i) instanceof Flag) 
				{ 
					Flag fObj = (Flag)theWorldArray.get(i); 
					System.out.println("Flag: loc = (" +fObj.getX() +"," +fObj.getY()+") size = " +fObj.getSize() + " seqNum = " +fObj.getSequenceNumber());
					
					
				} 
			if (theWorldArray.get(i) instanceof Ant) 
			{ 
				Ant aObj = (Ant)theWorldArray.get(i);  
				System.out.println("Ant: loc = (" +aObj.getX() +"," +aObj.getY()+") "+ aObj.toString() + " heading = "+aObj.getHeading() + " speed = " +aObj.getSpeed() +" size= " + aObj.getSize() + " maxSpeed = " + aObj.getMaxSpeed() + " foodConsumptionRate = " + aObj.getFoodConsumptionRate()); 
				
			} 
			if (theWorldArray.get(i) instanceof Spider) 
			{ 
				Spider sObj = (Spider)theWorldArray.get(i); 
				System.out.println("Spider: loc = (" +sObj.getX() +"," +sObj.getY()+") "+ sObj.toString() + " heading = " +sObj.getHeading() + " speed = " +sObj.getSpeed() +" size= " + sObj.getSize()); 
				
			} 
			if (theWorldArray.get(i) instanceof FoodStation) 
			{ 
				FoodStation fsObj = (FoodStation)theWorldArray.get(i); 
				System.out.println("FoodStation: loc = (" +fsObj.getX() +"," +fsObj.getY()+") size = " +fsObj.getSize() + " capacity = " +fsObj.getCapacity()); 
				
			} 
			
		}
		
	}
	//Shows current status of game stats and ant including time and lives left.
	public void display()
	{
;
		System.out.println("Lives Remaining: " +lives);
		System.out.println("Time Elapsed: " +time +" seconds");
		for (int i=0; i<theWorldArray.size(); i++) 
		{ 
			if (theWorldArray.get(i) instanceof Ant) 
				{ 
					Ant aObj = (Ant)theWorldArray.get(i); 
					System.out.println("Current Flag: Flag #" +aObj.getLastFlagReached());
					System.out.println("Current FoodLevel: " +aObj.getFoodLevel());
					System.out.println("Current HealthLevel: " +aObj.getHealthLevel()); 
				} 
		
		}
		
	}
	
	
    
    
}
