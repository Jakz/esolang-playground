package com.github.jakz.esolang.source;

import com.github.jakz.esolang.common.*;

public class Code2D<T> implements Code<T>
{
	private T[][] code;
	private Position pc;
	private Direction dir;
	private boolean finished;
	
	public Code2D(int width, int height)
	{
		code = (T[][])new Object[width][height];
		pc = new Position();
		dir = Direction.RIGHT;
	}
	
	public Code2D(T[][] code)
	{
		this.code = code;
		pc = new Position();
		dir = Direction.RIGHT;
	}
	
	public void set(int i, int j, T op)
	{
		code[i][j] = op;
	}
	
	public int size()
	{
		return code.length;
	}

	public T get(int i, int j)
	{
		return code[i][j];
	}
	
	public T get()
	{
		return get(pc.x,pc.y);
	}
	
	public void resetPC()
	{
		pc.reset();
		dir = Direction.RIGHT;
	}
	
	public void incrPC()
	{
		pc.shift(dir);
		pc.wrap(code.length, code[0].length);
	}
	
	public void setDirection(Direction d)
	{
		this.dir = d;
	}
	
	public Direction direction()
	{
		return dir;
	}
	
	public void setPC(Position p)
	{
		pc.set(p);
	}
	
	public Position pc()
	{
		return pc;
	}
	
	public boolean finished()
	{
		return finished;
	}
	
	public void finish()
	{
		finished = true;
	}
	
	public String toString()
	{
		String s = "";
		
		for (int i = 0; i < code.length; ++i)
		{
			for (int j = 0; j < code[0].length; ++j)
			{
				s += code[i][j].toString();
			}
			s += "\n";
		}
		
		return s;
	}
}
