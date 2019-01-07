package com.github.jakz.esolang.cellular.lang.terms;

import com.github.jakz.esolang.cellular.*;

public class NeighborCountTerm implements Term<Integer>
{
	Category type;
	
	public NeighborCountTerm(Category type)
	{
		this.type = type;
	}
	
	public Integer getValue(Automaton automaton, Cell cell)
	{
		int c = 0;
		for (int i = 0; i < Constants.DIRECTIONS; ++i)
		{
			int nx = cell.x+Constants.dirs[i][0], ny = cell.y+Constants.dirs[i][1];
			Cell n = automaton.get(nx, ny);
			if (n != null && n.type == type)
				++c;
		}
		
		return c;
	}
	
	public void solveReferences(Automaton a)
	{
		if (type instanceof TypePlaceholder)
		{
			this.type = a.getType(type.name);
		}
	}
	
	public String toString()
	{
		return "neighbors("+type.name+")";
	}
}
