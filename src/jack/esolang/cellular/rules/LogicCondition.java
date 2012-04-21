package jack.esolang.cellular.rules;

import jack.esolang.cellular.Cell;

public class LogicCondition implements Condition
{
	public static enum Op
	{
		AND, OR
	}
	
	Op op;
	Condition[] conds;
	
	public LogicCondition(Op op, Condition... conds)
	{
		this.conds = conds;
		this.op = op;
	}
	
	public boolean evaluate(Cell cell)
	{
		switch (op)
		{
			case AND:
			{
				for (Condition c : conds)
					if (!c.evaluate(cell))
						return false;
				
				return true;
			}
			case OR:
			{
				for (Condition c : conds)
					if (c.evaluate(cell))
						return true;
				
				return false;
			}
			default: return false;
		}
	}
	
	public void solveReferences()
	{
		for (Condition c : conds)
			c.solveReferences();
	}
}
