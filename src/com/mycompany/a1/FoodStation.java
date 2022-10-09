package com.mycompany.a1;

import com.codename1.charts.models.Point;


public class FoodStation extends Fixed 
{
	private int capacity;
	
	//assists in setting the values passed in.
	public FoodStation(Point loc, int clr, int size, int z) 
	{
		super(loc, clr, size, z);
		capacity = size;
		
	}
	//sets capacity of foodstation
	public void setCapacity(int newCapacity)
	{
	  	capacity = newCapacity;
	}
	//returns the capacity of the foodStation
	public int getCapacity()
	{
	  	return capacity;
	}


	
	
	
}
