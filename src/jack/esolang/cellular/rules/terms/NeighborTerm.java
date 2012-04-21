package jack.esolang.cellular.rules.terms;

import jack.esolang.cellular.*;

public class NeighborTerm implements Term<Type>
{
	int dir;
	
	public NeighborTerm(int dir)
	{
		this.dir = dir;
	}
	
	public Type getValue(Cell cell)
	{
		Cell c = Automaton.current().get(cell.x+Constants.dirs[dir][0], cell.y+Constants.dirs[dir][1]);
		
		return c.type;
	}
	
	public void solveReferences() {}
}
