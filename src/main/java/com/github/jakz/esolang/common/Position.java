package com.github.jakz.esolang.common;

public class Position
{
	public int x,y;
	
	public Position()
	{
		x = 0;
		y = 0;
	}
	
	public Position(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void shift(Direction dir)
	{
		x += dir.x;
		y += dir.y;
	}
	
	public void reset()
	{
		x = 0;
		y = 0;
	}
	
	public void set(Position p)
	{
		this.x = p.x;
		this.y = p.y;
	}
	
	public void wrap(int w, int h)
	{
		/*if (x >= w)
			x %= w;
		else if (x < 0)
			x += w;
		
		if (y >= w)
			y %= h;
		else if (y < 0)
			y += h;*/
	}
}
