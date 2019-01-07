package com.github.jakz.esolang.common;

public enum Direction
{
	UP(-1,0,"up"),
	RIGHT(0,1,"right"),
	DOWN(1,0,"down"),
	LEFT(0,-1,"left");
	
	public final int x, y;
	public final String name;
	
	Direction(int x, int y, String name)
	{
		this.x = x;
		this.y = y;
		this.name = name;
	}
}
