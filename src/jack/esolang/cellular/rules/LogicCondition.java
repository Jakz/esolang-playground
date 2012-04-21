package jack.esolang.cellular.rules;

import jack.esolang.cellular.Cell;

public class LogicCondition implements Condition
{
	public static enum Op
	{
		AND, OR
	}
	
	Op op;
	Condition c1, c2;
	
	public LogicCondition(Condition c1, Condition c2, Op op)
	{
		this.c1 = c1;
		this.c2 = c2;
		this.op = op;
	}
	
	public boolean evaluate(Cell cell)
	{
		switch (op)
		{
			case AND: return c1.evaluate(cell) && c2.evaluate(cell);
			case OR: return c1.evaluate(cell) || c2.evaluate(cell);
			default: return false;
		}
	}
}
