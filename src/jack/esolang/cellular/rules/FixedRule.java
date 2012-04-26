package jack.esolang.cellular.rules;

import jack.esolang.cellular.*;

public class FixedRule implements Rule
{
	Type type;
	Condition condition;
	
	public FixedRule(Type type, Condition condition)
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

	public void solveReferences(Automaton a)
	{
		type = (Type)a.getType(type.name);
		condition.solveReferences(a);
	}
	
	public String toString()
	{
		return "becomes "+type.name+" when "+condition+"\n";
	}
}
