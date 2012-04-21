package jack.esolang.cellular.rules.terms;

import jack.esolang.cellular.*;

public class NeighborTerm implements Term<Integer>
{
	Type type;
	
	public NeighborTerm(Type type)
	{
		this.type = type;
	}
	
	public Integer getValue(Cell cell)
	{
		int c = 0;
		Automaton automaton = Automaton.current();
		for (int i = 0; i < Constants.DIRECTIONS; ++i)
		{
			int nx = cell.x+Constants.dirs[i][0], ny = cell.y+Constants.dirs[i][1];
			Cell n = automaton.get(nx, ny);
			if (n != null && n.type == type)
				++c;
		}
		
		return c;
	}
}
