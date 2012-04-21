package jack.esolang.cellular.rules;

import jack.esolang.cellular.*;

public class Rule
{
	Type type;
	Condition condition;
	
	public Rule(Type type, Condition condition)
	{
		this.type = type;
		this.condition = condition;
	}
	
	public boolean applyOnCell(Cell cell)
	{
		if (condition.evaluate(cell))
		{
			cell.nextType = type;
			return true;
		}
		
		return false;
	}
	
	public void solveReferences()
	{
		condition.solveReferences();
	}
}
