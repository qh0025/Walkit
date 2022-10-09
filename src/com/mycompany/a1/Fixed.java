package com.mycompany.a1;
import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;

//assists in setting the passed in values into game object.
public abstract class Fixed extends GameObject
{
	public Fixed(Point loc, int clr, int size, int z)
	{
	 super.setSize(size);
	 super.setLocation(loc);
	 super.setColor(clr);
	}
}
