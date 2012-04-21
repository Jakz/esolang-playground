package jack.esolang.cellular.rules;

import jack.esolang.cellular.Cell;

public class UnaryCondition implements Condition
{
	boolean value;
	Condition inner;
	
	UnaryCondition(boolean value)
	{
		this.value = value;
	}
	
	UnaryCondition(Condition inner)
	{
		this.inner = inner;
	}
	
	public boolean evaluate(Cell cell)
	{
		if (inner == null)
			return value;
		else
			return !inner.evaluate(cell);
	}
	
	public void solveReferences()
	{
		if (inner != null)
			inner.solveReferences();
	}
}
