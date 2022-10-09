package com.mycompany.a1;
import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;

public class Flag extends Fixed 
{
	private int sequenceNumber;

	//assists in setting the values passed in.
	public Flag(Point loc, int clr, int size, int z) 
	{
		super(loc, clr, size, z);
		
		setSequenceNumber(z);
	}

	


	//sets the sequence number of the flag
	public void setSequenceNumber(int seq)
	{
		sequenceNumber = seq;
	}
	//returns the sequnce number of the flag
	public int getSequenceNumber()
	{
		return sequenceNumber;	
	}
	
	//meant to be overrode
	public void setColor()
	{
		
	}
	
	//meant to be overrode
	public void setLocation() 
	{
		
	}
	//assists in format of location.
	//public String toString()
	//{
		//String parentDesc = super.getLocation();
		//return parentDesc;
	//}
	


	
}
