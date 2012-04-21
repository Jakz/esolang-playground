package jack.esolang.cellular;

import java.util.*;

public class Automaton
{
	Cell[][] cells;
	HashMap<String, Type> types;
	int w;
	int h;
	
	private static Automaton current;
	
	public static Automaton current()
	{
		return current;
	}
	
	Automaton(int w, int h)
	{
		this.w = w;
		this.h = h;
		cells = new Cell[w][h];
		
		for (int i = 0; i < w; ++i)
			for (int j = 0; j < h; ++j)
			{
				cells[i][j] = new Cell(null, i, j);
			}
		
		types = new HashMap<String, Type>();
		
		Automaton.current = this;
	}
	
	public void addType(Type type)
	{
		types.put(type.name, type);
	}
	
	public Type getType(String name)
	{
		return types.get(name);
	}
	
	public void reset(Type type)
	{
		for (int i = 0; i < w; ++i)
			for (int j = 0; j < h; ++j)
			{
				cells[i][j].type = type;
			}
	}
	
	public void set(Type type, int i, int j)
	{
		cells[i][j].type = type;
	}
	
	public Cell get(int x, int y)
	{
		if (x < 0 || y < 0 || x >= w | y >= h)
			return null;
		else
			return cells[x][y];
	}
	
	public void update()
	{
		for (int i = 0; i < w; ++i)
			for (int j = 0; j < h; ++j)
			{
				cells[i][j].type.update(cells[i][j]);
			}
		
		for (int i = 0; i < w; ++i)
			for (int j = 0; j < h; ++j)
			{
				cells[i][j].update();
			}
	}
}
