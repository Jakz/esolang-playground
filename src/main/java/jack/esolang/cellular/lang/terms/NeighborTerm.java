package jack.esolang.cellular.lang.terms;

import jack.esolang.cellular.*;

public class NeighborTerm implements Term<Type>
{
	int dir;
	
	public NeighborTerm(int dir)
	{
		this.dir = dir;
	}
	
	public Type getValue(Automaton automaton, Cell cell)
	{
		Cell c = automaton.get(cell.x+Constants.dirs[dir][0], cell.y+Constants.dirs[dir][1]);
		
		if (c != null)
			return c.type;
		else
			return null;
	}
	
	public void solveReferences(Automaton a) {}
	
	public String toString()
	{
		return Constants.dirsName[dir];
	}
}
