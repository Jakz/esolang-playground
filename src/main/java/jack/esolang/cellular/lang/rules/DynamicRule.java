package jack.esolang.cellular.lang.rules;

import jack.esolang.cellular.*;

public class DynamicRule implements Rule
{
	int direction;
	Condition condition;
	
	public DynamicRule(int direction, Condition condition)
	{
		this.direction = direction;
		this.condition = condition;
	}
	
	public boolean applyOnCell(Automaton automaton, Cell cell)
	{
		if (condition.compile(automaton).test(cell))
		{
			Cell ncell = automaton.get(cell.x+Constants.dirs[direction][0], cell.y+Constants.dirs[direction][1]);
			if (ncell != null)
			{
				cell.nextType = ncell.type;
				return true;
			}
			else
				return false;
		}
		
		return false;
	}

	public void solveReferences(Automaton a)
	{
		condition.solveReferences(a);
	}
	
	public String toString()
	{
		return "becomes "+Constants.dirsName[direction]+" when "+condition+"\n";
	}
}
