package jack.esolang.cellular.rules;

import jack.esolang.cellular.*;

public class BinaryCondition implements Condition
{
	public static enum Op
	{
		AND, OR
	}
	
	Op op;
	Condition[] conds;
	
	public BinaryCondition(Op op, Condition... conds)
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
	
	public void solveReferences(Automaton a)
	{
		for (Condition c : conds)
			c.solveReferences(a);
	}
	
	public String toString()
	{
		String s = "(";
		
		for (int i = 0; i < conds.length; ++i)
		{
			s += conds[i].toString();
			
			if (i < conds.length - 1)
				s+= op == Op.AND ? " && " : " || ";
		}
		
		s += ")";
		
		return s;
	}
}
